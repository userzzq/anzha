(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserXiaoXiCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserXiaoXiCtrl]);

  function UserXiaoXiCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserXiaoXiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserXiaoXiCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
  }
})();
