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

package hosseinzafari.github.sales.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.adapter.RecyclerViewCityAdapter;
import hosseinzafari.github.sales.core.G;
import hosseinzafari.github.sales.data.local.memory.GDataMemoryKt;
import hosseinzafari.github.sales.ui.activity.LoginActivity;
import hosseinzafari.github.sales.util.GToast;
import hosseinzafari.github.sales.util.UtilActivity;

/*

@created in 19/06/2020 - 10:14 AM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

public class StartSelectCityFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerViewCityAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        adapter = new RecyclerViewCityAdapter(GDataMemoryKt.getCityData());

        return inflater.inflate(R.layout.fragment_start_select_city, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        recyclerView = view.findViewById(R.id.rv_city);
        recyclerView.setAdapter(adapter);

        // submit viewpager and go ActivityMain
        Button btn_submit = view.findViewById(R.id.btn_submit_viewpager);
        btn_submit.setOnClickListener(v -> {
            // Control if is no Selected
            if(checkNoSelectedItemCity()){
                GToast.show("لطفا شهر خود را انتخاب کنید.", false);
                return;
            }

            // TODO must change to ActivityMain
            UtilActivity.goActivity(LoginActivity.class);
            G.currentActivity.finish();
        });
    }

    private boolean checkNoSelectedItemCity(){
        return adapter.getLastSelectedCity() == RecyclerViewCityAdapter.NO_SELECTED;
    }
}
