/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package method;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lenovo V14
 */
public class penggunaControl {
    Connection con = null;
    Statement st = null;
    ResultSet rs = null;
    String sql = null;
    
    public penggunaControl(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbpbotubes", "root", "");
            st = con.createStatement();
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null,"Koneksi Database Gagal, Terjadi Kesalahan Pada : \n" +e);

        }
    }

    public List cariLogin(String username, String password){
        List logLogin = new ArrayList();
        int result;
        sql = "select Username, Password, Hak Akses from pengguna where username '" +username+ "'and password '"+password+"'";
        try {
            rs = st.executeQuery(sql);
            while (rs.next()){
                dataPengguna ep = new dataPengguna();
                ep.setusername(rs.getString("Username"));
                ep.setpassword(rs.getString("Password"));
                ep.sethakakses(rs.getString("Hak Akses"));
                logLogin.add(ep);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Terjadi Kesalahan Login , Pada :\n" +e);
        }
        return logLogin;
    }
}
     
