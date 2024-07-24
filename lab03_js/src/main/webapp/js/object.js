/**
 * object.html에 포함. 
 */

 //JSON(JavaScript Object Notation): 자바스크립트에서 객체를 표기법.
 //{ property: value, ... }
 
 const person = {
    name : '홍길동',
    age : 16,
    phone: ['010-0000-0000' , '02-0000-0000'],
        
 };
 
 console.log(person);
 
 //객체가 가지고 있는 프로퍼티 접근 : (1) 참조 연산자, (2) 인덱스 연산자
 console.log(person.name); // 참조 연산자
 console.log(person['age']); // 인덱스 연산자 object['propertyName'];
 console.log(person.phone[0]); // person['phone'][0]) 
 
 person.age = 17; // 프로퍼티값 변경


 console.log(person);
 person.email = 'hgd@gmail.com';
 console.person ; 
 
 //메서드를 갖는 객체:
 const score = {
    html : 100,
    css: 90,
    js : 80,personsum : function () {
        
        return this.html + this.cs + this.js;
    },
    mean: function(){
        
        return this.sum() /   3;
    },
 };
 
 console.log(score);
 
 //생성자 함수 (construtor function): this 키워드를 사용해서 프로퍼티를  선언한 함수.
 
 
 function Score(html, css, li){
    return this.html + this.css + this.li 
 }
 
 //생성자 함수를 사용한 객체 생성 :new 생성잫마수();
 const score1 = new Score(1,2,3)
 console.log(score1);
 console.log(score1.sum());
 console.log(score1.mean());
 
 
 //클래스 :
 class Rectangle {
    
 }
 