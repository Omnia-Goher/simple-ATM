
package atmfinal;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ATMfinal extends Application  //implements EventHandler<ActionEvent> 
{
    MyATM atm = new MyATM (112233,0);
    Error error = new Error();
    Stage window;
    Scene scene1, scene2,scene3,scene4;
    String[] arr = atm.getHistory();
    
    public static void main(String[] args) {
        
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        window = primaryStage;
        
        
        //Gridpane
        GridPane grid = new GridPane();
        GridPane grid1 = new GridPane();
        GridPane grid2 = new GridPane();
        GridPane grid3 = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid1.setPadding(new Insets(10, 10, 10, 10));
        grid2.setPadding(new Insets(10, 10, 10, 10));
        grid3.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(15);
        grid.setHgap(15);
        grid1.setVgap(15);
        grid1.setHgap(15);
        grid2.setVgap(15);
        grid2.setHgap(15);
        grid3.setVgap(15);
        grid3.setHgap(15);
        
                         //User Inteface//
                       
       
 
        //Card Label
        Label cardLabel = new Label(" Card Number : ");
        GridPane.setConstraints(cardLabel, 2, 10);
        
        //Card Input
        TextField cardInput = new TextField();
        cardInput.getStyleClass().add("TextField");
        GridPane.setConstraints(cardInput, 4,10);

        //log in Button 
        Button button1 = new Button("      Log In     ");
        button1.setOnAction(e -> {
            int cardNumber = Integer.parseInt(cardInput.getText());
            boolean check =atm.logIn(cardNumber);
            if (check)
                {
                    window.setScene(scene2);
                    cardInput.setText("");
                }
            else 
            {
                 error.display("   Invailed Log In !!  ");
                    cardInput.setText("");
            }
        });
       // GridPane.setConstraints(button1, 12, 25);
          GridPane.setConstraints(button1, 7, 25);
        
        //Button to clear
        Button clearButton = new Button ("      Delete All     ");
        clearButton.setOnAction(e -> {
            cardInput.clear();
        });
        GridPane.setConstraints(clearButton, 7, 19);
       
        
        
        // numbers keypad
        Button num1 = new Button ("             1            ");
        num1.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"1");
        });
        GridPane.setConstraints(num1, 5, 16);
        Button num2 = new Button ("             2            ");
        num2.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"2");
        });
        GridPane.setConstraints(num2, 6,16);
        Button num3 = new Button ("             3            ");
        num3.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"3");
        });
        GridPane.setConstraints(num3, 7,16);
        Button num4 = new Button ("             4            ");
        num4.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"4");
        });
        GridPane.setConstraints(num4, 5,17);
        Button num5 = new Button ("             5            ");
        num5.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"5");
        });
        GridPane.setConstraints(num5, 6, 17);
        Button num6 = new Button ("             6            ");
        num6.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"6");
        });
        GridPane.setConstraints(num6, 7, 17);
        Button num7 = new Button ("             7            ");
        num7.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"7");
        });
        GridPane.setConstraints(num7, 5, 18);
        Button num8 = new Button ("             8            ");
        num8.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"8");
        });
        GridPane.setConstraints(num8, 6, 18);
        Button num9 = new Button ("             9            ");
        num9.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"9");
        });
        GridPane.setConstraints(num9, 7, 18);
        Button num0 = new Button ("             0            ");
        num0.setOnAction(e -> {
            cardInput.setText(cardInput.getText()+"0");

        });
        GridPane.setConstraints(num0, 6, 19);
      
       
        //screen1
        
        grid.getChildren().addAll(cardLabel,cardInput, button1 , clearButton , num1 , num2 
        ,num3 , num4 , num5 , num6 , num7 , num8 ,num9 ,num0);
        
        scene1 = new Scene(grid, 1200, 800);
     
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       ///Home Screen
       
         //Title
         Label label2 = new Label(" Transactions ");
         GridPane.setConstraints(label2, 19,7);
        
         
          ///deposite
         Button depositeB = new Button ("        Deposite      ");
         depositeB.setOnAction(e -> {
             window.setScene(scene3);   
       
         } );
         GridPane.setConstraints(depositeB, 19, 13);
         
          
         //withdraw
          Button withdrawB = new Button ("     withdrawal      ");
         withdrawB.setOnAction(e -> {
             window.setScene(scene4);
             
         });
         GridPane.setConstraints(withdrawB, 19, 15);
           
        
          
           //message to show balance & history
          Label showMassage = new Label("");
          showMassage.getStyleClass().add("Label3");
          GridPane.setConstraints(showMassage, 19, 23);
       
         //check Blanace
          Button balancecheck = new Button ("  Current Balance  ");
         balancecheck.setOnAction(e->{
            int balance = atm.getCurrentBal();
            showMassage.setText("Your balance is "+String.valueOf(balance));
             atm.getBalanceHistory();
         });
         GridPane.setConstraints(balancecheck, 19, 17);
         
         
         //prev Button
         Button prevButton = new Button ("   previous  ");
         prevButton.setOnAction(e ->{
             int count = atm.getI2();
              if (atm.geti()<0)
                showMassage.setText( "No previous history");
             else 
                showMassage.setText(arr[count]);
             
        });
         GridPane.setConstraints(prevButton, 15, 22);
          
         
         //Next Button
         Button nextButton = new Button ("     Next      ");
         nextButton.setOnAction(e -> {
            int count = atm.getI1();
            if (atm.geti()>=5)
            {
              showMassage.setText( "No next history" );  
            }
            else
            {
                showMassage.setText( arr[count] );
            }
                
         });
         GridPane.setConstraints(nextButton, 24, 22);
         
        
         
         
         //Button Log out 
        Button logOutButton = new Button("Log Out");
        logOutButton .setOnAction(e -> {
            
            window.setScene(scene1);
        });
                
        GridPane.setConstraints(logOutButton , 29,30);
         
         
         //Grid 2
        grid1.getChildren().addAll(label2,logOutButton ,depositeB,withdrawB,balancecheck,prevButton,nextButton,showMassage);
        scene2 = new Scene(grid1, 1000, 800); 
         
     

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////         
         
                //when you choose Deposit//
                
           //message
         Label label3 = new Label(" Enter Amount : ");
         GridPane.setConstraints(label3, 2, 9);

         //text area to add amount added 
         TextField deposite = new TextField();
           deposite.getStyleClass().add("TextField");
         GridPane.setConstraints(deposite, 4, 9);
          
          
         //warning massege
         Label messageDeposite = new Label("");
         GridPane.setConstraints(messageDeposite, 4, 10);
        
        
        //button to deposit
        
        Button depositeButton = new Button ("     Deposite    ");
        depositeButton.setOnAction(e->{
             
            int amountAdded = Integer.parseInt(deposite.getText());
            
            if(amountAdded == 0)
            {
                messageDeposite.setText("you can't add 0 balance!");
                
                messageDeposite.getStyleClass().add("Label2");
                
            }
            else 
            {
               messageDeposite.setText("you added " +amountAdded+ " succsesfuly.");
               messageDeposite.getStyleClass().add("Label1");
               atm.accountAdd(amountAdded);
               
            }
           
        });
        GridPane.setConstraints(depositeButton, 12, 25);
        
        
        //Home form deposite
         Button homeButton = new Button ("         menu        ");
         homeButton.setOnAction(e -> {
             deposite.setText("");
             messageDeposite.setText("");
             window.setScene(scene2);
         });
         GridPane.setConstraints(homeButton, 5, 19);
         
         
         
          // numbers keypad
        Button num11 = new Button ("             1            ");
        num11.setOnAction(e-> deposite.setText(deposite.getText()+"1"));
        GridPane.setConstraints(num11, 5, 16);
        Button num22 = new Button ("             2            ");
        num22.setOnAction(e -> deposite.setText(deposite.getText()+"2"));
        GridPane.setConstraints(num22, 6, 16);
        Button num33 = new Button ("             3            ");
        num33.setOnAction(e -> deposite.setText(deposite.getText()+"3"));
        GridPane.setConstraints(num33, 7, 16);
        Button num44 = new Button ("             4            ");
        num44.setOnAction(e -> deposite.setText(deposite.getText()+"4"));
        GridPane.setConstraints(num44, 5, 17);
        Button num55 = new Button ("             5            ");
        num55.setOnAction(e ->deposite.setText(deposite.getText()+"5"));
        GridPane.setConstraints(num55, 6, 17);
        Button num66 = new Button ("             6            ");
        num66.setOnAction(e ->deposite.setText(deposite.getText()+"6"));
        GridPane.setConstraints(num66, 7, 17);
        Button num77 = new Button ("             7            ");
        num77.setOnAction(e -> deposite.setText(deposite.getText()+"7"));
        GridPane.setConstraints(num77, 5, 18);
        Button num88 = new Button ("             8            ");
        num88.setOnAction(e -> deposite.setText(deposite.getText()+"8"));
        GridPane.setConstraints(num88, 6, 18);
        Button num99 = new Button ("             9            ");
        num99.setOnAction(e -> deposite.setText(deposite.getText()+"9"));
        GridPane.setConstraints(num99, 7, 18);
        Button num00 = new Button ("             0            ");
        num00.setOnAction(e -> deposite.setText(deposite.getText()+"0"));
        GridPane.setConstraints(num00, 6, 19);
        
        
        
        //Button to clear
        Button clearButton1 = new Button ("      Delete All     ");
        clearButton1.setOnAction(e -> {
            deposite.clear();
            messageDeposite.setText("");
        });
        GridPane.setConstraints(clearButton1, 7, 19);
        
        
         
          //Grid 3
        grid2.getChildren().addAll(deposite,messageDeposite,depositeButton,homeButton,num11 , num22 
        ,num33 , num44 , num55 , num66 , num77 , num88 ,num99 ,num00,clearButton1,label3);
        scene3 = new Scene(grid2, 1600, 800); 
        
        
        
 ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                     
                             //when you choose withdraw//
 
           //withdraw label                  
          Label label4 = new Label(" Enter Amount : ");
         GridPane.setConstraints(label4, 2, 9);                   
                             
                             
                             
         //text area to withdraw amount 
         TextField withdraw = new TextField();
        withdraw.getStyleClass().add("TextField");
         GridPane.setConstraints(withdraw, 4, 9);
          
          
         //warning massege
         Label messageWithdraw = new Label("");
         GridPane.setConstraints(messageWithdraw, 4, 10);
      
        
        //button to Withdraw
        Button withdrawButton = new Button ("   withdraw  ");
        withdrawButton.setOnAction(e->{
            int amountToWithdraw =Integer.parseInt(withdraw.getText());
            if( amountToWithdraw == 0)
            {
                messageWithdraw.setText("you can't withdraw 0 amount!");
                messageWithdraw.getStyleClass().add("Label2");
              
            }
            else if (amountToWithdraw > atm.getCurrentBal())
            {
             messageWithdraw.setText("you can't withdraw amount!");
                messageWithdraw.getStyleClass().add("Label2");
            }
            else
            {
               messageWithdraw.setText("you drawed "+amountToWithdraw+ " succsesfuly.");
               messageWithdraw.getStyleClass().add("Label1");
             
               atm.accountWithdraw(amountToWithdraw);
            }
            
        }
        );
        GridPane.setConstraints(withdrawButton, 12, 25);
        
        
         //Home from withdraw
          Button homeButton1 = new Button ("       menu         ");
         homeButton1.setOnAction(e -> {
             window.setScene(scene2);
         });
         GridPane.setConstraints(homeButton1, 5, 19);
         
         
         
               // numbers keypad
        Button num111 = new Button ("             1            ");
        num111.setOnAction(e-> withdraw.setText(withdraw.getText()+"1"));
        GridPane.setConstraints(num111, 5, 16);
        Button num222 = new Button ("             2            ");
        num222.setOnAction(e -> withdraw.setText(withdraw.getText()+"2"));
        GridPane.setConstraints(num222, 6, 16);
        Button num333 = new Button ("             3            ");
        num333.setOnAction(e -> withdraw.setText(withdraw.getText()+"3"));
        GridPane.setConstraints(num333, 7, 16);
        Button num444 = new Button ("             4            ");
        num444.setOnAction(e -> withdraw.setText(withdraw.getText()+"4"));
        GridPane.setConstraints(num444, 5, 17);
        Button num555 = new Button ("             5            ");
        num555.setOnAction(e ->withdraw.setText(withdraw.getText()+"5"));
        GridPane.setConstraints(num555, 6, 17);
        Button num666 = new Button ("             6            ");
        num666.setOnAction(e ->withdraw.setText(withdraw.getText()+"6"));
        GridPane.setConstraints(num666, 7, 17);
        Button num777 = new Button ("             7            ");
        num777.setOnAction(e -> withdraw.setText(withdraw.getText()+"7"));
        GridPane.setConstraints(num777, 5, 18);
        Button num888 = new Button ("             8            ");
        num888.setOnAction(e -> withdraw.setText(withdraw.getText()+"8"));
        GridPane.setConstraints(num888, 6, 18);
        Button num999 = new Button ("             9            ");
        num999.setOnAction(e -> withdraw.setText(withdraw.getText()+"9"));
        GridPane.setConstraints(num999, 7, 18);
        Button num000 = new Button ("             0            ");
        num000.setOnAction(e -> withdraw.setText(withdraw.getText()+"0"));
        GridPane.setConstraints(num000, 6, 19);
       
        
        
            //Button to clear
        Button clearButton2 = new Button ("      Delete All     ");
        clearButton2.setOnAction(e -> {
            withdraw.clear();
           messageWithdraw.setText("");
        });
        GridPane.setConstraints(clearButton2, 7, 19);
     
        
        //Grid 4
        grid3.getChildren().addAll(withdraw,messageWithdraw,withdrawButton,homeButton1,label4,num111 , num222 
        ,num333 , num444 , num555 , num666 , num777 , num888 ,num999 ,num000,clearButton2);
        scene4 = new Scene(grid3, 1600, 800); 
        
        //
       


        //Display scene 1 at first
       scene1.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
       scene2.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
     scene3.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
     scene4.getStylesheets().add(getClass().getResource("StyleSheet.css").toExternalForm());
        window.setScene(scene1);
        window.setTitle("ATM - Machine");
        window.show();
        
    }
 
}