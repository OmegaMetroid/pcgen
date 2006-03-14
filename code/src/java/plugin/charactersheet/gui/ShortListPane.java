/*
 * featPane.java
 *
 * Created on February 12, 2004, 4:32 PM
 */

package plugin.charactersheet.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author  ddjone3
 */
public class ShortListPane extends javax.swing.JPanel {
	private List list = new ArrayList();

	/** Creates new form featPane */
	public ShortListPane() {
		initComponents();
		setLocalColor();
	}

	/** This method is called from within the constructor to
	 * initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	private void initComponents() {//GEN-BEGIN:initComponents
		jPanel1 = new javax.swing.JPanel();
		title = new javax.swing.JLabel();
		listPane = new javax.swing.JPanel();

		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

		jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 1, 0));

		title.setFont(new java.awt.Font("Dialog", 1, 14));
		title.setText(" ");
		jPanel1.add(title);

		add(jPanel1);

		listPane.setLayout(new javax.swing.BoxLayout(listPane, javax.swing.BoxLayout.Y_AXIS));

		add(listPane);

	}//GEN-END:initComponents


	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel listPane;
	private javax.swing.JLabel title;
	// End of variables declaration//GEN-END:variables

	public void setColor() {
		setLocalColor();
		refresh();
	}

	public void setLocalColor() {
		setBackground(CharacterPanel.white);
		jPanel1.setBackground(CharacterPanel.header);
		jPanel1.setBorder(new javax.swing.border.LineBorder(CharacterPanel.border));
		listPane.setBackground(CharacterPanel.white);
		listPane.setBorder(new javax.swing.border.LineBorder(CharacterPanel.border));
	}

	public void setList(String title, List list) {
		this.list = list;
		this.title.setText(title);
		setVisible(false);
		refresh();
	}

	public void refresh() {
		if(list.size() > 0) {
			setVisible(true);
			listPane.removeAll();
			for(int i = 0; i < list.size(); i++) {
				Color color;
				if(i % 2 == 0) {
					color = CharacterPanel.bodyLight;
				}
				else {
					color = CharacterPanel.bodyMedLight;
				}
				addLine(list.get(i).toString(), color, i);
			}
		}
		else {
			setVisible(false);
		}
	}

	private void addLine(String text, Color color, int gridY) {
		javax.swing.JTextArea listDisplay = new javax.swing.JTextArea();
		listDisplay.setLineWrap(true);
		listDisplay.setWrapStyleWord(true);
		listDisplay.setBackground(color);
		listDisplay.setFont(new java.awt.Font("Dialog", 0, 10));
		listDisplay.setText(text);

		listPane.add(listDisplay);
	}

	public void destruct() {
		//Put any code here that is needed to prevent memory leaks when this panel is destroyed
	}
}
