
    // 1. 필요한 module require
    var http = require("http");

    //http.createServer() // 웹서버 객체를 만듬
    //.listen             // 메소드 호출
    // 요청을 받기위한 객체 req
    // 응답을 주기위한 객체 res
    http.createServer(function(req,res) {
        // 1. 클라이언트의 request를 분석해요
        // 2. 로직처리해요!!
        // 3. response를 보내요!
        res.writeHeader(200, {      // 상태코드값. 키 값이 정해져 있다. 200 = ok, 404 = 요청한 거 없어, 500 = ... 등등
            "Content-Type" : "text/html; charset=utf8"
        });
        res.write("<h1>이것은 소리없는 아우성!</h1>");
        res.end();
    }).listen(5000,"localhost");
    console.log("서버실행 - 5000");

    // 클라이언트( Web browser ) 가 접속
    // 접속할 때
    // 클라이언트가 여러가지 데이터를 같이 보내요
    // 내가 사용하는 browser는 어떤거야~
    // 서버로 전송하는 데이터는 무엇인지?
    // 전송방식은 어떤 전송방식인지~~
    // request를 보내요!!
