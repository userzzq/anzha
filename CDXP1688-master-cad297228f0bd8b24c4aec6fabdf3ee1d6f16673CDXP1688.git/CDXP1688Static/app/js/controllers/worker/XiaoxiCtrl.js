(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerXiaoxiCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerXiaoxiCtrl]);

  function WorkerXiaoxiCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerXiaoxiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerXiaoxiCtrl destroy...');
    });

    $scope.list = [{ title: '系统消息', info: '公告：很抱歉，此功能暂未开放，给大家带来多有不便，但不影响本平台的开发与使用，希望大家理解和配合！'}];
  }
})();
