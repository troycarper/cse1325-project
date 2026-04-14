package exercisetracker;
//
enum TypeOfExercise{
    //squat,hinge,row,press;
    //chest,back,leg,shoulders,arms
}

public class Exercise{
    protected String exerciseName;
    protected int reps;
    protected int sets;
    //rate a procived exertion(1-10 scale) 
    protected int rpe;

    protected TypeOfExercise exerciseType;

    public Exercise(int reps,int sets,int rpe,TypeOfExercise exerciseType) {
        this.reps= reps;
        this.sets = sets;
        this.rpe = rpe;
        this.exerciseType = exerciseType;
    }

    



}