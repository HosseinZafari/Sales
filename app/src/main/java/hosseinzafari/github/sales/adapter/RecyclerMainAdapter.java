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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;
import hosseinzafari.github.sales.R;
import hosseinzafari.github.sales.struct.DataProvider;
import hosseinzafari.github.sales.struct.Person;

public class RecyclerMainAdapter extends RecyclerView.Adapter {
     Context context;
     List<Person> peaplelist;

    public RecyclerMainAdapter(Context context, List<Person> peaplelist) {
        this.context = context;
        this.peaplelist = peaplelist;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.recycler_item_main,parent,false);
        return new Itemviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
     Itemviewholder itemviewholder= (Itemviewholder) holder;
     Person person=peaplelist.get(position);
     itemviewholder.name.setText(person.getName());
     itemviewholder.field.setText(person.getField());
     itemviewholder.imageView.setImageResource(person.getImage());

    }

    @Override
    public int getItemCount() {
        return peaplelist.size();
    }

    public  class Itemviewholder extends RecyclerView.ViewHolder{

        TextView name,field,disc;
        CircleImageView imageView;

        public Itemviewholder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.name_person);
            field=itemView.findViewById(R.id.field_person);
            imageView=itemView.findViewById(R.id.img_person);

        }
    }

}
