var arr = [1, 2, 3, 4, 5, 6, 7];

var sum = 0;

for(var i = 0; i < arr.length; i++){
    sum+=arr[i];    
}

var avg = sum / arr.length;

console.log('총합은' + sum + '입니다.');
console.log('평균은 ' + avg + '입니다.');

