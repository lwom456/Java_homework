package first_class;

public class LeapYear {
	//判断1990-2007年那些年是闰年
	public static void main(String[] args) {
		for(int i=1990;i<=2007;i+=2) {
			//每两年换一行
			for(int j=0;j<2;j++) {
				if(isLeapYear(i+j)) { System.out.print((i+j)+"是闰年      ");}
				else {System.out.print((i+j)+"不是闰年  ");}
			}
			System.out.println();
		}
	}
	//判断是否是闰年
	public static boolean isLeapYear(int year) {
		if(year%4==0 && year%100!=0) return true;
		if(year%100==0) return true;
		return false;
	}

}
