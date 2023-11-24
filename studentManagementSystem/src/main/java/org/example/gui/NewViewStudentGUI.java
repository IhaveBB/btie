import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class NewViewStudentGUI extends JFrame {
	private JTextField searchField;
	private JTable studentTable;
	private DefaultTableModel tableModel;

	public NewViewStudentGUI() {
		setTitle("View Student Information");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JPanel panel = new JPanel(new BorderLayout());

		JPanel searchPanel = new JPanel(new FlowLayout());
		JLabel searchLabel = new JLabel("Search by ID or Name:");
		searchField = new JTextField(15);
		JButton searchBtn = new JButton("Search");
		searchPanel.add(searchLabel);
		searchPanel.add(searchField);
		searchPanel.add(searchBtn);

		tableModel = new DefaultTableModel();
		studentTable = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(studentTable);

		// 添加表头和初始化表格列
		tableModel.setColumnIdentifiers(new String[]{"Student ID", "Name", "Gender", "Birthdate", "Address", "Phone Number"});

		// 模拟一些学生数据，并将其添加到表格中
		Object[] rowData1 = {101, "John Doe", "Male", "1990-05-20", "123 Main St", "555-1234"};
		Object[] rowData2 = {102, "Jane Smith", "Female", "1992-08-15", "456 Oak Ave", "555-5678"};

		tableModel.addRow(rowData1);
		tableModel.addRow(rowData2);

		panel.add(searchPanel, BorderLayout.NORTH);
		panel.add(scrollPane, BorderLayout.CENTER);

		add(panel);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new NewViewStudentGUI().setVisible(true);
			}
		});
	}
}
