'use strict';

// Declare app level module which depends on views, and components
angular.module('myApp', [
  'ngRoute',
  'nvd3', 'smart-table', 'ngResource', 'ngAnimate', 'ngSanitize', 'ui.bootstrap','ngMaterial', 'ngMessages', 
]).config(['$locationProvider', '$routeProvider', function ($locationProvider, $routeProvider) {
  $locationProvider.hashPrefix('!');


  $routeProvider
    .when('/finance', {
      templateUrl: 'views/finance/main.html',
      controller: 'financeMainCtrl',
      activetab: 'financehome',
      parent: 'finance.css',
      id: 1
    })
    .when('/finance/detail/:cname', {
      templateUrl: 'views/finance/detail.html',
      controller: 'financeDetailCtrl',
      activetab: 'financedetail',
      parent: 'finance.css',
      id: 1
    })
    .when('/finance/companies', {
      templateUrl: 'views/finance/companies.html',
      controller: 'financeCompanyCtrl',
      activetab: 'financecompanies',
      parent: 'finance.css',
      id: 1
    })
    .when('/health', {
      templateUrl: 'views/health/main.html',
      controller: 'healthMainCtrl',
      activetab: 'healthhome',
      parent: 'health.css',
      id: 2
    })
    .when('/health/detail/:patientid', {
      templateUrl: 'views/health/detail.html',
      controller: 'healthDetail',
      activetab: 'healthdetail',
      parent: 'health.css',
      id: 2
    })
    .when('/health/patient/add', {
      templateUrl: 'views/health/addpatient.html',
      controller: 'healthPatient',
      activetab: 'healthPatient',
      parent: 'health.css',
      id: 2
    })
        .when('/health/patient/:patientid/edit', {
      templateUrl: 'views/health/edit.html',
      controller: 'healthEdit',
      activetab: 'healthEdit',
      parent: 'health.css',
      id: 2
    })
    .otherwise({
      redirectTo: '/health'
    });

}])
  .run(function ($rootScope, $route) {
    $rootScope.$route = $route;
    /**
     * @todo: check parameter for health or finance and update theme variable on runtime
     */

    $rootScope.me = $route;

  })

  .directive('wrapOwlcarousel', function () {
    return {
      restrict: 'E',
      link: function (scope, element, attrs) {
        scope.initCarousel = function () {
          var options = scope.$eval($(element).attr('data-options'));
          $(element).owlCarousel(options);
        }


      }
    };
  })

  .directive('owlCarouselItem', function () {

    return function (scope) {

      if (scope.$last) {
        scope.initCarousel();
      }
    }
  })

