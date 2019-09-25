(function() {
  var ctrls = angular.module(MyAppConfig.controllers);
  ctrls.controller('MainCtrl', ['$scope', '$log', 'DialogService', 'MyDataService', 'MyUtilService', 'UtilsService', MainCtrl]);

  function MainCtrl($scope, $log, DialogService, MyDataService, MyUtilService, UtilsService) {
    $log.debug('MainCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function() {
      $log.debug('MainCtrl destroy...');
    });

    //用户相关============================================================================
    $scope.queryUserInfo = function() {
      MyDataService.send('/adminuser/queryTbAdminUser', {}, function(data) {
        if (data.datas && data.datas.user) {
          $scope.user = data.datas.user;
          return;
        }
        DialogService.showAlert('需要登录', function() {
          UtilsService.toPage('/index');
        });
      });
    };

    $scope.queryUserInfo();

    $scope.logout = function() {
      DialogService.showWait('安全退出中，请稍候...');
      MyDataService.send('/adminuser/logout', {}, function(data) {
        DialogService.hideWait();
        UtilsService.toPage('/index');
      });
    };

    //菜单相关==============================================================================
    $scope.menus = [
      {
        page: 'user',
        text: '用户管理',
        icon: '&#xe70d;'
      },
      {
        page: 'worker',
        text: '师傅管理',
        icon: '&#xe70d;'
      },
      {
        page: 'xidd',
        text: '订单管理',
        icon: '&#xe70d;'
      },
      {
        page: 'sfbk',
        text: '师傅拨款',
        icon: '&#xe70d;'
      },
      {
        page: 'workerReport',
        text: '报备管理',
        icon: '&#xe70d;'
      },
      {
        page: 'config',
        text: '配置管理',
        icon: '&#xe70d;'
      }
    ];

    $scope.changeMenu = function(menu) {
      $scope.incPage = 'templates/' + menu.page + '.html';
      $scope.selectMenu = menu;
    };

    $scope.changeMenu($scope.menus[0]);

    //----修改密码-----
    $scope.xiugaimm = function() {
      DialogService.showCustom('templates/xiugaimm.html', {});
    };
  }
})();
