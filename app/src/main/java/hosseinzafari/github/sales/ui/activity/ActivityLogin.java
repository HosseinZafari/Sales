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
import android.widget.Button;

import androidx.appcompat.widget.AppCompatEditText;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.core.GAppCompatActivity;
import hosseinzafari.github.sales.data.local.shared_pref.GSharedPref;
import hosseinzafari.github.sales.util.UtilActivity;

public class ActivityLogin extends GAppCompatActivity {

    private AppCompatEditText edt_name_login, edt_password_login;
    private Button button_login;
    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setupviews();
    }

    private void setupviews() {
//        edt_name_login = findViewById(R.id.edt_login);
//        edt_password_login = findViewById(R.id.edt_pass_login);
//        button_login = findViewById(R.id.btn_login);
//        button_login.setOnClickListener(this);
    }


  //  @Override
    //public void onClick(View v) {
//        String name = edt_name_login.getText().toString().trim();
//        String pass = edt_password_login.getText().toString().trim();
//        String name_shared = GSharedPref.getSharedPreferences().getString("name", null);
//        String pass_shared = GSharedPref.getSharedPreferences().getString("pass", null);
//
//        if (name.isEmpty()) {
//            toast("لطفا ایمیل  خود را وارد کنید.");
//        } else if (pass.isEmpty()) {
//            toast("لطفا رمز عبور خود را وارد کنید");
//        } else {
//            if (name.contentEquals(name_shared) && pass.contentEquals(pass_shared)) {
//
//                GSharedPref.setIsSubmitApp(true);
//                GSharedPref.apply();
//                UtilActivity.goActivity(MainActivity.class);
//                finish();
//
//            }
//        }
//    }

    @Override
    protected void onStart() {
        super.onStart();
        isLogin = GSharedPref.isLogin();
    }

    public void set_signup_activity(View view) {
        UtilActivity.goActivity(SignupActivity.class);
    }
}
