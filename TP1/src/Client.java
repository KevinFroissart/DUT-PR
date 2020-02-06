import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import java.net.Socket;
import java.net.UnknownHostException;

/*
 * Cette classe va permettre d'envoyer la requête
 * au serveur via la socket
 */
public class Client {
    private Socket clientSocket = null;
    private PrintWriter envoi = null;
    private BufferedReader reception = null;

    // La classe doit être instanciée avec le nom
    // ou l'adresse de la machine où se trouve le serveur
    // ainsi que le numéro de port qu'il utilise.
    public Client(String host, int port) {
	try {
	    // Instanciation de la socket client
	    // S'il n'y a pas d'exception, la connexion est établie
	    clientSocket = new Socket(host, port);
	}
	catch (UnknownHostException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	catch (IOException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
	
	try {
	    // Récupération d'un flux orienté texte pour écrire dans la socket
	    envoi = new PrintWriter(clientSocket.getOutputStream(), true);
	    
	    // Récupération d'un flux orienté texte pour lire dans la socket
	    reception = new BufferedReader(
					   new InputStreamReader(clientSocket.getInputStream()));
	} catch (IOException e) {
	    e.printStackTrace();
	    System.exit(1);
	}
    }
    
    public String envoyer(String message) {
	envoi.println(message);
	
	try {
	    return reception.readLine();
	} catch (IOException e) {
	    e.printStackTrace();
	}
	return null;
    }
}
