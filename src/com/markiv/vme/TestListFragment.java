package com.markiv.vme;

import java.io.Serializable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class TestListFragment extends Fragment implements OnItemClickListener{
	private onTestListItemSelectedListener mListener;
	private ListView mList;
	
	public TestItem[] items = new TestItem[]{new TestItem("Item 1"), new TestItem("Item 2"), new TestItem("Item 3")};
		
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		final ListView list = new ListView(getActivity());
		list.setAdapter(new ArrayAdapter<TestItem>(getActivity(), android.R.layout.simple_list_item_1, items));
		list.setOnItemClickListener(this);
		mList = list;
		return list;
	}
	
	public void setOnTestListItemSelectedListener(onTestListItemSelectedListener listener) {
		this.mListener = listener;
	}
	
	@Override
	public void onItemClick(AdapterView<?> adapter, View view, int position, long id) {
		if(mListener != null){
			mListener.onTestListItemSelected(items[position]);
		}
	}
	
	public void setChoiceModeSingle(){
		mList.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
	}
	
	public static interface onTestListItemSelectedListener{
		public void onTestListItemSelected(TestItem item);
	}
	
	public static class TestItem implements Serializable{
		private String mName;
		
		public TestItem(String name) {
			mName = name;
		}
		
		public String getName() {
			return mName;
		}
		
		public void setName(String name) {
			this.mName = name;
		}
		
		@Override
		public String toString() {
			return mName;
		}
	}
}
