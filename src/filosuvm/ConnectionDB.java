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
            int response= pst.executeUpdate();
            if(response > 0){
               JOptionPane.showMessageDialog(null, "Pelicula guardada correctamente");
            }
          }catch(Exception e){
              System.out.println(e);
          }
         
    }
    
     public void setDulceria(String nombre,int cantidad,int precio){
        try{
            String sql_query = "INSERT INTO Dulceria (NombreProducto,Precio,Cantidad) VALUES (?,?,?)" ;
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setString(1,nombre);
            pst.setInt(2,precio);
            pst.setInt(2,cantidad);
            int response= pst.executeUpdate();
            if(response > 0){
               JOptionPane.showMessageDialog(null, "Se ha registrado el dulce con exito");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void updateSeats(int asientos,int id){
        String sql_query = "UPDATE Sala SET TotalAsientos = ? WHERE idSala = ? ";
         try{
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setInt(1,asientos);
            pst.setInt(2,id);
            int response = pst.executeUpdate();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ArrayList<String> getSchedule(int idPelicula){
           ArrayList<String> schedules = new ArrayList<>();
          try{
            String sql_query = "Select Horario FROM Sala WHERE idPelicula= ?" ;
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setString(1,"1");
            ResultSet response = pst.executeQuery();
             while(response.next()){
                  schedules.add(response.getString("Horario"));
             }
          }catch(Exception e){
              e.printStackTrace();
          }
         return schedules;
    }
    
     public void setTicket(String descripcion,int totalBoletos,String fechaCompra,int precio){
        try{
            String sql_query = "INSERT INTO TicketTaquilla (descripcion,numBoletos,precio,fecha) VALUES (?,?,?,?)" ;
            PreparedStatement pst = this.conn.prepareStatement(sql_query);
            pst.setString(1,descripcion);
            pst.setInt(2,totalBoletos);
            pst.setString(3,fechaCompra);
            pst.setInt(4, precio);
            int response= pst.executeUpdate();
            if(response > 0){
               JOptionPane.showMessageDialog(null, "Su compra ha sido realizada exitosamente");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
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
    public ResultSet buscar(String consulta){
        ResultSet tabla=null;
        try{
            PreparedStatement ps= conn.prepareStatement(consulta);
            tabla=ps.executeQuery();
            //ps.close();
        }
        catch(Exception e){
            
        }
     return tabla;   
    }
    public int editar(String consulta){
       int fila=0;
        try{
         PreparedStatement ps= conn.prepareStatement(consulta);
         fila=ps.executeUpdate();
         ps.close();
        }
        catch(Exception e){
            
        }
     return fila;   
    }
 
}
