package com.example.hm15customizedlistview;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.List;

public class MyCustomizedLayout extends ArrayAdapter {

    private final Activity context;
    private final String[] maintitle;
    private final String[] subtitle;

    public MyCustomizedLayout(Activity context, String[] maintitle, String[] subtitle) {
        super(context, R.layout.mylayout, maintitle);
        this.context = context;
        this.maintitle = maintitle;
        this.subtitle = subtitle;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View layout=inflater.inflate( R.layout.mylayout, null,true);
        TextView titleHeading = layout.findViewById(R.id.textView);
        TextView titleDetails = layout.findViewById(R.id.textView2);
        titleHeading.setText(maintitle[position]);
        titleDetails.setText(subtitle[position]);
        return layout;
    }
}
