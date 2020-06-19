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

@created in 19/06/2020 - 1:08 PM
@project Sales
@author Hossein Zafari 
@email  hosseinzafari2000@gmail.com 
*/

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.struct.CityModel;
import hosseinzafari.github.sales.util.ExtensionsKt;

public class RecyclerViewCityAdapter extends RecyclerView.Adapter<RecyclerViewCityAdapter.CityViewHolder> {

    private List<CityModel> data;
    private int lastSelectedCity = -1;

    public RecyclerViewCityAdapter(List<CityModel> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new CityViewHolder(ExtensionsKt.inflate(parent, R.layout.item_city));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        CityModel cityModel = data.get(position);
        holder.bind(cityModel);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    class CityViewHolder extends RecyclerView.ViewHolder {
        private AppCompatTextView txt_name_city;
        private AppCompatImageView img_selected_city;
        private View root;

        public CityViewHolder(View v) {
            super(v);
            root = v;
            txt_name_city = v.findViewById(R.id.txt_name_city);
            img_selected_city = v.findViewById(R.id.img_selected_city);
        }


        private void bind(CityModel cityModel) {
            txt_name_city.setText(cityModel.getName());


            if(lastSelectedCity == cityModel.getId()){
                img_selected_city.setVisibility(View.VISIBLE);
            } else {
                img_selected_city.setVisibility(View.GONE);
            }

            root.setOnClickListener(v -> {
                setTick(cityModel.getId());
            });
        }


        private void setTick(int id){
            if (img_selected_city.getVisibility() == View.GONE){
                img_selected_city.setVisibility(View.VISIBLE);
                lastSelectedCity = id;
                notifyDataSetChanged();
            }
        }

    }
}
