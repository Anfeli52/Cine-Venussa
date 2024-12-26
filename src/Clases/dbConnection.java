/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;
import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author anfel
 */
public class dbConnection {
    private final static String url = "jdbc:mysql://localhost:3306/cinevenussa";
    private final static String user = "root";
    private final static String pass = "";
    
    public static Connection dbConnect(){
        
        Connection con = null;
        try {
            con = DriverManager.getConnection(url, user, pass);
            JOptionPane.showMessageDialog(null, "Conexión Exitosa", "Cine Venussa", 1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "¡Error en la Conexión!", "ERROR", 0);
        }
        return con;
    }
    
    public boolean LogIn(String email, String password){
        Connection con1 = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        if(email.equals("") || password.equals("")){
            JOptionPane.showMessageDialog(null, "Uno o más campos están vacios");
        } else{
            try {
                con1 = dbConnect();
                pstm = con1.prepareStatement("SELECT correoCorporativo, password FROM usuarios WHERE correoCorporativo = ? AND password = ?");
                pstm.setString(1, email);
                pstm.setString(2, password);
                rs = pstm.executeQuery();
                if(rs.next()){
                    JOptionPane.showMessageDialog(null, "Inicio de Sesión Éxitoso");
                    return true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error en la conexión, por favor intente más tarde");
            }
        }
        return false;
    }
}
