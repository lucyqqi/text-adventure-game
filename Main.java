/* Author: Lucy Qi
The class: Grade 12 Computer Science
Date last modified: October 24, 2021
Description: A text based adventure program, titled "High School Story" that guides you through a typical high school day. There are various mini games and animations that enhance the overall experience. 
*/

import java.util.Scanner;

class Main {

// import scanner
	static Scanner in = new Scanner(System.in);

// variables to change the text into different colours
	static final String ANSI_RESET = "\u001B[0m";
	static final String ANSI_RED = "\u001B[31m";
	static final String ANSI_GREEN = "\u001B[32m";
	static final String ANSI_YELLOW = "\u001B[33m";
	static final String ANSI_BLUE = "\u001B[34m";
	static final String ANSI_PURPLE = "\u001B[35m";
	static final String ANSI_CYAN = "\u001B[36m";
	static final String ANSI_WHITE = "\u001B[37m";

// initialize an array and store it with the 4 statistics that will be used for this game (i.e., well being, academics, social status, and extracurriculars)

	static int wellBeing = 0;
	static int academics = 0;
	static int socialStatus = 0;
	static int extracurriculars = 0;

	static int statistics[] = { wellBeing, academics, socialStatus, extracurriculars };

// for reference: 
// wellBeing -> statistics[0]
// academics -> statistics[1]1
// social status --> statistics [2]
// extracurriculars --> statistics[3]

	public static void main(String[] args) {

		while (true) {

			// starting page, can come back to it if you die or if you complete the game successfully
			// essentially the starting menu, only place where you can end the program if you click option 2
			startingPage();

			// storyline that briefly runs the user through the game, using time delays to make the information easy-to-read
			introductionToGame();

			// difficulty levels that user can choose from
			printLine();
			purple("Select your level of difficulty for High School Story:");
			yellow("1. EASY");
			yellow("2. MEDIUM");
			yellow("3. HARD");
			printLine();
			clearScreen();
			randomizeStats();

			// displays starting statistics for the game, depending on what difficulty level the user chose
			clearScreen();
			printLine();
			purple("Great! Here are your starting stats for the game.");
			printStats();
			printLine();
			clearScreen();
			promptEnterKey();

			// presents user with a special power
			// by selecting one of the choices, it will boost one of the stats by +10 XP
			clearScreen();
			printLine();
			purple("In this game, you will be equipped with one power to help boost your stats.\nWhat will you choose?");
			yellow("1. You’re really good at being well-rested on less sleep");
			yellow("2. Your parents will let you take tutoring lessons to learn material in advance");
			yellow("3. You are the student council president");
			printLine();
			clearScreen();
			selectPower();
			clearScreen();

			// prompt 1 8AM: you wake up
			clearScreen();
			statsDisplay();
			promptOne();
			clearScreen();
			increaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 2 9AM: go to school
			clearScreen();
			statsDisplay();
			promptTwo();
			clearScreen();
			decreaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 3 10AM: Mr. Anthony's class
			clearScreen();
			statsDisplay();
			promptThree();
			clearScreen();
			changeAcademicsValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 4 11AM: you see Cullen
			clearScreen();
			statsDisplay();
			promptFour();
			clearScreen();
			increaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 5 12PM: lunch break
			clearScreen();
			statsDisplay();
			promptFive();
			clearScreen();
			increaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 6 1PM: French class
			clearScreen();
			statsDisplay();
			promptSix();
			clearScreen();
			changeAcademicsValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 7 2PM: French class break
			clearScreen();
			statsDisplay();
			promptSeven();
			clearScreen();
			increaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 8 3PM: about to depart from school
			clearScreen();
			statsDisplay();
			promptEight();
			clearScreen();
			increaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 9 4PM: you arrive home
			clearScreen();
			statsDisplay();
			promptNine();
			clearScreen();
			decreaseValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 10 5PM: you need to create a strong password
			clearScreen();
			statsDisplay();
			promptTen();
			if (isAlive() == false) {
				continue;
			}

			// password game checker
			clearScreen();
			passwordGame();
			clearScreen();

			// prompt 11 6PM: you need to eat dinner
			clearScreen();
			statsDisplay();
			// displays ascii art of your parents cooking, using time delays
			promptElevenIntro();
			clearScreen();
			promptEnterKey();
			clearScreen();
			promptElevenCooking(); // ascii cooking art
			clearScreen();
			statsDisplay();
			promptEleven(); // select your food option
			clearScreen();
			changeWellBeingValue();
			if (isAlive() == false) {
				continue;
			}

			// prompt 12 7PM: volleyball practice
			clearScreen();
			statsDisplay();
			promptTwelve();
			clearScreen();
			changeExtracurricularStats();
			if (isAlive() == false) {
				continue;
			}

			// prompt 13 8PM: you arrive home, and spend time on a hobby
			clearScreen();
			statsDisplay();
			promptThirteen();
			clearScreen();
			changeExtracurricularStats();
			if (isAlive() == false) {
				continue;
			}

			// prompt 14 9PM: mini games
			clearScreen();
			statsDisplay();
			promptFourteenPartOne(); // player plays their first game
			clearScreen();
			gameOptions();

			// after the user finished the first game
			clearScreen();
      statsDisplay();
			promptFourteenPartTwo();
			clearScreen();
			gameOptions(); // player plays another game

			// prompt 15 10PM: computer science homework
			clearScreen();
			statsDisplay();
			promptFifteen();
			clearScreen();
			changeAcademicsValue();
			clearScreen();
			if (isAlive() == false) {
				continue;
			}

			// ending page if you successfully survive the "High School Story" game
			endingPage();
			if (endingPage() == false) {
				continue;
			}

      // close scanner
      in.close(); 
		}
	}

	/*
	 * method introductionToGame() tells the user how they can successfully survive the game and what each of the stats do 
   * pre: none 
   * post: prints what the game is about, how to survive, and what the stats mean
	 */
	public static void introductionToGame() {
		printFormat(
				"In this game, the purpose is to just survive.\nYou have 4 areas you need to take care of in high school.");
		clearScreen();
		promptEnterKey();
		clearScreen();

		clearScreen();

		printFormat(
				"Your well being, social status, academics, and extracurriculars.\nYou want to keep your stats as high as possible in this game.");
		clearScreen();
		promptEnterKey();
		clearScreen();

		printFormat("If your well-being goes below 50, you will die\nbecause your physical needs are not meet.");
		clearScreen();
		promptEnterKey();
		clearScreen();

		printFormat(
				"If your social status goes below 50, you will commit suicide \nbecause you feel disrespected by society and have no friends.");
		clearScreen();
		promptEnterKey();
		clearScreen();

		printFormat(
				"If your extracurriculars are below 50, you will question your life\npurpose and die since you do not see the meaning of life. ");
		clearScreen();
		promptEnterKey();
		clearScreen();

		printFormat(
				"Finally, if your academics go below 50, you will be abandoned\nby your family as an Asian disgrace and die from hunger.");
		clearScreen();
		promptEnterKey();
		clearScreen();

		printFormat(
				"So, the goal is just to make sure you keep all your stats\n50 or above at all times, and you stay alive in school!");
		clearScreen();
	  promptEnterKey();
		clearScreen();

		printFormat(
				"Now what happens if you win? Well, if you survive,\nyou just have to suffer again... but this time university edition :)");
		clearScreen();
		promptEnterKey();
		clearScreen();
	}

	/*
	 * method promptEnterKey() will help transition to the next prompt after the user enters a key. as a note, the user can enter any key before they click enter (not restricted to only ENTER), just for the sake of convenience 
   * pre: none 
   * post: will clear screen and go to next prompt
	 */
	public static void promptEnterKey() {
		purple("Press \"ENTER\" to continue");
		in.nextLine();
		clearScreen();
	}

