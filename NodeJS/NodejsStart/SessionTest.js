
    var http = require("http"),
        express = require("express"),
        app = express(),
        session = require("express-session"),
        path = require("path");

    app.set("views",path.join(__dirname,"views"));
    app.set("view engine","ejs");

    app.use(session({ secret : "호호호호호(session secret)" }));  // secret - signed쿠키를 만들 base key

    app.get("/setSession",function(req,res) {
        req.session.myName = "홍길동(session.myName)";
        res.render("setSession");
    });

    app.get("/getSession",function(req,res) {
        var name = req.session.myName;
        if( name ) {
            res.render("getSession",{
                name : name
            });
        } else {
            res.render("error");
        }
    });

    http.createServer(app).listen(5000,"localhost");
    console.log("session Test - 5000");