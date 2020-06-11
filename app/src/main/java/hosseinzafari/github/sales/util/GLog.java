package hosseinzafari.github.sales.util;
/*

@created in 11/06/2020 - 01:10 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.util.Log;
import hosseinzafari.github.sales.BuildConfig;
import hosseinzafari.github.sales.core.G;

public class GLog {
    
    private static final String TAG = G.TAG;
    private static final byte VERBOSE = 1,
    private static final byte DEBUG = 2,
    private static final byte INFO = 3,
    private static final byte WARNING = 4,
    private static final byte ERROR = 5,


    public static void v(String tag , String message){
        checkLog(VERBOSE , tag , message);       
    }
    
    public static void v(String message){
        v(G.TAG , message);       
    }
    
    public static void d(String tag , String message){
        checkLog(VERBOSE , tag , message);       
    }
    
    public static void d(String message){
        d( G.TAG , message);       
    }
    
    public static void i(String tag , String message){
        checkLog(INFO , tag , message);       
    }
    
    public static void i(String message){
        i(G.TAG , message);       
    }
    
    public static void w(String tag , String message){
        checkLog(WARNING , tag , message);       
    }
    
    public static void w(String message){
        i( G.TAG , message);       
    }
    
    public static void e(String tag , String message){
        checkLog(ERROR , tag , message);       
    }
    
    public static void e(String message){
        e( G.TAG , message);       
    }
    
    
    private static void checkLog(byte state, String tag , String text) {
        if (!BuildConfig.DEBUG) { 
            return;
        }

        switch (state) {
            case VERBOSE:
                Log.v(tag , text);
                break;
            case DEBUG:
                Log.d(tag , text);
                break;
            case INFO:
                Log.i(tag , text);
                break;
            case WARNING:
                Log.w(tag , text);
                break;
            case ERROR:
                Log.e(tag , text);
                break;
        }
    }
}
