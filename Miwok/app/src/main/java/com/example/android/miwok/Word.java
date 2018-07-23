package com.example.android.miwok;


import android.widget.ImageView;

public class Word {
    //lowercase m indicates that thevariables are private

    //constant in all caps
    private static final int NO_IMAGE_PROVIDED = -1; //-1 is out of range of all valid resource id's

    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = NO_IMAGE_PROVIDED;

    public Word(String defaultWord, String miwokWord){
        mDefaultTranslation=  defaultWord;
        mMiwokTranslation = miwokWord;
    }

    public Word(String defaultWord, String miwokWord, int imageResourceId){
        mDefaultTranslation=  defaultWord;
        mMiwokTranslation = miwokWord;
        mImageResourceId = imageResourceId;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultWord(){
        return mDefaultTranslation;
    }

    public int getImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
