(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('XiddCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', XiddCtrl]);

  function XiddCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('XiddCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('XiddCtrl destroy...');
    });

    //excel导出功能
    $scope.excelAction = UtilsService.getDataServer() + '/admin/userfixinfo/exportExcel?token=' + UtilsService.getToken();
    $scope.exportExcel = function() {
      document.getElementById('fix-excel-form').submit();
    };

    //=====================================================

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
        '/admin/userfixinfo/queryAll',
        {
          page: $scope.page,
          tbUserFixInfo: $scope.tbUserFixInfo
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

    $scope.tbUserFixInfo = {
      fixtype: ''
    };
    $scope.queryFixInfo = function(fixtype) {
      $scope.tbUserFixInfo.fixtype = fixtype;
      $scope.query();
    };

    $scope.djck = function(tbUserFixInfo) {
      DialogService.setTempTitle('查看图片');
      DialogService.showCustom('templates/cktp.html', {
        tbUserFixInfo: tbUserFixInfo
      });
    };
  }
})();
