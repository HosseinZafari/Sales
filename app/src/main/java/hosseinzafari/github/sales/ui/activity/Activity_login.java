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

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.core.GAppCompatActivity;
import hosseinzafari.github.sales.data.local.shared_pref.GSharedPref;
import hosseinzafari.github.sales.util.UtilActivity;

public class Activity_login extends AppCompatActivity {

    AppCompatEditText edt_name, edt_password, edtpassre;
    Spinner spinner;
    Button button;
    boolean ISLOGIN = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupviews();
        setSpinnerdata();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString().trim();
                String pass = edt_password.getText().toString().trim();
                String passre = edtpassre.getText().toString().trim();
                String job=spinner.getSelectedItem().toString();
                if (name.isEmpty()) {

                    Toast.makeText(Activity_login.this, "لطفا نام خود را وارد کنید.", Toast.LENGTH_SHORT).show();

                } else if (pass.isEmpty()) {
                    Toast.makeText(Activity_login.this, "لطفا رمز عبور خود را وارد کنید", Toast.LENGTH_SHORT).show();
                } else if (!pass.contentEquals(passre)) {
                    Toast.makeText(Activity_login.this, "لطفا روز عبور خود را یکی وارد کنید", Toast.LENGTH_SHORT).show();

                } else if (spinner.getSelectedItemId()==0) {
                    Toast.makeText(Activity_login.this, "لطفا شغل خود را وارد کنید", Toast.LENGTH_SHORT).show();
                }else {

                    GSharedPref.setIsSubmitApp(true);
                    GSharedPref.setNAME(name);
                    GSharedPref.setPASSWORD(pass);
                    GSharedPref.setJOB(job);
                    GSharedPref.apply();
                    UtilActivity.goActivity(MainActivity.class);
                    finish();

                }
            }
        });


    }

    public void setupviews() {
        edt_name = findViewById(R.id.edt_nameamie);
        edt_password = (AppCompatEditText) findViewById(R.id.edt_pass);
        edtpassre = (AppCompatEditText) findViewById(R.id.edt_pass_re);
        spinner = (Spinner) findViewById(R.id.spinner_shoghl);
        button = (Button) findViewById(R.id.btn_login);
    }

    public void setSpinnerdata() {

        String[] ali = {"شغل خود را انتخاب کنید", "دانشجو", "کارمند", "مدیر", "آزاد", "فریلنسر", "دانش آموز"};
        ArrayAdapter<String> sp_adapter = new ArrayAdapter<>
                (Activity_login.this, android.R.layout.simple_spinner_dropdown_item, ali);
        spinner.setAdapter(sp_adapter);
    }
}
