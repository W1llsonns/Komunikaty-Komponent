package C2;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Annoucment extends JPanel implements Serializable {
    private String[] welcomeMessages = {
        "Witaj w naszej aplikacji. Wprowadź liczby, aby dokonać obliczeń.",  // PL
        "Welcome to our app. Please, insert values to make calculations.",    // EN
        "Willkommen bei unserer Anwendung. Geben Sie Zahlen ein, um Berechnungen durchzuführen.",  // DE
        "Witéjce w najô aplikacji. Wprowadzta liczbë, é wëkònajce rechòwanié." // CSB
    };

    private String[] goodbyeMessages = {
        "Dziękujemy za skorzystanie z aplikacji!",  // PL
        "Thank you for using the application!",     // EN
        "Danke für die Nutzung der Anwendung!",     // DE
        "Dziękùjã za brëkòwanié aplikacji!"         // CSB
    };

    private String[] errorMessages = {
        "Błąd. Niedozwolone dzielenie przez 0!",     // PL
        "Error. Dividing by 0 is not allowed!",      // EN
        "Fehler. Eine Division durch 0 ist nicht zulässig!", // DE
        "Błąd. Niedozwòlony dzelenié z nulã."        // CSB
    };

    private String welcomeMessage;
    private String goodbyeMessage;
    private String divisionMessage;
    private boolean isOn = true;
    private String language = "Kaszubski";

    public Annoucment() {
        // domyślnie język kaszubski, indeks 3
        setLanguage("Kaszubski");
    }

    public void showMessage(String message) {
        if (!isOn) return;

        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(
                SwingUtilities.getWindowAncestor(this),
                message,
                "Powiadomienie",
                JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    // === GETTERY I SETTERY ===

    public String[] getWelcomeMessages() {
        return welcomeMessages;
    }

    public void setWelcomeMessages(String[] welcomeMessages) {
        this.welcomeMessages = welcomeMessages;
    }

    public String[] getGoodbyeMessages() {
        return goodbyeMessages;
    }

    public void setGoodbyeMessages(String[] goodbyeMessages) {
        this.goodbyeMessages = goodbyeMessages;
    }

    public String[] getErrorMessages() {
        return errorMessages;
    }

    public void setErrorMessages(String[] errorMessages) {
        this.errorMessages = errorMessages;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getGoodbyeMessage() {
        return goodbyeMessage;
    }

    public void setGoodbyeMessage(String goodbyeMessage) {
        this.goodbyeMessage = goodbyeMessage;
    }

    public String getDivisionMessage() {
        return divisionMessage;
    }

    public void setDivisionMessage(String divisionMessage) {
        this.divisionMessage = divisionMessage;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setOn(boolean on) {
        isOn = on;
    }

    public String getLanguage() {
        return language;
    }

    // Obsługa zmiany języka (PL, EN, DE, CSB)
    public void setLanguage(String language) {
        this.language = language;

        switch (language.toLowerCase()) {
            case "polski":
                welcomeMessage = welcomeMessages[0];
                goodbyeMessage = goodbyeMessages[0];
                divisionMessage = errorMessages[0];
                break;
            case "angielski":
                welcomeMessage = welcomeMessages[1];
                goodbyeMessage = goodbyeMessages[1];
                divisionMessage = errorMessages[1];
                break;
            case "niemiecki":
                welcomeMessage = welcomeMessages[2];
                goodbyeMessage = goodbyeMessages[2];
                divisionMessage = errorMessages[2];
                break;
            case "kaszubski":
            default:
                welcomeMessage = welcomeMessages[3];
                goodbyeMessage = goodbyeMessages[3];
                divisionMessage = errorMessages[3];
                break;
        }
    }

    public void toggleOnOff() {
        isOn = !isOn;
    }
}
