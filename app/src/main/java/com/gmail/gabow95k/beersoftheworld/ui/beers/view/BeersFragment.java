package com.gmail.gabow95k.beersoftheworld.ui.beers.view;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.gmail.gabow95k.beersoftheworld.base.BaseFragment;
import com.gmail.gabow95k.beersoftheworld.databinding.FragmentBeersBinding;
import com.gmail.gabow95k.beersoftheworld.model.Beer;
import com.gmail.gabow95k.beersoftheworld.ui.beers.adapter.BeerAdapter;
import com.gmail.gabow95k.beersoftheworld.ui.beers.adapter.GridSpacingItemDecoration;
import com.gmail.gabow95k.beersoftheworld.ui.beers.interactor.BeersInteractor;
import com.gmail.gabow95k.beersoftheworld.ui.beers.presenter.BeersContract;
import com.gmail.gabow95k.beersoftheworld.ui.beers.presenter.BeersPresenter;

import java.util.ArrayList;
import java.util.List;

public class BeersFragment extends BaseFragment<BeersContract.Presenter, FragmentBeersBinding> implements BeersContract.View, BeerAdapter.BeerIn {

    private int page = 1;
    private List<Beer> list;
    private BeerAdapter adapter;
    private Boolean enableToRequestAPI = true;
    private Boolean readyToLoad = false;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        list = new ArrayList<>();
        BeersInteractor interactor = new BeersInteractor();
        presenter = new BeersPresenter(this, interactor);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBeersBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setUpRecycler();
        setUpEvents();
        presenter.getBeersByApi(page);
    }

    private void setUpEvents() {
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.getFilter().filter(s);
            }
        });

        binding.recycler.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if (dy > 0 && enableToRequestAPI){
                    int visibleItemCount = binding.recycler.getLayoutManager().getChildCount();
                    int totalItemCount = binding.recycler.getLayoutManager().getItemCount();
                    int pastVisibleItems = ((LinearLayoutManager)recyclerView.getLayoutManager()).findFirstVisibleItemPosition();

                    if (readyToLoad){
                        if (visibleItemCount + pastVisibleItems >= totalItemCount){
                            readyToLoad = false;
                            page = (totalItemCount / 25) + 1;
                            presenter.getBeersByApi(page);
                        }
                    }
                }
            }
        });

    }


    private void setUpRecycler() {
        adapter = new BeerAdapter(getActivity(), list, this);
        binding.recycler.setLayoutManager(new GridLayoutManager(requireActivity(), 3));
        int spanCount = 3;
        int spacing = 50;
        boolean includeEdge = false;
        binding.recycler.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        binding.recycler.setHasFixedSize(true);
        binding.recycler.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void noBeers() {
        binding.tvNoAvailable.setVisibility(View.VISIBLE);
        binding.recycler.setVisibility(View.GONE);
    }

    @Override
    public void setBeers(List<Beer> beers) {
        readyToLoad = true;

        binding.tvNoAvailable.setVisibility(View.GONE);
        binding.recycler.setVisibility(View.VISIBLE);

        list.addAll(beers);
        adapter.notifyDataSetChanged();

    }

    @Override
    public void onItemClick(Beer beer) {

    }
}