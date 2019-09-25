(function () {
  var ctrls = angular.module(MyAppConfig.controllers);

  ctrls.controller('UserAndroidApiCtrl', ['$scope', '$log', '$timeout', 'UtilsService', 'MyUtilService', UserAndroidApiCtrl]);

  function UserAndroidApiCtrl($scope, $log, $timeout, UtilsService, MyUtilService) {
    $log.debug('UserAndroidApiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserAndroidApiCtrl destroy...');
      window.removeEventListener('message', locationBack, false);
    });

    var fileEle = null;

    $scope.selectFile = function ($event) {
      alert($event.target.previousElementSibling);
      $event.target.previousElementSibling.click();
    };

    $scope.changeFile = function (ele) {
      $log.debug(ele);
      alert(ele);
      $timeout(function () {
        $scope.upfile = ele.value;
        if (ele.value) {
          fileEle = ele;
          showImg(ele.files[0]);
        } else {
          fileEle = null;
          $scope.upimg = '';
        }
      }, 1);
    };

    //选择图片，马上预览
    function showImg(file) {

      var reader = new FileReader();

      //读取文件过程方法
      reader.onloadstart = function (e) {
        $log.debug("开始读取....");
      };
      reader.onprogress = function (e) {
        $log.debug("正在读取中....");
      };
      reader.onabort = function (e) {
        $log.debug("中断读取....");
      };
      reader.onerror = function (e) {
        $log.debug("读取异常....");
      };
      reader.onload = function (e) {
        $log.debug("成功读取....");
        $timeout(function () {
          $scope.upimg = e.target.result;
        }, 1);
      };

      reader.readAsDataURL(file);
    }
    //==========================================================

    //地图=======================================================
    window.addEventListener('message', locationBack, false);

    function locationBack(event) {
      // 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
      var loc = event.data;
      if (loc && loc.module == 'locationPicker') { //防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
        $log.debug('locationPicker', loc);
        UtilsService.saveLocation(loc); //保存地址
      } else if (loc) {
        $log.debug('location', loc);
        $timeout(function () {
          $scope.mapurl = UtilsService.getMapUrl(loc);
          UtilsService.saveLocation(loc); //保存地址
        }, 1);
      }
    }

    var count = 0;
    //android终端
    //var isAndroid = navigator.userAgent.indexOf('Android') > -1 || navigator.userAgent.indexOf('Adr') > -1;
    if (window.andoridNative) {
      //android接口测试
      alert("andoridNative");
      andoridNative.showToast('js调用android');
      window.loactionCallBack = function (loc) {
        try {
          alert(JSON.stringify(loc));
          if (count == 0) {
            count = 1;
            $timeout(function () {
              if (loc.addr) {
                var aloc = {
                  province: '',
                  city: '',
                  addr: loc.addr,
                  lat: loc.lat,
                  lng: loc.lng
                };
                alert(JSON.stringify(aloc));
                $scope.mapurl = UtilsService.getMapUrl(aloc);
                alert($scope.mapurl);
                UtilsService.saveLocation(aloc); //保存地址
              } else {
                //没有loc信息就转到html5获取位置
                $scope.geoUrl = UtilsService.getGeoUrl();
              }
            }, 1);
          } else {
            $log.debug(loc);
          }
          return 'ok!';
        } catch (ex) {
          return 'error!' + JSON.stringify(ex);
        }
      };
    } else {
      $scope.geoUrl = UtilsService.getGeoUrl();
    }

    //$scope.geoUrl = UtilsService.getGeoUrl();
    //地图=======================================================

    $scope.topage = function (page) {
      UtilsService.toPage(page);
    };
  }
})();