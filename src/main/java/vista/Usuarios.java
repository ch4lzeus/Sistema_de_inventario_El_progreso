package vista;

import controlador.DaoUsuarios;
import java.awt.Color;
import javax.swing.JOptionPane;
import java.util.List;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import modelo.Usuario;

public class Usuarios extends javax.swing.JPanel {

    // Declaración de la variable para almacenar el ID seleccionado
    private int idUsuarioSeleccionado = -1;

    public Usuarios() {
        initComponents();
        cargarUsuarios();

        // No editar celdas
        tbusuarios.setDefaultEditor(Object.class, null);

        // Personalizar encabezados
        tbusuarios.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbusuarios.getTableHeader().setBackground(new java.awt.Color(50, 130, 181)); // azul
        tbusuarios.getTableHeader().setForeground(Color.white);
        tbusuarios.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        // Bloquear acciones del usuario
        tbusuarios.getTableHeader().setResizingAllowed(false);
        tbusuarios.getTableHeader().setReorderingAllowed(false);

        // Añadir el ListSelectionListener para obtener la fila seleccionada
        tbusuarios.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            // Verificar si se ha seleccionado una fila
            if (tbusuarios.getSelectedRow() != -1) {
                int filaSeleccionada = tbusuarios.getSelectedRow();

                // Cargar los datos de la fila seleccionada en los campos correspondientes
                txtnombre.setText(tbusuarios.getValueAt(filaSeleccionada, 1).toString());
                txtapellido.setText(tbusuarios.getValueAt(filaSeleccionada, 2).toString());
                txtdocumento.setText(tbusuarios.getValueAt(filaSeleccionada, 3).toString());
                txtdireccion.setText(tbusuarios.getValueAt(filaSeleccionada, 4).toString());
                txttelefono.setText(tbusuarios.getValueAt(filaSeleccionada, 5).toString());
                cbtipousuario.setSelectedItem(tbusuarios.getValueAt(filaSeleccionada, 6).toString());
                txtusuario2.setText(tbusuarios.getValueAt(filaSeleccionada, 7).toString());
                txtcontraseña.setText(tbusuarios.getValueAt(filaSeleccionada, 8).toString());

                // Guardar el ID del usuario seleccionado
                idUsuarioSeleccionado = Integer.parseInt(tbusuarios.getValueAt(filaSeleccionada, 0).toString());
            }
        });
    }

    // Método para cargar los usuarios desde la base de datos y mostrarlos en la tabla
    private void cargarUsuarios() {
        // Crear una instancia del DAO para obtener los usuarios
        DaoUsuarios dao = new DaoUsuarios();
        List<Usuario> usuarios = dao.obtenerUsuarios();  // Obtener la lista de usuarios

        // Crear el modelo de la tabla con las columnas correspondientes
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellido");
        modelo.addColumn("DNI");
        modelo.addColumn("Dirección");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Rol");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");

        // Llenar el modelo con los datos de los usuarios
        for (Usuario usuario : usuarios) {
            Object[] fila = new Object[9];
            fila[0] = usuario.getIdUsuario();
            fila[1] = usuario.getNombre();
            fila[2] = usuario.getApellido();
            fila[3] = usuario.getDocumento();
            fila[4] = usuario.getDireccion();
            fila[5] = usuario.getTelefono();
            fila[6] = usuario.getTipoUsuario();
            fila[7] = usuario.getUsuario();
            fila[8] = usuario.getPass();
            modelo.addRow(fila);  // Añadir la fila al modelo
        }

        // Asignar el modelo a la JTable para mostrar los datos
        tbusuarios.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPregistrousuarios = new javax.swing.JPanel();
        txtnombre = new javax.swing.JTextField();
        txtapellido = new javax.swing.JTextField();
        txtdocumento = new javax.swing.JTextField();
        txtdireccion = new javax.swing.JTextField();
        txttelefono = new javax.swing.JTextField();
        txtusuario2 = new javax.swing.JTextField();
        txtcontraseña = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cbtipousuario = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbusuarios = new javax.swing.JTable();
        btnUsuario = new javax.swing.JButton();
        btneditusuario = new javax.swing.JButton();
        btnelimusuario = new javax.swing.JButton();
        btnlimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(951, 775));
        setRequestFocusEnabled(false);
        setVerifyInputWhenFocusTarget(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(951, 775));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jPregistrousuarios.setBackground(new java.awt.Color(255, 255, 255));

        txtnombre.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtnombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreActionPerformed(evt);
            }
        });

        txtapellido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtapellido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtapellidoActionPerformed(evt);
            }
        });

        txtdocumento.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtdocumento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdocumentoActionPerformed(evt);
            }
        });

        txtdireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtdireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdireccionActionPerformed(evt);
            }
        });

        txttelefono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txttelefono.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttelefonoActionPerformed(evt);
            }
        });

        txtusuario2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtusuario2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusuario2ActionPerformed(evt);
            }
        });

        txtcontraseña.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtcontraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcontraseñaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Apellido");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Documento");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Direccion");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Teléfono");

        cbtipousuario.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrador", "Almacén", "Ventas", "Reportes" }));
        cbtipousuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        cbtipousuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbtipousuarioActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Tipo de usuario");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Usuario");

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Contraseña");

        tbusuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nombre", "Apellido", "DNI", "Direccion", "Teléfono", "Rol", "User", "Contraseña"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbusuarios);
        if (tbusuarios.getColumnModel().getColumnCount() > 0) {
            tbusuarios.getColumnModel().getColumn(0).setResizable(false);
            tbusuarios.getColumnModel().getColumn(1).setResizable(false);
            tbusuarios.getColumnModel().getColumn(2).setResizable(false);
            tbusuarios.getColumnModel().getColumn(3).setResizable(false);
            tbusuarios.getColumnModel().getColumn(4).setResizable(false);
            tbusuarios.getColumnModel().getColumn(5).setResizable(false);
            tbusuarios.getColumnModel().getColumn(6).setResizable(false);
            tbusuarios.getColumnModel().getColumn(7).setResizable(false);
        }

        btnUsuario.setBackground(new java.awt.Color(50, 130, 181));
        btnUsuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnUsuario.setForeground(new java.awt.Color(255, 255, 255));
        btnUsuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnUsuario.setText("Guardar");
        btnUsuario.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUsuarioActionPerformed(evt);
            }
        });

        btneditusuario.setBackground(new java.awt.Color(50, 130, 181));
        btneditusuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditusuario.setForeground(new java.awt.Color(255, 255, 255));
        btneditusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btneditusuario.setText("Editar");
        btneditusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditusuarioActionPerformed(evt);
            }
        });

        btnelimusuario.setBackground(new java.awt.Color(50, 130, 181));
        btnelimusuario.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimusuario.setForeground(new java.awt.Color(255, 255, 255));
        btnelimusuario.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnelimusuario.setText("Eliminar");
        btnelimusuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimusuarioActionPerformed(evt);
            }
        });

        btnlimpiar.setBackground(new java.awt.Color(50, 130, 181));
        btnlimpiar.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/limpiar.png"))); // NOI18N
        btnlimpiar.setText("Limpiar");
        btnlimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPregistrousuariosLayout = new javax.swing.GroupLayout(jPregistrousuarios);
        jPregistrousuarios.setLayout(jPregistrousuariosLayout);
        jPregistrousuariosLayout.setHorizontalGroup(
            jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPregistrousuariosLayout.createSequentialGroup()
                .addGroup(jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPregistrousuariosLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(txtusuario2)
                            .addComponent(cbtipousuario, 0, 180, Short.MAX_VALUE)
                            .addComponent(txttelefono)
                            .addComponent(txtdireccion)
                            .addComponent(txtdocumento)
                            .addComponent(txtapellido)
                            .addComponent(txtnombre)
                            .addComponent(txtcontraseña))
                        .addGap(18, 18, 18))
                    .addGroup(jPregistrousuariosLayout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(btnUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)))
                .addGroup(jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPregistrousuariosLayout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addComponent(btneditusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(115, 115, 115)
                        .addComponent(btnelimusuario, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31))
        );
        jPregistrousuariosLayout.setVerticalGroup(
            jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPregistrousuariosLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPregistrousuariosLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtnombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtapellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(txtdocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(9, 9, 9)
                        .addComponent(txtdireccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txttelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbtipousuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 19, 19)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtusuario2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(txtcontraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addGap(26, 26, 26)
                .addGroup(jPregistrousuariosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditusuario)
                    .addComponent(btnelimusuario)
                    .addComponent(btnlimpiar)
                    .addComponent(btnUsuario)))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de usuarios");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(50, 130, 181));
        jLabel2.setText("Complete la información de los usuarios");

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPregistrousuarios, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addComponent(jPregistrousuarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 963, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnelimusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimusuarioActionPerformed
// Verificar si hay un usuario seleccionado
        if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar si realmente desea eliminar el usuario
        int confirmacion = JOptionPane.showConfirmDialog(this, "¿Está seguro que desea eliminar este usuario?", "Confirmar eliminación", JOptionPane.YES_NO_OPTION);
        if (confirmacion == JOptionPane.YES_OPTION) {
            // Crear una instancia del DAO y llamar al método eliminarUsuario
            DaoUsuarios dao = new DaoUsuarios();
            boolean resultado = dao.eliminarUsuario(idUsuarioSeleccionado);

            // Verificar si la eliminación fue exitosa
            if (resultado) {
                JOptionPane.showMessageDialog(this, "Usuario eliminado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                cargarUsuarios();  // Actualizar la tabla con los datos restantes
                limpiarCampos();   // Limpiar los campos del formulario
            } else {
                JOptionPane.showMessageDialog(this, "Hubo un error al eliminar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnelimusuarioActionPerformed

    private void btneditusuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditusuarioActionPerformed
        // Verificar si se ha seleccionado un usuario
        if (idUsuarioSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un usuario para editar.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener los datos de los campos de texto
        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String documento = txtdocumento.getText().trim();
        String direccion = txtdireccion.getText().trim();
        String telefono = txttelefono.getText().trim();
        String tipoUsuario = cbtipousuario.getSelectedItem().toString();
        String usuario = txtusuario2.getText().trim();
        String pass = txtcontraseña.getText().trim();

        // Verificar que todos los campos estén completos
        if (nombre.isEmpty() || apellido.isEmpty() || documento.isEmpty() || direccion.isEmpty()
                || telefono.isEmpty() || tipoUsuario.isEmpty() || usuario.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el DAO para actualizar el usuario
        DaoUsuarios dao = new DaoUsuarios();

        // Llamar al método de actualización en el DAO
        boolean resultado = dao.actualizarUsuario(idUsuarioSeleccionado, nombre, apellido, documento, direccion, telefono, tipoUsuario, usuario, pass);

        if (resultado) {
            JOptionPane.showMessageDialog(this, "Usuario actualizado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            // Limpiar los campos
            limpiarCampos();

            // Actualizar la tabla con los nuevos datos
            cargarUsuarios();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btneditusuarioActionPerformed

    private void btnUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUsuarioActionPerformed
        // Capturar los datos de los campos de texto
        String nombre = txtnombre.getText().trim();
        String apellido = txtapellido.getText().trim();
        String documento = txtdocumento.getText().trim();
        String direccion = txtdireccion.getText().trim();
        String telefono = txttelefono.getText().trim();
        String tipoUsuario = cbtipousuario.getSelectedItem().toString();  // JComboBox, por ejemplo, puede ser Admin o Usuario
        String usuario = txtusuario2.getText().trim();
        String pass = txtcontraseña.getText().trim();

        // Verificar que todos los campos estén completos
        if (nombre.isEmpty() || apellido.isEmpty() || documento.isEmpty() || direccion.isEmpty()
                || telefono.isEmpty() || tipoUsuario.isEmpty() || usuario.isEmpty() || pass.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Crear el DAO de usuarios
        DaoUsuarios dao = new DaoUsuarios();

        // Llamar al método guardarUsuario del DAO
        boolean resultado = dao.guardarUsuario(nombre, apellido, documento, direccion, telefono, tipoUsuario, usuario, pass);

        // Mostrar mensaje de éxito o error
        if (resultado) {
            JOptionPane.showMessageDialog(this, "Usuario guardado exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();

            cargarUsuarios();
        } else {
            JOptionPane.showMessageDialog(this, "Hubo un error al guardar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnUsuarioActionPerformed

    private void cbtipousuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbtipousuarioActionPerformed

    }//GEN-LAST:event_cbtipousuarioActionPerformed

    private void txtcontraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcontraseñaActionPerformed

    }//GEN-LAST:event_txtcontraseñaActionPerformed

    private void txtusuario2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusuario2ActionPerformed

    }//GEN-LAST:event_txtusuario2ActionPerformed

    private void txttelefonoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttelefonoActionPerformed

    }//GEN-LAST:event_txttelefonoActionPerformed

    private void txtdireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdireccionActionPerformed

    }//GEN-LAST:event_txtdireccionActionPerformed

    private void txtdocumentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdocumentoActionPerformed

    }//GEN-LAST:event_txtdocumentoActionPerformed

    private void txtapellidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtapellidoActionPerformed

    }//GEN-LAST:event_txtapellidoActionPerformed

    private void txtnombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreActionPerformed

    }//GEN-LAST:event_txtnombreActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUsuario;
    private javax.swing.JButton btneditusuario;
    private javax.swing.JButton btnelimusuario;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cbtipousuario;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPregistrousuarios;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbusuarios;
    private javax.swing.JTextField txtapellido;
    private javax.swing.JTextField txtcontraseña;
    private javax.swing.JTextField txtdireccion;
    private javax.swing.JTextField txtdocumento;
    private javax.swing.JTextField txtnombre;
    private javax.swing.JTextField txttelefono;
    private javax.swing.JTextField txtusuario2;
    // End of variables declaration//GEN-END:variables

// Método para limpiar todos los campos de texto y combos
    private void limpiarCampos() {
        txtnombre.setText("");       // Limpiar el campo de nombre
        txtapellido.setText("");     // Limpiar el campo de apellido
        txtdocumento.setText("");    // Limpiar el campo de documento
        txtdireccion.setText("");    // Limpiar el campo de dirección
        txttelefono.setText("");     // Limpiar el campo de teléfono
        cbtipousuario.setSelectedIndex(0);  // Restablecer JComboBox a su valor inicial (puede ser el primer elemento)
        txtusuario2.setText("");     // Limpiar el campo de usuario
        txtcontraseña.setText("");   // Limpiar el campo de contraseña
    }

}
