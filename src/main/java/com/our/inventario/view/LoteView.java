package com.our.inventario.view;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

public class LoteView extends javax.swing.JFrame {

    private DefaultTableModel tblModelo = new DefaultTableModel();
    private DefaultComboBoxModel<Categoria> cbxModel = new DefaultComboBoxModel<>();
    

    public LoteView() {
        initComponents();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoLoteDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtNombreAlmacen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrarNuevoAlmacen = new javax.swing.JButton();
        btnCloseNuevoAlmacen = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupEditarAlmacen = new javax.swing.JMenuItem();
        popupEliminarAlmacen = new javax.swing.JMenuItem();
        btnOpenNuevoLote = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlmacenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        nuevoLoteDialog.setMinimumSize(new java.awt.Dimension(324, 361));

        jLabel2.setText("Nuevo Lote");

        jLabel3.setText("Nombre");

        btnRegistrarNuevoAlmacen.setText("Registrar");

        btnCloseNuevoAlmacen.setText("Cancelar");

        javax.swing.GroupLayout nuevoLoteDialogLayout = new javax.swing.GroupLayout(nuevoLoteDialog.getContentPane());
        nuevoLoteDialog.getContentPane().setLayout(nuevoLoteDialogLayout);
        nuevoLoteDialogLayout.setHorizontalGroup(
            nuevoLoteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nuevoLoteDialogLayout.createSequentialGroup()
                .addGroup(nuevoLoteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(nuevoLoteDialogLayout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(btnCloseNuevoAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRegistrarNuevoAlmacen))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, nuevoLoteDialogLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, nuevoLoteDialogLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))
                .addGap(56, 56, 56))
        );
        nuevoLoteDialogLayout.setVerticalGroup(
            nuevoLoteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoLoteDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(nuevoLoteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(32, 32, 32)
                .addGroup(nuevoLoteDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseNuevoAlmacen)
                    .addComponent(btnRegistrarNuevoAlmacen))
                .addContainerGap(29, Short.MAX_VALUE))
        );

        popupEditarAlmacen.setText("Editar");
        popupEditarAlmacen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                popupEditarAlmacenActionPerformed(evt);
            }
        });
        jPopupMenu1.add(popupEditarAlmacen);

        popupEliminarAlmacen.setText("Eliminar");
        jPopupMenu1.add(popupEliminarAlmacen);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOpenNuevoLote.setText("Nuevo Lote");

        tblAlmacenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblAlmacenes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAlmacenesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblAlmacenes);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 137, 206));
        jLabel1.setText("Gestión de Lotes");

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
                        .addComponent(btnOpenNuevoLote)
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
                    .addComponent(btnOpenNuevoLote, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblAlmacenesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAlmacenesMouseClicked
        int nPosX = MouseInfo.getPointerInfo().getLocation().x;
        int nPosY = MouseInfo.getPointerInfo().getLocation().y;
        jPopupMenu1.show(this, nPosX, nPosY);
    }//GEN-LAST:event_tblAlmacenesMouseClicked

    private void popupEditarAlmacenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_popupEditarAlmacenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_popupEditarAlmacenActionPerformed

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
        tblAlmacenes.setModel(tblModelo);
    }

    

    public void mostrar(List<Producto> productos) {
        this.setVisible(true);
        actualizarTabla(productos);
    }

    public void mostrarRegistroProducto() {
        System.out.println("se abrio");
        nuevoLoteDialog.setVisible(true);
    }

    public void setOnRegistroProducto(ActionListener listener) {
        btnRegistrarNuevoAlmacen.addActionListener(listener);
    }

    public void setOnOpenNuevoProducto(ActionListener listener) {
        btnOpenNuevoLote.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseNuevoAlmacen;
    private javax.swing.JButton btnOpenNuevoLote;
    private javax.swing.JButton btnRegistrarNuevoAlmacen;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog nuevoLoteDialog;
    private javax.swing.JMenuItem popupEditarAlmacen;
    private javax.swing.JMenuItem popupEliminarAlmacen;
    private javax.swing.JTable tblAlmacenes;
    private javax.swing.JTextField txtNombreAlmacen;
    // End of variables declaration//GEN-END:variables
}
