package com.pennapps.feedDJ;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class Requester extends Thread {

	Socket requestSocket;
	String message;
	StringBuilder returnStringBuffer = new StringBuilder();
	Message lmsg;
	int ch;
	Handler h;
	String toSend;
	
	public Requester(Handler h, String toSend) {
		this.h = h;
		this.toSend = toSend;
	}
	
	@Override
	public void run() {
		try {
			//establish connection
			this.requestSocket = new Socket("emish@seas202.wlan.seas.upenn.edu", 9999);
			//send info toSend
			PrintWriter out = new PrintWriter(requestSocket.getOutputStream(),
					true);
			out.println(toSend);
			//receive info
			InputStreamReader isr = new InputStreamReader(
					this.requestSocket.getInputStream());
			while ((this.ch = isr.read()) != -1) {
				this.returnStringBuffer.append((char) this.ch);
			}
			this.message = this.returnStringBuffer.toString();
			this.lmsg = new Message();
			this.lmsg.obj = this.message;
			this.lmsg.what = 0;
			//give info to handler to deal with back at the base
			h.sendMessage(this.lmsg);
			this.requestSocket.close();
		} catch (Exception ee) {
			Log.d("sample application", "failed to read data" + ee.getMessage());
		}
	}
}
