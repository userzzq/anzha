(function () {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestIndexCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', TestIndexCtrl]);

  function TestIndexCtrl($scope, $log, DialogService, MyDataService, MyUtilService) {
    $log.debug('TestIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestIndexCtrl destroy...');
    });

    $scope.showInfo = function (info) {
      DialogService.showAlert(MyUtilService.trustAsHtml('<pre>' + MyUtilService.formatJson(info, true) + '</pre>'));
    };

    //用户相关==============================================================
    $scope.userLogin = function () {
      DialogService.showWait('登录测试');
      MyDataService.send('/user/login', {
        tbUser: {
          phone: '15973637383',
          password: MyUtilService.md5('user-pwd')
        }
      }, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.getUser = function () {
      DialogService.showWait('获取用户信息测试');
      MyDataService.send('/user/queryUser', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.userLogout = function () {
      DialogService.showWait('用户退出测试');
      MyDataService.send('/user/logout', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.userAuth = function () {
      DialogService.showWait('用户授权测试');
      MyDataService.send('/auth/user', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };





  }
})();