/**
 * This file is part of VisiCut.
 * Copyright (C) 2011 - 2013 Thomas Oster <thomas.oster@rwth-aachen.de>
 * RWTH Aachen University - 52062 Aachen, Germany
 *
 *     VisiCut is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     VisiCut is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with VisiCut.  If not, see <http://www.gnu.org/licenses/>.
 **/

/*
 * EditMaterialDialog.java
 *
 * Created on 06.09.2011, 00:43:54
 */
package com.t_oster.visicut.gui;

import com.t_oster.uicomponents.EditableTableProvider;
import com.t_oster.visicut.model.MaterialProfile;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Thomas Oster <thomas.oster@rwth-aachen.de>
 */
public class EditMaterialDialog extends javax.swing.JDialog implements EditableTableProvider
{

  protected MaterialProfile material = null;
  public static final String PROP_MATERIAL = "material";
  private DefaultTableModel tableModel = new DefaultTableModel()
  {

    @Override
    public String getColumnName(int column)
    {
      return java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditMaterialDialog").getString("THICKNESSES");
    }

    @Override
    public int getColumnCount()
    {
      return 1;
    }

    @Override
    public int getRowCount()
    {
      return EditMaterialDialog.this.currentMaterial != null ? EditMaterialDialog.this.currentMaterial.getMaterialThicknesses().size() : 0;
    }

    @Override
    public Object getValueAt(int row, int column)
    {
      return EditMaterialDialog.this.currentMaterial.getMaterialThicknesses().get(row);
    }

    @Override
    public boolean isCellEditable(int row, int column)
    {
      return true;
    }

    @Override
    public void setValueAt(Object aValue, int row, int column)
    {
      EditMaterialDialog.this.currentMaterial.getMaterialThicknesses().set(row, (Float) aValue);
    }

    @Override
    public Class getColumnClass(int columnIndex)
    {
      return Float.class;
    }
  };

  /**
   * Get the value of material
   *
   * @return the value of material
   */
  public MaterialProfile getMaterial()
  {
    return material;
  }

  /**
   * Set the value of material
   *
   * @param material new value of material
   */
  public void setMaterial(MaterialProfile material)
  {
    MaterialProfile oldMaterial = this.material;
    this.material = material;
    firePropertyChange(PROP_MATERIAL, oldMaterial, material);
    if (material == null)
    {
      this.setCurrentMaterial(new MaterialProfile());
    }
    else
    {
      this.setCurrentMaterial(material.clone());
    }
  }
  protected MaterialProfile currentMaterial = new MaterialProfile();
  public static final String PROP_CURRENTMATERIAL = "currentMaterial";

  /**
   * Get the value of currentMaterial
   *
   * @return the value of currentMaterial
   */
  public MaterialProfile getCurrentMaterial()
  {
    return currentMaterial;
  }

  /**
   * Set the value of currentMaterial
   *
   * @param currentMaterial new value of currentMaterial
   */
  public void setCurrentMaterial(MaterialProfile currentMaterial)
  {
    MaterialProfile oldCurrentMaterial = this.currentMaterial;
    this.currentMaterial = currentMaterial;
    this.editableTablePanel1.setObjects((List) this.currentMaterial.getMaterialThicknesses());
    firePropertyChange(PROP_CURRENTMATERIAL, oldCurrentMaterial, currentMaterial);
  }

  /** Creates new form EditMaterialDialog */
  public EditMaterialDialog(java.awt.Frame parent, boolean modal)
  {
    super(parent, modal);
    initComponents();
    this.editableTablePanel1.setTableModel(tableModel);
    this.editableTablePanel1.setProvider(this);
  }

