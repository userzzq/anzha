(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserXGDLMMCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserXGDLMMCtrl]);

  function UserXGDLMMCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserXGDLMMCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserXGDLMMCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
    $scope.queryUserInfo = function() {
      MyDataService.send('/user/queryUser', {}, function(data) {
        if (data.datas && data.datas.user) {
          $scope.user = data.datas.user;
          return;
        }
        DialogService.showAlert('需要登录', function() {
          UtilsService.toPage('/main');
        });
      });
    };

    $scope.queryUserInfo();

  }
})();
