package hosseinzafari.github.sales.core;
/*

@created in 04/06/2020 - 1:14 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.app.Application;
import android.content.Context;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class G extends Application {

    public static Handler handler;
    public static Context context;
    public static AppCompatActivity appCompatActivity;

    @Override
    public void onCreate() {
        super.onCreate();

        context = getApplicationContext();
        handler = handler;
    }

}
