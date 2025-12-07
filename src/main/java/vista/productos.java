package vista;

import controlador.DaoCategorias;
import controlador.DaoProductos;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Categoria;
import modelo.GeneradorPDF;
import modelo.Producto;

public class productos extends javax.swing.JPanel {

    int idProductoSeleccionado = -1;

    public productos() {
        initComponents();
        cargarCategoriasEnCombo();
        cargarProductos();

        // Tabla no editable
        jTable1.setDefaultEditor(Object.class, null);
        jTable1.getTableHeader().setResizingAllowed(false);
        jTable1.getTableHeader().setReorderingAllowed(false);

        // Estilo encabezado
        jTable1.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        jTable1.getTableHeader().setBackground(new java.awt.Color(50, 130, 181));
        jTable1.getTableHeader().setForeground(Color.white);
        jTable1.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        // Evento selección de tabla
        jTable1.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && jTable1.getSelectedRow() != -1) {

                int fila = jTable1.getSelectedRow();

                idProductoSeleccionado = Integer.parseInt(jTable1.getValueAt(fila, 0).toString());
                txtproducto.setText(jTable1.getValueAt(fila, 1).toString());
                txtstockproducto.setText(jTable1.getValueAt(fila, 2).toString());

                int idCat = Integer.parseInt(jTable1.getValueAt(fila, 3).toString());
                lblcategoria.setText(String.valueOf(idCat));

                // Seleccionar categoría en combo
                seleccionarCategoriaPorId(idCat);

                txtprecioventa.setText(jTable1.getValueAt(fila, 4).toString());
            }
        });
    }

    private void cargarProductos() {
        DaoProductos dao = new DaoProductos();
        List<Producto> productos = dao.obtenerProductos();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("Nombre");
        modelo.addColumn("Stock");
        modelo.addColumn("ID Cat");
        modelo.addColumn("Precio Venta");

        for (Producto p : productos) {
            modelo.addRow(new Object[]{
                p.getIdProducto(),
                p.getNombre(),
                p.getStock(),
                p.getIdCategoria(),
                p.getPrecioV()
            });
        }

        jTable1.setModel(modelo);
    }

    private List<Categoria> listaCategorias; // global

    private void cargarCategoriasEnCombo() {
        DaoCategorias dao = new DaoCategorias();
        listaCategorias = dao.obtenerCategorias();

        jComboBox1.removeAllItems();

        for (Categoria c : listaCategorias) {
            jComboBox1.addItem(c.getCategoria());
        }
    }

    private void seleccionarCategoriaPorId(int idCategoria) {

        for (int i = 0; i < listaCategorias.size(); i++) {

            if (listaCategorias.get(i).getIdCategoria() == idCategoria) {
                jComboBox1.setSelectedIndex(i);
                return;
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtproducto = new javax.swing.JTextField();
        txtstockproducto = new javax.swing.JTextField();
        txtprecioventa = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnbusproducto = new javax.swing.JButton();
        btnproducto = new javax.swing.JButton();
        btneditproducto = new javax.swing.JButton();
        btnelimproducto = new javax.swing.JButton();
        btnexpproducto = new javax.swing.JButton();
        lblcategoria = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        btnlimpiar3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(951, 775));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de productos");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Complete la Informacion de los productos.");

        txtproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtproductoActionPerformed(evt);
            }
        });

        txtstockproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtstockproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockproductoActionPerformed(evt);
            }
        });

        txtprecioventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtprecioventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtprecioventaActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Nombre");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Stock");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("ID");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Categoría");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Precio de venta");

        btnbusproducto.setBackground(new java.awt.Color(50, 130, 181));
        btnbusproducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnbusproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnbusproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnbusproducto.setText("Buscar");
        btnbusproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusproductoActionPerformed(evt);
            }
        });

        btnproducto.setBackground(new java.awt.Color(50, 130, 181));
        btnproducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnproducto.setText("Guardar");
        btnproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnproductoActionPerformed(evt);
            }
        });

        btneditproducto.setBackground(new java.awt.Color(50, 130, 181));
        btneditproducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btneditproducto.setForeground(new java.awt.Color(255, 255, 255));
        btneditproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btneditproducto.setText("Editar");
        btneditproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditproductoActionPerformed(evt);
            }
        });

        btnelimproducto.setBackground(new java.awt.Color(50, 130, 181));
        btnelimproducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnelimproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnelimproducto.setText("Eliminar");
        btnelimproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimproductoActionPerformed(evt);
            }
        });

        btnexpproducto.setBackground(new java.awt.Color(50, 130, 181));
        btnexpproducto.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnexpproducto.setForeground(new java.awt.Color(255, 255, 255));
        btnexpproducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnexpproducto.setText("Exportar");
        btnexpproducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexpproductoActionPerformed(evt);
            }
        });

        lblcategoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcategoria.setText("ID");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categorías" }));
        jComboBox1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        btnlimpiar3.setBackground(new java.awt.Color(50, 130, 181));
        btnlimpiar3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar3.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/limpiar.png"))); // NOI18N
        btnlimpiar3.setText("Limpiar");
        btnlimpiar3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar3ActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnbusproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(jLabel3)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel8)
                                                .addComponent(txtproducto)
                                                .addComponent(txtstockproducto)
                                                .addComponent(txtprecioventa, javax.swing.GroupLayout.DEFAULT_SIZE, 133, Short.MAX_VALUE))
                                            .addComponent(jLabel7))
                                        .addGap(27, 27, 27)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 25, Short.MAX_VALUE)
                                            .addComponent(lblcategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btneditproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(49, 49, 49)
                                        .addComponent(btnelimproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnlimpiar3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(31, 31, 31)
                                        .addComponent(btnexpproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 641, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(25, 25, 25))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jLabel2)))
                .addGap(68, 68, 68)
                .addComponent(btnbusproducto)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(txtstockproducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel6))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblcategoria))))
                        .addGap(30, 30, 30)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(txtprecioventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnproducto))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btneditproducto)
                    .addComponent(btnelimproducto)
                    .addComponent(btnexpproducto)
                    .addComponent(btnlimpiar3))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnbusproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusproductoActionPerformed
    ForProductos formulario1 = new ForProductos();
            formulario1.setVisible(true);
    }//GEN-LAST:event_btnbusproductoActionPerformed

    private void btnproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnproductoActionPerformed

        String nombre = txtproducto.getText().trim();
        int stock = Integer.parseInt(txtstockproducto.getText().trim());
        int idCat = Integer.parseInt(lblcategoria.getText());
        double precio = Double.parseDouble(txtprecioventa.getText().trim());

        DaoProductos dao = new DaoProductos();

        if (dao.guardarProducto(nombre, stock, idCat, precio)) {
            JOptionPane.showMessageDialog(this, "Producto guardado");
            limpiarCampos();
            cargarProductos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar");
        }
    }//GEN-LAST:event_btnproductoActionPerformed

    private void btneditproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditproductoActionPerformed

        if (idProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
            return;
        }

        String nombre = txtproducto.getText().trim();
        int stock = Integer.parseInt(txtstockproducto.getText().trim());
        int idCat = Integer.parseInt(lblcategoria.getText());
        double precio = Double.parseDouble(txtprecioventa.getText().trim());

        DaoProductos dao = new DaoProductos();

        if (dao.actualizarProducto(idProductoSeleccionado, nombre, stock, idCat, precio)) {
            JOptionPane.showMessageDialog(this, "Producto actualizado");
            limpiarCampos();
            cargarProductos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al actualizar");
        }
    }//GEN-LAST:event_btneditproductoActionPerformed

    private void btnelimproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimproductoActionPerformed

        if (idProductoSeleccionado == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
            return;
        }

        int c = JOptionPane.showConfirmDialog(this, "¿Eliminar producto?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (c == JOptionPane.YES_OPTION) {
            DaoProductos dao = new DaoProductos();

            if (dao.eliminarProducto(idProductoSeleccionado)) {
                JOptionPane.showMessageDialog(this, "Producto eliminado");
                limpiarCampos();
                cargarProductos();
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar");
            }
        }
    }//GEN-LAST:event_btnelimproductoActionPerformed

    private void btnexpproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexpproductoActionPerformed
