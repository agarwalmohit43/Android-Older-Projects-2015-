package com.drwaer2.robotics;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.drwaer2.R;

public class rocombatimageadap extends PagerAdapter {

	Context context;
	private int[] image={R.drawable.techcombat1};

	public rocombatimageadap(Context context) {
		this.context=context;
	}

	

	public int getCount() {
		return image.length;
	}

	public boolean isViewFromObject(View view, Object object) {
		return view==((ImageView) object);
	}
	
	@Override
	public Object instantiateItem(ViewGroup container, int position) {

		LayoutParams lp=new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
		ImageView img=new ImageView(context);
		img.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
		img.setImageResource(image[position]);
		((ViewPager) container).addView(img, 0);
		return img;
	}
	public void destroyItem(ViewGroup container, int position, Object object) {
		((ViewPager) container).removeView((ImageView) object);
	}
	

}
