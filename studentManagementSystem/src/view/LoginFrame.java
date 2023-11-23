package view;

import javax.swing.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class LoginFrame extends JFrame implements ActionListener {
	JTextField userField;
	JPasswordField passField;
	JButton loginButton;

	public LoginFrame() {
		setTitle("登录");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		JPanel panel = new JPanel();
		add(panel);
		placeComponents(panel);

		setVisible(true);
	}

	private void placeComponents(JPanel panel) {
		panel.setLayout(null);

		JLabel userLabel = new JLabel("账号:");
		userLabel.setBounds(40, 30, 80, 25);
		panel.add(userLabel);

		userField = new JTextField(20);
		userField.setBounds(120, 30, 140, 25);
		panel.add(userField);

		JLabel passLabel = new JLabel("密码:");
		passLabel.setBounds(40, 60, 80, 25);
		panel.add(passLabel);

		passField = new JPasswordField(20);
		passField.setBounds(120, 60, 140, 25);
		panel.add(passField);

		loginButton = new JButton("登录");
		loginButton.setBounds(100, 100, 100, 25);
		loginButton.addActionListener(this);
		panel.add(loginButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginButton) {
			String username = userField.getText();
			String password = String.valueOf(passField.getPassword());

			if (validateLogin(username, password)) {
				JOptionPane.showMessageDialog(this, "登录成功！");
				// 这里可以添加登录成功后的操作
			} else {
				JOptionPane.showMessageDialog(this, "登录失败，请检查账号和密码！");
			}
		}
	}

	private boolean validateLogin(String username, String password) {
		File file = new File("user_data.txt");
		if (!file.exists()) {
			JOptionPane.showMessageDialog(this, "账号密码数据文件不存在！");
			return false;
		}

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] parts = line.split(":");
				if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
					return true; // 找到匹配的账号密码
				}
			}
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(this, "读取账号密码数据文件出错：" + ex.getMessage());
		}
		return false;
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(LoginFrame::new);
	}
}
