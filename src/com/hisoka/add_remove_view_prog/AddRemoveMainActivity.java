package com.hisoka.add_remove_view_prog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TableRow;
import android.widget.TextView;

public class AddRemoveMainActivity extends Activity {

	Button add,del;
	LinearLayout ll;
	private String[] spinnerContent = {"Ikan","Udang","Kepiting","Kerang"};
	
	
	
	private int count = 0;
	private int line = 0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_remove_main);
			
		ll = (LinearLayout) findViewById(R.id.main_layout);
		
		
		
	}
	
	public void addItems(View view)
	{
		count++;
		
		final LinearLayout frame = new LinearLayout(this);
		frame.setOrientation(LinearLayout.VERTICAL);
		frame.setId(count);
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,spinnerContent);
		
		final TableRow row1 = new TableRow(this);
		final TableRow row2 = new TableRow(this);
		final TableRow row3 = new TableRow(this);
		
		Spinner spin = new Spinner(this);
		TextView jenis = new TextView(this);
		TextView keterangan = new TextView(this);
		TextView total = new TextView(this);
		
		
		spin.setAdapter(adapter);
		jenis.setText("Jenis : "+Integer.toString(count));
		
		keterangan.setText("Keterangan : ");
		total.setText("Jumlah(kg) :");
		
		row1.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		
		row1.addView(jenis);
		row1.addView(spin);
		
		frame.addView(row1);
		
		ll.addView(frame, line);
		line++;
	}
	
	
	public void deleteItems(View view)
	{
		if(count > 0)
		{
			final LinearLayout temp = (LinearLayout)ll.findViewById(count);
			temp.removeAllViews();
			ll.removeView(temp);
			count--;
			line--;
		}
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_remove_main, menu);
		return true;
	}

}
