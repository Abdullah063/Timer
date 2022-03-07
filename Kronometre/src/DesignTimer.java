import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.*;
import java.awt.Color;
import javax.swing.JList;

public class DesignTimer {

	private JFrame frmTimer;
	private JTextField screan;
	private Timer time;
    static int second=0 ,minute = 0,hour =0 ;
    

    private final Action action = new SwingAction();
   
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DesignTimer window = new DesignTimer();
					window.frmTimer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
	
	
	

	public DesignTimer() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTimer = new JFrame();
		frmTimer.setTitle("Timer");
		frmTimer.setResizable(false);
		frmTimer.setBounds(100, 100, 400, 450);
		frmTimer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTimer.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(31, 10, 334, 81);
		frmTimer.getContentPane().add(panel);
		panel.setLayout(null);
		
		screan = new JTextField();
		screan.setText("0 : 0 : 0");
		screan.setBackground(Color.LIGHT_GRAY);
		screan.setEditable(false);
		screan.setHorizontalAlignment(SwingConstants.CENTER);
		screan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		screan.setBounds(94, 28, 153, 31);
		panel.add(screan);
		screan.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(31, 88, 334, 315);
		frmTimer.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnStart.setBounds(62, 39, 58, 35);
		panel_1.add(btnStart);
		btnStart.setToolTipText("");
		
		JButton btnNewButton_2 = new JButton("Reset");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_2.setBounds(213, 39, 71, 35);
		panel_1.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Save");
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnNewButton_3.setBounds(139, 39, 58, 35);
		panel_1.add(btnNewButton_3);
		
		
		
		DefaultListModel<String> l
		= new DefaultListModel<>();
		JList<String> list = new JList<>(l);
		list.setVisibleRowCount(2);
		list.setFont(new Font("Tahoma", Font.PLAIN, 12));
		list.setBounds(62, 95, 222, 141);
		panel_1.add(list);
		
		
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			l.addElement(screan.getText());
			
			}
		});
		JButton btnNewButton_4 = new JButton("Remove");
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 8));
		
		btnNewButton_4.setBounds(130, 253, 93, 35);
		panel_1.add(btnNewButton_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l.clear();
				
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				second=0;
				screan.setText("0 : 0 : 0");
				time.stop();
			}
		});
		
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
			
				if (btnStart.getText().equals("Start"))
				{
					time = new Timer(1000 , new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							second++;
							screan.setText(hour+" : "+minute+" : "+ second );
							if (second==60) 
							{
							    minute++;
							    second=0;
							    if (minute==60)
							    {
									hour++;
									minute=0;
								}
							}
						}
					});
					time.start();
					btnStart.setText("Stop");
				}
				else 
				{
					time.stop();
					btnStart.setText("Start");
					
				}
				
				
				
				
			}
		});
		
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public void start() 
	{
		
	}
}

