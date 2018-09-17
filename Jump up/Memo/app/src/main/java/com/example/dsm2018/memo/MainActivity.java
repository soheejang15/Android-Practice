package com.example.dsm2018.memo;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_CODE_INSERT = 1000;
    MemoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.main_floating);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(new Intent(MainActivity.this, MemoActivity.class),REQUEST_CODE_INSERT);
            }
        });

        ListView listView = (ListView) findViewById(R.id.main_list);

        adapter = new MemoAdapter(this, getMemoCursor());
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,MemoActivity.class);
                Cursor cursor = (Cursor) adapter.getItem(position);

                //커서에서 제목과 내용을 가져옴
                String title = cursor.getString(cursor.getColumnIndexOrThrow(MemoContract.MemoEntry.COLUMN_NAME_TITLE));
                String contents = cursor.getString(cursor.getColumnIndexOrThrow(MemoContract.MemoEntry.COLUMN_NAME_CONTENTS));

                //인텐트에 id와 함께 저장
                intent.putExtra("id",id);
                intent.putExtra("title",title);
                intent.putExtra("contents",contents);

                //MemoActivity 시작
                startActivityForResult(intent, REQUEST_CODE_INSERT);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                final long deleteId = id;
                AlertDialog.Builder builder= new AlertDialog.Builder(MainActivity.this);
                builder.setTitle("메모 삭제");
                builder.setMessage("메모를 삭제하시겠습니까?");
                builder.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        SQLiteDatabase db = MemoDbHelper.getsInstance(MainActivity.this).getWritableDatabase();
                        int deleteCount = db.delete(MemoContract.MemoEntry.TABLE_NAME,MemoContract.MemoEntry._ID + "=" + deleteId,null);

                        if(deleteCount == 0){
                            Toast.makeText(MainActivity.this, "삭제에 문제가 발생하였습니다.", Toast.LENGTH_SHORT).show();
                        } else{
                            adapter.swapCursor(getMemoCursor());
                            Toast.makeText(MainActivity.this, "메모가 삭제되었습니다.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                return false;
            }
        });
    }

    private Cursor getMemoCursor(){
        //MemoDbHelper 인스턴스를 얻어와 읽기 전용 DB를 얻음
        MemoDbHelper dbHelper = MemoDbHelper.getsInstance(this);

        //query는 조회를 위한 메소드.
        // 파라미터 : 테이블명, 컬럼명(배열), where절 , where절의 값, group by절, having절, order절(정렬. 오름차순이 기본)
        Cursor cursor = dbHelper.getReadableDatabase().query(MemoContract.MemoEntry.TABLE_NAME,null, null, null,null,null,MemoContract.MemoEntry._ID+" DESC");

        return cursor;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE_INSERT && resultCode == RESULT_OK){
            //swapCursor메서드에 새로 갱신된 커서를 전달
            adapter.swapCursor(getMemoCursor());
        }
    }

    private static class MemoAdapter extends CursorAdapter{
        public MemoAdapter(Context context, Cursor cursor){
            super(context,cursor,false);
        }

        //리스트뷰의 각 아이템에 해당할 레이아웃
        //simple_list_item_1에는 텍스트 뷰 하나만 들어가 있으며, 직접 만든 레이아웃 지정가능하다
        @Override
        public View newView(Context context, Cursor cursor, ViewGroup viewGroup){
            return LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, viewGroup,false);
        }

        //Cursor 객체의 컬럼 값을 가져와서 설정
        @Override
        public void bindView(View view, Context context, Cursor cursor){
            TextView titleText = view.findViewById(android.R.id.text1);
            titleText.setText(cursor.getString(cursor.getColumnIndexOrThrow(MemoContract.MemoEntry.COLUMN_NAME_TITLE)));
        }

    }
}
