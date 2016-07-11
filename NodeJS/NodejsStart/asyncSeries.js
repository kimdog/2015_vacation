
    var async = require("async");

    // 순차처리
    // 처음 함수의 결과값을 다음 함수가 받아서 처리
    async.series([
        function(callback) {
            setTimeout(function() {
                console.log("2초뒤에 실행되요!");
                callback(null,"첫번째 결과");
            },2000)
        },
        function(callback) {
            setTimeout(function() {
                console.log("3초뒤에 실행되요!");
                callback(null,"두번째 결과");
            },3000)
        }

    ],function(err,result) {
        console.log(result);
    });