  /** This method is called from within the constructor to
   * initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is
   * always regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        jTextField1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        selectThumbnailButton1 = new com.t_oster.uicomponents.SelectThumbnailButton();
        materialColorButton = new com.t_oster.uicomponents.ChooseColorButton();
        chooseCutColorButton = new com.t_oster.uicomponents.ChooseColorButton();
        jLabel7 = new javax.swing.JLabel();
        chooseEngraveButton = new com.t_oster.uicomponents.ChooseColorButton();
        jLabel8 = new javax.swing.JLabel();
        editableTablePanel1 = new com.t_oster.uicomponents.EditableTablePanel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditMaterialDialog"); // NOI18N
        setTitle(bundle.getString("TITLE")); // NOI18N
        setName("Form"); // NOI18N

        jTextField1.setName("jTextField1"); // NOI18N

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.name}"), jTextField1, org.jdesktop.beansbinding.BeanProperty.create("text"), "name");
        bindingGroup.addBinding(binding);

        org.jdesktop.application.ResourceMap resourceMap = org.jdesktop.application.Application.getInstance(com.t_oster.visicut.gui.VisicutApp.class).getContext().getResourceMap(EditMaterialDialog.class);
        jLabel1.setText(resourceMap.getString("Name")); // NOI18N
        jLabel1.setName("jLabel1"); // NOI18N

        jLabel2.setText(resourceMap.getString("Description")); // NOI18N
        jLabel2.setName("jLabel2"); // NOI18N

        jTextField2.setName("jTextField2"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.description}"), jTextField2, org.jdesktop.beansbinding.BeanProperty.create("text"), "Description");
        bindingGroup.addBinding(binding);

        jLabel5.setText(resourceMap.getString("jLabel5.text")); // NOI18N
        jLabel5.setName("jLabel5"); // NOI18N

        jButton3.setText(resourceMap.getString("jButton3.text")); // NOI18N
        jButton3.setName("jButton3"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText(resourceMap.getString("jButton4.text")); // NOI18N
        jButton4.setName("jButton4"); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        selectThumbnailButton1.setName("selectThumbnailButton1"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.thumbnailPath}"), selectThumbnailButton1, org.jdesktop.beansbinding.BeanProperty.create("thumbnailPath"), "thumbnailbt");
        bindingGroup.addBinding(binding);

        materialColorButton.setText(resourceMap.getString("materialColorButton.text")); // NOI18N
        materialColorButton.setName("materialColorButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.color}"), materialColorButton, org.jdesktop.beansbinding.BeanProperty.create("selectedColor"), "selectedColor");
        bindingGroup.addBinding(binding);

        chooseCutColorButton.setText(resourceMap.getString("chooseCutColorButton.text")); // NOI18N
        chooseCutColorButton.setName("chooseCutColorButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.cutColor}"), chooseCutColorButton, org.jdesktop.beansbinding.BeanProperty.create("selectedColor"), "cutColor");
        bindingGroup.addBinding(binding);

        jLabel7.setText(resourceMap.getString("jLabel7.text")); // NOI18N
        jLabel7.setName("jLabel7"); // NOI18N

        chooseEngraveButton.setText(resourceMap.getString("chooseEngraveButton.text")); // NOI18N
        chooseEngraveButton.setName("chooseEngraveButton"); // NOI18N

        binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, this, org.jdesktop.beansbinding.ELProperty.create("${currentMaterial.engraveColor}"), chooseEngraveButton, org.jdesktop.beansbinding.BeanProperty.create("selectedColor"), "engraveColor");
        bindingGroup.addBinding(binding);

        jLabel8.setText(resourceMap.getString("jLabel8.text")); // NOI18N
        jLabel8.setName("jLabel8"); // NOI18N

        editableTablePanel1.setEditButtonVisible(false);
        editableTablePanel1.setName("editableTablePanel1"); // NOI18N

        jLabel3.setFont(resourceMap.getFont("jLabel3.font")); // NOI18N
        jLabel3.setText(resourceMap.getString("MaterialHelptext")); // NOI18N
        jLabel3.setName("jLabel3"); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 581, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chooseEngraveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(materialColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 278, Short.MAX_VALUE)
                                .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(chooseCutColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                            .addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(materialColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chooseCutColorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(chooseEngraveButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addComponent(selectThumbnailButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(editableTablePanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addContainerGap())
        );

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

  private void jButton3ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton3ActionPerformed
  {//GEN-HEADEREND:event_jButton3ActionPerformed
    // if no thickness was set, give a warning and don't close the dialog
    if (this.currentMaterial.getMaterialThicknesses().isEmpty()) {
      javax.swing.JOptionPane.showMessageDialog(null, java.util.ResourceBundle.getBundle("com/t_oster/visicut/gui/resources/EditMaterialDialog").getString("ERROR_PLEASE_ADD_A_THICKNESS"), "VisiCut", JOptionPane.WARNING_MESSAGE);
      return;
    }
    //clean up duplicates
    Set<Float> set = new LinkedHashSet<Float>();
    set.addAll(this.currentMaterial.getMaterialThicknesses());
    this.currentMaterial.getMaterialThicknesses().clear();
    this.currentMaterial.getMaterialThicknesses().addAll(set);
    this.setMaterial(this.getCurrentMaterial());
    this.setVisible(false);
  }//GEN-LAST:event_jButton3ActionPerformed

  private void jButton4ActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_jButton4ActionPerformed
  {//GEN-HEADEREND:event_jButton4ActionPerformed
    this.setMaterial(null);
    this.setVisible(false);
  }//GEN-LAST:event_jButton4ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.t_oster.uicomponents.ChooseColorButton chooseCutColorButton;
    private com.t_oster.uicomponents.ChooseColorButton chooseEngraveButton;
    private com.t_oster.uicomponents.EditableTablePanel editableTablePanel1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private com.t_oster.uicomponents.ChooseColorButton materialColorButton;
    private com.t_oster.uicomponents.SelectThumbnailButton selectThumbnailButton1;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

  public Object getNewInstance()
  {
    return new Float(2f);
  }

  public Object editObject(Object o)
  {
    return o;
  }
}
