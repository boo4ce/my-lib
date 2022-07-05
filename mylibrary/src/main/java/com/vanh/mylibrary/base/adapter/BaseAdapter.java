package com.vanh.mylibrary.base.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;

import com.vanh.mylibrary.base.adapter.callback.OnItemClick;

import java.util.List;

public abstract class BaseAdapter extends RecyclerView.Adapter<BaseAdapter.BaseViewHolder<ViewBinding>> {
    protected final List<ItemData> mDataList;
    protected final ItemTemplate<BaseViewHolder<ViewBinding>, ItemData> mTemplate;
    protected OnItemClick<? extends BaseViewHolder<ViewBinding>> mListener;

    public BaseAdapter(ItemTemplate<BaseViewHolder<ViewBinding>, ItemData> template, List<ItemData> dataList) {
        this.mDataList = dataList;
        this.mTemplate = template;
    }

    public void changeData(List<ItemData> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TaskDiffCallback(mDataList, newData));
        this.mDataList.clear();
        this.mDataList.addAll(newData);

        diffResult.dispatchUpdatesTo(this);
    }

    public void onItemClickListener(OnItemClick<? extends BaseViewHolder<ViewBinding>> listener) {
        this.mListener = listener;
    }

    public int getDataSize() {
        return mDataList.size();
    }

    @NonNull
    @Override
    public BaseViewHolder<ViewBinding> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mTemplate.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<ViewBinding> holder, int position) {
        mTemplate.bind(holder, mDataList.get(position));
        holder.bindData(mDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public abstract static class BaseViewHolder<T extends ViewBinding> extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected final T binding;
        private ItemData data;
        private final OnItemClick listener;

        public BaseViewHolder(@NonNull T binding, OnItemClick listener) {
            super(binding.getRoot());

            this.binding = binding;
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public void bindData(ItemData data) {
            this.data = data;
        }

        public ItemData getData() {
            return data;
        }

        @Override
        public void onClick(View view) {
            if(listener != null) listener.onItemClicked(this);
        }
    }

    private final static class TaskDiffCallback extends DiffUtil.Callback {
        private final List<ItemData> oldTasks;
        private final List<ItemData> newTasks;

        public TaskDiffCallback(List<ItemData> oldTasks, List<ItemData> newTasks) {
            this.oldTasks = oldTasks;
            this.newTasks = newTasks;
        }

        @Override
        public int getOldListSize() {
            return oldTasks.size();
        }

        @Override
        public int getNewListSize() {
            return newTasks.size();
        }

        @Override
        public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
            return oldTasks.get(oldItemPosition).getCompareContent().equals(
                    newTasks.get(newItemPosition).getCompareContent()
            );
        }

        @Override
        public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
            return oldTasks.get(oldItemPosition).equals(newTasks.get(newItemPosition));
        }
    }
}
