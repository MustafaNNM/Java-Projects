package com.tr.kodgraf.httpexample;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class Main extends Activity {

	TextView loadingData;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        loadingData = (TextView) findViewById(R.id.tvLoadingData); 
        GetHTTPMethod test = new GetHTTPMethod();
        String myData;
        try {
			myData = test.getInternetData();
        		loadingData.setText(myData);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    
}
