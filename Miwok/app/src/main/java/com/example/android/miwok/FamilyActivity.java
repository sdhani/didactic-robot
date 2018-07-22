package com.example.android.miwok;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("father", "әpә"));
        words.add(new Word("mother", "әṭa"));
        words.add(new Word("son", "angsi"));
        words.add(new Word("daughter", "tune"));
        words.add(new Word("older brother", "taachi"));
        words.add(new Word("younger brother", "chalitti"));
        words.add(new Word("older sister", "teṭe"));
        words.add(new Word("younger sister", "kolliti"));
        words.add(new Word("grandmother", "ama"));
        words.add(new Word("grandfather", "paapa"));


        Log.v("FamilyActivity" , "Words " + words.get(5));

        //ListView + Array Adapter = Recycler View


        /**
         * ArrayAdapter handles making the List or Array or ArrayList
         * into a list item view.
         * Could also be connected to a GridView object.
         * */
        WordAdapter adapter =
                new WordAdapter(this, words);


        /**
         *The ListView is a container for the Array Adapter and maintains
         * the state on where the user us within the entire list.
         */

        ListView listView = (ListView)findViewById(R.id.list);

        /**
         * Connects/sets the ArrayAdapter to the ListView list id in xml
         */
        listView.setAdapter(adapter);
    }
}
