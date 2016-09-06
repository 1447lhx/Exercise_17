package cn.edu.bistu.cs.cnse.edu.bistu.cs.se.sharepreferences;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    private final static String SharePreferencesFileName="info";
    private final static String KEY_SNAME="Sname";
    private final static String KEY_SNUM="Snum";
    private final static String KEY_SCLASS="Sclass";
    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferences=getSharedPreferences(SharePreferencesFileName,MODE_PRIVATE);
        editor=preferences.edit();
        Button read=(Button)findViewById(R.id.btn_Read);
        Button write=(Button)findViewById(R.id.btn_Write);
        write.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                  editor.putString(KEY_SNAME,"Lihuixai");
                 editor.putString(KEY_SNUM,"2014011389");
                editor.putString(KEY_SCLASS,"1410");
                editor.apply();
            }
        });
        read.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
               String Sname=preferences.getString(KEY_SNAME,null);
                String Snum=preferences.getString(KEY_SNUM,null);
                String Sclass=preferences.getString(KEY_SCLASS,null);
                if(Snum!=null)
                    Toast.makeText(MainActivity.this, "姓名:" + Sname + "学号:" + Snum+"班级:"+Sclass, Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
