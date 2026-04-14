package macrotracker;
public class Food{
    protected String name;
    protected int calories;
    protected int protein;
    protected int fat;
    protected int carb;

    public Food(int calories, int protein, int fat,int carb,String name){
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
    }

public String getName() {
    return name;
}

public int getCalories() {
    return calories;
}

public int getProtein() {
    return protein;
}

public int getFat() {
    return fat;
}

public int getCarb() {
    return carb;
}

@Override
public String toString() {
    return name + " {" +
            "Calories=" + calories +
            ", Protein=" + protein + "g" +
            ", Fat=" + fat + "g" +
            ", Carbs=" + carb + "g" +
            '}';
}

}