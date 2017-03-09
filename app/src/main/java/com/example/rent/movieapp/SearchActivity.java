package com.example.rent.movieapp;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.RadioGroup;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnCheckedChanged;
import butterknife.OnClick;

public class SearchActivity extends AppCompatActivity {

    private Map<Integer, String> apiKeysMap = new HashMap<Integer, String>() {{

        put(R.id.radio_movies, "movie");
        put(R.id.radio_episodes, "episodes");
        put(R.id.radio_games, "game");
        put(R.id.radcio_series, "series");
    }};


    @BindView(R.id.number_picker)
    NumberPicker numberPicker;

    @BindView(R.id.edit_text)
    TextInputEditText editText;

    @BindView(R.id.search_button)
    ImageView searchButton;

    @BindView(R.id.year_checkbox)
    CheckBox yearCheckBox;

    @BindView(R.id.radio_group)
    RadioGroup radioGroup;

    @BindView(R.id.type_checkbox)
    CheckBox typeCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        numberPicker.setMinValue(1950);
        numberPicker.setValue(year);
        numberPicker.setMaxValue(year);
        numberPicker.setWrapSelectorWheel(true);


        TextInputEditText editText = (TextInputEditText) findViewById(R.id.edit_text);


//        ImageButton searchButton = (ImageButton) findViewById(R.id.search_button);
//        searchButton.setOnClickListener(v -> {
//         //tutaj
//        });
    }

    @OnCheckedChanged(R.id.type_checkbox)
    void onTypeStateChanged(CompoundButton buttonview, boolean isChecked) {
        radioGroup.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    }

    @OnCheckedChanged(R.id.year_checkbox)
    void onYearCheckboxStateChanged(CompoundButton buttonview, boolean isChecked) {
        numberPicker.setVisibility(isChecked ? View.VISIBLE : View.GONE);
    }

    //to (tresc metody, nie sama definicja) moze byc wyzej
    @OnClick(R.id.search_button)
    void onSearchButtonClick() {
        int checkedRadioId = radioGroup.getCheckedRadioButtonId();

        String typeKey = typeCheckbox.isChecked()? apiKeysMap.get(checkedRadioId) : null;

        int year = yearCheckBox.isChecked() ? numberPicker.getValue() : ListingActivity.NO_YEAR_SELECTED;
        startActivity(ListingActivity.createIntent(SearchActivity.this, editText.getText().toString(),
                year, typeKey));
    }
}
