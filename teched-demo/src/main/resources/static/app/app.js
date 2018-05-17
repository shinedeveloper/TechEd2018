var app = angular.module('myApp', ['ngRoute']);
app.factory("services", ['$http', function ($http) {
    var serviceBase = 'services/';
    var obj = {};
    obj.getAllFilms = function () {
        return $http.get(serviceBase + 'films/all');
    };

    obj.getFilm = function (filmID) {
        return $http.get(serviceBase + 'films/' + filmID);
    };

    obj.insertFilm = function (film) {
        return $http.post(serviceBase + 'films/new', film).then(function (results) {
            return results.data;
        });
    };

    obj.updateFilm = function (id, film) {
        return $http.put(serviceBase + 'films/' + id, film).then(function (status) {
            return status.data;
        });
    };

    obj.deleteFilm = function (id) {
        return $http.delete(serviceBase + 'films/' + id + "/" + 1).then(function (status) {
            return status.data;
        });
    };

    return obj;
}]);

app.controller('listCtrl', function ($scope, services) {
    services.getAllFilms().then(function (data) {
        $scope.films = data.data;
    });
});

app.controller('editCtrl', function ($scope, $rootScope, $location, $routeParams, services, film) {
    var filmID = ($routeParams.filmID) ? parseInt($routeParams.filmID) : null;
    $rootScope.title = (filmID != null) ? 'Edit Film' : 'Add Film';
    $scope.buttonText = (filmID != null) ? 'Update Film' : 'Add New Film';
    var original = film.data;
    original._id = filmID;
    $scope.film = angular.copy(original);
    $scope.film._id = filmID;

    $scope.isClean = function () {
        return angular.equals(original, $scope.film);
    };

    $scope.deleteFilm = function (film) {
        $location.path('/');
        if (confirm("Are you sure to delete film number: " + $scope.film._id) == true)
            services.deleteFilm(film.filmNumber);
    };

    $scope.saveFilm = function (film) {
        $location.path('/');
        if (filmID === null) {
            services.insertFilm(film);
        } else {
            services.updateFilm(filmID, film);
        }
    };
});

app.config(['$routeProvider',
    function ($routeProvider) {
        $routeProvider.when('/films/all', {
            title: 'Films',
            templateUrl: 'partials/films/all.html',
            controller: 'listCtrl'
        })
        .when('/films/new', {
            title: 'Add a film',
            templateUrl: 'partials/films/edit.html',
            controller: 'editCtrl',
            resolve: {
                film: function (services, $route) {
                    return { data: {} };
                }
            }
        })
        .when('/films/:filmID', {
            title: 'Edit Films',
            templateUrl: 'partials/films/edit.html',
            controller: 'editCtrl',
            resolve: {
                film: function (services, $route) {
                    var filmID = $route.current.params.filmID;
                    return services.getFilm(filmID);
                }
            }
        })
        .otherwise({
            redirectTo: '/films/all'
        });
    }]);
app.run(['$location', '$rootScope', function ($location, $rootScope) {
    $rootScope.$on('$routeChangeSuccess', function (event, current, previous) {
        $rootScope.title = current.$$route.title;
    });
}]);