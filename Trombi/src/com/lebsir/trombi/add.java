package com.lebsir.trombi;
import android.app.Activity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;



public class add extends Activity {
	



	public class AjoutProfil extends Activity {
		
		private Requet RBDD;
		private profil profil;
		private ImageView image;
		
	    @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.add);
	        profil = new profil();
	        profil.setImage(null);
	        image = (ImageView) findViewById(R.id.imageView1);
	        Button b= (Button) findViewById(R.id.Take);
	        final EditText et1 = (EditText)findViewById(R.id.NomEleve);
	        final EditText et2 = (EditText)findViewById(R.id.Prenom);
	     
	        b.setOnClickListener(
	        	new OnClickListener() {
	        	    @Override
	        	    public void onClick(View v) {
	        	    	Intent intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
	        	        startActivityForResult(intent, 0);
	        	    }
	        	}
	        );
	        
	        RBDD = new Requet(this);
	        RBDD.open();
	        
	        Button ajouter = (Button) findViewById(R.id.ajout);
	        ajouter.setOnClickListener(
	            	new OnClickListener() {
						@Override
						public void onClick(View v) {			
							profil.setNom(et1.getText().toString());
							profil.setPrenom(et2.getText().toString());
							RBDD.ajouter(profil);
						}
	            	}
	        );     	
	    }
	    
	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    	super.onActivityResult(requestCode, resultCode, data);
	    	Bitmap bit= (Bitmap) data.getExtras().get("data");
	    	Uri uri=(Uri) data.getData();
	    	bit = BitmapFactory.decodeFile(getRealPathFromURI(uri));
	    	image.setImageBitmap(bit);
	    	profil.setImage(getRealPathFromURI(uri));// modifier la ref de l'imagesinon mettre un string pour récupérer le nom donner par la machine
	    }
	    
		public String getRealPathFromURI(Uri contentUri) {
	        String[] proj = { MediaStore.Images.Media.DATA };
	        Cursor cursor = managedQuery(contentUri, proj, null, null, null);
	        int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
	        cursor.moveToFirst();
	        return cursor.getString(column_index);
	    }


	}
}


