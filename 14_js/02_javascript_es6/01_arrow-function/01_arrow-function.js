/*
  1. 콜백함수로 화살표 함수를 사용하게 되면 해당 화살표 함수가 사용하는 곳에 따라
     this의 의미가 정해진다.

     화살표 함수: 렉시컬this(화살표 함수는 자신만의 this를 가지지 않음)
                 상위 스코프에서 상속 받아 화살표 함수가 정의된 시점의 상위 스코프(showMovieList)
                 에서의 this를 의미하게 된다.
     단순 익명 함수: 자체 this의 의미가 바인딩되어 있다. 
                    콜백함수로 쓰일 때는 기본적으로 global(전역 객체) 객체를 의미하게 된다.
*/

let theater = {
    store: '강남점',
    titles: ['승부', '브리짓 존스의 일기: 뉴 챕터', '진격의 거인', '미키17', '콘클라베'],
    showMovieList() {
        this.titles.forEach(
            title => console.log(this.store + ": " + title) // 화살표 함수에 쓰인 this는 원래 대상이 없다.
        );
    }

    // showMovieList() {
    //     this.titles.forEach(
    //         function(title) {
    //             console.log(this.store + ": " + title);
    //         }
    //     );
    // }
};

theater.showMovieList();

/* 2. 화살표 함수는 new 연산자와 함께 사용할 수 없다.(생성자 함수로 쓰일 수 없다.) */
const arrowFunc = () => {};
const normalFunc = function() {
    
};

// new arrowFunc();
new normalFunc();

/* 3. 화살표 함수는 arguments를 지원하지 않는다. 
      (외부 함수의 arguments가 있다면 외부함수의 arguments가 적용됨(렉시컬 arguments))
*/

const test = () => console.log(arguments);  // this와 같이 화살표 함수의 arguments가 아닌
                                            // 상위 환경의 arguments(전역 객체의 arguments)가 나옴
test(1, 2, 3, 4, 5);

const test2 = function() {
    console.log('normal outer: ', arguments);
    const arrowFunc = () => console.log('arrow inner: ', arguments);
    arrowFunc();
};

test2(1, 2, 3, 4, 5);