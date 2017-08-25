angular.module('app')
.controller("taskController", function($scope,$http,$window){



    $scope.configuration=[{

                         			"title": "Todo",
                         			"code": "todo",
                         			"permissible_transition": ["In Pr,CR Pr"],
                         			"comment": true

                         	},
                         	{

                         			"title": "In Process",
                         			"code": "In Pr",
                         			"permissible_transition": ["CR Pr"],
                         			"comment": true

                         	},
                         	{

                         			"title": "CR Progress",
                         			"code": "CR Pr",
                         			"permissible_transition": ["CR Done"],
                         			"comment": true

                         	},
                         	{

                         			"title": "CR done",
                         			"code": "CR Done",
                         			"permissible_transition": null,
                         			"comment": true

                         	}
                         ]
 var init=function(){

            $http.get("/asignee/getAsigneeList").then(function(response){

               $scope.asigneeList=response.data;
                view();

           });

        }
         init();

        function view(){
                $http.get("/task/getTaskList").then(function(response){

                  $scope.taskList=response.data;
            });
        }
      $scope.addTask=function(task){
              task.currentStatus="todo";

              $http.post("/task/add",task).then(function(response){

                     $window.alert(response.data.message);
                         $scope.show='view';
                                       view();
                 },
                  function(error) {

                          $window.alert(error.data.message);

                          });
        }

        $scope.dragstart_handler=function(event,currentStatus){
                event.dataTransfer.setData("text", event.target.id);
                var i=0;
               while(currentStatus!=configuration[i].code){
                    i++;
               }
               $scope.allowedList=configuration[i].permissible_transition;
        }

        $scope.allowDrop=function(event){

        }


});