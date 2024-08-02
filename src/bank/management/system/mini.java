package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini extends JFrame implements ActionListener {
    JButton button;
    String pin;
    mini(String pin){
        this.pin=pin;
        getContentPane().setBackground(new Color(255,204,204));
        setSize(400,600);
        setVisible(true);
        setLocation(20,20);
        setLayout(null);

        JLabel label1=new JLabel();
        label1.setBounds(20,140,400,200);
        add(label1);
        JLabel label2=new JLabel("NITIN BISHT");
        label2.setFont(new Font("Raleway",Font.BOLD,15));
        label2.setBounds(150,20,200,20);
        add(label2);

        JLabel label3=new JLabel();
        label3.setBounds(20,80,300,20);
        add(label3);

        JLabel label4=new JLabel();
        label4.setBounds(20,400,300,20);
        add(label4);

        try {
            con c=new con();

            ResultSet resultSet=c.statement.executeQuery("select * from login where pin='"+pin+"'");
            while (resultSet.next()){
                label3.setText("Card Number: "+resultSet.getString("Card_No").substring(0,4) +"xxxxxxxxxxxx"+resultSet.getString("Card_No").substring(12) );
            }


        }catch (Exception e){
            e.printStackTrace();
        }
        try {

            int balence=0;
            con c=new con();
            ResultSet resultSet=c.statement.executeQuery("select * from bank where pin+'"+pin+"'");
            while (resultSet.next()) {
                label1.setText(label1.getText() + "<html>"+resultSet.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+resultSet.getString("amount")+ "<br><br><html>");
                if (resultSet.getString("type").equals("Deposit")) {
                    balence += Integer.parseInt(resultSet.getString("amount"));
                } else {
                    balence += Integer.parseInt(resultSet.getString("amount"));
                }
            }
            label4.setText("Your total balence is Rs "+balence);
        }catch (Exception E){
            E.printStackTrace();
        }

        button=new JButton("Exit");
        button.setBounds(20,500,100,25);
        button.addActionListener(this);
        button.setForeground(Color.BLACK);
        button.setForeground(Color.WHITE);
        add(button);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        setVisible(false);

    }

    public static void main(String[] args) {
        new mini("");

    }
}
