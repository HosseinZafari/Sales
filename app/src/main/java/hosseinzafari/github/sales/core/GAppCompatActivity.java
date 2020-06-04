package hosseinzafari.github.sales.core;
/*
@created in 04/06/2020 - 6:24 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

/**
 * this is a base Activity and we can config this before another Acitvityes
 * we do must extends this class .
 */

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GAppCompatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // set current activity for access it and use easy another classes
        G.appCompatActivity = this;
    }
}
