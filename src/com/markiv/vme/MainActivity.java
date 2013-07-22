package com.markiv.vme;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import com.markiv.vme.TestListFragment.TestItem;
import com.markiv.vme.TestListFragment.onTestListItemSelectedListener;

public class MainActivity extends FragmentActivity implements onTestListItemSelectedListener{
	private TestItemDetailsFragment mDetailsFragment;
	private TestListFragment mListFragment;
	
	@Override
	protected void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.activity_main);
		
		final FragmentManager fragmentManager = getSupportFragmentManager();
		
		mListFragment = (TestListFragment)fragmentManager.findFragmentById(R.id.list);
		mDetailsFragment = (TestItemDetailsFragment)fragmentManager.findFragmentById(R.id.details);
		
		mListFragment.setOnTestListItemSelectedListener(this);
	}
	
	@Override
	public void onTestListItemSelected(TestItem item) {
		if(mDetailsFragment != null){
			//Dual pane
			mDetailsFragment.setSelectedTestItem(item);
			mListFragment.setChoiceModeSingle();
		}
		else{
			final Intent intent = new Intent(this, DetailsActivity.class);
			intent.putExtra("SELECTED", item);
			startActivity(intent);
		}
	}
}
