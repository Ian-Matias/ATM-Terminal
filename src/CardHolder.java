import javax.swing.*;
import java.util.*;
import java.util.function.Supplier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class CardHolder {


    String cardNum, firstName, lastName;
    int pin;
    double moneyInBank;


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

    public void setNum(String newCardNum)
    {
        cardNum = newCardNum;
    }

    public void setPin(int newPin)
    {
        pin = newPin;
    }

    public void setFirstName(String newFirstName)
    {
        firstName= newFirstName;
    }

    public void setLastName(String newLastName)
    {
        lastName= newLastName;
    }

    public void setMoneyInBank(double newMoneyInBank)
    {
        moneyInBank = newMoneyInBank;
    }

    public CardHolder(String cardNum, String firstName, String lastName, int pin,
                      double moneyInBank)
    {
        this.cardNum = cardNum;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pin = pin;
        this.moneyInBank = moneyInBank;

    }



     List<CardHolder> cards;

    {
        cards = new LinkedList<CardHolder>();
    }

    public void users (){
        cards.add(new CardHolder("93","John","V", 1234,
                400.54));
        cards.add(new CardHolder("47","Ms","D", 1234,
                400.54));
        cards.add(new CardHolder("98","Juan","D", 1234,
                400.54));
    }






}
