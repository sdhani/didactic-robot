package com.example.android.cookies;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Called when the cookie should be eaten.
     */
    public void eatCookie(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookieStatus = (ImageView) findViewById(R.id.android_cookie_image_view);
        cookieStatus.setImageResource(R.drawable.after_cookie);

        TextView cookieMessage = (TextView) findViewById(R.id.status_text_view);
        cookieMessage.setText("I'm so full");

        // TODO: Find a reference to the TextView in the layout. Change the text.

    }

    public void reset(View view) {
        // TODO: Find a reference to the ImageView in the layout. Change the image.
        ImageView cookieStatus = (ImageView) findViewById(R.id.android_cookie_image_view);
        cookieStatus.setImageResource(R.drawable.before_cookie);

        TextView cookieMessage = (TextView) findViewById(R.id.status_text_view);
        cookieMessage.setText("I'm so hungry");
        // TODO: Find a reference to the TextView in the layout. Change the text.

    }
}