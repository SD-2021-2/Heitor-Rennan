import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex2 {
	public static void main(String[] args) throws IOException {
		
        ServerSocket serverSocket = new ServerSocket(6565);
        System.out.println("Waiting connections");
        Socket socket;
		
		while(true){
			socket = null;
			socket = serverSocket.accept(); 
			System.out.println("Conexao realizada!");
			
			new Ex2(socket).start();
		}		
    }
}

class Ex2 extends Thread {

	Socket thread;
  
	Ex2 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run() {
    try {
		InputStream inputStream = thread.getInputStream();
        BufferedReader messageReceived = new BufferedReader(new InputStreamReader (inputStream));
		JSONObject json = new JSONObject(messageReceived.readLine());

		Pessoa pessoa = new Pessoa();

		pessoa.name = json.getString("nome");
		pessoa.gender = json.getString("sexo");
		pessoa.age = json.getInt("idade");
		
		json.put("maioridade", pessoa.maiorDeIdade());

		PrintStream resposta = new PrintStream(thread.getOutputStream());
		resposta.println(json.toString());

		thread.close();
		System.out.println("Conexao encerrada!");
		
	}catch (IOException e) {
		System.out.println("Erro na conexao!");
	} catch (JSONException e) {
		System.out.println("Erro na conexao!");
	}
	}  
}

class Pessoa {
	String name;
	String gender;
	int age;
	
	String maiorDeIdade(){
		if((gender.equals("Masculino") && age >= 18) || (gender.equals("Feminino") && age >= 21))
			return "Atingiu a Maioridade!";
		else
			return "Nao atingiu a Maioridade!";
		
	}
}