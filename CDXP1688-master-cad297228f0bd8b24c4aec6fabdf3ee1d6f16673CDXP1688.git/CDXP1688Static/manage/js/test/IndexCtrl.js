(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('TestIndexCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', TestIndexCtrl]);

  function TestIndexCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('TestIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestIndexCtrl destroy...');
    });

    $scope.showInfo = function (info) {
      DialogService.showAlert(MyUtilService.trustAsHtml('<pre>' + MyUtilService.formatJson(info, true) + '</pre>'));
    };

    //授权测试
    $scope.authAdminUser = function () {
      DialogService.showWait('测试中，请稍候...');
      MyDataService.send('/auth/adminuser', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };
    $scope.page = {
      pageNumber: 1,
      pageSize: 10
    };



    //修改密码========================================
    $scope.tbAdminUser = {};

    $scope.modifyPwd = function () {
      $scope.tbAdminUser.password = MyUtilService.md5($scope.tbAdminUser.password);
      DialogService.showWait('修改密码，请稍候...');
      MyDataService.send('/adminuser/modifyPwd', {
        tbAdminUser: $scope.tbAdminUser
      }, function (data) {
        DialogService.hideWait();
        $scope.tbAdminUser.password = '';
        $scope.showInfo(data);
      });
    };

    //worker查询
    $scope.tbWorker = {
      'isEnable': 'y',
      'phone': '736',
      'name': '谭'
    };

    $scope.queryWorker = function () {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send('/admin/worker/queryAll', {
        page: $scope.page,
        tbWorker: $scope.tbWorker
      }, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    //UserFixInfo查询
    $scope.tbUserFixInfo = {
      'phone': '1',
      'fixtype': ''
    };
    $scope.quyerUserFixInfo = function () {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send('/admin/userfixinfo/queryAll', {
        page: $scope.page,
        tbUserFixInfo: $scope.tbUserFixInfo
      }, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

  }
})();