import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

public class Main {
	static Vector<String> cName=new Vector<String>();
	static Vector<Vector<String>> goods=new Vector<Vector<String>>();
	static ArrayList<Fruit> fruits=new ArrayList<Fruit>();
	static  DefaultTableModel model;
	static  JTable table;
	static  JPanel panel;
	public static void init(){
		cName.add("编号");
		cName.add("种类");
		cName.add("价格");
		fruits.add(new Fruit("001","番茄","5","2","2"));
		fruits.add(new Fruit("002","土豆","4","2","2"));
		fruits.add(new Fruit("003","茄子","4.2","2","2"));
	}

	public static void main(String[] args) {
		init();
		JFrame frame=new JFrame();
		login(frame);
		frame.setSize(500,200);
		frame.setVisible(true);
	}
	public static void show(JFrame frame){
		panel = new JPanel();
		JPanel jPanel=new JPanel();
		JButton querybtButton =new JButton("查询");
		query( querybtButton);
		JButton addbtButton=new JButton("添加");
		add(addbtButton);
		JButton delButton=new JButton("删除");
		delete(delButton);
		JButton editButton=new JButton("修改");
		edit(editButton);
		jPanel.add(querybtButton);
		jPanel.add(addbtButton);
		jPanel.add(delButton);
		jPanel.add(editButton);
		panel.add(BorderLayout.NORTH,jPanel);
		JTextField textField=new JTextField();
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Timer timer=new Timer(3000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Date current=new Date();
				textField.setText(simpleDateFormat.format(current)+'\n');
			}



		});
		frame.add(panel);

	}


	public static void edit(JButton editButton){
		editButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog=new JDialog();
				int row=table.getSelectedRow();
				JPanel gPanel=new JPanel(new GridLayout(4,2));
				JLabel idIJabel=new JLabel("编号");
				JTextField idField=new JTextField(10);
				idField.setText((String) table.getValueAt(row,0));
				JLabel nameIJabel=new JLabel("名称");
				JTextField nameField=new JTextField(10);
				nameField.setText((String) table.getValueAt(row,1));
				JLabel priceIJabel=new JLabel("价格");
				JTextField priceField=new JTextField(10);
				priceField.setText((String) table.getValueAt(row,2));
				JButton okButton=new JButton("确定修改");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector<String>fru=new Vector<String>();
						fru.add(idField.getText());
						fru.add(nameField.getText());
						fru.add(priceField.getText());
						model.removeRow(row);
						model.insertRow(row,fru);

					}
				});
				JButton canButton=new JButton("取消修改");
				canButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				gPanel.add(idIJabel);
				gPanel.add(idField);
				gPanel.add(nameIJabel);
				gPanel.add(nameField);
				gPanel.add(priceIJabel);
				gPanel.add(priceField);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				dialog.setSize(200,160);
				dialog.setVisible(true);
			}
		});
	}
	public static void delete(JButton delButton){
		delButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int row=table.getSelectedRow();
				model.removeRow(row);
			}
		});
	}
	public static void login(JFrame frame) {
		JPanel panel=new JPanel();
		JTextField nametf=new JTextField(10);
		JTextField namemm=new JTextField(10);
		JLabel name=new JLabel("用户名");
		JButton ok=new JButton("登录");
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				show(frame);
				frame.setVisible(true);
			}
		});
		JLabel password=new JLabel("密   码");
		JButton qx=new JButton("取消");
		Box box=Box.createVerticalBox();
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		box1.add(name);
		box1.add(nametf);
		box2.add(password);
		box2.add(namemm);
		box3.add(ok);
		box3.add(qx);
		box.add(box1);
		box.add(box2);
		box.add(box3);
		panel.add(box);
		frame.add(panel);

	}
	public static void query(JButton querybtButton){
		querybtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				for (Fruit f:fruits) {
					Vector<String>fru=new Vector<String>();
					fru.add(f.getId());
					fru.add(f.getName());
					fru.add(f.getPrice());
					goods.add(fru);
				}
				model=new DefaultTableModel(goods,cName);
				table=new JTable(model);
				panel.updateUI();
				panel.add(BorderLayout.CENTER,new JScrollPane(table));
			}
		});
	}
	public static void add(JButton addbtButton){
		addbtButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog dialog=new JDialog();
				JPanel gPanel=new JPanel(new GridLayout(4,2));
				JLabel idIJabel=new JLabel("编号");
				JTextField idField=new JTextField(10);
				JLabel nameIJabel=new JLabel("名称");
				JTextField nameField=new JTextField(10);
				JLabel priceIJabel=new JLabel("价格");
				JTextField priceField=new JTextField(10);
				JButton okButton=new JButton("确定添加");
				okButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						Vector<String>fru=new Vector<String>();
						fru.add(idField.getText());
						fru.add(nameField.getText());
						fru.add(priceField.getText());
						model.addRow(fru);
					}
				});
				JButton canButton=new JButton("取消添加");
				canButton.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						dialog.dispose();
					}
				});
				gPanel.add(idIJabel);
				gPanel.add(idField);
				gPanel.add(nameIJabel);
				gPanel.add(nameField);
				gPanel.add(priceIJabel);
				gPanel.add(priceField);
				gPanel.add(okButton);
				gPanel.add(canButton);
				dialog.add(gPanel);
				dialog.setSize(200,160);
				dialog.setVisible(true);
			}
		});
	}

}