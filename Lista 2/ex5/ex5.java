import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex5 {
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6565);
        Socket socket;
        
        System.out.println("Waiting connections");
		
        while(true){
			socket = null;
			socket = serverSocket.accept(); 
		
          	System.out.println("Conexao aceita");
			
			new Ex5(socket).start();
	    }		
    }
}

class Ex5 extends Thread {

	Socket thread;
  
	Ex5 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run()  {
	    try {
		InputStream inputStream = thread.getInputStream();
                BufferedReader messageReceived = new BufferedReader(new InputStreamReader (inputStream));
		JSONObject json = new JSONObject(messageReceived.readLine());

		Nadador nadador = new Nadador();

		nadador.age = json.getInt("idade");
		
		json.put("categoria", nadador.categoriaNatacao());
		PrintStream resposta = new PrintStream(thread.getOutputStream());
		resposta.println(json.toString());

		thread.close();
		System.out.println("Conexao finalizada!");
	
	}catch (IOException e) {
		System.out.println("Erro na conexao!");
	} catch (JSONException e) {
		System.out.println("Erro na conexao!");
	}
	}  
}

class Nadador {
	int age;
	
	String categoriaNatacao(){
		if(age >= 18)
			return "Categoria Adulto";
		else if(age >= 14)
			return "Categoria Juvenil B";
		else if(age >= 11)
			return "Categoria Juvenil A";
		else if(age >= 8)
			return "Categoria Infantil B";
		else if(age >= 5)
			return "Categoria Infantil A";
		else
			return "Idade Invalida!";
	
	}
}