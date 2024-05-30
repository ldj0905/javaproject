/**
 * array_method.html과 연결됨
 * 
 * JS array 메서드
 */

 const arr = [1,2,3];
 console.log(arr);
 
 //배열에 새로운 원소를 배열 끝에 추가:
 arr.push(100); //push(): 원본 배열의 끝에 새로운 원소를 추가. 원본 배열이 바뀌는 것.
 console.log(arr);
 let result = arr.concat(200); 
 console.log(arr);
 console.log(result);
 
 // 배열의 마지막 원소를 삭제:
 arr.pop();
 console.log(arr);
 
 result = arr.slice(0,-1);
 console.log(arr);
 console.log(result);
 
 const arr2 = [10, 100, -1,50, 90];
 //원본배열이 변경되지않는애
 result = arr2.toSorted(); // 배열의 원소들을 문자열로 변환해서 크기 비교를 함.
 //오름차순 정렬된 "새로운"배열을 리턴.
 // toSorted(callback): 배열 원소들의 크기 비교를 할 때 사용할 콜백을 아규먼트로 전달.
 console.log(arr2); //-> toSorted() 메서드는 원본 배열을 변경하지 않음!
 console.log(result); 
 
 //sort():
 // - 배열의 원소들을 문자열로 변환해서 크기 비교.
 // - 원본 배열의 원소 순서를 오름차순으로 변경. 원본 배열이 바뀜 !
 // sort(callback): 배열 원소의 크기 비교에서 사용하는 콜백을 아규먼트로 전달.
 arr2.sort((x,y )=>x - y);
 console.log(arr2);
 
 //filter,map,reduce: 
 const numbers  = [1,2,3,4,5,6];
 console.log(numbers);
 // 배열 numbers의 원소들 중에서 홀수들로만 이루어진 새로운 배열 만드세요.
 const odds = []; 
 for (let x of numbers){
    if(x % 2 ){
        odds.push(x);        
    }
 }
 console.log(odds);
 
 result = numbers.filter(function (x){
    return x % 2;
 });
 result = numbers.filter((x) => x %2);
 console.log(result);
 
 //배열  numbers의 원소들의 제곱을 원소로 갖는 새로운 배열을 만드세요.
 const squares = [];
 for (let x of numbers){
    squares.push(x * x);
 }
 console.log(squares); //A라는 원소가 있으면 그걸 B라는 원소로 다시 바꿔주는거 -> mapping
 
 result = numbers.map((x)=> x * x);
 console.log(result);
 
 numbers.forEach((x) => console.log(x));
 
 
 
 sum = numbers.reduce((acc,cur) => acc+cur,0);
 console.log(`sum = ${sum}`);
 
 //numbers의 모든 원소들의 곱 : 1x2x3x4x5x6 ..
 result = numbers.reduce((acc, cur) => acc * cur, 1);
 console.log(`result = ${result}`);
 
 //numbers의 원소들 중에서 짝수들의 합 : 2 + 4 + 6
 result = numbers.filter((x) => x % 2 === 0).reduce((acc, cur) => acc + cur);
 console.log(`짝수 합 = ${result}`); 