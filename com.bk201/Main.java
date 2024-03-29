package com.bk201;

import java.util.Random;
import javax.swing.JOptionPane;

public class Main {

    public static void main(String[] args){
        guessing(11);
    }

    public static int userinput() {

        String firstuserinput = JOptionPane.showInputDialog(null,"Geben Sie eine Zahl ein!");

        if (firstuserinput == null){
            JOptionPane.showMessageDialog(null,"Du hast Cancel gedrückt!!!","Error",JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        int seconduserinput= Integer.parseInt(firstuserinput);
        return seconduserinput;
    }



    public static void guessing(int maxguessing){

        JOptionPane.showMessageDialog(null,"Ich denke mir eine Zahl zwischen \n"
                + "1 und 1000. Rate welche!\n"
                + "\n"
                + " Du hast 10 versuche.\n"
                + "     Viel Spaß!");

        int guesstries = 1;
        Random num = new Random();
        int rnum = num.nextInt(1001)+0;

        try{
            while (guesstries < maxguessing) {

                int giveninput = userinput();

                if (rnum == giveninput) {
                    JOptionPane.showMessageDialog(null,giveninput+" Ist Richtig"+"\nDu hast gewonnen!\nGratulation!!!"
                            + "\nDu hast: "+guesstries+" mal geraten.");
                    break;
                }

                if (giveninput > rnum){
                    JOptionPane.showMessageDialog(null,"Dein Tipp: "+giveninput+"\n ist zu groß."
                            + "\nDu hast: "+guesstries+" mal geraten.");

                }else if (giveninput < rnum){
                    JOptionPane.showMessageDialog(null,"Dein Tipp: "+giveninput+"\n ist zu klein."
                            + "\nDu hast: "+guesstries+" mal geraten.");
                }

                guesstries++;

            }
        }catch (Exception e){

            JOptionPane.showMessageDialog(null,"Du kannst nur Zahlen eingeben!!!","Error",JOptionPane.ERROR_MESSAGE);
        }

        if (maxguessing == guesstries){
            JOptionPane.showMessageDialog(null,"Sie haben verloren!");
        }
    }
}

