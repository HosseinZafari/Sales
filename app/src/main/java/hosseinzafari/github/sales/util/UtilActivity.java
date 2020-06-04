package hosseinzafari.github.sales.util;
/*

@created in 04/06/2020 - 5:50 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.content.Intent;

import org.jetbrains.annotations.NotNull;

import hosseinzafari.github.sales.core.G;

public class UtilActivity {

     public static void goActivity(@NotNull Class clazz){
         G.appCompatActivity.startActivity(new Intent(G.appCompatActivity , clazz));
     }

}
