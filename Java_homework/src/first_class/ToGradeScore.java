package first_class;

import java.util.Random;

public class ToGradeScore {
	public static void main(String args[]) {
		int N = 100;//ģ�����ݴ�С
		int[] data = createData(N);//����������ȡ�������
		toGradeScore(data);
	}
	
	//���������������
	public static int[] createData(int n) {
		int[] data = new int[n];
		Random rand = new Random();
		for(int i=0;i<n;i++) {
			data[i] = rand.nextInt(100);
		}
		return data;
	}
	
	//��ֵ���ɼ�ת���ɵȼ��ɼ�
	public static void toGradeScore(int[] data) {
		for(int i=0;i<data.length;i++) {
			if(data[i]==100) {
				System.out.println("�ɼ�:"+data[i]+" �ȵڣ���");
				continue;
			}
			switch(data[i]/10%10) {
			case 9:System.out.println("�ɼ�:"+data[i]+" �ȵڣ���");break;
			case 8:System.out.println("�ɼ�:"+data[i]+" �ȵڣ���");break;
			case 7:System.out.println("�ɼ�:"+data[i]+" �ȵڣ���");break;
			case 6:System.out.println("�ɼ�:"+data[i]+" �ȵڣ�����");break;
			default:System.out.println("�ɼ�:"+data[i]+" �ȵڣ�������");break;
			}
		}
	}
}
