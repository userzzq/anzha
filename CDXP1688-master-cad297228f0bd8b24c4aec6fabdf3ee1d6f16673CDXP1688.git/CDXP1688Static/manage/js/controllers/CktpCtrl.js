(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('CktpCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', CktpCtrl]);

  function CktpCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('CktpCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('CktpCtrl destroy...');
    });

    var tbUserFixInfo = DialogService.getCustomData().tbUserFixInfo;

    $scope.quxiao = DialogService.hideCustom;

    $scope.baseurl=UtilsService.getDataServer()+'/util/getOssObjUrl?TbOssInfo.objectName=';
     
    $scope.showimg=function(d){
       window.open( $scope.baseurl+d.objectName);
    };
    $scope.query = function() {
      $log.debug('DWEGTSWSA@#@$$%^$R',tbUserFixInfo);
      DialogService.showWait('信息查询中，请稍候...');
      MyDataService.send(
        '/admin/userfixinfo/queryObjectNamesByUserFixInfo',
        {
          'tbUserFixInfo.ufid': tbUserFixInfo.ufid
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
