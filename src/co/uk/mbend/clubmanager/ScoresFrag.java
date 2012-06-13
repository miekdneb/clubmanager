package co.uk.mbend.clubmanager;

import co.uk.mbend.clubmanager.InfoText;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
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


public class ScoresFrag extends Fragment
{
	
	Bundle resumeState;
	public static final String PREFS = "ClubManPrefs";
	//public static final int MODE_PRIVATE =0;
	
	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onCreateView(android.view.LayoutInflater, android.view.ViewGroup, android.os.Bundle)
	 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//resumeState = savedInstanceState;
		return inflater.inflate(R.layout.info2, container, false);
		
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onStart()
	 */
	@Override
	public void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		TabHost tabs = (TabHost) getView().findViewById(R.id.tabhost2);
		tabs.setup();
		
		TabSpec tspec1 = tabs.newTabSpec("First Tab2");
		tspec1.setIndicator("General Information");
		tspec1.setContent(R.id.content2);
		tabs.addTab(tspec1);
		
		TabSpec tspec2 = tabs.newTabSpec("Second Tab2");
		tspec2.setIndicator("Constitution");
		tspec2.setContent(R.id.content2);
		tabs.addTab(tspec2);
		
		TabSpec tspec3 = tabs.newTabSpec("Third Tab2");
		tspec3.setIndicator("Rules Of Shooting");
		tspec3.setContent(R.id.content2);
		tabs.addTab(tspec3);
		
		TabSpec tspec4 = tabs.newTabSpec("Fourth Tab2");
		tspec4.setIndicator("Website Guide");
		tspec4.setContent(R.id.content2);
		tabs.addTab(tspec4);
		
		TabSpec tspec5 = tabs.newTabSpec("5th Tab2");
		tspec5.setIndicator("Committee Roles");
		tspec5.setContent(R.id.content2);
		tabs.addTab(tspec5);
		
		TabSpec tspec6 = tabs.newTabSpec("6th Tab2");
		tspec6.setIndicator("Committee Roles");
		tspec6.setContent(R.id.content2);
		tabs.addTab(tspec6);
		
		TabSpec tspec7 = tabs.newTabSpec("7th Tab");
		tspec7.setIndicator("Tits");
		tspec7.setContent(R.id.content2);
		tabs.addTab(tspec7);
		

		tabs.setOnTabChangedListener(new OnTabChangeListener()
		{

			@Override
			public void onTabChanged(String tabId) {
				// TODO Auto-generated method stub
				Log.i("Tab Selected", tabId);
			}
			
		});
	
		/*if(resumeState != null){
			tabs.setCurrentTabByTag(resumeState.getString("tab"));
		}
		else
		{
			Log.i("resumestate"," is 0");
		}*/
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onSaveInstanceState(android.os.Bundle)
	 */
	/*@Override
	public void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
		Log.i("onSaveInstanceState", "called");
		TabHost tabs = (TabHost) getView().findViewById(R.id.tabhost);
		String tabtag = tabs.getCurrentTabTag();
		Log.i("tabselected:", tabtag);
		outState.putString("tab", tabtag);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onPause()
	 */
	@Override
	public void onPause() {
		// TODO Auto-generated method stub
		super.onPause();
		Log.i("onPause Scores", "called");
		String tabtag = ((TabHost) getView().findViewById(R.id.tabhost2)).getCurrentTabTag();
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
		SharedPreferences.Editor editor = settings.edit();
		editor.putString("ScoreTab", tabtag);
		editor.commit();
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onResume()
	 */
	@Override
	public void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		Log.i("onresume", "called");
		SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(getActivity());
		String pasttab = settings.getString("ScoreTab", "7th Tab");
		((TabHost) getView().findViewById(R.id.tabhost2)).setCurrentTabByTag(pasttab);
	}

	/* (non-Javadoc)
	 * @see android.support.v4.app.Fragment#onDestroy()
	 */
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.i("ondestroy", "called");
	}



	
	
}
