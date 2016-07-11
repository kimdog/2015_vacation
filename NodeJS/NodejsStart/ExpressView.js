
    // 1. 필요한 module require
    var http = require("http"),
        express = require("express"),
        app = express(),
        path = require("path");
        bodyParser = require("body-parser");


    // 2. 필요한 routing module require

    var routes = require("./routes/viewRouter");

    // 3. view setting을 express에 해줘야해요
    app.set("views",path.join(__dirname,"views"));  // __dirname(working파일) 및 views란 폴더를 views로 넘겨준다
                                                    // 이미 views << 는 정해져 있음
    app.set("view engine","ejs");                   // ejs 안에 view engine을 사용 << 는 정해져 있음

    // 4. express에 필요한 module을 설정해요!!
    app.use(bodyParser());                          // bodyParser를 실행시켰기 때문에 express에 podyParser가 결합된 형태


    app.use("/",routes);

    app.get("*",function(req,res) {
       res.render("error");
    });

    http.createServer(app).listen(5000,"localhost");

    console.log("view 서버기동 5000");
