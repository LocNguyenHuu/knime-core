/* @(#)$RCSfile$ 
 * $Revision$ $Date$ $Author$
 * 
 * -------------------------------------------------------------------
 * This source code, its documentation and all appendant files
 * are protected by copyright law. All rights reserved.
 * 
 * Copyright, 2003 - 2006
 * Universitaet Konstanz, Germany.
 * Lehrstuhl fuer Angewandte Informatik
 * Prof. Dr. Michael R. Berthold
 * 
 * You may not modify, publish, transmit, transfer or sell, reproduce,
 * create derivative works from, distribute, perform, display, or in
 * any way exploit any of the content, in whole or in part, except as
 * otherwise expressly permitted in writing by the copyright owner.
 * -------------------------------------------------------------------
 * 
 * History
 *   21.09.2005 (mb): created
 */
package de.unikn.knime.core.node.defaultnodedialog;

import java.awt.event.ItemListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;

import de.unikn.knime.core.data.DataTableSpec;
import de.unikn.knime.core.node.NodeSettings;

/**
 * Provide a standard component for a dialog that allows to edit a boolean
 * value. Provides label and checkbox as well as functionality to load/store
 * into config object.
 * 
 * @author M. Berthold, University of Konstanz
 */
public final class DialogComponentBoolean extends DialogComponent {
    
    private final JCheckBox m_checkbox;
    private final String m_configName;
    private final boolean m_dftValue;

    /**
     * Constructor put label and checkbox into panel.
     * 
     * @param configName name used in configuration file
     * @param label label for dialog in front of checkbox
     * @param isSelected default value for CheckBox.
     */
    public DialogComponentBoolean(final String configName, final String label,
            final boolean isSelected) {
        this.add(new JLabel(label));
        m_checkbox = new JCheckBox();
        m_checkbox.setSelected(isSelected);
        this.add(m_checkbox);
        m_configName = configName;
        m_dftValue = isSelected;
    }
    
    /**
     * Read value for this dialog component from configuration object.
     * 
     * @param settings The <code>NodeSettings</code> to read from.
     * @param specs The input specs.
     */
    public void loadSettingsFrom(final NodeSettings settings,
            final DataTableSpec[] specs) {
        boolean newBool = settings.getBoolean(m_configName, m_dftValue);
        m_checkbox.setSelected(newBool);
    }

    /**
     * write settings of this dialog component into the configuration object.
     * 
     * @param settings The <code>NodeSettings</code> to write into.
     */
    public void saveSettingsTo(final NodeSettings settings) {
        settings.addBoolean(m_configName, m_checkbox.getModel().isSelected());
    }

    /**
     * @see de.unikn.knime.core.node.defaultnodedialog.DialogComponent
     *      #setEnabledComponents(boolean)
     */
    @Override
    public void setEnabledComponents(final boolean enabled) {
        m_checkbox.setEnabled(enabled);
    }
    
    /**
     * Adds the listener to the underlying checkbox component.
     * @param l The listener to add.
     */
    public void addItemListener(final ItemListener l) {
        m_checkbox.addItemListener(l);
    }
    
    /**
     * Removes the listener from the underlying checkbox component.
     * @param l The listener to remove.
     */
    public void removeItemListener(final ItemListener l) {
        m_checkbox.removeItemListener(l);
    }
    
    /**
     * @return true if the checkbox is selected.
     */
    public boolean isSelected() {
        return m_checkbox.isSelected();
    }

    /**
     * Set the selection state of the checkbox.
     * @param select true or false.
     */
    public void setSelected(final boolean select) {
        m_checkbox.setSelected(select);
    }
    
}
