
//need to make an enum for type of exercise (squat/press/hinge/row)
// could also be a more powerlifting type tracker for squat bench deadlift i can give more examples about what makes this better during the demo

class Exercise{
    String exerciseName;
    int reps;
    int sets;
    //rate a procived exertion(1-10 scale) 
    int rpe;

    //typeOfexercise exerciseType

    public Exercise(int reps,int sets,int rpe) {
        this.reps= reps;
        this.sets = sets;
        this.rpe = rpe;
    }

    



}