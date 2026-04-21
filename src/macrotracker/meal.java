package macrotracker;
import java.util.ArrayList;

public class Meal{
    ArrayList<Food> foods;
    protected MealType mealType;
    protected int totalCals;
    protected int totalProtein;
    protected int totalFat;
    protected int totalCarbs;

    public Meal(MealType mealType){
        this.mealType = mealType;
    }

    public Meal(MealType mealType,int totalCals, int totalCarbs, int totalFat, int totalProtein){
        this.mealType = mealType;
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
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(mealType.toString());
       for (Food food : foods) {
           sb.append(food.toString());
       }
        return sb.toString();
    }

        
}