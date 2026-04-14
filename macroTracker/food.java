package macrotracker;
public class food{
    protected int calories;
    protected int protein;
    protected int fat;
    protected  int carb;

    public food(int calories, int protein, int fat,int carb){
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carb = carb;
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
   
}