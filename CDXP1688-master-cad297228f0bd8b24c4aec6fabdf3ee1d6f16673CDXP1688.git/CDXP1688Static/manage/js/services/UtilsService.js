/**
 * 工具服务
 */
(function () {
  var app = angular.module(MyAppConfig.services);

  app.factory('UtilsService', ['$log', '$rootScope', '$location', '$timeout', 'DialogService', 'MyDataService', 'MyUtilService', 'MyLocalDataService', UtilsService]);

  function UtilsService($log, $rootScope, $location, $timeout, DialogService, MyDataService, MyUtilService, MyLocalDataService) {
    $log.info('UtilsService init...');
    var service = {};

    //需要完成统一token处理
    var servertokenKey = 'servertoken.key';

    DialogService.setTitle($rootScope.appTitle);
    $rootScope.dataServer = MyAppConfig.dataservice;

    service.initDataService = function () {

      MyDataService.setDataServer($rootScope.dataServer);


      MyDataService.setBefore(function (url, senddata) {
        $log.debug('before:', url, senddata);
        // 发送时间戳和token
        senddata.ajaxtimestamp = new Date().getTime();
        senddata.token = MyLocalDataService.get(servertokenKey);
      });

      MyDataService.setAfter(function (data) {
        $log.debug('after data====>', data);
        //保存token
        if (data.data && data.data.token && !MyUtilService.empty(MyUtilService.trim(data.data.token))) {
          MyLocalDataService.put(servertokenKey, data.data.token);
        }
        if (data.data && data.data.code && data.data.code == 1001) {
          DialogService.hideWait();
          DialogService.showAlert(data.data.message, function () {
            service.toPage('/index');
          });
          return 'break';
        }
      });
    };

    service.getDataServer = function () {
      return $rootScope.dataServer;
    };

    service.getToken = function () {
      return MyLocalDataService.get(servertokenKey);
    };

    service.getImageCode = function () {
      return service.getDataServer() + '/util/validate.jpg?token=' + service.getToken() + '&ts=' + new Date().getTime();
    };

    var imageCodeScope;
    service.setImageCodeScope = function (ics) {
      imageCodeScope = ics;
    };

    service.changeImageCode = function () {
      if (imageCodeScope) {
        $timeout(function () {
          imageCodeScope.changeImg();
        }, 1);
      }
    };

    service.toPage = function (page, search, hash) {
      $timeout(function () {
        if (!search) {
          search = {};
        }
        $location.search(search);
        if (!hash) {
          hash = '';
        }
        $location.hash(hash);

        $location.path("/route/page" + page);
      }, 1);

    };


    return service;
  }
})();