	/*
	 * method selectPower() allows the user to select one of the options (1,2,3) and updates the corresponding stats to reflect the new power 
   * pre: none 
   * post: updates the stats with the new power (+10 XP) one of the categories and prints a statement with elaboration of the user's choice
	 */
	public static void selectPower() {
    String input; 
		while (true) {
      input = in.nextLine();
			try {
				if (input.equals("1")) {
					statistics[0] += 10;
          clearScreen(); 
          printLine();
          System.out.println("");
					yellow("Nice choice! Since you can sleep for less,\nyour health XP increases by 10.");
          System.out.println("");
          printLine();
          clearScreen();
          promptEnterKey();
          clearScreen();
          break;
				} else if (input.equals("2")) {
					statistics[1] += 10;
          clearScreen(); 
          printLine();
          System.out.println("");
					yellow("Nice choice! Since your parents let you take lessons,\nyour academics XP increase by 10.");
					System.out.println("");
          printLine();
          clearScreen();
          promptEnterKey();
          clearScreen();
          break;
				} else if (input.equals("3")) {
					statistics[3] += 10;
          clearScreen(); 
          printLine();
          System.out.println("");
					yellow("Nice choice! Since your student council president,\nyour extracurricular XP increases by 10.");
					System.out.println("");
          printLine();
          clearScreen();
          promptEnterKey();
          clearScreen();
          break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				yellow("Please enter an option: 1, 2, or 3!");
			}
		}
	}

	/*
	 * method wait(int ms) will create a time delay in the program for the indicated
	 * number of milliseconds 
   * pre: ms >= 0, because negative time doesn't really make sense 
   * post: pauses the thread to sleep for a certain number of
	 * milliseconds
	 */
	public static void wait(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException ex) {
			Thread.currentThread().interrupt();
		}
	}

	/*
	 * method isAlive() checks if the player is still alive in the game, that is, all it's statistics are equal to or above 50, and if not, will display the "you lose" page 
   * pre: none 
   * post: returns true if player is still alive (can still continue the game), and returns false is player does not reach the 50 threshold stats requirement and will display a "you lose" page and prompt enter to try again (which will return to the home page)
	 */
	public static boolean isAlive() {
		if (statistics[1] >= 50 && statistics[0] >= 50 && statistics[3] >= 50 && statistics[2] >= 50) {
			return true;
		} else {
			// "you lose" page

      clearScreen(); 

      clearScreen(); 

			// credits to sad face ascii art: https://www.asciiart.eu/computers/smileys
			yellow("    .-\"\"\"\"\"\"-.");
			yellow("   .'          '.");
			yellow("  /   O      O   \\");
			yellow(" :                :");
			yellow(" |                |");
			yellow(" :    .------.    :");
			yellow("  \\  '        '  /");
			yellow("   '.          .'");
			yellow("     '-......-'");
			System.out.println("");
			System.out.println(
					"Oh no! Bad move right there, that just cost you your life.\nSad, I know high school is pretty rough.");
			System.out.println();
			System.out.println("Here were your ending statistics that cost you that:");
			printStats();
			System.out.println("");

      // print spaces for formatting purposes
      for(int i = 0; i < 3; i++){
        System.out.println(""); 
      }

			// gives user opportunity to play game again, will return to home screen because it will restart the while loop that wraps the whole program
			System.out.println("Press \"ENTER\" to try again!");
			in.nextLine();
      clearScreen(); 

			restartStats();
			return false;
		}
	}

	/*
	 * method clearScreen() clears the screen essentially, by printing 23 lines so text can be formatted properly approximately in the center of the console
	 * pre: none
   * post: prints 23 lines
	 */
	public static void clearScreen() {
		for (int i = 0; i < 11; i++) {
			System.out.println("");
		}
	}

	/*
	 * method printFormat(String s) prints the information in the description slightly nicer to the conosle, with borders and spacing
   * pre: String has to be not null 
   * post: prints the string entered with a nicer formatting (2 spaces
	 * around it with a line border)
	 */
	public static void printFormat(String s) {
		printLine();
		System.out.println("");
		System.out.println(ANSI_PURPLE + s + ANSI_RESET);
		System.out.println("");
		printLine();
	}

	/*
	 * method generateRandomNum(int min, int max) will generate a random number from the given minimum to maximum number entered as parameters 
   * pre: max > min
	 * post: generated a random number from the minimum to maximum number
	 */
	public static int generateRandomNum(int min, int max) {
		return (int) (Math.random() * (max - min) + 1) + min;
	}

	/*
	 * method printStats() prints all 4 of the statistics and corresponding XP respectively 
   * pre: none
   * post: prints the 4 statistics and their corresponding XP
	 */
	public static void printStats() {
		System.out.println(ANSI_CYAN + "WELL BEING: " + statistics[0] + ANSI_RESET);
		System.out.println(ANSI_YELLOW + "ACADEMICS: " + statistics[1] + ANSI_RESET);
		System.out.println(ANSI_BLUE + "SOCIAL STATUS: " + statistics[2] + ANSI_RESET);
		System.out.println(ANSI_RED + "EXTRACURRICULARS:" + statistics[3] + ANSI_RESET);
	}

	/*
	 * method statsDisplay() displays the statistics for the game as like a bar at the top for all the prompts, for convenience for the user to see how they are doing in each category during the game 
   * pre: none 
   * post: prints all 4 statistics for the game and their corresponding XP respectively
	 */
	public static void statsDisplay() {
		System.out.println(ANSI_CYAN + "WELL BEING: " + statistics[0] + ANSI_RESET + "  " + ANSI_YELLOW + "ACADEMICS: "
				+ statistics[1] + ANSI_RESET + ANSI_BLUE + "  SOCIAL STATUS: " + statistics[2] + ANSI_RESET + ANSI_RED
				+ "  EXTRACURRICULARS: " + statistics[3] + ANSI_RESET);
	}

	/*
	 * method yellow(String s) changes the text into yellow 
   * pre: String has to be not null
   * post: prints the text into the colour yellow
	 */
	public static void yellow(String s) {
		System.out.println(ANSI_YELLOW + s + ANSI_RESET);
	}

	/*
	 * method green(String s) changes the text into green 
   * pre: String has to be not null
   * post: prints the text into the colour green
	 */
	public static void green(String s) {
		System.out.println(ANSI_GREEN + s + ANSI_RESET);
	}

	/*
	 * method green(String s) changes the text into purple 
   * pre: String has to be not null
   * post: prints the text into the colour purple
	 */
	public static void purple(String s) {
		System.out.println(ANSI_PURPLE + s + ANSI_RESET);
	}

	/*
	 * method red(String s) changes the text into red 
   * pre: String has to be not null
   * post: prints the text into the colour red
	 */
	public static void red(String s) {
		System.out.println(ANSI_RED + s + ANSI_RESET);
	}

	/*
	 * method blue(String s) changes the text into blue 
   * pre: String has to be not null
   * post: prints the text into the colour blue
	 */
	public static void blue(String s) {
		System.out.println(ANSI_BLUE + s + ANSI_RESET);
	}

	/*
	 * method cyan(String s) changes the text into cyan 
   * pre: String has to be not null
   * post: prints the text into the colour cyan
	 */
	public static void cyan(String s) {
		System.out.println(ANSI_CYAN + s + ANSI_RESET);
	}

	/*
	 * method white(String s) changes the text into white 
   * pre: String has to be not null
   * post: prints the text into the colour white
	 */
	public static void white(String s) {
		System.out.println(ANSI_WHITE + s + ANSI_RESET);
	}

	/*
	 * method printLine() essentially just prints a line using - 
   * pre: String has to be not null
   * post: prints a line
	 */
	public static void printLine() {
		System.out.println("------------------------------------------------------------------");
	}

