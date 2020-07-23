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

import androidx.viewpager2.widget.ViewPager2;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.adapter.SlideFragmentAdapter;
import hosseinzafari.github.sales.core.GAppCompatActivity;

public class StartActivity extends GAppCompatActivity {

    public static ViewPager2 viewpager;
    private SlideFragmentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        adapter = new SlideFragmentAdapter(this);
        viewpager = findViewById(R.id.viewPager_Start);
        prepareViewPager();
    }

    private void prepareViewPager(){
        viewpager.setLayoutDirection(View.LAYOUT_DIRECTION_RTL);
        viewpager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (getCurrentPage() == 0){
            super.onBackPressed();
        } else {
            viewpager.setCurrentItem(getCurrentPage() - 1);
        }
    }

    public static int getCurrentPage(){
        return viewpager.getCurrentItem();
    }

}
