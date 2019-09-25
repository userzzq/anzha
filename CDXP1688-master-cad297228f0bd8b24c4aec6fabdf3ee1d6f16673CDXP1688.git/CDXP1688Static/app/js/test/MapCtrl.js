(function () {

  var ctrls = angular.module('controllers');
  ctrls.controller('TestMapCtrl', ['$scope', '$log', '$timeout', 'UtilsService', TestMapCtrl]);

  function TestMapCtrl($scope, $log, $timeout, UtilsService) {
    $log.debug('TestMapCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestMapCtrl destroy...');
      window.removeEventListener('message', locationBack, false);
    });

    window.addEventListener('message', locationBack, false);

    function locationBack(event) {
      // 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
      var loc = event.data;
      if (loc && loc.module == 'locationPicker') { //防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
        $log.debug('locationPicker', loc);
      } else if (loc) {
        $log.debug('location', loc);
        $timeout(function () {
          $scope.mapurl = UtilsService.getMapUrl(loc);
        }, 1);
      }
    }

    $scope.geoUrl = UtilsService.getGeoUrl();

    // var geolocation = new qq.maps.Geolocation("TD7BZ-HV26J-KJUFA-KOUXQ-RZWLT-XVBEH", "壹路巴巴-维修服务");
    // geolocation.getLocation(function (position) {
    //   // var myLatlng = new qq.maps.LatLng(position.lat, position.lng);
    //   // var myOptions = {
    //   //   zoom: 18,
    //   //   center: myLatlng,
    //   //   mapTypeId: qq.maps.MapTypeId.ROADMAP
    //   // }
    //   DialogService.showAlert(JSON.stringify(position));

    // }, function (err) {
    //   DialogService.showAlert('定位失败：' + JSON.stringify(err));
    // }, {});


  }
})();