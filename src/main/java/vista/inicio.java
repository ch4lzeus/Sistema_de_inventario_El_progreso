package vista;

import controlador.DaoEstadisticas;

public class inicio extends javax.swing.JPanel {

    /**
     * Creates new form inicio
     */
    public inicio() {
        initComponents();
        cargarEstadisticas();
    }
    
     // ← AGREGAR ESTE MÉTODO
    private void cargarEstadisticas() {
        DaoEstadisticas dao = new DaoEstadisticas();
        
        // Cargar todas las estadísticas de una vez
        dao.cargarTodasLasEstadisticas(
            lblad1,      // Total de Administradores
            lblent2,     // Total de Usuarios
            lblusu,      // Total de Entradas
            lblpro,      // Total de Proveedores
            lblcat,      // Total de Categorías
            lblsal       // Total de Salidas
        );
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanelinicio = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lblusu = new javax.swing.JLabel();
        lblpro = new javax.swing.JLabel();
        lblad1 = new javax.swing.JLabel();
        lblcat = new javax.swing.JLabel();
        lblsal = new javax.swing.JLabel();
        lblent2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(951, 775));

        jpanelinicio.setBackground(new java.awt.Color(255, 255, 255));
        jpanelinicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(50, 130, 181));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/salida.png"))); // NOI18N
        jLabel2.setText("Salidas");
        jLabel2.setOpaque(true);
        jpanelinicio.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 600, 170, 53));

        jLabel5.setBackground(new java.awt.Color(50, 130, 181));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/producto.png"))); // NOI18N
        jLabel5.setText("Proveedores");
        jLabel5.setOpaque(true);
        jLabel5.setPreferredSize(new java.awt.Dimension(133, 25));
        jpanelinicio.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 130, 180, 53));

        jLabel1.setBackground(new java.awt.Color(50, 130, 181));
        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuario.png"))); // NOI18N
        jLabel1.setText("Administradores");
        jLabel1.setOpaque(true);
        jpanelinicio.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 130, 184, 53));

        jLabel3.setBackground(new java.awt.Color(50, 130, 181));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/usuario.png"))); // NOI18N
        jLabel3.setText("Usuarios");
        jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        jLabel3.setOpaque(true);
        jpanelinicio.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 600, 184, 53));

        jLabel4.setBackground(new java.awt.Color(50, 130, 181));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/entrada.png"))); // NOI18N
        jLabel4.setText("Entradas");
        jLabel4.setOpaque(true);
        jpanelinicio.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(161, 365, 184, 53));

        jLabel6.setBackground(new java.awt.Color(50, 130, 181));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/categorias.png"))); // NOI18N
        jLabel6.setText("Categorías");
        jLabel6.setOpaque(true);
        jpanelinicio.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(669, 365, 170, 53));

        lblusu.setBackground(new java.awt.Color(50, 130, 181));
        lblusu.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblusu.setForeground(new java.awt.Color(255, 255, 255));
        lblusu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblusu.setText("N°");
        lblusu.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblusu.setOpaque(true);
        lblusu.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblusu, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 365, 70, 53));
        lblusu.getAccessibleContext().setAccessibleDescription("");

        lblpro.setBackground(new java.awt.Color(50, 130, 181));
        lblpro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblpro.setForeground(new java.awt.Color(255, 255, 255));
        lblpro.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblpro.setText("N°");
        lblpro.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblpro.setOpaque(true);
        lblpro.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblpro, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 130, 70, 53));

        lblad1.setBackground(new java.awt.Color(50, 130, 181));
        lblad1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblad1.setForeground(new java.awt.Color(255, 255, 255));
        lblad1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblad1.setText("N°");
        lblad1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(50, 130, 181)));
        lblad1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        lblad1.setOpaque(true);
        lblad1.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblad1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 70, 53));

        lblcat.setBackground(new java.awt.Color(50, 130, 181));
        lblcat.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblcat.setForeground(new java.awt.Color(255, 255, 255));
        lblcat.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblcat.setText("N°");
        lblcat.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblcat.setOpaque(true);
        lblcat.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblcat, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 365, 70, 53));

        lblsal.setBackground(new java.awt.Color(50, 130, 181));
        lblsal.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblsal.setForeground(new java.awt.Color(255, 255, 255));
        lblsal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsal.setText("N°");
        lblsal.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblsal.setOpaque(true);
        lblsal.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblsal, new org.netbeans.lib.awtextra.AbsoluteConstraints(598, 600, 70, 53));

        lblent2.setBackground(new java.awt.Color(50, 130, 181));
        lblent2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblent2.setForeground(new java.awt.Color(255, 255, 255));
        lblent2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblent2.setText("N°");
        lblent2.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        lblent2.setOpaque(true);
        lblent2.setVerticalTextPosition(javax.swing.SwingConstants.TOP);
        jpanelinicio.add(lblent2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 600, 70, 53));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(50, 130, 181));
        jLabel7.setText("INDICADORES DEL SISTEMA");
        jpanelinicio.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 40, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpanelinicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jpanelinicio;
    private javax.swing.JLabel lblad1;
    private javax.swing.JLabel lblcat;
    private javax.swing.JLabel lblent2;
    private javax.swing.JLabel lblpro;
    private javax.swing.JLabel lblsal;
    private javax.swing.JLabel lblusu;
    // End of variables declaration//GEN-END:variables
}


