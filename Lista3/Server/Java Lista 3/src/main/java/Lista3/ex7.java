import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex7 {
	public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(6565);
        Socket socket;
            
        System.out.println("Waiting Connextions");
		
		
    	while(true){
			socket = null;
			socket = serverSocket.accept(); 
			System.out.println("Conexao aceita");
			
			new Ex7(socket).start();
        }		
    }
}

class Ex7 extends Thread {

	Socket thread;
  
	Ex7 (Socket socket) throws IOException {
            thread = socket;
	}
  
	public void run() {
            try {
				InputStream inputStream = thread.getInputStream();
                BufferedReader messageReceived = new BufferedReader(new InputStreamReader (inputStream));
				JSONObject json = new JSONObject(messageReceived.readLine());

				Funcionario funcionario = new Funcionario();

				funcionario.age = json.getInt("idade");
				funcionario.time = json.getInt("tempo");

				json.put("aposentado", funcionario.podeAposentar());

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

class Funcionario {
	int age;
	int time;
	
	String podeAposentar(){
		if(age >= 65 && time >= 30)
                    return "Permitido Aposentar!";
		else
                    return "N�o Permitido Aposentar";
	}
}