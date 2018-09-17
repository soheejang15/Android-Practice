package com.example.dsm2018.memo;

import android.provider.BaseColumns;

//final을 붙여서 상속 금지
public final class MemoContract {

    //인스턴스화 금지

    //외부에서 MemoContract.MemoEntry.변수명으로 접근 가능

    public static class MemoEntry implements BaseColumns{
        public static final String TABLE_NAME = "memo";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_CONTENTS = "contents";
    }
}
