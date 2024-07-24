/**
 * switch.html에 포함 시킬것
 */

const weekday = document.getElementById('weekday');
const btn = document.getElementById('btn');
const result = document.getElementById('result');
 
 
 function selectListener(){
    const value = weekday.value;
    switch (value){
        case 'mon':
        case 'tue':
        case 'wed':
        case 'thu':
        case 'fri':
            result.innerHTML = '학원 출석.';
            break;
        case 'sat':
        case 'sun':
            result.innerHTML = '놀러감.';        
            break;
        default:
            result.innerHTML = '몰라유';
    }
    
 }
 
 btn.addEventListener('click', selectListener); // 버튼에서 클릭에대한 이벤트가 발생하면
 //selectListener 함수가 실행 되는 것