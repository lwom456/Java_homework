package fourth_class;
//双队列FCFS
public class DoubleFCFS {
	private Task[] task;
	private int N;//当前任务计数
	private int time1;//队列1
	private int time2;//队列2
	
	/**
	 * @param
	 * int n 任务数量n
	 * int data 输入数据data[][3]
	 * */
	public DoubleFCFS(int[][] data){
		int n = data.length;
		task = new Task[n];
		N=0;//初始化计数器
		time1=0;//初始化计时器
		time2=0;
		//创建task对象
		for(int i=0;i<n;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,到达时间，服务时间
		}
	}
	public void startService() {
		for(;N<task.length;N++) {
			if(time1<=task[N].arrivalTime) {//如果之前队列1完成时间小于任务到达时间（服务空闲）
				task[N].startService(task[N].arrivalTime);//任务到达即开始服务
				time1=task[N].arrivalTime+task[N].serviceTime;//队列1完成时间等于任务到达时间+服务时间
			} else if(time2<=task[N].arrivalTime) {//如果之前队列2完成时间小于任务到达时间（服务空闲）
				task[N].startService(task[N].arrivalTime);//任务到达即开始服务
				time2=task[N].arrivalTime+task[N].serviceTime;//队列2完成时间等于任务到达时间+服务时间
			} else if(time1<time2){//1队列比2队列更早完成任务
				task[N].startService(time1);//任务在之前任务完成后才开始服务
				time1+=task[N].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			} else {//2队列比1队列更早完成任务
				task[N].startService(time2);//任务在之前任务完成后才开始服务
				time2+=task[N].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			}
		}
	}
	//返回Task对象
	public Task[] getTask() {
		return task;
	}
}
