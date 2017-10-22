package com.cryptosasa;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Levit Nudi on 14/10/17.
 */
public class AboutActivity extends AppCompatActivity {
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        startActivity(new Intent(AboutActivity.this, HomeActivity.class));
        finish();
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        ActionBar ab = getSupportActionBar();
        ab.setTitle(Html.fromHtml("<font color=#ffffff>" + getString(R.string.app_name) + "</font>"));
        //ab.setIcon(getResources().getDrawable(R.drawable.ic_action_back));
        if(ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);

        }

        View mainContent = findViewById(R.id.main_content);
        if (mainContent != null) {
            mainContent.setAlpha(0);
            mainContent.animate().alpha(1).setDuration(2000);
        }

        ((TextView)findViewById(R.id.authorLinkedin)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)findViewById(R.id.githubURL)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)findViewById(R.id.apiURL)).setMovementMethod(LinkMovementMethod.getInstance());
        ((TextView)findViewById(R.id.textFieldVersionName)).setText(BuildConfig.VERSION_NAME);

        overridePendingTransition(0, 0);

    }


   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            startActivity(new Intent(AboutActivity.this, HomeActivity.class));
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
