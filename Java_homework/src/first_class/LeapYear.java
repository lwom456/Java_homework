package first_class;

public class LeapYear {
	//�ж�1990-2007����Щ��������
	public static void main(String[] args) {
		for(int i=1990;i<=2007;i+=2) {
			//ÿ���껻һ��
			for(int j=0;j<2;j++) {
				if(isLeapYear(i+j)) { System.out.print((i+j)+"������      ");}
				else {System.out.print((i+j)+"��������  ");}
			}
			System.out.println();
		}
	}
	//�ж��Ƿ�������
	public static boolean isLeapYear(int year) {
		if(year%4==0 && year%100!=0) return true;
		if(year%100==0) return true;
		return false;
	}

}
