package com.example.dsm2018.scrollview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Context mContext;

    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mContext = getApplicationContext();

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        ArrayList items = new ArrayList<>();

        items.add(new Item(R.drawable.a,"첫번째","설명"));
        items.add(new Item(R.drawable.b,"두번째","설명"));
        items.add(new Item(R.drawable.c,"세번째","설명"));
        items.add(new Item(R.drawable.d,"네번째","설명"));
        items.add(new Item(R.drawable.e,"다섯번째","설명"));

        layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(items, mContext);
        recyclerView.setAdapter(Adapter);

    }

    class MyAdpater extends RecyclerView.Adapter {
        private Context context;
        private ArrayList mItems;
        // Allows to remember the last item shown on screen
        private int lastPosition = -1;

        public MyAdpater(ArrayList items, Context mContext) {
            mItems = items;
            context = mContext;
        }

        // 필수로 Generate 되어야 하는 메소드 1 : 새로운 뷰 생성
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            // 새로운 뷰를 만든다
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item_cardview,parent,false);
            ViewHolder holder = new ViewHolder(v);
            return holder;
        }

        // 필수로 Generate 되어야 하는 메소드 2 : ListView의 getView 부분을 담당하는 메소드
        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            holder.imageView.setImageResource(mItems.get(position).image);
            holder.textView.setText(mItems.get(position).imagetitle);
            setAnimation(holder.imageView, position); }
            // // 필수로 Generate 되어야 하는 메소드 3
        @Override
        public int getItemCount() {
            return mItems.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public ImageView imageView;
            public TextView textView;
            public ViewHolder(View view) {
                super(view);
                imageView = (ImageView) view.findViewById(R.id.image);
                textView = (TextView) view.findViewById(R.id.imagetitle);
            }
        }

        private void setAnimation(View viewToAnimate, int position) {

            // 새로 보여지는 뷰라면 애니메이션을 해줍니다
            if (position > lastPosition) {
                Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
                viewToAnimate.startAnimation(animation);
                lastPosition = position;
            }
        }
    }

}
