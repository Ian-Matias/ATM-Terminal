import javax.swing.*;
import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;

public class ATM{

    String cardNum, firstName, lastName, id = "",debitCardNum,enterInput = "";
    int pin, userPin, userId, option = 0, click = 0;
    double moneyInBank;

    Locale usa = new Locale("en", "US");
    // Create a Currency instance for the Locale
    Currency dollars = Currency.getInstance(usa);
    // Create a formatter given the Locale
    NumberFormat dollarFormat = NumberFormat.getCurrencyInstance(usa);
    BufferedReader input = new BufferedReader(
            new InputStreamReader(System.in));

    JFrame frame;
    JPanel mainPanel;
    JTextArea textArea;
    JTextField inputTextField;
    Font myFont = new Font("Int Free", Font.BOLD, 14);

    JButton  depositButton, withdrawButton, balanceButton, enterButton;

    public ATM(String cardNum, String firstName, String lastName, int pin,
        double moneyInBank)
    {
        this.cardNum = cardNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.moneyInBank = moneyInBank;

    }

    ATM() {
        frame = new JFrame("Forsa Atm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 310);
        frame.setLayout(null);

        textArea = new JTextArea();
        textArea.setBounds(140, 50, 400, 200);
        textArea.setFont(myFont);
        textArea.setEditable(false);
        textArea.setFocusable(false);

        inputTextField = new JTextField();
        inputTextField.setBounds(210,270,250,25);
        inputTextField.setFont(myFont);
        inputTextField.setFocusable(true);
       // inputTextField.setBackground(Color.black);

        mainPanel = new JPanel(new BorderLayout());

        withdrawButton = new JButton("Withdraw");
        depositButton = new JButton("Deposit");
        balanceButton = new JButton("Balance");
        enterButton = new JButton("Enter");
        //enterButton.addActionListener(this);


        enterButton.setBounds(450,300,100,100);
        //enterButton.setBackground(Color.black);

        balanceButton.setBounds(20,25,0,25);
        withdrawButton.setBounds(20,25,0,25);
        depositButton.setBounds(20,25,0,25);

        frame.setLocationRelativeTo(null);//Setting location to the center of screen
        frame.setVisible(true);

    }

    public String getNum()
    {
        return cardNum;
    }

    public int getPin()
    {
        return pin;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public double getMoneyInBank()
    {
        return moneyInBank;
    }

    public Double deposit(Double deposit, Double balance)  {

        if(deposit < 1.00)
        {
            JOptionPane.showMessageDialog(frame,"\n" + "Insufficient deposit");
        }
        else {

            JOptionPane.showMessageDialog(frame,"\n" + "Transaction underway...");
            return balance + deposit;
        }

          return  balance;
    }

    public Double withdraw(Double x, Double y) {

        if(x > y)
        {
            JOptionPane.showMessageDialog(frame,"\n" + "Insufficient Balance");
        }
        else {
            JOptionPane.showMessageDialog(frame,"\n" + "Transaction underway...");
            return y - x;
        }

       return y;
    }

    public Double balance(Double balance) {

        return balance;
    }



    public void printOptions(String name) {
        inputTextField.setText("\n" + "Hello," + name + ":\n" +
                " Choose from the following options.." + "\n" +
                "1. Deposit" + "\n" + "2. Withdraw" + "\n" +
                "3. Show Balance" + "\n" + "4.Exit" + "\n" );
    }

    public boolean isNumber(String str)
    {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }



    List<CardHolder> cards;

    {
        cards = new LinkedList<CardHolder>();
    }






    public static void main(String[] args)
            throws IOException {

        new SplashScreen();


        List<CardHolder> cards;

        {
            cards = new LinkedList<>();
        }


        cards.add(new CardHolder("93", "John", "V", 123,
                400.54));
        cards.add(new CardHolder("49", "Ms", "D", 234,
                400.54));
        cards.add(new CardHolder("98", "Juan", "D", 345,
                402.54));

        ATM atm = new ATM(cards.get(0).getNum(), cards.get(0).getFirstName(), cards.get(0).getLastName(),
                cards.get(0).pin, cards.get(0).getMoneyInBank());

        ATM atm1 = new ATM();


        atm1.balanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == atm1.balanceButton)
                {
                    JOptionPane.showMessageDialog(atm1.frame,"Balance: $"+atm.balance(cards.get(atm.userId).getMoneyInBank()) +"\n");

                }


            }
        });

