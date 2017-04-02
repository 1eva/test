package Grafik;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Main {

	public static void main(String[] args) {
		
		ConnectionDB connect = new ConnectionDB("localhost", "SYSDBA", "masterkey", "c:/DB/GRAFIK.fdb");
		connect.initProperties();
		connect.init();
		
		JFrame frame = new JFrame("table");
		frame.setSize(new Dimension(600, 400));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setLayout(new GridBagLayout());
		
		JButton addButton = new JButton("add");
		JButton delButton = new JButton("delete");
		JButton clearButton = new JButton("clear");
		
		Table tm = new Table();
		JTable table = new JTable(tm);
		JScrollPane tableScroll = new JScrollPane(table);
		tableScroll.setPreferredSize(new Dimension(600, 400));
		
		tm.addData(connect);
		
		/*
		String []str = new String[4];
		str[0] = "0";
		str[1] = "name";
		str[2] = "111";
		str[3] = "222";
		
		tm.addData(str);
		
		*/
		
		frame.add(tableScroll, new GridBagConstraints(0, 0, 3, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
		
		frame.add(addButton, new GridBagConstraints(0, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
		frame.add(delButton, new GridBagConstraints(1, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
		frame.add(clearButton, new GridBagConstraints(2, 1, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.BOTH, new Insets(1, 1, 1, 1), 0, 0));
		
		frame.setVisible(true);
		frame.pack();
		
		/*
		ConnectionDB connect = new ConnectionDB("localhost", "SYSDBA", "masterkey", "c:/DB/GRAFIK.fdb");
		connect.initProperties();
		connect.init();
		ResultSet res = connect.query("SELECT * from DEP");
		connect.closeConnection();
		*/

	}

}
