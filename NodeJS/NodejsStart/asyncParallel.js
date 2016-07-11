
    var async = require("async");

    // 여러 개의 비동기 IO 작업을 할 때
    // 모든 처리가 완료된 후에
    // 각각의 결과를 모아서 한방에 처리하고 싶을 때
    // 배열 안에 함수, 함수, 함수, 함수 , ... 끝나면 , 이후에 마지막 함수가 싹 모아서 처리 .
    async.parallel([
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