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
    private String name;
    private String image;
    private String kind;
    private String schedule;
    private String description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Maecenas auctor dictum dignissim. Duis mollis sollicitudin odio, sed bibendum purus elementum a";
    
    public Movie(String name, String image, String kind,String schedule){
        this.name = name;
        this.image = image;
        this.kind = kind;
        this.schedule = schedule;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getImage(){
        return this.image;
    }
    
    public String getKind(){
        return this.kind;
    }
    
    public String getSchedule(){
        return this.schedule;
    }
    
    public String getDescription(){
        return this.description;
    }
}
