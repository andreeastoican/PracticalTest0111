package ro.pub.cs.systems.pdsd.practicaltest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PracticalTest01MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_main);
        
        
        Button secondaryButton = (Button) findViewById(R.id.second_activity);
        
        
        EditText edit11= (EditText)findViewById(R.id.edit1);
        if (savedInstanceState !=null && savedInstanceState.getString("EDIT1") != null) {
            edit11.setText(savedInstanceState.getString("EDIT1"));
        }
        
        EditText edit12= (EditText)findViewById(R.id.edit2);
        if (savedInstanceState !=null && savedInstanceState.getString("EDIT2") != null) {
            edit12.setText(savedInstanceState.getString("EDIT2"));
        }
        
        
        Button press1 = (Button) findViewById(R.id.press1);
        Button press2 = (Button) findViewById(R.id.press2);
        final EditText edit1 = (EditText) findViewById(R.id.edit1);
        final EditText edit2 = (EditText) findViewById(R.id.edit2);
        
        press1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String string1 = edit1.getText().toString();
				int no1 = Integer.parseInt(string1);
				no1++;
				
				edit1.setText(no1+"");
			}
		});
        
        press2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				String string2 = edit2.getText().toString();
				int no2 = Integer.parseInt(string2);
				no2++;
				edit2.setText(no2+"");
			}
		});
        final Intent intent = new Intent(this, PracticalTest01SecondaryActivity.class);
        secondaryButton.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String string1 = edit1.getText().toString();
				int no1 = Integer.parseInt(string1);
				
				String string2 = edit2.getText().toString();
				int no2 = Integer.parseInt(string2);
				
				int s = no1+no2;
				Intent intent = new Intent(PracticalTest01MainActivity.this, PracticalTest01SecondaryActivity.class);
				intent.putExtra("ro.pub.cs.systems.pdsd.practicaltest01.sum", s+"");
				startActivityForResult(intent, 2015);
			}
		});
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
  	  switch(requestCode) {
  	    case 2015:
  	      if (resultCode == Activity.RESULT_OK) {
  	        String data = intent.getStringExtra("ro.pub.cs.systems.pdsd.practicaltest01.res1");
  	        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
  	      } else {
  	    	String data = intent.getStringExtra("ro.pub.cs.systems.pdsd.practicaltest01.res2");
  	    	Toast.makeText(getApplicationContext(), data, Toast.LENGTH_LONG).show();
  	      }
  	      break;
  	 
  	      // process other request codes
  	  }
  	}

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
      super.onSaveInstanceState(savedInstanceState);
      
      EditText edit1 = (EditText)findViewById(R.id.edit1);
      savedInstanceState.putString("EDIT1", edit1.getText().toString());
      
      EditText edit2 = (EditText)findViewById(R.id.edit2);
      savedInstanceState.putString("EDIT2", edit2.getText().toString());
    }
    /*
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
      super.onRestoreInstanceState(savedInstanceState);
      
      EditText edit1= (EditText)findViewById(R.id.edit1);
      if (savedInstanceState.getString("EDIT1") != null) {
          edit1.setText(savedInstanceState.getString("EDIT1"));
      }
      
      EditText edit2= (EditText)findViewById(R.id.edit2);
      if (savedInstanceState.getString("EDIT2") != null) {
          edit2.setText(savedInstanceState.getString("EDIT2"));
      }
    }
    */

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.practical_test01_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
