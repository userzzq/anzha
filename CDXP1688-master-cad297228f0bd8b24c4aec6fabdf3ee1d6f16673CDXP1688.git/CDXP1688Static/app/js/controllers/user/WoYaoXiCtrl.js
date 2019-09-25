(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WoYaoXiCtrl', ['$scope', '$log', '$timeout', 'UtilsService', 'MyDataService', 'DialogService', WoYaoXiCtrl]);

  function WoYaoXiCtrl($scope, $log, $timeout, UtilsService, MyDataService, DialogService) {
    $log.debug('WoYaoXiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WoYaoXiCtrl destroy...');
    });

    var locInfo = UtilsService.getLocation();

    $scope.tbUserFixInfo = {
      lat: locInfo.lat,
      lng: locInfo.lng,
      address: locInfo.address
    };

    $log.debug($scope.tbUserFixInfo);

    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };

    //图片处理=====================================================
    $scope.upimg = 'images/sctp.png';
    var fileEle = null;
    $scope.selectFile = function($event) {
      $log.debug($event.target);
      $event.target.previousElementSibling.click();
    };

    $scope.changeFile = function(ele) {
      $log.debug(ele);
      $timeout(function() {
        $scope.upfile = ele.value;
        if (ele.value) {
          fileEle = ele;
          showImg(ele.files[0]);
        } else {
          fileEle = null;
          $scope.upimg = 'images/sctp.png';
        }
      }, 1);
    };

    //选择图片，马上预览
    function showImg(file) {
      var reader = new FileReader();
      //读取文件过程方法
      reader.onloadstart = function(e) {
        $log.debug('开始读取....');
      };
      reader.onprogress = function(e) {
        $log.debug('正在读取中....');
      };
      reader.onabort = function(e) {
        $log.debug('中断读取....');
      };
      reader.onerror = function(e) {
        $log.debug('读取异常....');
      };
      reader.onload = function(e) {
        $log.debug('成功读取....');
        $timeout(function() {
          $scope.upimg = e.target.result;
        }, 1);
      };
      reader.readAsDataURL(file);
    }

    //下单==========================================================================
    $scope.save = function() {
      DialogService.showWait('数据提交中，请稍候...');
      var files = {
        files: []
      };
      if (fileEle) {
        var file = fileEle.files[0];
        $log.debug('上传文件对象：', file);
        files.files.push(file);
      }

      MyDataService.sendFile(
        '/userfixinfo/wash',
        files,
        {
          tbUserFixInfo: $scope.tbUserFixInfo
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.tbUserFixInfo = {
              lat: locInfo.lat,
              lng: locInfo.lng,
              address: locInfo.address
            };
            $scope.upimg = 'images/sctp.png';
            fileEle = null;
            DialogService.showAlert(data.message, function() {
              if (data.success) {
                DialogService.hideCustom();
                UtilsService.toPage('/user/weixiudingdan');
                return;
              }
            });
          } else {
            DialogService.showAlert(data.message);
          }
        }
      );
    };
  }
})();
