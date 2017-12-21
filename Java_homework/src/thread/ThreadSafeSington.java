package thread;

public class ThreadSafeSington implements Runnable{
	private boolean empty;
	private boolean boiled;
	private static ThreadSafeSington c;
	private ThreadSafeSington() {}
	public static ThreadSafeSington getInstance() {
		if(c == null) {
			c = new ThreadSafeSington();
			return c;
		}
		return c;
	}
	/**
	 * ���¯�����ɿ�����ţ�̵Ļ�������Ҫ�жϹ�¯�Ƿ�Ϊ�գ�ֻ�пյĹ�¯��������ɿ�����ţ�̣������̴�ӡһ����伴�ɣ���
	 * ���֮��emptyΪfalse
	 * */
	public void full() {
		if(empty==false) {
			empty=true;
			System.out.println("��������ɿ�����ţ�̵Ļ����...");
		}
		else {
			System.out.println("��¯���Ѿ���������壬�����ټ��ˣ�");
		}
	}
	/**
	 * ��¯����С������жϱ�־λ��ֻ�й�¯�����ģ�����û����������ܽ��иò�������в�����ӡһ����伴�ɣ���
	 * ��к�boiled��־λ����Ϊtrue��
	 * */
	public void boil() {
		if(empty==true) {
			if(boiled==false) {
				boiled=true;
				System.out.println("�������ɿ���ţ��...");
			} else {
				System.out.println("�Ѿ��ж���������!");
			}
		} else {
			System.out.println("���ﻹû�����ԭ�ϣ�");
		}
	}
	/**
	 * �ų���е��ɿ�����ţ�̡�����Ҫ���б�־λ�жϣ�ֻ�й�¯�����ģ����ҹ�¯�Ѿ����֮��
	 * �����ų������ų������Ķ�����ӡһ����伴�ɣ����ų������֮������emptyΪtrue��
	 * */
	public void drain() {
		if(empty==true) {
			if(boiled==true) {
				boiled=false;
				empty=false;
				System.out.println("���ڵ�����е��ɿ���ţ��...");
			} else {
				System.out.println("�ɿ���ţ�̻�û��ʼ��");
			}
		} else {
			System.out.println("��������ǿյģ�");
		}
	}
	public boolean isEmpty() {return empty;}
	public boolean isBolied() {return boiled;}
	
	@Override
	public synchronized void run() {
		this.full();
		this.boil();
		this.drain();
	}
	
	//��������
		public static void main(String args[]) {
			int n = 10;
			Thread[] th = new Thread[n];
			while(--n>=0) {
				th[n]=new Thread(ThreadSafeSington.getInstance());
				th[n].start();
			}
		}
}