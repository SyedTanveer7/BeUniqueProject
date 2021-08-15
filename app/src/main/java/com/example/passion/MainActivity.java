package com.example.passion;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.bio.BioActivity;
import com.example.network.response_models.CategoriesResponse;
import com.example.passion.modals.InterestDataModal;
import com.example.passion.repository.PassionRepository;
import com.example.splashactivity.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private PassionRepository passionRepository;
    private Button btnContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        setContentView(R.layout.activity_main);
        initializeViews();
    }

    @Override
    protected void onStart() {
        super.onStart();

        getCategories();

    }


    private void initializeViews() {
        passionRepository = new PassionRepository(this);

        btnContinue = findViewById(R.id.button);

        btnContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, BioActivity.class));
            }
        });


    }


    private void getCategories() {
        passionRepository.getCategories().observe(this, new Observer<CategoriesResponse>() {
            @Override
            public void onChanged(CategoriesResponse categoriesResponse) {
                if (categoriesResponse != null) {
                    bindCategoriesView(categoriesResponse.getData().getInterests());


                }
            }
        });
    }


    private void bindCategoriesView(List<InterestDataModal> interests) {


    }


}
