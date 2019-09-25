(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('DkboxCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', DkboxCtrl]);

  function DkboxCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('DkboxCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('DkboxCtrl destroy...');
    });
    var d = DialogService.getCustomData();
    $log.debug(d);
    $scope.closeMe = DialogService.hideCustom;

    $scope.tbPayRecode = { wid: d.wid };

    $scope.dk = function() {
      DialogService.showWait('打款处理中。。。。');
      MyDataService.send(
        '/adminpayrecode/add',
        {
          tbPayRecode: $scope.tbPayRecode
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
            }
          });
        }
      );
    };
  }
})();
