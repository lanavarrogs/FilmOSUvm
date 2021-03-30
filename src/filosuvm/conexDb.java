/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author 52553
 */
public class conexDb {
    
   Connection con;
  
   
   public ResultSet Buscar(String Consulta)
       {
           ResultSet tabla=null;
          try{
              PreparedStatement ps =con.prepareStatement(Consulta);
              tabla=ps.executeQuery();
          }
          catch(SQLException sqlerr){
              
               System.out.println("la consulta esta mal");
          }
          return tabla;
       }
   public int Editar(String Consulta)
       {
           int fila=0;
          try{
             Statement s =con.createStatement();
              fila=s.executeUpdate(Consulta);
              s.close();
          }
          catch(SQLException sqlerr){
              
               System.out.println("la consulta esta mal");
          }
          return fila;
       }
   public void ejecutarConsulta(Connection con) throws SQLException {
    String SQL = "SELECT * FROM Person WHERE Name = ?";
    PreparedStatement pstmt = con.prepareStatement(SQL);
    pstmt.setString(1, "Nombre_buscado");
    ResultSet rs = pstmt.executeQuery();
   }
   
    
    
}
