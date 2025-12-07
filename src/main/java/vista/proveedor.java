package vista;

import controlador.DaoProveedor;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.GeneradorPDF;
import modelo.Proveedor;

public class proveedor extends javax.swing.JPanel {

    int idProveedorSeleccionado = -1;

    public proveedor() {
        initComponents();
        cargarProveedores();

        tbproveedor.setDefaultEditor(Object.class, null);
        tbproveedor.getTableHeader().setResizingAllowed(false);
        tbproveedor.getTableHeader().setReorderingAllowed(false);

        tbproveedor.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbproveedor.getTableHeader().setBackground(new java.awt.Color(50, 130, 181));
        tbproveedor.getTableHeader().setForeground(Color.white);
        tbproveedor.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        tbproveedor.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tbproveedor.getSelectedRow() != -1) {

                int fila = tbproveedor.getSelectedRow();

                idProveedorSeleccionado = Integer.parseInt(tbproveedor.getValueAt(fila, 0).toString());
                txtproveedor.setText(tbproveedor.getValueAt(fila, 1).toString());
                txtapellidoprov.setText(tbproveedor.getValueAt(fila, 2).toString());
                txtdniprov.setText(tbproveedor.getValueAt(fila, 3).toString());
                txtrsocial.setText(tbproveedor.getValueAt(fila, 4).toString());
                txtdireccionprov.setText(tbproveedor.getValueAt(fila, 5).toString());
                txttelefonoprov.setText(tbproveedor.getValueAt(fila, 6).toString());
                txtcorreoprov.setText(tbproveedor.getValueAt(fila, 7).toString());
            }
        });
    }

    private void cargarProveedores() {  
        DaoProveedor dao = new DaoProveedor();
        List<Proveedor> lista = dao.obtenerProveedores();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("R.Social");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Correo");

        for (Proveedor p : lista) {
            modelo.addRow(new Object[]{
                p.getIdProveedor(),
                p.getNombre(),
                p.getApellido(),
                p.getDocumento(),
                p.getRsocial(),
                p.getDireccion(),
                p.getTelefono(),
                p.getCorreo()
            });
        }

        tbproveedor.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtproveedor = new javax.swing.JTextField();
        txtapellidoprov = new javax.swing.JTextField();
        txtdniprov = new javax.swing.JTextField();
        txtrsocial = new javax.swing.JTextField();
        txtdireccionprov = new javax.swing.JTextField();
        txttelefonoprov = new javax.swing.JTextField();
        txtcorreoprov = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbproveedor = new javax.swing.JTable();
        btnbusprov = new javax.swing.JButton();
        btnelimprov = new javax.swing.JButton();
        btnproveedor = new javax.swing.JButton();
        btneditprov = new javax.swing.JButton();
        btnexporproveedor = new javax.swing.JButton();
        btnlimpiar1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de proveedores");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Complete la Informacion de los proveedores.");

        txtproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproveedorActionPerformed(evt);
            }
        });

        txtapellidoprov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtapellidoprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoprovActionPerformed(evt);
            }
        });

        txtdniprov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtdniprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdniprovActionPerformed(evt);
            }
        });

        txtrsocial.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtrsocial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtrsocialActionPerformed(evt);
            }
        });

        txtdireccionprov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtdireccionprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionprovActionPerformed(evt);
            }
        });

        txttelefonoprov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txttelefonoprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoprovActionPerformed(evt);
            }
        });

        txtcorreoprov.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtcorreoprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcorreoprovActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Apellido");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Documento");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Razón social");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Dirección");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Teléfono");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Correo");

        tbproveedor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "Documento", "R.Social", "Dirección", "Teléfono", "Correo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbproveedor);
        if (tbproveedor.getColumnModel().getColumnCount() > 0) {
            tbproveedor.getColumnModel().getColumn(0).setResizable(false);
            tbproveedor.getColumnModel().getColumn(1).setResizable(false);
            tbproveedor.getColumnModel().getColumn(2).setResizable(false);
            tbproveedor.getColumnModel().getColumn(3).setResizable(false);
            tbproveedor.getColumnModel().getColumn(4).setResizable(false);
            tbproveedor.getColumnModel().getColumn(5).setResizable(false);
            tbproveedor.getColumnModel().getColumn(6).setResizable(false);
        }

        btnbusprov.setBackground(new java.awt.Color(50, 130, 181));
        btnbusprov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnbusprov.setForeground(new java.awt.Color(255, 255, 255));
        btnbusprov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnbusprov.setText("Buscar");
        btnbusprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusprovActionPerformed(evt);
            }
        });

        btnelimprov.setBackground(new java.awt.Color(50, 130, 181));
        btnelimprov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimprov.setForeground(new java.awt.Color(255, 255, 255));
        btnelimprov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnelimprov.setText("Eliminar");
        btnelimprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimprovActionPerformed(evt);
            }
        });

        btnproveedor.setBackground(new java.awt.Color(50, 130, 181));
        btnproveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnproveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnproveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnproveedor.setText("Guardar");
        btnproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedorActionPerformed(evt);
            }
        });

        btneditprov.setBackground(new java.awt.Color(50, 130, 181));
        btneditprov.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditprov.setForeground(new java.awt.Color(255, 255, 255));
        btneditprov.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btneditprov.setText("Editar");
        btneditprov.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditprovActionPerformed(evt);
            }
        });

        btnexporproveedor.setBackground(new java.awt.Color(50, 130, 181));
        btnexporproveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnexporproveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnexporproveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnexporproveedor.setText("Exportar");
        btnexporproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexporproveedorActionPerformed(evt);
            }
        });

        btnlimpiar1.setBackground(new java.awt.Color(50, 130, 181));
        btnlimpiar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/limpiar.png"))); // NOI18N
        btnlimpiar1.setText("Limpiar");
        btnlimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar1ActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtproveedor)
                                .addComponent(txtapellidoprov)
                                .addComponent(txtdniprov)
                                .addComponent(txtrsocial)
                                .addComponent(txtdireccionprov)
                                .addComponent(txttelefonoprov)
                                .addComponent(txtcorreoprov, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE))
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(btnproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btneditprov, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnelimprov, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addComponent(btnlimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnexporproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnbusprov, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 679, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(jLabel11)))
                .addGap(18, 18, 18)
                .addComponent(btnbusprov)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(txtproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(txtapellidoprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(18, 18, 18)
                                .addComponent(txtdniprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtrsocial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(txtdireccionprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txttelefonoprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtcorreoprov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1))
                        .addContainerGap(142, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnproveedor)
                            .addComponent(btneditprov)
                            .addComponent(btnelimprov)
                            .addComponent(btnexporproveedor)
                            .addComponent(btnlimpiar1))
                        .addGap(63, 63, 63))))
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

    private void txtcorreoprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcorreoprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtcorreoprovActionPerformed

    private void btnbusprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusprovActionPerformed
    ForProveedor formulario2 = new ForProveedor();
    formulario2.setVisible(true);
    }//GEN-LAST:event_btnbusprovActionPerformed

    private void btnelimprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimprovActionPerformed

        if (idProveedorSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "¿Eliminar proveedor?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            DaoProveedor dao = new DaoProveedor();

            if (dao.eliminarProveedor(idProveedorSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Proveedor eliminado.");
                cargarProveedores();
                limpiarCampos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnelimprovActionPerformed

    private void btnproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedorActionPerformed
        if (txtproveedor.getText().trim().isEmpty()
                || txtapellidoprov.getText().trim().isEmpty()
                || txtdniprov.getText().trim().isEmpty()
                || txtrsocial.getText().trim().isEmpty()
                || txtdireccionprov.getText().trim().isEmpty()
                || txttelefonoprov.getText().trim().isEmpty()
                || txtcorreoprov.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Proveedor p = new Proveedor();
        p.setNombre(txtproveedor.getText());
        p.setApellido(txtapellidoprov.getText());
        p.setDocumento(txtdniprov.getText());
        p.setRsocial(txtrsocial.getText());
        p.setDireccion(txtdireccionprov.getText());
        p.setTelefono(txttelefonoprov.getText());
        p.setCorreo(txtcorreoprov.getText());

        DaoProveedor dao = new DaoProveedor();

        if (dao.guardarProveedor(p)) {
            JOptionPane.showMessageDialog(this, "Proveedor guardado.");
            cargarProveedores();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnproveedorActionPerformed

    private void btneditprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditprovActionPerformed
        if (idProveedorSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un proveedor.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        Proveedor p = new Proveedor();
        p.setIdProveedor(idProveedorSeleccionado);
        p.setNombre(txtproveedor.getText());
        p.setApellido(txtapellidoprov.getText());
        p.setDocumento(txtdniprov.getText());
        p.setRsocial(txtrsocial.getText());
        p.setDireccion(txtdireccionprov.getText());
        p.setTelefono(txttelefonoprov.getText());
        p.setCorreo(txtcorreoprov.getText());

        DaoProveedor dao = new DaoProveedor();

        if (dao.actualizarProveedor(p)) {
            JOptionPane.showMessageDialog(this, "Proveedor actualizado.");
            cargarProveedores();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditprovActionPerformed

    private void btnexporproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexporproveedorActionPerformed
// Verificar que haya datos en la tabla
        if (tbproveedor.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this,
                    "No hay datos para exportar",
                    "Tabla vacía",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Crear el selector de archivos
        javax.swing.JFileChooser fileChooser = new javax.swing.JFileChooser();
        fileChooser.setDialogTitle("Guardar reporte PDF");

        // Establecer nombre de archivo por defecto
        fileChooser.setSelectedFile(new java.io.File("Reporte_Proveedor.pdf"));

        // Filtro para solo mostrar archivos PDF
        javax.swing.filechooser.FileNameExtensionFilter filtro
                = new javax.swing.filechooser.FileNameExtensionFilter("Archivos PDF (*.pdf)", "pdf");
        fileChooser.setFileFilter(filtro);

        // Mostrar ventana de diálogo
        int resultado = fileChooser.showSaveDialog(this);

        if (resultado == javax.swing.JFileChooser.APPROVE_OPTION) {
            // Obtener la ruta seleccionada
            String rutaArchivo = fileChooser.getSelectedFile().getAbsolutePath();

            // Asegurar que termine en .pdf
            if (!rutaArchivo.toLowerCase().endsWith(".pdf")) {
                rutaArchivo += ".pdf";
            }

            // Crear instancia del generador
            GeneradorPDF generador = new GeneradorPDF();

            // Generar el PDF
            boolean exito = generador.generarPDFTabla(
                    rutaArchivo,
                    tbproveedor,
                    "REPORTE DE PROVEEDORES",
                    "Listado completo de proveedores registrados en el sistema"
            );

            if (exito) {
                JOptionPane.showMessageDialog(this,
                        "PDF generado exitosamente\n",
                        "Exportación exitosa",
                        JOptionPane.INFORMATION_MESSAGE);

                // Opcional: Abrir el PDF automáticamente
                try {
                    java.awt.Desktop.getDesktop().open(new java.io.File(rutaArchivo));
                } catch (Exception e) {
                    // Si no se puede abrir, solo ignorar
                }
            } else {
                JOptionPane.showMessageDialog(this,
                        "Error al generar el PDF",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnexporproveedorActionPerformed

    private void btnlimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiar1ActionPerformed

    private void txtproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproveedorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproveedorActionPerformed

    private void txtapellidoprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtapellidoprovActionPerformed

    private void txtdniprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdniprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdniprovActionPerformed

    private void txtrsocialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtrsocialActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtrsocialActionPerformed

    private void txtdireccionprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdireccionprovActionPerformed

    private void txttelefonoprovActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoprovActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttelefonoprovActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusprov;
    private javax.swing.JButton btneditprov;
    private javax.swing.JButton btnelimprov;
    private javax.swing.JButton btnexporproveedor;
    private javax.swing.JButton btnlimpiar1;
    private javax.swing.JButton btnproveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbproveedor;
    private javax.swing.JTextField txtapellidoprov;
    private javax.swing.JTextField txtcorreoprov;
    private javax.swing.JTextField txtdireccionprov;
    private javax.swing.JTextField txtdniprov;
    private javax.swing.JTextField txtproveedor;
    private javax.swing.JTextField txtrsocial;
    private javax.swing.JTextField txttelefonoprov;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        txtproveedor.setText("");
        txtapellidoprov.setText("");
        txtdniprov.setText("");
        txtrsocial.setText("");
        txtdireccionprov.setText("");
        txttelefonoprov.setText("");
        txtcorreoprov.setText("");

        idProveedorSeleccionado = -1;
        tbproveedor.clearSelection();
    }

}
