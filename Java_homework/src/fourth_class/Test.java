package fourth_class;

import java.io.IOException;

//���Գ���
public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		IOData.makeTestFile(N,"testData.txt");//����������ݵ��ļ�������ΪN
		int[][] data=IOData.inputData("testData.txt",N);//���ļ��ж�ȡ����
		SingleSJF sFCFS = new SingleSJF(data);
		sFCFS.startService();//��ʼ����
		Task[] task=sFCFS.getTask();//ȥ����������
		IOData.outputData(task,"outputData.txt");//������������ļ�
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}

}
