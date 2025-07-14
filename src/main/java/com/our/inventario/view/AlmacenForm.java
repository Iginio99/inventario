package com.our.inventario.view;

import com.our.inventario.data.ListaAlmacen;
import com.our.inventario.data.NodoAlmacen;
import com.our.inventario.model.Almacen;
import com.our.inventario.model.Categoria;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AlmacenForm extends javax.swing.JFrame {

    private DefaultTableModel tblModelo = new DefaultTableModel();
    private DefaultComboBoxModel<Categoria> cbxModel = new DefaultComboBoxModel<>();
    

    public AlmacenForm() {
        initComponents();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoAlmacenDialog = new javax.swing.JDialog();
        lblAlmacen = new javax.swing.JLabel();
        txtNombreAlmacen = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        btnRegistrarNuevoAlmacen = new javax.swing.JButton();
        btnCloseNuevoAlmacen = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupEditarAlmacen = new javax.swing.JMenuItem();
        popupEliminarAlmacen = new javax.swing.JMenuItem();
        popupAgregarLote = new javax.swing.JMenuItem();
        popupAgregarStock = new javax.swing.JMenuItem();
        btnOpenNuevoAlmacen = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAlmacenes = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnRegresar = new javax.swing.JButton();

        nuevoAlmacenDialog.setMinimumSize(new java.awt.Dimension(324, 361));

        lblAlmacen.setText("Nuevo Almacen");

        jLabel3.setText("Nombre");

        btnRegistrarNuevoAlmacen.setText("Registrar");

        btnCloseNuevoAlmacen.setText("Cancelar");

        javax.swing.GroupLayout nuevoAlmacenDialogLayout = new javax.swing.GroupLayout(nuevoAlmacenDialog.getContentPane());
        nuevoAlmacenDialog.getContentPane().setLayout(nuevoAlmacenDialogLayout);
        nuevoAlmacenDialogLayout.setHorizontalGroup(
            nuevoAlmacenDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoAlmacenDialogLayout.createSequentialGroup()
                .addGroup(nuevoAlmacenDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevoAlmacenDialogLayout.createSequentialGroup()
                        .addContainerGap(60, Short.MAX_VALUE)
                        .addComponent(btnCloseNuevoAlmacen)
                        .addGap(56, 56, 56)
                        .addComponent(btnRegistrarNuevoAlmacen))
                    .addGroup(nuevoAlmacenDialogLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(lblAlmacen)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(nuevoAlmacenDialogLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel3)
                        .addGap(52, 52, 52)
                        .addComponent(txtNombreAlmacen)))
                .addGap(56, 56, 56))
        );
        nuevoAlmacenDialogLayout.setVerticalGroup(
            nuevoAlmacenDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoAlmacenDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(lblAlmacen)
                .addGap(18, 18, 18)
                .addGroup(nuevoAlmacenDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreAlmacen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(nuevoAlmacenDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCloseNuevoAlmacen)
                    .addComponent(btnRegistrarNuevoAlmacen))
                .addContainerGap(34, Short.MAX_VALUE))
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

        popupAgregarLote.setText("jMenuItem1");
        jPopupMenu1.add(popupAgregarLote);

        popupAgregarStock.setText("jMenuItem1");
        jPopupMenu1.add(popupAgregarStock);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOpenNuevoAlmacen.setText("Nuevo Almacen");

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
        jLabel1.setText("Gestión de Almacenes");

        btnRegresar.setText("Regresar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnOpenNuevoAlmacen)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnOpenNuevoAlmacen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnRegresar))
                .addGap(18, 18, Short.MAX_VALUE)
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
        tblAlmacenes.setModel(tblModelo);
    }

    private void actualizarTabla(ListaAlmacen lista) {
        tblModelo.setRowCount(0);
        NodoAlmacen actual = lista.getStart();
        while (actual != null) {
            Almacen alm = actual.getModel();
            Object[] fila = new Object[]{
                alm.getIdAlmacen(),
                alm.getNombre()
            };
            tblModelo.addRow(fila);
            actual = actual.getSiguiente();
        }
        tblAlmacenes.setModel(tblModelo);
    }

    public void mostrar(ListaAlmacen lista) {
        this.setVisible(true);
        actualizarTabla(lista);
    }

    public void mostrarRegistroAlmacen() {
        lblAlmacen.setText("Nuevo almacén");
        btnRegistrarNuevoAlmacen.setText("Registrar");
        nuevoAlmacenDialog.setVisible(true);
    }

    public void mostrarEditarAlmacen(Almacen almacen) {
        lblAlmacen.setText("Editar almacén");
        txtNombreAlmacen.setText(almacen.getNombre());
        btnRegistrarNuevoAlmacen.setText("Editar");
        nuevoAlmacenDialog.setVisible(true);
    }

    public void cerrarVistaNuevoAlmacen() {
        nuevoAlmacenDialog.setVisible(false);
    }

    public void limpiarDatosRegistro() {
        txtNombreAlmacen.setText("");
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "OK", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public int getIdAlmacenSeleccionado() {
        int fila = tblAlmacenes.getSelectedRow();
        if (fila == -1) return -1;
        return Integer.parseInt(tblModelo.getValueAt(fila, 0).toString());
    }

    public String getNameAlmacenSeleccionado() {
        int fila = tblAlmacenes.getSelectedRow();
        if (fila == -1) return null;
        return tblModelo.getValueAt(fila, 1).toString();
    }

    public String getNombre() {
        return txtNombreAlmacen.getText();
    }

    public void cerrar() {
        this.dispose();
    }

    public void setOnRegistroAlmacen(ActionListener listener) {
        btnRegistrarNuevoAlmacen.addActionListener(listener);
    }

    public void setOnOpenNuevoAlmacen(ActionListener listener) {
        btnOpenNuevoAlmacen.addActionListener(listener);
    }

    public void setOnOpenEditarAlmacen(ActionListener listener) {
        popupEditarAlmacen.addActionListener(listener);
    }

    public void setOnEliminarAlmacen(ActionListener listener) {
        popupEliminarAlmacen.addActionListener(listener);
    }

    public void setOnRegresarMenu(ActionListener listener) {
        btnRegresar.addActionListener(listener);
    }

    public void setOnCloseNuevoAlmacen(ActionListener listener) {
        btnCloseNuevoAlmacen.addActionListener(listener);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseNuevoAlmacen;
    private javax.swing.JButton btnOpenNuevoAlmacen;
    private javax.swing.JButton btnRegistrarNuevoAlmacen;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAlmacen;
    private javax.swing.JDialog nuevoAlmacenDialog;
    private javax.swing.JMenuItem popupAgregarLote;
    private javax.swing.JMenuItem popupAgregarStock;
    private javax.swing.JMenuItem popupEditarAlmacen;
    private javax.swing.JMenuItem popupEliminarAlmacen;
    private javax.swing.JTable tblAlmacenes;
    private javax.swing.JTextField txtNombreAlmacen;
    // End of variables declaration//GEN-END:variables
}
