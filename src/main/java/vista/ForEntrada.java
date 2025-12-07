package vista;

import controlador.DaoBusquedas;
import controlador.DaoEntrada;
import java.awt.Color;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Entrada;
import modelo.GeneradorPDF;

public class ForEntrada extends javax.swing.JFrame {

    public ForEntrada() {
        setUndecorated(true);  // Elimina la barra de título antes de que la ventana sea visible
        initComponents();
        setSize(770, 456);
        setLocationRelativeTo(null);
        cargarEntradas();

// No editar celdas
        tbentr1.setDefaultEditor(Object.class, null);

        // Personalizar encabezados
        tbentr1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbentr1.getTableHeader().setBackground(new java.awt.Color(50, 130, 181)); // azul
        tbentr1.getTableHeader().setForeground(Color.white);
        tbentr1.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 20));

        // Bloquear acciones del usuario
        tbentr1.getTableHeader().setResizingAllowed(false);
        tbentr1.getTableHeader().setReorderingAllowed(false);
    }

    private void cargarEntradas() {
        DaoEntrada dao = new DaoEntrada();
        List<Entrada> lista = dao.obtenerEntradas();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("ID Prod");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID Prov");
        modelo.addColumn("P. Entrada");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Total");

        for (Entrada e : lista) {
            modelo.addRow(new Object[]{
                e.getIdEntrada(),
                e.getIdProducto(),
                e.getStock(),
                e.getFecha(),
                e.getIdProveedor(),
                e.getPrecioE(),
                e.getPrecioV(),
                e.getTotal()
            });
        }

        tbentr1.setModel(modelo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btncerrar1 = new javax.swing.JButton();
        btnbus1 = new javax.swing.JButton();
        btnexp1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbentr1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181), 2));
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 456));
        jPanel1.setRequestFocusEnabled(false);

        btncerrar1.setBackground(new java.awt.Color(255, 102, 102));
        btncerrar1.setText("X");
        btncerrar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncerrar1ActionPerformed(evt);
            }
        });

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

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Fecha:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(50, 130, 181));
        jLabel3.setText("Buscar entradas");

        tbentr1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID/E", "ID/Prod", "Stock", "Fecha", "ID/Prov", "P.E", "P.V", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tbentr1.setPreferredSize(new java.awt.Dimension(494, 80));
        jScrollPane1.setViewportView(tbentr1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnbus1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(298, 298, 298)
                        .addComponent(jLabel3)))
                .addContainerGap(317, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncerrar1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnexp1)
                        .addGap(327, 327, 327))))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 728, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btncerrar1)
                .addGap(3, 3, 3)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnbus1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(261, 261, 261)
                .addComponent(btnexp1)
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                    .addContainerGap(127, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 232, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(51, 51, 51)))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncerrar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncerrar1ActionPerformed
        dispose();  // Cierra solo esta ventana
    }//GEN-LAST:event_btncerrar1ActionPerformed

    private void btnexp1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexp1ActionPerformed
        // Verificar que haya datos en la tabla
        if (tbentr1.getRowCount() == 0) {
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
        fileChooser.setSelectedFile(new java.io.File("Reporte_Entrada.pdf"));

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
                    tbentr1,
                    "REPORTE DE ENTRADAS",
                    "Listado completo de entradas registradas en el sistema"
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
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una fecha", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date fechaBusqueda = new java.sql.Date(jDateChooser1.getDate().getTime());
        DaoBusquedas daoBusqueda = new DaoBusquedas();
        List<Entrada> lista = daoBusqueda.buscarEntradasPorFecha(fechaBusqueda);

        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No se encontraron entradas para esta fecha", "Sin resultados", JOptionPane.INFORMATION_MESSAGE);
            cargarEntradas(); // Volver a mostrar todas
            return;
        }

        // Actualizar la tabla con los resultados
        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("ID Prod");
        modelo.addColumn("Stock");
        modelo.addColumn("Fecha");
        modelo.addColumn("ID Prov");
        modelo.addColumn("P. Entrada");
        modelo.addColumn("P. Venta");
        modelo.addColumn("Total");

        for (Entrada e : lista) {
            modelo.addRow(new Object[]{
                e.getIdEntrada(),
                e.getIdProducto(),
                e.getStock(),
                e.getFecha(),
                e.getIdProveedor(),
                e.getPrecioE(),
                e.getPrecioV(),
                e.getTotal()
            });
        }

        tbentr1.setModel(modelo);
        JOptionPane.showMessageDialog(this, "Se encontraron " + lista.size() + " entrada(s)", "Resultados", JOptionPane.INFORMATION_MESSAGE);

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
            java.util.logging.Logger.getLogger(ForEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ForEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ForEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ForEntrada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ForEntrada().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbus1;
    private javax.swing.JButton btncerrar1;
    private javax.swing.JButton btnexp1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbentr1;
    // End of variables declaration//GEN-END:variables
}
