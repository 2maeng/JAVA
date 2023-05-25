package class01;


// 포켓몬 class Pokemon
// - 이름 String name
// - 이긴횟수 int win
// - 울음소리() hello() : 각각의 포켓몬마다 고유한 소리를 출력
// - 게임()s boolean game(Pokemon pokemon)
// 			-> pokemonA.game(pokemonB);
//			   홀홀 작은값이 이김
//			   짝짝 큰값이 이김
//			   홀짝, 짝홀 홀수가 이김

// class 생성시
// 1. abstract 일까?
//	1) 이 클래스의 객체가 필요한가?
//	2) 추상 메서드가 있나? == 오버라이딩을 강제해야하는 메서드가 있나?
// 					 == 재정의 해야하는 메서드가 있나?
// 2. 멤버변수 생성
// 	1) private
//	2) getter, setter
// 3. 생성자
// 4. 메서드
//	1) 오버라이딩(재정의)을 강제 해야되나? => 추상 메서드로 만들어야 하나?
//	2) '기능'을 보고, "INPUT, OUTPUT"을 생각하여 '메서드 시그니처' 작성
abstract class Pokemon {
	private String name;
	private int win;
	
	abstract void hello();
	
	boolean game(Pokemon pokemon) { 
		if(this.win % 2 == 1 && pokemon.win % 2 ==1) {
			if(this.win <= pokemon.win){
				this.win++;
				return true;
			} else {
				pokemon.win++;
				return false;
			}
		}
		else if(this.win % 2 ==0 && pokemon.win % 2 == 0) {
			if(this.win >= pokemon.win) {
				this.win++;
				return true;
			} else {
				pokemon.win++;
				return false;
			}
		} else {
			if(this.win % 2 ==1) {
				this.win++;
				return true;
			} else {
				pokemon.win++;
				return false;
			}
		}
	}
	
	Pokemon(String name) { // 추상 클래스 생성자 소유 가능
		this.name = name;
		this.win = 0;
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
	
}

class Pika extends Pokemon {
	// 1. 메서드 안 만든거 있어 => 오버라이딩 강제되고있는 메서드(추상 메서드 구현X)
	//	=> 1. 나도 추상클래스 하던지
	//	=> 2. 추상 메서드 오버라이딩 해주던지◀
	// 2. super()를 호출하는 중이야 ~~ => 부모 클래스에게는 기본 생성자가 현재 없음
	// 	=> 1. 부모 클래스에 기본 생성자 만들던지
	//	=> 2. 부모 클래스의 다른 생성자를 사용하던지◀ 
	Pika(){
		super("피카츄");
	}

	@Override
	void hello() {
		System.out.println("피카츄 좋았쒀~");
	}

}

class Myu extends Pokemon {
	Myu(){
		super("뮤");
		this.setWin(0);
	}

	@Override
	void hello() {
		System.out.println("뮤직 큐~~");
	}

	@Override
	boolean game(Pokemon pokemon) {
		return super.game(pokemon);
	}
	
	
}
public class Test03 {

	public static void main(String[] args) {
		
	}
	
}
