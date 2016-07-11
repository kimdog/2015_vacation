


    // 노드 코드를 넣어서 프로그램을 만들어요

    //(function(exports,require,module,__filename,__dirname) {  --> 생략된 코드 (under bar 두개)

        var http = require("http");
        global.myName = "홍길동";
        var test = 10;

        console.log("test의 값은 : " + test);

    //})();                                                     --> 생략된 코드

    // 모든 노드 코드는 전체 코드를 함수로 감싸고 그 함수를 실행한다.