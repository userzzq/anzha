(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('IndexCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', IndexCtrl]);

  function IndexCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('IndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('IndexCtrl destroy...');
    });

    $scope.tbAdminUser = {};

    $scope.login = function () {
      if (!$scope.tbAdminUser.username) {
        DialogService.showAlert('登录名必须填写');
        return;
      }
      if (!$scope.tbAdminUser.password) {
        DialogService.showAlert('密码必须填写');
        return;
      }
      $scope.tbAdminUser.password = MyUtilService.md5($scope.tbAdminUser.password);
      DialogService.showWait('登录校验中，请稍候...');
      MyDataService.send('/adminuser/login', {
        tbAdminUser: $scope.tbAdminUser
      }, function (data) {
        $scope.tbAdminUser.password = '';
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            UtilsService.toPage('/main');
          }
        });
      });

    };

  }
})();