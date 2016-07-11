
    // controller
    var pool = require("../lib/_DBPool");
    var mysql = require("mysql");

    exports.userinfo = function(req,res) {

        pool.acquire(function(err,conn) {
            if(err) {
                console.log("Connection 획득에 실패");
            } else {

                var sql = "select * from users where id = ?"

                var usrid = req.body.usrid,
                    usrpw = req.body.usrpw;

                var params = [
                    usrid
                ];

                sql = mysql.format(sql,params);

                conn.query(sql,function(err,result,fields) {
                        if (err) {
                            res.render("error");
                        } else if (result[0] == null) {

                            var idfail = "id가 없습니다"
                            res.render("index", {
                                state: idfail
                            });

                        } else {

                            var rsid = result[0].id,
                                rspw = result[0].password,
                                rsname = result[0].name,
                                rsphoneNum = result[0].phoneNum,
                                rsenable = result[0].isEnable;

                            if (rsenable == "false") {

                                var disable = "접속이 허가되지 않았습니다"
                                res.render("index", {
                                    state: disable
                                });

                            } else if (usrpw == rspw) {

                                console.log("login :");
                                console.log(result);
                                res.render("userinfo", {
                                    rsid: rsid,
                                    rspw: rspw,
                                    rsname: rsname,
                                    rsphoneNum: rsphoneNum
                                });

                            } else {

                                var pwfail = "비밀번호가 일치하지 않습니다"
                                res.render("index", {
                                    state: pwfail
                                });
                            }
                        }
                    }
                );
            }
        });
    }

    exports.register = function(req,res) {
        pool.acquire(function(err,conn) {
            if(err) {
                console.log("Connection 획득에 실패");
            } else {
                var sql = "insert into users(name,phoneNum,id,password) values(?,?,?,?)";

                var usrname = req.body.usrname,
                    usrphone = req.body.usrphone,
                    usrid = req.body.usrid,
                    usrpw = req.body.usrpw;


                var params = [

                    usrname,
                    usrphone,
                    usrid,
                    usrpw

                ];

                sql = mysql.format(sql,params);

                conn.query(sql,function(err,rows,cols) {
                    if(err) {
                        console.log("Query Error : ",err);
                        conn.rollback(function () {
                            throw err;
                        });

                        res.render("error");
                    }
                    conn.commit(function(err) {
                        if(err) {
                            conn.rollback(function() {
                               throw err;
                            });
                        }

                        console.log("enrollment :");
                        console.log(usrname+","+usrphone+","+usrid+","+usrpw);

                        console.log("commit Complete!");
                    });
                    pool.release(conn);
                    //res.redirect("/register/reg_2"); redirect 하기 보다는 render 해버린다
                    res.render("register",{
                        usrname : usrname,
                        usrphone : usrphone,
                        usrid : usrid,
                        usrpw : usrpw
                    });
                });
            }
        });
    }