import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;
public class Demo1
{
	private static JTextArea display;
	public static void main(String[] args)
	{
		JFrame frame = calculator(new JFrame());
		frame.setVisible(true);
		frame.setSize(700, 400);
	}
	public static JFrame calculator(JFrame frame)
	{
		frame.setTitle("科学计算器");
		frame.setLayout(new BorderLayout());
		// 结果显示在最上面
		display = new JTextArea(5,8);

		frame.add(BorderLayout.NORTH, display);
		// 按钮区域放在中间
		JPanel buttonPanel = new JPanel();
		GridLayout grid = new GridLayout(4, 4);
		buttonPanel.setLayout(grid);
		String[] buttons = {"7", "8", "9", "/", "*", "4", "5", "6", "+", "-", "1", "2", "3", "0", ".", "sin", "cos", "tan", "CE","="};
		ButtonClickListener listener = new ButtonClickListener();
		for(String t: buttons)
		{
			JButton button = new JButton(t);
			button.addActionListener(listener);
			buttonPanel.add(button);
		}
		frame.add(BorderLayout.CENTER, buttonPanel);
		return frame;
	}


	private static class ButtonClickListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//获取当前的按钮
			JButton source = (JButton) e.getSource();
			String command = source.getText();
			if(command.equals("="))
			{
				evaluateExpression();
			}
			else if(command.equals("sin") || command.equals("cos") || command.equals("tan"))
			{
				performTrigFunction(command);
			}else if(command.equals("CE"))
			{
				display.setText("");
			}
			else
			{
				display.setText(display.getText() + command);
			}
		}
		/** @description: sin cos等运算直接返回结果，其他加减乘除运算通过调用此方法来显示最终答案
				* @param: void
				* @return: void
				* @author: IhaveBB
				* @date: 2023/11/22
				*/
		private void evaluateExpression()
		{
			String expression = display.getText();
			double result = evaluate(expression);
			display.setText(Double.toString(result));
		}

		/** @description: 进行加减乘除的计算。使用正则表达式匹配加减乘除符号，符号前的数值和后符号后的数值进行计算。
				* @param: String
				* @return: double
				* @author: IhaveBB
				* @date: 2023/11/22
				*/
		private double evaluate(String expression)
		{
			// 正则表达式匹配数字和运算符
			String regex = "([\\d.]+)\\s*([-+*/%])\\s*([\\d.]+)";
			Pattern pattern = Pattern.compile(regex);
			Matcher matcher = pattern.matcher(expression);
			//https://blog.csdn.net/IhaveBB/article/details/134565432
			if(matcher.find())
			{
				double operand1 = Double.parseDouble(matcher.group(1));
				String operator = matcher.group(2);
				double operand2 = Double.parseDouble(matcher.group(3));
				// 根据运算符计算结果
				switch(operator)
				{
					case "+":
						return operand1 + operand2;
					case "-":
						return operand1 - operand2;
					case "*":
						return operand1 * operand2;
					case "/":
						return operand1 / operand2;
					default:
						// 处理其他运算符
						break;
				}
			}
			// 如果没有匹配到，则返回默认值（例如，0）
			return 0;
		}
		/** @description: 处理sin cos等运算。次运算直接计算即可，无需像加减乘除一样进行正则匹配
				* @param: String
				* @return: void
				* @author: IhaveBB
				* @date: 2023/11/22
				*/
		private void performTrigFunction(String functionName) {

			//读取文本框中的内容，并转为double类型
			String tmp = display.getText();
			double num = Double.parseDouble(tmp);
			double result;
			switch(functionName)
			{
				case "sin":
					result = Math.sin(Math.toRadians(num));
					break;
				case "cos":
					result = Math.cos(Math.toRadians(num));
					break;
				case "tan":
					result = Math.tan(Math.toRadians(num));
					break;
				default:
					result = 0;
			}
			display.setText(Double.toString(result));
		}
	}
}