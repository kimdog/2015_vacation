
    // 1. 필요한 module require
    var http = require("http"),
        express = require("express"),
        app = express();

    // 2. Routing module을 require
    var routes = require("./routes");
    var product = require("./routes/product");

    // 3. express 설정
    app.use("*",function(req,res,next) {
        res.writeHeader(200, {
            "Content-Type" : "text/html; charset=utf8"
        });
        next();
    });                                        //use - get방식이든 post방식이든 모든 방식에 대해서
                                               //next - 다음 코드로 계속해서 진행

    app.use("/",routes);                       // "/"로 들어오면 routes가 잡아라
    app.use("/product",product);               // "/product"로 들어오면 product가 잡아라
                                               // 카테고리 별로 라우팅을 따로 잡겠다.
                                               // /product일지라도 /로 시작되기 때문에 routes에 먼저 들어간다
                                               // 따라서 routes 내부에 /product가 있다면 그 것이 실행된다


    app.get("*",function(req,res) {
        res.write(req + "<h1>페이지가 존재하지 않아요</h1>");
        res.end();
    });


    http.createServer(app).listen(5000,"localhost");

    console.log("Express 서버 기동 - 5000");