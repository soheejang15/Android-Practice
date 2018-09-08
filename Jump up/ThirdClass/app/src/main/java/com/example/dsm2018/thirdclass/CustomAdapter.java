package com.example.dsm2018.thirdclass;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ObjectStreamClass;
import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    public ArrayList<Contact> mDataList;

    public CustomAdapter(ArrayList<Contact> mDataList){this.mDataList = mDataList;}

    //아이템 개수
    @Override
    public int getCount() {
        return mDataList.size();
    }

    //position번째의 아이템
    @Override
    public Object getItem(int position) {
        return mDataList.get(position);
    }

    //position 번째의 아이디
    @Override
    public long getItemId(int position) {
        return position;
    }

    //position 번째의 아이템의 View를 구성하는 부분
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

            //ImageView imageView = (ImageView)convertView.findViewById(R.id.contact_img);
            TextView textName = convertView.findViewById(R.id.text_name);
            TextView textPhone = convertView.findViewById(R.id.text_phone);





        Contact contact = mDataList.get(position);

        textName.setText(contact.getName());
        textPhone.setText(contact.getPhone());

        return convertView;

    }

}
