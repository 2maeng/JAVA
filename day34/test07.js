function Car(name){
    this.name = name;
    this.printInfo = function(){
        console.log('차의 주인은 ' + this.name + '님 입니다.');
    }
}

var car1 = new Car('김임형');
var car2 = new Car('니똥칼라파워');

console.log(car1, car2);
console.log(car2.name);
car2.printInfo();