(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('workerBaojiaCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', workerBaojiaCtrl]);

  function workerBaojiaCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('workerBaojiaCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('workerBaojiaCtrl destroy...');
    });

    $scope.closeMe = DialogService.hideCustom;
    var tbUserFixOrder = DialogService.getCustomData();
    $log.debug(tbUserFixOrder);
    $scope.tbFixOrderDetail = { price: tbUserFixOrder.price };
    var url = tbUserFixOrder.price ? '/workerfixinfo/modifyOrderPrice' : '/workerfixinfo/orderPrice';

    $scope.baocun = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        url,
        {
          tbFixOrderDetail: $scope.tbFixOrderDetail,
          // "tbUserFixOrder.ufoid":tbUserFixOrder.ufoid
          tbUserFixOrder: { ufoid: tbUserFixOrder.ufoid }
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
              return;
            }
          });
        }
      );
    };
  }
})();
