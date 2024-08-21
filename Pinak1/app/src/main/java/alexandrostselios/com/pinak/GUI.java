package alexandrostselios.com.pinak;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import alexandrostselios.com.pinak.databinding.ActivityGuiBinding;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class GUI extends AppCompatActivity {

    private AppBarConfiguration appBarConfiguration;
    private ActivityGuiBinding binding;

    private TextView roundScore = null;

    private EditText score1EditText;
    private EditText score2EditText;

    private EditText currentScore1;
    private EditText currentScore2;

    private CheckBox firstTeam1 = null;
    private CheckBox firstTeam2 = null;
    private Pinak pinak=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityGuiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        appBarConfiguration = new AppBarConfiguration.Builder(navController.getGraph()).build();
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);

        createButtons();
        createEditText();
        pinak = new Pinak();
    }

    private void createButtons(){
//        binding.fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAnchorView(R.id.fab)
//                        .setAction("Action", null).show();
//            }
//        });

        roundScore = (TextView) findViewById(R.id.roundPoints);
        roundScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pinak.PlayPinak(currentScore1,currentScore2,firstTeam1,firstTeam2,GUI.this);
                setScore();
                clear();
            }
        });

        firstTeam1 = (CheckBox) findViewById(R.id.firstTeam1);
        firstTeam1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstTeam2.isChecked()) {
                    firstTeam2.setChecked(false);
                }
            }
        });

        firstTeam2 = (CheckBox) findViewById(R.id.firstTeam2);
        firstTeam2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(firstTeam1.isChecked()) {
                    //Toast.makeText(GUI.this, "1st Team is First", Toast.LENGTH_SHORT).show();
                    firstTeam1.setChecked(false);
                }
            }
        });
    }

    private void createEditText() {
        score1EditText = (EditText) findViewById(R.id.score1EditText);
        score1EditText.setText(String.valueOf(""));
        score2EditText = (EditText) findViewById(R.id.score2EditText);
        score2EditText.setText(String.valueOf(""));
        currentScore1 = (EditText) findViewById(R.id.currentScore1);
        currentScore1.setText(String.valueOf("0"));
        currentScore2 = (EditText) findViewById(R.id.currentScore2);
        currentScore2.setText(String.valueOf("0"));
    }

    public void setScore() {
        score1EditText.setText(String.valueOf(pinak.getScoreTeam1()));
        score2EditText.setText(String.valueOf(pinak.getScoreTeam2()));
    }

    public void clear() {
        currentScore1.setText(String.valueOf("0"));
        currentScore2.setText(String.valueOf("0"));
        firstTeam1.setChecked(false);
        firstTeam2.setChecked(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_new) {
            Toast.makeText(GUI.this, getResources().getString(R.string.action_new), Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_save) {
            Toast.makeText(GUI.this, getResources().getString(R.string.action_save), Toast.LENGTH_SHORT).show();
            return true;
        } else{
            Toast.makeText(GUI.this, "Version: "+ getResources().getString(R.string.action_about_version), Toast.LENGTH_SHORT).show();
            return true;
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, appBarConfiguration)
                || super.onSupportNavigateUp();
    }
}