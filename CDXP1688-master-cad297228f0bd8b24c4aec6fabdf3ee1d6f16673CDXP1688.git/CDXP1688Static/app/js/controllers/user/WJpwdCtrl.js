(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserWJpwdCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserWJpwdCtrl]);

  function UserWJpwdCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserWJpwdCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserWJpwdCtrl destroy...');
    });

    $scope.focus = {
      phone: false
    };

    $scope.model = {
      imageCode: '',
      phoneCode: '',
      password: ''
    };

    $scope.tbUser = {};

    // $scope.selectedType = {};

    // $scope.queryFormInfo = function() {
    //   DialogService.showWait('数据查询中，请稍候...');
    //   MyDataService.send('/user/queryUser', {}, function(data) {
    //     DialogService.hideWait();
    //     if (!data.success) {
    //       DialogService.showAlert(data.message);
    //       return;
    //     }
    //     $scope.types = data.datas.types;
    //     $scope.selectedType = $scope.types[0];
    //     $scope.focus.phone = true;
    //   });
    // };
    // $scope.queryFormInfo();

    // $scope.changeType = function (t) {
    //   $scope.selectedType = t;
    // };

    $scope.sendPhoneCode = function () {
      DialogService.showWait('发送手机验证中，请稍候...');
      MyDataService.send('/util/sendFindPwd', {
        phone: $scope.tbUser.phone,
        imageCode: $scope.model.imageCode
      }, function (data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message);
      });
    };

    $scope.wjpwd = function () {
      if (!$scope.tbUser.phone) {
        DialogService.showAlert('请填写手机号码');
        return;
      }
      if (!$scope.tbUser.password) {
        DialogService.showAlert('请填写新密码');
        return;
      }
      if (!$scope.model.password) {
        DialogService.showAlert('请重复一遍密码');
        return;
      }
      if ($scope.model.password != $scope.tbUser.password) {
        DialogService.showAlert('密码不一致');
        return;
      }
      if (!$scope.model.phoneCode) {
        DialogService.showAlert('请填写手机验证码');
        return;
      }
      $scope.tbUser.password = MyUtilService.md5($scope.tbUser.password);
      // $scope.tbUser.wtid = $scope.selectedType.wtid;
      DialogService.showWait('修改中，请稍候...');
      MyDataService.send('/user/modifyPwd', {
        tbUser: $scope.tbUser,
        phoneCode: $scope.model.phoneCode
      }, function (data) {
        $scope.tbUser.password = '';
        $scope.model.password = '';
        DialogService.hideWait();
        DialogService.showAlert(data.message,function () {
          if (data.success) {
            UtilsService.toPage('/user/main');
          }
        });
      });
    };

    $scope.login = function () {
      UtilsService.toPage('/user/main');
    };
  }
})();