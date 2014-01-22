package org.sy.socket.service;

import org.sy.socket.SYSocketClient;
import org.sy.socket.SYSocketClient.SYSocketListener;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

public class ChatService extends Service implements SYSocketListener {

	public SYSocketClient client;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();

		client = new SYSocketClient("www.ichezhen.com", 3005);
		client.setSocketListener(this);
		new Thread(new Runnable() {
			@Override
			public void run() {
				client.connect();
			}
		}).start();
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		// TODO Auto-generated method stub
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void didConnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void didDisconnect() {
		// TODO Auto-generated method stub

	}

	@Override
	public void didError(Error err) {
		// TODO Auto-generated method stub
		System.out.println(err);
	}

	@Override
	public void didReceive(String msg) {
		// TODO Auto-generated method stub
		System.out.print(msg);
	}
}
