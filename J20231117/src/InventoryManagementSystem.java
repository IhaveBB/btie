import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

class Product {
	static int idCounter = 1;
	int id;
	String name;
	String category;
	double price;
	double quantity; // 使用double类型存储商品数量

	public Product(String name, String category, double price, double quantity) {
		this.id = idCounter++;
		this.name = name;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		return String.format("%-5d%-20s%-20s%-15.2f%-10.2f", id, name, category, price, quantity);
	}
}

public class InventoryManagementSystem extends JFrame {
	private List<Product> productList;
	private JComboBox<String> unitComboBox;

	public InventoryManagementSystem() {
		productList = new ArrayList<>();

		setTitle("库存管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		createMenuBar();
		createUI();

		setSize(600, 400); // 设置固定的窗口大小
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void createMenuBar() {
		JMenuBar menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("文件");
		JMenuItem exitMenuItem = new JMenuItem("退出");

		exitMenuItem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		fileMenu.add(exitMenuItem);
		menuBar.add(fileMenu);
		setJMenuBar(menuBar);
	}

	private void createUI() {
		JButton entryButton = createStyledButton("商品入库");
		JButton displayButton = createStyledButton("展示商品");
		JButton deleteButton = createStyledButton("删除商品");
		JButton modifyButton = createStyledButton("修改商品信息");

		entryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				entryProduct();
			}
		});

		displayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				displayProducts();
			}
		});

		deleteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteProduct();
			}
		});

		modifyButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				modifyProduct();
			}
		});

		// 添加商品单位选择下拉框
		String[] units = {"斤", "个"};
		unitComboBox = new JComboBox<>(units);

		JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		panel.setBackground(new Color(230, 230, 250));

		panel.add(unitComboBox); // 将单位选择下拉框添加到界面

		panel.add(entryButton);
		panel.add(displayButton);
		panel.add(deleteButton);
		panel.add(modifyButton);

		setContentPane(new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				drawGradientBackground(g);
			}
		});

		add(panel);
	}

	private JButton createStyledButton(String text) {
		JButton button = new JButton(text);
		button.setBackground(new Color(135, 206, 250));
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		return button;
	}

	private void drawGradientBackground(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		Color color1 = new Color(240, 248, 255);
		Color color2 = new Color(173, 216, 230);

		GradientPaint gradient = new GradientPaint(0, 0, color1, getWidth(), getHeight(), color2);
		g2d.setPaint(gradient);
		g2d.fillRect(0, 0, getWidth(), getHeight());
	}

	private void displayProducts() {
		if (productList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "库存为空");
		} else {
			StringBuilder display = new StringBuilder(String.format("%-5s%-20s%-20s%-15s%-10s\n", "编号", "商品名称", "商品类别", "商品价格", "商品数量"));

			for (Product product : productList) {
				display.append(product.toString()).append("\n");
			}

			JTextArea textArea = new JTextArea(display.toString());
			textArea.setEditable(false);

			JScrollPane scrollPane = new JScrollPane(textArea);

			JOptionPane.showMessageDialog(null, scrollPane, "商品列表", JOptionPane.PLAIN_MESSAGE);
		}
	}

	private void deleteProduct() {
		if (productList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "库存为空");
			return;
		}

		try {
			String input = JOptionPane.showInputDialog("请输入要删除的商品编号(1-" + productList.size() + "):");
			int productIndex = Integer.parseInt(input) - 1;

			if (productIndex >= 0 && productIndex < productList.size()) {
				productList.remove(productIndex);
				JOptionPane.showMessageDialog(null, "商品删除成功!");
				displayProducts();
			} else {
				JOptionPane.showMessageDialog(null, "无效的商品编号!");
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "请输入有效的数字！");
		}
	}

	private void modifyProduct() {
		if (productList.isEmpty()) {
			JOptionPane.showMessageDialog(null, "库存为空");
			return;
		}

		try {
			String input = JOptionPane.showInputDialog("请输入要修改的商品编号(1-" + productList.size() + "):");
			int productIndex = Integer.parseInt(input) - 1;

			if (productIndex >= 0 && productIndex < productList.size()) {
				Product selectedProduct = productList.get(productIndex);

				JTextField nameField = new JTextField(selectedProduct.name);
				JTextField categoryField = new JTextField(selectedProduct.category);
				JTextField priceField = new JTextField(Double.toString(selectedProduct.price));
				JTextField quantityField = new JTextField(Double.toString(selectedProduct.quantity));

				JPanel modifyPanel = new JPanel(new GridLayout(4, 2, 10, 10));

				modifyPanel.add(new JLabel("新的商品名称:"));
				modifyPanel.add(nameField);
				modifyPanel.add(new JLabel("新的商品类别:"));
				modifyPanel.add(categoryField);
				modifyPanel.add(new JLabel("新的商品价格:"));
				modifyPanel.add(priceField);
				modifyPanel.add(new JLabel("新的商品数量:"));
				modifyPanel.add(quantityField);

				int result = JOptionPane.showConfirmDialog(null, modifyPanel, "修改商品信息", JOptionPane.OK_CANCEL_OPTION);

				if (result == JOptionPane.OK_OPTION) {
					try {
						selectedProduct.name = nameField.getText();
						selectedProduct.category = categoryField.getText();
						selectedProduct.price = Double.parseDouble(priceField.getText());
						selectedProduct.quantity = Double.parseDouble(quantityField.getText());

						JOptionPane.showMessageDialog(null, "商品信息修改成功!");
						displayProducts();
					} catch (NumberFormatException ex) {
						JOptionPane.showMessageDialog(null, "请输入有效的数字！");
					}
				}
			} else {
				JOptionPane.showMessageDialog(null, "无效的商品编号!");
			}
		} catch (NumberFormatException ex) {
			JOptionPane.showMessageDialog(null, "请输入有效的数字！");
		}
	}

	private void entryProduct() {
		JTextField nameField = new JTextField();
		JTextField categoryField = new JTextField();
		JTextField priceField = new JTextField();
		JTextField quantityField = new JTextField();

		JPanel entryPanel = new JPanel(new GridLayout(5, 2, 10, 10)); // 修改为5行

		entryPanel.add(new JLabel("商品名称:"));
		entryPanel.add(nameField);
		entryPanel.add(new JLabel("商品类别:"));
		entryPanel.add(categoryField);
		entryPanel.add(new JLabel("商品价格:"));
		entryPanel.add(priceField);
		entryPanel.add(new JLabel("商品数量:"));
		entryPanel.add(quantityField);
		entryPanel.add(new JLabel("商品单位:")); // 新增商品单位标签
		entryPanel.add(unitComboBox); // 新增商品单位下拉框

		int result = JOptionPane.showConfirmDialog(null, entryPanel, "录入商品信息", JOptionPane.OK_CANCEL_OPTION);

		if (result == JOptionPane.OK_OPTION) {
			try {
				String name = nameField.getText();
				String category = categoryField.getText();
				double price = Double.parseDouble(priceField.getText());
				double quantity = Double.parseDouble(quantityField.getText());
				String selectedUnit = (String) unitComboBox.getSelectedItem(); // 获取用户选择的商品单位

				// 根据选择的商品单位进行转换
				if ("斤".equals(selectedUnit)) {
					price = price * 2; // 1斤=2元
					quantity = quantity / 2; // 1斤=2个
				}

				Product newProduct = new Product(name, category, price, quantity);
				productList.add(newProduct);

				JOptionPane.showMessageDialog(null, "商品入库成功!\n商品编号：" + newProduct.id);
				displayProducts();
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "请输入有效的数字！");
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new InventoryManagementSystem();
			}
		});
	}
}
