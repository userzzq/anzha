(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('workerXgxxCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', workerXgxxCtrl]);

  function workerXgxxCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('workerXgxxCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('workerXgxxCtrl destroy...');
    });
    $scope.fanhui=function(){
      UtilsService.toPage('/worker/grxx');
    };
    

    $scope.queryWorker = function () {
      MyDataService.send('/worker/queryWorker', {}, function (data) {
        if (data.datas && data.datas.worker) {
          $scope.worker = data.datas.worker;
          return;
        }
        DialogService.showAlert('需要登录', function () {
          UtilsService.toPage('/worker/index');
        });
      });
    };
    $scope.queryWorker();
  }
})();