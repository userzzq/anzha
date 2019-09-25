(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserMainCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserMainCtrl]);

  function UserMainCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserMainCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserMainCtrl destroy...');
    });

    $scope.focus = {
      phone: true
    };

    $scope.tbUser = {};
    

    $scope.login = function () {
      if (!$scope.tbUser.password) {
        DialogService.showAlert('密码必须填写');
        return;
      }
      $scope.tbUser.password = MyUtilService.md5($scope.tbUser.password);
      DialogService.showWait('登录校验中，请稍候...');
      MyDataService.send('/user/login', {
        tbUser: $scope.tbUser
      }, function (data) {
        $scope.tbUser.password = '';
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            UtilsService.toPage('/user/index');
          }
        });
      });
    };

    $scope.zhuce = function () {
      UtilsService.toPage('/user/zhuce');
    };
    
    $scope.wjpwd = function () {
      UtilsService.toPage('/user/wjpwd');
    };
  }
})();