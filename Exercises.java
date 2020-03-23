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
public class Exercises {
    
    private String name;
    private String bodyType;
    private String exerciseType;
    private double duration;
    private int repetition;
    private int sets;
    
    public Exercises() {
        this.name = "";
        this.bodyType = "";
        this.exerciseType = "";
        this.duration = 0.0;
        this.repetition = 0;
        this.sets = 0;
    }
    
    public Exercises(String name, String bodyType, String exerciseType, double duration, int repetition, int sets) {
        this.name = name;
        this.bodyType = bodyType;
        this.exerciseType = exerciseType;
        this.duration = duration;
        this.repetition = repetition;
        this.sets = sets;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getExerciseType() {
        return exerciseType;
    }

    public void setExerciseType(String exerciseType) {
        this.exerciseType = exerciseType;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public int getRepetition() {
        return repetition;
    }

    public void setRepetition(int repetition) {
        this.repetition = repetition;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }
 
    
}
