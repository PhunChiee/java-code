package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import bean.nhansu;
import bean.nhanvien;
import bean.sinhvien;
import bo.nhansubo;

import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;

public class NhanSu extends JFrame {

	private JPanel contentPane;
	private JTable table;
	JComboBox cmbns = new JComboBox();
	
	nhansubo nvbo = new nhansubo();
	ArrayList<nhansu> ds;
	void Napbang(ArrayList<nhansu> ds) {
		DefaultTableModel mh = new DefaultTableModel();
		for(nhansu item: ds) {
			 if(item instanceof sinhvien) {
				 sinhvien sv = (sinhvien)item;
				 mh.addColumn("Ma");
				 mh.addColumn("Ho ten");
				 mh.addColumn("Ngay sinh");
				 mh.addColumn("Diem 1");
				 mh.addColumn("Diem 2");
				 mh.addColumn("Diem tb");
				 
			 }
		}
		for(nhansu item: ds) {
			 if(item instanceof nhanvien) {
				 nhanvien sv = (nhanvien)item;
				 mh.addColumn("Ma");
				 mh.addColumn("Ho ten");
				 mh.addColumn("Ngay sinh");
				 mh.addColumn("He so luong");
				 mh.addColumn("Luong");
			 }
		}
		for(nhansu ns: ds) {
			Object[] t = new Object[6];
			t[0] = ns.getMa();
			t[1] = ns.getHoten();
			t[2] = ns.getNgaysinh();
			mh.addRow(t);
		}
		
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhanSu frame = new NhanSu();
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
	ArrayList<nhansu> ns = new ArrayList<nhansu>();
	public NhanSu() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				try {
					FileReader f = new FileReader("ds.txt");
					BufferedReader bf = new BufferedReader(f);
					DefaultListModel<String> mh = new DefaultListModel<String>();
					while(true) {
						String s = bf.readLine();
						if(s == null || s == "") {
							break;
						}
						String[] l = s.split(";");
						cmbns.addItem(l[0]);
						mh.addElement(l[0]);
						//ds.add(new nhansu() );
						
					}
					bf.close();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
				}
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 466);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(25, 184, 494, 235);
		contentPane.add(tabbedPane);
		
		JScrollPane scrollPane = new JScrollPane();
		tabbedPane.addTab("New tab", null, scrollPane, null);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("chon nhan su:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel.setBounds(33, 34, 120, 28);
		contentPane.add(lblNewLabel);
		
		
		cmbns.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				String th = cmbns.getSelectedItem().toString();
				for(nhansu ns: ds) {
					if(ns.getMa().equals(th)) {
						scrollPane.setToolTipText(String.valueOf(ns.getMa()));
				}
			}
			}
		});
		cmbns.setBounds(247, 38, 104, 24);
		contentPane.add(cmbns);
		
		JButton btnNewButton = new JButton("ghi file");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setBounds(46, 127, 85, 21);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("tim");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(318, 127, 85, 21);
		contentPane.add(btnNewButton_1);
	}
}
