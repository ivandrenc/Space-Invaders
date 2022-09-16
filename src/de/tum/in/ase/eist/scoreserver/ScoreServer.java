package de.tum.in.ase.eist.scoreserver;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class ScoreServer {
    private ArrayList<String> sessions = new ArrayList<>();
    private final String CSV_FILE_NAME = "GameLogs/ScoreBoard.csv";
    private File csvOutputFile;
    private int session_number;
    private String errorMessage = null;
    private final String delimiter = ",";

    // Constructor populates the array of sessions and saves new session in the database
    public ScoreServer() {
        csvOutputFile = new File(CSV_FILE_NAME);
        try {
            int numEntries = getNumberOfEntriesCSVFile(CSV_FILE_NAME);
            if (numEntries < 0) {
                session_number = 0;
            } else {
                session_number = numEntries + 1;
            }
        } catch (IOException e) {
            errorMessage = e.getMessage();
        }

    }

    public void log(int score, LocalDateTime dateTimePlayed) {
        ScoreEntry scoreEntry = new ScoreEntry(session_number, score, dateTimePlayed.toLocalDate());
        populateSessions(scoreEntry);
    }

    private void populateSessions(ScoreEntry entry) {
        writeToDataBase(convertToCSV(entry));
        readDataBase();
    }

    private void writeToDataBase(String entry) {
        try {
            FileWriter fileWriter = new FileWriter(CSV_FILE_NAME, true);
            fileWriter.write(entry);
            fileWriter.write(System.lineSeparator());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            errorMessage = e.getMessage();
        }
    }

    private String convertToCSV(ScoreEntry entry) {
        StringBuilder data = new StringBuilder();
        data.append(session_number).append(",").append(entry.getScore()).append(",").append(entry.getDateTimePlayed().toString());
        return data.toString();
    }


    private void readDataBase() {
        sessions = new ArrayList<>();
        try {
            FileReader csvFile = new FileReader(csvOutputFile);
            BufferedReader reader = new BufferedReader(csvFile);
            String line = reader.readLine();
            String[] entry;
            StringBuilder joiner = new StringBuilder();
            while(line != null) {
                entry = line.split(delimiter);
                for(String tempStr : entry) {
                    joiner.append(tempStr);
                    joiner.append("                              ");
                }
                sessions.add(joiner.toString());
                joiner = new StringBuilder();
                line = reader.readLine();
            }
            reader.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

    private int getNumberOfEntriesCSVFile(String csvFile) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader(csvFile));
        int count = -1;
        while(bufferedReader.readLine() != null)
        {
            count++;
        }

        return count;
    }

    // prepares list of all sessions of the game
    public void startServer(){
        readDataBase();
    }

    public void stopServer(){
        throw new UnsupportedOperationException();
    }

    // Returns data from the database. If db is empty, returns null
    public ArrayList<String> receiveData(){
        if (errorMessage == null) {
            if (this.sessions == null) {
                return null;
            } else {
                return this.sessions;
            }
        } else {
            ArrayList<String> content = new ArrayList<>();
            content.add(errorMessage);
            return content;
        }
    }

    // TODO: Show the data from this.sessions in some way, maybe as a new pop up window (?)
    public void printData(){

    }
}
