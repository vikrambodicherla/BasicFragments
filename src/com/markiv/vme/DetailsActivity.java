package com.markiv.vme;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;

import com.markiv.vme.TestListFragment.TestItem;

public class DetailsActivity extends FragmentActivity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if(savedInstanceState == null){
			final TestItemDetailsFragment detailsFragment = new TestItemDetailsFragment();
			
			final TestItem item = (TestItem)getIntent().getSerializableExtra("SELECTED");
			if(item != null){
				final Bundle args = new Bundle();
				args.putSerializable("SELECTED", item);
				detailsFragment.setArguments(args);
			}
			
			FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
			transaction.add(android.R.id.content, detailsFragment).commit();
		}
	}
}
