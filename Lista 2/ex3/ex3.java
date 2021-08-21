import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONException;
import org.json.JSONObject;

public class ex3 {
	public static void main(String[] args) throws IOException {
		
            ServerSocket serverSocket = new ServerSocket(6565);
            Socket socket;
            
			System.out.println("Waiting connections");
		
		while(true){
			socket = null;
			socket = serverSocket.accept(); 
			System.out.println("Conexao realizada!");
			
			new Ex3(socket).start();
		}		
    }
}

class Ex3 extends Thread {

	Socket thread;
  
	Ex3 (Socket socket) throws IOException {
		thread = socket;
	}
  
	public void run() {
		try {
			InputStream inputStream = thread.getInputStream();
            BufferedReader messageReceived = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(messageReceived.readLine());

			NotasParaMedia notas = new NotasParaMedia();

			notas.nota1 = json.getDouble("n1");
			notas.nota2 = json.getDouble("n2");
			notas.nota3 = json.getDouble("n3");
			
			json.put("resultado", notas.aprovado());

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

class NotasParaMedia {
	double nota1, nota2, nota3;
	
	String aprovado(){
		
		double media = (nota1+nota2)/2;
		if(media >= 7.0 || (media > 3.0 && (media+nota3)/2 >= 5.0))
			return "Aprovado!";
		else
			return "Reprovado!";
		
        }
}