//Not accepting icon parameter on JOptionPane
//ImageIcon icon = new ImageIcon("src/images/icon.jpg");

      //  Verify Card Number
                   while (true) {


                       do{

                           atm.debitCardNum = (JOptionPane.showInputDialog(atm1.frame,"Welcome to Forsa ATM" + "\n" + "Please insert your debit card: ", "Forsa ATM", JOptionPane.PLAIN_MESSAGE));
                           atm1.textArea.setText("Welcome to Forsa ATM" + "\n" + "Please insert your debit card: ");

                           if(!atm.isNumber(atm.debitCardNum))
                           {
                               JOptionPane.showMessageDialog(atm1.frame,"\n" + "Not Number!");
                           }

                       } while (!atm.isNumber(atm.debitCardNum));

                        if (atm.debitCardNum.equals(cards.get(0).getNum())) {

                            atm.id = cards.get(0).getFirstName();
                            System.out.println(atm.id);
                            JOptionPane.showMessageDialog(atm1.frame,"Hello, " + atm.id);
                            atm.userId = 0;
                            break;
                        } else if (atm.debitCardNum.equals(cards.get(1).getNum())) {
                            atm.id = cards.get(1).getFirstName();
                            System.out.println(atm.id);
                            JOptionPane.showMessageDialog(atm1.frame,"Hello, " + atm.id);
                            atm.userId = 1;
                            break;
                        } else if (atm.debitCardNum.equals(cards.get(2).getNum())) {
                            atm.id = cards.get(2).getFirstName();
                            System.out.println(atm.id);
                            JOptionPane.showMessageDialog(atm1.frame,"Hello, " + atm.id);
                            atm.userId = 2;
                            break;
                        } else {
                            atm1.textArea.setText("Card not recognized. Please try again" + "\n");
                            JOptionPane.showMessageDialog(atm1.frame, "Card not recognized. Please try again" + "\n");
                        }

                    }








        //Verify Pin associated with account
            while (true) {
                String pane;
                do {
                    pane = JOptionPane.showInputDialog(atm1.frame, "Please enter your pin: ");

                    if(!atm.isNumber(pane))
                    {
                        JOptionPane.showMessageDialog(atm1.frame,"\n" + "Not Number!");
                    }

                }while(!atm.isNumber(pane));

                atm.userPin = Integer.parseInt(pane);

                        if (atm.userPin == cards.get(0).getPin() && atm.userId == 0) {

                            break;
                        } else if (atm.userPin == cards.get(1).getPin() && atm.userId == 1) {

                            break;
                        } else if (atm.userPin == cards.get(2).getPin() && atm.userId == 2) {

                            break;
                        } else {
                            JOptionPane.showMessageDialog(atm1.frame,"Incorrect pin. Please try again" + "\n");

                        }
                    }





        //User's atm  decision
                    do {

                        String pane;


                      do{
                          pane = (JOptionPane.showInputDialog(atm1.frame,"\n" + "Hello," + cards.get(atm.userId).firstName + ":\n" +
                                  " Choose from the following options.." + "\n" +
                                  "1. Deposit" + "\n" + "2. Withdraw" + "\n" +
                                  "3. Show Balance" + "\n" + "4.Exit" + "\n"));

                          if(!atm.isNumber(pane))
                          {
                              JOptionPane.showMessageDialog(atm1.frame,"\n" + "Not Number!");
                          }

                          else if(Integer.parseInt(pane) < 0 || Integer.parseInt(pane) > 4)
                          {
                              JOptionPane.showMessageDialog(atm1.frame,"\n" + "Not an option!");
                          }
                      } while (!atm.isNumber(pane) || Integer.parseInt(pane) < 0 || Integer.parseInt(pane) > 4);

                        atm.option = Integer.parseInt(pane);

                        if (atm.option == 1) {

                            Double deposit = Double.parseDouble(JOptionPane.showInputDialog(atm1.frame,"How much would you like to deposit? "));
                            cards.get(atm.userId).setMoneyInBank(atm.deposit(deposit, cards.get(atm.userId).getMoneyInBank()));

                        }
                        else if (atm.option == 2) {

                            Double withdraw = Double.parseDouble(JOptionPane.showInputDialog(atm1.frame,"How much would you like to withdraw?"));
                            cards.get(atm.userId).setMoneyInBank(atm.withdraw(withdraw, cards.get(atm.userId).getMoneyInBank()));


                        }
                        else if (atm.option == 3) {

                            atm.balance(cards.get(atm.userId).getMoneyInBank());
                            JOptionPane.showMessageDialog(atm1.frame,"Current balance is: " + atm.dollarFormat.format(atm.balance(cards.get(atm.userId).getMoneyInBank())) );
                        }
                        else if (atm.option == 4) {

                            break;
                        }

                        else {

                            atm.option = 0;
                        }
                    }
                    while(atm.option != 4);
                    JOptionPane.showMessageDialog(atm1.frame,"\n" + "Thank you. Have a nice day!");
                    atm1.frame.dispose();









    }




}





