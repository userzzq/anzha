(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserWoDeCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserWoDeCtrl]);

  function UserWoDeCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserWoDeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserWoDeCtrl destroy...');
    });

    $scope.queryUserInfo = function() {
      MyDataService.send('/user/queryUser', {}, function(data) {
        if (data.datas && data.datas.user) {
          $scope.user = data.datas.user;
          return;
        }
        DialogService.showAlert('需要登录', function() {
          UtilsService.toPage('/user/flash');
        });
      });
    };

    $scope.queryUserInfo();

    $scope.gerenxinxi = function() {
      UtilsService.toPage('/user/gerenxinxi');
    };

    $scope.lianxikefu = function() {
      UtilsService.toPage('/user/lxkf');
    };

    $scope.weixiudingdan = function() {
      UtilsService.toPage('/user/weixiudingdan');
    };

    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };

    $scope.gdjc = function() {
      DialogService.showAlert('更多精彩暂未开放，敬请期待吧！');
    };

    $scope.zwkf = function() {
      DialogService.showAlert('暂未开放，敬请期待！');
    };
    $scope.logout = function() {
      DialogService.showWait('安全退出中，请稍候...');
      MyDataService.send('/user/logout', {}, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
        UtilsService.toPage('/user/main');
      });
    };
  }
})();
