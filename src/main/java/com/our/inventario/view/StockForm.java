package com.our.inventario.view;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class StockForm extends javax.swing.JFrame {

    private DefaultTableModel tblModelo = new DefaultTableModel();
    private DefaultComboBoxModel<Categoria> cbxModel = new DefaultComboBoxModel<>();
    

    public StockForm() {
        initComponents();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoStockDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAlmacen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrarNuevoAlmacen = new javax.swing.JButton();
        btnCloseNuevoAlmacen = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxLoteStock = new javax.swing.JComboBox<>();
        cbxProducto = new javax.swing.JComboBox<>();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupVerLotes = new javax.swing.JMenuItem();
        jComboBox2 = new javax.swing.JComboBox<>();
        btnOpenNuevoStock = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStock = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        nuevoStockDialog.setMinimumSize(new java.awt.Dimension(324, 361));

        jLabel2.setText("Nuevo Stock");

        jLabel3.setText("Cantidad");

        btnRegistrarNuevoAlmacen.setText("Registrar");

        btnCloseNuevoAlmacen.setText("Cancelar");

        jLabel4.setText("Lote");

        jLabel6.setText("Producto");

        cbxLoteStock.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxProducto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout nuevoStockDialogLayout = new javax.swing.GroupLayout(nuevoStockDialog.getContentPane());
        nuevoStockDialog.getContentPane().setLayout(nuevoStockDialogLayout);
        nuevoStockDialogLayout.setHorizontalGroup(
            nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGap(52, 52, 52)
                        .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                            .addComponent(cbxLoteStock, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbxProducto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(56, 56, 56))
            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(btnCloseNuevoAlmacen)
                .addGap(49, 49, 49)
                .addComponent(btnRegistrarNuevoAlmacen)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        nuevoStockDialogLayout.setVerticalGroup(
            nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoStockDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(28, 28, 28)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbxLoteStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cbxProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                .addGroup(nuevoStockDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseNuevoAlmacen)
                    .addComponent(btnRegistrarNuevoAlmacen))
                .addGap(42, 42, 42))
        );

        popupVerLotes.setText("Eliminar");
        jPopupMenu1.add(popupVerLotes);

        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOpenNuevoStock.setText("Nuevo Stock");

        tblStock.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Producto", "Total"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStock.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStockMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStock);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 137, 206));
        jLabel1.setText("Gestión de Stock");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpenNuevoStock)
                        .addGap(14, 14, 14))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(btnOpenNuevoStock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblStockMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStockMouseClicked
        int nPosX = MouseInfo.getPointerInfo().getLocation().x;
        int nPosY = MouseInfo.getPointerInfo().getLocation().y;
        jPopupMenu1.show(this, nPosX, nPosY);
    }//GEN-LAST:event_tblStockMouseClicked

    private void initTable() {
        tblModelo.addColumn("ID");
        tblModelo.addColumn("Nombre");
        tblModelo.addColumn("Descripción");
        tblModelo.addColumn("Categoría");
    }

    private void actualizarTabla(List<Producto> productos) {
        tblModelo.setRowCount(0);
        for (Producto prod : productos) {
            Object[] fila = new Object[]{
                prod.getIdProducto(),
                prod.getNombre(),
                prod.getDescripcion(),
                prod.getCategoria().getNombre()
            };
            tblModelo.addRow(fila);
        }
        tblStock.setModel(tblModelo);
    }

    

    public void mostrar(List<Producto> productos) {
        this.setVisible(true);
        actualizarTabla(productos);
    }

    public void mostrarRegistroProducto() {
        System.out.println("se abrio");
        nuevoStockDialog.setVisible(true);
    }

    public void setOnRegistroProducto(ActionListener listener) {
        btnRegistrarNuevoAlmacen.addActionListener(listener);
    }

    public void setOnOpenNuevoProducto(ActionListener listener) {
        btnOpenNuevoStock.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseNuevoAlmacen;
    private javax.swing.JButton btnOpenNuevoStock;
    private javax.swing.JButton btnRegistrarNuevoAlmacen;
    private javax.swing.JComboBox<String> cbxLoteStock;
    private javax.swing.JComboBox<String> cbxProducto;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog nuevoStockDialog;
    private javax.swing.JMenuItem popupVerLotes;
    private javax.swing.JTable tblStock;
    private javax.swing.JTextField txtNombreAlmacen;
    // End of variables declaration//GEN-END:variables
}
