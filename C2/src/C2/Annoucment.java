/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package C2;

/**
 *
 * @author Willsonowie
 */
import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

public class Annoucment extends JPanel implements Serializable {
    private String message = "Witamy w aplikacji!";  // domyślny komunikat
    private Boolean isOn = false;

    public Annoucment() {
        if (isOn == true) {
            showMessage();
        }
    }

    public void showMessage() {
        
        SwingUtilities.invokeLater(() -> {
            JOptionPane.showMessageDialog(
                SwingUtilities.getWindowAncestor(this),
                message,
                "Powiadomienie",
                JOptionPane.INFORMATION_MESSAGE
            );
        });
    }

    // ===== GETTER i SETTER =====

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
    public void ToggleOnOff(){
        if (isOn != true ) isOn = true;
    }
}

