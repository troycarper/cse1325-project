package macrotracker;
import java.util.ArrayList;

public class Meal{
    ArrayList<Food> foods;

    protected int totalCals;
    protected int totalProtein;
    protected int totalFat;
    protected int totalCarbs;

    public Meal(int totalCals, int totalCarbs, int totalFat, int totalProtein){
        this.totalCals = totalCals;
        this.totalCarbs = totalCarbs;
        this.totalFat = totalFat;
        this.totalProtein = totalProtein;
    }

    public void addFood(Food food){
        foods.add(food);

        totalCals += food.getCalories();
        totalProtein += food.getProtein();
        totalFat += food.getFat();
        totalCarbs += food.getCarb();
    }

        
}