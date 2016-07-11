
    var http = require("http"),
        express = require("express"),
        app = express();

    app.get("/",function(req,res) {
        res.redirect("http://www.naver.com");   // 특정 url을 알면 보낼 수 있다
    });

    var option = {
        root : __dirname
    };

    app.get("/send",function(req,res) {
        //res.sendFile("file.html",option);
        res.sendFile("캡처.JPG",option);       // "파일이름", option에서 찾아서 던져라
    });

    http.createServer(app).listen(5000,"localhost");
    console.log("서버실행!! - 5000");