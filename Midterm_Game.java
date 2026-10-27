import java.util.Scanner;

public class Midterm_Game {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean startGame = false;
        
        String[] monsterNames = {
        "Slime",
        "Goblin Warrior",
        "Skeleton Knight",
        "Dragon"
        };

        int[] monsterHealth = {30, 50, 70, 100};
        int[] monsterDamage = {10, 15, 18, 20};

        int playerHealth = 100;
        int playerDamage = 20;
        int potions = 3;
        
        introduction();

        System.out.println("Would you like to play? (yes/no)");
        String response = sc.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Great! Let's get started.");
            startGame = true;
        } 
        else {
            System.out.println("Maybe next time. Goodbye!");
        }

        System.out.println("You are now facing the first monster! It is a " + monsterNames[0] + ".");

        while (startGame){
            System.out.println("The " + monsterNames[0] + " has " + monsterHealth[0] + " health points.");
            boolean playerActed = false;
            
            System.out.println("Your health: " + playerHealth);
            System.out.println("Potions remaining: " + potions);
            displayMenu();
            int action = sc.nextInt();

            if (action == 1) {
                System.out.println("You attack the monster and deal " + playerDamage + " damage!");
                monsterHealth[0] -= playerDamage;
                if (monsterHealth[0] < 0) {
                    monsterHealth[0] = 0;
                }
                System.out.println("The monster now has " + monsterHealth[0] + " health points.");
                playerActed = true;
            }

            else if (action == 2) {
                if (potions > 0) {
                    if (playerHealth < 100) {
                        playerHealth += 20;

                    if (playerHealth > 100) {
                        playerHealth = 100;
                    }

                    potions--;
                    System.out.println("You use a healing potion!");
                    playerActed = true;
                    }
                    
                    else {
                        System.out.println("Your health is already full!");
                    }
                }
                
                else {
                    System.out.println("You have no healing potions left!");
                }
            }
            
            if (monsterHealth[0] <= 0) {
                System.out.println("You have defeated the " + monsterNames[0] + "!");
                startGame = false;
            }
            
            else if (action == 3) {
                System.out.println("You run away from the monster and lose the game.");
                startGame = false;
            }
            
            else if (playerActed) {
                System.out.println("The " + monsterNames[0] + " attacks you and deals " + monsterDamage[0] + " damage!");
                playerHealth -= monsterDamage[0];
                
                if (playerHealth < 0) {
                    playerHealth = 0;
                }

                System.out.println("You now have " + playerHealth + " health points.");

                if (playerHealth <= 0) {
                System.out.println("You have been defeated! Game over.");
                    startGame = false;
                }
            }
            
            else if (action != 1 && action != 2 && action != 3) {
                System.out.println("Invalid action. Please try again.");
            }
        }
    }


    public static void introduction() {
        System.out.println("Welcome to the Monster Battle Arena!");
        System.out.println("In this game you will fight against a series of monsters and try to defeat them all.");
        System.out.println("There will be three monsters to fight and one final boss.");
    }
    
    public static void displayMenu() {
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Heal");
        System.out.println("3. Run");
        System.out.println("Please enter the number of your choice:");
    }
}
