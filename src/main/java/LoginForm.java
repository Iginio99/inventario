import javax.swing.*;

public class LoginForm extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnIngresar;
    private JLabel lblMensaje;

    public LoginForm() {
        setTitle("Login - Sistema de Inventario");
        setSize(350, 250);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        // Componentes
        JLabel lblTitulo = new JLabel("INICIAR SESIÓN");
        lblTitulo.setBounds(110, 10, 150, 30);
        add(lblTitulo);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(30, 50, 80, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(120, 50, 180, 25);
        add(txtUsuario);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setBounds(30, 90, 80, 25);
        add(lblContrasena);

        txtContrasena = new JPasswordField();
        txtContrasena.setBounds(120, 90, 180, 25);
        add(txtContrasena);

        btnIngresar = new JButton("Ingresar");
        btnIngresar.setBounds(120, 130, 100, 30);
        add(btnIngresar);

        lblMensaje = new JLabel("");
        lblMensaje.setBounds(30, 170, 300, 20);
        add(lblMensaje);
    }

    public static void main(String[] args) {
    }
}
