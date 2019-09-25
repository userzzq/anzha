(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerCtrl]);

  function WorkerCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerCtrl destroy...');
    });

    //excel导出功能
    $scope.excelAction = UtilsService.getDataServer() + '/admin/worker/exportExcel?token=' + UtilsService.getToken();
    $scope.exportExcel = function() {
      document.getElementById('worker-excel-form').submit();
    };

    //=====================================================

    $scope.tbWorker = {};

    $scope.page = {
      pageNumber: 1,
      pageSize: 10
    };

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
        '/admin/worker/queryAll',
        {
          page: $scope.page
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

    $scope.changeEnable = function(worker, status) {
      DialogService.showConfirm('是否更改：' + worker.name + '-' + worker.phone + '的状态？', function() {
        var url = status == 'y' ? '/admin/worker/enable' : '/admin/worker/disable';
        DialogService.showWait('处理中，请稍候...');
        MyDataService.send(
          url,
          {
            tbWorker: worker
          },
          function(data) {
            DialogService.hideWait();
            if (data.success) {
              $scope.query();
              return;
            }
            DialogService.showAlert(data.message);
          }
        );
      });
    };

    $scope.queryWorker = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        '/admin/worker/queryAll',
        {
          page: $scope.page,
          tbWorker: $scope.tbWorker
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
  }
})();
