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

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import androidx.appcompat.widget.AppCompatEditText;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.core.GAppCompatActivity;
import hosseinzafari.github.sales.data.local.memory.GDataMemoryKt;
import hosseinzafari.github.sales.data.local.shared_pref.GSharedPref;
import hosseinzafari.github.sales.util.UtilActivity;

public class ActivityLogin extends GAppCompatActivity implements View.OnClickListener {

    private AppCompatEditText edt_name, edt_password, edtpassre;
    private Spinner spinner;
    private Button button;
    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupviews();
        setSpinnerdata();
    }

    private void setupviews() {
        edt_name = findViewById(R.id.edt_nameamie);
        edt_password = findViewById(R.id.edt_pass);
        edtpassre = findViewById(R.id.edt_pass_re);
        spinner = findViewById(R.id.spinner_shoghl);
        button = findViewById(R.id.btn_login);
        button.setOnClickListener(this);
    }

    private void setSpinnerdata() {
        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<>(
                ActivityLogin.this,
                android.R.layout.simple_spinner_dropdown_item,
                GDataMemoryKt.getDataSpiner()
        );
        spinner.setAdapter(spinerAdapter);
    }

    @Override
    public void onClick(View v) {
        String name = edt_name.getText().toString().trim();
        String pass = edt_password.getText().toString().trim();
        String passre = edtpassre.getText().toString().trim();
        String job = spinner.getSelectedItem().toString();
        if (name.isEmpty()) {
            toast("لطفا نام خود را وارد کنید.");
        } else if (pass.isEmpty()) {
            toast("لطفا رمز عبور خود را وارد کنید");
        } else if (!pass.contentEquals(passre)) {
            toast("لطفا روز عبور خود را یکی وارد کنید");
        } else if (spinner.getSelectedItemId() == 0) {
            toast("لطفا شغل خود را وارد کنید");
        } else {
            GSharedPref.setIsSubmitApp(true);
            GSharedPref.setName(name);
            GSharedPref.setPassword(pass);
            GSharedPref.setJob(job);
            GSharedPref.apply();
            UtilActivity.goActivity(MainActivity.class);
            finish();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        isLogin = GSharedPref.isLogin();
    }
}
