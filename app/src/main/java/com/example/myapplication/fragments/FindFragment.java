package com.example.myapplication.fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.R;


public class FindFragment extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view_container = inflater.inflate(R.layout.fragment_find, null);
		TextView tv_title = (TextView) view_container
				.findViewById(R.id.tv_classify_custom_actionbar_title);
		tv_title.setText("发现");
		return view_container;
	}
}
