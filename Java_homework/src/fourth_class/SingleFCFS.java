package fourth_class;

//������FCFS
public class SingleFCFS {
	private Task[] task;
	private int N;
	private int time;
	
	/**
	 * @param
	 * int n ��������n
	 * int data ��������data[][3]
	 * */
	public SingleFCFS(int[][] data){
		int n = data.length;
		task = new Task[n];
		N=0;//��ʼ��������
		time=0;//��ʼ����ʱ��
		//����task����
		for(int i=0;i<n;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,����ʱ�䣬����ʱ��
		}
	}
	public void startService() {
		for(;N<task.length;N++) {
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
}
