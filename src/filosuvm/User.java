/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;
import java.security.MessageDigest;
import javax.crypto.Cipher;

/**
 *
 * @author luisn
 */
public class User {
    private int uid;
    private String username;
    private String password;
    
    public User(String username,String password){
        this.username = username;
        this.password = password;
    }
    
    public String getName(){
        return username;
    }
    
    public String getPassword(){
        return password;
    }
    
    
    
}
