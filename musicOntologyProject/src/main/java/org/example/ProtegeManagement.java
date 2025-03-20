package org.example;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

public class ProtegeManagement {


    public static void openProtege(){

        Scanner scanner = new Scanner(System.in);

        // Prompt user for the path to Protege
        System.out.print("Enter the path of Protege: ");
        String protegePath = scanner.nextLine();

        protegePath = protegePath + "\\run.bat";

        //System.out.println("Protege path: " + protegePath);

        //Prompt user for the OWL file name
        System.out.print("\nEnter the name of the OWL file (without extension): ");
        String owlFileName = scanner.nextLine();

        //Determine the path to the OWL file located in the project directory
        String projectDirectory = System.getProperty("user.dir");  // Get the current working directory
        String owlFilePath = Paths.get(projectDirectory, owlFileName + ".owl").toString();

        //System.out.println("OWL file path: " + owlFilePath);

        //Check if the Protege path is valid
        File protegeFile = new File(protegePath);
        if (!protegeFile.exists() || !protegeFile.isFile()) {
            System.out.println("\n[You don't have Protege. Please download it.\n\n");
            return;
        }

        //Check if the OWL file exists
        File owlFile = new File(owlFilePath);
        if (!owlFile.exists() || !owlFile.isFile()) {
            System.out.println("\n[The specified OWL file does not exist.]\n\n");
            return;
        }

        //Start Protege with the specified OWL file
        ProcessBuilder processBuilder = new ProcessBuilder(protegePath, owlFilePath);
        processBuilder.directory(protegeFile.getParentFile());  // Set the working directory

        try {
            Process process = processBuilder.start();
            System.out.println("\n[Protege started successfully.]\n\n");
        } catch (IOException e) {
            System.out.println("\n[Failed to start Protege: " + e.getMessage()+"]\n\n");
        }



    }
}
