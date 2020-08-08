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
import android.widget.EditText;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.core.GAppCompatActivity;
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

public class LoginActivity extends GAppCompatActivity {

    private EditText edt_number_login;
    private EditText edt_pass_login;

    private Api api;
    private CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // TODO must add logic here

        edt_number_login = findViewById(R.id.edt_number_login);
        edt_pass_login   = findViewById(R.id.edt_pass_login);


        api = GService.getApi();
        compositeDisposable = new CompositeDisposable();
    }

    public void login(View view){
        String number = UtilActivity.getFromEditText(edt_number_login);
        String pass = UtilActivity.getFromEditText(edt_pass_login);

        boolean isValidForm = true;

        if (number.isEmpty()) {
            edt_number_login.setError("لطفا شماره همراه خود را وارد نمایید.");
            isValidForm = false;
        }

        if(pass.isEmpty()) {
            edt_pass_login.setError("لطفا رمز عبور را وارد نمایید.");
            isValidForm = false;
        }

        if(number.length() != 11) {
            edt_number_login.setError("لطفا شماره همراه صحیحی وارد نمایید.");
            isValidForm = false;
        }

        if(isValidForm){
            userLogin(number , pass , response -> {
                int code = response.getCode();

                if(code == 400){
                    toast("لطفا تمامی مقادیر را پر کنید.");
                } else if (code == 401) {
                    toast(response.getDesc());
                } else if(code == 402){
                    toast(response.getDesc());
                } else if(code == 500){
                    toast(response.getDesc());
                } else {
                    UserModel user = response.getUser();
                    String name    = user.getName();
                    String family  = user.getFamily();
                    String job     = user.getJob();
                    String phoneNumber  = user.getNumber();
                    String password = user.getPassword();

                    GSharedPref.setIsSubmitApp(true);
                    GSharedPref.setName(name);
                    GSharedPref.setFamily(family);
                    GSharedPref.setNumber(phoneNumber);
                    GSharedPref.setPassword(password);
                    GSharedPref.setJob(job);
                    GSharedPref.apply();

                    toast("خوش آمدید.");
                    UtilActivity.goActivityWithFinish(MainActivity.class);
                }

            } , error -> {
                toast("مشکلی در ورود شما به وجود آمده لطفا بعدا امتحان کنید.");
                GLog.e(error.getMessage());
            });
        }

    }

    private void userLogin(String number , String pass , GSuccess<ResponseStdModel> success, GError error) {
        Single<ResponseStdModel> result = api.login(number , pass);
        Disposable disposable = result.observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(success::onSuccess , error::onError);

        compositeDisposable.add(disposable);
    }

    public void signupActivity(View view) {
        UtilActivity.goActivity(SignupActivity.class);
    }

}
