

    // 우리 프로그램이 종료되면
    // "exit"라는 이벤트가 process에서 발생
    // global object인 process객체에서 event가 발생

    // global object 중에 setTimeout()이라는게 있어요!!
    // 일정시간 뒤에 특정 함수를 호출해주는 함수

    setTimeout(function() {
        console.log("3초뒤에 실행됬어요!!");
    },3000);

    // 프로그램이( process ) 가 종료되는 이벤트를 잡으려
    // 해요!!
    process.on("exit",function() {
        console.log("프로세스 종료!!");
    })
    console.log("프로그램 종료!!");