(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('SfbkCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', SfbkCtrl]);

  function SfbkCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('SfbkCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('SfbkCtrl destroy...');
    });

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
        '/adminpayrecode/queryWorker',
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



    $scope.queryWorker = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        '/adminpayrecode/queryWorker',
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

    $scope.dakuan=function(d){
      DialogService.showCustom('templates/dkbox.html', d,function(){
        $scope.query();
      });
    };

    $scope.cxdkxxbox = function(d) {
      DialogService.showCustom('templates/cxdkxxbox.html', d);
    };
  }
})();