	/*
	 * method startingPage() is the starting page that the user sees when they run the program, essentially it is like the main menu 
   * pre: none 
   * post: prints the text that welcomes user to the game and asks if the want to start or end the game, and will start the game if user types "1" and ends the program if user types "2"
	 */
	public static void startingPage() {
    // intialize variable
    String input;
    
		// starting page formatting
		for (int i = 0; i < 2; i++) {
			System.out.println("");
		}
    

		printLine();
		// ascii art credit for the girl drawing on chalkboard:
		// https://ascii.co.uk/art/school
		purple("    |.==================================,|");
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "WELCOME TO HIGH SCHOOL STORY."
				+ ANSI_RESET + ANSI_PURPLE + "  ||" + ANSI_RESET);
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "WELCOME TO HIGH SCHOOL STORY."
				+ ANSI_RESET + ANSI_PURPLE + "  ||" + ANSI_RESET);
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "WELCOME TO HIGH SCHOOL STORY."
				+ ANSI_RESET + ANSI_PURPLE + "  ||");
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "WELCOME TO HI ," + ANSI_RESET
				+ ANSI_PURPLE + "                ||");
		purple("    || /`\\/      \\/`\\ /                 ||");
		purple("    || )_/|      |\\_(/\\                 ||");
		purple("    ||    \\______/  /\\/                 ||");
		purple("    ||    _(____)__/ /                  ||");
		purple("    ||    _(____)__/ /                  ||");
		purple("    ||___/ ,_ _  ___/___________________||");
		purple("    '====\\___\\_) |======================='");
		purple("          |______|");
		purple("          /______\\");
		purple("           |_||_|");
		purple("          (__)(__)");

		// asks user if they want to begin "High School Story"
		System.out.println("");
		yellow("Ready to begin the adventure? Type \"1\" to start, or \"2\" to end the program");
		yellow("1. Yes, let's start the adventure");
		yellow("2. No, let's end the adventure");
		printLine();

		// printed spaces for formatting purposes
		for (int i = 0; i < 2; i++) {
			System.out.println("");
		}

		while (true) {
			input = in.nextLine();
			try {
				// let's user start game
				if (input.equalsIgnoreCase("1")) {
					break;
					// exits the program
				} else if (input.equalsIgnoreCase("2")) {
					yellow("Alright, well come back when you are ready to play!");
					System.exit(0);
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				yellow("Please enter an option: 1 or 2!");
			}
		}
		clearScreen();

	}

	/*
	 * method promptOne() is the 8AM prompt and is when the user just wakes up. it
	 * prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 8AM prompt and 4 choices
	 */
	public static void promptOne() {
		printLine();
		System.out.println("⏰ 8:00AM: you wake up, supposed to be getting ready for school. What do you do?");
		cyan("1. Go back to sleep until 8:30");
		yellow("2. Study for 30 minutes");
		blue("3. Scroll through Instagram and keep up with the latest DMs");
		red("4. Draw something to put on your art account");
		printLine();
	}

	/*
	 * method promptTwo() is the 9AM prompt, when the user is about to enter school. it prints the prompt and the options that the user can choose. 
   * pre: none
	 * post: prints the 9AM prompt and 4 choices
	 */
	public static void promptTwo() {
		printLine();
		System.out.println("⏰ 9:00AM: You are at MGCI. You are about to enter the school");
		cyan("1. Accidentally trip while walking to do your daily health screening");
		yellow("2. Skip first period class since you are too sad");
		blue("3. Accidentally embarrass yourself to your friends");
		red("4. Piss off the student council vice president");
		printLine();
	}

	/*
	 * method promptThree() is the 10AM prompt and is when the user has to hand in their computer science assignment. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 10AM prompt and 4 choices
	 */
	public static void promptThree() {
		printLine();
		System.out.println("⏰ 10:00AM: You are in CS class and realize Assignment 1 is due. What do you do?");
		cyan("1. Pulled an all nighter for it, so you hand in your decent enough assignment");
		yellow("2. Slept a decent amount so you couldn't finish your assignment");
		blue("3. Hand it in, you spent 50 hours on it");
		red("4. Realize it is missing, and say your dog hacked your replit account");
		printLine();
	}

	/*
	 * method promptFour() is the 11AM prompt and is when the user sees Cullen. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 11AM prompt and 4 choices
	 */
	public static void promptFour() {
		printLine();
		System.out.println(
				"⏰ 11:00AM: Unfortunately, you also remember that you have your first period class with Cullen. Cullen calls you a failure because you don’t know how to physics. What is your course of action?");
		cyan("1. Beat him up to cope with your anger");
		yellow("2. You still get him to teach you physics even though you are under immense pain");
		blue("3. Get JW to help you because he’s a nice guy");
		red("4. Ignore him and work on key club work since you are too busy");
		printLine();
	}

	/*
	 * method promptFive() is the 12PM prompt and is when the user has lunch break. it prints the prompt and the options that the user can choose. 
   * pre: none
	 * post: prints the 12PM prompt and the 4 choices user can choose from
	 */
	public static void promptFive() {
		printLine();
		System.out.println(
				"⏰ 12:00PM: Yay! It’s finally lunch now, and Cullen asks you if you want to join the nerd group. What do you do?");
		cyan("1. Decline his offer, since you will be taking a nap in the library");
		yellow("2. Join the nerd group");
		blue("3. Nope, join the cool kids popular club!!");
		red("4. Ignore him and go to the SAC room");
		printLine();
	}

	/*
	 * method promptSix() is the 1PM prompt and is when the user has French class and sees Akshaya! it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 1PM prompt and the 4 choices user can choose from
	 */
	public static void promptSix() {
		printLine();
		System.out.println(
				"⏰ 1:00PM: It’s French class! The teacher is teaching, but your friend Akshaya is playing fire boy and water girl. What do you do?");
		cyan("1. Pay semi attention in class, but still play fire boy water girl anyways");
		yellow("2. Decline her offer, and take a nap");
		blue("3. Pay attention to the French teacher, taking notes");
		red("4. Who cares about French? Let's speedrun fire girl and water boy");
		printLine();
	}

	/*
	 * method passwordGame() checks if a user enters a good password. a good
	 * password must have at least 8 characters, have at least one capital letter, at least one lower case letter, a number, and a special character
   * pre: none
	 * post: asks the user for a password and checks if the password is good or not. if it isn't it will prompt the user to try again
	 */
	public static void passwordGame() {
		// initialize variables for my password game
		String password;
		String name;

    purple("Enter your name: "); 
		// asks for the user name
    while(true){
      name = in.nextLine(); 
      try{
        if(name.length() >= 1){
          break;
        }
        else{
          throw new Exception(); 
        }
      }
      catch(Exception e)
      {
        // makes sure user doesn't just enter nothing
        purple("Try again. Please enter a valid name!"); 
      }
    }

		// asks the user to enter their password
		while (true) {
			purple("Enter your password: ");
			password = in.nextLine();

			// check all conditions to make sure it's a good password
			if (isEightCharacters(password) && hasCapitals(password) && hasLowerCase(password) && hasNumber(password)
					&& hasSpecialCharacter(password) && noName(password, name)) {
				purple("Good password! ");
				wait(2000);
				break;
			}
			// will go back to start of while loop and reiterate until user enters a good password
			else {
				purple("Bad password. Try again!");
			}
		}
	}

	/*
	 * method isEightCharacters(String s) determines if password is at least eight characters long 
   * pre: string has to be not null 
   * post: return true if password is at least 8 characters, else return false
	 */
	public static boolean isEightCharacters(String s) {
		if (s.length() >= 8) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method hasCapitals(String s) determines if password has at least one capital letter 
   * pre: string has to be not null 
   * post: return true if password has at least one character that is capital, else return false
	 */
	public static boolean hasCapitals(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(s.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/*
	 * method hasLowerCase(String s) determines if password has at least one lower letter 
   * pre: string has to be not null 
   * post: return true if password has at least one character that is lower case, else return false
	 */
	public static boolean hasLowerCase(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ("qwertyuiopasdfghjklzxcvbnm".indexOf(s.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/*
	 * method hasNumber(String s) determines if password has at least one number
	 * pre: string has to be not null 
   * post: return true if password has at least one character that is a number, else return false
	 */
	public static boolean hasNumber(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ("1234567890".indexOf(s.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/*
	 * method hasNumber(String s) determines if password has at least one special character 
   * pre: string has to be not null 
   * post: return true if password has at least one character that is a special character, else return false
	 */
	public static boolean hasSpecialCharacter(String s) {
		for (int i = 0; i < s.length(); i++) {
			if ("!@#$%^&*()<>?/:;_-+=~`\\|".indexOf(s.charAt(i)) != -1) {
				return true;
			}
		}
		return false;
	}

	/*
	 * method noNameString s) determines if password does not contain the user's name 
   * pre: string has to be not null 
   * post: return true if password doesn't contain name, else return false
	 */
	public static boolean noName(String s, String n) {
		if (s.contains(n)) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * method promptSeven() is the 2PM prompt and is when the user has their French class break, and go outside. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 2PM prompt and the 4 choices user can choose from
	 */
	public static void promptSeven() {
		printLine();
		System.out.println(
				"⏰ 2:00PM: Your teacher lets you go on a 20 minute break every class, outside on the school field. What are you doing?");
		cyan("1. Eat your fresh fresh apple");
		yellow("2. Talk to Akshaya about computer science");
		blue("3. Talk to random people and walk around the field");
		red("4. Play volleyball with the gym class people");
		printLine();
	}

	/*
	 * method promptEight() is the 3PM prompt and is when the user is just about to leave the school. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 3PM prompt and the 4 choices user can choose from
	 */
	public static void promptEight() {
		printLine();
		System.out.println(
				"⏰ 3:00PM: School is over! Now it’s time to go home. What do you do before you leave the school?");
		cyan("1. Eat a banana since you for some reason have way too many snacks");
		yellow("2. Open up my textbook and read while you walk to the car");
		blue("3. Hit up all my friends and good bye since your presence is truly needed");
		red("4. Go to one of your club rooms to help out with any work you need to do");
		printLine();
	}

	/*
	 * method promptNine() is the 4PM prompt and is when the user has just arrived home. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 4PM prompt and the 4 choices user can choose from
	 */
	public static void promptNine() {
		printLine();
		System.out.println(
				"⏰ 4:00PM: School is just over, and you arrived home. You should probably do something, but are too lazy to study yet. What are you doing?");
		cyan("1. Eat a donut to get that sugar high and make it through the day");
		yellow("2. Procrastinate your homework");
		blue("3. Start a fight with your little sister first thing you come home");
		red("4. Put off your SAC tasks you should probably start doing right now");
		printLine();
	}

	/*
	 * method promptTen() is the 5PM prompt and is when the user has to make a password 
   * pre: none 
   * post: prints the 5PM prompt which is the password game, and prints the requirements needed for a strong password
	 */
	public static void promptTen() {
		printLine();
		System.out.println("⏰ 5:00PM: Now, you need to study French and make a Quizlet account.");
		purple("You need to make a good password. A good password must be at least 8 characters long, must not contain the user's name and have at least one capital letter, lower case letter, number, and special character");
		purple("Enter your password (it must fulfill all requirements):");
		printLine();
	}

	/*
	 * method promptElevenIntro() is the intro to the 6PM prompt and gives the user a few moments to think about what they want to eat for dinner 
   * pre: none 
   * post: prints that it's dinner time and the user should think about what to eat
	 */
	public static void promptElevenIntro() {
		printLine();
		purple("Now it's 6:00PM... dinner time! Your parents are in the kitchen, cooking some food!\nTake a few seconds to think about what you want to eat...");
		printLine();
	}

	/*
	 * method promptEleven() is the official 6PM prompt and is when the user has dinner, and has to choose what to eat for dinner. it prints the prompt and the options that the user can choose. 
   * pre: none
   * post: prints the 6PM prompt and the 4 food choices user can choose from
	 */
	public static void promptEleven() {
		printLine();
		System.out.println(
				"⏰ 6:00PM: Wow, you watch your parents cooking... it looks really tasty... Here are the options. What are you going to eat?");
		cyan("1. Apple 🍎");
		yellow("2. 60% Dark chocolate 🍫");
		blue("3. Banana 🍌");
		red("4. Pizza 🍕");
		printLine();
	}

	/*
	 * method promptElevenCooking() is a cooking animation of the user's parents making them food for dinner 
   * pre: none 
   * post: prints an “illusion” of moving ASCII images with print statements and time delays of a parent making dinner
	 */
	public static void promptElevenCooking() {
		long start_time = System.currentTimeMillis();
		long wait_time = 10000;
		long end_time = start_time + wait_time;

// allows the animation to continue for 10 seconds so the user can appreciate the moving ascii images
		while (System.currentTimeMillis() < end_time) {
			for (int i = 0; i < 14; i++) {
				System.out.println("");
			}

			// prompt 12 7PM
			// credit to the cooking ascii image:
			// https://www.asciiart.eu/food-and-drinks/other
			white("                               (c)___c____(c)");
			white("                               (c)___c____(c)");
			white("                            \\ ........../");
			white("                             |.........|");
			white("                              |.......|");
			white("                              |.......|");
			white("                              |=======|");
			white("                              |=======|");
			purple("                             __o)\"\"\"\"::?");
			purple("                             __o)\"\"\"\"::?");
			purple("                            C__    c)::;");
			purple("                               >--   :: ");
			purple("                               (____/  ");
			purple("                               } /\"\"|");
			purple("                    __/       (|V ^ )\\");
			purple("                    o | _____/ |#/ / | ");
			purple("           @        o_|}|_____/|/ /  | ");
			purple("                          _____/ /   | ");
			purple("              ======ooo}{|______)#   | ");
			purple("          ~~~~ ;    ;          ###---|8  ");
			purple("        ____;_____;____        ###====  ");
			purple("       (///0///@///@///)       ###@@@@|");
			purple("       |~~~~~~~~~~~~~~~|       ###@@@@|");
			purple("        \\             /        ###@@@@|               ");
			purple("         \\___________/         ###xxxxx    ");
		/*	purple("           H H   H  H          ###|| |     ");
			purple("           H H   H  H           | || |   ");
			purple("           H H   H  H           C |C |     ______ /__|#|_");
			purple("           H H   H  H            || ||    /______/___|#|/|");
			purple(" v    \\/   H(o) (o) H            || ::   |:::::::::::::|#|");
			purple(" ~    ~~  (o)      (o)        Ccc__)__)  | PARENT COOKS|#|");
			purple("  \\|/      ~   @* & ~                    |:::::::::::::|/  \\|/");
			purple("   ~           \\|/        !!        \\ !/  ~~~~~~~~~~~~~    ~~~");
			purple("               ~~~        ~~         ~~           ~~");
			purple("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
      */
      // note: the legs are commented out for the sake of printing to the console, but the animation does look quite cool with the chef's legs as well

			// printed spaces for formatting purposes
			for (int i = 0; i < 2; i++) {
				System.out.println("");
			}

			wait(200);

			// printed spaces for formatting purposes
			for (int i = 0; i < 2; i++) {
				System.out.println("");
			}

			// credit to ascii image: https://www.asciiart.eu/food-and-drinks/other
			white("                               (c)___c____(c)");
			white("                               (c)___c____(c)");
			white("                            \\ ........../");
			white("                             |.........|");
			white("                              |.......|");
			white("                              |.......|");
			white("                              |=======|");
			white("                              |=======|");
			purple("                             __o)\"\"\"\"::?");
			purple("                              _o)\"\"\"\"::?");
			purple("                             C_    c)::;  ");
			purple("                               ---   ::  ");
			purple("                               (____/   ");
			purple("                               } /\"\"|");
			purple("                     __/       (|V ^ )\\ ");
			purple("                        o | ___/ |#/ / |");
			purple("        @               o_|}|___/|/ /  | ");
			purple("                          _____/ /   |  ");
			purple("              ======ooo}{|______)#   | ");
			purple("       ~~~~.    ;    ;          ###---|8   ");
			purple("        _____;______;__        ###====");
			purple("       (///0///@///@///)       ###@@@@|");
			purple("       |~~~ ~~~~ ~~~ ~~|       ###@@@@|");
			purple("        \\             /        ###@@@@| ");
			purple("         \\___________/         ###xxxxx    ");
		/*	purple("           H H   H  H          ###|| |     ");
			purple("           H H   H  H           | || |    ");
			purple("           H H   H  H           C |C |     ______ /__|#|_");
			purple("           H H   H  H            || ||    /______/___|#|/|");
			purple(" v    \\/   H(o) (o) H            || ::   |:::::::::::::|#|");
			purple(" ~    ~~  (o)      (o)        Ccc__)__)  | PARENT COOKS|#|");
			purple("  \\|/      ~   @* & ~                    |:::::::::::::|/  \\|/");
			purple("   ~           \\|/        !!        \\ !/  ~~~~~~~~~~~~~    ~~~");
			purple("               ~~~        ~~         ~~           ~~");
			purple("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~"); */

			// printed spaces for formatting purposes
			for (int i = 0; i < 2; i++) {
				System.out.println("");
			}

			wait(200);

		}
	}

	/*
	 * method promptTwelve() is the 7PM prompt and is when the user has volleyball practice. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 7PM prompt and the 4 choices user can choose from
	 */ 
	public static void promptTwelve() {
		printLine();
		System.out.println(
				"⏰ 7:00PM: It’s time for volleyball practice. You show up to practice on time (crazy), what do you do?");
		cyan("1. Do what's instructed, try your best");
		yellow("2. Talk to your teammates instead of actually playing");
		blue("3. Have a sudden epiphany and play really well that day");
		red("4. Start beef with your volleyball coach...");
		printLine();
	}

	/*
	 * method promptThirteen() is the 8PM prompt and is when the user spends some time on their hobbies. it prints the prompt and the options that the user can choose. 
   * pre: none 
   * post: prints the 8PM prompt and the 4 choices user can choose from
	 */
	public static void promptThirteen() {
		printLine();
		System.out.println(
				"⏰ 8:00PM: Since we want to spice up this day, let’s not study and spend some time on some hobbies. What are you going to do?");
		cyan("1. Paint a flower");
		yellow("2. Read manga! Manga is a hobby too.. right?");
		blue("3. Practice piano since Chopin is my lifeline");
		red("4. Tiktok since you have no life so you just make Tiktoks");
		printLine();
	}

	/*
	 * method promptFourteenPartOne() is the 9:00PM prompt and is when the user gets to play their first game (2 mini games total)! it prints the prompt and the 3 games that the user can choose. 
   * pre: none 
   * post: prints the 9:00PM prompt and the 3 games the user can choose from
	 */
	public static void promptFourteenPartOne() {
		printLine();
		System.out.println(
				"⏰ 9:00PM: You need some downtime to relax, and decided to play a game! What game do you play?");
		cyan("1. Rock, Paper, Scissors!");
		yellow("2. Tic Tac Toe");
		blue("3. Random Guessing Game");
		printLine();
	}

	/*
	 * method promptFourteenPartTwo() is the 9:30PM prompt and is when the user gets to play their second game (2 mini games total)! it prints the prompt and the
	 * 3 games that the user can choose. 
   * pre: none 
   * post: prints the 9:30PM prompt and the 3 games the user can choose from
	 */
	public static void promptFourteenPartTwo() {
		printLine();
		System.out.println(
				"⏰ 9:30PM: Ah, that went by quick! You still have time to play more games! Which game do you want to play now? ");
		cyan("1. Rock, Paper, Scissors!");
		yellow("2. Tic Tac Toe");
		blue("3. Random Guessing Game");
		printLine();
	}

	/*
	 * method promptFifteen() is the 10PM prompt and is when the user does their computer science homework. it prints the prompt and the options that the user can choose. 
   * pre: none
   * post: prints the 10PM prompt and the 4 choices user can choose from
	 */
	public static void promptFifteen() {
		printLine();
		System.out.println(
				"⏰ 10PM: It’s time to do your computer science homework. Obviously, you do it at the last minute since yolo. You have no idea how to do it. What do you do?");
		cyan("1. Go to bestie Stack Overflow and watch Indian guy Java Youtube Tutorial");
		yellow("2. Ask Cullen, only to get roasted");
		blue("3. Call up Jonathan because he codes for 10 hours a day and is a nice guy");
		red("4. Not do the computer science homework... and watch Squid Game!");
		printLine();
	}

	/*
	 * method endingPage() depits the ending page once the player finishes
	 * "High School Story" and allows them to click enter to return to home page
	 * pre: none 
   * post: prints the text for the ending page and returns to home page
	 * if user clicks enter or essentially any key
	 */
	public static boolean endingPage() {
		for (int i = 0; i < 2; i++) {
			System.out.println("");
		}

		printLine();

		// girl drawing on chalk board ascii art credit: https://ascii.co.uk/art/school
		purple("    |.==================================,|");
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "    THANKS FOR PLAYING.      "
				+ ANSI_RESET + ANSI_PURPLE + "  ||" + ANSI_RESET);
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "    THANKS FOR PLAYING.      "
				+ ANSI_RESET + ANSI_PURPLE + "  ||" + ANSI_RESET);
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "    THANKS FOR PLAYING.      "
				+ ANSI_RESET + ANSI_PURPLE + "  ||");
		System.out.println(ANSI_PURPLE + "    ||   " + ANSI_RESET + ANSI_YELLOW + "    THANKS FO ," + ANSI_RESET
				+ ANSI_PURPLE + "                ||   ");
		purple("    || /`\\/      \\/`\\ /                 ||");
		purple("    || )_/|      |\\_(/\\                 ||");
		purple("    ||    \\______/  /\\/                 ||");
		purple("    ||    _(____)__/ /                  ||");
		purple("    ||    _(____)__/ /                  ||");
		purple("    ||___/ ,_ _  ___/___________________||");
		purple("    '====\\___\\_) |======================='");
		purple("          |______|");
		purple("          /______\\");
		purple("           |_||_|");
		purple("          (__)(__)");
		System.out.println("");
		yellow("Woah you survived, that's a feat by itself!\nNow you need to survive university.. but thats's another game on it's own :)");
		System.out.println("");

		// allows user to play game again and return to main menu
		yellow("Press \"ENTER\" to try again!");
		printLine();
		
    for (int i = 0; i < 2; i++) {
			System.out.println("");
		}

		System.out.println("");
		in.nextLine();
		clearScreen();
		// this just resets all the stats to 100 just to be safe
		restartStats();

		return false;
	}

	/*
	 * method rockPaperScissors() is a game of rock paper scissors that the user can choose from the prompt 14 mini games 
   * pre: none 
   * post: welcomes user to rock paper scissors and asks them to enter a move, and then lets them know if they win or lose judging by the computer move. after the game, method asks if user wants to play again, and will repeat the game again if user enters y for yes, and will exit out if user enters n for no
	 */
	public static void rockPaperScissors() {
		clearScreen();

		// initalize variables
		String playAgain;
		String playerMove;

    // welcome page for tic tac toe
    printLine();
      System.out.println("");
			purple("Welcome to Rock, Paper, Scissors!\nThis game is non competitive, and will not change your well being stats. So have fun with it!");
      System.out.println("");
      printLine();
			System.out.println("");

		// while loop is used so game continues until user enters n for no
		while (true) {

			// computer generates a random number from 1 to 3
			String computerMove = "";
			int randomNum = generateRandomNum(1, 3);

			// if random number is 1, computer move is scissors, if random number is 2 - computer move is paper, and if 3 - computer move is rock
			if (randomNum == 1) {
				computerMove = "s";
			} else if (randomNum == 2) {
				computerMove = "p";
			} else if (randomNum == 3) {
				computerMove = "r";
			}

			// asks user to enter a move: r, p, or s
			while (true) {
        purple("Please enter your move: r, p, or s");
				playerMove = in.nextLine();
				try {
					if (playerMove.equalsIgnoreCase("s") || playerMove.equalsIgnoreCase("r") || playerMove.equalsIgnoreCase("p")) {
						break;
					} else {
						throw new Exception();
					}
				} catch (Exception e) {
					purple("Please enter a valid move: r, p, or s");
				}
			}

			// shows computer move
			System.out.println(ANSI_PURPLE + "Computer move: " + ANSI_RESET + computerMove);

			// logic for each case of rock paper scissors
			if (playerMove.equals(computerMove)) {
				yellow("It's a tie!");
			} else if (playerMove.equalsIgnoreCase("r")) {
				if (computerMove.equalsIgnoreCase("s")) {
					green("You win!");
				} else if (computerMove.equalsIgnoreCase("p")) {
					red("You lose!");
				}
			} else if (playerMove.equalsIgnoreCase("p")) {
				if (computerMove.equalsIgnoreCase("r")) {
					green("You win!");
				} else if (computerMove.equalsIgnoreCase("s")) {
					red("You lose!");
				}
			} else if (playerMove.equalsIgnoreCase("s")) {
				if (computerMove.equalsIgnoreCase("p")) {
					green("You win!");
				} else if (computerMove.equalsIgnoreCase("r")) {
					red("You lose!");
				}
			}

			// asks user if they want to play again
			purple("Do you want to play again? Enter y for yes, n for no");
			playAgain = in.nextLine();
      
			while (true) {
				if (!playAgain.equalsIgnoreCase("n") && !playAgain.equalsIgnoreCase("y")) {
					purple("Please enter an option: y for yes, n for no!");
					playAgain = in.nextLine();
				} else {
					break;
				}
			}
			if (playAgain.equalsIgnoreCase("n")) {
				purple("Thanks for playing!");
        System.out.println("");
				break;
			}
		}
	}

	/*
	 * method ticTacToe() is one of the mini games from prompt 14 and allows the user to play the game of tic tac toe 
   * pre: none 
   * post: welcomes user to tic tac toe and asks them to enter a X somewhere on the board, shows the computer move, and then after a win/loss/or all spots are filled, it will tell the result of the game
	 */
	public static void ticTacToe() {

		// initialize 2d arrays for the tic tac toe board
		char[][] gameBoard = { { ' ', ' ', ' ' }, { ' ', ' ', ' ' }, { ' ', ' ', ' ' } };

		char[][] numberBoard = { { '1', '2', '3' }, { '4', '5', '6' }, { '7', '8', '9' } };

		// simply for formatting sakes, welcomes user to tic tac toe game
		clearScreen();
		printLine();
		System.out.println("");
		purple("Welcome to Tic Tac Toe!\nThese numbers correspond to the following positions on the table.\nIf you win, you increase your well being XP by 5, decrease by 5 if you lose, or keep it the same if you tie.");
		System.out.println("");
		printNumberBoard(numberBoard);
		System.out.println("");
		printLine();
		
    // for formatting purposes 
    for(int i = 0; i < 6; i++){
      System.out.println("");
    }

		promptEnterKey();
		clearScreen();

		printBoard(gameBoard);

		while (true) {
			playerTurn(gameBoard);
			if (isGameDone(gameBoard)) {
				break;
			}
			printBoard(gameBoard);
			computerTurn(gameBoard);
			printBoard(gameBoard);
		}
	}

	/*
	 * method isGameDone() check if the game is finished and if there is a winner. if there is no winner, it will just check if the board is full 
   * pre: char[][]  gameBoard must be length 3 x 3
   * post: returns true if you win, returns true if computer wins, returns false if not all the spaces on the tic tac toe board are filled yet, and returns true if there is a tie (all the spaces on
	 * the tic tac toe board are filled)
	 */
	public static boolean isGameDone(char[][] gameBoard) {
		// checks if player won
		if (hasSomeoneWon(gameBoard, 'X')) {
			printBoard(gameBoard);
			purple("Congrats, you win!");

      // increases well being stat by 5 since you're happy you won
      statistics[0] += 5; 

			wait(4000);
			clearScreen();
			return true;
		}

		// checks if player won
		if (hasSomeoneWon(gameBoard, 'O')) {
			printBoard(gameBoard);
			purple("Better luck next time... computer wins!");

      // decreases well being stat by 5 since you are sad you lost
      statistics[0] -= 5; 

			wait(4000);
			clearScreen();
			return true;
		}

		// nested for loop will loop through every position on board checks if that position on board is blank, and will note is board is not full and game is not finished
		for (int i = 0; i < gameBoard.length; i++) {
			for (int j = 0; i < gameBoard[i].length; j++) {
				if (gameBoard[i][j] == ' ') {
					return false;
				}
			}
		}

		// lets player know game ended in tie since no one won and all spots are filled
		printBoard(gameBoard);
		purple("Better luck next time... you tied!");

    // for a tie: doesn't update well being stat, since you didn't lose or win
		wait(4000);
		clearScreen();
		return true;
	}

	/*
	 * method hasSomeoneWon() checks if either the player or the computer has won the game of tic tac toe yet 
   * pre: char[][] gameBoard must be length 3 x 3 for it to properly work, and char symbol should be 'X' or 'O'
   * post: returns true if someone has won (the symbols  are filled some way in a row/column/diagonal in the game board), and false if nobody has won this game yet
	 */
	public static boolean hasSomeoneWon(char[][] gameBoard, char symbol) {
		if ((gameBoard[0][0] == symbol && gameBoard[0][1] == symbol && gameBoard[0][2] == symbol)
				|| (gameBoard[1][0] == symbol && gameBoard[1][1] == symbol && gameBoard[1][2] == symbol)
				|| (gameBoard[2][0] == symbol && gameBoard[2][1] == symbol && gameBoard[2][2] == symbol)
				|| (gameBoard[0][0] == symbol && gameBoard[1][0] == symbol && gameBoard[2][0] == symbol)
				|| (gameBoard[0][1] == symbol && gameBoard[1][1] == symbol && gameBoard[2][1] == symbol)
				|| (gameBoard[0][2] == symbol && gameBoard[1][2] == symbol && gameBoard[2][2] == symbol)
				|| (gameBoard[0][0] == symbol && gameBoard[1][1] == symbol && gameBoard[2][2] == symbol)
				|| (gameBoard[0][2] == symbol && gameBoard[1][1] == symbol && gameBoard[2][0] == symbol)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * method computerTurn() gets the computer to make a move of where they want to place their "O" on the tic tac toe board 
   * pre: char[][] gameBoard must be length 3 x 3 
   * post: computer chooses a position on the tic tac toe board and places the "O"
	 */
	public static void computerTurn(char[][] gameBoard) {
		// initialize variables at start
		int computerMove;

		// gets computer to generate a random number from 1 to 9, so it can choose a
		// position
		while (true) {
			computerMove = generateRandomNum(1, 9);
			if (isValidMove(gameBoard, Integer.toString(computerMove))) {
				break;
			}
		}

		// places move that computer made and shows what position computer chose
		purple("The computer chose position: " + computerMove);
		placeMove(gameBoard, Integer.toString(computerMove), 'O');
	}

	/*
	 * method isValidMove(char[][] gameBoard, String position) checks if a valid move was made 
   * pre: char[][] gameBoard must be length 3 x 3, and String position must not be null and be one of the positions from 1-9
   * post: returns true if it's a valid move (one of the numbers 1-9), and false if it is not a valid move
	 */
	public static boolean isValidMove(char[][] gameBoard, String position) {
		switch (position) {
		case "1":
			return (gameBoard[0][0] == ' ');
		case "2":
			return (gameBoard[0][1] == ' ');
		case "3":
			return (gameBoard[0][2] == ' ');
		case "4":
			return (gameBoard[1][0] == ' ');
		case "5":
			return (gameBoard[1][1] == ' ');
		case "6":
			return (gameBoard[1][2] == ' ');
		case "7":
			return (gameBoard[2][0] == ' ');
		case "8":
			return (gameBoard[2][1] == ' ');
		case "9":
			return (gameBoard[2][2] == ' ');
		default:
			return false;
		}
	}

	/*
	 * method playerTurn() allows the player to enter a move in the tic tac toe game
	 * pre: char[][] gameBoard must be length 3 x 3 
   * post: asks user where they would like to place their "X" on the tic tac toe board game, and helps them place their move
	 */
	public static void playerTurn(char[][] gameBoard) {
		// intialize variables
		String playerInput;

		while (true) {
			purple("Where would you like to play? Enter an integer from 1 to 9:");
			playerInput = in.nextLine();

			try {
				if (isValidMove(gameBoard, playerInput)) {
					break;
				} else {
					throw new Exception();
				}
			} catch (Exception e) {
				// makes sure it's an empty slot
				red("Please enter a valid integer from 1 to 9 that has not been filled out on the board yet!");
			}

		}
		// places move for the player
		placeMove(gameBoard, playerInput, 'X');
	}

	/*
	 * method spaceAvaliable(char[][] gameBoard, int position) checks if there is space avaliable in the tic tac toe game 
   * pre: char[][] gameBoard must be length 3 x 3
   * post: returns true if the slot in the 2d array has a space, and
	 * false otherwise
	 */
	public static boolean spaceAvaliable(char[][] gameBoard, int position) {
		switch (position) {
		case 1:
			return (gameBoard[0][0] == ' ');
		case 2:
			return (gameBoard[0][1] == ' ');
		case 3:
			return (gameBoard[0][2] == ' ');
		case 4:
			return (gameBoard[1][0] == ' ');
		case 5:
			return (gameBoard[1][1] == ' ');
		case 6:
			return (gameBoard[1][2] == ' ');
		case 7:
			return (gameBoard[2][0] == ' ');
		case 8:
			return (gameBoard[2][1] == ' ');
		case 9:
			return (gameBoard[2][2] == ' ');
		default:
			return false;
		}
	}

	/*
	 * method placeMove() places a move for the player/computer in the tic tac toe game 
   * pre: char[][] gameBoard must length 3 x 3, string must not be null, symbol should be either "X" or "O" 
   * post: places the respective symbol into the game board at the specific position on the tic tac toe board
	 */
	public static void placeMove(char[][] gameBoard, String position, char symbol) {
		switch (position) {
		case "1":
			gameBoard[0][0] = symbol;
			break;
		case "2":
			gameBoard[0][1] = symbol;
			break;
		case "3":
			gameBoard[0][2] = symbol;
			break;
		case "4":
			gameBoard[1][0] = symbol;
			break;
		case "5":
			gameBoard[1][1] = symbol;
			break;
		case "6":
			gameBoard[1][2] = symbol;
			break;
		case "7":
			gameBoard[2][0] = symbol;
			break;
		case "8":
			gameBoard[2][1] = symbol;
			break;
		case "9":
			gameBoard[2][2] = symbol;
			break;
		default:
			System.out.println("Error");
		}
	}

	/*
	 * method printNumberBoard() prints the tic tac toe board with the numbers on it, for instructional purposes to show the numbers' position on the tic tac toe board 
   * pre: char[][] gameBoard must be length 3 x 3 
   * post: prints the tic tac toe board, with numbers in each of the slots
	 */
	public static void printNumberBoard(char[][] numberBoard) {
		purple(numberBoard[0][0] + "|" + numberBoard[0][1] + "|" + numberBoard[0][2]);
		purple("-+-+-");
		purple(numberBoard[1][0] + "|" + numberBoard[1][1] + "|" + numberBoard[1][2]);
		purple("-+-+-");
		purple(numberBoard[2][0] + "|" + numberBoard[2][1] + "|" + numberBoard[2][2]);
	}

	/*
	 * method printBoard() prints the tic tac toe board empty 
   * pre: char[][] gameBoard must be length 3 x 3 
   * post: prints the tic tac toe board (not filled  out yet)
	 */
	public static void printBoard(char[][] gameBoard) {
		purple(gameBoard[0][0] + "|" + gameBoard[0][1] + "|" + gameBoard[0][2]);
		purple("-+-+-");
		purple(gameBoard[1][0] + "|" + gameBoard[1][1] + "|" + gameBoard[1][2]);
		purple("-+-+-");
		purple(gameBoard[2][0] + "|" + gameBoard[2][1] + "|" + gameBoard[2][2]);
	}

	/*
	 * method guessingGame() is one of the mini games in prompt 14 that the user can play. it asks the user to guess the number that is randomly generated by the
	 * computer 
   * pre: none 
   * post: prints introduction information to the guessing game, asks user what they think the number is, and tells them if they are right, or if it's higher or lower (if user guessed wrong). it also prints how
	 * many tries it took the user to guess the number right
	 */
	public static void guessingGame() {

		// initialize variables
		int randomNum;
		int guess;
		String input;

		// counts how many tries it took user to enter right variable
		int counter = 0;

		randomNum = generateRandomNum(1, 100);

		// introduction text to the guessing game
		printLine();
		System.out.println("");
		purple("Welcome to the guessing game!");
		purple("The computer will randomly choose a number from 1 to 100.\nYour job is to try to guess that number.\nIt will give you hints if you get it wrong!\nIf you guess the number within 5 tries, your well being stats increase by 5. Otherwise, they will decrease by 5.");
		System.out.println("");
		printLine();

    // print spaces for formatting
    for(int i = 0; i < 9; i++){
      System.out.println("");
    }

		promptEnterKey();
    clearScreen();
    clearScreen();

		while (true) {
			// asks user to enter a number from to 100
			while (true) {
				purple("Enter a guess (1-100):");
				input = in.nextLine();

				try {
					guess = Integer.parseInt(input);
					counter++;
          if(guess > 100 || guess < 0){
            throw new Exception(); 
          }
					break;
				} catch (Exception e) {
					System.out.println("Please enter an integer between 1 to 100!");
				}
			}

			if (guess == randomNum) {
				green("Good job, you win!");
				purple("It took you " + counter + " tries");

        // checks if player won within 5 tries, and increases well being by 5 if they do, and decrease by 5 if they don't
        if(counter <= 5 ){
          statistics[0] += 5;
        }
        else{
          statistics[0] -= 5;
        }

				wait(4000);
				clearScreen();
				break;
			} else if (randomNum > guess) {
				red("Nope, the number is higher. Guess again!");
			} else {
				red("Nope, the number is lower. Guess again!");
			}


		}
	}

	/*
	 * method updateOption() updates all the statistics for the game 
   * pre: none 
   * post: updates the statistics for the game
	 */
	public static void updateOption(int wellb, int academ, int status, int ec) {
		statistics[0] += wellb;
		statistics[1] += academ;
		statistics[2] += status;
		statistics[3] += ec;
	}

	/*
	 * method restartStats() resets all stats to 100, just to be safe so the while loop doesn't crash since some stats may be below 50 
   * pre: none 
   * post: resets all stats (wellbeing, academics, social status, and extracurriculars) to 100
	 */
	public static void restartStats() {
		statistics[0] = 100;
		statistics[1] = 100;
		statistics[2] = 100;
		statistics[3] = 100;
	}

	/*
	 * method gameOption() lets the user play the following game they chose 
   * pre: none 
   * post: allows user to enter their option and to play their game depending on the option number (1, 2, or 3) chosen
	 */
	public static void gameOptions() {
  String input; 

		while (true) {
			input = in.nextLine();
			try {
				if (input.equals("1")) {
					clearScreen();
					rockPaperScissors();
				} else if (input.equals("2")) {
					clearScreen();
					ticTacToe();
				} else if (input.equals("3")) {
					clearScreen();
					guessingGame();
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, or 3!");
			}
		}
	}

	/*
	 * method increaseValue() will increase one of the values for the stats by 5, depending on what option the user picks 
   * pre: none 
   * post: allows user to enter input, and updates the stats accordingly
	 */
	public static void increaseValue() {
    String input;

		while (true) {
		  input = in.nextLine();
			try {
				if (input.equals("1")) {
					updateOption(5, 0, 0, 0);
				} else if (input.equals("2")) {
					updateOption(0, 5, 0, 0);
				} else if (input.equals("3")) {
					updateOption(0, 0, 5, 0);
				} else if (input.equals("4")) {
					updateOption(0, 0, 0, 5);
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, 3, or 4!");
			}
		}
	}

	/*
	 * method decreaseValue() will decrease one of the values for the stats by 15, depending on what option the user picks 
   * pre: none 
   * post: allows user to enter input, and updates the stats accordingly
	 */
	public static void decreaseValue() {
    String input; 

		while (true) {
		 input = in.nextLine();
			try {
				if (input.equals("1")) {
					// -15 is used just to make the game slightly harder as it a survival game (for high school) after all
					updateOption(-15, 0, 0, 0);
				} else if (input.equals("2")) {
					updateOption(0, -15, 0, 0);
				} else if (input.equals("3")) {
					updateOption(0, 0, -15, 0);
				} else if (input.contains("4")) {
					updateOption(0, 0, 0, -15);
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, 3, or 4!");
			}
		}
	}

	/*
	 * method randomizeStats() will randomize the stats within a certain range depending on the option chosen
   * pre: none
   * post: allows user to randomize their stats within a certain range depending on the option they chose for difficultly level for the "High School Story" game
	 */
	public static void randomizeStats() {
    // initialize variable
    String input; 
    
		while (true) {
			try {
        input = in.nextLine();
				if (input.equals("1")) {
					// initialize all stats to be within a range from 80-100
					statistics[0] = generateRandomNum(80, 100);
					statistics[1] = generateRandomNum(80, 100);
					statistics[2] = generateRandomNum(80, 100);
					statistics[3] = generateRandomNum(80, 100);
				} 
        else if (input.equals("2")) {
					// initialize all stats to be within a range from 70-80
					statistics[0] = generateRandomNum(70, 80);
					statistics[1] = generateRandomNum(70, 80);
					statistics[2] = generateRandomNum(70, 80);
					statistics[3] = generateRandomNum(70, 80);
				} 
        else if (input.equals("3")) {
					// initialize all stats to be within a range from 60-70
					statistics[0] = generateRandomNum(60, 70);
					statistics[1] = generateRandomNum(60, 70);
					statistics[2] = generateRandomNum(60, 70);
					statistics[3] = generateRandomNum(60, 70);
				} 
        else {
					throw new Exception();
				}
        break;
			} 
      catch (Exception e) {
				purple("Please enter an option: 1, 2, or 3!");
			}
		}
	}

	/*
	 * method changeAcademicsValue() will update only the academics stat by a certain number, depending on what option the user picks 
   * pre: none 
   * post: allows user to enter input, and updates the academics stat accordingly
	 */
	public static void changeAcademicsValue() {
    String input; 

		while (true) {
			input = in.nextLine();
			try {
				if (input.equals("1")) {
					updateOption(0, 5, 0, 0);
				} else if (input.equals("2")) {
					updateOption(0, -5, 0, 0);
				} else if (input.equals("3")) {
					updateOption(0, 10, 0, 0);
				} else if (input.equals("4")) {
					updateOption(0, -10, 0, 0);
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, 3, or 4!");
			}
		}
	}

	/*
	 * method changeExtracurricularStats() will update only the extracurricular
	 * stats by a certain number, depending on what option the user picks 
   * pre: none
	 * post: allows user to enter input, and updates the extracurriculars stat accordingly
	 */
	public static void changeExtracurricularStats() {
    String input; 

		while (true) {
			input = in.nextLine();
			try {
				if (input.equals("1")) {
					updateOption(0, 0, 0, 5);
				} else if (input.equals("2")) {
					updateOption(0, 0, 0, -5);
				} else if (input.equals("3")) {
					updateOption(0, 0, 0, 10);
				} else if (input.equals("4")) {
					updateOption(0, 0, 0, -10);
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, 3, or 4!");
			}
		}
	}

	/*
	 * method changeWellbeingValue() will update only the well being stat by a
	 * certain number, depending on what food option the user picks 
   * pre: none 
   * post: allows user to enter input for the option they pick, and updates the well
	 * being stat accordingly. it also prints an image of ascii art of the food they
	 * chose and a short phrase using time delays
	 */
	public static void changeWellBeingValue() {
    String input; 

		while (true) {
			input = in.nextLine();
			try {
				if (input.equals("1")) {
					updateOption(5, 0, 0, 0);
					clearScreen();
					System.out.println("Enjoy your food! Like they say, an apple a day keeps the doctor away");

					// ascii art credit for apple: https://www.asciiart.eu/food-and-drinks/apples
					red("  ,--./,-.");
					red(" / #      \\");
					red("|          |");
					red(" \\        /");
					red("  `._,._,'");
					clearScreen();
					promptEnterKey();
				} else if (input.equals("2")) {
					updateOption(-5, 0, 0, 0);
					clearScreen();
					System.out.println("Enjoy the chocolate! Good choice, full of antioxidants and minerals");

					// ascii art credit for chocolate:
					// https://www.asciiart.eu/food-and-drinks/chocolates
					purple("  ___  ___  ___  ___  ___.---------------.");
					purple(".'\\__\\'\\__\\'\\__\\'\\__\\'\\__,`   .  ____ ___ \\");
					purple("|\\/ __\\/ __\\/ __\\/ __\\/ _:\\   |`.  \\  \\___ \\");
					purple(" \\\\'\\__\\'\\__\\'\\__\\'\\__\\'\\_`.__|\"\"`. \\  \\___ \\");
					purple("  \\/ __\\/ __\\/ __\\/ __\\/ __:                \\");
					purple("   \\\\'\\__\\'\\__\\'\\__\\ \\__\\'\\_;-----------------`");
					purple("    \\\\/   \\/   \\/   \\/   \\/ :                 |");
					clearScreen();
					promptEnterKey();
				} else if (input.equals("3")) {
					updateOption(10, 0, 0, 0);
					clearScreen();
					System.out.println("Enjoy the banana! Elite choice, bananas are the best dinner");

					// ascii art credit for banana: https://www.asciiart.eu/food-and-drinks/bananas
					yellow(" _");
					yellow("//\\");
					yellow("V  \\");
					yellow(" \\  \\_");
					yellow("  \\,'.`-.");
					yellow("   |\\ `. `. ");
					yellow("   ( \\  `. `-.                        _,.-:\\");
					yellow("    \\ \\   `.  `-._             __..--' ,-';/");
					yellow("     \\ `.   `-.   `-..___..---'   _.--' ,'/");
					yellow("      `. `.    `-._        __..--'    ,' /");
					yellow("        `. `-_     ``--..''       _.-' ,'");
					yellow("          `-_ `-.___        __,--'   ,'");
					yellow("             `-.__  `----\"\"\"    __.-'");
					yellow("                  `--..____..--'");

					// clear screen usually works quite well but since this banana ascii art is
					// really big, want to use a little less spacing so i will use a for loop
					// instead so it looks formatted center
					for (int i = 0; i < 3; i++) {
						System.out.println("");
					}

				  promptEnterKey();

				} else if (input.equals("4")) {
					updateOption(-10, 0, 0, 0);
					clearScreen();
					System.out.println("Not very healthy... here's your pizza though! Enjoy!");

					// ascii art credit for pizza: https://www.asciiart.eu/food-and-drinks/other
					yellow("// \"\"--.._");
					yellow("||  (_)  _ \"-._");
					yellow("||    _ (_)    '-.");
					yellow("||   (_)   __..-'");
					yellow(" \\\\__..--\"\"");
					clearScreen();
					promptEnterKey();
				} else {
					throw new Exception();
				}
				break;
			} catch (Exception e) {
				System.out.println("Please enter an option: 1, 2, 3, or 4!");
			}
		}
	}
}
