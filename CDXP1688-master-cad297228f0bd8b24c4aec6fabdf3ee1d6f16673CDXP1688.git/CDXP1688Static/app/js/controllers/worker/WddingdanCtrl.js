(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerWddingdanCtrl', ['$scope', '$log','$location', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerWddingdanCtrl]);

  function WorkerWddingdanCtrl($scope, $log,$location, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerWddingdanCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerWddingdanCtrl destroy...');
    });
    $scope.panhuiwode = function() {
      UtilsService.toPage('/worker/main', null, 'menu2');
    };

    //菜单相关==============================================================================
    $scope.menus = [
      {
        page: 'wodedingdan',
        text: '在做订单'
      },
      {
        page: 'lisdingdan',
        text: '历史订单'
      }
    ];

    var index = $location.hash();
    index = index ? index.replace('menu', '') : '0';
    $log.debug('=====>', $location.hash(), index);
    index = parseInt(index);

    $log.debug('=====>', $location.hash(), index);

    $scope.changeMenu = function(index) {
      $location.hash('menu' + index);
      $location.path('/route/page/worker/wddingdan');
    };

    function changeMenu(menu) {
      $scope.incPage = 'templates/worker/' + menu.page + '.html';
      $scope.selectMenu = menu;
    }

    changeMenu($scope.menus[index]);

    //用户信息=============================================================================
    $scope.queryWorker = function() {
      MyDataService.send('/worker/queryWorker', {}, function(data) {
        if (data.datas && data.datas.worker) {
          $scope.worker = data.datas.worker;
          return;
        }
        DialogService.showAlert('需要登录', function() {
          UtilsService.toPage('/worker/index');
        });
      });
    };

    $scope.queryWorker();
  }
})();
