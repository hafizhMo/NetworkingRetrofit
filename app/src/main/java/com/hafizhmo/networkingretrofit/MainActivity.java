package com.hafizhmo.networkingretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.hafizhmo.networkingretrofit.model.Heroes;
import com.hafizhmo.networkingretrofit.network.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tvName = findViewById(R.id.text_name);
        ImageView ivHero = findViewById(R.id.hero_image);

        ApiClient call = new ApiClient();
        call.getApi().getHeroes().enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {
                List<Heroes> heroes = response.body();

                tvName.setText(heroes.get(3).name); //0: Anti-Mage
                Glide.with(getApplicationContext())
                        .load("https://api.opendota.com" + heroes.get(3).image)
                        .placeholder(R.drawable.ic_launcher_background)
                        .into(ivHero);

            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_SHORT).show();
            }
        });

    }
}