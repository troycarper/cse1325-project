package exercisetracker;

enum TypeOfExercise{
    //squat,hinge,row,press;
    chest,back,leg,shoulders,arms
}

public class Exercise{
    protected String exerciseName;
    protected int reps;
    protected int sets;
    //rate a procived exertion(1-10 scale) 
    protected int rpe;

    public TypeOfExercise exerciseType;

    public Exercise(int reps,int sets,int rpe,TypeOfExercise exerciseType) {
        this.reps= reps;
        this.sets = sets;
        this.rpe = rpe;
        this.exerciseType = exerciseType;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public int getReps() {
        return reps;
    }

    public int getSets() {
        return sets;
    }

    public int getRpe() {
        return rpe;
    }

    public TypeOfExercise getExerciseType() {
        return exerciseType;
    }
    
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder(exerciseName);
        sb.append(reps);
        sb.append(sets);
        sb.append(rpe);
        sb.append(exerciseType);
        return sb.toString();
    }

    



}