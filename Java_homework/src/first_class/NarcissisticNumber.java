package first_class;

public class NarcissisticNumber {
	//水仙花数是三位数，它的各位数字的立方和等于这个三位数本身。
	public static void main(String args[]) {
		for(int i=100;i<=999;i++) {
			if(isNarcissisticNumber(i)) {System.out.println(i);}
		}
	}
	
	//判断是否是水仙花数
	public static boolean isNarcissisticNumber(int n) {
		if(n<100||n>999) {return false;}
		int a,b,c;//分别保存百位十位和个位数
		a=n/100%10;
		b=n/10%10;
		c=n%10;
		if((Math.pow(a, 3)+Math.pow(b,3)+Math.pow(c, 3))==n) {return true;}
		return false;
	}
}
