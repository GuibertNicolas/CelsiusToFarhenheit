package celsius;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Nicolas GUIBERT
 * Groupe 6
 * convertit les degrés celsius en farhenheit
 */

public class Main {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Convert Celsius to Fahrenheit");
        JPanel panel = new JPanel();
        JTextField celsiusField = new JTextField();
        JButton convertButton = new JButton("Convert");
        JLabel celsius = new JLabel("Celsius");
        JLabel result = new JLabel("Fahrenheit");

        convertButton.addActionListener(new ActionListener() {//on ajoute un listener sur le bouton "Convert"
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp = 0;//température choisie
                int error = 0;//permet de vérifier si c'est un chiffre
                try{
                    temp = Integer.parseInt(celsiusField.getText());//on récupère les chiffres dans le textField
                } catch (Exception except){//Si on a une erreur alors on affiche un message d'aleert
                    JOptionPane jop = new JOptionPane();
                    jop.showMessageDialog(null, "La valeur choisie est incorrecte", "Message d'erreur", JOptionPane.ERROR_MESSAGE);//message d'erreur
                    celsiusField.setText("");//on reset la textField
                    error = 1;//on indique qu'il y à une erreur
                }
                if (error == 0){// si il n'y a pas d'erreur on fait la conversion
                    int far = (int) (temp*1.8) + 32;//calcul pour la conversion 9/5 = 1.8
                    result.setText(far + " Farhenheit");//on affiche le résultat
                }
            }
        });



        panel.add(celsiusField);
        panel.add(celsius);
        panel.add(convertButton);
        panel.add(result);
        panel.setLayout(new GridLayout(2,2));

        frame.add(panel);
        frame.setSize(350,110);
        frame.setLocationRelativeTo(null);//on place la frame au centre de l'écran
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
}
