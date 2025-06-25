package com.our.inventario;

import com.our.inventario.controller.LoginController;
import com.our.inventario.model.repository.UsuarioRepository;
import com.our.inventario.service.UsuarioService;
import com.our.inventario.util.DbConnection;
import com.our.inventario.view.CategoriaForm;

public class Inventario {

    public static void main(String[] args){
        var conn = DbConnection.getInstance();
        var repo = new UsuarioRepository(conn);
        var service = new UsuarioService(repo);
        var controller = new LoginController(service);
        //conn.close();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            controller.mostrarVista();
        });
    }

    /*
    public static void main(String[] args) throws SQLException {
        var conn = DbConnection.get();
        var repo = new CategoriaRepository(conn);
        var service = new CategoriaService(repo);
        var controller = new CategoriaController(service);
        //conn.close();
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CategoriaForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> {
            new CategoriaForm(controller).setVisible(true);
        });

    }*/
}