// Verificar que haya datos en la tabla
        if (jTable1.getRowCount() == 0) {
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
        fileChooser.setSelectedFile(new java.io.File("Reporte_Productos.pdf"));

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
                    jTable1,
                    "REPORTE DE PRODUCTOS",
                    "Listado completo de productos registrados en el sistema"
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
    }//GEN-LAST:event_btnexpproductoActionPerformed

    private void btnlimpiar3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar3ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiar3ActionPerformed

    private void txtproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtproductoActionPerformed

    private void txtstockproductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockproductoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstockproductoActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        int index = jComboBox1.getSelectedIndex();
        if (index >= 0) {
            lblcategoria.setText(String.valueOf(listaCategorias.get(index).getIdCategoria()));
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void txtprecioventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtprecioventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtprecioventaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusproducto;
    private javax.swing.JButton btneditproducto;
    private javax.swing.JButton btnelimproducto;
    private javax.swing.JButton btnexpproducto;
    private javax.swing.JButton btnlimpiar3;
    private javax.swing.JButton btnproducto;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblcategoria;
    private javax.swing.JTextField txtprecioventa;
    private javax.swing.JTextField txtproducto;
    private javax.swing.JTextField txtstockproducto;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        idProductoSeleccionado = -1;
        txtproducto.setText("");
        txtstockproducto.setText("");
        txtprecioventa.setText("");
        lblcategoria.setText("");
        jComboBox1.setSelectedIndex(0);
        jTable1.clearSelection();
    }

}
