package filosuvm;


import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import org.apache.commons.codec.binary.Base64;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luisn
 */
public class Encode {
    private String secretKey="";
    
    
    public Encode(){
        this.secretKey = "VTo$7WugRx%W";
    }
    
    public String encode(String password){
        String passwordEncrypted = "";
        try{
            //Cifrado en md5 para las contrasenias
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte []keyPassword = md5.digest(this.secretKey.getBytes("utf-8"));
            byte []bytesKey = Arrays.copyOf(keyPassword, 24);
            SecretKey key = new SecretKeySpec(bytesKey,"DESede");
            Cipher encoded = Cipher.getInstance("DESede");
            encoded.init(Cipher.ENCRYPT_MODE,key);
            
            byte []plainTextBytes = password.getBytes("utf-8");
            byte []buf = encoded.doFinal(plainTextBytes);
            byte []bytesB64 = Base64.encodeBase64(buf);
            
            passwordEncrypted = new String(bytesB64);
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Algio salio mal");
        }
        return passwordEncrypted;
    }
    
    public String decode(String passwordEncrypted){
        String decryptPassword = "";
        try{
            byte []message = Base64.decodeBase64(passwordEncrypted.getBytes("utf-8"));
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte []digestOfPassword = md5.digest(secretKey.getBytes("utf-8"));
            byte []keyBytes = Arrays.copyOf(digestOfPassword,24);
            SecretKey key = new SecretKeySpec(keyBytes,"DESede");
            Cipher decoded = Cipher.getInstance("DESede");
            decoded.init(Cipher.DECRYPT_MODE, key);
            
            byte []plainTextBytes = decoded.doFinal(message);
            
            decryptPassword = new String(plainTextBytes);
        }catch(Exception e){
        
        }
        return decryptPassword;
    }
    
    
    
}
