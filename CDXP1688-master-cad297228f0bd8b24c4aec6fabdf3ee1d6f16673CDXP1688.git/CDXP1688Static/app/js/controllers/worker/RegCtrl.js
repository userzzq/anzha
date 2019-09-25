(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerRegCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerRegCtrl]);

  function WorkerRegCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerRegCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerRegCtrl destroy...');
    });

    $scope.focus = {
      phone: false
    };

    $scope.model = {
      imageCode: '',
      phoneCode: '',
      password: ''
    };

    $scope.tbWorker = {};

    $scope.selectedType = {};

    $scope.queryFormInfo = function () {
      DialogService.showWait('数据查询中，请稍候...');
      MyDataService.send('/worker/queryFormInfo', {}, function (data) {
        DialogService.hideWait();
        if (!data.success) {
          DialogService.showAlert(data.message);
          return;
        }
        $scope.types = data.datas.types;
        $scope.selectedType = $scope.types[0];
        $scope.focus.phone = true;
      });
    };

    $scope.queryFormInfo();

    $scope.changeType = function (t) {
      $scope.selectedType = t;
    };


    $scope.sendPhoneCode = function () {
      DialogService.showWait('发送手机验证中，请稍候...');
      MyDataService.send('/util/sendPhoneCode', {
        phone: $scope.tbWorker.phone,
        imageCode: $scope.model.imageCode
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };
    $scope.reg = function () {
      if ($scope.tbWorker.password == '') {
        DialogService.showAlert('密码必须填写');
        return;
      }
      if ($scope.model.password != $scope.tbWorker.password) {
        DialogService.showAlert('密码不一致');
        return;
      }
      if (!$scope.tbWorker.agreement) {
        DialogService.showAlert('不同意协议不能注册');
        return;
      }

      $scope.tbWorker.password = MyUtilService.md5($scope.tbWorker.password);
      $scope.tbWorker.wtid = $scope.selectedType.wtid;
      DialogService.showWait('注册中，请稍候...');
      MyDataService.send('/worker/reg', {
        tbWorker: $scope.tbWorker,
        phoneCode: $scope.model.phoneCode
      }, function (data) {
        $scope.tbWorker.password = '';
        $scope.model.password = '';
        $scope.tbWorker = {agreement: false };
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };

    $scope.login = function () {
      UtilsService.toPage('/worker/index');
    };
    $scope.topage = function (page) {
      UtilsService.toPage(page);
    };
  }
})();