
    // module require
    var http = require("http"),
        express = require("express"),
        app = express(),
        path = require("path"),
        bodyPaser = require("body-parser");                  // 클라이언트가 보내준 파일 받기

    // routing module require
    var routes = require("./routes");

    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");
    // 정적 파일에 대한 폴더를 설정
    // ejs가 사용하는 CSS와 JavaScript에 대한 내용을 저장
    app.use(express.static(path.join(__dirname,"public")));  // express.static(경로)

    app.use(bodyPaser());

    app.use("/",routes);

    // 서버 생성 후 기동
    http.createServer(app).listen(5020);
    console.log("STACK Team - 5020");