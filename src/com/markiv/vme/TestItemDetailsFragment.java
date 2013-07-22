package com.markiv.vme;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.markiv.vme.TestListFragment.TestItem;

public class TestItemDetailsFragment extends Fragment{
	private TextView mText;
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		mText = new TextView(getActivity());
		
		final Bundle args = getArguments();
		if(args != null){
			final TestItem item = (TestItem)args.get("SELECTED");
			setSelectedTestItem(item);
		}
		
		return mText;
	}
	
	public void setSelectedTestItem(TestItem item){
		if(item != null){
			mText.setText(item.toString());
		}
		else{
			mText.setText("Select something you fool!");
		}
	}
}
