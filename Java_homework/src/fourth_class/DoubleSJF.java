package fourth_class;

//������SJF
public class DoubleSJF {
	private Task[] task;
	int time1;//������ʱ��
	int time2;
	boolean[] isServ;//�����Ƿ񱻷����
	
	
	public DoubleSJF(int[][] data) {
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
			for(int i=min+1;i<task.length&&i<=time1&&i<=time2;i++) {//�ҵ��ѵ����������������
				if(isServ[i]==true) {continue;}
				if(task[min].serviceTime>task[i].serviceTime) {min=i;}
			}
			if(time1<=task[min].arrivalTime) {//���֮ǰ����1���ʱ��С�����񵽴�ʱ�䣨������У�
				task[min].startService(task[min].arrivalTime);//���񵽴Ｔ��ʼ����
				time1=task[min].arrivalTime+task[min].serviceTime;//����1���ʱ��������񵽴�ʱ��+����ʱ��
			} else if(time2<=task[min].arrivalTime) {//���֮ǰ����2���ʱ��С�����񵽴�ʱ�䣨������У�
				task[min].startService(task[min].arrivalTime);//���񵽴Ｔ��ʼ����
				time2=task[min].arrivalTime+task[min].serviceTime;//����2���ʱ��������񵽴�ʱ��+����ʱ��
			} else if(time1<time2){//1���б�2���и����������
				task[min].startService(time1);//������֮ǰ������ɺ�ſ�ʼ����
				time1+=task[min].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			} else {//2���б�1���и����������
				task[min].startService(time2);//������֮ǰ������ɺ�ſ�ʼ����
				time2+=task[min].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			}
			isServ[min]=true;//����������Ϊ�ѷ���
		}
	}
	//����Task����
		public Task[] getTask() {
			return task;
		}
}
