(function () {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestFileUploadCtrl', ['$scope', '$log', '$timeout', 'DialogService', 'MyDataService', 'MyUtilService', TestFileUploadCtrl]);

  function TestFileUploadCtrl($scope, $log, $timeout, DialogService, MyDataService, MyUtilService) {
    $log.debug('TestFileUploadCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestFileUploadCtrl destroy...');
    });

    $scope.showInfo = function (info) {
      DialogService.showAlert(MyUtilService.trustAsHtml('<pre>' + MyUtilService.formatJson(info, true) + '</pre>'));
    };

    var fileEle = null;

    $scope.selectFile = function ($event) {
      $event.target.previousElementSibling.click();
    };

    $scope.changeFile = function (ele) {
      $log.debug(ele);
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

    $scope.saveFile = function () {
      if (!fileEle) {
        return;
      }
      var file = fileEle.files[0];
      $log.debug('上传文件对象：', file);
      var files = {
        files: [file, file]
      };
      var senddata = {
        testEntity: {
          echo: 'echo测试',
          tbToken: {
            token: 'token测试',
            uid: 1
          }
        }
      };
      MyDataService.sendFile('/test/upload', files, senddata, function (data) {
        $scope.showInfo(data);
      });

    };

  }
})();