/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
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
        int id;
        String name;
        String premiere;;
        int length;
        String rating;
        String cinemanumber;
        String src = "";
        String description;
        byte []image;
        ArrayList<Movie> listMovies = new ArrayList<>(); 
        
        String sql_query = "SELECT * FROM  Pelicula ORDER BY idPelicula";
        try{
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            ResultSet response = pst.executeQuery();
            
            while(response.next()){
                id = Integer.parseInt(response.getString("IdPelicula"));
                name = response.getString("NombrePelicula");
                premiere = response.getString("FechaEstreno");
                rating = response.getString("Clasificacion");
                length = Integer.parseInt(response.getString("Duracion"));
                cinemanumber = response.getString("idSala");
                image = response.getBytes("imagen");
                description = response.getString("descripcion");
                if(image !=null){
                    src = "C:\\Users\\luisn\\Documents\\NetBeansProjects\\FilmOSUvm\\src\\peliculas\\img"+id+".jpg";
                    FileOutputStream fis = new FileOutputStream(src);
                    fis.write(image);
                    fis.close();
                }
                listMovies.add(new Movie(id,name,src,length,premiere,description,rating));

            }
        }catch(Exception e){
            System.out.println(e);
        }
        
        return listMovies;
    }
    
    public void setMovie(ByteArrayInputStream image,Movie movie){
          try{
              
            String sql_query = "INSERT INTO Pelicula (idPelicula, NombrePelicula,FechaEstreno,Clasificacion,Duracion,idSala,descripcion,imagen)VALUES (?,?,?,?,?,?,?,?)" ;
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setString(1,String.valueOf(movie.getId()));
            pst.setString(2,movie.getName());
            pst.setString(3,movie.getSchedule());
            pst.setString(4,movie.getRating());
            pst.setInt(5, movie.getLenght());
            pst.setInt(6, 1);
            pst.setString(7,movie.getDescription());
            pst.setBlob(8, image);
            ResultSet response= pst.executeQuery();
            if(response.next()){
                JOptionPane.showMessageDialog(null,"Los datos se han agregado exitosamente");
            }else{
                JOptionPane.showMessageDialog(null,"Hubo un error al introducir los datos intente nuevamente");
            }
          }catch(Exception e){
              System.out.println(e);
          }
         
    }
    
    public void updateSeats(int asientos){
        String sql_query = "UPDATE Sala SET TotalAsientos = ? WHERE idSala = ? ";
    }
    
    public int getSeats(int id){
        int seats = -1;
        String sql_query = "SELECT TotalAsientos FROM Sala WHERE NumeroSala = ?" ;
        try{
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setInt(1,id);
            ResultSet response = pst.executeQuery();
            if(response.next()){
                seats = response.getInt("TotalAsientos");
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return seats;
    }
    
    public void connectionClose(){
        try{
         this.conn.close();
         }catch(Exception e){
             System.out.println("Hubo un errror mi compa" + e );
         }
    }
    
}
