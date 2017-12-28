package socket;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTcpClient extends JFrame {
	private static final long serialVersionUID = 1L;
	private BufferedReader reader;
	private PrintWriter writer;
	private Socket socket;
	private JTextPane tp = new JTextPane();
	private Document doc = tp.getStyledDocument(); 
	private JTextField tf = new JTextField();
	SimpleAttributeSet setBlack = new SimpleAttributeSet();
	SimpleAttributeSet setRed = new SimpleAttributeSet();
	SimpleAttributeSet setBlue = new SimpleAttributeSet();
	Container cc;
	
	public MyTcpClient(String title) {		    //构造函数
		super(title);							//UI标题
		setTextColor();		//设置字体
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//实例化对象
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tp);
		cc.add(tf, "South");					//将文本框放在窗体的下部;
		tf.addActionListener(new ActionListener(){
			//绑定事件
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());//将文本框中的信息写入流
				try {
					doc.insertString(doc.getLength(),"我:"+tf.getText()+'\n', setBlue);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				tf.setText("");//将文本框清空
			}
		});
	}
	
	public void connect() {
		try {
			doc.insertString(doc.getLength(),"尝试连接\n", setBlack);
			socket = new Socket("127.0.0.1",6666);
			writer=new PrintWriter(socket.getOutputStream(),true);
			reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			doc.insertString(doc.getLength(),"完成连接\n", setBlack);
			getServerMessage();
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void setTextColor() {
		StyleConstants.setForeground(setRed,Color.RED);
		StyleConstants.setForeground(setBlue,Color.BLUE);
		StyleConstants.setForeground(setBlack,Color.BLACK);
	}
	
	private void getServerMessage() {
		try {
			while(true) {			//如果套接字是连接状态
				doc.insertString(doc.getLength(),"服务器:"+reader.readLine()+"\n", setRed);
			}
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(reader!=null) {		//关闭流
				reader.close();
			}
			if(socket!=null) {		//关闭套接字
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyTcpClient client = new MyTcpClient("客户端");
		client.setSize(300,300);
		client.setVisible(true);
		client.connect();
	}
}
