package macrotracker;
import java.util.ArrayList;

public class Meal{
    ArrayList<Food> foods;
    protected String name;
    protected int totalCals;
    protected int totalProtein;
    protected int totalFat;
    protected int totalCarbs;

    public Meal(String name,int totalCals, int totalCarbs, int totalFat, int totalProtein){
        this.name = name;
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
        StringBuilder sb = new StringBuilder(name);
       for (Food food : foods) {
           sb.append(food.toString());
       }
        return sb.toString();
    }

        
}