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
   private JLabel idadeLabel;
   private JTextField nomeField,sexoField,idadeField, mensagemField, mensagemField2;
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
      
      idadeLabel = new JLabel( "idade:" );
      idadeField = new JTextField( 10 );
      
      mensagemField = new JTextField( 30 );
      mensagemField2 = new JTextField( 30 );
      mensagemField.setEditable(false);
      mensagemField2.setEditable(false);
      maiorDeIdadeButton = new JButton("maior de idade?");
      maiorDeIdadeButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ){
			  String nome = nomeField.getText();
			  String sexo = sexoField .getText(); 
              double idade = Double.parseDouble(idadeField .getText());
              Pessoa obj = null;
              try {
                  Registry registry = LocateRegistry.getRegistry("localhost");                   
                  obj = (Pessoa) registry.lookup("Pessoa");
                  boolean maior = obj.maiorDeIdade(nome,sexo,idade);
                  System.out.println(maior);
                  if (obj.maiorDeIdade(nome,sexo,idade)){
					 mensagemField.setText(" maior de idade");
					
				  }else {
					 mensagemField.setText(" menor de idade");	
			      
			      }
                 
             
              } catch (Exception ex) {
                  System.out.println("Aplicativo exception: " +
                                          ex.getMessage());
                  ex.printStackTrace();
              }

            }
         }
      );

      c2.add( nomeLabel );
      c2.add( nomeField );
      
      c2.add( sexoLabel );
      c2.add( sexoField );
      
      c2.add( idadeLabel );
      c2.add( idadeField );
      
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


