package com.company;

// ketabkhane ha
import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author MMNazari1380
 * @version 1.0
 */
public class Client extends JFrame
{


    /**
     * methode run baraye ejraye barname
     */
    public void run()
    {

        try
        {

            // sakhte shey baraye daryafte vorrodi
            Scanner sc = new Scanner(System.in);
            System.out.println(" lotfan shomare port ra vared konid");
            int port = sc.nextInt();
            Socket socket = new Socket( InetAddress.getLocalHost(), port );
            DataInputStream dataInputStream = new DataInputStream( socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            System.out.println("  agar amade hastid ' ready ' ra type konid ");
            String ready = sc.next();
            if(ready.equals("ready"))
            {

                while(true)
                {



                    for ( int x=1 ; x<2 ; x++){
                        System.out.println(" username khod ra vared konid");
                        String username = sc.next();
                        dataOutputStream.writeUTF(username);
                    }

                    while(true){

                        String khorooji = sc.next();
                        dataOutputStream.writeUTF(khorooji);
                    }

                }

            }

            // bastane socket va stream ha
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();

        }
        // residegi be exception
        catch (IOException e)
        {

            e.printStackTrace();

        }

    }

}
