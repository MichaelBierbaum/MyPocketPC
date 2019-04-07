package de.maestro979546.MyPocketPC;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener 
		, TextToSpeech.OnInitListener
        , View.OnClickListener{
    private TextToSpeech tts;
    EditText inputTTS;
    Button buttonDeu;
    Button buttonEng;								

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        tts  = new TextToSpeech(this, this);
        inputTTS = (EditText) findViewById(R.id.inputTTS);
        buttonDeu = (Button) findViewById(R.id.btnTTSinDeu);
        buttonEng = (Button) findViewById(R.id.btnTTSinEng);
        buttonDeu.setOnClickListener(this);
        buttonEng.setOnClickListener(this);
    }

    /*
    fuer Interface TextToSpeech.OnInitListener
     */
    @Override
    public void onInit(int status){
        //ab jetzt ist TTS bereit zu sprechen
        tts.setLanguage(Locale.GERMAN);
    }

    /*
    fuer OnClickListener, wenn Button gedrueckt wird
     */
    @Override
    public void onClick(View v){
        tts.setLanguage(Locale.GERMAN);//default ist deutsch
        switch(v.getId()){
            case R.id.btnTTSinDeu: {
                tts.speak(inputTTS.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                break;
                }
            case R.id.btnTTSinEng: {
                tts.setLanguage(Locale.ENGLISH);
                tts.speak(inputTTS.getText().toString(), TextToSpeech.QUEUE_ADD, null);
                break;
            }

            case R.id.btnTTSja:{tts.speak("ja", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSvielleicht:{tts.speak("vielleicht", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSnein:{tts.speak("nein", TextToSpeech.QUEUE_ADD, null);break;}

            case R.id.btnTTSfrueher:{tts.speak("früher", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSjetzt:{tts.speak("jetzt", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSspaeter:{tts.speak("später", TextToSpeech.QUEUE_ADD, null);break;}

            case R.id.btnTTSbitte:{tts.speak("Bitte", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSdanke:{tts.speak("Danke", TextToSpeech.QUEUE_ADD, null);break;}

            case R.id.btnTTSWieGehtsDir:{tts.speak("Wie geht es Dir?", TextToSpeech.QUEUE_ADD, null);break;}
            case R.id.btnTTSpasstscho:{tts.speak("Passt scho.", TextToSpeech.QUEUE_ADD, null);break;}
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

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

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            View currentFocus = getWindow().getCurrentFocus();
            if(currentFocus !=null){
                View rootView = currentFocus.getRootView();
                rootView.setBackground(getResources().getDrawable(R.drawable.ironman));
            }
        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
