

// 이 파일을 module로 사용하려면
// 리턴은 module.exprots객체( {} ) 가 return
//(function(exports,require,module,__filename,__dirname) {
    function myInfo() {
        console.log("홍길동이에요");
    }

    var myAge = 30;

    module.exports = function() {
        console.log("모듈의 리턴함수");
    }

    // 여러개의 값을 return 시킬 때 사용
    exports.hahaha = { myName : "홍길동" };
    exports.hohoho = 100;

    //1개의 값(객체, 함수)를 return할 때는
    module.exports

//})();


// module.exprots (리턴되는 실객체)
// exports( module.exports에 대한 reference )