(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('workerJiedanCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', workerJiedanCtrl]);

  function workerJiedanCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('workerJiedanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('workerJiedanCtrl destroy...');
    });

    $scope.order = JSON.parse(localStorage.getItem('order-detail'));
    $log.debug('==========>', $scope.order);

    $scope.fanhui = function() {
      UtilsService.toPage('/worker/main', null, 'menu0');
    };

    $scope.jd = function() {
      MyDataService.send(
        '/workerfixinfo/pickOrder',
        {
          'tbUserFixOrder.ufid': $scope.order.ufid
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
              UtilsService.toPage('/worker/wddingdan');
              return;
            }
          });
        }
      );
    };
    $scope.baseurl = UtilsService.getDataServer() + '/util/getOssObjUrl?TbOssInfo.objectName=';

    // $scope.showimg=function(d){
    //    window.open( $scope.baseurl+d.objectName);
    // };
    $scope.query = function() {
      DialogService.showWait('信息查询中，请稍候...');
      MyDataService.send(
        '/workerfixinfo/queryObjectNamesByUserFixInfo',
        {
          'tbUserFixInfo.ufid': $scope.order.ufid
        },
        function(data) {
          DialogService.hideWait();
          if (data.success) {
            $scope.list = data.datas.list;
            return;
          }
          DialogService.showAlert(data.message);
        }
      );
    };

    $scope.query();
  }
})();
