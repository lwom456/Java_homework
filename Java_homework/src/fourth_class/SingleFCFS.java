package fourth_class;

//单队列FCFS
public class SingleFCFS {
	private Task[] task;
	private int time;
	
	/**
	 * @param
	 * int n 任务数量n
	 * int data 输入数据data[][3]
	 * */
	public SingleFCFS(int[][] data){
		task = new Task[data.length];
		//创建task对象
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,到达时间，服务时间
		}
	}
	public void startService() {
		for(int N=0;N<task.length;N++) {
			if(time<=task[N].arrivalTime) {//如果之前任务完成时间小于任务到达时间（服务空闲）
				task[N].startService(task[N].arrivalTime);//任务到达即开始服务
				time=task[N].arrivalTime+task[N].serviceTime;//任务完成时间等于任务到达时间+服务时间
			} else {
				task[N].startService(time);//任务在之前任务完成后才开始服务
				time+=task[N].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			}
		}
	}
	//返回Task对象
	public Task[] getTask() {
		return task;
	}
}
