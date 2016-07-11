/*
    // 만약에 객체를 만들어 내는 하수면
    // 관용적으로 함수이름을 대문자로 시작
    function Student() {
        this.name = null;
        this.age = null;

        this.info = function() {

        }
    }

    var stu = new Student();
*/

// global object라는게 존재
// 여기서 말하는 5가지 인자는 당연히 모든 파일에서
// 사용이 가능해요
// scope는 local scope, module scope를 가져요!



//(function(exports,require,module,__filename,__dirname) {

    // var module1 = require("kakaka");
    // 우리 project밑에 node_modules라는 폴더로 가서
    // kakaka.js를 찾아요!
    // 만약 못찾으면 kakaka라는 폴더를 찾아요, 그 폴더밑에
    // index.js를 찾아요

    var module1 = require("./moduleTest");
    // 현재 폴더 밑에서 moduleTest.js를 실행해서
    // 그 결과를 가져와!!

    console.log(module1.myName);
    module1();

    var tmp1 = 10;
    var tmp2 = 20;

    var sum = tmp1 + tmp2;

    console.log("현재 파일의 이름은 : " + __filename); // __filename이 애초에 인자이기 때문에 사용 가능
    console.log("변수의 합은 : " + sum);
//})();