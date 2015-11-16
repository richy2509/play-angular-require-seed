/**
 * Configure routes of user module.
 */
define(['angular', './controllers', 'common'], function(angular, controllers) {
  'use strict';

  var mod = angular.module('mail.routes', ['mail.services', 'casper.common']);
  mod.config(['$routeProvider', function($routeProvider) {
    $routeProvider
      .when('/mail', {templateUrl:'/assets/javascripts/mail/mail.html', controller:controllers.MailCtrl});
      //.when('/users', {templateUrl:'/assets/templates/user/users.html', controller:controllers.UserCtrl})
      //.when('/users/:id', {templateUrl:'/assets/templates/user/editUser.html', controller:controllers.UserCtrl});
  }]);
  return mod;
});
