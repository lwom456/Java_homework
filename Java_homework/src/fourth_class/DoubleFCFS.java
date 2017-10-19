package fourth_class;
//˫����FCFS
public class DoubleFCFS {
	private Task[] task;
	private int N;//��ǰ�������
	private int time1;//����1
	private int time2;//����2
	
	/**
	 * @param
	 * int n ��������n
	 * int data ��������data[][3]
	 * */
	public DoubleFCFS(int[][] data){
		int n = data.length;
		task = new Task[n];
		N=0;//��ʼ��������
		time1=0;//��ʼ����ʱ��
		time2=0;
		//����task����
		for(int i=0;i<n;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,����ʱ�䣬����ʱ��
		}
	}
	public void startService() {
		for(;N<task.length;N++) {
			if(time1<=task[N].arrivalTime) {//���֮ǰ����1���ʱ��С�����񵽴�ʱ�䣨������У�
				task[N].startService(task[N].arrivalTime);//���񵽴Ｔ��ʼ����
				time1=task[N].arrivalTime+task[N].serviceTime;//����1���ʱ��������񵽴�ʱ��+����ʱ��
			} else if(time2<=task[N].arrivalTime) {//���֮ǰ����2���ʱ��С�����񵽴�ʱ�䣨������У�
				task[N].startService(task[N].arrivalTime);//���񵽴Ｔ��ʼ����
				time2=task[N].arrivalTime+task[N].serviceTime;//����2���ʱ��������񵽴�ʱ��+����ʱ��
			} else if(time1<time2){//1���б�2���и����������
				task[N].startService(time1);//������֮ǰ������ɺ�ſ�ʼ����
				time1+=task[N].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			} else {//2���б�1���и����������
				task[N].startService(time2);//������֮ǰ������ɺ�ſ�ʼ����
				time2+=task[N].serviceTime;//�������ʱ�����֮ǰ�������ʱ��+����ʱ��
			}
		}
	}
	//����Task����
	public Task[] getTask() {
		return task;
	}
}
