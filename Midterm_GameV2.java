import java.util.Scanner;

public class Midterm_GameV2 {
    public static void main(String[] args) {
        //setting up the scanner and boolean needed for the game to be started
        Scanner sc = new Scanner(System.in);
        boolean startGame = false;
        
        //Arrays for the monsters and the players information
        String[] monsterNumbers = {"first", "second", "third", "final"};
        String[] monsterNames = {
        "Slime",
        "Goblin Warrior",
        "Skeleton Knight",
        "Dragon"
        };

        int[] monsterHealth = {30, 50, 60, 80};
        int[] monsterDamage = {10, 12, 15, 18};

        int playerHealth = 100;
        int playerDamage = 20;
        int potions = 3;
        
        introduction();

        System.out.println("Would you like to play? (yes/no)");
        String response = sc.nextLine();
        //Googled IgnoreCase, because having to be exact annoyed me.
        if (response.equalsIgnoreCase("yes")) {
            System.out.println("Great! Let's get started.");
            startGame = true;
        } 
        else {
            System.out.println("Maybe next time. Goodbye!");
        }
        
        for (int i = 0; i < monsterNames.length; i++) {
                if (startGame) {
                    System.out.println("You are now facing the " + monsterNumbers[i] + " monster! It is a " + monsterNames[i] + ".");
                }
            
            while (startGame && monsterHealth[i] > 0) {
                System.out.println("The " + monsterNames[i] + " has " + monsterHealth[i] + " health points.");
                //Boolean so if you try to heal when full health or out of potions, you don't get punished
                boolean playerActed = false;
            
                System.out.println("Your health: " + playerHealth);
                System.out.println("Potions remaining: " + potions);
                displayMenu();
                int action = sc.nextInt();

                if (action == 1) {
                    System.out.println("You attack the monster and deal " + playerDamage + " damage!");
                    monsterHealth[i] -= playerDamage;
                    if (monsterHealth[i] < 0) {
                        monsterHealth[i] = 0;
                    }
                    System.out.println("The monster now has " + monsterHealth[i] + " health points.");
                    playerActed = true;
                }

                else if (action == 2) {
                    if (potions > 0) {
                        if (playerHealth < 100) {
                            playerHealth += 25;

                            if (playerHealth >= 100) {
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
            
                else if (action == 3) {
                    System.out.println("You run away from the monster and lose the game.");
                    startGame = false;
                }
                
                if (monsterHealth[i] <= 0) {
                    System.out.println("You have defeated the " + monsterNames[i] + "!");

                    //Gives the player a reward for beating the monster.
                    playerHealth += 30;

                    if (playerHealth >= 100) {
                        playerHealth = 100;
                    }

                    potions++;

                    System.out.println("You earned 30 health and 1 healing potion!");
                    System.out.println("Your health is now " + playerHealth + ".");
                    System.out.println("You now have " + potions + " potions.");
                }
            
                else if (playerActed) {
                    System.out.println("The " + monsterNames[i] + " attacks you and deals " + monsterDamage[i] + " damage!");
                    playerHealth -= monsterDamage[i];
                
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
            
            if (!startGame) {
                break;
            }
            if (startGame) {
                System.out.println("Congratulations! You defeated all the monsters!");
                System.out.println("You are the champion of the Monster Battle Arena!");
            }
        }
    }

    //methods for introduction and the menu with player options
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
