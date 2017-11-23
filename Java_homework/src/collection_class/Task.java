package collection_class;

//������task
class Task {
	int taskID; //����ID
	int arrivalTime; //����ʱ��
	int serviceTime; //����ʱ��
	int startingTime; //��ʼʱ��
	int finishingTime; //���ʱ��=��ʼʱ��+����ʱ��
	int turnAroundTime; //��תʱ��=���ʱ��-�ﵽʱ��
	double weightTurnAround; //��Ȩ��תʱ��=��תʱ��/����ʱ��
	Task(int id,int atime,int stime){
		taskID = id;
		arrivalTime = atime;
		serviceTime = stime;
	}
	void startService(int time) {
		startingTime = time;
		finishingTime = startingTime + serviceTime;
		turnAroundTime = finishingTime - arrivalTime;
		weightTurnAround = (double)turnAroundTime / serviceTime;
	}
	public String toString() {
		return "id:" + taskID + " ����ʱ��:" + arrivalTime + " ��ʼʱ��:" + startingTime + 
				" ����ʱ��:" + serviceTime + " ���ʱ��:" + finishingTime +
				" ��תʱ��:" + turnAroundTime + " ��Ȩ��תʱ��:" + weightTurnAround;
	}
}
