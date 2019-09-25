(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerMainCtrl', ['$scope', '$log', '$location', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerMainCtrl]);

  function WorkerMainCtrl($scope, $log, $location, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerMainCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('WorkerMainCtrl destroy...');
    });

    //菜单相关==============================================================================
    $scope.menus = [
      {
        page: 'woyaojiedan',
        text: '接单',
        icon: '&#xe679;'
      },
      {
        page: 'xiaoxi',
        text: '消息',
        icon: '&#xe61e;'
      },
      {
        page: 'wode',
        text: '我的',
        icon: '&#xe67d;'
      }
    ];

    var index = $location.hash();
    index = index ? index.replace('menu', '') : '0';
    $log.debug('=====>', $location.hash(), index);
    index = parseInt(index);

    $log.debug('=====>', $location.hash(), index);

    $scope.changeMenu = function(index) {
      $location.hash('menu' + index);
      $location.path('/route/page/worker/main');
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
