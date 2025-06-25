package com.our.inventario.view;

import com.our.inventario.model.Categoria;
import com.our.inventario.model.Producto;
import java.awt.MouseInfo;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ProductoView extends javax.swing.JFrame {

    private DefaultTableModel tblModelo = new DefaultTableModel();
    private DefaultComboBoxModel<Categoria> cbxModel = new DefaultComboBoxModel<>();

    public ProductoView() {
        initComponents();
        initTable();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevoProductoDialog = new javax.swing.JDialog();
        jLabel2 = new javax.swing.JLabel();
        txtNombreProducto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcionProducto = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbxCategorias = new javax.swing.JComboBox<>();
        txtPrecioProducto = new javax.swing.JTextField();
        btnRegistrarNuevoProducto = new javax.swing.JButton();
        btnCloseNuevoProducto = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupEditarProd = new javax.swing.JMenuItem();
        popupEliminarProd = new javax.swing.JMenuItem();
        btnOpenNuevoProducto = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblProductos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        nuevoProductoDialog.setMinimumSize(new java.awt.Dimension(324, 361));

        jLabel2.setText("Nuevo Producto");

        jLabel3.setText("Nombre");

        jLabel4.setText("Descripción");

        jLabel5.setText("Categoría");

        jLabel6.setText("Precio");

        btnRegistrarNuevoProducto.setText("Registrar");

        btnCloseNuevoProducto.setText("Cancelar");

        javax.swing.GroupLayout nuevoProductoDialogLayout = new javax.swing.GroupLayout(nuevoProductoDialog.getContentPane());
        nuevoProductoDialog.getContentPane().setLayout(nuevoProductoDialogLayout);
        nuevoProductoDialogLayout.setHorizontalGroup(
            nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel2))
                    .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                        .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(jLabel4))))
                            .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))))
                        .addGap(28, 28, 28)
                        .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNombreProducto)
                            .addComponent(txtDescripcionProducto)
                            .addComponent(cbxCategorias, 0, 109, Short.MAX_VALUE)
                            .addComponent(txtPrecioProducto))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, nuevoProductoDialogLayout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(btnCloseNuevoProducto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addComponent(btnRegistrarNuevoProducto)
                .addGap(52, 52, 52))
        );
        nuevoProductoDialogLayout.setVerticalGroup(
            nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevoProductoDialogLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cbxCategorias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtPrecioProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(68, 68, 68)
                .addGroup(nuevoProductoDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrarNuevoProducto)
                    .addComponent(btnCloseNuevoProducto))
                .addContainerGap(86, Short.MAX_VALUE))
        );

        popupEditarProd.setText("Editar");
        jPopupMenu1.add(popupEditarProd);

        popupEliminarProd.setText("Eliminar");
        jPopupMenu1.add(popupEliminarProd);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnOpenNuevoProducto.setText("Nuevo Producto");

        tblProductos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripción", "Categoría"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblProductos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblProductosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblProductos);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 137, 206));
        jLabel1.setText("Gestión de Productos");

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
                        .addComponent(btnOpenNuevoProducto)
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
                    .addComponent(btnOpenNuevoProducto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 361, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblProductosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblProductosMouseClicked
        int nPosX = MouseInfo.getPointerInfo().getLocation().x;
        int nPosY = MouseInfo.getPointerInfo().getLocation().y;
        jPopupMenu1.show(this, nPosX, nPosY);
    }//GEN-LAST:event_tblProductosMouseClicked

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
        tblProductos.setModel(tblModelo);
    }

    private void setCategorias(List<Categoria> categorias) {
        for (Categoria c : categorias) {
            cbxModel.addElement(c);
        }
        cbxCategorias.setModel(cbxModel);
    }

    public void mostrar(List<Producto> productos) {
        this.setVisible(true);
        actualizarTabla(productos);
    }

    public void mostrarRegistroProducto(List<Categoria> categorias) {
        setCategorias(categorias);
        System.out.println("se abrio");
        nuevoProductoDialog.setVisible(true);
    }

    public void setOnRegistroProducto(ActionListener listener) {
        btnRegistrarNuevoProducto.addActionListener(listener);
    }

    public void setOnOpenNuevoProducto(ActionListener listener) {
        btnOpenNuevoProducto.addActionListener(listener);
    }

    public void setOnEditarProducto(ActionListener r) {
    }

    public void setOnEliminarProducto(ActionListener r) {
    }

    public String getSku() {
        return "SKU-" + java.time.LocalDate.now() + "-" + java.util.UUID.randomUUID().toString().substring(0, 6).toUpperCase();
    }

    public String getNombre() {
        return txtNombreProducto.getText();
    }

    public String getDescripcion() {
        return "";
    }

    public Categoria getCategoriaSeleccionada() {
        return (Categoria) cbxCategorias.getSelectedItem();
    }

    public String getMarca() {
        return "";
    }

    public double getPrecio() {
        String texto = txtPrecioProducto.getText();
        return Double.parseDouble(texto);
    }

    public int getIdProducto() {
        return 0;
    }

    public int getIdProductoSeleccionado() {
        return 0;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Ok",
                JOptionPane.OK_OPTION
        );
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(
                this,
                mensaje,
                "Error",
                JOptionPane.ERROR_MESSAGE
        );
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCloseNuevoProducto;
    private javax.swing.JButton btnOpenNuevoProducto;
    private javax.swing.JButton btnRegistrarNuevoProducto;
    private javax.swing.JComboBox<Categoria> cbxCategorias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JDialog nuevoProductoDialog;
    private javax.swing.JMenuItem popupEditarProd;
    private javax.swing.JMenuItem popupEliminarProd;
    private javax.swing.JTable tblProductos;
    private javax.swing.JTextField txtDescripcionProducto;
    private javax.swing.JTextField txtNombreProducto;
    private javax.swing.JTextField txtPrecioProducto;
    // End of variables declaration//GEN-END:variables
}
