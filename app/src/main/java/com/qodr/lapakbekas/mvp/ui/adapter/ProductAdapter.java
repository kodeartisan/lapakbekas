package com.qodr.lapakbekas.mvp.ui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.qodr.lapakbekas.R;
import com.qodr.lapakbekas.entity.Product;

import java.util.List;

/**
 * Created by kodeartisan on 27/05/17.
 */

public class ProductAdapter extends RecyclerArrayAdapter<Product> {

    public static final String TAG = ProductAdapter.class.getSimpleName();

    public ProductAdapter(Context context, List<Product> productList) {
        super(context, productList);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new ProductViewHolder(parent);
    }

    public class ProductViewHolder extends BaseViewHolder<Product> {

        ImageView mIvThumbnail;

        public ProductViewHolder(ViewGroup parent) {
            super(parent, R.layout.adapter_product);

            mIvThumbnail = $(R.id.iv_thumbnail);
        }

        @Override
        public void setData(Product data) {
            super.setData(data);

            Glide.with(getContext()).load(data.getImages().get(0)).crossFade().centerCrop()
                    .into(mIvThumbnail);
        }
    }
}
