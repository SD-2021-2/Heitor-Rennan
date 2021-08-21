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
            System.out.println("Waiting connections");
            Socket socket;
		
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
                BufferedReader mensagem = new BufferedReader(new InputStreamReader (inputStream));
		JSONObject json_obj = new JSONObject(mensagem.readLine());

		NotasParaMedia notas = new NotasParaMedia();

		notas.nota1 = json_obj.getDouble("n1");
		notas.nota2 = json_obj.getDouble("n2");
		notas.nota3 = json_obj.getDouble("n3");
		
		json_obj.put("resultado", notas.aprovado());

		PrintStream resposta = new PrintStream(thread.getOutputStream());
		resposta.println(json_obj.toString());

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