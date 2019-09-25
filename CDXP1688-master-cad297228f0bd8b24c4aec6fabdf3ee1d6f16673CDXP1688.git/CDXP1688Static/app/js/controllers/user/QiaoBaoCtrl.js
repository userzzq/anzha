(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserQiaoBaoCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserQiaoBaoCtrl]);

  function UserQiaoBaoCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserQiaoBaoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserQiaoBaoCtrl destroy...');
    });
    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
  }
})();
