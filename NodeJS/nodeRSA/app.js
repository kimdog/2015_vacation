
    var http = require("http"),
        express = require("express"),
        app = express(),
        path = require("path"),
        bodyParser = require("body-parser"),
        nodeRSA = require("node-rsa");

    var routes = require("./routes");

    // RSA key객체 생성
    var option = {
        encryptionScheme : {
            scheme : "pkcs1",
            hash : "md5"
        }
    };

    var key = new nodeRSA({b:1024},option); // nodeRSA는 함수일 것이다. size 512, 1024
    var publicKey = key.exportKey("pkcs8-public-pem");        // 퍼블릭키 밖으로 내보내기

    global.pubkey = publicKey;                                // global - 프로젝트 내에서 다른 파일에서도 사용가능
    global.mykey = key;

    // express 설정
    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");
    app.use(express.static(path.join(__dirname,"public")));   // public 폴더 static폴더로 지정

    app.use(bodyParser());
    app.use("/",routes);

    http.createServer(app).listen(5000,"localhost");
    console.log("서버기동 - 5000");