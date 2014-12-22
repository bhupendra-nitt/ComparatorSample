package com.example.samplecomparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnClickListener {
	
	private ListView list;
	private Button btnAsc;
	private Button btnDsc;
	
	private List<String> stringList;
	private StringAdapter adapter;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		list = (ListView) findViewById(R.id.listView1);
		btnAsc = (Button) findViewById(R.id.button1);
		btnDsc = (Button) findViewById(R.id.button2);
		
		stringList = new ArrayList<String>();
		stringList.add("Ajay");
		stringList.add("Balram");
		stringList.add("chetan");
		stringList.add("Deepak");
		stringList.add("Febin");
		stringList.add("Gyani");
		stringList.add("Harmeet");
		stringList.add("kapil");
		stringList.add("laxman");
		stringList.add("om");
		stringList.add("Ram");
		
		adapter = new StringAdapter(MainActivity.this ,R.id.listView1, stringList );
		list.setAdapter(adapter);
		
		btnAsc.setOnClickListener(this);
		btnDsc.setOnClickListener(this);
	}
	
    public static Comparator<String> StringAscComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;
            
            return stringName1.compareToIgnoreCase(stringName2);
        }
    };
    
    public static Comparator<String> StringDescComparator = new Comparator<String>() {

        public int compare(String app1, String app2) {

            String stringName1 = app1;
            String stringName2 = app2;
            
            return stringName2.compareToIgnoreCase(stringName1);
        }
    };

    
    
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
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

	
	
	
	 private class StringAdapter extends ArrayAdapter<String> {
	        // Attributes
	        private List<String> strModel;

	        public StringAdapter(Context context, int textViewResourceId,
	                List<String> strModel) {
	            super(context, textViewResourceId, strModel);
	            this.strModel = strModel;
	        }

	        @Override
	        public View getView(int position, View convertView, ViewGroup parent) {
	            View view = convertView;
	            Holder holder = null;

	            if (view == null) {
	                view = View.inflate(MainActivity.this,
	                        R.layout.row_item, null);

	                holder = new Holder();
	                holder.StringNameTextView = (TextView) view
	                        .findViewById(R.id.textView1);

	                view.setTag(holder);
	            } else {
	                holder = (Holder) view.getTag();
	            }
	            String nameText=strModel.get(position);
	            holder.StringNameTextView.setText(nameText);
	            return view;
	        }
	    }
	    
	    static class Holder
	    {
	        private TextView StringNameTextView;

//			public TextView getStringNameTextView() {
//				return StringNameTextView;
//			}
//
//			public void setStringNameTextView(TextView stringNameTextView) {
//				StringNameTextView = stringNameTextView;
//			}
//
//			public Holder(TextView stringNameTextView) {
//				super();
//				StringNameTextView = stringNameTextView;
//			}
	        
	        
	    }

	    @Override
	    public void onClick(View v) {

	        switch(v.getId()) {
	        case R.id.button1 :
	            Collections.sort(stringList, StringAscComparator);
	            Toast.makeText(MainActivity.this, "Sorting in Ascending Order", Toast.LENGTH_LONG).show();
	            break;
	        case R.id.button2 :
	            Collections.sort(stringList, StringDescComparator);
	            Toast.makeText(MainActivity.this, "Sorting in Descending Order", Toast.LENGTH_LONG).show();
	            break;
	        }
	        adapter.notifyDataSetChanged();
	        
	    }
}
