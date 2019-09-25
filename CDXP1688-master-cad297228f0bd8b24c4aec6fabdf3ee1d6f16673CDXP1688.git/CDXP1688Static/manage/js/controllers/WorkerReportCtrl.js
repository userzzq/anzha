(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerReportCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerReportCtrl]);

  function WorkerReportCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerReportCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerReportCtrl destroy...');
    });

    //excel导出功能
    $scope.excelAction = UtilsService.getDataServer() + '/admin/workerReport/exportExcel?token=' + UtilsService.getToken();
    $scope.exportExcel = function() {
      document.getElementById('report-excel-form').submit();
    };

    //=====================================================

    $scope.page = {
      pageNumber: 1,
      pageSize: 10
    };

    $scope.tbWorkerReport = {};
    //分页跳转
    $scope.toPage = function(pn) {
      //不能超出范围
      if (pn <= 0 || pn > $scope.page.pageCount || pn == $scope.page.pageNumber) {
        return;
      }
      //分页查询
      $scope.page.pageNumber = pn;
      $scope.query();
    };

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候...');
      MyDataService.send(
        '/admin/workerReport/queryAll',
        {
          page: $scope.page,
          tbWorkerReport: $scope.tbWorkerReport
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

    $scope.query();

    $scope.showPeople = function(worker) {
      DialogService.showCustom('templates/workerReportPeople.html', {
        peoples: worker.peoples
      });
    };
  }
})();
