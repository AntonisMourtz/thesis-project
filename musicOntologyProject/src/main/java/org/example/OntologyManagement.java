package org.example;

import org.apache.jena.ontology.*;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.*;

import java.io.*;
import java.util.*;

public class OntologyManagement {

    public static void newOntology(){
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> person = new ArrayList<String>();
        ArrayList<String> band = new ArrayList<String>();
        ArrayList<String> musicalInstruments = new ArrayList<String>();
        ArrayList<String> song = new ArrayList<String>();
        ArrayList<String> recording = new ArrayList<String>();
        ArrayList<String> album = new ArrayList<String>();
        ArrayList<String> studio = new ArrayList<String>();
        ArrayList<String> venue = new ArrayList<String>();
        ArrayList<String> label = new ArrayList<String>();
        ArrayList<String> year = new ArrayList<String>();

        ArrayList<String> message = new ArrayList<>();
        ArrayList<String> counter = new ArrayList<>();

        counter.add("1");
        counter.add("2");
        counter.add("3");
        counter.add("4");
        counter.add("5");
        counter.add("6");
        counter.add("7");
        counter.add("8");
        counter.add("9");
        counter.add("10");

        message.add("1) Artists -> Person");
        message.add("2) Artists -> Band");
        message.add("3) Musical instruments");
        message.add("4) Song");
        message.add("5) Recording");
        message.add("6) Album");
        message.add("7) Place -> Studio");
        message.add("8) Place -> Venue");
        message.add("9) Label");
        message.add("10) Year");

        System.out.println("#################################################");
        System.out.println("Let's make the new music Ontology!!!\n");

        System.out.println("--Some Instructions--\n ");
        System.out.println("-> Υou can put as many names as you want for each class");
        System.out.println("-> When you finish entering names, enter 'STOP'");
        System.out.println("-> Do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)\n");

        for(int i =0; i<10; i++){//we have 10 classes, so 10 repetitions

            System.out.println("Your Classes:");

            for (String element : message) {//I print my classes
                System.out.println(element);
            }
            System.out.println("Please enter the number (e.g. 4 for Song) ");

            String answer = scanner.nextLine();
            while (!counter.contains(answer)||answer.isEmpty()||answer.replaceAll("\\s+", "").isEmpty()){

                System.out.println("Please try again!");
                answer = scanner.nextLine();

            }




            String input;
            if (answer.equals("1")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){//checks if there is a gap
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    person.add(input);

                }

                System.out.println("The names of class 'Person':");
                for (String element : person) {
                    System.out.println(element);
                }

                message.set(0,"");
                counter.set(0,"");

            }

            if (answer.equals("2")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }

                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    band.add(input);

                }

                System.out.println("The names of class 'Band':");
                for (String element : band) {
                    System.out.println(element);
                }

