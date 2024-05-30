/**
 * for.html 에 포함
 */

 const result = document.getElementById('result');
 
 
 // result 요소에 추가할 html 코드를 저장하기 위한 문자열 변수:
 let html = '';
 
 for (let x = 0; x<10 ; x++ ){
    html += `2 x ${x} = ${2 * x} <br/>`; //자바스크립트 `` 
 }
 result.innerHTML += html;
 
 result.innerHTML += '<hr/>';
 
 for (let x  = 3; x < 10; x ++){
    for(let y = 0; y < 10 ; y++){
        html += `${x} x ${y} = ${x * y} <br/>`;
        
    }
    
 }
 result.innerHTML += html;
 //result에 구구단 3단 ~ 9단까지 덧붙임 (append).
 html = '';
 //break를 사용해서 2단은 2x2까지, 3단은 3x3까지, 9x9까지 출력
 for (let x  = 0; x < 10; x ++){
    for(let y = 0; y < 10 ; y++){
        if(x>=y){
        html += `${x} x ${y} = ${x * y} <br/>`;
        }
        else break;
        
    }
    
 }
 result.innerHTML += html;
 
  