(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserCtrl]);

  function UserCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserCtrl destroy...');
    });

    //excel导出功能
    $scope.excelAction = UtilsService.getDataServer() + '/admin/user/exportExcel?token=' + UtilsService.getToken();
    $scope.exportExcel = function() {
      document.getElementById('user-excel-form').submit();
    };

    //=====================================================
    $scope.tbUser = {};

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
        '/admin/user/queryAll',
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

    $scope.changeEnable = function(user, status) {
      DialogService.showConfirm('是否更改：' + user.name + '-' + user.phone + '的状态？', function() {
        var url = status == 'y' ? '/admin/user/enable' : '/admin/user/disable';
        DialogService.showWait('处理中，请稍候...');
        MyDataService.send(
          url,
          {
            tbUser: user
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

    $scope.queryUser = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        '/admin/user/queryAll',
        {
          page: $scope.page,
          tbUser: $scope.tbUser
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
