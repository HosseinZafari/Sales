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

package hosseinzafari.github.sales.util;
/*

@created in 04/06/2020 - 5:50 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import org.jetbrains.annotations.NotNull;

import hosseinzafari.github.sales.core.G;
import hosseinzafari.github.sales.core.GAppCompatActivity;

public class UtilActivity {

    public static GAppCompatActivity appCompatActivity = G.appCompatActivity;


    public UtilActivity fullScreen() {
        appCompatActivity.requestWindowFeature(Window.FEATURE_NO_TITLE);
        appCompatActivity.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN) ;
        return this;
    }

    public UtilActivity setContentView(@LayoutRes int id){
        appCompatActivity.setContentView(id);
        return this;
    }

    public UtilActivity setContentView(@NotNull View view){
        appCompatActivity.setContentView(view);
        return this;
    }

    public UtilActivity setContentView(@NonNull View view , @NonNull ViewGroup.LayoutParams layouParams){
        appCompatActivity.setContentView(view , layouParams);
        return this;
    }

    public static void goActivity(@NotNull Class clazz) {
        appCompatActivity.startActivity(new Intent(G.appCompatActivity, clazz));
    }

}
