package com.pennapps.feedDJ;


import java.net.Socket;

import org.json.JSONObject;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.io.PrintWriter;
import java.net.UnknownHostException;


public class RequestServices extends Service{
	
	final static String HOST = "localhost";
	final static int PORT = 9997;
	
	
	
	@Override
	public void onCreate(){
		//Actions to perform when service is created
		super.onCreate();
		//setContentView(R.layout.main);
		
	}
	@Override
	public IBinder onBind(Intent intent){
		return null;
	}
	
	private void refreshAction(){
		try{
			JSONObject refJson = new JSONObject();
			String reqString = refJson.toString();
			connectSocket(reqString);
		} finally {}
	}
	
	private void connectSocket(String reqString){
		try{
			InetAddress serverAddr = InetAddress.getByName(HOST);
			//Log.d()
			Socket socket = new Socket(serverAddr, PORT);
			String message = reqString;
			try{
				PrintWriter out = new PrintWriter(new BufferedWriter( new 
						OutputStreamWriter(socket.getOutputStream())), true);
				out.println(message);
			}
			catch(Exception e){
				Log.e("TCP", "S:Error", e);
			}
			finally{
				socket.close();
			}
		}
		catch(UnknownHostException e){
			Log.e("TCP", "UnknownHostException", e);
			e.printStackTrace();
		}
		catch(IOException e){
			Log.e("TCP", "IOException", e);
			e.printStackTrace();
		}
	}
}