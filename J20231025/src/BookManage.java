import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;

import javax.security.auth.login.LoginContext;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class BookManage {
	static ArrayList<User>person=new ArrayList<User>();//创建一个ArrayList对象
	static ArrayList<Books>books=new ArrayList<Books>(); //创建一个String类型的ArrayList对象
	static Vector<String>listname=new Vector<String>();//创建一个String类型的Vector对象(vector是一个动态数组，可以存储任意类型的变量)
	static Vector<Vector<String>>booksVector=new Vector<Vector<String>>();
	static DefaultTableModel model=new DefaultTableModel(booksVector,listname);
	static JTable table=new JTable(model);//创建存放图书信息的表格(显示JTable组件需要用到TableModel接口，需要使用DefaultTableModel类)


	static JFrame frame=new JFrame("图书信息管理系统");
	static JLabel name=new JLabel("用户名");
	static JTextField nfield=new JTextField(10);//创建用户名输入框
	static JLabel password=new JLabel("密    码");
	static JPasswordField pfield= new JPasswordField(10);//创建密码输入框
	static JButton ok=new JButton("确认");
	static JButton canel=new JButton("取消");
	static JButton searchbt=new JButton("查询图书信息");
	static JButton editbt=new JButton("修改图书信息");
	static JButton addbt=new JButton("添加图书信息");
	static JButton deletebt=new JButton("减删图书信息");


	public static void init() {
		person.add(new User("sun", "123"));
		listname.add("类别");
		listname.add("名称");
		listname.add("编号");
		books.add(new Books("长篇小说","《三国演义》","001"));
		books.add(new Books("长篇小说","《红楼梦》","002"));
		books.add(new Books("长篇小说","《西游记》","003"));
		books.add(new Books("长篇小说","《水浒传》","004"));
		books.add(new Books("历史类","《史记》","005"));
		books.add(new Books("历史类","《资治通鉴》","006"));
		books.add(new Books("历史类","《战国史》","007"));
		books.add(new Books("自然科学类","《意识新探》","008"));
		books.add(new Books("自然科学类","《物种起源》","009"));
		books.add(new Books("自然科学类","《大脑的故事》","010"));
		books.add(new Books("艺术类","《艺术的故事》","011"));
		books.add(new Books("艺术类","《梵高手稿》","012"));
		books.add(new Books("艺术类","《现代艺术150年》","013"));


	}
	public static void main(String[] args) {
		init();//初始化用户及图书信息
		JFrame frame=new JFrame("图书信息管理系统");
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setLocation(230, 150);
		login(frame);
	}
	//登录界面设计
	public static void login(JFrame frame) {
		JPanel panel=new JPanel();
		Box box=Box.createVerticalBox();//封装box1,box2,box3
		Box box1=Box.createHorizontalBox();//创建水平盒式模型，封装用户名及其输入框
		/*JLabel name=new JLabel("用户名");
		JTextField nfield=new JTextField(10);//创建用户名输入框*/
		box1.add(name);
		box1.add(nfield);

		Box box2=Box.createHorizontalBox();//创建水平盒式模型，封装密码及密码输入框
		/*JLabel password=new JLabel("密   码");
		JTextField pfield=new JTextField(10);//创建密码输入框*/
		box2.add(password);
		box2.add(pfield);

		Box box3=Box.createHorizontalBox();//创建水平盒式模型，封装确认和取消按钮
		/*JButton ok=new JButton("确认");
		JButton canel=new JButton("取消");*/
		box3.add(ok);
		box3.add(canel);
		box.add(box1);
		box.add(box2);
		box.add(box3);
		panel.add(box);
		frame.add(panel);
		loginEvent(ok, panel, frame);
		//panel.add(box3,BorderLayout.CENTER);

	}
	//登录事件的相关处理
	public static void loginEvent(JButton ok,JPanel panel,JFrame frame) {
		ok.addActionListener(new ActionListener() {
			/*点击确认按钮，触发事件*/
			@Override
			public void actionPerformed(ActionEvent e) {
				String s=nfield.getText();//获取用户名内容
				String ps=pfield.getText();//获取密码框内容
				User user=new User(s,ps);
				boolean flag=true;
				  /*使用增强for循环遍历输入的用户名和密码，增强for循环:用于数组和集合
				  for(元素类型 元素名(自己取的变量名称)：集合名或数组名){
				       }*/
				for(User u:person) {
					if(u.toString().equals(user.toString())) {
						flag=false;//防止输出用户名为空或密码为空的情况
						panel.removeAll();
						panel.updateUI();
						frame.remove(panel);
						home(frame);
					}
				}
				if(flag&&s.trim().length()!=0&&ps.trim().length()!=0) {
					JOptionPane.showMessageDialog(frame, "用户名或密码有误，请再次输入","",JOptionPane.ERROR_MESSAGE);
				}
				if(flag&&s.trim().length()==0) {
					JOptionPane.showMessageDialog(frame, "用户名不能为空!","",JOptionPane.WARNING_MESSAGE);
				}
				if(flag&&ps.trim().length()==0) {
					JOptionPane.showMessageDialog(frame, "密码不能为空!","",JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		canel.addActionListener(new ActionListener() {
			/*点击取消按钮，触发相应事件*/
			@Override
			public void actionPerformed(ActionEvent e) {
				nfield.setText("");//更新文本框的显示文本
				pfield.setText("");//更新密码框的显示文本

			}
		});
	}
	/*对图书增删减改的操作按钮位置布局*/
	public static Box list() {
		Box box=Box.createVerticalBox();
		box.add(searchbt);
		box.add(editbt);
		box.add(addbt);
		box.add(deletebt);
		return box;

	}
	//登录成功后由用户界面跳转到图书信息管理系统界面
	public static void home(JFrame frame) {
		JPanel panel=new JPanel(new BorderLayout(6,6));
		panel.add(BorderLayout.NORTH,new JLabel("欢迎进入图书信息管理系统!"));
		panel.add(BorderLayout.WEST,list());
		search(panel);
		frame.add(panel);

	}
	//查询图书信息
	public static void search(JPanel panel) {
		//点击查询按钮，触发查询图书信息的事件
		searchbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Books b:books) {
					Vector<String>books1=new Vector<String>();
					books1.add(b.getKind());
					books1.add(b.getName());
					books1.add(b.getCode());
					booksVector.add(books1);
					model.setDataVector(booksVector,listname);//更新表格中的数据
				}
				panel.updateUI();//刷新面板
				panel.add(BorderLayout.CENTER,new JScrollPane(table));//将查询到的图书信息放到面板的中央
			}
		});
		//增添商品信息
		addbt.addActionListener(new ActionListener() {
			//点击增添按钮，弹出添加信息的对话框
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel1=new JPanel(new BorderLayout());
				int row=table.getSelectedRow();
				JDialog dialog=new JDialog(frame,"添加图书信息",true);
				JPanel contentPanel = new JPanel(new GridLayout(3, 2));

				JLabel kindLabel = new JLabel("种类");
				JTextField kindField = new JTextField(10);
				JLabel nameLabel = new JLabel("名称");
				JTextField nameField = new JTextField(10);
				JLabel codeLabel = new JLabel("编码");
				JTextField codeField = new JTextField(10);
				/** @description: 上述三个字段及其输入框添加到表格中
				 * @param: void
				 * @return: void
				 * @author: IhaveBB
				 * @date: 2023/12/27
				 */
				contentPanel.add(kindLabel);
				contentPanel.add(kindField);
				contentPanel.add(nameLabel);
				contentPanel.add(nameField);
				contentPanel.add(codeLabel);
				contentPanel.add(codeField);


				JButton confirmbt=new JButton("确认添加");
				confirmbt.addActionListener(new ActionListener() {
					//点击确认添加，触发添加学生信息的事件
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector<String>bookStrings=new Vector<>();
						bookStrings.add(kindField.getText());
						bookStrings.add(nameField.getText());
						bookStrings.add(codeField.getText());
						model.addRow(bookStrings);

					}
				});
				JButton canelbt=new JButton("取消添加");
				canelbt.addActionListener(new ActionListener() {
					//点击取消添加,将框中的信息都更新清除
					@Override
					public void actionPerformed(ActionEvent e) {
						kindField.setText("");//更新种类框
						nameField.setText("");//更新名称框
						codeField.setText("");//更新编码框

					}
				});

				//使用流布局来存放两个按钮
				JPanel buttonGroud = new JPanel();
				buttonGroud.add(confirmbt);
				buttonGroud.add(canelbt);

				//将上面的表格和按钮添加到面板中
				panel1.add(buttonGroud,BorderLayout.SOUTH);
				panel1.add(contentPanel,BorderLayout.CENTER);
				dialog.add(panel1);
				dialog.setSize(300,200);
				dialog.setVisible(true);
			}
		});
		//修改图书信息
		editbt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel panel2=new JPanel(new GridLayout(4,2));
				int row=table.getSelectedRow();
				JDialog dialog=new JDialog(frame,"修改图书信息",true);
				JLabel kindLabel = new JLabel("种类");
				JTextField kindField = new JTextField(10);
				JLabel nameLabel = new JLabel("名称");
				JTextField nameField = new JTextField(10);
				JLabel codeLabel = new JLabel("编码");
				JTextField codeField = new JTextField(10);

				kindField.setText(table.getValueAt(row, 0).toString());
				nameField.setText(table.getValueAt(row, 1).toString());
				codeField.setText(table.getValueAt(row, 2).toString());

				panel2.add(kindLabel);
				panel2.add(kindField);
				panel2.add(nameLabel);
				panel2.add(nameField);
				panel2.add(codeLabel);
				panel2.add(codeField);

				JButton confirmbt=new JButton("确认修改");

				confirmbt.addActionListener(new ActionListener() {
					//点击确认修改，对图书信息进行修改
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector<String> goodStrings = new Vector<String>();
						goodStrings.add(kindField.getText());
						goodStrings.add(codeField.getText());
						goodStrings.add(nameField.getText());
						model.removeRow(row);
						model.insertRow(row, goodStrings);

					}
				});
				JButton canelButton=new JButton("取消修改");
				canelButton.addActionListener(new ActionListener() {
					//点击取消修改按钮
					@Override
					public void actionPerformed(ActionEvent e) {
						kindField.setText("");//更新种类框
						nameField.setText("");//更新名称框
						codeField.setText("");//更新编码框

					}
				});
				panel2.add(confirmbt);
				panel2.add(canelButton);
				dialog.add(panel2);
				dialog.setSize(500,500);
				dialog.setLocation(200, 160);
				dialog.setVisible(true);
			}
		});
		//减删图书信息
		deletebt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				model.removeRow(row);

			}
		});
	}
}
