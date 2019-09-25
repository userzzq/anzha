(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerGrxxsCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerGrxxsCtrl]);

  function WorkerGrxxsCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerGrxxsCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerGrxxsCtrl destroy...');
    });
    $scope.queryWorker = function() {
      MyDataService.send('/worker/queryWorker', {}, function(data) {
        if (data.datas && data.datas.worker) {
          $scope.worker = data.datas.worker;
          return;
        }
        DialogService.showAlert('需要登录', function() {
          UtilsService.toPage('/worker/index');
        });
      });
    };
    $scope.queryWorker();
    $scope.tjyhk = function() {
      UtilsService.toPage('/worker/tjyhk');
    };
    $scope.xgmm = function() {
      UtilsService.toPage('/worker/xgmm');
    };
    $scope.zwkf=function(){
      DialogService.showAlert('此功能暂未开放！');
    };
    // $scope.test=function(){
    //   location='https://huhuiyu.top';
    // };
  }
})();
