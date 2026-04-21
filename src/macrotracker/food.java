package macrotracker;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

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
    public Food (){

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

public void setName(String name) {
    this.name = name;
}

public void setCalories(int calories) {
    this.calories = calories;
}

public void setProtein(int protein) {
    this.protein = protein;
}

public void setFat(int fat) {
    this.fat = fat;
}

public void setCarb(int carb) {
    this.carb = carb;
}

public void saveFood() {
    try {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("food.txt", true)) // true = append
        ) {
            writer.write(this.toString());
            writer.newLine(); // move to next line
        }
    } catch (IOException e) {
        System.out.println("Error saving food to file.");
    }
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