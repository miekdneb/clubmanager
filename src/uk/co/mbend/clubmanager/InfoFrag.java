package uk.co.mbend.clubmanager;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;


//use shared variable in separate file (menuitems.java?/menu.java) to record current tab? - can be blanked on app launch (splashscreen?)



public class InfoFrag extends Fragment {

	TextView tabContentTitle;
	TextView tabContentText;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater,
	 * android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		return inflater.inflate(R.layout.info, container, false);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onStart()
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		if(((TabHost) getView().findViewById(R.id.tabhost))
				.getCurrentTabTag()!=null)
		{
			Log.i("Tabs","Already Created");
		}
		else
		{
			Log.i("Tabs","not Present");
			tabContentTitle= (TextView) getView().findViewById(R.id.tabtitle);
			tabContentText= (TextView) getView().findViewById(R.id.tabtext);
		
			TabHost tabs = (TabHost) getView().findViewById(R.id.tabhost);
			tabs.setup();
		
			TabSpec tspec1 = tabs.newTabSpec("0");
			tspec1.setIndicator("General Information");
			tspec1.setContent(R.id.content);
			tabs.addTab(tspec1);
		
			TabSpec tspec2 = tabs.newTabSpec("1");
			tspec2.setIndicator("Constitution");
			tspec2.setContent(R.id.content);
			tabs.addTab(tspec2);
		
			TabSpec tspec3 = tabs.newTabSpec("2");
			tspec3.setIndicator("Rules Of Shooting");
			tspec3.setContent(R.id.content);
			tabs.addTab(tspec3);
		
			TabSpec tspec4 = tabs.newTabSpec("3");
			tspec4.setIndicator("Website Guide");
			tspec4.setContent(R.id.content);
			tabs.addTab(tspec4);
			
			TabSpec tspec5 = tabs.newTabSpec("4");
			tspec5.setIndicator("Committee Roles");
			tspec5.setContent(R.id.content);
			tabs.addTab(tspec5);
		
			TabSpec tspec6 = tabs.newTabSpec("5");
			tspec6.setIndicator("Promotional Material");
			tspec6.setContent(R.id.content);
			tabs.addTab(tspec6);
		
			//TabSpec tspec7 = tabs.newTabSpec("7");
			//tspec7.setIndicator("test");
			//tspec7.setContent(R.id.content);
			//tabs.addTab(tspec7);		
			
			
			tabContentTitle.setTextSize(24);
			tabs.setOnTabChangedListener(new OnTabChangeListener()
			{
				
				@Override
				public void onTabChanged(String tabId) 
				{
					// TODO Auto-generated method stub
					Log.i("Tab Selected", tabId);
					int tabIdInt= Integer.parseInt(tabId);
					tabContentTitle.setText(uk.co.mbend.clubmanager.InfoText.Tabs[tabIdInt]);
					tabContentText.setText(uk.co.mbend.clubmanager.InfoText.Information[tabIdInt]);
				}
			
			});
			tabs.setCurrentTabByTag("2");
		
		}
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onPause()
	 */
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();

		String tabtag = ((TabHost) getView().findViewById(R.id.tabhost))
				.getCurrentTabTag();
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("InfoTab", tabtag);
		editor.commit();
		Log.i("last tab used (pause):", tabtag);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("onresume", "called");
		SharedPreferences settings = PreferenceManager
				.getDefaultSharedPreferences(getActivity());
		String pasttab = settings.getString("InfoTab", "0");
		((TabHost) getView().findViewById(R.id.tabhost))
				.setCurrentTabByTag(pasttab);
		//int tabIdInt= Integer.parseInt(pasttab);
		//tabContentTitle.setText(co.uk.mbend.clubmanager.InfoText.Tabs[tabIdInt]);
		//tabContentText.setText(co.uk.mbend.clubmanager.InfoText.Information[tabIdInt]);

	}
}
