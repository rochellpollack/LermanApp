package com.example.rachel.lermanapp;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Rachel on 5/23/2016.
 */
public class DetailActivityFragment extends Fragment {
    private TextView tvContactName;
    private TextView tvHomePhoneNum;
    private TextView tvCellNum;
    private TextView tvEmail;
    private TextView tvAddress;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        Intent intent = getActivity().getIntent();

        //finding the textviews
        tvContactName = (TextView) rootView.findViewById(R.id.tvContactName);
        tvHomePhoneNum = (TextView) rootView.findViewById(R.id.tvHomePhoneNum);
        tvCellNum = (TextView) rootView.findViewById(R.id.tvCellNum);
        tvEmail = (TextView) rootView.findViewById(R.id.tvEmail);
        tvAddress = (TextView) rootView.findViewById(R.id.tvAddress);

        //setting the texts in the textviews
        tvContactName.setText(intent.getStringExtra("first_name") + " " + intent.getStringExtra("last_name"));
        tvHomePhoneNum.setText(intent.getStringExtra("home_phone"));
        tvCellNum.setText(intent.getStringExtra("cell_phone"));
        tvEmail.setText(intent.getStringExtra("email"));
        tvAddress.setText(intent.getStringExtra("street") + "\n" + intent.getStringExtra("city") + " " +
                intent.getStringExtra("zip"));


        return rootView;
    }
}
