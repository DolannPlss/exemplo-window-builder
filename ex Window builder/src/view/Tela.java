package view;

import java.awt.EventQueue;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Tela extends JFrame {

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfIdade;
	private JButton btnInserir;
	private JButton btnLimpar;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 644, 430);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		
		tfIdade = new JTextField();
		tfIdade.setColumns(10);
		
		btnInserir = new JButton("Inserir");
		
		btnLimpar = new JButton("Limpar");
		
		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(tfNome, GroupLayout.DEFAULT_SIZE, 608, Short.MAX_VALUE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 355, Short.MAX_VALUE)
							.addComponent(btnInserir)
							.addGap(41)
							.addComponent(btnLimpar)))
					.addContainerGap())
				.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 618, Short.MAX_VALUE)
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(tfNome, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(55)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(tfIdade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInserir)
						.addComponent(btnLimpar))
					.addGap(32)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE))
		);
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		contentPane.setLayout(gl_contentPane);
		
		ActionListener insert = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				insereDados();
			}
		};
			ActionListener clean = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				limpaTexto();
			}
		};
		btnInserir.addActionListener(insert);
		tfIdade.addActionListener(insert);
		btnLimpar.addActionListener(clean);
	}
	public void limpaTexto() {
		textArea.setText("");
	} 
	public void insereDados() {
		if (!tfNome.getText().isEmpty()) {
			if (!tfIdade.getText().isEmpty()) {
				String nome = tfNome.getText();
				String idade = tfIdade.getText();
				textArea.setText(textArea.getText()+nome+"\n"+idade+"anos"+"\n");
			}else {
				JOptionPane.showMessageDialog(null, "Digite uma idade " , "ERRO", JOptionPane.ERROR_MESSAGE);
			}
		}else{
			JOptionPane.showMessageDialog(null, "Digite um nome !!!" , "ERRO", JOptionPane.ERROR_MESSAGE);
		}
	}
}
