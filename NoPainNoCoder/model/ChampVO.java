package model;

public class ChampVO {

	// 변수
	private int num;
	private String name;
	private int line;
	private int tier;
	private int winCnt;
	private int pickCnt;
	private String select;
	
	// 생성자
	public ChampVO(int num) { // 단일 객체 정보 검색, 객체 정보 삭제
		this(num, null, 0, 0, 0, 0);
	}
	public ChampVO(String name, int line) { // DB 저장(티어 디폴트값)
		this(0, name, line, 0, 0, 0);
	}
	public ChampVO(String name, int line, int tier) { // DB 저장, 다중 객체 정보 검색
		this(0, name, line, tier, 0, 0);
	}
	public ChampVO(int num, String name, int line, int tier, int winCnt, int pickCnt) { // DB에서 정보 받아오기, 객체 정보 변경
		this.num = num;
		this.name = name;
		this.line = line;
		this.tier = tier;
		this.winCnt = winCnt;
		this.pickCnt = pickCnt;
		this.select = "";
	}

	// ======================================================================== getter,setter

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLine() {
		return line;
	}

	public void setLine(int line) {
		this.line = line;
	}

	public int getTier() {
		return tier;
	}

	public void setTier(int tier) {
		this.tier = tier;
	}

	public int getWinCnt() {
		return winCnt;
	}

	public void setWinCnt(int winCnt) {
		this.winCnt = winCnt;
	}

	public int getPickCnt() {
		return pickCnt;
	}

	public void setPickCnt(int pickCnt) {
		this.pickCnt = pickCnt;
	}

	public String getSelect() {
		return select;
	}

	public void setSelect(String select) {
		this.select = select;
	}

}
