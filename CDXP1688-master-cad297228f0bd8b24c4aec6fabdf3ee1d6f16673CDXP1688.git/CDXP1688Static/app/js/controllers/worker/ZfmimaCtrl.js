(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorekrZfmimaCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorekrZfmimaCtrl]);

  function WorekrZfmimaCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorekrZfmimaCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorekrZfmimaCtrl destroy...');
    });

    $scope.quxiao= DialogService.hideCustom;

  }
})();