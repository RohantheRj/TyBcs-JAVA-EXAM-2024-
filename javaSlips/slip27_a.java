import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class CollegeDetailsTable extends JFrame {

    public CollegeDetailsTable() {
        setTitle("College Details Table");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        Object[][] data = {
                {"1", "ABC College", "123 Main St, City1", "2020"},
                {"2", "XYZ College", "456 Elm St, City2", "2018"},
                {"3", "PQR College", "789 Oak St, City3", "2019"},
                {"4", "LMN College", "321 Pine St, City4", "2021"},
                {"5", "EFG College", "654 Maple St, City5", "2017"}
        };


        String[] columnNames = {"CID", "CName", "Address", "Year"};


        DefaultTableModel model = new DefaultTableModel(data, columnNames);


        JTable table = new JTable(model);


        table.setPreferredScrollableViewportSize(new Dimension(500, 300));
        table.setFillsViewportHeight(true);


        JScrollPane scrollPane = new JScrollPane(table);


        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CollegeDetailsTable frame = new CollegeDetailsTable();
            frame.setVisible(true);
        });
    }
}

