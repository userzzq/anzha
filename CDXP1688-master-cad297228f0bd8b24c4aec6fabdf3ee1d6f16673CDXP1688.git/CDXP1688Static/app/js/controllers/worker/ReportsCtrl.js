(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerReportsCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerReportsCtrl]);

  function WorkerReportsCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerReportsCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerReportsCtrl destroy...');
    });
    $scope.list = [];
    $scope.page = {
      pageNumber: 1,
      pageSize: 2
    };


  $scope.ckgd = function() {
    if ($scope.page.pageNumber >= $scope.page.pageCount) {
      return;
    }
    $scope.page.pageNumber = $scope.page.pageNumber + 1;
    $scope.query();
  };
  
    $scope.requery = function() {
      $scope.list = [];
      $scope.page.pageNumber = 1;
      $scope.query();
    };
    $scope.query = function () {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/workerReport/reports', {
        page: $scope.page
      }, function (data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.list = $scope.list.concat(data.datas.list);
          $scope.page = data.datas.page;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };

    $scope.query();
  }


})();