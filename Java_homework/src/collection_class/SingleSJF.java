package collection_class;

import java.io.IOException;

//������SJF
public class SingleSJF {
	private Task[] task;
	int time;//������ʱ��
	boolean[] isServ;//�����Ƿ񱻷����
	
	
	public SingleSJF(int[][] data) {
		task = new Task[data.length];
		isServ = new boolean[data.length];
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,����ʱ�䣬����ʱ��
		}
	}
	
	public void startService() {
		int min = 0;//�����ҵ�������
		int lmin = min;//��Ƕ�����ǰ��δ������������
		for(int N=0;N<task.length;N++) {
			for(int i=lmin;i<task.length;i++) {//�ҵ�������ǰ����ѵ�������
				if(isServ[i]==false) {
					min=i;
					break;
				}
			}
			lmin = min;//��ǣ��´β���ʱ���ô�ͷ��ʼ
			for(int i=min+1;i<task.length&&i<=time;i++) {//�ҵ��ѵ����������������
				if(isServ[i]==true) {continue;}
				if(task[min].serviceTime>task[i].serviceTime) {min=i;}
			}			
			if(time<=task[min].arrivalTime) {//���֮ǰ�������ʱ��С�����񵽴�ʱ�䣨������У�
				task[min].startService(task[min].arrivalTime);//���񵽴Ｔ��ʼ����
				time=task[min].arrivalTime+task[min].serviceTime;//�������ʱ��������񵽴�ʱ��+����ʱ��
			} else {
				task[min].startService(time);//������֮ǰ������ɺ�ſ�ʼ����
				time+=task[min].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			}
			isServ[min]=true;//����������Ϊ�ѷ���
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
		SingleSJF sSJF = new SingleSJF(data);//������Ը��ĳ�SingleSJf,SingleFCFS,DoubleSJF,DoubleFCFS
		sSJF.startService();//��ʼ����
		Task[] task=sSJF.getTask();//ȡ����������
		IOData.outputData(task,"outputData.txt");//������������ļ�
		for(int i=0;i<task.length;i++) {
			System.out.println(task[i]);
		}
	}
}
