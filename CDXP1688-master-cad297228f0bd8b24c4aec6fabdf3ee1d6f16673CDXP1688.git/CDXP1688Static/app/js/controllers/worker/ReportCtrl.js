(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerReportCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerReportCtrl]);

  function WorkerReportCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerReportCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerReportCtrl destroy...');
    });
    $scope.tbReportPeople = {};
    $scope.tbWorkerReport = {};
    $scope.reportPeoples = [];

    $scope.report = function () {
      DialogService.showWait('信息处理中，请稍候');
      MyDataService.send('/workerReport/report', {
        tbWorkerReport: $scope.tbWorkerReport,
        reportPeoples: $scope.reportPeoples
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function () {
          if (data.success) {
            $scope.tbWorkerReport = {};
            $scope.reportPeoples = [];
          }
        });
      });
    };

    $scope.addPeople = function () {
      if (!$scope.tbReportPeople.username) {
        DialogService.showAlert('姓名必须填写');
        return;
      }
      if (!$scope.tbReportPeople.phone) {
        DialogService.showAlert('电话必须填写');
        return;
      }
      var people = {};
      angular.copy($scope.tbReportPeople, people);
      $scope.tbReportPeople = {
        rtid: $scope.types[0].rtid
      };
      $scope.reportPeoples.push(people);
    };

    $scope.removePeople = function (index) {
      $scope.reportPeoples.splice(index, 1);
    };

    $scope.showTypeName = function (rtid) {
      for (var i = 0; i < $scope.types.length; i++) {
        var type = $scope.types[i];
        if (type.rtid == rtid) {
          return type.typeName;
        }
      }
      return '';
    };

    //表单初始信息
    $scope.queryFormInfo = function () {
      DialogService.showWait('信息查询中，请稍候');
      MyDataService.send('/workerReport/queryFormInfo', {}, function (data) {
        DialogService.hideWait();
        if (data.success) {
          $scope.types = data.datas.types;
          $scope.tbReportPeople.rtid = $scope.types[0].rtid;
          return;
        }
        DialogService.showAlert(data.message);
      });
    };
    $scope.queryFormInfo();
  }
})();