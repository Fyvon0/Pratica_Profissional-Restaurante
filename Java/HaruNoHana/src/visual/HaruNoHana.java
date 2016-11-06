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
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import javax.swing.JTabbedPane;
import javax.swing.JLayeredPane;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.sql.SQLException;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HaruNoHana implements ActionListener{

	private JFrame frame;
	private ButtonGroup btnGrpOrdemCliente = new ButtonGroup();
	private JTable tbl_clientes;
	DefaultTableModel tableModel;

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
	public HaruNoHana(){
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(){
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
		tabbedPane.addTab("Clientes", null, pnl_clientes, null);
		pnl_clientes.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		pnl_clientes.add(panel_3, BorderLayout.EAST);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		String [] header = {"codCliente","userLogin","frequencia","nome","ultimaVisita","dataCadastro","mediaGasta","celular"};
		tableModel = new DefaultTableModel(header, 0);
		tbl_clientes = new JTable(tableModel);
		tbl_clientes.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				//btnPesquisar.doClick();
			}
		});
		pnl_clientes.add(tbl_clientes, BorderLayout.CENTER);
		
		JLabel lblOrdenarPor = new JLabel("Ordenar por:");
		panel_3.add(lblOrdenarPor, BorderLayout.NORTH);
		
		JPanel panel_4 = new JPanel();
		panel_3.add(panel_4, BorderLayout.CENTER);
		panel_4.setLayout(new GridLayout(5, 1, 0, 0));
		
		JRadioButton rdbtnNome = new JRadioButton("Nome");
		rdbtnNome.setActionCommand("nome");
		rdbtnNome.setSelected(true);
		btnGrpOrdemCliente.add(rdbtnNome);
		panel_4.add(rdbtnNome);
		
		JRadioButton rdbtnDataDeCadastro = new JRadioButton("Data de Cadastro");
		rdbtnDataDeCadastro.setActionCommand("dataCadastro");
		btnGrpOrdemCliente.add(rdbtnDataDeCadastro);
		panel_4.add(rdbtnDataDeCadastro);
		
		JRadioButton rdbtnUltimaVisita = new JRadioButton("\u00DAltima Visita");
		rdbtnUltimaVisita.setActionCommand("ultimaVisita");
		btnGrpOrdemCliente.add(rdbtnUltimaVisita);
		panel_4.add(rdbtnUltimaVisita);
		
		JRadioButton rdbtnFrequencia = new JRadioButton("Frequ\u00EAncia");
		rdbtnFrequencia.setActionCommand("frequencia");
		btnGrpOrdemCliente.add(rdbtnFrequencia);
		panel_4.add(rdbtnFrequencia);
		
		JRadioButton rdbtnMediaGasta = new JRadioButton("M\u00E9dia Gasta");
		rdbtnMediaGasta.setActionCommand("mediaGasta");
		btnGrpOrdemCliente.add(rdbtnMediaGasta);
		panel_4.add(rdbtnMediaGasta);
		
		rdbtnNome.addActionListener(this);
		rdbtnDataDeCadastro.addActionListener(this);
		rdbtnFrequencia.addActionListener(this);
		rdbtnUltimaVisita.addActionListener(this);
		rdbtnMediaGasta.addActionListener(this);
		
		JPanel pnl_promocoes = new JPanel();
		tabbedPane.addTab("Promo\u00E7\u00F5es", null, pnl_promocoes, null);
	}

	public void actionPerformed(ActionEvent e) {
		MeuResultSet clientes = null;
		
		try 
		{
			clientes = DAOs.getClientes().getClientesOrdenado(e.getActionCommand());
		}
		catch (Exception erro)
		{
			JOptionPane.showMessageDialog(null, e.toString(), "Error",
                    JOptionPane.ERROR_MESSAGE);
		}
		
		try
		{
			while (clientes.next())
				tableModel.addRow(new Object[] {clientes.getInt("codCliente"),clientes.getString("userLogin"),clientes.getFloat("frequencia"),
					clientes.getString("nome"),clientes.getTimestamp("ultimaVisita"),clientes.getTimestamp("dataCadastro"),
					clientes.getFloat("mediaGasta"),clientes.getString("celular")});
		}
		catch (SQLException erro)
		{JOptionPane.showMessageDialog(null, e.toString(), "Error",
                JOptionPane.ERROR_MESSAGE);
		}
	}
}
