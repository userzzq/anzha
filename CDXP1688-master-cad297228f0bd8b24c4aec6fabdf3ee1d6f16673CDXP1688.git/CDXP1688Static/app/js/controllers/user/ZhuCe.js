(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserZhuCeCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserZhuCeCtrl]);

  function UserZhuCeCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserZhuCeCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserZhuCeCtrl destroy...');
    });

    $scope.focus = {
      phone: false
    };

    $scope.model = {
      imageCode: '',
      phoneCode: '',
      password: ''
    };

    $scope.tbUser = {

    };

    $scope.sendPhoneCode = function () {
      DialogService.showWait('发送手机验证中，请稍候...');
      MyDataService.send('/util/sendPhoneCode', {
        phone: $scope.tbUser.phone,
        imageCode: $scope.model.imageCode
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };

    $scope.zhuce = function () {
      if ($scope.tbUser.password == '') {
        DialogService.showAlert('密码必须填写');
        return;
      }
      if ($scope.model.password != $scope.tbUser.password) {
        DialogService.showAlert('密码不一致');
        return;
      }


      if (!$scope.tbUser.agreement) {
        DialogService.showAlert('不同意协议不能注册');
        return;
      }


      $scope.tbUser.password = MyUtilService.md5($scope.tbUser.password);
      DialogService.showWait('注册中，请稍候...');
      MyDataService.send('/user/reg', {
        tbUser: $scope.tbUser,
        phoneCode: $scope.model.phoneCode
      }, function (data) {
        $scope.tbUser.password = {};
        $scope.model.password ={};
        $scope.tbUser = {agreement: false };
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };

    $scope.login = function () {
      UtilsService.toPage('/user/main');
    };

    $scope.topage = function (page) {
      UtilsService.toPage(page);
    };
  }
})();