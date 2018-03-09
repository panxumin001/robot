var app = angular.module('app', ['ngRoute']);
    app.config( [ '$routeProvider', function( $routeProvider ) {
       $routeProvider
       .when('/index', {
       url: '/index',
       templateUrl: 'index.html' ,
       controller: 'MainController'
       })
       .otherwise({redirectTo:'/'});
    }]);

    app.controller('MainController', function($rootScope, $scope, $http) {
        $scope.robotData = {};

        /**    控制命令发送   **/
        // 开始
        $scope.start = function() {
            $http({
                    url : '/api/s?state=start&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                  console.info(result);
                  alert(JSON.stringify(result.data));
              }).catch(function(result) {
                  console.info(result);
                  alert(JSON.stringify(result.data));
              });
        }
        // 停止
        $scope.stop = function() {
            $http({
                    url :'/api/s?state=stop&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               });
        }
        // 急停/复位
        $scope.reset = function() {
            $http({
                    url : '/api/s?state=reset&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               });
        }
        // 连接机器人
        $scope.connect = function() {
            $http({
                    url : '/api/s?state=connect&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               });
        }

        // 踏步
        $scope.stepAction = function() {
            $http({
                    url : '/api/s?state=step&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               });
        }
        // 步行
        $scope.walkAction = function() {
            $http({
                    url :'/api/s?state=walk&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                  alert(JSON.stringify(result.data));
               });
        }
        // 坐下
        $scope.setDownAction = function() {
            $http({
                    url : '/api/s?state=setDown&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               }).catch(function(result) {
                   console.info(result);
                   alert(JSON.stringify(result.data));
               });
        }
        // 爬楼梯
        $scope.climbStairs = function() {
            $http({
                    url : '/api/s?state=climb&ip='+'192.168.4.1',
                    method : 'GET',
                }).then(function(result) {
                    console.info(result);
                    alert(JSON.stringify(result.data));
                }).catch(function(result) {
                    console.info(result);
                    alert(JSON.stringify(result.data));
                });
        }

        // 显示数据
        $scope.getDataById = function(id) {
            $http({
                url : '/api/gateway/robot/' + id,
                method : 'POST',
            }).then(function(data) {
                robotData.leftHipAngle = data.leftHipAngle ? data.leftHipAngle : 0;
                robotData.rightHipAngle = data.rightHipAngle ? data.rightHipAngle : 0;
                robotData.leftKneeAngle = data.leftKneeAngle ? data.leftKneeAngle : 0;
                robotData.rightKneeAngle = data.rightKneeAngle ? data.rightKneeAngle : 0;
                robotData.leftToePressure = data.leftToePressure ? data.leftToePressure : 0;
                robotData.rightToePressure = data.rightToePressure ? data.rightToePressure : 0;
                robotData.leftHeelPressure = data.leftHeelPressure ? data.leftHeelPressure : 0;
                robotData.rightHeelPressure = data.rightHeelPressure ? data.rightHeelPressure : 0;
            });
        }
    });

    app.controller('UserController', function($rootScope, $scope, $http) {
            $scope.userName = "admin";
            $scope.passWord = "admin";

    });
