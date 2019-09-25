(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerZhmmCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerZhmmCtrl]);

  function WorkerZhmmCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerZhmmCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerZhmmCtrl destroy...');
    });

    $scope.focus = {
      phone: false
    };

    $scope.model = {
      imageCode: '',
      phoneCode: '',
      password: ''
    };

    $scope.tbWorker = {};

    $scope.sendPhoneCode = function() {
      DialogService.showWait('发送手机验证中，请稍候...');
      MyDataService.send(
        '/util/sendFindPwd',
        {
          phone: $scope.tbWorker.phone,
          imageCode: $scope.model.imageCode
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message);
        }
      );
    };

    $scope.reg = function() {
      if (!$scope.tbWorker.phone) {
        DialogService.showAlert('请填写手机号码');
        return;
      }
      if (!$scope.tbWorker.password) {
        DialogService.showAlert('请填写新密码');
        return;
      }
      if (!$scope.model.password) {
        DialogService.showAlert('请重复一遍密码');
        return;
      }
      if ($scope.model.password != $scope.tbWorker.password) {
        DialogService.showAlert('密码不一致');
        return;
      }
      if (!$scope.model.phoneCode) {
        DialogService.showAlert('请填写手机验证码');
        return;
      }
      $scope.tbWorker.password = MyUtilService.md5($scope.tbWorker.password);
      DialogService.showWait('修改中，请稍候...');
      MyDataService.send(
        '/worker/modifyPwd',
        {
          tbWorker: $scope.tbWorker,
          phoneCode: $scope.model.phoneCode
        },
        function(data) {
          $scope.model.phoneCode='';
          $scope.tbWorker.password = '';
          $scope.model.password = '';
          DialogService.hideWait();
          DialogService.showAlert(data.message);
        }
      );
    };

    $scope.login = function() {
      UtilsService.toPage('/worker/index');
    };
  }
})();
