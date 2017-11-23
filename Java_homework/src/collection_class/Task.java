package collection_class;

//任务类task
class Task {
	int taskID; //任务ID
	int arrivalTime; //到达时间
	int serviceTime; //服务时间
	int startingTime; //开始时间
	int finishingTime; //完成时间=开始时间+服务时间
	int turnAroundTime; //周转时间=完成时间-达到时间
	double weightTurnAround; //带权周转时间=周转时间/服务时间
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
		return "id:" + taskID + " 到达时间:" + arrivalTime + " 开始时间:" + startingTime + 
				" 服务时间:" + serviceTime + " 完成时间:" + finishingTime +
				" 周转时间:" + turnAroundTime + " 带权周转时间:" + weightTurnAround;
	}
}
