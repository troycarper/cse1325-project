package macrotracker;
import java.util.ArrayList;
import java.util.Scanner;
public class Meal{
    ArrayList<Food> foods = new ArrayList<>();
    MealType mealType;

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

    public void addFood(){
        Food food = new Food();
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter name: ");
        food.setName(scanner.nextLine());
        
        System.out.print("Enter calories: ");
        food.setCalories(scanner.nextInt());

        System.out.print("Enter protein: ");
        food.setProtein(scanner.nextInt());

        System.out.print("Enter fat: ");
        food.setFat(scanner.nextInt());

        System.out.print("Enter carbs: ");
        food.setCarb(scanner.nextInt());

        scanner.nextLine(); 

        

        
        foods.add(food);

        totalCals += food.getCalories();
        totalProtein += food.getProtein();
        totalFat += food.getFat();
        totalCarbs += food.getCarb();
    }
    
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(mealType.toString());
        sb.append("\n");
       for (Food food : foods) {
           sb.append(food.toString());
           sb.append("\n");
       }
        return sb.toString();
    }

        
}