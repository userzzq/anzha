(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('ErrorCtrl', ['$scope', '$log', 'MyDataService', 'MyUtilService', ErrorCtrl]);

  function ErrorCtrl($scope, $log, MyDataService, MyUtilService) {
    $log.debug('ErrorCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('ErrorCtrl destroy...');
    });

    var errorInfo = MyDataService.loadLastError();
    errorInfo = errorInfo == '' ? {} : errorInfo;
    errorInfo.server = MyDataService.dataServer;
    $log.debug('errorInfo===>', errorInfo);

    $scope.errorInfo = MyUtilService.trustAsHtml('错误信息===>：<br>' + MyUtilService.formatJson(errorInfo, true));

  }
})();