(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserHaoCaiDingDanCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserHaoCaiDingDanCtrl]);

  function UserHaoCaiDingDanCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserHaoCaiDingDanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserHaoCaiDingDanCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
  }
})();
