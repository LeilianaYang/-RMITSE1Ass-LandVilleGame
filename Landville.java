import java.util.Scanner;

public class Landville {
    /* add the variable 'hasHouse' */
    private int[][] land;

    /* define hasHuose type as boolean as requested */
    private boolean hasHouse;

    /*  A: Constructor method (create and initialize land array, hasHouse variable):
        initialize the object --land[][]
     */
    public Landville (int row, int col) {
        /* Instantiation the land[][] with the row and column */
        this.land = new int[row][col];

        /* use loop to initialize the 2Darray'land[][]' wiz the value 0 means empty plot */
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {

                land[i][j] = 0;
            }
        }
        /* Initialize the hasHouse as false as requested */
        hasHouse = false;
    }

    /*  B:displayLand method :display the land as a square shape consists of 0
     */
    public void displayLand() {
        /* The value of i must be less than land.length which stands for the number of column */
        for (int i = 0; i < land.length; i++) {
            /* The value of j must be less than land[0].length which stands for the number of row [0] */
            for (int j = 0; j < land[0].length; j++) {
                System.out.print(land[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

    }


    /*  C: Clearland method : recoverd as the initial value
           after clearing the land, there is no house on the land.
     *  call the method displayland which is used to recover the initialized square shape consists of 0
     */

    public void clearLand() {
        /* use loop whatever the value i&j is ,land[i][j] = 0 */
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                land[i][j] = 0;
            }
        }
        /* Initialize the boolean variable 'hasHouse' as false
        which is the sign that whether there is a house on the land */
        hasHouse = false;

        /* call the method displayland to show the land is cleared */
        displayLand();
        System.out.println("The land is cleared.");

    }


  /*  F: buildHouse method. check the conditions on input,write code for house and border
       At the end of the buildHouse method, call displayLand method and update 'hasHouse';
   *  buildHouse method : shows rows and columns of the house with '8'
      and rows and columns of the border is '1'
      and call method displayLand to show the rows and columns of the land is '0' ;

   */
    public void buildHouse(int hrow, int hcol) {
        /*
        To make sure both the row of the house & land
        and column of the house & land must be greater than or equal to 2
        */
        for (int i = 0; i < hrow + 2; i++) {
            for (int j = 0; j < hcol + 2; j++) {
                /* make the border shape consists of 1 */
                this.land[i][j] = 1;
            }
        }
        for (int i = 1; i < hrow + 1; i++) {
            for (int j = 1; j < hcol + 1; j++) {
                /* make the house shape consists of 8 */
                this.land[i][j] = 8;
            }
        }
        /* boolean variable hasHouse is needed to help check whether the input is valid;
           update "hasHouse" and call the method displayLand()
         */
        hasHouse = true;
        displayLand();

    }


    public static void main(String[] args) {
        /* Scanner object for user input */
        Scanner userInput = new Scanner(System.in);

        /* D: Input row and column number, check for valid input.Create an object of LandVille class */
        int row = 0, col = 0;
        System.out.println("Tips: in order to build a house on the land," + "\n" +
                "please set the row and col of land greater than 2.");

        /* a boolean variable to help check whether the input is valid */
        boolean flag = false;
        /* this loop is to guarantee the input is a valid number, not letter or other characters.*/
        while (!flag) {
            try
            {
                System.out.println("Please enter the row:");
                row = userInput.nextInt();
                userInput.nextLine();
                /* As requested by taskC less than or equal to 10*/
                if (!(row > 2 && row <= 10)) {
                    System.out.println("Your input is out of range," + "\n" +
                            "the row of land should be greater than 2 and less than or equal to 10.");
                }

                /* when (row > 2 && row <= 10) , break*/
                else
                    flag = true;
            }
            catch (Exception e) {
                System.out.println("Error : your input is not a valid number.");
                userInput.nextLine();
            }
        }

        /* define flag is folse again */
        flag = false;
        while (!flag) {
            try {
                System.out.println("Please enter the column:");
                col = userInput.nextInt();
                /* Newline instruction method*/
                userInput.nextLine();
                if (!(col > 2 && col <= 10)) {
                    System.out.println("Your input is out of range," +"\n" +
                            "the column of land should be greater than 2 and less than or equal to 10.");
                } else
                    flag = true;
            } catch (Exception e)
            {
                System.out.println("Error : your input is not a valid number.");
                userInput.nextLine();
            }
        }

        /* create an object of LandVille named ob */
        Landville ob = new Landville(row, col);

        /* create the row and column of house, and initialize them with value 0 */
        int hrow = 0, hcol = 0;

        /* E: Show menu. take the menu option as input.
        If the input is 1, take input for house and call buildHouse method.
        Show the menu as long as user does not select menu option 4.
         * declaration of the menu option
         */
        String menuOption;

        /* a while loop make sure that the menu can repeat showing*/
        while (true)
        {
            System.out.println("Menu" +"\n" +
                    "1. Build a house" +"\n" +
                    "2. Display land" +"\n" +
                    "3. Clear the land" +'\n' +
                    "4. Quit" +"\n" +
                    "Please enter the number of menu options:");
            menuOption = userInput.nextLine();

            /* switch-case help to call different method from main method.*/
            switch(menuOption)
            {
                case "1":
                    if (ob.hasHouse == true)
                    {
                        System.out.println("Error: a house already exisits.");
                    }
                    else
                        {
                            flag = false;
                    /* this loop is to guarantee the input is a valid number,
                     not letter or other characters.*/
                        while (!flag) {
                            try {
                                System.out.println("Please enter the number of rows of the house to build:");
                                /*give hrow a new value like userInput call the method nextInt*/
                                hrow = userInput.nextInt();
                                userInput.nextLine();
                                if(!(ob.land.length - hrow >= 2)){
                                    System.out.println("Your input is out of range, "
                                            + "row of house should be greater than 0"+" \n"
                                            + ",and less than or equal to "
                                            + (ob.land.length-2));
                                }else flag = true;

                            }catch (Exception e)
                            {
                                System.out.println("Error : your input is not a valid number.");
                                userInput.nextLine();
                            }

                        }
                            /*set the flag to false in order to make sure the loop can work */
                            flag = false;
                            /* this loop is to guarantee the input is a valid number, not letter or other characters.*/
                            while (!flag)
                            {
                                try {
                                    System.out.println("Please enter the number of column of the house to build:");
                                    //this statement is the one
                                    hcol = userInput.nextInt();
                                    userInput.nextLine();
                                    //the row and column of house should be 2 less than the land
                                    if(!(ob.land[0].length - hcol >= 2))
                                    {
                                        System.out.println("Your input is out of range, "
                                                + "column of house should be greater than 0 \n"
                                                + ",and less than or equal to "
                                                + (ob.land[0].length-2));
                                    }else flag = true;
                                }catch (Exception e)
                                {
                                    System.out.println("Error : your input is not a valid number.");
                                    //this try-catch provide the function that the program can still run when the input is not a int variable
                                    userInput.nextLine();
                                }
                            }
                            ob.buildHouse(hrow, hcol);
                        }
                    break;
                case "2":
                    ob.displayLand();
                    break;
                case "3":
                    ob.clearLand();
                    break;
                case "4":
                    userInput.close();
                    System.out.println("Program ends.");
                    System.exit(0);
                default:
                    System.out.println("Error: please enter the valid option.");
                    System.out.println();
                    break;

                    }

            }
        }


    }

