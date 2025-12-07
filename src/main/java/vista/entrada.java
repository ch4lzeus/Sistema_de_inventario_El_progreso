package vista;

import controlador.DaoEntrada;
import controlador.DaoProductos;
import controlador.DaoProveedor;
import java.awt.Color;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Entrada;
import modelo.GeneradorPDF;
import modelo.Producto;
import modelo.Proveedor;

public class entrada extends javax.swing.JPanel {

    int idEntradaSeleccionada = -1;
    private List<Producto> listaProductos;
    private List<Proveedor> listaProveedores;

    public entrada() {
        initComponents();

        txtstockentrada.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }
        });

        txtpentrada.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                calcularTotal();
            }
        });

        cargarCombos();
        cargarEntradas();

        // No editar celdas
        tbentradas.setDefaultEditor(Object.class, null);

        // Personalizar encabezados
        tbentradas.getTableHeader().setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
        tbentradas.getTableHeader().setBackground(new java.awt.Color(50, 130, 181)); // azul
        tbentradas.getTableHeader().setForeground(Color.white);
        tbentradas.getTableHeader().setPreferredSize(new java.awt.Dimension(0, 30));

        // Bloquear acciones del usuario
        tbentradas.getTableHeader().setResizingAllowed(false);
        tbentradas.getTableHeader().setReorderingAllowed(false);

        tbentradas.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tbentradas.getSelectedRow() != -1) {

                int f = tbentradas.getSelectedRow();

                idEntradaSeleccionada = Integer.parseInt(tbentradas.getValueAt(f, 0).toString());

                lblidprod.setText(tbentradas.getValueAt(f, 1).toString());
                txtstockentrada.setText(tbentradas.getValueAt(f, 2).toString());
                jdate.setDate((java.sql.Date) tbentradas.getValueAt(f, 3));
                lblidprov.setText(tbentradas.getValueAt(f, 4).toString());
                txtpentrada.setText(tbentradas.getValueAt(f, 5).toString());
                txtpventa.setText(tbentradas.getValueAt(f, 6).toString());
                lbltotalentrada.setText(tbentradas.getValueAt(f, 7).toString());

                seleccionarProductoPorId(Integer.parseInt(lblidprod.getText()));
                seleccionarProveedorPorId(Integer.parseInt(lblidprov.getText()));
            }
        });

    }

    private void cargarCombos() {
        // Productos
        DaoProductos daoP = new DaoProductos();
        listaProductos = daoP.obtenerProductos();

        cmbproductos.removeAllItems();
        for (Producto p : listaProductos) {
            cmbproductos.addItem(p.getNombre());
        }

        // Proveedores
        DaoProveedor daoProv = new DaoProveedor();
        listaProveedores = daoProv.obtenerProveedores();

        cmbproveedor.removeAllItems();
        for (Proveedor p : listaProveedores) {
            cmbproveedor.addItem(p.getNombre());
        }
    }

    private void calcularTotal() {

        if (txtstockentrada.getText().trim().isEmpty()
                || txtpentrada.getText().trim().isEmpty()) {

            lbltotalentrada.setText("0.00");
            return;
        }

        try {
            int stock = Integer.parseInt(txtstockentrada.getText());
            double precio = Double.parseDouble(txtpentrada.getText());
            double total = stock * precio;

            lbltotalentrada.setText(String.format("%.2f", total));

        } catch (NumberFormatException e) {
            lbltotalentrada.setText("0.00");
        }
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

        tbentradas.setModel(modelo);
    }

    private void seleccionarProductoPorId(int id) {
        for (int i = 0; i < listaProductos.size(); i++) {
            if (listaProductos.get(i).getIdProducto() == id) {
                cmbproductos.setSelectedIndex(i);
            }
        }
    }

    private void seleccionarProveedorPorId(int id) {
        for (int i = 0; i < listaProveedores.size(); i++) {
            if (listaProveedores.get(i).getIdProveedor() == id) {
                cmbproveedor.setSelectedIndex(i);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmbproductos = new javax.swing.JComboBox<>();
        lblidprod = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtpventa = new javax.swing.JTextField();
        cmbproveedor = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lblidprov = new javax.swing.JLabel();
        jdate = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtpentrada = new javax.swing.JTextField();
        txtstockentrada = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbentradas = new javax.swing.JTable();
        btnentrada = new javax.swing.JButton();
        btnbusentrada = new javax.swing.JButton();
        btnexpentrada = new javax.swing.JButton();
        btnelimentrada = new javax.swing.JButton();
        lbltotalentrada = new javax.swing.JLabel();
        btnlimpiar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Productos");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Registro de entradas");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(50, 130, 181));
        jLabel4.setText("Complete la Informacion de las entradas.");

        cmbproductos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Productos" }));
        cmbproductos.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        cmbproductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbproductosActionPerformed(evt);
            }
        });

        lblidprod.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblidprod.setText("ID");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("ID");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setText("Stock");

        txtpventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtpventa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpventaActionPerformed(evt);
            }
        });

        cmbproveedor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "proveedor" }));
        cmbproveedor.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        cmbproveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbproveedorActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setText("Proveedor");

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("ID");

        lblidprov.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblidprov.setText("ID");

        jdate.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));

        jLabel10.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel10.setText("Fecha");

        txtpentrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtpentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpentradaActionPerformed(evt);
            }
        });

        txtstockentrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        txtstockentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstockentradaActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel11.setText("Total");

        jLabel12.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel12.setText("Precio de venta");

        jLabel13.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel13.setText("Precio de entrada");

        tbentradas.setModel(new javax.swing.table.DefaultTableModel(
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
        tbentradas.setPreferredSize(new java.awt.Dimension(494, 80));
        jScrollPane1.setViewportView(tbentradas);
        if (tbentradas.getColumnModel().getColumnCount() > 0) {
            tbentradas.getColumnModel().getColumn(0).setResizable(false);
            tbentradas.getColumnModel().getColumn(0).setHeaderValue("ID/E");
            tbentradas.getColumnModel().getColumn(1).setResizable(false);
            tbentradas.getColumnModel().getColumn(1).setHeaderValue("ID/Prod");
            tbentradas.getColumnModel().getColumn(2).setResizable(false);
            tbentradas.getColumnModel().getColumn(2).setHeaderValue("Stock");
            tbentradas.getColumnModel().getColumn(3).setResizable(false);
            tbentradas.getColumnModel().getColumn(3).setHeaderValue("Fecha");
            tbentradas.getColumnModel().getColumn(4).setResizable(false);
            tbentradas.getColumnModel().getColumn(4).setHeaderValue("ID/Prov");
            tbentradas.getColumnModel().getColumn(5).setResizable(false);
            tbentradas.getColumnModel().getColumn(5).setHeaderValue("P.E");
            tbentradas.getColumnModel().getColumn(6).setResizable(false);
            tbentradas.getColumnModel().getColumn(6).setHeaderValue("P.V");
            tbentradas.getColumnModel().getColumn(7).setResizable(false);
            tbentradas.getColumnModel().getColumn(7).setHeaderValue("Total");
        }

        btnentrada.setBackground(new java.awt.Color(50, 130, 181));
        btnentrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnentrada.setForeground(new java.awt.Color(255, 255, 255));
        btnentrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Guardar.png"))); // NOI18N
        btnentrada.setText("Guardar");
        btnentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnentradaActionPerformed(evt);
            }
        });

        btnbusentrada.setBackground(new java.awt.Color(50, 130, 181));
        btnbusentrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnbusentrada.setForeground(new java.awt.Color(255, 255, 255));
        btnbusentrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/buscar.png"))); // NOI18N
        btnbusentrada.setText("Buscar");
        btnbusentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusentradaActionPerformed(evt);
            }
        });

        btnexpentrada.setBackground(new java.awt.Color(50, 130, 181));
        btnexpentrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnexpentrada.setForeground(new java.awt.Color(255, 255, 255));
        btnexpentrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/pdf.png"))); // NOI18N
        btnexpentrada.setText("Exportar");
        btnexpentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexpentradaActionPerformed(evt);
            }
        });

        btnelimentrada.setBackground(new java.awt.Color(50, 130, 181));
        btnelimentrada.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnelimentrada.setForeground(new java.awt.Color(255, 255, 255));
        btnelimentrada.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/eliminar.png"))); // NOI18N
        btnelimentrada.setText("Eliminar");
        btnelimentrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnelimentradaActionPerformed(evt);
            }
        });

        lbltotalentrada.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));

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

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/FormularioR.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbproductos, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 19, Short.MAX_VALUE)
                                    .addComponent(lblidprod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel6)
                                    .addComponent(txtpventa, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtpentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel11)
                                    .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtstockentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbltotalentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cmbproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, 153, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblidprov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(btnentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(btnelimentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnlimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(115, 115, 115)
                            .addComponent(btnexpentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnbusentrada, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addContainerGap(612, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel2)))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(btnbusentrada))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbproductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblidprod, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel6)
                        .addGap(18, 18, 18)
                        .addComponent(txtstockentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(jdate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbproveedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblidprov, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel13)
                        .addGap(18, 18, 18)
                        .addComponent(txtpentrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(txtpventa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel11)
                        .addGap(12, 12, 12)
                        .addComponent(lbltotalentrada, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 447, Short.MAX_VALUE)
                        .addGap(27, 27, 27)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnentrada)
                            .addComponent(btnelimentrada))
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnexpentrada)
                            .addComponent(btnlimpiar))
                        .addGap(32, 32, 32))))
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

    private void btnentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnentradaActionPerformed
        if (txtstockentrada.getText().isEmpty()
                || txtpentrada.getText().isEmpty()
                || txtpventa.getText().isEmpty()
                || jdate.getDate() == null) {

            JOptionPane.showMessageDialog(this, "Complete todos los campos.");
            return;
        }

        Entrada e = new Entrada();
        e.setIdProducto(Integer.parseInt(lblidprod.getText()));
        e.setStock(Integer.parseInt(txtstockentrada.getText()));
        e.setFecha(new java.sql.Date(jdate.getDate().getTime()));
        e.setIdProveedor(Integer.parseInt(lblidprov.getText()));
        e.setPrecioE(Double.parseDouble(txtpentrada.getText().replace(",", ".")));
        e.setPrecioV(Double.parseDouble(txtpventa.getText().replace(",", ".")));
        e.setTotal(Double.parseDouble(lbltotalentrada.getText().replace(",", ".")));

        DaoEntrada dao = new DaoEntrada();

        if (dao.guardarEntrada(e)) {
            JOptionPane.showMessageDialog(this, "Entrada registrada.");
            cargarEntradas();
            limpiarCampos();
        } else {
            JOptionPane.showMessageDialog(this, "Error al guardar.");
        }
    }//GEN-LAST:event_btnentradaActionPerformed

    private void btnbusentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusentradaActionPerformed
        ForEntrada formulario4 = new ForEntrada();
        formulario4.setVisible(true);
    }//GEN-LAST:event_btnbusentradaActionPerformed

    private void btnexpentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexpentradaActionPerformed
