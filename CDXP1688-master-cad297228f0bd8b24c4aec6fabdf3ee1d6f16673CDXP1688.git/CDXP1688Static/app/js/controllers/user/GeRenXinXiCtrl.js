(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserReRenXinXiCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserReRenXinXiCtrl]);

  function UserReRenXinXiCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserReRenXinXiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserReRenXinXiCtrl destroy...');
    });

    $scope.tbUser = {};
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

    $scope.fanhui = function() {
      UtilsService.toPage('/user/wode');
    };
  }
})();
