package com.example.eye;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {

    private ArrayList<ListVO> listVO = new ArrayList<ListVO>() ;
    public ListViewAdapter() {

    }

    @Override
    public int getCount() {
        return listVO.size() ;
    }

    // ** 이 부분에서 리스트뷰에 데이터를 넣어줌 **
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //postion = ListView의 위치      /   첫번째면 position = 0
        final int pos = position;
        final Context context = parent.getContext();


        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.period_listview, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.TextView_lens_name) ;
        TextView left = (TextView) convertView.findViewById(R.id.TextView_lens_left) ;
        TextView right = (TextView) convertView.findViewById(R.id.TextView_lens_right) ;


        ListVO listViewItem = listVO.get(position);

        // 아이템 내 각 위젯에 데이터 반영
        name.setText(listViewItem.getName());
        left.setText(listViewItem.getDate().toString());
        right.setText(listViewItem.getPeriod().toString());


        //리스트뷰 클릭 이벤트
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, (pos+1)+"번째 리스트가 클릭되었습니다.", Toast.LENGTH_SHORT).show();
            }
        });


        return convertView;
    }


    @Override
    public long getItemId(int position) {
        return position ;
    }


    @Override
    public Object getItem(int position) {
        return listVO.get(position) ;
    }

    // 데이터값 넣어줌
    public void addVO(String name, Integer[] date, Integer period) {
        ListVO item = new ListVO();

        item.setName(name);
        item.setDate(date);
        item.setPeriod(period);

        listVO.add(item);
    }
}