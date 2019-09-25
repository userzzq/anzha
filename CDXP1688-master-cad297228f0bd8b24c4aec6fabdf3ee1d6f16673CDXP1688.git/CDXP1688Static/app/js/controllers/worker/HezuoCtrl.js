(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerHezuoCtrl', ['$scope', '$log', WorkerHezuoCtrl]);

  function WorkerHezuoCtrl($scope, $log) {
    $log.debug('WorkerHezuoCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerHezuoCtrl destroy...');
    });

    $scope.images = [];
    for (var i = 1; i <= 48; i++) {
      var imageName = i < 10 ? '0' + i : '' + i;
      $scope.images.push('images/hezuo/hezuo0' + imageName + '.jpg');
    }

  }
})();