import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import static java.util.Arrays.sort;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.sql.SQLException;


public class DBSql {
    private Connection connection;
    private Statement stmt;
    private Statement stmt1;

    DBSql() {

        connection = null;
        stmt = null;
        try {
            String url = "jdbc:sqlite:C://Users//effer//Ny mappe//Studerendefag.db";

            connection = DriverManager.getConnection(url);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Studerende> getAllStudents() throws SQLException {
        ArrayList<Studerende> listOfStudents = null;
        String sql = "select * from studerende";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        listOfStudents = new ArrayList<Studerende>();
        while (rs.next()) {
            Studerende student = new Studerende(rs.getInt("stdnr"), rs.getString("fnavn"),
                    rs.getString("enavn"), rs.getString("adr"), rs.getString("postnr"),
                    rs.getString("mobil"), rs.getString("klasse"));

            listOfStudents.add(student);
        }
        stmt.close();
        return listOfStudents;

    }

    public void alleFag() {
        try {
            String sql = "select * from Fag";
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            while (rs.next()) {
                System.out.println(rs.getInt("fagid"));
                System.out.println(rs.getString("fagnavn"));

            }
            stmt.close();
        } catch (
                SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public ArrayList<Fag> getAllFag() throws SQLException {

        ArrayList<Fag> listOfFag = null;
        String sql = "select * from Fag";
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        listOfFag = new ArrayList<Fag>();
        while (rs.next()) {
            Fag fagVar = new Fag(rs.getInt("fagnr"), rs.getString("fagnavn"));
            listOfFag.add(fagVar);
        }
        stmt.close();
        return listOfFag;
    }


    public void opretStuderende(Studerende s) {
        try {
            // String sql = "INSERT INTO studerende(stdnr,fnavn,enavn,adr,postnr,mobil,klasse)";

            //ql+= "VALUES("+String.valueOf(s.getStdNr())+",'"+s.getfNavn()+"´,´"+s.geteNavn()+"','"+s.getAdresse()+"´,´"+s.getAdresse()+"´,´"+s.getMobil()+"´,´"+s.getKlasse()+"')";
            String sql = "INSERT INTO studerende(stdnr,fnavn,enavn,adr,postnr,Klasse,mobil)";
            sql += "VALUES(" + String.valueOf(s.getStdNr()) + ",'" + s.getfNavn() + "','" + s.geteNavn() + "','" + s.getAdresse() + "','" + s.getPostNr() + "','" + s.getKlasse() + "','" + s.getMobil() + "')";

            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void opretFag(Fag f) {
        try {
            String sql = "INSERT INTO fag(fagid,fagnavn)";
            sql += "VALUES(" + String.valueOf(f.getFagid()) + ",'" + f.getFagnavn() + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void tilmeldStuderendeFag(int id, Studerende s, Fag f, String kar) {
        try {
            String sql = "INSERT INTO studfag(id,stdnr,fagid,kar)";
            sql += "VALUES(" + String.valueOf(id) + ",'" + String.valueOf(s.getStdNr()) + "','" + String.valueOf(f.getFagid()) + "','" + kar + "')";
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void frameldFag(int id) {
        try {
            String sql = "DELETE FROM studfag WHERE id = " + String.valueOf(id);
            Statement stmt = connection.createStatement();
            stmt.execute(sql);
            System.out.println("Connection to SQLite has been established.");
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Studerende soegStamStud(int stdNr) throws SQLException {
        String sql = "select * from studerende WHERE stdnr = " + String.valueOf(stdNr);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Studerende student = new Studerende(rs.getInt("stdnr"), rs.getString("fnavn"), rs.getString("enavn"), rs.getString("adr"), rs.getString("postnr"), rs.getString("mobil"), rs.getString("klasse"));
        stmt.close();
        return student;
    }

    public ArrayList<StudFag> soegStud(int stdNr) {
        ArrayList<StudFag> fag = new ArrayList<>();
        String sql = "SELECT * FROM studfag WHERE stdnr = " + String.valueOf(stdNr);
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                StudFag fagOpl = new StudFag();
                fagOpl.setFagNr(rs.getInt("fagid"));
                fagOpl.setKar(rs.getInt("kar"));
                fag.add(fagOpl);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return fag;
    }

    /*public ArrayList<StudFag> soegStud(int stdNr) {
        ArrayList<StudFag> fag = null;
        String sql = "SELECT * FROM studfag WHERE stdnr = " + String.valueOf(stdNr);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        fag = new ArrayList<StudFag>();

            if (rs.next()) {
                StudFag fagOpl = new StudFag();
                fagOpl.setFagNr(rs.getInt("fagid"));
                fag.add(fagOpl);
            }

        }
        return fag;
    }

     */

    public ArrayList<Studerende> soegPostnummer(String postNr) throws SQLException {
        // 4. Alle studerende med et givet postnummer
        ArrayList<Studerende> findStudentWithPost = null;

        String sql = "SELECT * FROM studerende where postnr =" + postNr;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        findStudentWithPost = new ArrayList<Studerende>();

        while (rs.next()) {
            Studerende studentPost = new Studerende(rs.getInt("stdnr"), rs.getString("postnr"));
            findStudentWithPost.add(studentPost);
        }
        stmt.close();
        return findStudentWithPost;
    }

    public ArrayList<Studerende> soegKlasse(String klasse) throws SQLException {
        ArrayList<Studerende> klasser = new ArrayList<>();
        String sql = "SELECT * FROM studerende WHERE Klasse = " + klasse;
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Studerende s = new Studerende(rs.getInt("stdnr"), rs.getString("fnavn"), rs.getString("enavn"), rs.getString("adr"), rs.getString("postnr"), rs.getString("mobil"), rs.getString("Klasse"));
                klasser.add(s);
            }
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return klasser;
    }

     public ArrayList<Studerende> alfabetisk() throws SQLException {
            // 6.	Alle studerende i alfabetisk orden efter fnavn
         ArrayList<Studerende> findStudentWithPost = null;

         String sql = "SELECT * FROM studerende";
         Statement stmt = connection.createStatement();
         ResultSet rs = stmt.executeQuery(sql);
         ArrayList<Studerende> navne = new ArrayList<Studerende>();
            while(rs.next()) {
                Studerende s = new Studerende (rs.getString("fnavn"));
                navne.add(s);
        }
         Collections.sort(navne, Comparator.comparing(Studerende::getfNavn));
            return navne;
    }









    /*public Studerende soegStud(int stdNr) throws SQLException{
        String sql = "select * from studerende WHERE stdnr = " + String.valueOf(stdNr);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Studerende student = new Studerende(rs.getInt("stdnr"), rs.getString("fnavn"), rs.getString("enavn"), rs.getString("adr"), rs.getString("postnr"), rs.getString("mobil"), rs.getString("klasse"));
        stmt.close();
        return student;
    }*/

    /*public void soegStud(int stdNr) {
        try {
            //String sql = "SELECT * FROM studerende WHERE stdnr = " + String.valueOf(stdNr);
            String sql = "SELECT * FROM studerende s JOIN studfag sf ON s.stdnr = sf.stdnr WHERE sf.stdnr = " + String.valueOf(stdNr);

            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            System.out.println("Student ID: " + rs.getInt("stdnr"));
            System.out.println("First Name: " + rs.getString("fnavn"));
            System.out.println("Last Name: " + rs.getString("enavn"));
            System.out.println("Address: " + rs.getString("adr"));
            System.out.println("Postal Code: " + rs.getInt("postnr"));
            System.out.println("Mobile: " + rs.getInt("mobil"));
            System.out.println("Class: " + rs.getString("klasse"));
            while (rs.next()) {
                System.out.println("Fag: " + rs.getString("fagid") + " Karakter: " + rs.getString("kar"));
            }
            System.out.println();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }*/

   /* public void soegFag(int fagNr) {
        try {
            //String sql = "SELECT * FROM Fag f JOIN studfag sf ON f.fagid = sf.stdnr WHERE sf.stdnr = " + String.valueOf(fagNr);
            String sql = "SELECT * FROM Fag f JOIN studfag sf ON f.fagid = sf.fagid WHERE sf.fagid = " + fagNr;
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            System.out.println("Connection to SQLite has been established.");
            System.out.println("Fag ID: " + rs.getInt("fagid"));
            System.out.println("Fag navn: " + rs.getString("fagnavn"));
            while (rs.next()) {
                System.out.println("studerende: " + rs.getString("stdnr"));
            }
            System.out.println();
            stmt.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    */

   /* public Fag soegFagTilInfo (int fagNr) throws SQLException{
        String sql = "select * from fag WHERE fagid = " + String.valueOf(fagNr);
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        Fag fagTilInfo = new Fag(rs.getInt("fagid"),rs.getString("fagnavn"));
        while(rs.next()) {
            rs.getInt("stdnr");
        }
        stmt.close();
        return fagTilInfo;
    }

    */

    public ArrayList<Fag> soegFagTilInfo(int fagNr) throws SQLException {
        ArrayList<Fag> fagInfoListe = null;

        String sql = "SELECT * FROM Fag f JOIN studfag sf ON f.fagnr = sf.fagid WHERE sf.fagid = " + fagNr;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        fagInfoListe = new ArrayList<Fag>();
        // Fag fagInfo = new Fag(rs.getInt("fagnr"), rs.getString("fagnavn"));
        if (rs.next()) {

            Fag f = new Fag(rs.getInt("fagnr"), rs.getString("fagnavn"), rs.getInt("stdnr"));
            fagInfoListe.add(f);
        }
        stmt.close();
        return fagInfoListe;

    }
//opg 7
   public ArrayList<Studerende> soegklasseogpostnr(String klasse, String postNr) throws  SQLException{
        ArrayList<Studerende> returnstud = null;
        String sql = "SELECT * FROM Studerende WHERE Klasse =" + klasse + postNr;
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        returnstud = new ArrayList<>();
                if(rs.next()){
                Studerende s = new Studerende(rs.getString("Klasse"), String.valueOf(postNr));
                returnstud.add(s);
                }
             stmt.close();
                return returnstud;
    }



}
