package com.our.inventario.view;

import com.our.inventario.controller.CategoriaController;
import com.our.inventario.model.Categoria;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.table.DefaultTableModel;

public class CategoriaForm extends javax.swing.JFrame {
    private DefaultTableModel tblModelo = new DefaultTableModel();

    public CategoriaForm() {
        initComponents();
        initTable();
    }

    private void initTable() {
        JPopupMenu popupMenu = new JPopupMenu();

        // Opción 1: "Editar"
        JMenuItem editarItem = new JMenuItem("Editar");
        editarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tblCategorias.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    String nombre = (String) tblCategorias.getValueAt(filaSeleccionada, 1);
                    //JOptionPane.showMessageDialog( "Editando a: " + nombre);
                }
            }
        });

        // Opción 2: "Eliminar"
        JMenuItem eliminarItem = new JMenuItem("Eliminar");
        eliminarItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int filaSeleccionada = tblCategorias.getSelectedRow();
                if (filaSeleccionada >= 0) {
                    tblModelo.removeRow(filaSeleccionada);
                }
            }
        });
        tblModelo.addColumn("ID");
        tblModelo.addColumn("Nombre");
        tblModelo.addColumn("Descripción");
    }

    private void actualizarTabla(List<Categoria> categoria) {
        tblModelo.setRowCount(0);
        for (Categoria cat : categoria) {
            Object[] fila = new Object[]{
                cat.getId(),
                cat.getNombre(),
                cat.getDescripcion()
            };
            tblModelo.addRow(fila);
        }
        tblCategorias.setModel(tblModelo);
    }

    private void limpiarDatosRegistro(boolean mostrar) {
        txtNombreCategoria.setText("");
        txtDescripcionCategoria.setText("");
        nuevaCategoriaDialog.setVisible(mostrar);
    }
    
    public void mostrar(List<Categoria> categoria) {
        this.setVisible(true);
        actualizarTabla(categoria);
    }
    
    public void mostrarRegistroCategoria() {
        System.out.println("se abrio");
        nuevaCategoriaDialog.setVisible(true);
    }

    public void setOnRegistroCategoria(ActionListener listener) {
        btnRegistrarCategoria.addActionListener(listener);
    }

    public void setOnOpenNuevoCategoria(ActionListener listener) {
        btnNuevaCategoria.addActionListener(listener);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nuevaCategoriaDialog = new javax.swing.JDialog();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNombreCategoria = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcionCategoria = new javax.swing.JTextArea();
        btnRegistrarCategoria = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        popupEditarCat = new javax.swing.JMenuItem();
        popupEliminarCat = new javax.swing.JMenuItem();
        btnNuevaCategoria = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblCategorias = new javax.swing.JTable();

        nuevaCategoriaDialog.setTitle("Registar categoría");
        nuevaCategoriaDialog.setMinimumSize(new java.awt.Dimension(450, 200));

        jLabel6.setText("Nueva Categoría");

        jLabel7.setText("Nombre");

        jLabel8.setText("Descripción");

        txtDescripcionCategoria.setColumns(20);
        txtDescripcionCategoria.setRows(5);
        jScrollPane2.setViewportView(txtDescripcionCategoria);

        btnRegistrarCategoria.setText("Registrar");
        btnRegistrarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnRegistrarCategoriaMouseClicked(evt);
            }
        });

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout nuevaCategoriaDialogLayout = new javax.swing.GroupLayout(nuevaCategoriaDialog.getContentPane());
        nuevaCategoriaDialog.getContentPane().setLayout(nuevaCategoriaDialogLayout);
        nuevaCategoriaDialogLayout.setHorizontalGroup(
            nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevaCategoriaDialogLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(nuevaCategoriaDialogLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(75, 75, 75)
                        .addComponent(btnRegistrarCategoria)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(btnCancelar)
                        .addGap(14, 14, 14))
                    .addGroup(nuevaCategoriaDialogLayout.createSequentialGroup()
                        .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 292, Short.MAX_VALUE)
                            .addComponent(txtNombreCategoria))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        nuevaCategoriaDialogLayout.setVerticalGroup(
            nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(nuevaCategoriaDialogLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btnRegistrarCategoria)
                    .addComponent(btnCancelar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(nuevaCategoriaDialogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        popupEditarCat.setText("Editar");
        jPopupMenu1.add(popupEditarCat);

        popupEliminarCat.setText("Eliminar");
        jPopupMenu1.add(popupEliminarCat);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnNuevaCategoria.setText("Nueva Categoria");
        btnNuevaCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaCategoriaMouseClicked(evt);
            }
        });

        jLabel1.setText("Gestión de Categorías");

        jLabel2.setText("Categorías");

        tblCategorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Nombre", "Descripción"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class
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
        jScrollPane1.setViewportView(tblCategorias);
        if (tblCategorias.getColumnModel().getColumnCount() > 0) {
            tblCategorias.getColumnModel().getColumn(0).setMinWidth(30);
            tblCategorias.getColumnModel().getColumn(0).setPreferredWidth(40);
            tblCategorias.getColumnModel().getColumn(0).setMaxWidth(50);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(125, 125, 125)
                        .addComponent(btnNuevaCategoria))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(btnNuevaCategoria, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNuevaCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaCategoriaMouseClicked
        limpiarDatosRegistro(true);
    }//GEN-LAST:event_btnNuevaCategoriaMouseClicked

    private void btnRegistrarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegistrarCategoriaMouseClicked
//        boolean exito = controller.crear(txtNombreCategoria.getText(), txtDescripcionCategoria.getText());
//        if (exito) {
//            actualizarTabla();
//            limpiarDatosRegistro(false);
//        } else {
//            JOptionPane.showMessageDialog(
//                    this,
//                    "No se pudo registrar la categoría. Verifica los datos o intenta nuevamente.",
//                    "Error",
//                    JOptionPane.ERROR_MESSAGE
//            );
//        }
    }//GEN-LAST:event_btnRegistrarCategoriaMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnNuevaCategoria;
    private javax.swing.JButton btnRegistrarCategoria;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JDialog nuevaCategoriaDialog;
    private javax.swing.JMenuItem popupEditarCat;
    private javax.swing.JMenuItem popupEliminarCat;
    private javax.swing.JTable tblCategorias;
    private javax.swing.JTextArea txtDescripcionCategoria;
    private javax.swing.JTextField txtNombreCategoria;
    // End of variables declaration//GEN-END:variables
}
