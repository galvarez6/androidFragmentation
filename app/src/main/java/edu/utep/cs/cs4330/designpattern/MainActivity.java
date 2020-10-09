package edu.utep.cs.cs4330.designpattern;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PatternListFragment fragment = (PatternListFragment) getSupportFragmentManager().findFragmentById(R.id.listFragment);
        fragment.setListener(this::patternClicked);

    }//end of onCreate

    private void patternClicked(String name){
        Fragment fragment = getSupportFragmentManager().findFragmentById(R.id.detailFragment);
        if(fragment != null && fragment.isAdded()){
            ((PatternDetailFragment)fragment).setPattern(name);
        }
        else {
            Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, DetailActivity.class);
            intent.putExtra("pattern", name);
            startActivity(intent);
        }
    }//end of intent method

}//end of MainActivity class