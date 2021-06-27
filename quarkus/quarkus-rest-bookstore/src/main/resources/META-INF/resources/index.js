var app = angular.module("BookManagement", []);

app.controller("BookManagementController", function ($scope, $http) {

  $scope.books = [];

  $scope.form = {
    id: -1,
    code: "",
    title: "",
    author: "",
    description: ""
  };

  /* load books data from server */
  _refreshPageData();

  /* HTTP POST/PUT methods for create/update book entity */
  $scope.save = function () {
    var method = "";
    var url = "";
    var data = {};

    if ($scope.form.id == -1) {
      method = "POST";
      url = '/books';
      data.code = $scope.form.code;
      data.title = $scope.form.title;
      data.author = $scope.form.author;
      data.description = $scope.form.description;
    } else {
      method = "PUT";
      url = '/books/' + $scope.form.id;
      data.code = $scope.form.code;
      data.title = $scope.form.title;
      data.author = $scope.form.author;
      data.description = $scope.form.description;
    }

    $http({
      method: method,
      url: url,
      data: angular.toJson(data),
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(_success, _error);
  };

  /* HTTP DELETE method, delete book by id */
  $scope.delete = function (book) {
    $http({
      method: 'DELETE',
      url: '/books/' + book.id
    }).then(_success, _error);
  };

  /* HTTP GET method for get all books collection */
  function _refreshPageData() {
    $http({
      method: 'GET',
      url: '/books'
    }).then(function successCallback(response) {
      $scope.books = response.data;
    }, function errorCallback(response) {
      console.log(response.statusText);
    });
  }

  function _success(response) {
    _refreshPageData();
    _clearForm();
  }

  function _error(response) {
    alert(response.data.message || response.statusText);
  }

  /* populate form with book data */
  $scope.populate = function (book) {
    $scope.form.id = book.id;
    $scope.form.code = book.code;
    $scope.form.title = book.title;
    $scope.form.author = book.author;
    $scope.form.description = book.description;
  };

  /* clear data form */
  function _clearForm() {
    $scope.form.code = "";
    $scope.form.title = "";
    $scope.form.author = "";
    $scope.form.description = "";
  }
});
