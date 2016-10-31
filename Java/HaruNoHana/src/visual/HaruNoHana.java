package visual;

import java.awt.EventQueue;
import banco.de.dados.*;
import daos.*;
import dbos.*;
import Core.*;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JList;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class HaruNoHana {

	private JFrame frame;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JList<String> lst_Clientes = new JList<String>();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HaruNoHana window = new HaruNoHana();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HaruNoHana() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 592, 419);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.EAST);
		panel.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_pedidos = new JLabel("\u00DAltimos Pedidos");
		panel_1.add(lbl_pedidos, BorderLayout.NORTH);
		
		JList lst_pedidos = new JList();
		panel_1.add(lst_pedidos, BorderLayout.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_fechamentos = new JLabel("\u00DAltimos Fechamentos");
		panel_2.add(lbl_fechamentos, BorderLayout.NORTH);
		
		JList lst_fechamentos = new JList();
		panel_2.add(lst_fechamentos, BorderLayout.CENTER);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);
		
		JPanel pnl_pedidos = new JPanel();
		tabbedPane.addTab("Pedidos", null, pnl_pedidos, null);
		
		JPanel pnl_mesas = new JPanel();
		tabbedPane.addTab("Mesas", null, pnl_mesas, null);
		
		JPanel pnl_clientes = new JPanel();
		pnl_clientes.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent arg0) {
				MeuResultSet clientes = null;
				
				try
				{
					clientes = DAOs.getClientes().getClientes();
				}
				catch (Exception erro)
				{
					lst_Clientes.add("N�o foi poss�vel conectar ao banco de dados", pnl_clientes);
				}
				
				try
				{
					if (clientes.next()) {
						lst_Clientes.add
					}
				}
				catch (SQLException erro)
				{}
				
			}
		});
		tabbedPane.addTab("Clientes", null, pnl_clientes, null);
		pnl_clientes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		pnl_clientes.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JButton btnPesquisar = new JButton("Pesquisar");
		panel_3.add(btnPesquisar, BorderLayout.SOUTH);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		panel_3.add(lblOrdenarPor, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 1, 0, 0));
		
		JRadioButton rdbtnPedidos = new JRadioButton("Nome");
		buttonGroup.add(rdbtnPedidos);
		panel_4.add(rdbtnPedidos);
		
		JRadioButton rdbtnDataDeCadastro = new JRadioButton("Data de Cadastro");
		buttonGroup.add(rdbtnDataDeCadastro);
		panel_4.add(rdbtnDataDeCadastro);
		
		JRadioButton rdbtnltimaVisita = new JRadioButton("\u00DAltima Visita");
		buttonGroup.add(rdbtnltimaVisita);
		panel_4.add(rdbtnltimaVisita);
		
		JRadioButton rdbtnFrequncia = new JRadioButton("Frequ\u00EAncia");
		buttonGroup.add(rdbtnFrequncia);
		panel_4.add(rdbtnFrequncia);
		
		JRadioButton rdbtnMdiaGasta = new JRadioButton("M\u00E9dia Gasta");
		buttonGroup.add(rdbtnMdiaGasta);
		panel_4.add(rdbtnMdiaGasta);
		
		pnl_clientes.add(lst_Clientes, BorderLayout.CENTER);
		
		JPanel pnl_promocoes = new JPanel();
		tabbedPane.addTab("Promo\u00E7\u00F5es", null, pnl_promocoes, null);
	}
}