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

    public Meal(Scanner scanner) {
    foods = new ArrayList<>();

    // Read meal type
    this.mealType = MealType.valueOf(scanner.nextLine());

    // Read totals
    this.totalCals = Integer.parseInt(scanner.nextLine());
    this.totalCarbs = Integer.parseInt(scanner.nextLine());
    this.totalFat = Integer.parseInt(scanner.nextLine());
    this.totalProtein = Integer.parseInt(scanner.nextLine());

    // Read number of foods
    int numFoods = Integer.parseInt(scanner.nextLine());

    // Read each food
    for (int i = 0; i < numFoods; i++) {
        Food food = new Food(scanner); // requires Food scanner constructor
        foods.add(food);
    }
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

    public String toFileString() {
    StringBuilder sb = new StringBuilder();

    sb.append(mealType).append("\n");     // Breakfast, Lunch, etc.
    sb.append(totalCals).append("\n");
    sb.append(totalCarbs).append("\n");
    sb.append(totalFat).append("\n");
    sb.append(totalProtein).append("\n");

    sb.append(foods.size()).append("\n");

    for (Food f : foods) {
        sb.append(f.toFileString());
    }

    return sb.toString();
}

        
}