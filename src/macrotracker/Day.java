package macrotracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Day{
    public ArrayList<Meal> meals = new ArrayList<>();
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

    public Day(String filename) {
    try {
        Scanner scanner = new Scanner(new File(filename));

        this.date = scanner.nextLine();
        this.remainingCal = Integer.parseInt(scanner.nextLine());
        this.remainingCarb = Integer.parseInt(scanner.nextLine());
        this.remainingFat = Integer.parseInt(scanner.nextLine());
        this.remainingProtein = Integer.parseInt(scanner.nextLine());

        int numMeals = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numMeals; i++) {
            Meal meal = new Meal(scanner); 
            meals.add(meal);
        }

        scanner.close();

    } catch (FileNotFoundException e) {
        System.out.println("File not found: " + e.getMessage());
    }
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
        System.out.println("What meal is this\n1.Breakfest\n2.Lunch\n3.Dinner\n3.snack");
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

public void saveToFile(String filename) {
    try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
        writer.println(date);
        writer.println(remainingCal);
        writer.println(remainingCarb);
        writer.println(remainingFat);
        writer.println(remainingProtein);

        writer.println(meals.size());

        for (Meal meal : meals) {
            writer.print(meal.toFileString());
        }

    } catch (IOException e) {
        System.out.println("Error saving file: " + e.getMessage());
    }
}
    @Override 
    public String toString(){
        StringBuilder sb = new StringBuilder(date+"\n");
       for (Meal meal : meals) {
           sb.append(meal.toString());
       }
        return sb.toString();
    }
    }

    
