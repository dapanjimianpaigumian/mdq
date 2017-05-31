package com.sdjr.mdq.ui.cjwt;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sdjr.mdq.R;
import com.sdjr.mdq.bean.CJWTBean;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by Administrator on 2017/2/17 0017.
 */

public class CJWTAdapter extends BaseAdapter {
    private Context context;
    private List<CJWTBean.InfoBean> list = null;
    private LayoutInflater inflater;

    public CJWTAdapter(Context context, List<CJWTBean.InfoBean> list) {
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
            view = inflater.inflate(R.layout.cjwt_item, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        holder.cjwtItemText.setText(list.get(i).getName());
        return view;
    }


    public void reload(List _list) {

        list.addAll(_list);
        notifyDataSetChanged();
    }

    static class ViewHolder {
        @Bind(R.id.cjwt_item_text)
        TextView cjwtItemText;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
