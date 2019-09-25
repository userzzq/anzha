(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerIndexCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerIndexCtrl]);

  function WorkerIndexCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerIndexCtrl destroy...');
    });

    $scope.focus = {
      phone: true
    };

    $scope.tbWorker = {};

    $scope.login = function() {
      if (!$scope.tbWorker.password) {
        DialogService.showAlert('密码必须填写');
        return;
      }
      $scope.tbWorker.password = MyUtilService.md5($scope.tbWorker.password);
      DialogService.showWait('登录校验中，请稍候...');
      MyDataService.send(
        '/worker/login',
        {
          tbWorker: $scope.tbWorker
        },
        function(data) {
          $scope.tbWorker.password = '';
          DialogService.hideWait();
          if (data.code == 520) {
            DialogService.showAlert('请联系壹路巴巴运营人员：郑总15507361688开通权限');
            return;
          }
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              UtilsService.toPage('/worker/main');
            }
          });
        }
      );
    };

    $scope.reg = function() {
      UtilsService.toPage('/worker/reg');
    };

    $scope.zhmm = function() {
      UtilsService.toPage('/worker/zhmm');
    };
  }
})();
