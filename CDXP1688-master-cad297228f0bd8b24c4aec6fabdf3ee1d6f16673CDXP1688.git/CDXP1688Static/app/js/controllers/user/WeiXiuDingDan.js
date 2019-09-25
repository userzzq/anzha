(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserWeiXiuDingDanCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', UserWeiXiuDingDanCtrl]);

  function UserWeiXiuDingDanCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('UserWeiXiuDingDanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserWeiXiuDingDanCtrl destroy...');
    });
    //移除ufid信息
    UtilsService.removeUfid();

    function isWeiXin() {
      var ua = window.navigator.userAgent.toLowerCase();
      if (ua.match(/MicroMessenger/i) == 'micromessenger') {
        return true;
      } else {
        return false;
      }
    }
    var wx = isWeiXin();

    var url = '/userfixinfo/query';

    $scope.list = [];
    $scope.page = {
      pageNumber: 1,
      pageSize: 3
    };

    $scope.queryProgress = function() {
      url = '/userfixinfo/query';
      $scope.requery();
    };

    $scope.queryFinish = function() {
      url = '/userfixinfo/queryFinish';
      $scope.requery();
    };

    $scope.ckgd = function() {
      if ($scope.page.pageNumber >= $scope.page.pageCount) {
        return;
      }
      $scope.page.pageNumber = $scope.page.pageNumber + 1;
      $scope.query();
    };

    $scope.requery = function() {
      $scope.list = [];
      $scope.page.pageNumber = 1;
      $scope.query();
    };

    $scope.topage = function(page) {
      UtilsService.toPage(page);
    };
    var tbUserFixInfo = {};
    $scope.tbUserFixInfo = { ufid: tbUserFixInfo.ufid };

    $scope.pay = function(tbUserFixInfo) {
      DialogService.showWait('确认支付中...');
      //需要保存ufid信息，方便openid获取后的订单信息查询
      UtilsService.saveUfid(tbUserFixInfo.ufid);
      if (wx) {
        location = UtilsService.getDataServer() + '/wx/openid';
      } else {
        MyDataService.send('/wx/toh5pay', { ufid: tbUserFixInfo.ufid }, function(data) {
          DialogService.hideWait();
          if (data.success) {
            location = data.message;
            return;
          }
          DialogService.showAlert(data.message);
        });
      }
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

    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候...');
      MyDataService.send(
        url,
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

    $scope.query();

    $scope.tbUserFixInfo = {
      fixtype: ''
    };
    $scope.queryFixInfo = function(fixtype) {
      $scope.tbUserFixInfo.fixtype = fixtype;
      $scope.query();
    };
  }
})();
