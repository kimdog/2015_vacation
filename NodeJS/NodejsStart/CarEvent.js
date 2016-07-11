
    // 이벤트를 처리하려면 // event.EventEmitter를 상속
    // events 내부 module로 존재해여!
    // 1. 필요한 module을 require

    var events = require("events");
    var util = require("util"); // 상속구현을 위해서

    // 객체를 생성하기 위해서!!
    function Car() {
        this.carName = "sonata";
    }

    // 해당 함수로부터 객체를 생성해 낼 수 있는데
    // 해당 객체가 event를 처리하려면 당연한 말이지만
    // 함수가 event.EventEmitter를 상속

    // 함수의 상속
    util.inherits(Car,events.EventEmitter);

    // 이벤트를 처리하려면
    // 이벤트를 등록해야해요!
    // 이벤트 이름과 해당 이벤트가 발생됬을 때 처리할
    // 내용을 등록

    // handler라고 해요!! ( 이벤트가 발생하면 처리하는 함수, 메소드 )
    var forward = function(input) {
        console.log("차가 가요!!" + input);
    };

    var stop = function() {
        console.log("차가 멈춰요!!");
    };

    // 객체를 생성해 보아요 !
    var car = new Car();

    // 이벤트를 등록해보아요!!
    car.on("CAR FORWARD",forward);
    car.on("CAR STOP",stop);

    // 이벤트를 발생시켜보아요
    car.emit("CAR FORWARD","이렇게 넘겨요!");
    car.emit("CAR STOP");


