
    // 1. 프로그램에서 필요한 module을 불러들여요
    // http server를 만들거에요
    // http는 워낙 많이 사용이 되요.. 외부 module이
    // 아니라 내장 module
    var http = require("http");

    // Webserver를 생성하고
    // 5000번 포트로 클라이언트가 접속하길 기다리는
    // 코드
    // 클라이언트가 접속했을 때 서버가 어떤 작업을
    // 해서 다시 클라이언트에게 응답을 돌려줘야 되요
    http.createServer(function(req,res) {
        res.writeHeader(200,{
           "Content-Type" : "text/html; charset=utf8"
        });   //200이라는 상태코드
        res.write("<h1>안녕하세요!!</h1>");
        res.end();
    }).listen(5000,"localhost");
    // http.createServer("클라이언트에게 보내줄 내용 처리").listen("localhost",5000);

    // console은 global scope를 가지는
    // global 객체에요
    global.myName = "홍길동";
    // JavaScript는 객체의 property나 method를
    // 동적으로 할당할 수 있어요

    console.log("파일 이름은 : " + __filename);
    console.log("서버기동 - 5000");



