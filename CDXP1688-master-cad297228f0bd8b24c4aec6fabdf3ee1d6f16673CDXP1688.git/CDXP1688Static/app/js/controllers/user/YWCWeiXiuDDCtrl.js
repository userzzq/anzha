(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserYWCWeiXiuDDCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserYWCWeiXiuDDCtrl]);

  function UserYWCWeiXiuDDCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserYWCWeiXiuDDCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserYWCWeiXiuDDCtrl destroy...');
    });

    $scope.list = [];
    $scope.page = {
      pageNumber: 1,
      pageSize: 5
    };

    $scope.ckgd = function() {
      if ($scope.page.pageNumber >= $scope.page.pageCount) {
        return;
      }
      $scope.page.pageNumber = $scope.page.pageNumber + 1;
      $scope.wcquery();
    };

    $scope.requery = function() {
      $scope.list = [];
      $scope.page.pageNumber = 1;
      $scope.wcquery();
    };

    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
    var tbUserFixInfo = {};
    $scope.tbUserFixInfo = { ufid: tbUserFixInfo.ufid };

    $scope.pay = function(tbUserFixInfo) {
      DialogService.showWait('确认支付中...');
      MyDataService.send('/userfixinfo/pay', { 'tbUserFixInfo.ufid': tbUserFixInfo.ufid }, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function() {
          if (data.success) {
            $scope.requery();
            return;
          }
        });
      });
    };

    $scope.price = function(tbUserFixInfo) {
      DialogService.showWait('确认价格中...');
      MyDataService.send('/userfixinfo/price', { 'tbUserFixInfo.ufid': tbUserFixInfo.ufid }, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function() {
          if (data.success) {
            $scope.requery();
            return;
          }
        });
      });
    };

    $scope.cance = function(tbUserFixInfo) {
      DialogService.showWait('取消订单中');
      MyDataService.send('/userfixinfo/cancelOrder', { 'tbUserFixInfo.ufid': tbUserFixInfo.ufid }, function(data) {
        DialogService.hideWait();
        DialogService.showAlert(data.message, function() {
          if (data.success) {
            $scope.requery();
            return;
          }
        });
      });
    };

    $scope.wcquery = function() {
      DialogService.showWait('信息查询中，请稍候...');
      MyDataService.send(
        '/userfixinfo/queryFinish',
        {
          page: $scope.page,
          tbUserFixInfo: $scope.tbUserFixInfo
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.list = $scope.list.concat(data.datas.list);
            $scope.page = data.datas.page;
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };

    $scope.wcquery();

    $scope.tbUserFixInfo = {
      fixtype: ''
    };
    $scope.queryFixInfo = function(fixtype) {
      $scope.tbUserFixInfo.fixtype = fixtype;
      $scope.wcquery();
    };
  }
})();
