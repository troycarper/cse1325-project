package exercisetracker;

import java.util.ArrayList;

public class Workout {

    private String date;
    private ArrayList<Exercise> exercises = new ArrayList<>();

    public Workout(String date) {
        this.date = date;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Exercise> getExercises() {
        return exercises;
    }

    public void addExercise(Exercise e) {
        exercises.add(e);
    }

    public void editExercise(int index, String name, int reps, int sets, int rpe, TypeOfExercise type) {
        if (index >= 0 && index < exercises.size()) {
            Exercise e = exercises.get(index);
            e.setName(name);
            e.setReps(reps);
            e.setSets(sets);
            e.setRpe(rpe);
            e.setType(type);
        }
    }

    public void display() {
        System.out.println("\n===== WORKOUT: " + date + " =====");

        for (int i = 0; i < exercises.size(); i++) {
            System.out.println(i + ". " + exercises.get(i));
        }
    }
}
