/**
 * Created by 김정수 on 2015-08-03.
 */

/*
    // data type

    // primitive data type vs. reference data type

    // literal
    // 데이터 타입이 코드로 표현되는 것.
    // javascript는 변수를 지정할 때 type을 명시하지 않아요
    // 변수를 생성(선언)할 때는 var keyword를 이용

    // primitive data type
    // 1. number
    // javascript는 정수와 실수를 구분하지 않아요
    // 내부적으로 처리될때는 실수로 변환되서 처리
    var myNum = 10.5;

    // 2. string
    // 문자열. 문자가 존재하지 않는다
    // 문자를 표현할 때는 '', ""
    var myString1 = "Hello";
    var myString2 = "Hello";

    // 3. boolean
    // true, false값이 존재
    var myboolean = true;

    // 4. undefined
    // 값이 아직 정해지지 않았어..라는 의미
    // 프로그래머가 할당하는 값이 x

    // 5. null
    // 값이 없어.
    var myTmp = null;

    // 여기서 잠깐..
    // JavaScript의 함수는 크게 2가지 종류
    // 1. 선언적 함수(우리가 알고 있는 함수)
    function myFunc() {

    }
    // 2. 익명함수(람다함수)
    var myFunc1 = function() {

    }

    // 6. Reference data type (객체)
    // 함수는 객체에요
    // field라는 용어 x => property
    // method는 그냥 method라고 표현
    // key와 value의 쌍으로 표현
    var obj = {
        myName : "홍길동",             //key : value
        myAddress : "서울",
        myInfo : function() {

        }
    };
*/

    // return data type을 명시하지 않는다
    function mySum(num1,num2) {
        var sum = num1 + num2;
        return sum;
    }

    var n1 = 100;
    var n2 = 200;

    var n3 = mySum(n1,n2);

    console.log("결과값은 : " + n3);

    // javascript code가 실행이 될때
    // 전체 코드를 한 번 스캔
    // 변수를 찾아서 메모리에 공간 확보
    // 함수를 찾아서 메모리에 함수이름과 똑같은
    // 이름의 변수를 만들어요( 함수변수 )

    // 함수의 선언과 동시에 실행이 가능!!
    (function myInfo() {
        console.log("소리없는 아우성!!");
    })();

    // 결국 함수가 어떻게 표현될 수 있냐하면
    // 변수에 저장되서 표현이 가능
    // 함수를 값으로 사용 가능
    // 일급함수(frist-class function)
