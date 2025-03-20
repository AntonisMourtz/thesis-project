package org.example;
import org.apache.jena.rdf.model.*;
import org.apache.jena.vocabulary.RDF;
import java.util.*;

public class OntologySearching {
    public static void ontologySearching(){
        runOntologySearch("ontology.owl"); // Load OWL file
    }
    public static void runOntologySearch(String owlFilePath) {
        Model model = ModelFactory.createDefaultModel();
        model.read(owlFilePath); // Load ontology from file

        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Display menu options
            System.out.println("\nSelect an option:");
            System.out.println("1. Find the classes of an individual");
            System.out.println("2. Find individuals of a class");
            System.out.println("3. Find relationships of individuals");
            System.out.println("4. Back");

            int choice = getValidChoice(scanner, 1, 4); // Ensure valid input

            if (choice == 4) {
                break;
            }

            System.out.print("Enter the name: ");
            //We use .trim to avoid errors if the user leaves too much space (spaces or tabs )
            String input = scanner.nextLine().trim();

            //Get the ontology namespace (for example http://example.com/ontology....)
            String namespace = getNamespace(model);
            if (namespace == null) {
                System.out.println("Error: Could not determine ontology namespace.");
                continue;
            }

            if (choice == 1) {
                findClassOfIndividual(model, namespace, input);
            } else if (choice == 2) {
                findIndividualsOfClass(model, namespace, input);
            } else if (choice == 3) {
                findRelationships(model, namespace, input.split("\\s+")); // Split input by spaces
            }
        }
    }

    // Ensures that the user enters a valid integer between min and max
    private static int getValidChoice(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Enter your choice (" + min + "-" + max + "): ");
            String input = scanner.nextLine();
            try {
                int choice = Integer.parseInt(input);
                if (choice >= min && choice <= max) {
                    return choice; // Valid choice
                }
            } catch (NumberFormatException e) {
                // Ignore invalid input and prompt again
            }
            System.out.println("Invalid input! Please enter a number between " + min + " and " + max + ".");
        }
    }

    // Finds the class of a given individual
    private static void findClassOfIndividual(Model model, String namespace, String individualName) {
        Resource individual = model.getResource(namespace + individualName);
        StmtIterator iter = model.listStatements(individual, RDF.type, (RDFNode) null);

        // Check if there are any individuals
        if (!iter.hasNext()) {
            System.out.println("No class found for individual: " + individualName);
        } else {
            // Print all Classes
            System.out.println("Classes of " + individualName + ":");
            while (iter.hasNext()) {
                Statement stmt = iter.nextStatement();
                System.out.println(" - " + stmt.getObject().asResource().getLocalName());
            }
        }
    }

    // Finds all individuals that belong to a given class
    private static void findIndividualsOfClass(Model model, String namespace, String className) {
        Resource classResource = model.getResource(namespace + className);
        StmtIterator iter = model.listStatements(null, RDF.type, classResource);

        // Check if there are any individuals
        if (!iter.hasNext()) {
            System.out.println("No individuals found for class: " + className);
        } else {
            // Print all individuals
            System.out.println("Individuals of class " + className + ":");
            while (iter.hasNext()) {
                Statement stmt = iter.nextStatement();
                //We print only the name of individual and not all the URL
                System.out.println(" - " + stmt.getSubject().getLocalName());
            }
        }
    }

    // Finds relationships of given individuals
    private static void findRelationships(Model model, String namespace, String[] individuals) {
        for (String name : individuals) {
            Resource individual = model.getResource(namespace + name);
            if (individual == null) {
                System.out.println("Individual not found: " + name);
                continue;
            }

            StmtIterator iter = model.listStatements(individual, null, (RDFNode) null);

            if (!iter.hasNext()) {
                System.out.println(name + " has no relationships.");
            } else {
                System.out.println("Relationships of " + name + ":");
                while (iter.hasNext()) {
                    Statement stmt = iter.nextStatement();
                    String predicate = stmt.getPredicate().getLocalName();
                    String object = stmt.getObject().isResource() ? stmt.getObject().asResource().getLocalName() : stmt.getObject().toString();
                    System.out.println(" - " + predicate + " -> " + object);
                }
            }
        }
    }

    // Gets the namespace of the ontology
    private static String getNamespace(Model model) {
        ResIterator iter = model.listSubjects();
        while (iter.hasNext()) {
            Resource res = iter.nextResource();
            if (res.getNameSpace() != null) {
                return res.getNameSpace();
            }
        }
        return null; // Namespace not found
    }
}
