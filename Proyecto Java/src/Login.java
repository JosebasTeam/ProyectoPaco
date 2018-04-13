import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class Login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usuario;
	private JPasswordField contraseña;
	boolean sw;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 351, 304);
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		usuario = new JTextField();
		usuario.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario: ");
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		
		contraseña = new JPasswordField();
		contraseña.setColumns(10);
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				SQL db = new SQL();
				
				String usuario2;
		        db.MySQLConnection("root", "", "");
				
				usuario2 = db.getUsuario("usuario", usuario.getText() , contraseña.getText() );
				switch (usuario2.charAt(0)) {
				case 'u':
					lblNewLabel.setForeground(Color.red);
					lblNewLabel.setText("Usuario erroneo");
					break;
				case 'c':
					lblNewLabel.setForeground(Color.red);
					lblNewLabel.setText("Contraseña erronea");
					break;
				case 'i':
					//lblNewLabel.setForeground(Color.green);
					//lblNewLabel.setText("Usuario correcto");
					Admin m = new Admin(Integer.parseInt(usuario2.substring(1)));
					setVisible(false);
					m.setVisible(true);
					m.setBounds(200,200,794,556); // Para darle el tamano y localizarlo en la pantalla 

					// Ahora para volver invisible en el JFrame actual

					sw=false;
					break;

				default:
					break;
				}
			}
		});

		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\admin-dam1\\Desktop\\Icon.png"));
		
		
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(37)
					.addComponent(label)
					.addContainerGap(32, Short.MAX_VALUE))
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(133)
					.addComponent(btnLogin)
					.addContainerGap(135, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addContainerGap(60, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblUsuario)
							.addGap(41))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblContrasea, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE)
						.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, 120, GroupLayout.PREFERRED_SIZE))
					.addGap(61))
				.addComponent(lblNewLabel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(usuario, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblUsuario))
					.addGap(30)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(contraseña, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblContrasea))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 18, Short.MAX_VALUE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnLogin)
					.addContainerGap())
		);
		contentPane.setLayout(gl_contentPane);
	}



}
