(function () {
  var ctrls = angular.module(MyAppConfig.controllers);

  ctrls.controller('UserIndexCtrl', ['$scope', '$log', '$timeout', 'UtilsService', UserIndexCtrl]);

  function UserIndexCtrl($scope, $log, $timeout, UtilsService) {
    $log.debug('UserIndexCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('UserIndexCtrl destroy...');
      window.removeEventListener('message', locationBack, false);
    });

    //地图=======================================================
    window.addEventListener('message', locationBack, false);

    function locationBack(event) {
      // 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
      var loc = event.data;
      if (loc && loc.module == 'locationPicker') { //防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
        $log.debug('locationPicker', loc);
        UtilsService.saveLocation(loc); //保存地址
      } else if (loc) {
        $log.debug('location', loc);
        $timeout(function () {
          $scope.mapurl = UtilsService.getMapUrl(loc);
          UtilsService.saveLocation(loc); //保存地址
        }, 1);
      }
    }

    var count = 0;
    //android终端
    //var isAndroid = navigator.userAgent.indexOf('Android') > -1 || navigator.userAgent.indexOf('Adr') > -1;
    if (window.andoridNative) {
      window.loactionCallBack = function (loc) {
        try {
          if (count == 0) {
            count = 1;
            $timeout(function () {
              if (loc.addr) {
                var aloc = {
                  province: '',
                  city: '',
                  addr: loc.addr,
                  lat: loc.lat,
                  lng: loc.lng
                };
                $scope.mapurl = UtilsService.getMapUrl(aloc);
                UtilsService.saveLocation(aloc); //保存地址
              } else {
                //没有loc信息就转到html5获取位置
                $scope.geoUrl = UtilsService.getGeoUrl();
              }
            }, 1);
          } else {
            $log.debug(loc);
          }
          return 'ok!';
        } catch (ex) {
          return 'error!' + JSON.stringify(ex);
        }
      };
    } else {
      $scope.geoUrl = UtilsService.getGeoUrl();
    }
    //$scope.geoUrl = UtilsService.getGeoUrl();
    //地图=======================================================

    $scope.topage = function (page) {
      UtilsService.toPage(page);
    };
  }
})();