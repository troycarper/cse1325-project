package macrotracker;
import java.util.ArrayList;
import macrotacker.food;

public class meal extends food {
    Arraylist<food> foods  = new ArrayList<food>();

    totalCals;
    totalProtein;
    totalFat;
    totalCarbs;
    public meal(){
        super(calories, protein, fat, carb);

    }

    public addFood(food Food){
        foods.add(Food);
    }

}