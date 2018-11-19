package com.example.luxiaoju.mutillistviewtest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lv1_root,lv2_root,lv3_root;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();

        fillData();
    }

    private void initView() {
        lv1_root  = findViewById(R.id.lv1_root);
        lv2_root = findViewById(R.id.lv2_root);
//        lv3_root = findViewById(R.id.lv3_root);

    }

    private void fillData() {
        List<String> data = new ArrayList<>();
        for (int i=0;i<120;i++) {
            data.add("item" + i);
        }
        myAdapter = new MyAdapter(this,data);
        lv1_root.setAdapter(myAdapter);
        lv2_root.setAdapter(myAdapter);
//        lv3_root.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {

        private List<String> dataList;
        private Context context;

        private MyAdapter(Context context,List<String> dataList) {
            this.context = context;
            this.dataList = dataList;
        }

        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int i) {
            return dataList.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            MyViewHolder holder;
            if (view == null) {
                holder =new MyViewHolder();
                view = LayoutInflater.from(context).inflate(R.layout.item,null);
                holder.tv =view.findViewById(R.id.tv_item);
                view.setTag(holder);
            } else {
                holder = (MyViewHolder) view.getTag();
            }
            holder.tv.setText(dataList.get(i));
            return view;
        }

        class MyViewHolder {
            TextView tv;
        }
    }
}
