package com.gmail.gabow95k.beersoftheworld.ui.beers.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.gmail.gabow95k.beersoftheworld.databinding.ItemBeerBinding;
import com.gmail.gabow95k.beersoftheworld.model.Beer;

import java.util.ArrayList;
import java.util.List;

public class BeerAdapter extends RecyclerView.Adapter<BeerAdapter.ViewHolder> implements Filterable {

    private Context context;
    private BeerIn listener;
    private List<Beer> list, filterList;


    public BeerAdapter(Context context, List<Beer> list, BeerIn listener) {
        this.context = context;
        this.listener = listener;
        this.list = list;
        this.filterList = list;
    }

    public interface BeerIn{
        void onItemClick(Beer beer);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemBeerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context)
                .load(list.get(position).getImage_url())
                .into(holder.binding.ivBeer);
        holder.binding.tvName.setText(list.get(position).getName());
        holder.binding.content.setOnClickListener(v -> listener.onItemClick(list.get(position)));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ItemBeerBinding binding;

        public ViewHolder(ItemBeerBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String charString = constraint.toString();
                if (charString.isEmpty()){
                    list = filterList;
                }else {
                    List<Beer> auxList = new ArrayList<>();
                    for (Beer item : list){
                        if (item.getName().toLowerCase().contains(charString.toLowerCase())){
                            auxList.add(item);
                        }
                    }
                    list = auxList;
                }

                FilterResults filterResults = new FilterResults();
                filterResults.values = list;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                list = (List<Beer>) results.values;
                notifyDataSetChanged();
            }
        };
    }
}
