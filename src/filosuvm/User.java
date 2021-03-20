/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package filosuvm;

/**
 *
 * @author luisn
 */
public class User {
    private String name;
    private String password;
    
    public User(String name,String password){
        this.name = name;
        this.password = password;
    }
    
    
    public String getName(){
        return name;
    }
    
    public String getPassword(){
        return password;
    }
    
}
