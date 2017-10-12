package second_class;

public class Sington {
	private boolean empty;
	private boolean boiled;
	private static Sington c;
	private Sington() {}
	public static Sington getInstance() {
		if(c == null) {
			c = new Sington();
			return c;
		}
		return c;
	}
	/**
	 * 向锅炉填满巧克力和牛奶的混合物。首先要判断锅炉是否为空，只有空的锅炉才能填充巧克力和牛奶（填充过程打印一条语句即可）。
	 * 填充之后empty为false
	 * */
	public void full() {
		if(empty==false) {
			empty=true;
			System.out.println("正在填充巧克力和牛奶的混合物...");
		}
		else {
			System.out.println("锅炉中已经存放了物体，不能再加了！");
		}
	}
	/**
	 * 将炉内煮沸。首先判断标志位，只有锅炉是满的，并且没有煮过，才能进行该操作（煮沸操作打印一条语句即可）。
	 * 煮沸后boiled标志位设置为true。
	 * */
	public void boil() {
		if(empty==true) {
			if(boiled==false) {
				boiled=true;
				System.out.println("正在煮巧克力牛奶...");
			} else {
				System.out.println("已经有东西在煮了!");
			}
		} else {
			System.out.println("锅里还没有填充原料！");
		}
	}
	/**
	 * 排出煮沸的巧克力和牛奶。首先要进行标志位判断，只有锅炉是满的，并且锅炉已经煮沸之后，
	 * 才能排出混合物（排出混合物的动作打印一条语句即可），排出混合物之后设置empty为true。
	 * */
	public void drain() {
		if(empty==true) {
			if(boiled==true) {
				boiled=false;
				empty=false;
				System.out.println("正在倒出煮沸的巧克力牛奶...");
			} else {
				System.out.println("巧克力牛奶还没开始煮！");
			}
		} else {
			System.out.println("这个锅还是空的！");
		}
	}
	public boolean isEmpty() {return empty;}
	public boolean isBolied() {return boiled;}
	
	//测试用例
	public static void main(String args[]) {
		Sington cb = Sington.getInstance();
		cb.full();
		cb.boil();
		cb.drain();
	}
}