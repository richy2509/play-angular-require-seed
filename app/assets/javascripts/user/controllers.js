/**
 * User controllers.
 */
define([], function () {
    'use strict';

    var LoginCtrl = function ($scope, $location, userService) {
        $scope.credentials = {};
        $scope.error = '';

        $scope.login = function (credentials) {
            if (userService.validated(credentials)) {
                userService.loginUser(credentials).then(function (/*user*/) {
                    $location.path('/dashboard');
                });
            } else {
                $scope.error = "Le mot de passe n'est pas assez long";
            }
        };

        $scope.change = function(){
            $scope.error = "";
        }
    };
    LoginCtrl.$inject = ['$scope', '$location', 'userService'];

    return {
        LoginCtrl: LoginCtrl
    };

});
