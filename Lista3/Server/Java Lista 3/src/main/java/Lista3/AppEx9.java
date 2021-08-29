package Lista3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;


public class AppEx9 {
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6565);
        Socket socket;
            
        System.out.println("Waiting Connections");
	
        while(true){
            socket = null;
            socket = serverSocket.accept(); 
            System.out.println("Conexao realizada!");	
            new Ex9(socket).start();
        }		
    }
}

class Ex9 extends Thread {

	Socket thread;
  
	Ex9 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run() {
    	try {
            InputStream inputStream = thread.getInputStream();
            BufferedReader message = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(message.readLine());

			Card card = new Card();

			card.number = json.getInt("numero");
			card.type = json.getInt("naipe");
			
			json.put("extenso", card.cartaEscrita());

			PrintStream retorno = new PrintStream(thread.getOutputStream());
			retorno.println(json.toString());
			thread.close();
			
			System.out.println("Conexao Finalizada!");
				
		}catch (IOException e) {
			System.out.println("Erro na conexao!");
		} catch (JSONException e) {
			System.out.println("Erro na conexao!");
		}
	}  
}
    
    class Card {
	int number;
	int type;

	String cartaEscrita(){
		String nome = "Sua Carta: ";
	
		switch(number){
			case 1 -> nome = nome.concat("As de ");
			case 2 -> nome = nome.concat("Dois de ");
			case 3 -> nome = nome.concat("Tres de ");
			case 4 -> nome = nome.concat("Quatro de ");
			case 5 -> nome = nome.concat("Cinco de ");
			case 6 -> nome = nome.concat("Seis de ");
			case 7 -> nome = nome.concat("Sete de ");
			case 8 -> nome = nome.concat("Oito de ");
			case 9 -> nome = nome.concat("Nove de ");
			case 10 -> nome = nome.concat("Dez de ");
			case 11 -> nome = nome.concat("Valete de ");
			case 12 -> nome = nome.concat("Dama de ");
			case 13 -> nome = nome.concat("Rei de ");
		}	
		
		switch(type){
			case 1 -> nome = nome.concat("Ouros");
			case 2 -> nome = nome.concat("Paus");
			case 3 -> nome = nome.concat("Copas");
			case 4 -> nome = nome.concat("Espadas");
		}
		return nome;
	}
}

