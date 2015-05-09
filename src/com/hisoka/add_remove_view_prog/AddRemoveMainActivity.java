package com.hisoka.add_remove_view_prog;

import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
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
		
		final TableRow row0 = new TableRow(this);
		final TableRow row1 = new TableRow(this);
		final TableRow row2 = new TableRow(this);
		final TableRow row3 = new TableRow(this);
		
		TextView garis = new TextView(this);
		Spinner spin = new Spinner(this);
		TextView jenis = new TextView(this);
		TextView keterangan = new TextView(this);
		EditText ket = new EditText(this);
		TextView total = new TextView(this);
		EditText tot = new EditText(this);
		
		TableRow.LayoutParams params = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
		params.setMargins(78, 7, 97, 29);
		
		TableRow.LayoutParams params2 = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT);
		params2.setMargins(78, 9, 0, 29);
		
		garis.setText("=======================================");
		garis.setGravity(Gravity.CENTER);
		spin.setAdapter(adapter);
		jenis.setText("Jenis : ");
		//jenis.setLayoutParams(params);
		keterangan.setText("Keterangan : ");
		ket.setHint("Keterangan");
		total.setText("Jumlah(kg) :");
		tot.setHint("total");
		//setRunTimeMargin(jenis,45,0,97,27);
		
		row1.setLayoutParams(new ViewGroup.LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT));
		//ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams)jenis.getLayoutParams();
		//mlp.setMargins(37, 13, 17, 0);
		
		row0.addView(garis);
		row1.addView(jenis,params);
		row1.addView(spin);
		row2.addView(keterangan,params2);
		row2.addView(ket);
		row3.addView(total,params2);
		row3.addView(tot);
		
		frame.addView(row0);
		frame.addView(row1);
		frame.addView(row2);
		frame.addView(row3);
		
		ll.addView(frame, line);
		line++;
		
	}
	
	public static void setRunTimeMargin(View v, int left, int top, int right,
            int bottom) {

  ViewGroup.MarginLayoutParams mlp = (ViewGroup.MarginLayoutParams) v
   .getLayoutParams();

   mlp.setMargins(left, top, right, bottom);
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
