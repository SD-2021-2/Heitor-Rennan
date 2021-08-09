/*
 * Aplicativo.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.RemoteException;

public class Aplicativo extends JFrame{

   private JLabel nomeLabel;
   private JLabel sexoLabel;
   private JLabel alturaLabel;
   private JTextField nomeField,sexoField,alturaField, mensagemField, mensagemField2;
   private JButton maiorDeIdadeButton;

   public Aplicativo(String t)
   {
      super(t);

      Container cont = getContentPane();
      cont.setLayout( new FlowLayout() );
      JPanel c = new JPanel();
      c.setLayout( new GridLayout(3,1) );
      JPanel c2 = new JPanel();
      c2.setLayout( new GridLayout(4,4) );
      nomeLabel = new JLabel( "Nome:" );
      nomeField = new JTextField( 10 );
      
      sexoLabel = new JLabel( "sexo:" );
      sexoField = new JTextField( 10 );
      
      alturaLabel = new JLabel( "altura:" );
      alturaField = new JTextField( 10 );
      
      mensagemField = new JTextField( 30 );
      mensagemField2 = new JTextField( 30 );
      mensagemField.setEditable(false);
      mensagemField2.setEditable(false);
      maiorDeIdadeButton = new JButton("peso ideal");
      maiorDeIdadeButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ){
			  String nome = nomeField.getText();
			  String sexo = sexoField .getText(); 
              double altura = Double.parseDouble(alturaField .getText());
              Pessoa obj = null;
              try {
                  Registry registry = LocateRegistry.getRegistry("localhost");                   
                  obj = (Pessoa) registry.lookup("Pessoa");
                  double pesoIdeal = obj.pesoIdeal(sexo,altura);
                  System.out.println(pesoIdeal);
                  
				  mensagemField.setText(String.valueOf(pesoIdeal));
					
				  
                 
             
              } catch (Exception ex) {
                  System.out.println("Aplicativo exception: " +
                                          ex.getMessage());
                  ex.printStackTrace();
              }

            }
         }
      );
/*
      c2.add( nomeLabel );
      c2.add( nomeField );
      */
      c2.add( sexoLabel );
      c2.add( sexoField );
      
      c2.add( alturaLabel );
      c2.add( alturaField );
      
      c.add( maiorDeIdadeButton  );
      c.add( mensagemField );
      //c.add( mensagemField2 );
      cont.add(c2);
      cont.add(c);
   }


   public static void main(String[] args) {

        Aplicativo frame = new Aplicativo("maior de idade");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,250);
        frame.setVisible(true);
    }
}


