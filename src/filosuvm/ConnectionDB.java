/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author luisn
 */
public class ConnectionDB {
    String database = "jdbc:sqlserver://filosuvm.database.windows.net:1433;database=filmosuvm;user=uvmroot@filosuvm;password=oHi$ms%6l&MT;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";
    Connection conn;
    
    public ConnectionDB(){
        try{
            conn = DriverManager.getConnection(database);
        }catch(Exception e){
            System.out.println("Se cayo el sistema");
        }
    }
    
    
    //Get the user for the login
    public User getUser(String username, String password){
        User user = null;
        String sql_query = "Select * from usuarios where ididentificacion = ?";
        try{
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setString(1,username);
            ResultSet response = pst.executeQuery();
            if(response.next()){
                String id = response.getString("IdIdentificacion");
                String confirmPassword = response.getString("contrasena");
                String type = response.getString("Tipo");
                String name = response.getString("nombre");
                String apellido = response.getString("apellido");
                String age = response.getString("edad");
                String education = response.getString("FormacionAcademica");
                String identificacion = response.getString("Direccion");
                String phone = response.getString("Telefono");
                user = new User(name,confirmPassword,type);
            }
        }catch(Exception e){
            System.out.println("Error" + e);
        }
        
        return user;
    }
    
    public ArrayList<Movie> getMovies(){
        String id;
        String name;
        String premiere;
        String schedule;
        String length;
        String rating;
        String cinemanumber;
        ArrayList<Movie> listMovies = new ArrayList<>(); 
        
        String sql_query = "SELECT * FROM  Pelicula";
        try{
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            ResultSet response = pst.executeQuery();
            
            while(response.next()){
                id = response.getString("IdPelicula");
                name = response.getString("NombrePelicula");
                premiere = response.getString("FechaEstreno");
                schedule = response.getString("Horario");
                rating = response.getString("Clasificacion");
                length = response.getString("Duracion");
                cinemanumber = response.getString("NumeroSala");
                
                listMovies.add(new Movie(name,"","",schedule,rating));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return listMovies;
    }
    
}
