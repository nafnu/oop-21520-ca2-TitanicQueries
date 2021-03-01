package com.jetbrains;
import com.jetbrains.models.Passenger;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.List;

public class TitanicListing extends JFrame {

//    private PreparedStatement getSurvivalByStatus;

    public TitanicListing() {

        String[] columns = new String[]{
                "name", "gender", "age"
        };

        DefaultTableModel model = new DefaultTableModel();

        model.setColumnIdentifiers(columns);

        JTable table = new JTable(model);
        TitanicQueries tq = new TitanicQueries();

        // List<Passenger> passengers = tq.getPeopleByName("peter");
        // List<Passenger> passengers = tq.getPeopleByGender("female");
        // List<Passenger> passengers = tq.getPeopleByAge(35);
        List<Passenger> passengers = tq.getPeopleByNameAndGender("peter", "female");


        for(Passenger p : passengers) {

            model.addRow(new Object[]{p.name, p.gender, p.age});
        }



        this.add(new JScrollPane(table));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);



    }
}