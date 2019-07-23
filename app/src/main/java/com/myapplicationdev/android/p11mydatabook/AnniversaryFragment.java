package com.myapplicationdev.android.p11mydatabook;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AnniversaryFragment extends Fragment {

    TextView tvAnniversary;
    Button btnEdit;
    FloatingActionButton fab;

    public AnniversaryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.anniversaryfragment, container, false);

        tvAnniversary = view.findViewById(R.id.tvAnniversary);
        btnEdit = view.findViewById(R.id.btnEdit);
        fab = view.findViewById(R.id.fab);

        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.editdialog, null);

                final TextView tv = viewDialog.findViewById(R.id.textView);
                final EditText et = viewDialog.findViewById(R.id.editText);
                tv.setText("Edit Anniversary");

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(getActivity());
                myBuilder.setView(viewDialog);

                myBuilder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String anniversary = et.getText().toString().trim();
                        tvAnniversary.setText(anniversary);

                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
                        SharedPreferences.Editor prefEdit = prefs.edit();
                        prefEdit.putString("anniversary", anniversary);
                        prefEdit.commit();
                    }
                });

                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getActivity());
        String anniversary = prefs.getString("anniversary", "");
        tvAnniversary.setText(anniversary);

    }

}
