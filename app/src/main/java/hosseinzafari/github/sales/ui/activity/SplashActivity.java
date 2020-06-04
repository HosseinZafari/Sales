package hosseinzafari.github.sales.ui.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.core.G;
import hosseinzafari.github.sales.core.GAppCompatActivity;


class SplashActivity extends GAppCompatActivity {

    private static final long TIME_DELAY = 3000;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        G.handler.postDelayed(() -> {

            // TODO Logic this here

        }, TIME_DELAY);
    }


}
