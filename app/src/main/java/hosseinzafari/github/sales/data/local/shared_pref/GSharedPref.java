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

package hosseinzafari.github.sales.data.local.shared_pref;
/*
@created in 10/06/2020 - 10:56 AM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.content.Context;
import android.content.SharedPreferences;

import hosseinzafari.github.sales.core.G;

public class GSharedPref {

    private static final String SHARED_PREF_NAME = G.packageName + "_SharedPref_";
    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor sharedEdit;
    private static boolean isSubmitApp;

    static {
        sharedPreferences = G.context.getSharedPreferences(SHARED_PREF_NAME , Context.MODE_PRIVATE);
        sharedEdit = sharedPreferences.edit();
        isSubmitApp = sharedPreferences.getBoolean("submit" , false);
    }

    public static SharedPreferences getSharedPreferences(){
        return sharedPreferences;
    }

    public static SharedPreferences.Editor getSharedEdit() {
        return sharedEdit;
    }

    public static boolean isSubmit(){
        return isSubmitApp;
    }
}


