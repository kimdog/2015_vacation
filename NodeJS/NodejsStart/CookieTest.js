
    var http = require("http"),
        express = require("express"),
        app = express(),
        path = require("path");

    var CookieParser = require("cookie-parser");

    app.use(CookieParser("소리없는아우성사인드쿠키값"));

    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");

    app.get("/getCookie",function(req,res) {
        var name = req.signedCookies.myName;
        res.render("getCookie",{
            cookie : name
        });
    });

    app.get("/setCookie",function(req,res) {
        // 응답을 돌려줄 때 cookie를 클라이언트에게 설정해요!!
        res.cookie("myName","홍길동!!!",{ signed : true });
        res.render("setCookie");
    });

    http.createServer(app).listen(5000,"localhost");
    console.log("쿠키 서버 기동 - 5000");


