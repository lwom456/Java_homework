package collection_class;

import java.io.IOException;

//������FCFS
public class SingleFCFS {
	private Task[] task;
	private int time;
	
	/**
	 * @param
	 * int n ��������n
	 * int data ��������data[][3]
	 * */
	public SingleFCFS(int[][] data){
		task = new Task[data.length];
		//����task����
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,����ʱ�䣬����ʱ��
		}
	}
	public void startService() {
		for(int N=0;N<task.length;N++) {
			if(time<=task[N].arrivalTime) {//���֮ǰ�������ʱ��С�����񵽴�ʱ�䣨������У�
				task[N].startService(task[N].arrivalTime);//���񵽴Ｔ��ʼ����
				time=task[N].arrivalTime+task[N].serviceTime;//�������ʱ��������񵽴�ʱ��+����ʱ��
			} else {
				task[N].startService(time);//������֮ǰ������ɺ�ſ�ʼ����
				time+=task[N].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			}
		}
	}
	//����Task����
	public Task[] getTask() {
		return task;
	}
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N =100;
		//IOData.makeTestFile(N,"testData.txt");//����������ݵ��ļ�������ΪN
		int[][] data=IOData.inputData("input.txt",N);//���ļ��ж�ȡ����
		SingleFCFS sFCFS = new SingleFCFS(data);//������Ը��ĳ�SingleSJf,SingleFCFS,DoubleSJF,DoubleFCFS
		sFCFS.startService();//��ʼ����
		Task[] task=sFCFS.getTask();//ȡ����������
		IOData.outputData(task,"outputData.txt");//������������ļ�
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}
}
