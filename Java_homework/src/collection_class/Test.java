package collection_class;

import java.io.IOException;

//���Գ���
public class Test {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		IOData.makeTestFile(N,"testData.txt");//����������ݵ��ļ�������ΪN
		int[][] data=IOData.inputData("testData.txt",N);//���ļ��ж�ȡ����
		SingleFCFS sFCFS = new SingleFCFS(data);//������Ը��ĳ�SingleSJf,SingleFCFS,DoubleSJF,DoubleFCFS
		sFCFS.startService();//��ʼ����
		Task[] task=sFCFS.getTask();//ȡ����������
		IOData.outputData(task,"outputData.txt");//������������ļ�
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}

}
