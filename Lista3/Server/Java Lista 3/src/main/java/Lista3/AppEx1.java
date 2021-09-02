package Lista3;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import static java.lang.System.out;
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
                        BufferedReader textoRecebidoParaJsonDoCliente = new BufferedReader(new InputStreamReader (inputStream));
			JSONObject json = new JSONObject(textoRecebidoParaJsonDoCliente.readLine());
                        
                        Socket socketManagerDB = new Socket("127.0.0.1", 4000);
                        System.out.println("Conectado ao DB Manager!");
                        
                        JSONObject dataObj = new JSONObject();
                        
                        dataObj.put("exerc", 1);
                        dataObj.put("data", json);
                        
                        System.out.println(dataObj.toString());
                        
                        try (OutputStreamWriter outS = new OutputStreamWriter(
                            socketManagerDB.getOutputStream(), StandardCharsets.UTF_8)) {
                            outS.write(dataObj.toString());
                        }
                        
                        socketManagerDB.close();  
			socketCliente.close();		
			System.out.println("Conexao finalizada!");
		
		}catch (IOException e){
                    System.out.println("Erro na conexao!");
                    
                } catch (JSONException e) {
		   System.out.println("Erro no JSON!");
		}
	}  
}
