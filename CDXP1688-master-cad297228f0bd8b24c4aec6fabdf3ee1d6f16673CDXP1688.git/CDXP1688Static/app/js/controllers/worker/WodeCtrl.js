(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerWodeCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerWodeCtrl]);

  function WorkerWodeCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerWodeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerWodeCtrl destroy...');
    });
    $scope.zxsc = function() {
      UtilsService.toPage('/worker/zxsc');
    };

    $scope.wybb = function() {
      UtilsService.toPage('/worker/baobeiguanli');
    };
    $scope.wddk = function() {
      UtilsService.toPage('/worker/wodedakuan');
    };
    $scope.grxx = function() {
      UtilsService.toPage('/worker/grxx');
    };
    $scope.gdjc = function() {
      UtilsService.toPage('/worker/lxkf');
    };
    $scope.smrz = function() {
      UtilsService.toPage('/worker/smrz');
    };
    $scope.gdj = function() {
      DialogService.showAlert('更多精彩请敬请期待哦！');
    };
   
    $scope.wodedd = function() {
      UtilsService.toPage('/worker/wddingdan');
    };
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

    $scope.logout = function() {
      DialogService.showWait('安全退出中，请稍候...');
      MyDataService.send('/worker/logout', {}, function(data) {
        DialogService.hideWait();
        UtilsService.toPage('/worker/index');
      });
    };
  }
})();
