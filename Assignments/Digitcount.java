import java.util.Scanner;

public class Digitcount {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long num = sc.nextLong();
		int count = 0;
		while(num != 0)
		{
			num = num/10;
			count++;
		}
		System.out.println(count);

	}

}
