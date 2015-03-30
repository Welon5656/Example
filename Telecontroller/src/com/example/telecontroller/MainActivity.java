package com.example.telecontroller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends Activity {

	public OutputStream os;
	byte[] buf;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		init();
		new Thread() {
			
			@Override
			public void run() {
				
				try {
					Socket s = new Socket("192.168.1.101", 30000);
					os = s.getOutputStream();
				} 
				catch (IOException e) {
					e.printStackTrace();
				}
			}
		}.start();
	
	}
	
	public void init() {
	
		Button power = (Button) findViewById(R.id.power);
		power.setOnClickListener(new ShortClickListener());
		//power.setOnLongClickListener(new LongClickListener());
		power.setTag(0);
		Button guide = (Button) findViewById(R.id.guide);
		guide.setOnClickListener(new ShortClickListener());
		//guide.setOnLongClickListener(new LongClickListener());
		guide.setTag(1);
		Button program = (Button) findViewById(R.id.program);
		program.setOnClickListener(new ShortClickListener());
		//program.setOnLongClickListener(new LongClickListener());
		program.setTag(2);
		Button vv = (Button) findViewById(R.id.vv);
		vv.setOnClickListener(new ShortClickListener());
		//vv.setOnLongClickListener(new LongClickListener());
		vv.setTag(3);
		Button iTV = (Button) findViewById(R.id.iTV);
		iTV.setOnClickListener(new ShortClickListener());
		//iTV.setOnLongClickListener(new LongClickListener());
		iTV.setTag(4);
		Button home = (Button) findViewById(R.id.home);
		home.setOnClickListener(new ShortClickListener());
		//home.setOnLongClickListener(new LongClickListener());
		home.setTag(5);
		Button information = (Button) findViewById(R.id.information);
		information.setOnClickListener(new ShortClickListener());
		//information.setOnLongClickListener(new LongClickListener());
		information.setTag(6);
		Button back = (Button) findViewById(R.id.back);
		back.setOnClickListener(new ShortClickListener());
		//back.setOnLongClickListener(new LongClickListener());
		back.setTag(7);
		Button exit = (Button) findViewById(R.id.exit);
		exit.setOnClickListener(new ShortClickListener());
		//exit.setOnLongClickListener(new LongClickListener());
		exit.setTag(8);
		Button up = (Button) findViewById(R.id.up);
		up.setOnClickListener(new ShortClickListener());
		//up.setOnLongClickListener(new LongClickListener());
		up.setTag(9);
		Button confirm = (Button) findViewById(R.id.confirm);
		confirm.setOnClickListener(new ShortClickListener());
		//confirm.setOnLongClickListener(new LongClickListener());
		confirm.setTag(10);
		Button down = (Button) findViewById(R.id.down);
		down.setOnClickListener(new ShortClickListener());
		//down.setOnLongClickListener(new LongClickListener());
		down.setTag(11);
		Button left = (Button) findViewById(R.id.left);
		left.setOnClickListener(new ShortClickListener());
		//left.setOnLongClickListener(new LongClickListener());
		left.setTag(12);
		Button right = (Button) findViewById(R.id.right);
		right.setOnClickListener(new ShortClickListener());
		//right.setOnLongClickListener(new LongClickListener());
		right.setTag(13);
		Button b_1 = (Button) findViewById(R.id.b_1);
		b_1.setOnClickListener(new ShortClickListener());
		//b_1.setOnLongClickListener(new LongClickListener());
		b_1.setTag(14);
		Button b_2 = (Button) findViewById(R.id.b_2);
		b_2.setOnClickListener(new ShortClickListener());
		//b_2.setOnLongClickListener(new LongClickListener());
		b_2.setTag(15);
		Button b_3 = (Button) findViewById(R.id.b_3);
		b_3.setOnClickListener(new ShortClickListener());
		//b_3.setOnLongClickListener(new LongClickListener());
		b_3.setTag(16);
		Button b_4 = (Button) findViewById(R.id.b_4);
		b_4.setOnClickListener(new ShortClickListener());
		//b_4.setOnLongClickListener(new LongClickListener());
		b_4.setTag(17);
		Button b_5 = (Button) findViewById(R.id.b_5);
		b_5.setOnClickListener(new ShortClickListener());
		//b_5.setOnLongClickListener(new LongClickListener());
		b_5.setTag(18);
		Button b_6 = (Button) findViewById(R.id.b_6);
		b_6.setOnClickListener(new ShortClickListener());
		//b_6.setOnLongClickListener(new LongClickListener());
		b_6.setTag(19);
		Button b_7 = (Button) findViewById(R.id.b_7);
		b_7.setOnClickListener(new ShortClickListener());
		//b_7.setOnLongClickListener(new LongClickListener());
		b_7.setTag(20);
		Button b_8 = (Button) findViewById(R.id.b_8);
		b_8.setOnClickListener(new ShortClickListener());
		//b_8.setOnLongClickListener(new LongClickListener());
		b_8.setTag(21);
		Button b_9 = (Button) findViewById(R.id.b_9);
		b_9.setOnClickListener(new ShortClickListener());
		//b_9.setOnLongClickListener(new LongClickListener());
		b_9.setTag(22);
		Button b_10 = (Button) findViewById(R.id.b_10);
		b_10.setOnClickListener(new ShortClickListener());
		//b_10.setOnLongClickListener(new LongClickListener());
		b_10.setTag(23);
		Button b_0 = (Button) findViewById(R.id.b_0);
		b_0.setOnClickListener(new ShortClickListener());
		//b_0.setOnLongClickListener(new LongClickListener());
		b_0.setTag(24);
		Button b_01 = (Button) findViewById(R.id.b_01);
		b_01.setOnClickListener(new ShortClickListener());
		//b_01.setOnLongClickListener(new LongClickListener());
		b_01.setTag(25);
	
	}
	
	class ShortClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			int tag = (Integer) v.getTag(); 
	        switch(tag) {
	        case 0:
	        	buf = new byte[]{(byte)0x86,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x86}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 1:
	        	buf = new byte[]{(byte)0x86,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x87}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 2:
	        	buf = new byte[]{(byte)0x86,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x84}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 3:
	        	buf = new byte[]{(byte)0x86,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x85}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 4:
	        	buf = new byte[]{(byte)0x86,(byte)0x04,(byte)0x00,(byte)0x00,(byte)0x82}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 5:
	        	buf = new byte[]{(byte)0x86,(byte)0x05,(byte)0x00,(byte)0x00,(byte)0x83}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 6:
	        	buf = new byte[]{(byte)0x86,(byte)0x06,(byte)0x00,(byte)0x00,(byte)0x80}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 7:
	        	buf = new byte[]{(byte)0x86,(byte)0x07,(byte)0x00,(byte)0x00,(byte)0x81}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 8:
	        	buf = new byte[]{(byte)0x86,(byte)0x08,(byte)0x00,(byte)0x00,(byte)0x8E}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 9:
	        	buf = new byte[]{(byte)0x86,(byte)0x09,(byte)0x00,(byte)0x00,(byte)0x8F}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 10:
	        	buf = new byte[]{(byte)0x86,(byte)0x0A,(byte)0x00,(byte)0x00,(byte)0x8C}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 11:
	        	buf = new byte[]{(byte)0x86,(byte)0x0B,(byte)0x00,(byte)0x00,(byte)0x8D}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 12:
	        	buf = new byte[]{(byte)0x86,(byte)0x0C,(byte)0x00,(byte)0x00,(byte)0x8A}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 13:
	        	buf = new byte[]{(byte)0x86,(byte)0x0D,(byte)0x00,(byte)0x00,(byte)0x8B}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 14:
	        	buf = new byte[]{(byte)0x86,(byte)0x0E,(byte)0x00,(byte)0x00,(byte)0x88}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 15:
	        	buf = new byte[]{(byte)0x86,(byte)0x0F,(byte)0x00,(byte)0x00,(byte)0x89}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 16:
	        	buf = new byte[]{(byte)0x86,(byte)0x10,(byte)0x00,(byte)0x00,(byte)0x96}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 17:
	        	buf = new byte[]{(byte)0x86,(byte)0x11,(byte)0x00,(byte)0x00,(byte)0x97}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 18:
	        	buf = new byte[]{(byte)0x86,(byte)0x12,(byte)0x00,(byte)0x00,(byte)0x94}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 19:
	        	buf = new byte[]{(byte)0x86,(byte)0x13,(byte)0x00,(byte)0x00,(byte)0x95}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 20:
	        	buf = new byte[]{(byte)0x86,(byte)0x14,(byte)0x00,(byte)0x00,(byte)0x92}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 21:
	        	buf = new byte[]{(byte)0x86,(byte)0x15,(byte)0x00,(byte)0x00,(byte)0x93}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 22:
	        	buf = new byte[]{(byte)0x86,(byte)0x16,(byte)0x00,(byte)0x00,(byte)0x90}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 23:
	        	buf = new byte[]{(byte)0x86,(byte)0x17,(byte)0x00,(byte)0x00,(byte)0x91}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 24:
	        	buf = new byte[]{(byte)0x86,(byte)0x18,(byte)0x00,(byte)0x00,(byte)0x9E}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 25:
	        	buf = new byte[]{(byte)0x86,(byte)0x19,(byte)0x00,(byte)0x00,(byte)0x9F}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        default:
	        	break;
	        }
		}
		
	}
	
	/*class LongClickListener implements OnLongClickListener {

		@Override
		public boolean onLongClick(View v) {
			int tag = (Integer) v.getTag(); 
	        switch(tag) {
	        case 0:
	        	buf = new byte[]{(byte)0x88,(byte)0x00,(byte)0x00,(byte)0x00,(byte)0x88}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 1:
	        	buf = new byte[]{(byte)0x88,(byte)0x01,(byte)0x00,(byte)0x00,(byte)0x89}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 2:
	        	buf = new byte[]{(byte)0x88,(byte)0x02,(byte)0x00,(byte)0x00,(byte)0x8A}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 3:
	        	buf = new byte[]{(byte)0x88,(byte)0x03,(byte)0x00,(byte)0x00,(byte)0x8B}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 4:
	        	buf = new byte[]{(byte)0x88,(byte)0x04,(byte)0x00,(byte)0x00,(byte)0x8C}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 5:
	        	buf = new byte[]{(byte)0x88,(byte)0x05,(byte)0x00,(byte)0x00,(byte)0x8D}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 6:
	        	buf = new byte[]{(byte)0x88,(byte)0x06,(byte)0x00,(byte)0x00,(byte)0x8E}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 7:
	        	buf = new byte[]{(byte)0x88,(byte)0x07,(byte)0x00,(byte)0x00,(byte)0x8F}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 8:
	        	buf = new byte[]{(byte)0x88,(byte)0x08,(byte)0x00,(byte)0x00,(byte)0x80}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 9:
	        	buf = new byte[]{(byte)0x88,(byte)0x09,(byte)0x00,(byte)0x00,(byte)0x81}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 10:
	        	buf = new byte[]{(byte)0x88,(byte)0x0A,(byte)0x00,(byte)0x00,(byte)0x82}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 11:
	        	buf = new byte[]{(byte)0x88,(byte)0x0B,(byte)0x00,(byte)0x00,(byte)0x83}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 12:
	        	buf = new byte[]{(byte)0x88,(byte)0x0C,(byte)0x00,(byte)0x00,(byte)0x84}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 13:
	        	buf = new byte[]{(byte)0x88,(byte)0x0D,(byte)0x00,(byte)0x00,(byte)0x85}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 14:
	        	buf = new byte[]{(byte)0x88,(byte)0x0E,(byte)0x00,(byte)0x00,(byte)0x86}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 15:
	        	buf = new byte[]{(byte)0x88,(byte)0x0F,(byte)0x00,(byte)0x00,(byte)0x87}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 16:
	        	buf = new byte[]{(byte)0x88,(byte)0x10,(byte)0x00,(byte)0x00,(byte)0x98}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 17:
	        	buf = new byte[]{(byte)0x88,(byte)0x11,(byte)0x00,(byte)0x00,(byte)0x99}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 18:
	        	buf = new byte[]{(byte)0x88,(byte)0x12,(byte)0x00,(byte)0x00,(byte)0x9A}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 19:
	        	buf = new byte[]{(byte)0x88,(byte)0x13,(byte)0x00,(byte)0x00,(byte)0x9B}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 20:
	        	buf = new byte[]{(byte)0x88,(byte)0x14,(byte)0x00,(byte)0x00,(byte)0x9C}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 21:
	        	buf = new byte[]{(byte)0x88,(byte)0x15,(byte)0x00,(byte)0x00,(byte)0x9D}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 22:
	        	buf = new byte[]{(byte)0x88,(byte)0x16,(byte)0x00,(byte)0x00,(byte)0x9E}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 23:
	        	buf = new byte[]{(byte)0x88,(byte)0x17,(byte)0x00,(byte)0x00,(byte)0x9F}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 24:
	        	buf = new byte[]{(byte)0x88,(byte)0x18,(byte)0x00,(byte)0x00,(byte)0x90}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        case 25:
	        	buf = new byte[]{(byte)0x88,(byte)0x19,(byte)0x00,(byte)0x00,(byte)0x91}; 
	        	try {
	        		os.write(buf);
	        	}
	        	catch(Exception e) {
	        		e.printStackTrace();
	        	}
	        	break;
	        default:
	        	break;
	        }
			return true;
		}
		
	}*/

}