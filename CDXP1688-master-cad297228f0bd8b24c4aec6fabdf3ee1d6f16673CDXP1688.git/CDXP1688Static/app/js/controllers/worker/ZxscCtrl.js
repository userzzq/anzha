(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerZxscCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerZxscCtrl]);

  function WorkerZxscCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerZxscCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerZxscCtrl destroy...');
    });

    $scope.fanhui = function () {
      UtilsService.toPage('/worker/main', null, 'menu2');
    };
  }
})();