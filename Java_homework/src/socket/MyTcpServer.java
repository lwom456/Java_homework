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
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class MyTcpServer extends JFrame {
	private static final long serialVersionUID = 1L;
	private BufferedReader reader;
	private PrintWriter writer;
	private ServerSocket server;
	private Socket socket;
	private JTextPane tp = new JTextPane();
	private JTextField tf = new JTextField();
	private Document doc = tp.getStyledDocument();  
	SimpleAttributeSet setBlack = new SimpleAttributeSet();
	SimpleAttributeSet setRed = new SimpleAttributeSet();
	SimpleAttributeSet setBlue = new SimpleAttributeSet();
	Container cc;
	
	public MyTcpServer(String title) {		    //���캯��
		super(title);							//UI����
		setTextColor();		//��������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//ʵ��������
		cc=this.getContentPane();
		final JScrollPane scrollPane=new JScrollPane();
		scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		scrollPane.setViewportView(tp);
		cc.add(tf, "South");					//���ı�����ڴ�����²�;
		tf.addActionListener(new ActionListener(){
			//���¼�
			@Override
			public void actionPerformed(ActionEvent e) {
				writer.println(tf.getText());//���ı����е���Ϣд����
				try {
					doc.insertString(doc.getLength(),"��:"+tf.getText()+'\n', setBlue);
				} catch (BadLocationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//���ı����е���Ϣ��ʾ���ı�����
				tf.setText("");//���ı������
			}
		});
	}
	
	public void setTextColor() {
		StyleConstants.setForeground(setRed,Color.RED);
		StyleConstants.setForeground(setBlue,Color.BLUE);
		StyleConstants.setForeground(setBlack,Color.BLACK);
	}
	
	public void getServer() {
		try {
			server = new ServerSocket(6666);	     //ʵ����Socket����
			doc.insertString(doc.getLength(),"�������׽����Ѿ������ɹ�\n", setBlack);
			while(true) {
				doc.insertString(doc.getLength(),"�ȴ��ͻ���������\n", setBlack);
				socket=server.accept();
				doc.insertString(doc.getLength(),"�ͻ���������\n", setBlack);
				reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
				writer=new PrintWriter(socket.getOutputStream(),true);
				getClientMessage();
			}
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void getClientMessage() {
		try {
			while(true) {			//����׽���������״̬
				String recv = reader.readLine();
				doc.insertString(doc.getLength(),"�ͻ���:"+recv+"\n", setRed);
			}
		} catch (IOException | BadLocationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			if(reader!=null) {		//�ر���
				reader.close();
			}
			if(socket!=null) {		//�ر��׽���
				socket.close();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		MyTcpServer server = new MyTcpServer("������");
		server.setSize(300,300);
		server.setVisible(true);
		server.getServer();
	}
}
