(function () {
  var ctrls = angular.module('controllers');
  ctrls.controller('TestOneCtrl', ['$scope', '$log', 'DialogService', TestOneCtrl]);

  function TestOneCtrl($scope, $log, DialogService) {
    $log.debug('TestOneCtrl init...');

    // 处理scope销毁
    $scope.$on('$destroy', function () {
      $log.debug('TestOneCtrl destroy...');
    });

    //日期信息
    $scope.dateInfo = {
      years: [],
      months: [],
      days: []
    };
    //选择的日期信息
    $scope.selectDate = {
      year: '',
      month: '',
      day: '',
      toString: function () {
        var m = this.month < 10 ? '-0' + this.month : '-' + this.month;
        var d = this.day < 10 ? '-0' + this.day : '-' + this.day;
        return this.year + m + d;
      }
    };

    //年份改变事件
    $scope.changeYear = function () {
      $log.debug('选中的日期：', $scope.selectDate);
      //清空月份
      $scope.dateInfo.months.length = 0;
      var startMonth = 1;
      var endMonth = 12;
      var date = new Date();
      var nowYear = date.getFullYear();
      //如果是本年度，不需要添加已经过去的月
      if (nowYear == $scope.selectDate.year) {
        startMonth = date.getMonth() + 1;
      }
      $log.debug(startMonth, endMonth);
      for (var i = startMonth; i <= endMonth; i++) {
        $scope.dateInfo.months.push(i);
      }
      //默认选中月份
      $scope.selectDate.month = $scope.dateInfo.months[0];
      $scope.changeMonth();
    };

    //月份改变事件
    $scope.changeMonth = function () {
      $log.debug('选中的日期：', $scope.selectDate);
      //清空日期
      $scope.dateInfo.days.length = 0;
      var startDay = 1;
      var endDay = 31;
      var date = new Date();
      var nowYear = date.getFullYear();
      var nowMonth = date.getMonth() + 1;
      //不能超过当日
      if (nowYear == $scope.selectDate.year && nowMonth == $scope.selectDate.month) {
        startDay = date.getDate();
      }
      //月份日期判断
      var smonth = $scope.selectDate.month;
      var syear = $scope.selectDate.year;
      var run = (syear % 400 == 0) || (syear % 4 == 0 && syear % 1000 != 0);
      if (smonth == 4 || smonth == 6 || smonth == 9 || smonth == 11) {
        endDay = 30;
      } else if (run && smonth == 2) {
        endDay = 29;
      } else if (smonth == 2) {
        endDay = 28;
      }
      $log.debug(startDay, endDay);
      for (var i = startDay; i <= endDay; i++) {
        $scope.dateInfo.days.push(i);
      }
      //默认选中日期
      $scope.selectDate.day = $scope.dateInfo.days[0];
    };

    //初始化年份信息
    var date = new Date();
    var nowYear = date.getFullYear();
    var endYear = nowYear + 1;
    for (var i = nowYear; i <= endYear; i++) {
      $scope.dateInfo.years.push(i);
    }
    //默认选中年份
    $scope.selectDate.year = $scope.dateInfo.years[0];
    $scope.changeYear();

  }
})();