package vista;

import controlador.DaoBusquedas;
import controlador.DaoProveedor;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.GeneradorPDF;
import modelo.Proveedor;

public class ForProveedor extends javax.swing.JFrame {

    public ForProveedor() {
        setUndecorated(true);  // Elimina la barra de título antes de que la ventana sea visible
        initComponents();
        setSize(770, 456);
        setLocationRelativeTo(null);
        cargarProveedores();

        tbpro1.setDefaultEditor(Object.class, null);
        tbpro1.getTableHeader().setResizingAllowed(false);
        tbpro1.getTableHeader().setReorderingAllowed(false);

        tbpro1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbpro1.getTableHeader().setBackground(new java.awt.Color(50, 130, 181));
        tbpro1.getTableHeader().setForeground(Color.white);
        tbpro1.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 20));

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

        tbpro1.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btncerrar1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbpro1 = new javax.swing.JTable();
        btnbus1 = new javax.swing.JButton();
        btnexp1 = new javax.swing.JButton();
        txtDNI1 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 456));

        btncerrar1.setBackground(new java.awt.Color(255, 102, 102));
        btncerrar1.setText("X");
        btncerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrar1ActionPerformed(evt);
            }
        });

        tbpro1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Stock", "ID/categoría", "Pr.Venta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbpro1);

        btnbus1.setBackground(new java.awt.Color(50, 130, 181));
        btnbus1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnbus1.setForeground(new java.awt.Color(255, 255, 255));
        btnbus1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnbus1.setText("Buscar");
        btnbus1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbus1ActionPerformed(evt);
            }
        });

        btnexp1.setBackground(new java.awt.Color(50, 130, 181));
        btnexp1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnexp1.setForeground(new java.awt.Color(255, 255, 255));
        btnexp1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnexp1.setText("Exportar");
        btnexp1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexp1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("DNI: ");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 130, 181));
        jLabel3.setText("Buscar Proveedores");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 754, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDNI1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnbus1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(313, 313, 313)
                                .addComponent(btnexp1)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(253, 253, 253)
                .addComponent(btncerrar1))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btncerrar1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 21, Short.MAX_VALUE)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnbus1)
                    .addComponent(txtDNI1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnexp1)
                .addGap(21, 21, 21))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrar1ActionPerformed
        dispose();  // Cierra solo esta ventana
    }//GEN-LAST:event_btncerrar1ActionPerformed

    private void btnexp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexp1ActionPerformed
        // Verificar que haya datos en la tabla
        if (tbpro1.getRowCount() == 0) {
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
                    tbpro1,
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
    }//GEN-LAST:event_btnexp1ActionPerformed

    private void btnbus1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbus1ActionPerformed

        String dni = txtDNI1.getText().trim();

        if (dni.isEmpty() || dni.equals("DNI")) {
            JOptionPane.showMessageDialog(this, "Ingrese un DNI", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        DaoBusquedas daoBusqueda = new DaoBusquedas();
        List<Proveedor> lista = daoBusqueda.buscarProveedoresPorDNI(dni);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontró proveedor con ese DNI", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            cargarProveedores(); // Volver a mostrar todos
            return;
        }

        // Actualizar la tabla
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

        tbpro1.setModel(modelo);

    }//GEN-LAST:event_btnbus1ActionPerformed

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
            java.util.logging.Logger.getLogger(ForProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForProveedor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForProveedor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbus1;
    private javax.swing.JButton btncerrar1;
    private javax.swing.JButton btnexp1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbpro1;
    private javax.swing.JTextField txtDNI1;
    // End of variables declaration//GEN-END:variables
}
