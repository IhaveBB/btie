package org.example;

import org.example.Product;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import java.util.List;

public class InventoryManagement {
	static List<Product> products = new ArrayList<>();
	static JFrame frame = new JFrame("库存管理系统");
	static JPanel panel = new JPanel(new GridBagLayout());

	public static void main(String[] args) {
		loginLayout();
		setFrame();
	}

	public static void loginLayout() {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(5, 5, 5, 5);

		JButton queryBt = new JButton("查询产品信息");
		JButton addBt = new JButton("增加产品信息");
		JButton editBt = new JButton("修改产品信息");
		JButton deleteBt = new JButton("删除产品信息");

		queryBt.addActionListener(e -> displayProducts());
		addBt.addActionListener(e -> addProduct());
		editBt.addActionListener(e -> editProduct());
		deleteBt.addActionListener(e -> deleteProduct());

		panel.add(queryBt, gbc);
		gbc.gridy++;
		panel.add(addBt, gbc);
		gbc.gridy++;
		panel.add(editBt, gbc);
		gbc.gridy++;
		panel.add(deleteBt, gbc);

		frame.setContentPane(panel);
		frame.revalidate();
		frame.repaint();
	}

	public static void setFrame() {
		frame.setSize(800, 500);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

	public static void displayProducts() {
		JPanel rightPanel = new JPanel(new BorderLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.fill = GridBagConstraints.BOTH;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		gbc.insets = new Insets(5, 5, 5, 5);

		String[] columnNames = {"ID", "Name", "Category", "Price", "Quantity"};
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		for (Product product : products) {
			Object[] rowData = {product.getId(), product.getName(), product.getCategory(), product.getPrice(), product.getQuantity()};
			model.addRow(rowData);
		}

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);

		rightPanel.add(scrollPane, BorderLayout.CENTER);
		panel.add(rightPanel, gbc);

		frame.revalidate();
		frame.repaint();
	}

	// 省略其他方法的实现，与之前的代码保持一致
}
