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
public class Movie {
    private int id;
    private String name;
    private String image;
    private int  length;
    private String schedule;
    private String description;
    private String rating;
    
    public Movie(int id,String name, String image,int length,String schedule,String description, String rating){
        this.id = id;
        this.name = name;
        this.image = image;
        this.length = length;
        this.schedule = schedule;
        this.description = description;
        this.rating = rating;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public int getLenght(){
        return this.length;
    }
    
    public String getSchedule(){
        return this.schedule;
    }
    
    public String getDescription(){
        return this.description;
    }
    
    public String getRating(){
        return this.rating;
    }
    public int getId(){
        return this.id;
    }
}
