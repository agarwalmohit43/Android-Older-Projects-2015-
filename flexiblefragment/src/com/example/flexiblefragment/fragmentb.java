package com.example.flexiblefragment;

import android.app.Fragment;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class fragmentb extends Fragment {

	TextView tv;
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fragmentb,container,false);
		
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);
		tv=(TextView) getActivity().findViewById(R.id.textView1);
	}

	public void changedata(int i) {

		Resources rs=getResources();
		String[] des=rs.getStringArray(R.array.description);
		tv.setText(des[i]);
	}
}