// Verificar que haya datos en la tabla
        if (tbentradas.getRowCount() == 0) {
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
                    tbentradas,
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
    }//GEN-LAST:event_btnexpentradaActionPerformed

    private void btnelimentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnelimentradaActionPerformed
        if (idEntradaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, "Seleccione una entrada.");
            return;
        }

        int op = JOptionPane.showConfirmDialog(this, "¿Eliminar entrada?", "Confirmar", JOptionPane.YES_NO_OPTION);

        if (op == JOptionPane.YES_OPTION) {

            DaoEntrada dao = new DaoEntrada();

            if (dao.eliminarEntrada(idEntradaSeleccionada)) {
                JOptionPane.showMessageDialog(this, "Entrada eliminada.");
                cargarEntradas();
                limpiarCampos();
            }
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btnelimentradaActionPerformed

    private void btnlimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnlimpiarActionPerformed
        limpiarCampos();        // TODO add your handling code here:
    }//GEN-LAST:event_btnlimpiarActionPerformed

    private void cmbproductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbproductosActionPerformed
        int i = cmbproductos.getSelectedIndex();
        if (i >= 0)
            lblidprod.setText(String.valueOf(listaProductos.get(i).getIdProducto()));
    }//GEN-LAST:event_cmbproductosActionPerformed

    private void txtstockentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstockentradaActionPerformed
        calcularTotal();
    }//GEN-LAST:event_txtstockentradaActionPerformed

    private void cmbproveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbproveedorActionPerformed
        int i = cmbproveedor.getSelectedIndex();
        if (i >= 0)
            lblidprov.setText(String.valueOf(listaProveedores.get(i).getIdProveedor()));
    }//GEN-LAST:event_cmbproveedorActionPerformed

    private void txtpentradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpentradaActionPerformed
        calcularTotal();
    }//GEN-LAST:event_txtpentradaActionPerformed

    private void txtpventaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpventaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpventaActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusentrada;
    private javax.swing.JButton btnelimentrada;
    private javax.swing.JButton btnentrada;
    private javax.swing.JButton btnexpentrada;
    private javax.swing.JButton btnlimpiar;
    private javax.swing.JComboBox<String> cmbproductos;
    private javax.swing.JComboBox<String> cmbproveedor;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private com.toedter.calendar.JDateChooser jdate;
    private javax.swing.JLabel lblidprod;
    private javax.swing.JLabel lblidprov;
    private javax.swing.JLabel lbltotalentrada;
    private javax.swing.JTable tbentradas;
    private javax.swing.JTextField txtpentrada;
    private javax.swing.JTextField txtpventa;
    private javax.swing.JTextField txtstockentrada;
    // End of variables declaration//GEN-END:variables

    private void limpiarCampos() {
        cmbproductos.setSelectedIndex(0);
        cmbproveedor.setSelectedIndex(0);
        txtstockentrada.setText("");
        txtpentrada.setText("");
        txtpventa.setText("");
        lbltotalentrada.setText("0.00");
        jdate.setDate(null);
        idEntradaSeleccionada = -1;
        tbentradas.clearSelection();
    }

}
