(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserXiYiCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserXiYiCtrl]);

  function UserXiYiCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserXiYiCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserXiYiCtrl destroy...');
    });

    $scope.topage = function (page) {
      UtilsService.toPage(page);
    };
  }
})();