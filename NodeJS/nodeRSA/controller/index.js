
    exports.loginForm = function(req,res) {
        res.render("loginForm",{
            publicKey : global.pubkey
        });
    };

    exports.loginProcess = function(req,res) {

        // 1. 암호화된 ID, PW를 받아요
        var id = req.body.uId;
        var pw = req.body.uPw;

        console.log("Id : " + id);
        console.log("Pw : " + pw);

        var key = global.mykey;
        var realId = key.decrypt(id);
        var realPw = key.decrypt(pw);

        console.log("RealId : " + realId);
        console.log("RealPw : " + realPw);

    };