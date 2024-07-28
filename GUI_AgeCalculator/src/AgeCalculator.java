import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AgeCalculator implements ActionListener {
	
	private static JLabel greeting, labelYear, labelMonth, labelDay, yourAge;
	private static JTextField userYear, userMonth, userDay;
	private static JButton button;

	public static void main(String[] args) {
		
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		
		frame.setTitle("Age Calculator");
		frame.setSize(500, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.add(panel);
		
		panel.setLayout(null);
		
		greeting= new JLabel("ENTER YOUR BIRTHDAY");
		greeting.setBounds(10, 10, 200, 30);
		panel.add(greeting);
		
		labelYear = new JLabel("Year:");
		labelYear.setBounds(10, 40, 200, 30);
		panel.add(labelYear);
		
		userYear = new JTextField();
		userYear.setBounds(120, 40, 100, 30);
		panel.add(userYear);
		
		labelMonth = new JLabel("Month:");
		labelMonth.setBounds(10, 80, 200, 30);
		panel.add(labelMonth);
		
		userMonth = new JTextField();
		userMonth.setBounds(120, 80, 100, 30);
		panel.add(userMonth);
		
		labelDay = new JLabel("Day:");
		labelDay.setBounds(10, 120, 200, 30);
		panel.add(labelDay);
		
		userDay = new JTextField();
		userDay.setBounds(120, 120, 100, 30);
		panel.add(userDay);
		
		button = new JButton("Calculate!");
		button.setBounds(10, 160, 100, 30);
		button.addActionListener(new AgeCalculator());
		panel.add(button);
		
		yourAge = new JLabel("");
		yourAge.setBounds(150, 160, 200, 30);
		panel.add(yourAge);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		int year = Integer.parseInt(userYear.getText());
		int month = Integer.parseInt(userMonth.getText());
		int day = Integer.parseInt(userDay.getText());
		
		LocalDate today = LocalDate.now();
		LocalDate birthDate = LocalDate.of(year, month, day);
		int age = Period.between(birthDate, today).getYears();
		
		yourAge.setText("You are " + age + " years old");
	}

}
