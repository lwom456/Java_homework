package first_class;

public class PrintPattern {
	//����forѭ����ӡ���ͼ��
	public static void main(String args[]) {
		for(int i=1;i<=4;i++) {
			print(i);
			System.out.println();
		}
		for(int i=3;i>=1;i--) {
			print(i);
			System.out.println();
		}
	}
	
	//��ӡ����ͼ��
	public static void print(int i) {
		for(int j=1;j<=4-i;j++) {
			System.out.print(" ");
			}
			for(int j=1;j<2*i;j++) {
				System.out.print("*");
		}
	}
}
