package com.lebsir.trombi;





import com.lebsir.trombinoscope.R;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.AdapterView.OnItemClickListener;



public class CaseDepart extends Activity {
	LinearLayout layoutGlobal = null;
	Button EXIT, ADD, VIEW;

	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.activity_case_depart);
	        GridView gridView = (GridView) findViewById(R.id.ContactList);
	    
	        gridView.setOnItemClickListener(new OnItemClickListener() {
	            @Override
	            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
	                Intent i = null;
	                if(position==0){
	                    i= new Intent(getApplicationContext(),add.class);
	                }
	                else if(position==1){
	                    i= new Intent(getApplicationContext(),view_list.class);
	                }
	                else if(position==2){
	                	i= new Intent(getApplicationContext(),profil.class);
	                }
	                startActivity(i);
	            }
	        });
	    }

	    @Override
	    public boolean onCreateOptionsMenu(Menu menu) {
			// Inflate the menu; this adds items to the action bar if it is present.
			getMenuInflater().inflate(R.menu.main, menu);
			return true;
		}

		
	}
	
	


