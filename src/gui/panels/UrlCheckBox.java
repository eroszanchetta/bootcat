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
 * UrlCheckBox.java
 *
 * Created on 22-apr-2010, 10.57.38
 */

package gui.panels;

import gui.Main;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author Eros Zanchetta <eros@sslmit.unibo.it>
 */
public class UrlCheckBox extends javax.swing.JPanel {

	private UrlEditor urlEditor;
	private String url;

	public String getUrl() {
		return url;
	}

    /** Creates new form UrlCheckBox
     * @param selected     
     * @param url
     * @param urlEditor */
    public UrlCheckBox(String url, boolean selected, UrlEditor urlEditor) {
        initComponents();

		this.urlEditor = urlEditor;
		setSelected(selected);
		setUrl(url);
    }

    /**
     *
     * @param selected
     */
    public final void setSelected(boolean selected) {
		urlCheckBox.setSelected(selected);
	}

	public boolean isSelected() {
		return urlCheckBox.isSelected();
	}

	public final void setUrl(String url) {
		this.url = url;
		urlLabel.setText("<html><a href='" + url + "'>" + url + "</a></html>");
	}

    private void openUrl() {
        URI uri = URI.create(url);
        
        // this is a really messy hack, but it works so let's just go with it
        // if I don't convert the uri to an ascii string the page won't open
        URI asciiUri = URI.create(uri.toASCIIString());

        try {
            Desktop.getDesktop().browse(asciiUri);
        } catch (IOException ex) {
            Logger.getLogger(Main.LOGNAME).log(Level.SEVERE, null, ex);
        }        
    }
    
    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        urlCheckBox = new javax.swing.JCheckBox();
        urlLabel = new javax.swing.JLabel();

        urlCheckBox.setSelected(true);
        urlCheckBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                urlCheckBoxActionPerformed(evt);
            }
        });

        urlLabel.setText("jLabel1");
        urlLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                urlLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(urlCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(urlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(urlCheckBox))
            .addComponent(urlLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

	private void urlCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_urlCheckBoxActionPerformed
		if (urlCheckBox.isSelected()) urlEditor.addUrl();
		else urlEditor.removeUrl();
	}//GEN-LAST:event_urlCheckBoxActionPerformed

    private void urlLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_urlLabelMouseClicked
        openUrl();
    }//GEN-LAST:event_urlLabelMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JCheckBox urlCheckBox;
    private javax.swing.JLabel urlLabel;
    // End of variables declaration//GEN-END:variables

}
