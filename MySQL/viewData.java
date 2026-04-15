package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class viewData {
    public static void main(String args[]){
        try {
            String url ="jdbc:mysql://localhost/mhs";
            String user="root";
            String pass="";
            
            // driver terbaru
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            Connection con = DriverManager.getConnection(url,user,pass);
            Statement stm = con.createStatement();
            
            String sql = "SELECT * FROM datamhs";
            ResultSet rs = stm.executeQuery(sql);
            
            while(rs.next()){
                System.out.println("NIM: " + rs.getInt("nim"));
                System.out.println("Nama: " + rs.getString("nama"));
                System.out.println("Semester: " + rs.getInt("semester"));
                System.out.println("Kelas: " + rs.getString("kelas"));
                System.out.println("----------------------");
            }
            
            rs.close();
            stm.close();
            con.close();
            
        } catch (Exception e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
        }
    }
}