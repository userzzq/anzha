(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerTjyhkCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerTjyhkCtrl]);

  function WorkerTjyhkCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerTjyhkCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerTjyhkCtrl destroy...');
    });

    $scope.fanhui = function () {
      UtilsService.toPage('/worker/grxx');
    };

    $scope.shurumima = function () {
      DialogService.setTempTitle('添加银行卡');
      DialogService.showCustom('templates/worker/zfmima.html');
    };

  }
})();