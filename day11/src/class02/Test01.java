package class02;

class Player{
	private final static int maxIndex = 3;
	private int preIndex;
	private String name;
	Pokemon[] data;
	
	Player(){
		this.name = "지우";
		this.data = new Pokemon[maxIndex];
		this.data[0] = new Pika("피카츄");
		this.preIndex = 1;
		System.out.println("지우 두둥장");
	}
	
//	void play(Pokemon pokemon) {
//		if()
//	}
	
	void addPokemon() {
			this.data[1] = new Pika("피카츄2");
			this.data[2] = new Myu();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pokemon[] getData() {
		return data;
	}

	public void setData(Pokemon[] data) {
		this.data = data;
	}
	
}

abstract class Pokemon {
	private String name;
	private int win;
	
	Pokemon(String name){
		this.name = name;
		this.win = 0;
	}
	
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
	public boolean equals(Object obj) {
		Pokemon pokemon = (Pokemon)obj;
		if(this.getClass().isInstance(pokemon)) {
			return true;
		} else {
			return false;
		}
	}
	
	
	
}

class Pika extends Pokemon {
	
	
	Pika(String name){
		super(name);
	}

	@Override
	void hello() {
		System.out.println("짜릿해 좋와써!!");
	}
}

class Myu extends Pokemon {
	Myu(){
		super("뮤");
	}
	
	@Override
	void hello() {
		System.out.println("뮤직 큐~~");
	}
}

public class Test01 {

	public static void main(String[] args) {
		
		Player p = new Player();

		p.addPokemon();
		
		System.out.println(p.getData()[0].getName());
		System.out.println(p.getData()[1].getName());
		System.out.println(p.getData()[2].getName());
		
		if(p.getData()[0].equals(p.getData()[2])) {
			System.out.println(true);
		} else {
			System.out.println(false);
		}
	}
	
}
