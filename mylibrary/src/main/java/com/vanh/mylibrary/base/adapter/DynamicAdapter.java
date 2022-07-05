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

public abstract class DynamicAdapter<T extends DynamicAdapter.BaseViewHolder<? extends ViewBinding>>
        extends RecyclerView.Adapter<T> {
    protected final List<ItemData<T>> mDataList;
    protected final ItemTemplate<T> mTemplate;
    protected OnItemClick<T> mListener;

    public DynamicAdapter(ItemTemplate<T> template, List<ItemData<T>> dataList) {
        this.mDataList = dataList;
        this.mTemplate = template;
    }

    public void changeData(List<ItemData<T>> newData) {
        DiffUtil.DiffResult diffResult = DiffUtil.calculateDiff(new TaskDiffCallback(mDataList, newData));
        this.mDataList.clear();
        this.mDataList.addAll(newData);

        diffResult.dispatchUpdatesTo(this);
    }

    public void onItemClickListener(OnItemClick<T> listener) {
        this.mListener = listener;
    }

    public int getDataSize() {
        return mDataList.size();
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return mTemplate.inflate(LayoutInflater.from(parent.getContext()), parent, false);
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {
        ItemData<T> item = mDataList.get(position);

        holder.bindData(item);
        item.bind(holder);
    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    public abstract static class BaseViewHolder<T extends ViewBinding> extends RecyclerView.ViewHolder implements View.OnClickListener {
        protected final T binding;
        private ItemData<? extends BaseViewHolder<? extends ViewBinding>> data;
        private final OnItemClick<BaseViewHolder<T>> listener;

        public BaseViewHolder(@NonNull T binding,
                              OnItemClick<BaseViewHolder<T>> listener) {
            super(binding.getRoot());

            this.binding = binding;
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        public <H extends DynamicAdapter.BaseViewHolder<? extends ViewBinding>> void bindData(ItemData<H> data) {
            this.data = data;
        }

        public ItemData<? extends BaseViewHolder<? extends ViewBinding>> getData() {
            return data;
        }

        @Override
        public void onClick(View view) {
            if(listener != null) listener.onItemClicked(this);
        }
    }

    private final class TaskDiffCallback extends DiffUtil.Callback {
        private final List<ItemData<T>> oldTasks;
        private final List<ItemData<T>> newTasks;

        public TaskDiffCallback(List<ItemData<T>> oldTasks, List<ItemData<T>> newTasks) {
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
