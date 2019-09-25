(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerLxkfCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerLxkfCtrl]);

  function WorkerLxkfCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerLxkfCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerLxkfCtrl destroy...');
    });
    $scope.fanhui = function() {
      UtilsService.toPage('/worker/main', null, 'menu2');
    };
  }
})();
