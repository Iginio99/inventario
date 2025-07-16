package com.our.inventario.view;

import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class MovimientosForm extends javax.swing.JFrame {

    public MovimientosForm() {
        initComponents();
    }

    public void setOnOpenNotaDeEntrada(ActionListener listener) {
        btnOpenNotaDeEntrada.addActionListener(listener);
    }

    public void setOnOpenNotaDeSalida(ActionListener listener) {
        btnOpenNotaDeSalida.addActionListener(listener);
    }

    public void setOnRegresarMenu(ActionListener listener) {
        btnRegresarMenu.addActionListener(listener);
    }

    public void setOnRegresarEleccion(ActionListener listener) {
        btnRegresarEleccion.addActionListener(listener);
    }

    public void setOnGuardarMovimiento(ActionListener listener) {
        btnGuardarMovimiento.addActionListener(listener);
    }

    public void setOnEliminarProducto(ActionListener listener) {
        popupEliminarProducto.addActionListener(listener);
    }

    public void setOnAgregarProducto(ActionListener listener) {
        btnAgregarProducto.addActionListener(listener);
    }

    public void setOnLimpiar(ActionListener listener) {
        btnLimpiar.addActionListener(listener);
    }

    public void setOnSeleccionarProducto(ActionListener listener) {
        cbxProductos.addActionListener(listener);
    }

    public void mostrarElegirTipo() {
        dialogTipoMovimiento.setVisible(true);
    }

    public void mostrarRegistroMovimiento() {
        this.setVisible(true);
    }

    public void retrocederRegistroMovimiento() {
        this.setVisible(false);
    }

    public void retrocederEleccion() {
        dialogTipoMovimiento.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dialogTipoMovimiento = new javax.swing.JDialog();
        btnOpenNotaDeEntrada = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btnOpenNotaDeSalida = new javax.swing.JButton();
        btnRegresarMenu = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupEliminarProducto = new javax.swing.JMenuItem();
        jLabel1 = new javax.swing.JLabel();
        cbxProductos = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtCantidad = new javax.swing.JTextField();
        btnAgregarProducto = new javax.swing.JButton();
        btnRegresarEleccion = new javax.swing.JButton();
        btnGuardarMovimiento = new javax.swing.JButton();
        btnLimpiar = new javax.swing.JButton();
        lblTipoMovimiento = new javax.swing.JLabel();

        dialogTipoMovimiento.setMinimumSize(new java.awt.Dimension(290, 160));
        dialogTipoMovimiento.setPreferredSize(new java.awt.Dimension(290, 160));
        dialogTipoMovimiento.setResizable(false);

        btnOpenNotaDeEntrada.setText("Nota de entrada");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 137, 206));
        jLabel2.setText("MOVIMIENTO");

        btnOpenNotaDeSalida.setText("Nota de salida");

        btnRegresarMenu.setText("Regresar");

        javax.swing.GroupLayout dialogTipoMovimientoLayout = new javax.swing.GroupLayout(dialogTipoMovimiento.getContentPane());
        dialogTipoMovimiento.getContentPane().setLayout(dialogTipoMovimientoLayout);
        dialogTipoMovimientoLayout.setHorizontalGroup(
            dialogTipoMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTipoMovimientoLayout.createSequentialGroup()
                .addGroup(dialogTipoMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dialogTipoMovimientoLayout.createSequentialGroup()
                        .addGap(82, 82, 82)
                        .addGroup(dialogTipoMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnOpenNotaDeEntrada, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnOpenNotaDeSalida, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(dialogTipoMovimientoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnRegresarMenu)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        dialogTipoMovimientoLayout.setVerticalGroup(
            dialogTipoMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dialogTipoMovimientoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(dialogTipoMovimientoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresarMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpenNotaDeEntrada)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnOpenNotaDeSalida)
                .addContainerGap(42, Short.MAX_VALUE))
        );

        popupEliminarProducto.setText("jMenuItem1");
        jPopupMenu1.add(popupEliminarProducto);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 137, 206));
        jLabel1.setText("Gestión de Movimientos");

        cbxProductos.setName("Productos"); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "N°", "Producto", "Cantidad"
            }
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMinWidth(40);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        btnAgregarProducto.setText("Agregar");

        btnRegresarEleccion.setText("Regresar");

        btnGuardarMovimiento.setText("Guardar Movmimiento");

        btnLimpiar.setText("Limpiar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(lblTipoMovimiento, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(cbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAgregarProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnRegresarEleccion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnLimpiar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardarMovimiento)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTipoMovimiento, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnRegresarEleccion)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxProductos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAgregarProducto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardarMovimiento)
                    .addComponent(btnLimpiar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        if (SwingUtilities.isRightMouseButton(evt)) {
            int nPosX = evt.getX();
            int nPosY = evt.getY();
            jPopupMenu1.show(evt.getComponent(), nPosX, nPosY);
        }
    }//GEN-LAST:event_jTable1MouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarProducto;
    private javax.swing.JButton btnGuardarMovimiento;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JButton btnOpenNotaDeEntrada;
    private javax.swing.JButton btnOpenNotaDeSalida;
    private javax.swing.JButton btnRegresarEleccion;
    private javax.swing.JButton btnRegresarMenu;
    private javax.swing.JComboBox<String> cbxProductos;
    private javax.swing.JDialog dialogTipoMovimiento;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lblTipoMovimiento;
    private javax.swing.JMenuItem popupEliminarProducto;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
