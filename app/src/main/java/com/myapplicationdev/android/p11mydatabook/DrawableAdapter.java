package com.myapplicationdev.android.p11mydatabook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DrawableAdapter extends ArrayAdapter<Drawable> {

    Context context;
    ArrayList<Drawable> items;
    ImageView icon;
    TextView tvItem;

    public DrawableAdapter(Context context, int resource, ArrayList<Drawable> objects){
        super(context, resource, objects);
        items = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.customdrawable, parent, false);
        icon = rowView.findViewById(R.id.ivIcon);
        tvItem = rowView.findViewById(R.id.tvItem);

        Drawable pos = items.get(position);

        if (pos.getItem().equals("Bio")){
            tvItem.setText("Bio");
            icon.setImageResource(android.R.drawable.ic_dialog_info);
        } else if (pos.getItem().equals("Vaccination")) {
            tvItem.setText("Vaccination");
            icon.setImageResource(android.R.drawable.ic_menu_edit);
        } else if (pos.getItem().equals("Anniversary")){
            tvItem.setText("Anniversary");
            icon.setImageResource(android.R.drawable.ic_menu_my_calendar);
        } else if (pos.getItem().equals("About Us")){
            tvItem.setText("About Us");
            icon.setImageResource(android.R.drawable.btn_star);
        }

        return rowView;
    }
}