                message.set(1,"");
                counter.set(1,"");

            }

            if (answer.equals("3")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    musicalInstruments.add(input);

                }

                System.out.println("The names of class 'Musical Instruments':");
                for (String element : musicalInstruments) {
                    System.out.println(element);
                }

                message.set(2,"");
                counter.set(2,"");

            }

            if (answer.equals("4")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    song.add(input);

                }

                System.out.println("The names of class 'Song':");
                for (String element : song) {
                    System.out.println(element);
                }

                message.set(3,"");
                counter.set(3,"");

            }

            if (answer.equals("5")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    recording.add(input);

                }

                System.out.println("The names of class 'Recording':");
                for (String element : recording) {
                    System.out.println(element);
                }

                message.set(4,"");
                counter.set(4,"");

            }

            if (answer.equals("6")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){//ελεγχει εαν υπαρχει κενο
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    album.add(input);

                }

                System.out.println("The names of class 'Album':");
                for (String element : album) {
                    System.out.println(element);
                }

                message.set(5,"");
                counter.set(5,"");

            }

            if (answer.equals("7")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){//ελεγχει εαν υπαρχει κενο
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    studio.add(input);

                }

                System.out.println("The names of class 'Studio':");
                for (String element : studio) {
                    System.out.println(element);
                }

                message.set(6,"");
                counter.set(6,"");

            }

            if (answer.equals("8")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    venue.add(input);

                }

                System.out.println("The names of class 'Venue':");
                for (String element : venue) {
                    System.out.println(element);
                }

                message.set(7,"");
                counter.set(7,"");

            }
            if (answer.equals("9")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    label.add(input);

                }

                System.out.println("The names of class 'Label':");
                for (String element : label) {
                    System.out.println(element);
                }

                message.set(8,"");
                counter.set(8,"");
            }

            if (answer.equals("10")){
                System.out.println("Please, enter the names that you want:\n");
                while (!(input = scanner.nextLine()).equals("STOP")){
                    if(input.split("\\s+").length>1){
                        System.out.println("Please do not leave spaces between words. Put '_' instead of a space(e.g. John_Lennon)");
                        continue;
                    }
                    if (input.isEmpty()||input.replaceAll("\\s+", "").isEmpty()) {
                        System.out.println("Please enter a non-empty value.");
                        continue;
                    }
                    year.add(input);

                }

                System.out.println("The names of class 'Year':");
                for (String element : year) {
                    System.out.println(element);
                }

                message.set(9,"");
                counter.set(9,"");


            }

        }
        System.out.println("#################################################");
        System.out.println("Here we have all your statements:\n");

        System.out.print("Person --> ");
        for (String element : person) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Band --> ");
        for (String element : band) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Musical Instruments --> ");
        for (String element : musicalInstruments) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Song --> ");
        for (String element : song) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Recording --> ");
        for (String element : recording) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Album --> ");
        for (String element : album) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Studio --> ");
        for (String element : studio) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Venue --> ");
        for (String element : venue) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Label --> ");
        for (String element : label) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();

        System.out.print("Year --> ");
        for (String element : year) {
            System.out.print(element);
            System.out.print(" | ");
        }
        System.out.println();
        System.out.println("#################################################");


        //We make the RDF model
        Model model = ModelFactory.createDefaultModel();

        //We make the ontology model
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM, model);



        //We make the Classes
        OntClass artistsClass = ontModel.createClass("http://example.org/Artists");
        OntClass personClass = ontModel.createClass("http://example.org/Person");
        OntClass bandClass = ontModel.createClass("http://example.org/Band");
        OntClass musicalInstrumentsClass = ontModel.createClass("http://example.org/Musical_Instraments");
        OntClass songClass = ontModel.createClass("http://example.org/Song");
        OntClass recordingClass = ontModel.createClass("http://example.org/Recording");
        OntClass albumClass = ontModel.createClass("http://example.org/Album");
        OntClass placeClass = ontModel.createClass("http://example.org/Place");
        OntClass studioClass = ontModel.createClass("http://example.org/Studio");
        OntClass venueClass = ontModel.createClass("http://example.org/Venue");
        OntClass labelClass = ontModel.createClass("http://example.org/Label");
        OntClass yearClass = ontModel.createClass("http://example.org/Year");

        //We make the subclasses
        artistsClass.addSubClass(personClass);
        artistsClass.addSubClass(bandClass);

        placeClass.addSubClass(studioClass);
        placeClass.addSubClass(venueClass);


        for (String name : person) {//whatever elements we had in the lists, we passed them to the ontology
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, personClass);
        }
        for (String name : band) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, bandClass);
        }
        for (String name : musicalInstruments) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, musicalInstrumentsClass);
        }
        for (String name : song) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, songClass);
        }
        for (String name : recording) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, recordingClass);
        }
        for (String name : album) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, albumClass);
        }
        for (String name : studio) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, studioClass);
        }
        for (String name : venue) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, venueClass);
        }
        for (String name : label) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, labelClass);
        }
        for (String name : year) {
            String individualURI = "http://example.org/" + name;
            Individual individual = ontModel.createIndividual(individualURI, yearClass);
        }


        //Make the ontology.owl for testing
        try (FileOutputStream outputStream = new FileOutputStream("ontology.owl")) {
            ontModel.write(outputStream, "RDF/XML-ABBREV");
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Ontology saved successfully!!!");

    }

    public static void ontologyProcessing(){

        while (true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("#################################################");

            System.out.println("Let's edit the Ontology!\n");
            System.out.println("Choose an option:");
            System.out.println("1. Make connections");
            System.out.println("2. Add individual");
            System.out.println("3. Remove individual");
            System.out.println("4. Help");
            System.out.println("0. Back");

            String userInput = scanner.nextLine();
            while (!userInput.equals("1") && !userInput.equals("2") && !userInput.equals("3") && !userInput.equals("4") && !userInput.equals("0")){
                System.out.println("Please enter a number (between 0 and 4)");
                userInput = scanner.nextLine();
            }

            if(userInput.equals("1")){
                makeConnections();
            }
            if(userInput.equals("2")){
                addIndividual();
            }
            if(userInput.equals("3")){
                remIndividual();
            }
            if(userInput.equals("4")){
                String helpNumber="2";
                GraphicalUI.helpMessage(helpNumber);
            }
            if(userInput.equals("0")){
                break;
            }

        }
    }

    private static void makeConnections() {
        Scanner scanner = new Scanner(System.in);
        String answer="YES";
        String result;
        String selectedObjectProperty;

        while (answer.equals("YES")){

            System.out.println("Let's make the connections:");
            System.out.println("Enter the first name:");
            String individual1 = scanner.nextLine();
            System.out.println("Enter the second name:");
            String individual2 = scanner.nextLine();
            System.out.println("Choose an Object Property:");

            System.out.println("1. memberOf");
            System.out.println("2. uses");
            System.out.println("3. hasSong");
            System.out.println("4. writerOf");
            System.out.println("5. hasRecording");
            System.out.println("6. hasAlbum");
            System.out.println("7. producerOf");
            System.out.println("8. recorded");
            System.out.println("9. singerOf");
            System.out.println("10. hasLabel");
            System.out.println("11. released");

            ArrayList<String> counter2 = new ArrayList<>();
            counter2.add("1");
            counter2.add("2");
            counter2.add("3");
            counter2.add("4");
            counter2.add("5");
            counter2.add("6");
            counter2.add("7");
            counter2.add("8");
            counter2.add("9");
            counter2.add("10");
            counter2.add("11");

            selectedObjectProperty = scanner.nextLine();
            while (!counter2.contains(selectedObjectProperty)||selectedObjectProperty.isEmpty()||selectedObjectProperty.replaceAll("\\s+", "").isEmpty()){

                System.out.println("Please try again!");
                selectedObjectProperty = scanner.nextLine();

            }
            //---------------------------------------------------------------


            // System.out.println(ontology.result);
            String ontologyFile = "ontology.owl";
            OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
            ontModel.read(ontologyFile);

            //We make objectProperties
            ObjectProperty memberOf = ontModel.createObjectProperty("http://example.org/Member_of");
            ObjectProperty uses = ontModel.createObjectProperty("http://example.org/Uses");
            ObjectProperty hasSong = ontModel.createObjectProperty("http://example.org/Has_song");
            ObjectProperty writerOf = ontModel.createObjectProperty("http://example.org/Writer_of");
            ObjectProperty hasRecording = ontModel.createObjectProperty("http://example.org/Has_recording");
            ObjectProperty hasAlbum = ontModel.createObjectProperty("http://example.org/Has_album");
            ObjectProperty producerOf = ontModel.createObjectProperty("http://example.org/Producer_of");
            ObjectProperty singerOf = ontModel.createObjectProperty("http://example.org/Singer_of");
            ObjectProperty hasLabel = ontModel.createObjectProperty("http://example.org/Has_label");
            ObjectProperty recorded = ontModel.createObjectProperty("http://example.org/Recorded");
            ObjectProperty released = ontModel.createObjectProperty("http://example.org/Released");

            String indi1="http://example.org/"+individual1;
            String indi2="http://example.org/"+individual2;
            Individual name1 = ontModel.getIndividual(indi1);
            Individual name2 = ontModel.getIndividual(indi2);


            // Checking existence as Individuals in ontology
            if (containsIndividual(ontModel, indi1) && containsIndividual(ontModel, indi2)) {

                // Adding Object Property between Individuals
                if (selectedObjectProperty.equals("1")){
                    ontModel.add(name1, memberOf, name2);
                } else if (selectedObjectProperty.equals("2")) {
                    ontModel.add(name1, uses, name2);
                }else if (selectedObjectProperty.equals("3")) {
                    ontModel.add(name1, hasSong, name2);
                }else if (selectedObjectProperty.equals("4")) {
                    ontModel.add(name1, writerOf, name2);
                }else if (selectedObjectProperty.equals("5")) {
                    ontModel.add(name1, hasRecording, name2);
                }else if (selectedObjectProperty.equals("6")) {
                    ontModel.add(name1, hasAlbum, name2);
                }else if (selectedObjectProperty.equals("7")) {
                    ontModel.add(name1, producerOf, name2);
                }else if (selectedObjectProperty.equals("8")) {
                    ontModel.add(name1, recorded, name2);
                }else if (selectedObjectProperty.equals("9")) {
                    ontModel.add(name1, singerOf, name2);
                }else if (selectedObjectProperty.equals("10")) {
                    ontModel.add(name1, hasLabel, name2);
                }else if (selectedObjectProperty.equals("11")) {
                    ontModel.add(name1, released, name2);
                }

                System.out.println("The connection was successful.");

                //Make the ontology.owl
                try (FileOutputStream outputStream = new FileOutputStream("ontology.owl")) {
                    ontModel.write(outputStream, "RDF/XML-ABBREV");
                    System.out.println("OWL model saved successfully.");
                } catch (IOException e) {
                    e.printStackTrace();
                }

            } else {

                System.out.println("One or both names do not exist in the ontology as Individuals.");

            }
            //------------------------------------------------------------------

            System.out.println("Do you want to continue?[Yes/No]");

            answer = scanner.nextLine();
            answer = answer.toUpperCase();
            while (!answer.equals("YES") && !answer.equals("NO")){
                System.out.println("Please enter Yes or No");
                answer = scanner.nextLine();
                answer = answer.toUpperCase();
            }

        }

    }



    private static void addIndividual() {
        Scanner scanner = new Scanner(System.in);
        String classURI;
        String individual1;
        System.out.println("Enter the name of the class:");

        classURI = scanner.nextLine();
        while (classURI.replaceAll("\\s+", "").isEmpty() ||classURI.split("\\s+").length>1){

            System.out.println("Please try again!");
            classURI = scanner.nextLine();
        }

        classURI ="http://example.org/"+classURI;

        // Διαβάζω το URI του Individual
        System.out.println("Enter the name of the new Individual:");
        String individualURI = scanner.nextLine();
        //ελεγχω να μην υπάρχουν κενα αναμεσα στις λεξεις και να υπάρχει οποσδηποτε μια λέξη
        while (individualURI.replaceAll("\\s+", "").isEmpty()||individualURI.split("\\s+").length>1){

            System.out.println("Please try again!");
            individualURI = scanner.nextLine();

        }
        individualURI="http://example.org/"+individualURI;

        individual1 = individualURI;//χρησιμοποιω το individual1 απο πριν

       //-------------------------------------------
        String ontologyFile = "ontology.owl";
        OntModel ontModel = ModelFactory.createOntologyModel();
        ontModel.read(ontologyFile);


        // Εύρεση της κλάσης στο OntModel
        OntClass targetClass = ontModel.getOntClass(classURI);

        // Έλεγχος ύπαρξης της κλάσης
        if (targetClass != null) {
            // Δημιουργία νέου Individual και προσθήκη στην κλάση
            Resource newIndividual = ontModel.createIndividual(individual1, targetClass);
            System.out.println("New Individual added to the class.");

            System.out.println("OWL model saved successfully.");

        } else {
            System.out.println("Class not found in the ontology.");
        }

        // Αποθήκευση των αλλαγών στο αρχείο οντολογίας
        // ontModel.write(System.out, "RDF/XML-ABBREV");

        try (FileOutputStream outputStream = new FileOutputStream("ontology.owl")) {
            ontModel.write(outputStream, "RDF/XML-ABBREV");
            // System.out.println("OWL model saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void remIndividual() {
        String individual1;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the Individual to be removed:");
        individual1 = scanner.nextLine();

        //--------------
        String ontologyFile = "ontology.owl";
        OntModel ontModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM);
        ontModel.read(ontologyFile);


        individual1="http://example.org/"+individual1;

        // Εύρεση του Individual στο OntModel
        Individual individualToRemove = ontModel.getIndividual(individual1);

        // Έλεγχος ύπαρξης
        if (individualToRemove != null) {
            // Κλήση της μεθόδου για αφαίρεση
            removeIndividual(ontModel, individualToRemove);
            System.out.println("Individual and related statements removed successfully.");
            // System.out.println("Individual and related statements removed successfully.");
        } else {
            //System.out.println("Individual not found in the ontology.");
            System.out.println("Individual not found in the ontology.");
        }

        // Αποθήκευση των αλλαγών στο αρχείο οντολογίας
        // ontModel.write(System.out, "RDF/XML-ABBREV");

        //Make the ontology.owl for testing
        try (FileOutputStream outputStream = new FileOutputStream("ontology.owl")) {
            ontModel.write(outputStream, "RDF/XML-ABBREV");
            System.out.println("OWL model saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }



    }

    private static boolean containsIndividual(OntModel ontModel, String name) {
        Individual individual = ontModel.getIndividual(name);
        return individual != null;

    }
    private static void removeIndividual(OntModel ontModel, Individual individualToRemove) {
        // Εύρεση όλων των statements που περιέχουν το συγκεκριμένο Individual
        StmtIterator stmtIterator = ontModel.listStatements(individualToRemove, null, (RDFNode) null);

        // Προσθήκη όλων των statements σε μια λίστα
        List<Statement> statementsToRemove = new ArrayList<>();
        while (stmtIterator.hasNext()) {
            statementsToRemove.add(stmtIterator.next());
        }

        // Καθαρισμός των statements από την οντολογια
        for (Statement statement : statementsToRemove) {
            ontModel.remove(statement);
        }
    }


}
