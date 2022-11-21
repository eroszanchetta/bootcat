/*  This file is part of BootCaT frontend.
 *
 *  BootCaT frontend is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  BootCaT frontend is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with BootCaT frontend.  If not, see <http://www.gnu.org/licenses/>.
 *
 */

package gui.dialogs;

import gui.Main;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;

/**
 *
 * @author Eros Zanchetta
 */
public class GenericMessage extends javax.swing.JDialog {

	private String  url;
    private File    directory;

	public enum Type {
		ERROR,
		INFO,
		WARNING
	}

	public GenericMessage(java.awt.Frame parent, boolean modal, String message) {
		this(parent, modal, message, Type.INFO, null, null);
	}

	public GenericMessage(java.awt.Frame parent, boolean modal, String message, Type type) {
		this(parent, modal, message, type, null, null);
	}
    
	public GenericMessage(java.awt.Frame parent, boolean modal, String message, Type type, String url, File directory) {
		this(parent, modal);

		setMessage(message);

		this.url        = url;
        this.directory  = directory;

		if (url != null) {
            visitUrlLabel.setVisible(true);
            visitUrlLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else {
            visitUrlLabel.setVisible(false);
        }
        
        if (directory != null) {
            openFolderLabel.setVisible(true);
            openFolderLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        }
        else {
            openFolderLabel.setVisible(false);
        }

		String iconType = null;
		String iconTypeSmall = null;
		switch (type) {
			default:
			case ERROR:
				iconType = "/gui/resources/dialog-error.png";
				iconTypeSmall = "/gui/resources/dialog-error_16x16.png";
				setTitle("Error");
				break;
			case INFO:
				iconType = "/gui/resources/dialog-info.png";
				iconTypeSmall = "/gui/resources/dialog-info_16x16.png";
				setTitle("Info");
				break;
			case WARNING:
				iconType = "/gui/resources/dialog-warning.png";
				iconTypeSmall = "/gui/resources/dialog-info_16x16.png";
				setTitle("Warning");
				break;
		}

		textLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource(iconType)));
        
        // Commented this out because it breaks FlatLAF on Windows
//		setIconImage(Toolkit.getDefaultToolkit().getImage(iconType));
        
        // pack causes this Window to be sized to fit the preferred size and layouts of its subcomponents
        this.pack();
        centerOnScreen();
	}

    /** Creates new form GenericMessage */
    public GenericMessage(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        centerOnScreen();
    }

    private void centerOnScreen() {
        // work out current screen resolution and center main window
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        int initialXPosition = (dim.width - this.getSize().width) / 2;
        int initialYPosition = (dim.height - this.getSize().height) / 2;

		this.setLocation(initialXPosition, initialYPosition);        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textLabel = new javax.swing.JLabel();
        okButton = new javax.swing.JButton();
        visitUrlLabel = new javax.swing.JLabel();
        openFolderLabel = new javax.swing.JLabel();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setModal(true);

        textLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/resources/dialog-error.png"))); // NOI18N
        textLabel.setText("The message will be displayed here");
        textLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        textLabel.setIconTextGap(10);
        textLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textLabelMouseClicked(evt);
            }
        });

        okButton.setText("OK");
        okButton.setAlignmentY(0.0F);
        okButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okButtonActionPerformed(evt);
            }
        });

        visitUrlLabel.setForeground(new java.awt.Color(0, 51, 255));
        visitUrlLabel.setText("More info");
        visitUrlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                visitUrlLabelMouseClicked(evt);
            }
        });

        openFolderLabel.setForeground(new java.awt.Color(0, 51, 255));
        openFolderLabel.setText("Open folder");
        openFolderLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                openFolderLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(okButton)
                    .addComponent(textLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(visitUrlLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(openFolderLabel)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(textLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(visitUrlLabel)
                    .addComponent(openFolderLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(okButton)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void okButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okButtonActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_okButtonActionPerformed

	private void textLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textLabelMouseClicked
        
	}//GEN-LAST:event_textLabelMouseClicked

    private void visitUrlLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_visitUrlLabelMouseClicked
        openUrl();
    }//GEN-LAST:event_visitUrlLabelMouseClicked

    private void openFolderLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_openFolderLabelMouseClicked
        openDir();
    }//GEN-LAST:event_openFolderLabelMouseClicked

    private void openUrl() {
        if (url == null) return; 
        
        URI uri = URI.create(url);
        try {
            Desktop.getDesktop().browse(uri);
        } catch (IOException ex) {
            Logger.getLogger(Main.LOGNAME).log(Level.SEVERE, null, ex);
        }            
    }
    
    private void openDir() {
        if (directory == null) return;
        
        try {
            Desktop.getDesktop().open(directory);
        } catch (IOException ex) {
            Logger.getLogger(Main.LOGNAME).log(Level.SEVERE, null, ex);
        }
    }
    
    public void setMessage(String message) {
        this.textLabel.setText("<html><div style='text-align: center;'>" + message + "</div></html>");
    }

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                GenericMessage dialog = new GenericMessage(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JButton okButton;
    private javax.swing.JLabel openFolderLabel;
    private javax.swing.JLabel textLabel;
    private javax.swing.JLabel visitUrlLabel;
    // End of variables declaration//GEN-END:variables

}
