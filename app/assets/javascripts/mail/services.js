/**
 * User service, exposes user model to the rest of the app.
 */
define(['angular', 'common'], function (angular) {
  'use strict';

  var mod = angular.module('mail.services', ['casper.common', 'ngCookies']);
  mod.factory('mailService', [function () {
    return {
      validated: function(){
        return true;
      }
    };
  }]);

});
