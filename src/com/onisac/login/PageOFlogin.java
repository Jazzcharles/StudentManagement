package com.onisac.login;
import com.onisac.mysql.operator.DBoperator;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class PageOFlogin {
	public static void ShowPageOFlogin(){
		JFrame frame = new JFrame("ѧ������ϵͳ");
		Container c = frame.getContentPane();
		JTextField username = new JTextField();
		JPasswordField password = new JPasswordField();
		JButton ok = new JButton("ȷ��");
		JButton cancel = new JButton("ȡ��");
		JButton register = new JButton("ע��");
		frame.setSize(300,200);
		c.setLayout(new BorderLayout());
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setResizable(false);
		//����
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("ϵͳ��¼"));
		c.add(titlePanel,"North");

		//�в���
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel a1 = new JLabel("�û���:");
		a1.setBounds(50,20,50,20);
		
		JLabel a2 = new JLabel("��  ��:");
		a2.setBounds(50,60,50,20);
		fieldPanel.add(a1);
		fieldPanel.add(a2);
		username.setBounds(110,20,120,20);
		
		password.setBounds(110,60,120,20);
		fieldPanel.add(username);
		fieldPanel.add(password);
		c.add(fieldPanel,"Center");

		//�ײ���ť
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_okButton_actionPerformed(e);
			}
			private void do_okButton_actionPerformed(ActionEvent e){
				String UserName = new String(username.getText());
				String PassWord = new String(password.getPassword());
				//System.out.println(UserName + "hello" + PassWord);
				if(UserName.isEmpty() || PassWord.isEmpty()){
					JOptionPane.showMessageDialog(null, "�˺Ż����벻��Ϊ�գ�");
					return;
				}
				String CheckAnswer = new String (DBoperator.Check(UserName,PassWord));
				if(CheckAnswer.equals("null")){
					JOptionPane.showMessageDialog(null, "�˺Ż��������");
				}else {
					recent_user.user = UserName;
					recent_user.password = PassWord;
					if(CheckAnswer.equals("student")){
						frame.dispose();
						PageOfStudent.showPageOfStrudent();
					}else{
						frame.dispose();
						PageOfTeacher.showPageOfTeacher();
					}
				}
			}
		});
		cancel.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_cancelButton_actionPerformed(e);
			}
			private void do_cancelButton_actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		register.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_registerButton_actionPerformed(e);
			}
			private void do_registerButton_actionPerformed(ActionEvent e){
				frame.dispose();
				ShowRegisterFrame();
			}
		});
		buttonPanel.add(ok);
		buttonPanel.add(cancel);
		buttonPanel.add(register);
		c.add(buttonPanel,"South");
		frame.setLocation(com.onisac.login.SwingUtil.centreContainer(frame.getSize()));
		frame.setVisible(true);
	}	
	private static void ShowRegisterFrame() {
		JFrame frame = new JFrame("ѧ������ϵͳ");
		JFrame frameOfRegister = new JFrame("ע��");
		JTextField usernameOfRegister = new JTextField();
		JPasswordField passwordOfRegister = new JPasswordField();
		JPasswordField password2OfRegister = new JPasswordField();
		JTextField emailOfRegister = new JTextField();
		JTextField priorityOfRegister = new JTextField();
		JButton okOfRegister = new JButton("ȷ��");
		JButton cancelOfRegister = new JButton("ȡ��");
		frame.setVisible(false);
		frameOfRegister.setSize(300,320);
		frameOfRegister.setResizable(false);
		Container a = frameOfRegister.getContentPane();
		a.setLayout(new BorderLayout());
		frameOfRegister.setLocation(com.onisac.login.SwingUtil.centreContainer(frameOfRegister.getSize()));
		//frame.setVisible(true);
		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new FlowLayout());
		titlePanel.add(new JLabel("�û�ע��"));
		a.add(titlePanel,"North");

		//�в���
		JPanel fieldPanel = new JPanel();
		fieldPanel.setLayout(null);
		JLabel a1 = new JLabel("�û���:");
		a1.setBounds(50,20,50,20);
		
		JLabel a2 = new JLabel("��  ��:");
		a2.setBounds(50,60,50,20);
		
		JLabel a3 = new JLabel("�ظ�����:");
		a3.setBounds(50,100,60,20);
		
		JLabel a4 = new JLabel("��  ��:");
		a4.setBounds(50,140,50,20);
		
		JLabel a5 = new JLabel("��  ��:");
		a5.setBounds(50,180,50,20);
		fieldPanel.add(a1);
		fieldPanel.add(a2);
		fieldPanel.add(a3);
		fieldPanel.add(a4);
		fieldPanel.add(a5);
		
		usernameOfRegister.setBounds(110,20,120,20);
		usernameOfRegister.setText("ѧ������ѧ��ע��");
		passwordOfRegister.setBounds(110,60,120,20);
		password2OfRegister.setBounds(110,100,120,20);
		emailOfRegister.setBounds(110,140,120,20);
		priorityOfRegister.setBounds(110,180,120,20);
		priorityOfRegister.setText("'student' or 'teacher'");
		fieldPanel.add(usernameOfRegister);
		fieldPanel.add(passwordOfRegister);
		fieldPanel.add(password2OfRegister);
		fieldPanel.add(emailOfRegister);
		fieldPanel.add(priorityOfRegister);
		a.add(fieldPanel,"Center");
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new FlowLayout());
		
		okOfRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_okButton_Regiester_actionPerformed(e);
			}

			private void do_okButton_Regiester_actionPerformed(ActionEvent e) {
				String U = new String(usernameOfRegister.getText());
				String P = new String(passwordOfRegister.getPassword());
				String P2 = new String(password2OfRegister.getPassword());
				String E = new String(emailOfRegister.getText());
				String S = new String(priorityOfRegister.getText());
				if(U.isEmpty() || P.isEmpty() || P2.isEmpty() || 
						E.isEmpty() || S.isEmpty()){
					JOptionPane.showMessageDialog(null, "������Ŀ����Ϊ�գ�");
				}
				else if(!P.equals(P2)){
					JOptionPane.showMessageDialog(null, "�������벻ͬ�����������룡");
				}
				else if(!S.equals("student") && !S.equals("teacher")){
					JOptionPane.showMessageDialog(null, "���ֻ���student�����ߡ�teacher����");
				}
				else{
					DBoperator.add(U,P,E,S);
					JOptionPane.showMessageDialog(null, "ע��ɹ���");
					frameOfRegister.dispose();
					ShowPageOFlogin();
				}
			}
		});
		cancelOfRegister.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				do_cancelButton_Register_actionPerformed(e);
			}
			private void do_cancelButton_Register_actionPerformed(ActionEvent e) {
				frameOfRegister.dispose();
				ShowPageOFlogin();
			}
		});
		
		buttonPanel.add(okOfRegister);
		buttonPanel.add(cancelOfRegister);
		a.add(buttonPanel,"South");
		
		frameOfRegister.setVisible(true);
	}
}

