/*
 * MIT License
 *
 * Copyright (c) 2020.  Hossein Zafari/novinfar
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package hosseinzafari.github.sales.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.TextViewCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.List;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.adapter.RecyclerMainAdapter;
import hosseinzafari.github.sales.core.GAppCompatActivity;
import hosseinzafari.github.sales.data.local.shared_pref.GSharedPref;
import hosseinzafari.github.sales.struct.DataProvider;
import hosseinzafari.github.sales.struct.Person;
import hosseinzafari.github.sales.util.GToast;


public class MainActivity extends GAppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private Toolbar toolbar;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    RecyclerView recyclerView;
    List<Person> people;
    RecyclerMainAdapter mainAdapter;
    RecyclerView.LayoutManager manager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupviews();
        setupNavigationView();
        setupnavigationdata();
        SetRecyclerData();

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        navigationView.setCheckedItem(item);
        // TODO Must Add Menu Logic here
        return true;
    }


    private void setupNavigationView(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this ,
                drawerLayout ,
                toolbar ,
                R.string.OPEN ,
                R.string.CLOSE
        );

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.setNavigationItemSelectedListener(this);

        // TODO navigationView.getBackground().setAlpha(122);
    }
    private  void SetRecyclerData(){



        mainAdapter=new RecyclerMainAdapter(this,people);
        recyclerView.setAdapter(mainAdapter);
        manager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
    }
    private void setupviews(){
        toolbar = findViewById(R.id.toolbar_main);
        navigationView = findViewById(R.id.nav_mn);
        drawerLayout = findViewById(R.id.drawer_layout22);
        recyclerView = findViewById(R.id.rec_main_item);
        people= DataProvider.getdata();

    }
    private void setupnavigationdata(){

        String name=GSharedPref.getSharedPreferences().getString("name","");
        String job=GSharedPref.getSharedPreferences().getString("job","");
        View view=navigationView.getHeaderView(0);
        TextView TXT_NAME=view.findViewById(R.id.txt_name);
        TextView TXT_JOB=view.findViewById(R.id.txt_job);
        TXT_NAME.setText(name);
        TXT_JOB.setText(job);
    }


}
