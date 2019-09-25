(function () {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('WorkerBaobeiguanliCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', WorkerBaobeiguanliCtrl]);

  function WorkerBaobeiguanliCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('WorkerBaobeiguanliCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('WorkerBaobeiguanliCtrl destroy...');
    });
    $scope.panhuiwode=function(){
      UtilsService.toPage('/worker/main', null, 'menu2');
    };

    //菜单相关==============================================================================
    $scope.menus = [{
      'page': 'report',
      'text': '我要报备'
    },{
        'page': 'reports',
        'text': '报备管理'
      }];

    $scope.changeMenu = function (menu) {
      $scope.incPage = 'templates/worker/' + menu.page + '.html';
      $scope.selectMenu = menu;
    };

    $scope.changeMenu($scope.menus[0]);

    //用户信息=============================================================================
    $scope.queryWorker = function () {
      MyDataService.send('/worker/queryWorker', {}, function (data) {
        if (data.datas && data.datas.worker) {
          $scope.worker = data.datas.worker;
          return;
        }
        DialogService.showAlert('需要登录', function () {
          UtilsService.toPage('/worker/index');
        });
      });
    };

    $scope.queryWorker();

  }
})();