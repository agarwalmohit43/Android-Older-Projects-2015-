package com.abhishek.vt;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

 public class VideoTransmitter extends Thread{
     ServerSocket ss = null;
     //long sleepInterval = 50;

     public VideoTransmitter(long interval) throws Exception {
	     ss = new ServerSocket(2020);
	    // sleepInterval = interval;
	     this.setPriority(MIN_PRIORITY);
	     this.start();
	     startServer();
     }
     
     private void startServer() {
	     Socket client = null;
		 System.err.println("Starts listening for clients");
		 ClientThread ct = null;
		 while(true) {
			 try {
				 client = ss.accept();
				 ct = new ClientThread(client);
				 ct.start();
			 } catch(Exception ex) {ex.printStackTrace();}
		 }
	 } 
 
 class ClientThread extends Thread {
	 Socket client = null;
	 ObjectOutputStream os = null;
	 InputStream is = null;
	 
	 public ClientThread(Socket s) {
		 client = s;
		 try {
			 os = new ObjectOutputStream(s.getOutputStream());
			 is = s.getInputStream();
			 System.out.println("Client from "+s.getInetAddress().getHostAddress()+" connected");
		 } catch(Exception ex) {ex.printStackTrace();}
	 }
	 
	 public void run() {
		 java.awt.image.BufferedImage img = null;
		 Robot r = null;
		 try { r = new Robot(); } catch(Exception ex) {ex.printStackTrace();}
		 Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
		 Rectangle rect = new Rectangle(0,0,size.width, size.height);
		 javax.swing.ImageIcon icon = null;
		 while(true) {
			 try {
				 System.gc();
				 img = r.createScreenCapture(rect);
				 icon = new javax.swing.ImageIcon(img);
				 os.writeObject(icon);
				 os.flush();
				 icon = null;
				 System.gc();
			 }catch(Exception ex) { 
			   break;
		     }
		 } 
	 }
  }
  public static void main(String arg[]) throws Exception {
	long interval = 80;
    new VideoTransmitter(interval);
  }
}