(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerWoyaojiedanCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerWoyaojiedanCtrl]);

  function WorkerWoyaojiedanCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerWoyaojiedanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerWoyaojiedanCtrl destroy...');
    });

    $scope.tbWorker = {};
    $scope.tbUserFixOrder = {};
    $scope.list = [];

    $scope.ksjd = function() {
      UtilsService.toPage('/worker/ksjd');
    };

    $('.carousel').carousel({ interval: 5000 });

    $scope.page = {
      pageNumber: 1,
      pageSize: 4
    };

    $scope.requery = function() {
      $scope.list = [];
      $scope.page.pageNumber = 1;
      $scope.query();
    };
    $scope.query = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        '/workerfixinfo/queryWorkerFixinfo',
        {
          page: $scope.page,
          tbWorker: $scope.tbWorker
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.list = $scope.list.concat(data.datas.list);
            $scope.page = data.datas.page;
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };
    $scope.ckgd = function() {
      if ($scope.page.pageNumber >= $scope.page.pageCount) {
        return;
      }
      $scope.page.pageNumber = $scope.page.pageNumber + 1;
      $scope.query();
    };

    $scope.ckxq = function(d) {
      localStorage.removeItem('order-detail');
      localStorage.setItem('order-detail', JSON.stringify(d));
      UtilsService.toPage('/worker/jiedan');
    };

    //==========================================================
    $scope.changeEnable = function(worker, status) {
      DialogService.showConfirm('是否更改：' + worker.name + '的接单状态？', function() {
        var url = status == 'y' ? '/worker/inwork' : '/worker/notinwork';
        DialogService.showWait('处理中，请稍候...');
        MyDataService.send(url, { tbWorker: worker }, function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.queryWorker();
            return;
          }
          $scope.requery();
        });
      });
    };
    $scope.queryWorker = function() {
      MyDataService.send('/worker/queryWorker', {}, function(data) {
        if (data.datas && data.datas.worker) {
          $scope.worker = data.datas.worker;
          $scope.requery();
          return;
        }
      });
    };

    $scope.queryWorker();
  }
})();
