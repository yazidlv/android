package com.lebsir.trombi;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;

public class CaseDepart extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_case_depart);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.case_depart, menu);
		Context context = getBaseContext();  
	    DatabaseHelper dbHelper = new DatabaseHelper(context);  
	    dbHelper.formationDB = dbHelper.getWritableDatabase();  
	    return (dbHelper.formationDB == null) ? false : true;   
	
	}

}
