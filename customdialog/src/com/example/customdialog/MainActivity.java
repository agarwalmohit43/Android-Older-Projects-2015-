package com.example.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

	final Context context = this;
	private Button b;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		b=(Button) findViewById(R.id.mainbutton);
		b.setOnClickListener(this);
		
		
	}
	@Override
	public void onClick(View v) {
		final Dialog d=new Dialog(context);
		switch(v.getId()){
		case R.id.mainbutton:
		
		d.setContentView(R.layout.texts);
		d.setTitle("Title...");
		TextView text = (TextView) d.findViewById(R.id.textView1);
		text.setText(getString(R.string.rules));
//		ImageView image = (ImageView) d.findViewById(R.id.imageView1);
//		image.setImageResource(R.drawable.ic_launcher);
//		
//		Button dialogButton = (Button) d.findViewById(R.id.button1);
//		dialogButton.setOnClickListener(new OnClickListener() {
//			
//			@Override
//			public void onClick(View v) {
//				d.dismiss();
//			}
//		});
		d.show();
		break;
//		case R.id.button1:
//			d.dismiss();
//			break;
		}
	}


}
