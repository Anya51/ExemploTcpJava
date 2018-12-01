/**
 * @author Tarcisio da Rocha (Prof. DCOMP/UFS)
 */
package br.ufs.dcomp.ExemploTcpJava;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class TCPClient{
    public static void main(String[] args){
        try {
            System.out.print("[ Conectando com o Servidor TCP    ..................  ");
            Socket sock = new Socket("127.0.0.1", 3300);
            System.out.println("[OK] ]");
            
            InputStream is = sock.getInputStream(); // Canal de entrada de dados
            OutputStream os = sock.getOutputStream(); // Canal de saída de dados
            
            while(true){
                System.out.print("  Mensagem a enviar: ");
                Scanner sc1 = new Scanner(System.in); 
                String msg = sc1.nextLine();
                byte[] buf = msg.getBytes(); // Obtendo a respresntação em bytes da mensagem
                byte[] buf_retorno = new byte[20]; // buffer de recepção



                System.out.print("[ Enviando mensagem    ..............................  ");
                os.write(buf);
                System.out.println("[OK] ]");
            
                System.out.println("[ Aguardando recebimento de mensagem   ..............  ");
                is.read(buf_retorno); // Operação bloqueante (aguardando chegada de dados)
                String msg_retorno = new String(buf_retorno); // Mapeando vetor de bytes recebido para String
                System.out.println("  Mensagem recebida: "+ msg_retorno);
            }
            
        }catch(Exception e){System.out.println(e);}    
        System.out.println("[ FIM ]");
    }
}