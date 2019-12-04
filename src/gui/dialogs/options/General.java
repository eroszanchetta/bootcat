/*
 *  Copyright (C) 2010 Eros Zanchetta <eros@sslmit.unibo.it>
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/*
 * OptionsGeneral.java
 *
 * Created on May 28, 2010, 12:48:04 PM
 */

package gui.dialogs.options;

import common.UriRedirect;
import gui.Config;
import gui.dialogs.GenericMessage;
import gui.helpers.PathVerifier;
import gui.panels.MainPanel;
import java.awt.Cursor;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

/**
 *
 * @author Eros Zanchetta <eros@sslmit.unibo.it>
 */
public class General extends javax.swing.JPanel {

	private Config      config;
	private Properties  systemPreferences;
	private MainPanel   mainPanel;
	private File        lastOpenedDir;

    /** Creates new form OptionsGeneral */
    public General(MainPanel mainPanel) {
        initComponents();

		this.mainPanel = mainPanel;

		config = mainPanel.getMain().getConfig();

		systemPreferences = mainPanel.getMain().getSystemPreferences();

		populateForm();

		verifyTextFieldStatus();
        
        // change the look of cursors for buttons
        leaveThisOnLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

	private void populateForm() {
		dataDirTextField.setText(config.getDataDir());

		checkUpdatesCheckBox.setSelected(config.getCheckForNewVersion());
        collectStatsCheckBox.setSelected(config.getCollectUsageStatistics());
	}

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        dataDirTextField = new javax.swing.JTextField();
        dataDirError = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dataDirBrowse = new javax.swing.JButton();
        searchPMDirError = new javax.swing.JLabel();
        checkUpdatesCheckBox = new javax.swing.JCheckBox();
        collectStatsCheckBox = new javax.swing.JCheckBox();
        leaveThisOnLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(450, 380));

        dataDirTextField.setEditable(false);

        dataDirError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        dataDirError.setForeground(new java.awt.Color(255, 0, 0));
        dataDirError.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        jLabel4.setText("Folder where corpora will be stored");

        dataDirBrowse.setText("Browse");
        dataDirBrowse.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dataDirBrowseActionPerformed(evt);
            }
        });

        searchPMDirError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        searchPMDirError.setForeground(new java.awt.Color(255, 0, 0));
        searchPMDirError.setVerticalAlignment(javax.swing.SwingConstants.TOP);

        checkUpdatesCheckBox.setSelected(true);
        checkUpdatesCheckBox.setText("Check for new version at startup");
        checkUpdatesCheckBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        checkUpdatesCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        checkUpdatesCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkUpdatesCheckBoxActionPerformed(evt);
            }
        });

        collectStatsCheckBox.setSelected(true);
        collectStatsCheckBox.setText("Collect anonymous usage statistics");
        collectStatsCheckBox.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        collectStatsCheckBox.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        collectStatsCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                collectStatsCheckBoxActionPerformed(evt);
            }
        });

        leaveThisOnLabel.setForeground(new java.awt.Color(0, 51, 153));
        leaveThisOnLabel.setText("(please leave this on!)");
        leaveThisOnLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leaveThisOnLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(leaveThisOnLabel))
                    .addComponent(checkUpdatesCheckBox)
                    .addComponent(dataDirError, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(searchPMDirError, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 410, Short.MAX_VALUE)
                    .addComponent(collectStatsCheckBox)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(dataDirTextField, javax.swing.GroupLayout.DEFAULT_SIZE, 307, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataDirBrowse)
                        .addGap(6, 6, 6)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataDirTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataDirBrowse))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dataDirError, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(103, 103, 103)
                .addComponent(checkUpdatesCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(collectStatsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(leaveThisOnLabel)
                .addGap(29, 29, 29)
                .addComponent(searchPMDirError, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

	private void checkUpdatesCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkUpdatesCheckBoxActionPerformed
		config.setCheckForNewVersion(checkUpdatesCheckBox.isSelected());
}//GEN-LAST:event_checkUpdatesCheckBoxActionPerformed

	private void dataDirBrowseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dataDirBrowseActionPerformed
		JFileChooser fc = new JFileChooser();

		// set initial directory for file chooser (either the last opened directory of the default user directory)
		File currentDir;
		if (lastOpenedDir == null) currentDir = FileSystemView.getFileSystemView().getDefaultDirectory();
		else currentDir = lastOpenedDir;
		fc.setCurrentDirectory(currentDir);

		fc.setMultiSelectionEnabled(false);
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fc.showOpenDialog(this);

		if (fc.getSelectedFile() != null) {
			lastOpenedDir = fc.getSelectedFile();
			String newDataDir = fc.getSelectedFile().getPath();

			if (PathVerifier.dataDir(newDataDir, config, mainPanel.getMain().getDefaultDataDir())) {
				config.setDataPath(newDataDir);
				dataDirTextField.setText(newDataDir);
			}
			else {
				String msg = "The folder you chose is not valid.";
				GenericMessage errorMessage = new GenericMessage(mainPanel, true, msg, GenericMessage.Type.ERROR);
				errorMessage.setVisible(true);
			}
		}

		verifyTextFieldStatus();
	}//GEN-LAST:event_dataDirBrowseActionPerformed

    private void leaveThisOnLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leaveThisOnLabelMouseClicked
        URI uri = URI.create(mainPanel.getMain().redirectUrl(UriRedirect.HELP_USAGESTATS));
        try {
            Desktop.getDesktop().browse(uri);
        } catch (IOException ex) {
            Logger.getLogger(General.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_leaveThisOnLabelMouseClicked

private void collectStatsCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_collectStatsCheckBoxActionPerformed
    config.setCollectUsageStatistics(collectStatsCheckBox.isSelected());
}//GEN-LAST:event_collectStatsCheckBoxActionPerformed

	private void verifyTextFieldStatus() {

		// data dir
		if (dataDirTextField.getText().equals("")) {
			dataDirError.setText("<html><p>Choose the folder where BootCaT will store your corpora</p></html>");
		}
		else dataDirError.setText("");
	}


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox checkUpdatesCheckBox;
    private javax.swing.JCheckBox collectStatsCheckBox;
    private javax.swing.JButton dataDirBrowse;
    private javax.swing.JLabel dataDirError;
    private javax.swing.JTextField dataDirTextField;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel leaveThisOnLabel;
    private javax.swing.JLabel searchPMDirError;
    // End of variables declaration//GEN-END:variables

}
