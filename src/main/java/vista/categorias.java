package vista;

import controlador.DaoCategorias;
import java.awt.Color;
import modelo.Categoria;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public class categorias extends javax.swing.JPanel {

    private int idCategoriaSeleccionada = -1;

    public categorias() {
        initComponents();
        cargarCategorias();

        // No editar celdas
        tbcategorias.setDefaultEditor(Object.class, null);

        // Personalizar encabezados
        tbcategorias.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbcategorias.getTableHeader().setBackground(new java.awt.Color(50, 130, 181)); // azul
        tbcategorias.getTableHeader().setForeground(Color.white);
        tbcategorias.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        // Bloquear acciones del usuario
        tbcategorias.getTableHeader().setResizingAllowed(false);
        tbcategorias.getTableHeader().setReorderingAllowed(false);

        // Cuando seleccionas una fila de la tabla
        tbcategorias.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (tbcategorias.getSelectedRow() != -1) {

                int fila = tbcategorias.getSelectedRow();

                txtcategoria.setText(tbcategorias.getValueAt(fila, 1).toString());
                idCategoriaSeleccionada = Integer.parseInt(tbcategorias.getValueAt(fila, 0).toString());
            }
        });

    }

    // ================== CARGAR DATOS =====================
    private void cargarCategorias() {
        DaoCategorias dao = new DaoCategorias();
        List<Categoria> lista = dao.obtenerCategorias();

        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Categoría");

        for (Categoria c : lista) {
            Object[] fila = new Object[2];
            fila[0] = c.getIdCategoria();
            fila[1] = c.getCategoria();
            modelo.addRow(fila);
        }

        tbcategorias.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbcategorias = new javax.swing.JTable();
        txtcategoria = new javax.swing.JTextField();
        cbcategorias = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btneditcategoria = new javax.swing.JButton();
        btnelimcategoria = new javax.swing.JButton();
        btncategoria = new javax.swing.JButton();
        btnlimpiar2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tbcategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "ID", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbcategorias);
        if (tbcategorias.getColumnModel().getColumnCount() > 0) {
            tbcategorias.getColumnModel().getColumn(0).setResizable(false);
            tbcategorias.getColumnModel().getColumn(1).setResizable(false);
        }

        txtcategoria.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcategoriaActionPerformed(evt);
            }
        });

        cbcategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cereales y Galletas", "Bebidas", "Lácteos", "Frutas y Verduras", "Productos Congelados", "Carnes y Aves", "Panadería", "Productos en Conserva", "Snacks y Aperitivos", "Productos de Higiene" }));
        cbcategorias.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        cbcategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbcategoriasActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de categorías");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Complete la Informacion de las Categorías.");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Nueva categoría");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Categorías predeterminadas");

        btneditcategoria.setBackground(new java.awt.Color(50, 130, 181));
        btneditcategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditcategoria.setForeground(new java.awt.Color(255, 255, 255));
        btneditcategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btneditcategoria.setText("Editar");
        btneditcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditcategoriaActionPerformed(evt);
            }
        });

        btnelimcategoria.setBackground(new java.awt.Color(50, 130, 181));
        btnelimcategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimcategoria.setForeground(new java.awt.Color(255, 255, 255));
        btnelimcategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnelimcategoria.setText("Eliminar");
        btnelimcategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimcategoriaActionPerformed(evt);
            }
        });

        btncategoria.setBackground(new java.awt.Color(50, 130, 181));
        btncategoria.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncategoria.setForeground(new java.awt.Color(255, 255, 255));
        btncategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btncategoria.setText("Guardar");
        btncategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoriaActionPerformed(evt);
            }
        });

        btnlimpiar2.setBackground(new java.awt.Color(50, 130, 181));
        btnlimpiar2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar2.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/limpiar.png"))); // NOI18N
        btnlimpiar2.setText("Limpiar");
        btnlimpiar2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar2ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addContainerGap(779, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(cbcategorias, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addComponent(btncategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 90, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btneditcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(97, 97, 97)
                                .addComponent(btnelimcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnlimpiar2, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 586, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(jLabel2)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtcategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(cbcategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(71, 71, 71)
                        .addComponent(btncategoria)
                        .addGap(217, 217, 217))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 478, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btneditcategoria)
                            .addComponent(btnelimcategoria)
                            .addComponent(btnlimpiar2))
                        .addContainerGap(43, Short.MAX_VALUE))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcategoriaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcategoriaActionPerformed

    private void btneditcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditcategoriaActionPerformed

        if (idCategoriaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría de la tabla.");
            return;
        }

        String categoria = txtcategoria.getText().trim();

        DaoCategorias dao = new DaoCategorias();
        boolean ok = dao.actualizarCategoria(idCategoriaSeleccionada, categoria);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Categoría actualizada.");
            limpiarCampos();
            cargarCategorias();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar.");
        }
    }//GEN-LAST:event_btneditcategoriaActionPerformed

    private void btnelimcategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimcategoriaActionPerformed
        if (idCategoriaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una categoría para eliminar.");
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar categoría?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            DaoCategorias dao = new DaoCategorias();
            boolean ok = dao.eliminarCategoria(idCategoriaSeleccionada);

            if (ok) {
                JOptionPane.showMessageDialog(this, "Categoría eliminada.");
                limpiarCampos();
                cargarCategorias();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.");
            }
        }
    }//GEN-LAST:event_btnelimcategoriaActionPerformed

    private void btncategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoriaActionPerformed
        String categoria = txtcategoria.getText().trim();

        // Si no escribe nada, usar lo que escogió del combo
        if (categoria.isEmpty()) {
            categoria = cbcategorias.getSelectedItem().toString();
        }

        if (categoria.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Debe escribir o seleccionar una categoría.");
            return;
        }

        DaoCategorias dao = new DaoCategorias();
        boolean ok = dao.guardarCategoria(categoria);

        if (ok) {
            JOptionPane.showMessageDialog(this, "Categoría guardada.");
            limpiarCampos();
            cargarCategorias();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar categoría.");
        }
    }//GEN-LAST:event_btncategoriaActionPerformed

    private void btnlimpiar2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar2ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiar2ActionPerformed

    private void cbcategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbcategoriasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbcategoriasActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncategoria;
    private javax.swing.JButton btneditcategoria;
    private javax.swing.JButton btnelimcategoria;
    private javax.swing.JButton btnlimpiar2;
    private javax.swing.JComboBox<String> cbcategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbcategorias;
    private javax.swing.JTextField txtcategoria;
    // End of variables declaration//GEN-END:variables

// ================== MÉTODO LIMPIAR =====================
    private void limpiarCampos() {
        txtcategoria.setText("");
        cbcategorias.setSelectedIndex(0);
        idCategoriaSeleccionada = -1;
        tbcategorias.clearSelection();
    }

}
