(function () {
  var ctrls = angular.module(MyAppConfig.controllers);

  ctrls.controller('UserFlashCtrl', ['$scope', '$log', 'UtilsService', 'MyDataService', UserFlashCtrl]);

  function UserFlashCtrl($scope, $log, UtilsService, MyDataService) {
    $log.debug('UserFlashCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserFlashCtrl destroy...');
    });

    MyDataService.send('/user/queryUser', {}, function (data) {
      if (data.datas && data.datas.user) {
        UtilsService.toPage('/user/index');
      } else {
        UtilsService.toPage('/user/main');
      }
    });

  }
})();