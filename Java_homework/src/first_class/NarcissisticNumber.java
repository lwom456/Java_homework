package first_class;

public class NarcissisticNumber {
	//ˮ�ɻ�������λ�������ĸ�λ���ֵ������͵��������λ������
	public static void main(String args[]) {
		for(int i=100;i<=999;i++) {
			if(isNarcissisticNumber(i)) {System.out.println(i);}
		}
	}
	
	//�ж��Ƿ���ˮ�ɻ���
	public static boolean isNarcissisticNumber(int n) {
		if(n<100||n>999) {return false;}
		int a,b,c;//�ֱ𱣴��λʮλ�͸�λ��
		a=n/100%10;
		b=n/10%10;
		c=n%10;
		if((Math.pow(a, 3)+Math.pow(b,3)+Math.pow(c, 3))==n) {return true;}
		return false;
	}
}
