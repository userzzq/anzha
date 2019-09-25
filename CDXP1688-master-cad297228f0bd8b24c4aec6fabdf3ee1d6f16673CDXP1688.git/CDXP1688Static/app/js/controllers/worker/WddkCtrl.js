(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerWddkCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerWddkCtrl]);

  function WorkerWddkCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerWddkCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerWddkCtrl destroy...');
    });

    $scope.fanhui = function() {
      UtilsService.toPage('/worker/main', null, 'menu2');
    };

    $scope.list = [];

    $scope.page = {
      pageNumber: 1,
      pageSize: 7
    };
    $scope.ckgd = function() {
      if ($scope.page.pageNumber >= $scope.page.pageCount) {
        return;
      }
      $scope.page.pageNumber = $scope.page.pageNumber + 1;
      $scope.wddkquery();
    };
    $scope.requery = function() {
      $scope.list = [];
      $scope.page.pageNumber = 1;
      $scope.wddkquery();
    };
    $scope.wddkquery = function() {
      DialogService.showWait('数据查询中。。。');
      MyDataService.send(
        '/worker/queryPay',
        {
          page: $scope.page
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.list = $scope.list.concat(data.datas.list);
            $scope.page = data.datas.page;
            $scope.worker=data.datas.worker;
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };
    $scope.wddkquery();
  }
})();
