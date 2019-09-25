$(function() {
  var service = {};

  // 是否为手机浏览器
  service.isMobile = function() {
    return service.getBrowserInfo().versions.mobile;
  };

  // 获取浏览器信息
  service.getBrowserInfo = function() {
    var browserInfo = {
      versions: (function() {
        var u = navigator.userAgent;
        var info = {
          trident: u.indexOf('Trident') > -1, // IE内核
          presto: u.indexOf('Presto') > -1, // opera内核
          webKit: u.indexOf('AppleWebKit') > -1, // 苹果、谷歌内核
          gecko: u.indexOf('Gecko') > -1 && u.indexOf('KHTML') === -1, // 火狐内核
          ios: !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/), // ios终端
          android: u.indexOf('Android') > -1 || u.indexOf('Linux') > -1, // android终端或者uc浏览器
          iPhone: u.indexOf('iPhone') > -1 || u.indexOf('Mac') > -1, // 是否为iPhone或者QQHD浏览器
          webApp: u.indexOf('Safari') === -1
          // 是否web程序，没有头部与底部
        };
        info.mobile = info.iPhone || info.android || info.webApp;
        return info;
      })(),
      language: (navigator.browserLanguage || navigator.language).toLowerCase()
    };
    return browserInfo;
  };

  window.myutil = service;
});
