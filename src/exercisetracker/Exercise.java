package exercisetracker;

public class Exercise {

    private String name;
    private int reps;
    private int sets;
    private int rpe;
    private TypeOfExercise type;

    public Exercise(String name, int reps, int sets, int rpe, TypeOfExercise type) {
        this.name = name;
        this.reps = reps;
        this.sets = sets;
        this.rpe = rpe;
        this.type = type;
    }

    public String getName() { return name; }
    public int getReps() { return reps; }
    public int getSets() { return sets; }
    public int getRpe() { return rpe; }
    public TypeOfExercise getType() { return type; }

    public void setName(String name) { this.name = name; }
    public void setReps(int reps) { this.reps = reps; }
    public void setSets(int sets) { this.sets = sets; }
    public void setRpe(int rpe) { this.rpe = rpe; }
    public void setType(TypeOfExercise type) { this.type = type; }

    @Override
    public String toString() {
        return name + " | " + sets + "x" + reps + " | RPE " + rpe + " | " + type;
    }
}
