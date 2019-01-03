package com.mohammedfahadkaleem.extremematerialui.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mohammedfahadkaleem.extremematerialui.R;
import com.mohammedfahadkaleem.extremematerialui.model.MaterialComponents;
import java.util.ArrayList;
import java.util.List;

public class AdapterMainActivity extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<MaterialComponents> items = new ArrayList<>();

    private Context ctx;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(View view, MaterialComponents obj, int position);
    }

    public void setOnItemClickListener(final OnItemClickListener mItemClickListener) {
        this.mOnItemClickListener = mItemClickListener;
    }

    public AdapterMainActivity(Context context, List<MaterialComponents> items) {
        this.items = items;
        ctx = context;
    }

    public class OriginalViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageViewMaterialComponentIcon;
        public TextView textViewMaterialComponentName;
        public View lyt_parent;

        public OriginalViewHolder(View v) {
            super(v);
            imageViewMaterialComponentIcon = v.findViewById(R.id.material_component_icon);
            textViewMaterialComponentName = v.findViewById(R.id.material_component_name);
            lyt_parent = (View) v.findViewById(R.id.lyt_parent);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder vh;
        View v = LayoutInflater
            .from(parent.getContext()).inflate(R.layout.item_material_component, parent, false);
        vh = new OriginalViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof OriginalViewHolder) {
            OriginalViewHolder view = (OriginalViewHolder) holder;

            MaterialComponents component = items.get(position);
            view.textViewMaterialComponentName.setText(component.getComponentName());
            view.imageViewMaterialComponentIcon.setImageResource(component.getComponentIcon());
            //Tools.displayImageRound(ctx, view.imageViewMaterialComponentIcon, component.imageViewMaterialComponentIcon);
            view.lyt_parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mOnItemClickListener != null) {
                        mOnItemClickListener.onItemClick(view, items.get(position), position);
                    }
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

}