import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Timer;
import java.util.Vector;

/**
 * @author IhaveBB
 */
public class eventGUI {
	static ArrayList<User> person=new ArrayList<User>();//用户
	static Vector<String> listname=new Vector<String>();//vector是一个动态数组，可以存储任意类型的变量
	static ArrayList<Goods>goods=new ArrayList<Goods>();//ArrayList类是一个可以动态修改的数组(商品)
	static Vector<Vector<String>>goodsVector=new Vector<Vector<String>>();
	static DefaultTableModel model=new DefaultTableModel(goodsVector,listname);
	static JTable table=new JTable(model);//JLabel组件创建表格，显示JTable组件需要用到TableModel接口，需要使用DefaultTableModel类
	public static void init() {
		person.add(new User("sunflower", "2983130599"));
		listname.add("类别");
		listname.add("名称");
		listname.add("价格(元/斤)");
		goods.add(new Goods("水果","苹果","4.5"));
		goods.add(new Goods("水果","橙子","4"));
		goods.add(new Goods("水果","香蕉","3"));
		goods.add(new Goods("水果","西瓜","5"));
		goods.add(new Goods("蔬菜","白菜","2"));
		goods.add(new Goods("蔬菜","萝卜","1"));
	}



	static JLabel name=new JLabel("用户名");
	static JTextField nametext=new JTextField(10);//用户框
	static JLabel password=new JLabel("密    码");
	static JPasswordField pwtext =new JPasswordField(10);//密码框
		    /*static String [] label={"名称","类别","价格"};
		    static String [][]content= {{"苹果","水果","5"},{"橙子","水果","4"},{"西瓜","水果","8"},{"香蕉","水果","3"},{"白菜","蔬菜","2"},{"萝卜","蔬菜","1"}};//用二维数组存储商品的名称，类别，价格*/

	//JLabel组件创建表格，显示JTable组件需要用到TableModel接口，需要使用DefaultTableModel类

	//static DefaultTableModel model=new DefaultTableModel(content,label);
	static JButton searchbt =new JButton("查询商品信息");
	static JButton addbt =new JButton("增加商品信息");
	static JButton editchbt =new JButton("修改商品信息");
	static JButton deletebt =new JButton("删除商品信息");

	//由登录界面进入农产品界面

	public static void main(String[] args) {
		init(); // 初始化用户和商品数据
		JFrame frame=new JFrame("农产品平台");
		loginLayout(frame);
		setFrame(frame);

	}
	//登录界面的布局设计

	public static void loginLayout(JFrame frame) {
		JPanel panel=new JPanel();
		Box box=Box.createVerticalBox();//创建一个列式盒式模型，存放box1,box2,box3
		Box box1=Box.createHorizontalBox();//创建一个行型盒式模型，存放用户名及用户名的文本框
		box1.add(name);
		box1.add(nametext);

		Box box2=Box.createHorizontalBox();//创建一个行型盒式模型，存放密码及密码的密码框
		box2.add(password);
		box2.add(pwtext);

		Box box3=Box.createHorizontalBox();//创建一个行型盒式模型，存放登录和取消按钮
		JButton ok=new JButton("登录");
		JButton canel=new JButton("取消");
		login(ok,panel,frame);
		box3.add(ok);
		box3.add(canel);
		box.add(box1);
		box.add(box2);
		box.add(box3);
		panel.add(box);
		frame.add(panel);

	}

	//登录事件处理

