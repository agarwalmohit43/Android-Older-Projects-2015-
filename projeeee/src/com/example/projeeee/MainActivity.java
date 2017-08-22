package com.example.projeeee;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnClickListener {

	ImageView iv;
	Button z, x, c, vv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		iv = (ImageView) findViewById(R.id.imageView1);
		z = (Button) findViewById(R.id.button1);
		x = (Button) findViewById(R.id.button2);
		c = (Button) findViewById(R.id.button3);
		vv = (Button) findViewById(R.id.button4);
		
		iv.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
//		iv.setVisibility(View.GONE);
//		Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
//        iv.startAnimation(animation);
		z.setVisibility(View.VISIBLE);
		x.setVisibility(View.VISIBLE);
		c.setVisibility(View.VISIBLE);
		vv.setVisibility(View.VISIBLE);
		Animation animation22 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce);
		Animation animation23 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
		Animation animation24 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
		Animation animation25 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);


        z.startAnimation(animation22);
        x.startAnimation(animation23);

        c.startAnimation(animation24);

        vv.startAnimation(animation25);
		
	}

}
