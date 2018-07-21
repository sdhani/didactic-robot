package com.example.android.miwok;


public class Word {
    //lowercase m indicates that thevariables are private

    private String mDefaultTranslation;
    private String mMiwokTranslation;


    public Word(String defaultWord, String miwokWord){
        mDefaultTranslation=  defaultWord;
        mMiwokTranslation = miwokWord;
    }

    public String getMiwokTranslation(){
        return mMiwokTranslation;
    }

    public String getDefaultWord(){
        return mDefaultTranslation;
    }
}
