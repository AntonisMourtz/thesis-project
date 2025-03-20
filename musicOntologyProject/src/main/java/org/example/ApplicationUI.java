package org.example;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ApplicationUI {
    GraphicalUI graphicalUI = new GraphicalUI();
    OntologyManagement ontologyManagement = new OntologyManagement();


    public static void mainMenu(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Music Ontology Application\n");


         while (true){

             System.out.println("Choose one of the following:");
             System.out.println("1. Make a new Ontology");
             System.out.println("2. Ontology Processing");
             System.out.println("3. Ontology Searching");
             System.out.println("4. Open the Protege");
             System.out.println("5. Information");
             System.out.println("6. Help");
             System.out.println("0. Exit");

             System.out.print("Enter the number of your choice: ");
             String choice = scanner.nextLine();

             if(choice.equals("1")){
                 spaceMenu();
                 newOntology();
             }
             else if (choice.equals("2")){
                 spaceMenu();
                 ontologyProcessing();

             }else if (choice.equals("3")){
                 spaceMenu();
                 ontologySearch();

             }
             else if (choice.equals("4")){
                 spaceMenu();
                 openProtege();

             }
             else if (choice.equals("5")){
                 spaceMenu();
                 GraphicalUI.informationMassage();

             }
             else if (choice.equals("6")){
                 spaceMenu();
                 String helpNumber="1";
                 GraphicalUI.helpMessage(helpNumber);

             }
             else if (choice.equals("0")){
                 System.exit(0);
             }else {
                 spaceMenu();
                 System.out.println("[Please enter a number between 0-6]");

             }

         }


    }


    private static void newOntology(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Are you sure? You will delete the previous Ontology (Yes/no) ");
        String answer1 = scanner.nextLine();
        answer1 = answer1.toUpperCase();
        while (!answer1.equals("YES") && !answer1.equals("NO")){
            System.out.println("Please enter Yes or No");
            answer1 = scanner.nextLine();
            answer1 = answer1.toUpperCase();
        }
        //only if we want to delete the previous ontology, we can create the new one.
        if(answer1.equals("YES")){
            OntologyManagement.newOntology();
        }

    }
    private static void ontologyProcessing(){
        OntologyManagement.ontologyProcessing();

    }
    private static void ontologySearch(){
        OntologySearching.ontologySearching();

    }
    private static void openProtege(){

        ProtegeManagement protegeManagement = new ProtegeManagement();
        ProtegeManagement.openProtege();

    }
    private static void spaceMenu(){
        for(int i =0; i<3; i++){
            System.out.println("\n");
        }

    }

}
