/**
 * element.html에 포함됨
 */

 //button#btn1인 요소를 찾음:
  const btn1 = document.querySelector('button#btn1');
  
  // btn1 요소에 클릭 이벤트 리스너를 설정:
  btn1.addEventListener('click', function() {
    // document.getElementById(id) id는 id이름을 주면됨. id가 "id1"인 요소를 찾음.
    // -> 같은 아이디를 갖는 요소가 어러개 있으면 가장 먼저 찾은 요소를 리턴.
    const div1 = document.getElementById('id1');
    //document.getElementById('btn1')
    //console.log(div1);
    
    //div 요소의 바탕색을 변경:
    
    div1.style.backgroundColor = "lime";
  }); //버튼 1번에 클릭 이벤트를 넣는다. 클릭하면 function 안의 기능을 사용함
  const btn2 = document.querySelector('button#btn2');
  //button#btn2인 요소를 찾음.
  btn2.addEventListener('click', function(){
    const divs = document.getElementsByClassName('c1');
    console.log(divs);
    for (let i = 0; i < divs.length; i++) {
    divs[i].style.backgroundColor = 'tomato'; // 원하는 색상으로 변경
}
    
  })
  //button#btn3 요소 찾음:
  const btn3 = document.querySelector('button#btn3');
  
  // btn 3 에 클릭 이벤트 리스너를 설정:
  btn3.addEventListener('click', ()=>{
    //태그이름이 div인 모든 요소들을 찾아서 바탕색을 변경
    const divs = document.getElementsByTagName('div');
    console.log(divs);
    for (let i = 0; i < divs.length; i++){
        divs[i].style.backgroundColor= 'slateblue';
    }
  })
  const btn4 = document.querySelector('button#btn4');
  btn4.addEventListener('click', ()=>{
    const div4 = document.querySelector('#id4'); //querySelector('div#id4')
    div4.style.backgroundColor= 'lightgray';
  })
  
  const btn5 =  document.querySelector('button#btn5');
  btn5.addEventListener('click', ()=>{
    const divs = document.querySelectorAll('div.c2');
    console.log(divs);
    //for(let e of divs){
      //  e.style.backgroundColor = 'dodgerblue';
        
    //}
    divs.forEach((x)=>x.style.backgroundColor = 'violet');
  })
  // btn2에 클릭 이벤트 리스너를 설정.
  // 이벤트 리스너는 class 속성 값이 "c1"인 요소들의 바탕색을 변경.