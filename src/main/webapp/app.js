var app= angular.module("app",['ui.router']);
app.config(function($stateProvider,$urlRouterProvider) {

        $stateProvider
               .state('task', {
                 url: "/task",
                 templateUrl: "task.html",
                 controller: 'taskController'
               });

               $urlRouterProvider.otherwise("/task");
   });


