package class01;

// 1. 객체끼리 값을 "공유"하는 경우
// 		static 붙여서 클래스 변수로 선언
//		this xxx
// 2. 객체들로도 배열을 만들 수 있음.
//		: 객체배열
class Game{
	String name; // 모래성 게임을 하는 사람 이름
	static int res = 100; // 공유자원 한테만 대입 연산자 쓴다. 모래성

	Game(String name){
		this.name = name;
		System.out.println(this.name + "님 참가!");
	}

	boolean game(int cnt){ // this == 자기자신 객체
		res-=cnt;
		if(res <=0 ) {
			System.out.println(this.name + "님 패배...");
			return false;
		}
		System.out.println(this.name + "님 성공! 남은모래 : " + res);
		return true;
	}
}

public class Test04 {

	public static void main(String[] args) {

		Game g1 = new Game("아리");
		Game g2 = new Game("트위치");
		Game g3 = new Game("야스오");
		Game g4 = new Game("소나");
		// 객체로 만드는 배열
		// : 객체 배열
		Game[] data = new Game[3];
		data[0] = new Game("아리");
		data[1] = new Game("트위치");
		data[2] = new Game("야스오");

		int i = 0;
		while(true) {
			
			if(!data[i++].game(5)) {
				break;
			}
			
			if(i == data.length) {
				i = 0;
			}

		}
		// 첫번째부터 마지막까지 돌아가면서
		// 순서대로 게임을 할건데,
		// 만약 패배했다면 게임종료










































	}

}
