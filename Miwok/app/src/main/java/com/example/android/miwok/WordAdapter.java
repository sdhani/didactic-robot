package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//inherits behavior from the
public class WordAdapter extends ArrayAdapter<Word>{

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();

    // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
    // the second argument is used when the ArrayAdapter is populating a single TextView.
    // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
    // going to use this second argument, so it can be any value. Here, we used 0.

    public WordAdapter(Activity context, ArrayList<Word> words){
        super(context, 0, words);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item,parent, false);
        }

        Word currentWord = getItem(position);

        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
            defaultTextView.setText(currentWord.getDefaultWord());

        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
            miwokTextView.setText(currentWord.getMiwokTranslation());

        return listItemView;
    }
}
