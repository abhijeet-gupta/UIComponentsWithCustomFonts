package com.customfontscomponents;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.Button;

/**
 * This class is used to set the custom font for the Button.
 */
public class ButtonWithCustomFont extends Button {
    public ButtonWithCustomFont(Context context) {
        super(context);
    }

    public ButtonWithCustomFont(Context context, AttributeSet attrs) {
        super(context, attrs);
        setCustomFont(context, attrs);
    }

    public ButtonWithCustomFont(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setCustomFont(context, attrs);
    }

    private void setCustomFont(Context ctx, AttributeSet attrs) {
        TypedArray a = ctx.obtainStyledAttributes(attrs, R.styleable.ButtonWithCustomFont);
        String customFont = a.getString(R.styleable.ButtonWithCustomFont_customFontForButton);
        setCustomFont(ctx, customFont);
        a.recycle();
    }

    public boolean setCustomFont(Context ctx, String asset) {
        final String TAG = ButtonWithCustomFont.class.getSimpleName();
        Log.e(TAG, "get typeface: " + asset);
        Typeface tf = null;
        try {
            tf = Typeface.createFromAsset(ctx.getAssets(), asset);
        } catch (Exception e) {
            Log.e(TAG, "Could not get typeface: " + e.getMessage());
            return false;
        }
        setTypeface(tf);
        return true;
    }
}