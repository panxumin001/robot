var app = angular.module('app', ['ngRoute']);
    app.config( [ '$routeProvider', function( $routeProvider ) {
       $routeProvider
       .when('/login', {
          templateUrl:'login',
          controller:'UserController'
          })
       .when('/index', {
           templateUrl: 'index' ,
           controller: 'MainController'
           })
       .otherwise({redirectTo:'/'});
    }]);

    app.factory('paramService', function(){
         var result = {};
         function getResult() {
            return this.result;
         }
         function setResult(res) {
            this.result = res;
         }
         return {
             getter: getResult,
             setter: setResult
         };
        })

    app.controller('MainController', ["$rootScope", "$scope", "$http", "$interval","paramService", function($rootScope, $scope, $http, $interval, paramService) {
        // 初始化时间
        $scope.now = new Date();
        var timer = $interval(function () {
            $scope.now = new Date();
        }, 1000);

        $scope.showInfo = function() {
            $.ajax({
                    type: "get",
                    url: "/api/gateway/robot/" + $scope.tel, // 向后端请求数据的url
                    timeout: '1800', // 2秒超时
                    success: function (data) {
//                        console.log(data);
                        if(data.status == "ok") {
                            $scope.robotData = data.result ? data.result : {};
                        } else {
                            console.log(data);
                        }
                    }
                });
        }

        // 初始化用户信息
        $scope.initUserInfo = function() {
//            $scope.userName = paramService.getter();
//            $scope.showInfo();
            document.getElementById("login_button").disabled=false;
            document.getElementById("logout_button").disabled=true;
            document.getElementById("stepAction").disabled=true;
            document.getElementById("walkAction").disabled=true;
            document.getElementById("setDownAction").disabled=true;
            document.getElementById("climbStairs").disabled=true;
            document.getElementById("confirm").disabled=true;
            document.getElementById("start").disabled=true;
            document.getElementById("stop").disabled=true;
            document.getElementById("reset").disabled=true;
            document.getElementById("connect").disabled=true;
        }
        $scope.initUserInfo();

        $scope.robotData = {};
        /**    控制命令发送   **/
        // 开始
        $scope.start = function() {
            $http({
                    url : '/api/gateway/control?controlOrder=s' ,
                    method : 'GET',
                }).then(function(result) {
                  alert(JSON.stringify(result.data));
                  if(result.data && result.data.status == "ok") {
                    // 开始按钮置灰
                    window.setInterval(function(){$scope.showInfo()},1000);

                  }
              }).catch(function(result) {
                  alert(JSON.stringify(result.data));
              });
        }
        // 停止
        $scope.stop = function() {
            $http({
                     url : '/api/gateway/control?controlOrder=e' ,
                     method : 'GET',
                }).then(function(result) {
                  alert(JSON.stringify(result.data));
                  if(result.data && result.data.status == "ok") {
                    // 停止按钮置灰

                  }
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
                   method: 'GET',
                   url: '/api/control/connect&ip='+'192.168.4.1',
                   headers: {
                       'Content-Type': 'application/json'
                   }
               })
               .then(function(data) {
                   if(data.data.status == "ok") {
                       alert(JSON.stringify(data.data));
                   } else {
                       console.log(data);
                   }
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
                url : '/api/gateway/api/robotData',
                data: id,
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

        // 登录
        $scope.login = function() {
            var mobile = $scope.tel;
            if(!mobile) {
               alert('请输入手机号码！');
               return ;
            }
            if(mobile.length!=11) {
                 alert('请输入有效的手机号码！');
                 return ;
             }
             var myreg = /^1[3|4|5|6|7|8|9][0-9]\d{4,8}$/;
             if(!myreg.test(mobile)){
                 alert('请输入有效的手机号码！');
                 return ;
             }

            $http({
                    method: 'GET',
                    url: '/api/gateway/user/userLogin?mobile=' + $scope.tel ,
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(function(data) {
                    if(data.data.status == "ok") {
//                        window.location.href='/index.html';
                        $scope.tips = "登录成功！";
                        document.getElementById("tel").disabled=true;
                        document.getElementById("login_button").disabled=true;
                        document.getElementById("logout_button").disabled=false;
                        document.getElementById("stepAction").disabled=false;
                        document.getElementById("walkAction").disabled=false;
                        document.getElementById("setDownAction").disabled=false;
                        document.getElementById("climbStairs").disabled=false;
                        document.getElementById("confirm").disabled=false;
                        document.getElementById("start").disabled=false;
                        document.getElementById("stop").disabled=false;
                        document.getElementById("reset").disabled=false;
                        document.getElementById("connect").disabled=false;
                    } else {
                        console.log(data);
                        $scope.tips = "";
                        document.getElementById("tel").disabled=false;
                        document.getElementById("login_button").disabled=false;
                        document.getElementById("logout_button").disabled=true;
                        document.getElementById("stepAction").disabled=true;
                        document.getElementById("walkAction").disabled=true;
                        document.getElementById("setDownAction").disabled=true;
                        document.getElementById("climbStairs").disabled=true;
                        document.getElementById("confirm").disabled=true;
                        document.getElementById("start").disabled=true;
                        document.getElementById("stop").disabled=true;
                        document.getElementById("reset").disabled=true;
                        document.getElementById("connect").disabled=true;
                    }
                });
        }

        // 注销
        $scope.logout = function() {
            $http({
                    method: 'GET',
                    url: '/api/gateway/user/userLogout?mobile=' + $scope.tel ,
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(function(data) {
                    if(data.data.status == "ok") {
//                        window.location.href='/index.html';
                        $scope.tel = "";
                        $scope.tips = "";
                        document.getElementById("tel").disabled=false;
                        document.getElementById("login_button").disabled=false;
                        document.getElementById("logout_button").disabled=true;
                        document.getElementById("stepAction").disabled=true;
                        document.getElementById("walkAction").disabled=true;
                        document.getElementById("setDownAction").disabled=true;
                        document.getElementById("climbStairs").disabled=true;
                        document.getElementById("confirm").disabled=true;
                        document.getElementById("start").disabled=true;
                        document.getElementById("stop").disabled=true;
                        document.getElementById("reset").disabled=true;
                        document.getElementById("connect").disabled=true;
                    } else {
                        console.log(data);
                        document.getElementById("tel").disabled=true;
                        document.getElementById("login_button").disabled=true;
                        document.getElementById("logout_button").disabled=false;
                        document.getElementById("stepAction").disabled=false;
                        document.getElementById("walkAction").disabled=false;
                        document.getElementById("setDownAction").disabled=false;
                        document.getElementById("climbStairs").disabled=false;
                        document.getElementById("confirm").disabled=false;
                        document.getElementById("start").disabled=false;
                        document.getElementById("stop").disabled=false;
                        document.getElementById("reset").disabled=false;
                        document.getElementById("connect").disabled=false;
                    }
                });
        }
    }]);

    app.controller('UserController', ["$rootScope", "$scope", "$http", "$location", "paramService", function ($rootScope, $scope, $http, $location, paramService) {

        // 登录提交的患者手机号码
        $scope.submitForm = function() {
            var mobile = $scope.tel;
            if(!mobile) {
               alert('请输入手机号码！');
               return ;
            }
            if(mobile.length!=11) {
                 alert('请输入有效的手机号码！');
                 return ;
             }
             var myreg = /^1[3|4|5|6|7|8|9][0-9]\d{4,8}$/;
             if(!myreg.test(mobile)){
                 alert('请输入有效的手机号码！');
                 return ;
             }

            $http({
                    method: 'GET',
                    url: '/api/gateway/user/userLogin?mobile=' + $scope.tel ,
                    headers: {
                        'Content-Type': 'application/json'
                    }
                })
                .then(function(data) {
                    if(data.data.status == "ok") {
//                        paramService.setter($scope.tel);
                        window.location.href='/index.html';
                    } else {
                        console.log(data);
                    }
                });
        }
     }]);
