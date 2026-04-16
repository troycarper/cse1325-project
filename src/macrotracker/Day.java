package macrotracker;
import java.util.ArrayList;
public class Day{
    ArrayList<Meal> meals;
    protected String date;
    protected int calGoal;
    protected int carbGoal;
    protected int fatGoal;
    protected int proteinGoal;
    public Day(int calGoal,int carbGoal,int fatGoal,int proteinGoal){
        //might be able to use the free constructor
    }

    public void addMeal(Meal meal){
        meals.add(meal);
        calGoal = calGoal - meal.totalCals;
        carbGoal = carbGoal - meal.totalCarbs;
        fatGoal = fatGoal - meal.totalFat;
        proteinGoal = proteinGoal - meal.totalProtein;
    }
    public void editMeal(Meal meal){
       
    }
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(date);
       for (Meal meal : meals) {
           sb.append(meal.toString());
       }
        return sb.toString();
    }
    }

    
