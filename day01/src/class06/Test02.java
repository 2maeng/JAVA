package class06;

public class Test02 {
	public static void main(String[] args) {
		
		int x = 10;
		int y;
		
		y = ++x;
		System.out.println("1. x=" + x);
		System.out.println("1. y=" + y);
		
		y = x++;
		System.out.println("2. x=" + x);
		System.out.println("2. y=" + y);

		System.out.println("3. x=" + x);
		System.out.println("3. y=" + y);
		
		int a = 10;
		int b = 20;
		int c = ++a - b--; 
		int d = a-- * ++c; 
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}
}
