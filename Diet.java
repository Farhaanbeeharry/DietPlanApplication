/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dietplangui;

/**
 *
 * @author shankara19
 */
public class Diet {
    
    private String bodyType;
    private String meal;
    private String toEat;
    private String toDrink;
    private String toAvoid;
    private int duration;
    
    public Diet() {
        this.bodyType = "";
        this.meal = "";
        this.toEat = "";
        this.toDrink = "";
        this.toAvoid = "";
        this.duration = 0;
    }
    
    public Diet(String bodyType, String meal, String toEat, String toDrink, String toAvoid, int duration) {
        this.bodyType = bodyType;
        this.meal = meal;
        this.toEat = toEat;
        this.toDrink = toDrink;
        this.toAvoid = toAvoid;
        this.duration = duration;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getMeal() {
        return meal;
    }

    public void setMeal(String meal) {
        this.meal = meal;
    }

    public String getToEat() {
        return toEat;
    }

    public void setToEat(String toEat) {
        this.toEat = toEat;
    }

    public String getToDrink() {
        return toDrink;
    }

    public void setToDrink(String toDrink) {
        this.toDrink = toDrink;
    }

    public String getToAvoid() {
        return toAvoid;
    }

    public void setToAvoid(String toAvoid) {
        this.toAvoid = toAvoid;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
    
    
    
}
