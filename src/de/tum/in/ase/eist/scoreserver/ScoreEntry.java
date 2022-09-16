package de.tum.in.ase.eist.scoreserver;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ScoreEntry {
    private int session_number;
    private int score;
    private LocalDate dateTimePlayed;

    public ScoreEntry(int session_number, int score, LocalDate dateTimePlayed) {
        this.session_number = session_number;
        this.score = score;
        this.dateTimePlayed = dateTimePlayed;
    }

    public int getSession_number() {
        return session_number;
    }

    public int getScore() {
        return score;
    }

    public LocalDate getDateTimePlayed() {
        return dateTimePlayed;
    }
}
