(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('CxdkxxboxCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', CxdkxxboxCtrl]);

  function CxdkxxboxCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('CxdkxxboxCtrl init...');

    $scope.closeMe = DialogService.hideCustom;
    $scope.worker=DialogService.getCustomData();
    $scope.tbPayRecode = {wid:$scope.worker.wid};
    $scope.page = {
      pageNumber: 1,
      pageSize: 5
    };

    //分页跳转
    $scope.toPage = function(pn) {
      //不能超出范围
      if (pn <= 0 || pn > $scope.page.pageCount || pn == $scope.page.pageNumber) {
        return;
      }
      //分页查询
      $scope.page.pageNumber = pn;
      $scope.cxdkxxquery();
    };
    $scope.cxdkxxquery = function() {
      DialogService.showWait('数据查询中。。。');
      MyDataService.send(
        '/adminpayrecode/queryByWorker',
        {
          page: $scope.page,
          tbPayRecode:$scope.tbPayRecode
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.list = data.datas.list;
            $scope.page = data.datas.page;
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };
    $scope.cxdkxxquery();
  }
})();
