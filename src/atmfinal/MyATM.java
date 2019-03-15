
package atmfinal;


public class MyATM 
{

private int cardNumber;    
private int currentBal ;
public int i =0;
String[] transaction = new String[10];


    public MyATM(int cardNumber, int currentBal) {
        this.cardNumber = cardNumber;
        this.currentBal = currentBal;
        
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCurrentBal() {
        return currentBal;
    }

    public void setCurrentBal(int currentBal) {
        this.currentBal = currentBal;
    }


public boolean logIn( int x )
{ 
   
    if (x == cardNumber )
    {
        return true;
    }
    else 
    {
        return false;
    }
    
}

public int viewBalance() {
    
        return currentBal;
}

public void getBalanceHistory ()
{
    transaction[i]="Your balance is "+currentBal;
    i++;
    
}


public void accountWithdraw(int withdrawFunds){
    
    currentBal = currentBal -withdrawFunds;
   transaction[i]="You withdrawed "+withdrawFunds+" .";
        i++;
  
}

public void accountAdd (int depositFunds){
    currentBal = currentBal +depositFunds;
    transaction[i]="You deposited "+depositFunds+" .";
    i++; 
   
  
}


public String[] getHistory()
{
  
    return transaction;
}

public int geti ()
{
    return i;
}


public int getI1()
{
    i++;
    return i;
}


public int getI2()
{
    i--;
    return i;
}

    
}