package thread;

//利用线程分段求和
public class ThreadSum implements Runnable{
	private static Thread[] jobs = new Thread[4];
	private static int sum=0;
	private static int num=0;
	@Override
	public void run() {
		int tsum=0;
		for(int i=0;i<25;i++) {
			tsum+=++num;
		}
		sum+=tsum;
		System.out.println(tsum);
	}
	
	public static void main(String[] args) {
		try {
			for(int i=0;i<jobs.length;i++) {
				jobs[i] = new Thread(new ThreadSum());
				jobs[i].start();
				jobs[i].join();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(sum);
	}
}
