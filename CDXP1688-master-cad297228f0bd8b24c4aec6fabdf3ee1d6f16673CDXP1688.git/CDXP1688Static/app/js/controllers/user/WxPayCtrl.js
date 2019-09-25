(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('UserWxPayCtrl', ['$scope', '$log', '$location', 'UtilsService', 'MyDataService', 'DialogService', UserWxPayCtrl]);

  function UserWxPayCtrl($scope, $log, $location, UtilsService, MyDataService, DialogService) {
    $log.debug('UserWxPayCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('UserWxPayCtrl destroy...');
    });
    $scope.info = $location.search();
    function onBridgeReady() {
      WeixinJSBridge.invoke(
        'getBrandWCPayRequest',
        {
          appId: $scope.info.appId,
          timeStamp: $scope.info.timeStamp,
          nonceStr: $scope.info.nonceStr,
          package: $scope.info.package,
          signType: $scope.info.signType,
          paySign: $scope.info.paySign
        },
        function(res) {
          if (res.err_msg == 'get_brand_wcpay_request:ok') {
            MyDataService.send('/userfixinfo/pay', { 'tbUserFixInfo.ufid': UtilsService.loadUfid() }, function(data) {
              DialogService.showAlert(data.message, function() {
                UtilsService.toPage('/user/weixiudingdan');
              });
            });
          } else {
            DialogService.showAlert('支付失败：' + res.err_msg, function() {
              UtilsService.toPage('/user/weixiudingdan');
            });
          }
        }
      );
    }
    if (typeof WeixinJSBridge == 'undefined') {
      if (document.addEventListener) {
        document.addEventListener('WeixinJSBridgeReady', onBridgeReady, false);
      } else if (document.attachEvent) {
        document.attachEvent('WeixinJSBridgeReady', onBridgeReady);
        document.attachEvent('onWeixinJSBridgeReady', onBridgeReady);
      }
    } else {
      onBridgeReady();
    }
  }
})();
