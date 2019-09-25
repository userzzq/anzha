(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerXiugaimmCtrl', ['$scope', '$log', 'DialogService', 'MyUtilService', 'MyDataService', WorkerXiugaimmCtrl]);

  function WorkerXiugaimmCtrl($scope, $log, DialogService, MyUtilService, MyDataService) {
    $log.debug('WorkerXiugaimmCtrl init...');

    $scope.closeMe = DialogService.hideCustom;

    $scope.tbAdminUser = {};
    $scope.model = {};

    $scope.xgmm = function() {
      if (!$scope.oldPwd) {
        DialogService.showAlert('请填写旧密码');
        return;
      }
      if (!$scope.tbAdminUser.password) {
        DialogService.showAlert('请填写新密码');
        return;
      }
      if (!$scope.model.password) {
        DialogService.showAlert('请重复一遍密码');
        return;
      }
      if ($scope.model.password != $scope.tbAdminUser.password) {
        DialogService.showAlert('密码不一致');
        return;
      }
      $scope.tbAdminUser.password = MyUtilService.md5($scope.tbAdminUser.password);
      DialogService.showWait('正在修改，请稍候...');
      MyDataService.send(
        '/adminuser/modifyPwd',
        {
          oldPwd: MyUtilService.md5($scope.oldPwd),
          tbAdminUser: $scope.tbAdminUser
        },
        function(data) {
          $scope.tbAdminUser.password = '';
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
            }
          });
        }
      );
    };
  }
})();
