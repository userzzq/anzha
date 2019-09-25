(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerSmrzCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerSmrzCtrl]);

  function WorkerSmrzCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerSmrzCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerSmrzCtrl destroy...');
    });

    $scope.fanhui = function () {
      UtilsService.toPage('/worker/main');
    };
  }
})();