package vista;

import controlador.DaoProductos;
import controlador.DaoSalida;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.GeneradorPDF;
import modelo.Producto;
import modelo.Salida;

public class salida extends javax.swing.JPanel {

    private List<Producto> listaProductos;
    private int idSalidaSeleccionada = -1;

    public salida() {
        initComponents();

        // ← AGREGAR ESTAS LÍNEAS AL INICIO
        lblsubtotal.setText("");
        lbligv.setText("");
        lbltotal.setText("");
        lbltotal1.setText("");

        // Calcular importe mientras escribe la cantidad
        txtcantsalida.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                calcularImporte();
            }
        });
        generarNumeroSalida();
        cargarCombos();
        cargarSalidas();

        // No editar celdas
        tbSalidas.setDefaultEditor(Object.class, null);

        // Personalizar encabezados
        tbSalidas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbSalidas.getTableHeader().setBackground(new java.awt.Color(50, 130, 181)); // azul
        tbSalidas.getTableHeader().setForeground(Color.white);
        tbSalidas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        // Bloquear acciones del usuario
        tbSalidas.getTableHeader().setResizingAllowed(false);
        tbSalidas.getTableHeader().setReorderingAllowed(false);
        
            // ← AGREGAR ESTE LISTENER PARA CAPTURAR LA SELECCIÓN
    tbSalidas.getSelectionModel().addListSelectionListener(e -> {
        if (!e.getValueIsAdjusting() && tbSalidas.getSelectedRow() != -1) {
            int fila = tbSalidas.getSelectedRow();
            idSalidaSeleccionada = Integer.parseInt(tbSalidas.getValueAt(fila, 0).toString());
            System.out.println("ID seleccionado: " + idSalidaSeleccionada); // Para debug
        }
    });

    }

    private void cargarCombos() {
        // Productos
        DaoProductos daoP = new DaoProductos();
        listaProductos = daoP.obtenerProductos();

        cmbprosalida.removeAllItems();
        for (Producto p : listaProductos) {
            cmbprosalida.addItem(p.getNombre());
        }
    }

    private void cargarSalidas() {
        DaoSalida dao = new DaoSalida();
        List<Salida> lista = dao.obtenerSalidas();

        DefaultTableModel modelo = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int r, int c) {
                return false;
            }
        };

        modelo.addColumn("ID");
        modelo.addColumn("N° de salida");
        modelo.addColumn("Fecha");
        modelo.addColumn("Subtotal");
        modelo.addColumn("IGV");
        modelo.addColumn("Total");

        for (Salida s : lista) {
            modelo.addRow(new Object[]{
                s.getIdSalida(),
                s.getNumSalida(),
                s.getFecha(),
                s.getSubtotal(),
                s.getIgv(),
                s.getTotal()
            });
        }

        tbSalidas.setModel(modelo);
    }

    private void generarNumeroSalida() {
        DaoSalida dao = new DaoSalida();
        String ultimoNum = dao.obtenerUltimoNumeroSalida();

        if (ultimoNum == null || ultimoNum.isEmpty()) {
            lblnumsalida.setText("001");  // Primera salida
        } else {
            // Extraer el número y sumar 1
            int numero = Integer.parseInt(ultimoNum);
            numero++;
            lblnumsalida.setText(String.format("%03d", numero));  // Formato 001, 002, etc.
        }
    }

    private void calcularImporte() {
        // Si no hay cantidad, mostrar 0.00
        if (txtcantsalida.getText().trim().isEmpty()) {
            lbltotal1.setText("0.00");
            return;
        }

        // Validar que lblsubtotal tenga un valor numérico
        if (lblsubtotal.getText().isEmpty() || lblsubtotal.getText().equals("0.00")) {
            lbltotal1.setText("0.00");
            return;
        }

        try {
            int cantidad = Integer.parseInt(txtcantsalida.getText().trim());

            // Reemplazar coma por punto para poder parsear
            String precioStr = lblsubtotal.getText().replace(",", ".");
            double precio = Double.parseDouble(precioStr);

            double importe = cantidad * precio;
            lbltotal1.setText(String.format("%.2f", importe));
        } catch (NumberFormatException e) {
            lbltotal1.setText("0.00");
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jdatesalida = new com.toedter.calendar.JDateChooser();
        cmbprosalida = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lblnumsalida = new javax.swing.JLabel();
        txtcantsalida = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbSalidas = new javax.swing.JTable();
        btnsalida = new javax.swing.JButton();
        btnbussalida = new javax.swing.JButton();
        btnelimsalida = new javax.swing.JButton();
        btnexposalida = new javax.swing.JButton();
        lblsubtotal = new javax.swing.JLabel();
        lbligv = new javax.swing.JLabel();
        lbltotal = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        lbltotal1 = new javax.swing.JLabel();
        btnlimpiar1 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de salidas");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Complete la Informacion de las salidas.");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Producto");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Fecha");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Sub total");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Igv");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setText("Cantidad");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel9.setText("Total");

        jdatesalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));

        cmbprosalida.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cmbprosalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        cmbprosalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbprosalidaActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Número de salida");

        lblnumsalida.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lblnumsalida.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblnumsalida.setText("N°");

        txtcantsalida.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtcantsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtcantsalidaActionPerformed(evt);
            }
        });

        tbSalidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Fecha", "Producto", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(tbSalidas);

        btnsalida.setBackground(new java.awt.Color(50, 130, 181));
        btnsalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnsalida.setForeground(new java.awt.Color(255, 255, 255));
        btnsalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnsalida.setText("Guardar");
        btnsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsalidaActionPerformed(evt);
            }
        });

        btnbussalida.setBackground(new java.awt.Color(50, 130, 181));
        btnbussalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnbussalida.setForeground(new java.awt.Color(255, 255, 255));
        btnbussalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnbussalida.setText("Buscar");
        btnbussalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbussalidaActionPerformed(evt);
            }
        });

        btnelimsalida.setBackground(new java.awt.Color(50, 130, 181));
        btnelimsalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimsalida.setForeground(new java.awt.Color(255, 255, 255));
        btnelimsalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/editar.png"))); // NOI18N
        btnelimsalida.setText("Eliminar");
        btnelimsalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimsalidaActionPerformed(evt);
            }
        });

        btnexposalida.setBackground(new java.awt.Color(50, 130, 181));
        btnexposalida.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnexposalida.setForeground(new java.awt.Color(255, 255, 255));
        btnexposalida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnexposalida.setText("Exportar");
        btnexposalida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexposalidaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Importe");

        lbltotal1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));

        btnlimpiar1.setBackground(new java.awt.Color(50, 130, 181));
        btnlimpiar1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnlimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        btnlimpiar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnlimpiar1.setText("Limpiar");
        btnlimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnlimpiar1ActionPerformed(evt);
            }
        });

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnbussalida, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbligv, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lbltotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(jLabel11)
                                                    .addComponent(jLabel9)
                                                    .addComponent(jLabel7)
                                                    .addComponent(jLabel6)
                                                    .addComponent(jLabel5)
                                                    .addComponent(jdatesalida, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                                    .addComponent(jLabel3)
                                                    .addComponent(txtcantsalida)
                                                    .addComponent(jLabel8)
                                                    .addComponent(cmbprosalida, 0, 149, Short.MAX_VALUE)
                                                    .addComponent(lblsubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(lbltotal1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                        .addGap(78, 78, 78))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addComponent(btnsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(btnelimsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnlimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(93, 93, 93)
                                        .addComponent(btnexposalida, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 606, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(46, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(lblnumsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel12)
                        .addGap(36, 36, 36)
                        .addComponent(btnbussalida))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel10)
                            .addComponent(lblnumsalida))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnsalida)
                            .addComponent(btnelimsalida)
                            .addComponent(btnexposalida)
                            .addComponent(btnlimpiar1))
                        .addGap(66, 66, 66))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(18, 18, 18)
                                .addComponent(jdatesalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel6)
                                .addGap(10, 10, 10)
                                .addComponent(lblsubtotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addGap(12, 12, 12)
                                .addComponent(lbligv, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel3)
                                .addGap(18, 18, 18)
                                .addComponent(cmbprosalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtcantsalida, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel11)
                                .addGap(18, 18, 18)
                                .addComponent(lbltotal1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(94, 159, Short.MAX_VALUE))))
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

    private void btnsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsalidaActionPerformed

        // Validar campos
        if (txtcantsalida.getText().isEmpty() || lblsubtotal.getText().isEmpty()
                || lbltotal.getText().isEmpty() || jdatesalida.getDate() == null) {
            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        // Validar que haya un producto seleccionado
        if (cmbprosalida.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(this, "Seleccione un producto.");
            return;
        }

        try {
            // 1. Crear y guardar la SALIDA
            Salida s = new Salida();
            s.setNumSalida(lblnumsalida.getText());
            s.setFecha(new java.sql.Date(jdatesalida.getDate().getTime()));

            // Obtener precio del producto seleccionado
            Producto productoSeleccionado = listaProductos.get(cmbprosalida.getSelectedIndex());
            double precioUnitario = productoSeleccionado.getPrecioV();
            int cantidad = Integer.parseInt(txtcantsalida.getText().trim());

            // Calcular valores
            double subtotal = precioUnitario * cantidad;
            double igv = subtotal * 0.15;
            double total = subtotal + igv;

            s.setSubtotal(subtotal);
            s.setIgv(igv);
            s.setTotal(total);

            DaoSalida dao = new DaoSalida();

            // Guardar la salida
            if (dao.guardarSalida(s)) {
                // 2. Guardar el DETALLE de la salida
                modelo.DetalleSalida detalle = new modelo.DetalleSalida();
                detalle.setIdSalida(s.getIdSalida());
                detalle.setIdProducto(productoSeleccionado.getIdProducto());
                detalle.setCantidad(cantidad);

                // ← IMPORTANTE: Manejar la coma al parsear lbltotal1
                String importeStr = lbltotal1.getText().replace(",", ".");
                detalle.setImporte(Double.parseDouble(importeStr));

                if (dao.guardarDetallesSalida(detalle)) {
                    JOptionPane.showMessageDialog(this, "Salida registrada correctamente.");
                    cargarSalidas();
                    limpiarCampos();
                    generarNumeroSalida();
                } else {
                    JOptionPane.showMessageDialog(this, "Error al guardar el detalle.");
                }
            } else {
                JOptionPane.showMessageDialog(this, "Error al guardar la salida.");
            }

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Error en los valores numéricos: " + e.getMessage());
        }

    }//GEN-LAST:event_btnsalidaActionPerformed

    private void btnbussalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbussalidaActionPerformed
        ForSalida formulario3 = new ForSalida();
        formulario3.setVisible(true);
    }//GEN-LAST:event_btnbussalidaActionPerformed

    private void btnelimsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimsalidaActionPerformed
