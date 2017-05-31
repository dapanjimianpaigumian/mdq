package com.sdjr.mdq.ui.qyxx;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sdjr.mdq.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by user on 2017/4/10.
 */

public class LXRAdapter extends BaseAdapter {
    private Context context;
    private List<PhoneInfo> list = null;
    private LayoutInflater inflater;

    public LXRAdapter(Context context, List<PhoneInfo> list) {
        this.context = context;
        this.list = list;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null) {
            view = inflater.inflate(R.layout.item_lxr, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.name.setText(list.get(i).getName());
        holder.number.setText(list.get(i).getNumber());
        return view;
    }

    static class ViewHolder {
        @Bind(R.id.item_lxr_name)
        TextView name;
        @Bind(R.id.item_lxr_tel)
        TextView number;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
