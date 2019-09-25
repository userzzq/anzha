(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserCanKaoJiaCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserCanKaoJiaCtrl]);

  function UserCanKaoJiaCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserCanKaoJiaCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserCanKaoJiaCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
  }
})();
