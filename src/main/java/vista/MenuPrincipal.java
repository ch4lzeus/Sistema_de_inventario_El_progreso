package vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JOptionPane;

public class MenuPrincipal extends javax.swing.JFrame {

    public MenuPrincipal(String rol, String usuario) {
        setUndecorated(true);  // Elimina la barra de título antes de que la ventana sea visible       

        initComponents();

        setLocationRelativeTo(null);

        // Establece el layout del jpanelcontenido a BorderLayout para que se ajuste automáticamente
        jpanelcontenido.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        inicio panelInicio = new inicio();  // Crear una instancia al panel
        panelInicio.setPreferredSize(new Dimension(957, 787));  // (Opcional) Esto establece el tamaño del panel

        jpanelcontenido.removeAll();  // Elimina cualquier componente previo del jpanelcontenido
        jpanelcontenido.add(panelInicio, BorderLayout.CENTER);  // Añade el panel de inicio al centro
        jpanelcontenido.revalidate();  // Vuelve a validar el contenedor
        jpanelcontenido.repaint();  // Fuerza un repintado para actualizar la UI

        // Configurar los botones según el rol
        configurarBotonesPorRol(rol);

        // Aquí actualizas los JLabel con el nombre de usuario y rol
        lbldashboard.setText(usuario);  // Actualiza el JLabel con el nombre del usuario
        lblroldashboard.setText(rol);  // Actualiza el JLabel con el rol
    }

// Constructor por defecto que asigna un rol predeterminado y un usuario predeterminado
    public MenuPrincipal() {
        this("Administrador", "Usuario");  // Llama al constructor con un rol y un usuario por defecto
    }

    private void configurarBotonesPorRol(String rol) { // Deshabilitar/mostrar botones según el rol 
        if (rol.equals("Administrador")) { // El Administrador tiene acceso a todo 
            btncategorias.setEnabled(true);
            btnproductos.setEnabled(true);
            btnentradas.setEnabled(true);
            btnsalidas.setEnabled(true);
            btnproveedor.setEnabled(true);
            btnusuarios.setEnabled(true);
        } else if (rol.equals("Ventas")) { // Ventas tiene acceso solo a inicio, categorías y productos 
            btncategorias.setEnabled(true);
            btnproductos.setEnabled(true);
            btnentradas.setEnabled(false);
            btnsalidas.setEnabled(false);
            btnproveedor.setEnabled(false);
            btnusuarios.setEnabled(false);
        } else if (rol.equals("Almacén")) { // Almacén tiene acceso solo a inicio, entrada y salida 
            btncategorias.setEnabled(false);
            btnproductos.setEnabled(true);
            btnentradas.setEnabled(true);
            btnsalidas.setEnabled(true);
            btnproveedor.setEnabled(true);
            btnusuarios.setEnabled(false);
        } else if (rol.equals("Reportes")) { // Reportes tiene acceso solo a inicio 
            btncategorias.setEnabled(false);
            btnproductos.setEnabled(false);
            btnentradas.setEnabled(true);
            btnsalidas.setEnabled(true);
            btnproveedor.setEnabled(false);
            btnusuarios.setEnabled(false);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        lbldashboard = new javax.swing.JLabel();
        lblroldashboard = new javax.swing.JLabel();
        btncategorias = new javax.swing.JButton();
        btnusuarios = new javax.swing.JButton();
        btnproductos = new javax.swing.JButton();
        btnentradas = new javax.swing.JButton();
        btninicio = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        btnsalir = new javax.swing.JButton();
        btnsalidas = new javax.swing.JButton();
        btnproveedor = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jpanelcontenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(50, 130, 181));
        jPanel1.setPreferredSize(new java.awt.Dimension(309, 787));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(153, 204, 255));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Inventario");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 17, -1, -1));

        lbldashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbldashboard.setText("Nombre del usuario");
        lbldashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lbldashboard.setPreferredSize(new java.awt.Dimension(118, 16));
        jPanel1.add(lbldashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 140, 120, -1));

        lblroldashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblroldashboard.setText("Rol de usuario ");
        lblroldashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblroldashboard.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(lblroldashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 120, -1));

        btncategorias.setBackground(new java.awt.Color(50, 130, 181));
        btncategorias.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btncategorias.setForeground(new java.awt.Color(255, 255, 255));
        btncategorias.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/categorias.png"))); // NOI18N
        btncategorias.setText("    Categorías");
        btncategorias.setBorder(null);
        btncategorias.setPreferredSize(new java.awt.Dimension(135, 25));
        btncategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncategoriasActionPerformed(evt);
            }
        });
        jPanel1.add(btncategorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 301, 297, 48));

        btnusuarios.setBackground(new java.awt.Color(50, 130, 181));
        btnusuarios.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnusuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuario.png"))); // NOI18N
        btnusuarios.setText("      Usuarios");
        btnusuarios.setBorder(null);
        btnusuarios.setPreferredSize(new java.awt.Dimension(135, 25));
        btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariosActionPerformed(evt);
            }
        });
        jPanel1.add(btnusuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 619, 297, 48));

        btnproductos.setBackground(new java.awt.Color(50, 130, 181));
        btnproductos.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnproductos.setForeground(new java.awt.Color(255, 255, 255));
        btnproductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        btnproductos.setText("    Productos");
        btnproductos.setBorder(null);
        btnproductos.setPreferredSize(new java.awt.Dimension(135, 25));
        btnproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductosActionPerformed(evt);
            }
        });
        jPanel1.add(btnproductos, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 367, 297, 48));

        btnentradas.setBackground(new java.awt.Color(50, 130, 181));
        btnentradas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnentradas.setForeground(new java.awt.Color(255, 255, 255));
        btnentradas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/entrada.png"))); // NOI18N
        btnentradas.setText("      Entradas");
        btnentradas.setBorder(null);
        btnentradas.setPreferredSize(new java.awt.Dimension(135, 25));
        btnentradas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentradasActionPerformed(evt);
            }
        });
        jPanel1.add(btnentradas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 433, 297, 48));

        btninicio.setBackground(new java.awt.Color(50, 130, 181));
        btninicio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btninicio.setForeground(new java.awt.Color(255, 255, 255));
        btninicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/casa.png"))); // NOI18N
        btninicio.setText("            Inicio");
        btninicio.setToolTipText("");
        btninicio.setBorder(null);
        btninicio.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btninicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninicioActionPerformed(evt);
            }
        });
        jPanel1.add(btninicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 241, 297, 48));

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jPanel1.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 691, 297, 10));

        btnsalir.setBackground(new java.awt.Color(50, 130, 181));
        btnsalir.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsalir.setForeground(new java.awt.Color(255, 255, 255));
        btnsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salir.png"))); // NOI18N
        btnsalir.setText("             Salir");
        btnsalir.setBorder(null);
        btnsalir.setPreferredSize(new java.awt.Dimension(135, 25));
        btnsalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalirActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 713, 297, 48));

        btnsalidas.setBackground(new java.awt.Color(50, 130, 181));
        btnsalidas.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsalidas.setForeground(new java.awt.Color(255, 255, 255));
        btnsalidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salida.png"))); // NOI18N
        btnsalidas.setText("         Salidas");
        btnsalidas.setBorder(null);
        btnsalidas.setPreferredSize(new java.awt.Dimension(135, 25));
        btnsalidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidasActionPerformed(evt);
            }
        });
        jPanel1.add(btnsalidas, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 493, 297, 48));

        btnproveedor.setBackground(new java.awt.Color(50, 130, 181));
        btnproveedor.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnproveedor.setForeground(new java.awt.Color(255, 255, 255));
        btnproveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Proveedor.png"))); // NOI18N
        btnproveedor.setText("    Proveedor");
        btnproveedor.setBorder(null);
        btnproveedor.setPreferredSize(new java.awt.Dimension(135, 25));
        btnproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproveedorActionPerformed(evt);
            }
        });
        jPanel1.add(btnproveedor, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 559, 297, 48));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/LogoUsuario.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 75, 66, 55));

        jpanelcontenido.setBackground(new java.awt.Color(255, 255, 255));
        jpanelcontenido.setPreferredSize(new java.awt.Dimension(957, 787));
        jpanelcontenido.setRequestFocusEnabled(false);
        jpanelcontenido.setVerifyInputWhenFocusTarget(false);
        jpanelcontenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpanelcontenido, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jpanelcontenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncategoriasActionPerformed

        if (!btncategorias.isEnabled()) {
            JOptionPane.showMessageDialog(this, "Acceso Denegado. No tiene permisos para esta sección.");
            return;
        }
        // Código normal para cambiar el panel de categorias
        categorias panelcategoria = new categorias();
        panelcategoria.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelcategoria, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();

    }//GEN-LAST:event_btncategoriasActionPerformed

    private void btnproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductosActionPerformed
        productos panelproductos = new productos();
        panelproductos.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelproductos, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btnproductosActionPerformed

    private void btninicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninicioActionPerformed
        inicio panelInicio = new inicio();
        panelInicio.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelInicio, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btninicioActionPerformed

    private void btnsalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalirActionPerformed
        dispose();
        login loginFrame = new login();
        loginFrame.setVisible(true);
    }//GEN-LAST:event_btnsalirActionPerformed

    private void btnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariosActionPerformed
        Usuarios panelusuario = new Usuarios();
        panelusuario.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelusuario, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btnusuariosActionPerformed

    private void btnproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproveedorActionPerformed
        proveedor panelproveedor = new proveedor();
        panelproveedor.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelproveedor, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btnproveedorActionPerformed

    private void btnentradasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentradasActionPerformed
        entrada panelentrada = new entrada();
        panelentrada.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelentrada, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btnentradasActionPerformed

    private void btnsalidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidasActionPerformed
        salida panelsalida = new salida();
        panelsalida.setPreferredSize(new Dimension(957, 787));

        jpanelcontenido.removeAll();
        jpanelcontenido.add(panelsalida, BorderLayout.CENTER);
        jpanelcontenido.revalidate();
        jpanelcontenido.repaint();
    }//GEN-LAST:event_btnsalidasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncategorias;
    private javax.swing.JButton btnentradas;
    private javax.swing.JButton btninicio;
    private javax.swing.JButton btnproductos;
    private javax.swing.JButton btnproveedor;
    private javax.swing.JButton btnsalidas;
    private javax.swing.JButton btnsalir;
    private javax.swing.JButton btnusuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel jpanelcontenido;
    private javax.swing.JLabel lbldashboard;
    private javax.swing.JLabel lblroldashboard;
    // End of variables declaration//GEN-END:variables
}
