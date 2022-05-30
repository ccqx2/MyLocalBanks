package sg.edu.rp.c346.id21000243.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvDBS;
    TextView tvOCBC;
    TextView tvUOB;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvDBS = findViewById(R.id.textViewDBS);
        registerForContextMenu(tvDBS);
        tvOCBC = findViewById(R.id.textViewOCBC);
        registerForContextMenu(tvOCBC);
        tvUOB = findViewById(R.id.textViewUOB);
        registerForContextMenu(tvUOB);
    }
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        if (v == tvDBS) {
            wordClicked = "dbs";
        } else if (v == tvOCBC) {
            wordClicked = "ocbc";
        } else if (v == tvUOB) {
            wordClicked = "uob";
        }
        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.english) {
            tvDBS.setText("DBS");
            tvOCBC.setText("OCBC");
            tvUOB.setText("UOB");
            return true;
        } else if (id == R.id.chinese) {
            tvDBS.setText("星展银行");
            tvOCBC.setText("华侨银行");
            tvUOB.setText("大华银行");
            return true;
        } else {
            tvDBS.setText("Error translation");
            tvOCBC.setText("Error translation");
            tvUOB.setText("Error translation");
        }

        return super.onOptionsItemSelected(item);

    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId()==0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.dbs.com.sg/personal/default.page"));
                startActivity(intentView);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18001111111"));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId()==0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.ocbc.com/group/gateway.page"));
                startActivity(intentView);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+63633888));
                startActivity(intentCall);
                return true;
            }
        } else if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId()==0) {
                Intent intentView = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.uobgroup.com/uobgroup/default.page"));
                startActivity(intentView);
                return true;
            } else if (item.getItemId()==1) {
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:18002222121"));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}