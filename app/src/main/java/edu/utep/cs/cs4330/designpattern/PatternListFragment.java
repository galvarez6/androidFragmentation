package edu.utep.cs.cs4330.designpattern;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.fragment.app.ListFragment;

public class PatternListFragment extends ListFragment {

    public interface Listener{
        void patternClicked(String name);
    }

    private Listener listener;

    public View onCreateView(LayoutInflater inflater, ViewGroup containter,
                             Bundle savedInstanceState){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(inflater.getContext(),
                android.R.layout.simple_list_item_1,DesignPattern.names());
        setListAdapter(adapter);
        return super.onCreateView(inflater,containter,savedInstanceState);
    }//end of onCreateView

    public void onListItemClick(ListView listView, View itemView,
                                int position, long id){
        if(listener != null){
            listener.patternClicked((String) listView.getItemAtPosition(position));
        }
    }//end f onListItemClick

    public void setListener(Listener listener){ this.listener = listener; }

}//end of pattern list fragment
