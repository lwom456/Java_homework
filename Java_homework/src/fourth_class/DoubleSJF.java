package fourth_class;

//单队列SJF
public class DoubleSJF {
	private Task[] task;
	int time1;//服务总时间
	int time2;
	boolean[] isServ;//任务是否被服务过
	
	
	public DoubleSJF(int[][] data) {
		task = new Task[data.length];
		isServ = new boolean[data.length];
		for(int i=0;i<data.length;i++) {
			task[i] = new Task(data[i][0],data[i][1],data[i][2]);//id,到达时间，服务时间
		}
	}
	
	public void startService() {
		int min = 0;//最短作业所在序号
		int lmin = min;//标记队列最前方未服务任务的序号
		for(int N=0;N<task.length;N++) {
			for(int i=lmin;i<task.length;i++) {//找到队列最前面的已到达任务
				if(isServ[i]==false) {
					min=i;
					break;
				}
			}
			lmin = min;//标记，下次查找时不用从头开始
			for(int i=min+1;i<task.length&&i<=time1&&i<=time2;i++) {//找到已到达任务中最短任务
				if(isServ[i]==true) {continue;}
				if(task[min].serviceTime>task[i].serviceTime) {min=i;}
			}
			if(time1<=task[min].arrivalTime) {//如果之前队列1完成时间小于任务到达时间（服务空闲）
				task[min].startService(task[min].arrivalTime);//任务到达即开始服务
				time1=task[min].arrivalTime+task[min].serviceTime;//队列1完成时间等于任务到达时间+服务时间
			} else if(time2<=task[min].arrivalTime) {//如果之前队列2完成时间小于任务到达时间（服务空闲）
				task[min].startService(task[min].arrivalTime);//任务到达即开始服务
				time2=task[min].arrivalTime+task[min].serviceTime;//队列2完成时间等于任务到达时间+服务时间
			} else if(time1<time2){//1队列比2队列更早完成任务
				task[min].startService(time1);//任务在之前任务完成后才开始服务
				time1+=task[min].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			} else {//2队列比1队列更早完成任务
				task[min].startService(time2);//任务在之前任务完成后才开始服务
				time2+=task[min].serviceTime;//任务完成时间等于之前任务完成时间+服务时间
			}
			isServ[min]=true;//将该任务标记为已服务
		}
	}
	//返回Task对象
		public Task[] getTask() {
			return task;
		}
}
