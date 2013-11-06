package davidjllo.B1nch.Code;

import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Canvas;

public class MainScreen {
	private int [][] relaciones;
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainScreen window = new MainScreen();
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
	public MainScreen(int [][] gRel, int numAristas) {
		relaciones = new int[numAristas][numAristas];
		for(int x=0; x<numAristas; x++){
			for(int y=0; y<numAristas; y++){
				relaciones[x][y] = gRel[x][y];
				System.out.print(relaciones[x][y]);
			}
			System.out.println(" ");
		}
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 735, 522);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addComponent(panel, GroupLayout.DEFAULT_SIZE, 261, Short.MAX_VALUE)
		);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{309, 101, 0};
		gbl_panel.rowHeights = new int[]{23, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JButton btnGenerarGrafo = new JButton("Generar Grafo");
		GridBagConstraints gbc_btnGenerarGrafo = new GridBagConstraints();
		gbc_btnGenerarGrafo.insets = new Insets(0, 0, 5, 5);
		gbc_btnGenerarGrafo.anchor = GridBagConstraints.NORTH;
		gbc_btnGenerarGrafo.gridx = 0;
		gbc_btnGenerarGrafo.gridy = 0;
		panel.add(btnGenerarGrafo, gbc_btnGenerarGrafo);
		
		Canvas canvas = new Canvas();
		GridBagConstraints gbc_canvas = new GridBagConstraints();
		gbc_canvas.gridwidth = 2;
		gbc_canvas.insets = new Insets(0, 0, 0, 5);
		gbc_canvas.gridx = 0;
		gbc_canvas.gridy = 2;
		panel.add(canvas, gbc_canvas);
		frame.getContentPane().setLayout(groupLayout);
	}
	public void drawGraph(int [][] gRel, int numAristas){
		
	}
	public void paint(Graphics g){
		g.drawOval(50, 50, 50, 50);
	}

}
