(function () {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestDataServiceCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'UtilsService', 'MyUtilService', TestDataServiceCtrl]);

  function TestDataServiceCtrl($scope, $log, DialogService, MyDataService, UtilsService, MyUtilService) {
    $log.debug('TestDataServiceCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestDataServiceCtrl destroy...');
    });

    $scope.showInfo = function (info) {
      DialogService.showAlert(MyUtilService.trustAsHtml('<pre>' + MyUtilService.formatJson(info, true) + '</pre>'));
    };

    $scope.test = function () {
      DialogService.showWait('测试中...');
      MyDataService.send('/', {
        echo: parseInt(Math.random() * 100000)
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
        $log.debug(data);
      });
    };

    $scope.formdata = {
      phone: '13618413987'
    };

    $scope.sendPhoneCode = function () {
      DialogService.showWait('测试中...');
      MyDataService.send('/util/sendPhoneCode', $scope.formdata, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
        $log.debug(data);
      });
    };

    $scope.queryWorker = function () {
      DialogService.showWait('测试中...');
      MyDataService.send('/worker/queryWorker', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.workerLogout = function () {
      DialogService.showWait('测试中...');
      MyDataService.send('/worker/logout', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.authWorker = function () {
      DialogService.showWait('测试中...');
      MyDataService.send('/auth/worker', {}, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

    $scope.token = UtilsService.getToken();
    $scope.dataServer = UtilsService.getDataServer();
    $scope.imageCode = UtilsService.getImageCode();

    $scope.changeImage = function () {
      UtilsService.changeImageCode();
    };

    //用户下单查询
    $scope.page = {
      pageNumber: 1,
      pageSize: 3
    };

    $scope.tbUserFixInfo = {};

    $scope.quyerUserFixInfo = function () {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send('/userfixinfo/query', {
        page: $scope.page,
        tbUserFixInfo: $scope.tbUserFixInfo
      }, function (data) {
        DialogService.hideWait();
        $scope.showInfo(data);
      });
    };

  }
})();