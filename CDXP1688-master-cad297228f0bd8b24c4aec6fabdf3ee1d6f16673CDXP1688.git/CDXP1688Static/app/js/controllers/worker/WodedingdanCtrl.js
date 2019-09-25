(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('workerWodedingdanCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', workerWodedingdanCtrl]);

  function workerWodedingdanCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('workerWodedingdanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('workerWodedingdanCtrl destroy...');
    });
    $scope.list = [];
    $scope.page = {
      pageNumber: 1,
      pageSize: 3
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
    
    $scope.query = function() {
      DialogService.showWait('查询，请稍候...');
      MyDataService.send(
        '/workerfixinfo/queryOrder',
        {
          page: $scope.page,
          tbUserFixOrder: $scope.tbUserFixOrder
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

    $scope.baojia = function(tbUserFixOrder) {
      var data = {};
      angular.copy(tbUserFixOrder, data);
      DialogService.showCustom('templates/worker/baojia.html', data, function() {
        $scope.requery();
      });
    };

    var tbUserFixOrder = {};
    $scope.tbUserFixOrder = { ufoid: tbUserFixOrder.ufoid };
    $scope.wccdd = function(tbUserFixOrder) {
      MyDataService.send(
        '/workerfixinfo/finish',
        {
          'tbUserFixOrder.ufoid': tbUserFixOrder.ufoid
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
              return;
            }
            $scope.requery();
          });
        }
      );
    };
    $scope.wcwx = function(tbUserFixOrder) {
      MyDataService.send(
        '/workerfixinfo/finishWork',
        {
          'tbUserFixOrder.ufoid': tbUserFixOrder.ufoid
        },
        function(data) {
          DialogService.hideWait();
          DialogService.showAlert(data.message, function() {
            if (data.success) {
              DialogService.hideCustom();
              $scope.requery();
              return;
            }     
          });  
        }
      );
    };
  }
})();
