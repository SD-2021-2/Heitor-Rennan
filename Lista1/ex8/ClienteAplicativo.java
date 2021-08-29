/*
 * ClienteAplicativo.java
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.rmi.Naming;
import java.rmi.RemoteException;

public class ClienteAplicativo extends JFrame{

   private JLabel saldoLabel;
   private JTextField saldoField, mensagemField, mensagemField2;
   private JButton reajusteButton;

   public ClienteAplicativo(String t)
   {
      super(t);

      Container cont = getContentPane();
      cont.setLayout( new FlowLayout() );
      JPanel c = new JPanel();
      c.setLayout( new GridLayout(3,1) );
      JPanel c2 = new JPanel();
      c2.setLayout( new GridLayout(4,4) );
      saldoLabel = new JLabel( "Saldo Medio:" );
      saldoField = new JTextField( 10 );
      mensagemField = new JTextField( 30 );
      mensagemField2 = new JTextField( 30 );
      mensagemField.setEditable(false);
      mensagemField2.setEditable(false);
      reajusteButton = new JButton("Calcula Aposentadoria");
      reajusteButton.addActionListener(
         new ActionListener() {
            public void actionPerformed( ActionEvent e ){
              double saldo = Double.parseDouble(saldoField .getText());
              CreditoHome obj = null;
              try {
                  obj = (CreditoHome) Naming.lookup("//localhost/CreditoHome");
                  obj.setSaldo(saldo);
                  mensagemField.setText("O saldo medio do Cliente eh: " + saldo );
                  mensagemField2.setText("O valor do credito do Cliente eh: " + obj.calculaCredito() );
              } catch (Exception ex) {
                  System.out.println("ClienteAplicativo exception: " +
                                          ex.getMessage());
                  ex.printStackTrace();
              }

            }
         }
      );

      c2.add( saldoLabel );
      c2.add( saldoField );
      c.add( reajusteButton );
      c.add( mensagemField );
      c.add( mensagemField2 );
      cont.add(c2);
      cont.add(c);
   }


   public static void main(String[] args) {

        ClienteAplicativo frame = new ClienteAplicativo("Calcula Aposentadoria");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350,250);
        frame.setVisible(true);
    }
}


