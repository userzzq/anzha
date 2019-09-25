(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserOpenidBackCtrl', ['$scope', '$log', '$location', 'UtilsService', 'MyDataService', 'DialogService', UserOpenidBackCtrl]);

  function UserOpenidBackCtrl($scope, $log, $location, UtilsService, MyDataService, DialogService) {
    $log.debug('UserOpenidBackCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserOpenidBackCtrl destroy...');
    });

    var url = UtilsService.getDataServer() + '/wx/topay?openid=' + $location.search().openid + '&ufid=' + UtilsService.loadUfid();
    location = url;
  }
})();
