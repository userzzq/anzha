//工具类directive
(function () {
  var app = angular.module(MyAppConfig.directives);

  app.directive('imageCode', [
    '$log',
    'UtilsService',
    function ($log, UtilsService) {
      $log.debug('directive image-code...');

      return {
        restrict: 'AE',
        template: '<img ng-src={{imageCode}} ng-click="changeImg();">',
        replace: true,
        link: function ($scope, element, attr) {
          $scope.$on('$destroy', function () {
            $log.debug('directive image-code destroy...');
          });

          $log.debug('directive image-code init...', element, attr);

          $scope.changeImg = function () {
            $scope.imageCode = UtilsService.getImageCode();
          };

          //委托方法给service
          UtilsService.setImageCodeScope($scope);

          $scope.changeImg();
        }
      };
    }
  ]);
})();