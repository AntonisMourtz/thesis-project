package org.example;
import javax.swing.*;
import java.awt.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class GraphicalUI {

    public static void informationMassage(){

        JFrame frame = new JFrame("Music Ontology Application");

        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);

        String message = "<html><body style='text-align: center;'>"
                + "<h1>This application was developed by Antonios Mourtzakis</h1>"
                + "<p>It was created as part of his thesis project and aims to create a comprehensive Music Ontology.</p>"
                + "<p>Users can efficiently manage and retrieve a wide range of data related to the music industry.</p>"
                + "<h2>Key Features:</h2>"
                + "<ul style='text-align: left;'>"
                + "<li>Data Integration: Users can input a vast amount of data into the ontology, covering various aspects of the music industry such as artists, albums, genres, and more.</li>"
                + "<li>Relationship Mapping: The application allows users to establish connections between different data points, creating a rich and interconnected web of information.</li>"
                + "<li>Advanced Search Capabilities: Users can perform detailed searches within the ontology to quickly find specific information and uncover valuable insights.</li>"
                + "</ul>"
                + "<p>This tool is designed to support music researchers, industry professionals, and enthusiasts in their quest to explore and understand the vast landscape of music data. By facilitating the organization, integration, and retrieval of music-related information, the application serves as a valuable resource for academic research, industry analysis, and personal interest.</p>"
                + "<p>The user-friendly interface ensures ease of use, while the robust backend supports the handling of large volumes of data. Whether you are looking to map out the connections between different artists, analyze trends within genres, or simply retrieve information on a particular album, this application provides the tools necessary to delve deeply into the music industry.</p>"
                + "</body></html>";

        //We make JLabel to see the text
        JLabel messageLabel = new JLabel(message);
        ImageIcon image = new ImageIcon("logo1.png");
        frame.setIconImage(image.getImage());
        messageLabel.setFont(new Font("Monospaced", Font.PLAIN, 14));
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setVerticalAlignment(SwingConstants.CENTER);
        messageLabel.setOpaque(true);
        messageLabel.setBackground(new Color(50, 50, 50));
        messageLabel.setForeground(Color.WHITE);

        // We add JLabel on JFrame
        frame.add(messageLabel);

        frame.setVisible(true);
    }

    public static void helpMessage(String helpNumber){

        JFrame frame = new JFrame("Music Ontology Application");

        frame.setSize(1000, 600);

        // We read the .txt file
        String message = readTextFromFile("help"+helpNumber+".txt");


        JTextArea textArea = new JTextArea(message);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setBackground(new Color(50, 50, 50));
        textArea.setForeground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane);

        frame.setVisible(true);
    }

    //This Method reads the txt file
    private static String readTextFromFile(String filePath) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content.toString();
    }

}