// Verificar si se ha seleccionado una salida
        if (idSalidaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una salida.");
            return;
        }

        // Confirmar eliminación
        int op = JOptionPane.showConfirmDialog(this, "¿Eliminar esta salida?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {
            // Llamar al Dao para eliminar la salida
            DaoSalida dao = new DaoSalida();
            if (dao.eliminarSalida(idSalidaSeleccionada)) {
                JOptionPane.showMessageDialog(this, "Salida eliminada.");
                cargarSalidas();  // Recargar la tabla de salidas
                limpiarCampos();  // Limpiar los campos
            } else {
                JOptionPane.showMessageDialog(this, "Error al eliminar la salida.");
            }
        }
    }//GEN-LAST:event_btnelimsalidaActionPerformed

    private void btnexposalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexposalidaActionPerformed
        // Verificar que haya datos en la tabla
        if (tbSalidas.getRowCount() == 0) {
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
        fileChooser.setSelectedFile(new java.io.File("Reporte_Salidas.pdf"));

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
                    tbSalidas,
                    "REPORTE DE SALIDAS",
                    "Listado completo de salidas registradas en el sistema"
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
    }//GEN-LAST:event_btnexposalidaActionPerformed

    private void btnlimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiar1ActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_btnlimpiar1ActionPerformed

    private void cmbprosalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbprosalidaActionPerformed

        int index = cmbprosalida.getSelectedIndex();
        if (index >= 0) {
            Producto productoSeleccionado = listaProductos.get(index);
            double precio = productoSeleccionado.getPrecioV();

            // Usar punto en lugar de coma para evitar problemas
            lblsubtotal.setText(String.format("%.2f", precio).replace(",", "."));

            // Calcular IGV (15% del precio)
            double igv = precio * 0.15;
            lbligv.setText(String.format("%.2f", igv).replace(",", "."));

            // Calcular total (precio + IGV)
            double total = precio + igv;
            lbltotal.setText(String.format("%.2f", total).replace(",", "."));

            // Recalcular importe si ya hay cantidad
            calcularImporte();
        }

    }//GEN-LAST:event_cmbprosalidaActionPerformed

    private void txtcantsalidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtcantsalidaActionPerformed
        calcularImporte();  // Calcular cuando presiona Enter
    }//GEN-LAST:event_txtcantsalidaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbussalida;
    private javax.swing.JButton btnelimsalida;
    private javax.swing.JButton btnexposalida;
    private javax.swing.JButton btnlimpiar1;
    private javax.swing.JButton btnsalida;
    private javax.swing.JComboBox<String> cmbprosalida;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdatesalida;
    private javax.swing.JLabel lbligv;
    private javax.swing.JLabel lblnumsalida;
    private javax.swing.JLabel lblsubtotal;
    private javax.swing.JLabel lbltotal;
    private javax.swing.JLabel lbltotal1;
    private javax.swing.JTable tbSalidas;
    private javax.swing.JTextField txtcantsalida;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        cmbprosalida.setSelectedIndex(0);
        txtcantsalida.setText("");
        lblsubtotal.setText("");  // ← Vacío en lugar de "0.00"
        lbligv.setText("");
        lbltotal.setText("");
        lbltotal1.setText("");
        jdatesalida.setDate(null);
        idSalidaSeleccionada = -1;
        tbSalidas.clearSelection();
    }

}
