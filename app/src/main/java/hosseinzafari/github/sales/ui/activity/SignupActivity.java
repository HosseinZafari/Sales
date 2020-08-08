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
import hosseinzafari.github.sales.data.remote.Api;
import hosseinzafari.github.sales.data.remote.GService;
import hosseinzafari.github.sales.struct.ResponseStdModel;
import hosseinzafari.github.sales.struct.UserModel;
import hosseinzafari.github.sales.util.GError;
import hosseinzafari.github.sales.util.GLog;
import hosseinzafari.github.sales.util.GSuccess;
import hosseinzafari.github.sales.util.UtilActivity;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class SignupActivity extends GAppCompatActivity implements View.OnClickListener {

    private AppCompatEditText edt_name_signup,
            edt_family_signup,
            edt_number_signup,
            edt_password_signup,
            edt_pass_reenter;

    private Spinner spinner;
    private Button button_signup;
    private boolean isLogin = false;

    private Api api;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        setupviews();
        setSpinnerdata();

        api = GService.getApi();
        compositeDisposable = new CompositeDisposable();
    }

    private void setupviews() {
        edt_name_signup = findViewById(R.id.edt_name_signup);
        edt_family_signup = findViewById(R.id.edt_family_signup);
        edt_number_signup = findViewById(R.id.edt_number_signup);
        edt_password_signup = findViewById(R.id.edt_pass_signup);
        edt_pass_reenter = findViewById(R.id.edt_pass_reenter);
        spinner = findViewById(R.id.spinner_jobs);
        button_signup = findViewById(R.id.btn_signup);
        button_signup.setOnClickListener(this);
    }

    private void setSpinnerdata() {
        ArrayAdapter<String> spinerAdapter = new ArrayAdapter<>(
                SignupActivity.this,
                R.layout.item_spinner_signup,
                GDataMemoryKt.getDataSpiner()
        );
        spinner.setAdapter(spinerAdapter);
    }

    @Override
    public void onClick(View v) {
        String name = UtilActivity.getFromEditText(edt_name_signup);
        String family = UtilActivity.getFromEditText(edt_family_signup);
        String number = UtilActivity.getFromEditText(edt_number_signup);
        String pass = UtilActivity.getFromEditText(edt_password_signup);
        String passre = UtilActivity.getFromEditText(edt_pass_reenter);
        String job = spinner.getSelectedItem().toString();

        boolean isValidForm = true;

        if (name.isEmpty()) {
            edt_name_signup.setError("لطفا نام خود را وارد کنید.");
            isValidForm = false;
        }

        if(family.isEmpty()){
            edt_family_signup.setError("لطفا نام خانوادگی خود را وارد کنید.");
            isValidForm = false;
        }

        if(number.isEmpty()){
            edt_number_signup.setError("لطفا شماره همراه خود را وارد کنید.");
            isValidForm = false;
        }

        if (pass.isEmpty()) {
            edt_password_signup.setError("لطفا رمز عبور خود را وارد کنید");
            isValidForm = false;
        }

        if (passre.isEmpty()) {
            edt_pass_reenter.setError("لطفا رمز عبور خود را وارد کنید");
            isValidForm = false;
        }

        if(number.length() != 11) {
            edt_number_signup.setError("لطفا شماره همراه صحیحی وارد نمایید.");
            isValidForm = false;
        }

        if (!pass.contentEquals(passre)) {
            edt_password_signup.setError("رمز عبور شما با تکرار آن مطابقت ندارد");
            edt_pass_reenter.setError("رمز عبور شما با تکرار آن مطابقت ندارد");
            isValidForm = false;
        }

        if (spinner.getSelectedItemId() == 0) {
            toast("لطفا شغل خود را وارد کنید");
            isValidForm = false;
        }

        // Blocked User if is invalid
        if(!isValidForm)
            return;

        signupUser(new UserModel(name , family , number , job , pass) , error -> {
            // Error in Singup
            toast("مشکلی در ثبت نام شما به وجود آمده لطفا بعدا امتحان کنید.");
            GLog.e(error.getMessage());

        } , response-> {
            // Check Result Code
            int code = response.getCode();
            if(code == 400){
                toast("لطفا تمامی فیلد ها را پر کنید.");
            } else if(code == 401) {
                toast("شما قبلا با این شماره همراه ثبت نام کرده اید.");
            } else if (code == 500){
                toast("خطایی پیش آمده.");
            } else {
                // Successfully Signup
                GSharedPref.setIsSubmitApp(true);
                GSharedPref.setName(name);
                GSharedPref.setFamily(family);
                GSharedPref.setNumber(number);
                GSharedPref.setPassword(pass);
                GSharedPref.setJob(job);
                GSharedPref.apply();

                toast("خوش آمدید.");
                UtilActivity.goActivityWithFinish(MainActivity.class);
            }
        });
    }


    private void signupUser(UserModel user , GError error , GSuccess<ResponseStdModel> responseStdModel){
        // Signup Api
        Single<ResponseStdModel> result = api.signup(user.getName() , user.getFamily() , user.getJob() , user.getNumber() , user.getPassword());
        Disposable disposable = result.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(responseStdModel::onSuccess , error::onError);

        compositeDisposable.add(disposable);
    }


    @Override
    protected void onStart() {
        super.onStart();
        isLogin = GSharedPref.isLogin();
    }

    @Override
    protected void onDestroy() {
        compositeDisposable.clear();
        compositeDisposable = null;
        super.onDestroy();
    }
}
