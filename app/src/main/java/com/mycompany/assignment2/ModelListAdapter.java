package com.mycompany.assignment2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.mycompany.assignment2.databinding.ActivityPhoneModelBinding;

import java.util.ArrayList;

public class ModelListAdapter extends ArrayAdapter<ModelAndPrice> {



     public ModelListAdapter(@NonNull Context context,ArrayList<ModelAndPrice> modelAndPriceArrayList) {
          super(context, R.layout.list_item_view,modelAndPriceArrayList);
     }

     @NonNull
     @Override
     public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
         ModelAndPrice modelAndPrice=getItem(position);
         if(convertView== null){
               convertView =LayoutInflater.from(getContext()).inflate(R.layout.list_item_view,parent,false);
          }

          TextView the_model=convertView.findViewById(R.id.tv_model);
          TextView the_price=convertView.findViewById(R.id.tv_price);

          the_model.setText(modelAndPrice.getModel());
          the_price.setText(modelAndPrice.getPrice());
          return convertView;
     }
}
