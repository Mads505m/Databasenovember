import java.sql.SQLException;
import java.sql.*;
import java.util.Scanner;
import java.io.File.*;
import java.util.ArrayList;

public class Main {

    public static void main(String [] args) throws SQLException {
        Scanner scan = new Scanner(System.in);
        DBSql db = new DBSql();
        Studerende s = new Studerende(14,"Jenss", "Petersens", "Pedersvej 100", "4700", "01923023","A");
        Fag f = new Fag(6, "Huggosprog");
        //db.alleStuderende();
        //db.alleFag();
        System.out.println("1. Opret studerende: ");
        System.out.println("2. Opret fag");
        System.out.println("3. Tilmeld studerende til fag");
        System.out.println("4. Frameld studerende til fag");
        System.out.println("5. Udskriv alle studerende");
        System.out.println("6. Udskriv alle fag");
        System.out.println("7. Søg stam oplysninger om studerende");
        System.out.println("8. Søg alle oplysninger om studerende");
        System.out.println("9. Søg oplysninger om et fag");
        System.out.println("10. find studerende med given postnummer");
        System.out.println("11. Søg efter en klasse");
        System.out.println("12. ");
        System.out.println("13. sorter efter fornavn");
        System.out.println("Indtast valg:");
        int valg = scan.nextInt();
        switch (valg) {
            case 1:
                System.out.println("Oplys studienummer, fornavn, efternavn, adresse, postnummer, mobil og klasse");
                db.opretStuderende(s);
                break;

            case 2:
                System.out.println("Oplys fagnummer og fag navn");
                db.opretFag(f);
                break;

            case 3:
                System.out.println("Oplys id, studerende, fag og karakter");
                db.tilmeldStuderendeFag(12, s, f, "10");
                break;

            case 4:
                System.out.println("Oplys id: ");
                db.frameldFag(13);
                break;

            case 5:
                ArrayList<Studerende> studentList = db.getAllStudents();
                for (Studerende student : studentList) {
                    System.out.println(student);
                }
                break;

            case 6:
                ArrayList<Fag> fagListe = db.getAllFag();
                for (Fag fagVar : fagListe) {
                    System.out.println(fagVar);
                }
                break;

            case 7:
                System.out.println("Oplys studienummer");
                System.out.println(db.soegStamStud(scan.nextInt()));
                break;

            case 8:
                System.out.println("Oplys studienummer");
                int sNr = scan.nextInt();
                System.out.println(db.soegStamStud(sNr));
                System.out.println(db.soegStud(sNr));
                break;

            case 9:
                System.out.println("Oplys fagnummer");
                System.out.println(db.soegFagTilInfo(scan.nextInt()));
                break;

            case 10:
                System.out.println("Oplys postnummer");
                System.out.println(db.soegPostnummer(scan.next()));
                break;

            case 11:
                System.out.println("Oplys klasse");
                System.out.println(db.soegKlasse(scan.next()));
                /*ArrayList<Studerende> klasseListe = db.soegKlasse(scan.next());
                for (Studerende stud : klasseListe) {
                    System.out.println(stud);
                }*/
                break;

            case 12:
                System.out.println("Oplys klasse og postnr");
               System.out.println(db.soegklasseogpostnr(scan.next(),scan.next()));
                break;

            case 13:
                System.out.println(db.alfabetisk());
                break;
        }
    }
}