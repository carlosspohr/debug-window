package com.wp.carlos4web.utils.debug;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Constrói uma janela dialog da classe JOptionPane.showMessageDialog
 * 
 * @author Carlos A. Junior
 *
 * @see JOptionPane.showMessageDialog
 */
public class DebugWindow {

	private Object object;

	public DebugWindow(Object object) {
		super();
		this.object = object;
		this.show();
	}
	
	private void show () {
		
		final JTextArea textArea = new JTextArea();
		textArea.setFont		(new Font(Font.MONOSPACED, Font.PLAIN, 12));
		textArea.setAlignmentY	(JTextArea.RIGHT_ALIGNMENT);
		textArea.setEditable	(false);
		
		StringBuilder builder = StringHelper.reflectObject(object);
		
		textArea.append			(builder.toString());
		
		JScrollPane scroll = new JScrollPane(textArea);		
		scroll.setPreferredSize(new Dimension(500, 250));
		
		JOptionPane.showMessageDialog(null, scroll, "Dados do objeto", JOptionPane.INFORMATION_MESSAGE);
	}
	
	public static void main(String[] args) {
		
		Cliente c = new Cliente();
		
		c.setNome("Carlos Alberto Junior");
		c.setId(new Long(4559494));
		c.setIdade(25);
		c.setEmail("carlosjrcabello@gmail.com");
		
		new DebugWindow(c);
	}
}
