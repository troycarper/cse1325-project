package macrotracker;
import java.util.ArrayList;
import java.util.Scanner;
public class Day{
    ArrayList<Meal> meals;
    protected String date;
   
    protected int remainingCal;
    protected int remainingCarb;
    protected int remainingFat;
    protected int remainingProtein;


    public Day(String date, int remainingCal, int remainingCarb, int remainingFat,int remainingProtein){
        this.date = date;
        this.remainingProtein = remainingProtein;
        this.remainingCal = remainingCal;
        this.remainingCarb = remainingCarb;
        this.remainingFat = remainingFat;   
        }
    public int getRemainingCal() {
    return remainingCal;
}

    public int getRemainingCarb() {
    return remainingCarb;
}

    public int getRemainingFat() {
        return remainingFat;
}

    public int getRemainingProtein() {
        return remainingProtein;
}
    public void addMeal(int numFoods){
        MealType mealType = MealType.Breakfast;  
        int userInput;
        Scanner scanner = new Scanner(System.in);
        System.out.println("What meal is this\n1.Breakfest\n2.Lunch\n3.Dinner\n3.snack)");
        userInput = scanner.nextInt();
        switch (userInput) {
            case 1 -> {
                mealType = MealType.Breakfast;
            }
            case 2 -> {
                mealType = MealType.Lunch;
            }
            case 3 -> {
                mealType = MealType.Dinner;
            }
            case 4 -> {
                mealType = MealType.Snack;
            }
            default -> throw new AssertionError();
        }
        
        Meal meal = new Meal(mealType);
        for (int i = 0; i < numFoods;i++){
            meal.addFood();
        }
        meals.add(meal);
        remainingCal -= meal.totalCals;
        remainingCarb -= meal.totalCarbs;
        remainingFat -= meal.totalFat;
        remainingProtein -= meal.totalProtein;
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

    
