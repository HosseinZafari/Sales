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

package hosseinzafari.github.sales.adapter;
/*

@created in 19/06/2020 - 10:10 AM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/


import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import hosseinzafari.github.sales.ui.fragment.StartAccessFragment;
import hosseinzafari.github.sales.ui.fragment.StartIntoFragment;
import hosseinzafari.github.sales.ui.fragment.StartSelectCityFragment;
import hosseinzafari.github.sales.util.GLog;

public class SlideFragmentAdapter extends FragmentStateAdapter {

    private static final int FRAGMENT_COUTN = 3;
    private static final int FRAGMNET_START_INTO   = 0;
    private static final int FRAGMNET_START_ACCESS = 1;
    private static final int FRAGMNET_START_SELECT_CITY = 2;

    public SlideFragmentAdapter(@NonNull FragmentActivity fa) {
        super(fa);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        GLog.i("Postions " + position);

        switch (position){
            case FRAGMNET_START_INTO:
                return new StartIntoFragment();
            case FRAGMNET_START_ACCESS:
                return new StartAccessFragment();
            case FRAGMNET_START_SELECT_CITY:
                return new StartSelectCityFragment();
            default: return null;
        }
    }

    @Override
    public int getItemCount() {
        return FRAGMENT_COUTN;
    }
}
