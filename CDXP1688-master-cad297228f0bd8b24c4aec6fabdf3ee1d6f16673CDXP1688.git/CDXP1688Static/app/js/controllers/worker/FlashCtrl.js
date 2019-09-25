(function () {
  var ctrls = angular.module(MyAppConfig.controllers);

  ctrls.controller('WorkerFlashCtrl', ['$scope', '$log', 'UtilsService', 'MyDataService', WorkerFlashCtrl]);

  function WorkerFlashCtrl($scope, $log, UtilsService, MyDataService) {
    $log.debug('WorkerFlashCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerFlashCtrl destroy...');
    });

    MyDataService.send('/worker/queryWorker', {}, function (data) {
      if (data.datas && data.datas.worker) {
        UtilsService.toPage('/worker/main');
      } else {
        UtilsService.toPage('/worker/index');
      }
    });

  }
})();