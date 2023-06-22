
function printInfo(str){ // 함수 선언
    var input = prompt('단어를 입력하세요.');
    
    if(input == 'apple'){
        console.log('사과');
    }
    else if(input == 'banana'){
        console.log('바나나');
    }
    else {
        console.log('등록되지 않은 단어입니다...');
    }
}

for(var i = 0; i < 3; i++){

    var input = prompt('단어를 입력하세요.');
    
    printInfo(input); // 함수 호출 -> 재사용성 증가 -> 유지보수 용이

}