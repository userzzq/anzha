(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerXyCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerXyCtrl]);

  function WorkerXyCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerXyCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerXyCtrl destroy...');
    });
    
    $scope.fanhui=function(){
      UtilsService.toPage('/worker/reg');
    };
  }
})();