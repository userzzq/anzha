(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserLXKFCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserLXKFCtrl]);

  function UserLXKFCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserLXKFCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserLXKFCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
  }
})();
