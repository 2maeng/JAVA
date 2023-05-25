package class03;

import java.util.Random;

// 1. 멤버변수 2. 생성자 3. 메서드
class Player{
   private final static int maxIndex=3;
   private int preIndex;
   private Pokemon[] data;
   
   Player(){
	   this.preIndex = 0;
	   this.data = new Pokemon[maxIndex];
	   this.data[this.preIndex++] = new Pika();
   }
   
   // 기능 : 내 배열에 포켓몬 추가하기(포켓몬을 main()에서 받아온다.)
   // INPUT : 포켓몬
   // OUTPUT : X
   void addPokemon(Pokemon pokemon) {
	   this.data[this.preIndex++] = pokemon;
   }
   
   // 기능 : 내 배열에 저장된 포켓몬을 출력
   // INPUT : X
   // OUTPUT : X
   void printData() {
	   for(int i = 0; i < this.preIndex; i++) {
		   System.out.println(this.data[i]);
	   }
   }
   
   void play() {
	   Random rand = new Random();
	   int num1 = rand.nextInt(this.preIndex);
	   int num2 = rand.nextInt(this.preIndex);
	   System.out.println("num1 = " + num1 + "num2 = " + num2);
	   if(this.data[num1].equals(this.data[num2])) {
		   // ★★★★★★★★★★★★★★★★★★★★★★★★★★★★★
		   // this.data[num1]가 equals()를 수행하는 주체(주어)
		   // 타입 == 포켓몬			피카츄, 파이리, 메타몽,...
		   // 부모.메서드() 했어도, 알아서
		   // 자식이 구현한 메서드가 실행되는 현상
		   // == 동적 바인딩 -> "다형성"이 실현되었다!
		   
		   // ★ 실제 equals()를 수행하는 주체(주어)가
		   // 피카츄, 파이리, 꼬부기...
		   System.out.println("같은 포켓몬이라 종료합니다.");
		   return;
	   }
	   if(this.data[num1].game(this.data[num2])) {
		   this.data[num1].hello();
	   }else {
		   this.data[num2].hello();
	   }
   }
   
   public int getPreIndex() {
      return preIndex;
   }
   public void setPreIndex(int preIndex) {
      this.preIndex = preIndex;
   }
   public Pokemon[] getData() {
      return data;
   }
   public void setData(Pokemon[] data) {
      this.data = data;
   }
}

// class Pokemon
//  - String name
//  - int win 이긴횟수
//  - void hello() : 각각의 포켓몬마다 고유한 소리를 출력
//  - boolean game(Pokemon pokemon)
//      -> pokemonA.game(pokemonB);
//         이긴횟수가 홀홀 작은값이 이김
//         이긴횟수가 짝짝 큰값이 이김
//          동일하다면 A가 이김(A>B)
//         이긴횟수가 홀짝,짝홀 홀수가 이김

// class 생성시
// 1. abstract일까?
//    1) 이 클래스의 객체가 필요한가?
//    2) 추상메서드가 있나? == 오버라이딩을 강제해야하는 메서드가 있나?
//         == 재정의해야하는 메서드가 있나?
// 2. 멤버변수 생성
//    1) private
//    2) getter,setter
// 3. 생성자
// 4. 메서드
//    1) 오버라이딩(재정의)을 강제해야되나? => 추상메서드로 만들어야하나?
//    2) '기능'을 보고, "INPUT,OUTPUT"을 생각하여 '메서드 시그니처' 작성
abstract class Pokemon{
   private String name;
   private int win;
   Pokemon(String name){ // 추상클래스 생성가 소유 가능
      this.name=name;
      this.win=0;
   }
   abstract void hello();
   boolean game(Pokemon pokemon) { 
      if(this.win%2==1 && pokemon.win%2==1) {
         if(this.win<=pokemon.win) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }
      else if(this.win%2==0 && pokemon.win%2==0) {
         if(this.win>=pokemon.win) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }
      else {
         if(this.win%2==1) {
            this.win++;
            return true;
         }
         else {
            pokemon.win++;
            return false;
         }
      }
   }
   
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }
   public int getWin() {
      return win;
   }
   public void setWin(int win) {
      this.win = win;
   }
   
   @Override
	public String toString() {
		return this.name + "이(가) 이긴 횟수는" + this.win + "입니다.";
	}
}

class Pika extends Pokemon{
   Pika() {
      super("피카츄");
   }
   
   @Override
   void hello() {
      System.out.println("피카피카");
   }
   // 1. 메서드 안만든거 있어~~ => 오버라이딩 강제되고있는 메서드(추상메서드)
   //    => 1. 나도 추상클래스 하던지
   //       2. 추상메서드 오버라이딩 해주던지 ◀
   // 2. super()를 호출하는 중이야~~ => 부모클래스에게는 기본생성자가 현재 없음
   //    => 1. 부모클래스에 기본생성자 만들던지
   //       2. 부모클래스의 다른생성자를 사용하던지 ◀
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Pika) { // Pika와 비교하려는 obj의 클래스가 같아?
			return true;
		}
		return false;
	}
	
   
}
class Metamon extends Pokemon{
   Metamon() {
      super("메타몽");
   }
   @Override
   void hello() {
      System.out.println("˚▽˚");
   }
   
   public boolean equals(Object obj) {
		if(obj instanceof Metamon) { // Metamon와 비교하려는 obj의 클래스가 같아?
			return true;
		}
		return false;
	}
}

public class Test01 {
   public static void main(String[] args) {
      Pika pika=new Pika();
      Metamon m1=new Metamon();
      Metamon m2=new Metamon();

      pika.setWin( pika.getWin()+1 ); // == pika.win++;

      pika.game(m1);
      System.out.println(pika.getWin());
      m2.game(pika);
      System.out.println(pika.getWin());
      m1.game(pika);
      System.out.println(pika.getWin());
      m1.game(m2);
      System.out.println(m1.getWin());
      pika.game(m1);
      System.out.println(m1.getWin());


      if(pika.equals(m2)) {
         System.out.println();
      }



      System.out.println();
      System.out.println();
      System.out.println();

      // 포켓몬 추가
      // 기능이 없네? -> 메서드 정의(선언, 생성)
      // "누가"하는 기능?
      // "플레이어"가 하는 기능
      Player player = new Player();
      player.addPokemon(new Metamon());
      player.addPokemon(new Metamon());
      
      for(int i = 0; i < 10; i++) {
    	  player.play();
      }

      // 포켓몬 출력
      // "플레이어"가 하는 기능!
      player.printData();
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
   }
}