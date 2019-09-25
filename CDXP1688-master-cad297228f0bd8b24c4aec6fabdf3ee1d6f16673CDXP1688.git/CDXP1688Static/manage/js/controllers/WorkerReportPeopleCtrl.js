(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerReportPeopleCtrl', ['$scope', '$log', 'DialogService', WorkerReportPeopleCtrl]);

  function WorkerReportPeopleCtrl($scope, $log, DialogService) {
    $log.debug('WorkerReportPeopleCtrl init...');
    $scope.peoples = DialogService.getCustomData().peoples;

    $scope.closeMe = DialogService.hideCustom;

  }
})();