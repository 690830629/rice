var app = angular.module('myApp', []);
app.controller('myCtrl', function ($scope, $http) {
    $http.get("/getUserInfo").then(function (response) {
        $scope.users = response.data;
    })

});