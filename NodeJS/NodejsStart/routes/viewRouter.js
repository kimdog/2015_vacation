
    // 1. 필요한 module require
    var express = require("express"),
        router = express.Router();

    router.post("/",function(req,res) {
        // view 처리
        // ejs를 rendering하여 그려주기
        // res.render("welcome");

        var name = req.body.userName;       // ExpressView.js에서 bodyParser를 붙여놨기 때문에 body 사용 가능
        var age = req.body.userAge;
        res.render("welcomeWho",{
            name : name,
            age : age
        });

/*
        // get 옆에 "/" 대신 "/:uName"
        var name = req.params.uName;    // req의 params를 이용하여 uName으로 들어온 변수를 받아주기
        res.render("welcomeWho",{
            name : name
        });
*/


/*      쿼리 형식

        var name = req.query.name;
        var age = req.query.age;
        var addr = req.query.address;
        res.render("welcomeWho",{
            name : name,
            age : age,
            addr : addr
        });
*/

    });



    module.exports = router;