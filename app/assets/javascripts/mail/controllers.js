/**
 * User controllers.
 */
define([], function () {
    'use strict';

    var MailCtrl = function ($scope, $location, mailService) {

        $scope.submit = function () {
            if (mailService.validated()) {
                console.log("send");
            }
        };
    };

    MailCtrl.$inject = ['$scope', '$location', 'mailService'];

    return {
        MailCtrl: MailCtrl
    };

});
