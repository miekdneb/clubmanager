package uk.co.mbend.clubmanager;

import android.app.Activity;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MenuFrag extends ListFragment {

	OnMenuSelectListener mSelect;

	public interface OnMenuSelectListener {
		public void onMenuItemSelected(int position);
	}

	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		setListAdapter(new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1,
				uk.co.mbend.clubmanager.Menuitems.Names)); // Creates list using
															// string of menu
															// items in
															// Menuitems.java

	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);

		try {
			mSelect = (OnMenuSelectListener) activity;
		} catch (ClassCastException e) {
		}
	}

	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		// TODO Auto-generated method stub
		super.onListItemClick(l, v, position, id);
		// This is what is done when an item is clicked (denoted by id)
		Log.i("FragmentList", "Item clicked: " + id);
		mSelect.onMenuItemSelected(position);
	}

}
