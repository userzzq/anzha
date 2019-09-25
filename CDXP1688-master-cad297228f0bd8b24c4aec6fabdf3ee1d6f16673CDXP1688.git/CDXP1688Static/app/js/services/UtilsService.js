/**
 * 工具服务
 */
(function() {
  var app = angular.module(MyAppConfig.services);

  app.factory('UtilsService', ['$log', '$rootScope', '$location', '$timeout', '$sce', 'DialogService', 'MyDataService', 'MyUtilService', 'MyLocalDataService', UtilsService]);

  function UtilsService($log, $rootScope, $location, $timeout, $sce, DialogService, MyDataService, MyUtilService, MyLocalDataService) {
    $log.info('UtilsService init...');
    var service = {};

    var mapKey = 'TD7BZ-HV26J-KJUFA-KOUXQ-RZWLT-XVBEH';
    var mapReferer = '壹路巴巴-维修服务';
    var mapBaseUrl = 'https://apis.map.qq.com/tools/locpicker?search=1&type=1&key=' + mapKey + '&referer=' + mapReferer;
    var geoUrl = encodeURI('https://apis.map.qq.com/tools/geolocation?key=' + mapKey + '&referer=壹路巴巴-维修服务');
    var sessionLocationKey = 'saveSessionLocationKey';

    //地图有关
    service.getGeoUrl = function() {
      return $sce.trustAsResourceUrl(geoUrl);
    };

    service.getMapUrl = function(loc) {
      return $sce.trustAsResourceUrl(encodeURI(mapBaseUrl + '&coord=' + loc.lat + ',' + loc.lng));
    };

    service.saveLocation = function(loc) {
      var saveLoc = {};
      if (loc.module == 'locationPicker') {
        //地图选点
        saveLoc.address = loc.poiaddress + '(' + loc.poiname + ')';
        saveLoc.lat = loc.latlng.lat;
        saveLoc.lng = loc.latlng.lng;
      } else {
        //默认地址
        saveLoc.address = loc.province + loc.city + loc.addr;
        saveLoc.lat = loc.lat;
        saveLoc.lng = loc.lng;
      }
      MyLocalDataService.putSessionJson(sessionLocationKey, saveLoc);
    };

    service.getLocation = function() {
      return MyLocalDataService.getSessionJson(sessionLocationKey);
    };

    //订单支付的ufid信息
    var ufidInfoKey = 'localUfidInfo';
    service.saveUfid = function(ufid) {
      MyLocalDataService.putSession(ufidInfoKey, ufid);
    };
    service.loadUfid = function() {
      return MyLocalDataService.getSession(ufidInfoKey);
    };
    service.removeUfid = function() {
      MyLocalDataService.removeSession(ufidInfoKey);
    };

    //需要完成统一token处理
    var servertokenKey = 'servertoken.key';

    DialogService.setTitle($rootScope.appTitle);
    $rootScope.dataServer = MyAppConfig.dataservice;

    service.initDataService = function() {
      MyDataService.setDataServer($rootScope.dataServer);

      function beforeSend(url, senddata) {
        $log.debug('before:', url, senddata);
        // 发送时间戳和token
        senddata.ajaxtimestamp = new Date().getTime();
        senddata.token = MyLocalDataService.get(servertokenKey);
      }

      function beforeSendFile(url, files, senddata) {
        $log.debug('before:File', url, files, senddata);
        // 发送时间戳和token
        senddata.ajaxtimestamp = new Date().getTime();
        senddata.token = MyLocalDataService.get(servertokenKey);
      }

      function afterSend(data) {
        $log.debug('after data====>', data);
        //保存token
        if (data.data && data.data.token && !MyUtilService.empty(MyUtilService.trim(data.data.token))) {
          MyLocalDataService.put(servertokenKey, data.data.token);
        }
        if (data.data && data.data.code && data.data.code == 1000) {
          DialogService.hideWait();
          DialogService.showAlert(data.data.message, function() {
            service.toPage('/worker/index');
          });
          return 'break';
        }
        if (data.data && data.data.code && data.data.code == 1002) {
          DialogService.hideWait();
          DialogService.showAlert(data.data.message, function() {
            service.toPage('/user/main');
          });
          return 'break';
        }
      }

      MyDataService.setBefore(beforeSend);
      MyDataService.setBeforeFile(beforeSendFile);
      MyDataService.setAfter(afterSend);
      MyDataService.setAfterFile(afterSend);
    };

    service.getDataServer = function() {
      return $rootScope.dataServer;
    };

    service.getToken = function() {
      return MyLocalDataService.get(servertokenKey);
    };

    service.getImageCode = function() {
      return service.getDataServer() + '/util/validate.jpg?token=' + service.getToken() + '&ts=' + new Date().getTime();
    };

    var imageCodeScope;
    service.setImageCodeScope = function(ics) {
      imageCodeScope = ics;
    };

    service.changeImageCode = function() {
      if (imageCodeScope) {
        $timeout(function() {
          imageCodeScope.changeImg();
        }, 1);
      }
    };

    service.toPage = function(page, search, hash) {
      $timeout(function() {
        if (!search) {
          search = {};
        }
        $location.search(search);
        if (!hash) {
          hash = '';
        }
        $location.hash(hash);

        $location.path('/route/page' + page);
      }, 1);
    };

    return service;
  }
})();
