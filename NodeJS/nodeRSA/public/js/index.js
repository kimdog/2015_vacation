
    // client side javascript

    // static폴더로 지정했다. views의 loginForm.ejs에서 script하였기 때문에
    // 이 js안의 함수를 ejs에서 사용가능 즉, 클라이언트 쪽에서 사용 가능

    // 사용자가 입력한 id,pw를 가져와서
    // 암호화 시킨 후 서버로 전송!!
    // jQuery를 사용해서 ( 사용자가 입력한 id,pw를 가져와서 )
    // 암호화를 위한 Library를 이용해서 암호화 진행

    function sendData() {

        // 1. 암호화를 시키기 위한 key객체를 생성
        var keyObject = new JSEncrypt();
        // 2. 얻어낸 key객체에 공개키를 설정
        // 클라이언트에게 전달된 공개키값을 jQuery로 알아와요
        var publickey = $("#pkey").val();  // jQuery는 $으로 시작하고 #은 id를 의미, pkey라는 id의 val(ue)값을 땡겨와라
        keyObject.setPublicKey(publickey);
        // 3. 사용자가 입력한 ID와 PW를 알아와요
        var id = $("#uId").val();
        var pw = $("#uPw").val();

        // 4. 암호화 진행
        var enId = keyObject.encrypt(id);
        var enPw = keyObject.encrypt(pw);

        // 5. 암호화된 값으로 form setting
        $("#uId").val(enId);        // #uId를 찾아서 암호화된 enId로 바꿔라
        $("#uPw").val(enPw);        // #uPw를 찾아서 암호화된 enPw로 바꿔라

        // 6. 서버로 전송
        $("form").submit();

    }