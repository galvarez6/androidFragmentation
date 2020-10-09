package edu.utep.cs.cs4330.designpattern;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PatternDetailFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_pattern_detail, container, false);
    }//end of onCreateView

    public void setPattern(String name){
        View view = getView();
        TextView nameView = view.findViewById(R.id.nameView);
        nameView.setText(name);
        DesignPattern pattern = DesignPattern.find(name);
        if(pattern != null){
            TextView categoryView = view.findViewById(R.id.categoryView);
            categoryView.setText(pattern.category.name);
            TextView descriptionView = view.findViewById(R.id.descriptionView);
            descriptionView.setText(pattern.description);
        }
    }//end of setPattern


}//end of PatternDetailFragment