	public static void login(JButton ok, JPanel panel,JFrame frame) {
		ok.addActionListener(new ActionListener(){

			@Override
					/*
					  1.验证是否登录成功
					  2.不成功，对话显示
					  3.若成功，跳转到商品界面

					  */
			public void actionPerformed(ActionEvent arg0) {
				String nString=nametext.getText();
				String pString=pwtext.getText();
				User user=new User(nString, pString);
				boolean flag=true;
				for(User u:person) {
							/*增强for循环，用于数组和集合
							  for(元素类型 元素名(自己取的变量名称)：集合名或数组名){
							        访问元素
								*/
					if(u.toString().equals(user.toString())) {
						flag=false;
						panel.removeAll();
						panel.updateUI();
						frame.remove(panel);
						home(frame);
					}
				}
				if(flag&& nString.trim().length()!=0&&pString.trim().length()!=0){//trim()方法：删除字符串首尾的空格
					JOptionPane.showMessageDialog(frame, "用户名或密码有误，请仔细检查","",JOptionPane.ERROR_MESSAGE);

				}
				if (nString.trim().length()==0){
					JOptionPane.showMessageDialog(frame, "用户名不能为空","",JOptionPane.WARNING_MESSAGE);

				}
				if (pString.trim().length()==0){
					JOptionPane.showMessageDialog(frame, "密码不能为空","",JOptionPane.WARNING_MESSAGE);

				}
			}

		});
		JButton canelButton=new JButton("取消");
		canelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				nametext.setText("");
				pwtext.setText("");

			}
		});
	}

	//对商品进行查询，添加，修改，删除

	public static Box menu() {

		Box box=Box.createVerticalBox();//创建一个列式盒式模型,存放各操作按钮
		box.add(searchbt);
		box.add(editchbt);
		box.add(addbt);
		box.add(deletebt);
		return box;

	}

	//登录成功后跳转到商品界面

	public static void home(JFrame frame) {
		JPanel panel=new JPanel(new BorderLayout(5,5));//上下左右间距都为5
		panel.add(BorderLayout.NORTH,new JLabel("登录成功！欢迎进入商品信息管理系统"));
		panel.add(BorderLayout.WEST,menu());
		//处理查询商品信息的方法
		search(panel);
		frame.add(panel);
	}
	private static void search(JPanel panel) {
		//查询产品信息函数
		searchbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				for(Goods g:goods) {
					Vector<String>goodsString=new Vector<String>();
					goodsString.add(g.getKind());
					goodsString.add(g.getGname());
					goodsString.add(g.getPrice());
					goodsVector.add(goodsString);
					model.setDataVector(goodsVector, listname); // 更新表格数据
				}

				//JTable table=new JTable(model1);//创建存放商品信息的表格
				panel.updateUI();//更新Borderlayout
				//查询到的信息放到home的中央
				panel.add(BorderLayout.CENTER,new JScrollPane(table));
			}
		});
		addbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JPanel gPanel = new JPanel(new GridLayout(4, 2));
				JLabel kindJLabel = new JLabel("类别");
				JTextField kindField = new JTextField();
				JLabel nJLabel = new JLabel("名称");
				JTextField nfField = new JTextField();
				JLabel price = new JLabel("价格");
				JTextField prField = new JTextField();
				JButton okbt= new JButton("确认添加");
				okbt.addActionListener(new ActionListener() {


					@Override


					public void actionPerformed(ActionEvent arg0) {
						Vector<String> goodStrings = new Vector<String>();
						goodStrings.add(kindField.getText());
						goodStrings.add(nfField.getText());
						goodStrings.add(prField.getText());
						model.addRow(goodStrings);
					}
				});
				JButton canelbt = new JButton("取消添加商品信息");
				canelbt.addActionListener(new ActionListener() {


					@Override


					public void actionPerformed(ActionEvent arg0) {
						kindField.setText("");
						nfField.setText("");
						prField.setText("");
					}
				});
				gPanel.add(kindJLabel);
				gPanel.add(kindField);
				gPanel.add(nJLabel);
				gPanel.add(nfField);
				gPanel.add(price);
				gPanel.add(prField);
				gPanel.add(okbt);
				gPanel.add(canelbt);
				dialog.add(gPanel);
				dialog.setSize(200, 180);
				dialog.setVisible(true);
			}
		});
		//修改商品信息
		editchbt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog = new JDialog();
				JPanel gPanel = new JPanel(new GridLayout(4, 2));
				int row = table.getSelectedRow();
				JLabel kind = new JLabel("种类");
				JTextField kindField = new JTextField();
				kindField.setText((String) table.getValueAt(row, 0));
				JLabel namegJLabel = new JLabel("名称");
				JTextField nfField = new JTextField();
				nfField.setText((String) table.getValueAt(row, 1));
				JLabel price = new JLabel("价格");
				JTextField prField=new JTextField();
			//	prField.setText((String)table.getValue(row,2));
				prField.setText((String)table.getValueAt(row,2));

				JButton confirmButton=new JButton("确认修改商品信息");
				confirmButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						Vector<String> goodStrings = new Vector<String>();
						goodStrings.add(kindField.getText());
						goodStrings.add(nfField.getText());
						goodStrings.add(prField.getText());
						model.removeRow(row);
						model.insertRow(row, goodStrings);
					}
				});
				JButton noButton = new JButton("取消修改商品信息");
				noButton.addActionListener(new ActionListener() {


					@Override


					public void actionPerformed(ActionEvent arg0) {
						kindField.setText("");
						nfField.setText("");
						prField.setText("");
					}
				});
				gPanel.add(kind);
				gPanel.add(kindField);
				gPanel.add(namegJLabel);
				gPanel.add(nfField);
				gPanel.add(price);
				gPanel.add(prField);
				gPanel.add(confirmButton);
				gPanel.add(noButton);
				dialog.add(gPanel);
				dialog.setSize(200, 180);
				dialog.setVisible(true);
			}
		});
		//删除商品信息
		deletebt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int row = table.getSelectedRow();
				model.removeRow(row);
			}
		});
						/*box.add(searchbt);
						box.add(addbt);
						box.add(editchbt);
						box.add(deletebt);*/
		//panel.add(BorderLayout.WEST, box);
		JTextField textField = new JTextField();
		SimpleDateFormat st = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		panel.add(BorderLayout.SOUTH, textField);
	}
	public static void setFrame(JFrame frame) {
		frame.setSize(500,380);
		frame.setLocation(280,100);
		frame.setVisible(true);

	}

}