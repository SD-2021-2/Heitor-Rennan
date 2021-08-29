package Lista3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import org.json.JSONException;
import org.json.JSONObject;

public class AppEx1 {
	public static void main(String[] args) throws IOException {
		ServerSocket serverSocketCliente = new ServerSocket(6565);
                Socket socketCliente;

		System.out.println("Servidor iniciado");
		
		while(true){
			socketCliente = null;
			socketCliente = serverSocketCliente.accept(); 
			System.out.println("Socket conectado!");
			
			new Ex1(socketCliente).start();
		}	
        }
}


class Ex1 extends Thread {

	Socket socketCliente;
        
	Ex1 (Socket socket) throws IOException {
		socketCliente = socket;
	}
  
	
	public void run() {
		try {
			InputStream inputStream = socketCliente.getInputStream();
                        BufferedReader textoRecebidoParaJson = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(textoRecebidoParaJson.readLine());
                        
                        Socket socketManagerDB = new Socket("127.0.0.1", 4000);
                        
                        try (OutputStreamWriter out = new OutputStreamWriter(
                            socketManagerDB.getOutputStream(), StandardCharsets.UTF_8)) {
                            out.write(json.toString());
                        }
                     
			PrintStream retornoClient = new PrintStream(socketCliente.getOutputStream());
			retornoClient.println(json.toString());

			socketCliente.close();		
			System.out.println("Conexao finalizada!");
		
		}catch (IOException | JSONException e) {
			System.out.println("Erro na conexao!");
		}
	}  
}

class Funcionario {
	String name;
	String funcao;
	double salario;

}