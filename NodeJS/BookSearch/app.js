
    // json 먼저 만들어서 module 사용
    // json 안에는 주석을 달지 않는다. -> json 형식
    // body-parser ->
    // express-session -> 로그인 처리

    // 1. 필요한 module require
    var http = require("http"),
        express = require("express"),
        app = express(),
        path = require("path"),
        bodyPaser = require("body-parser");                  // 클라이언트가 보내준 파일 받기

    // 2. routing module require
    var routes = require("./routes");

    // 3. 환경설정
    // view 설정
    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");   // view engine이라는 키를 가지고 ejs 라는 엔진을 이용
                                    // ejs는 html을 보여주긴 하지만 원하는 변수를 넘겨줘서 보여주는 동적파일
                                    // css는 보여주는 정적 파일 <<
                                    // html, javascript 모두 정적 파일 <<
    // 정적 파일에 대한 폴더를 설정
    // ejs가 사용하는 CSS와 JavaScript에 대한 내용을 저장
    app.use(express.static(path.join(__dirname,"public")));  // express.static(경로) : 경로 폴더를 잡아 정적폴더로
                                                             // 프로젝트 폴더 안의 public이란 폴더를

    // 4. express 설정
    app.use(bodyPaser());

    // 5. routing 적용
    app.use("/",routes);

    // 6. 서버 생성 후 기동
    http.createServer(app).listen(5000);
    console.log("도서 검색 시스템 - 5000");