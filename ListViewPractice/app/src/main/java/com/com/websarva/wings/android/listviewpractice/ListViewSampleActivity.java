package com.com.websarva.wings.android.listviewpractice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewSampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view_sample);
        // ListViewオブジェクトを取得
        ListView lvMenu = findViewById(R.id.lvMenu);
        // リストビューに表示するリストデータ用Listオブジェクトを作成
        List<String> menulist = new ArrayList<>();
        // リストデータの登録
        menulist.add("から揚げ定食");
        menulist.add("ハンバーグ定食");
        menulist.add("生姜焼定食");
        menulist.add("ステーキ定食");
        menulist.add("野菜炒め定食");
        menulist.add("とんかつ定食");
        menulist.add("メンチカツ定食");
        menulist.add("チキンカツ定食");
        menulist.add("コロッケ定食");
        menulist.add("焼き魚定食");
        menulist.add("焼肉定食");
        // アダプタオブジェクトを生成
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ListViewSampleActivity.this, android.R.layout.simple_list_item_1, menulist);
        // ListViewにアダプタオブジェクトを設定
        lvMenu.setAdapter(adapter);
        // リストビューにリスナを設定
        lvMenu.setOnItemClickListener(new ListItemClickListener());
    }
    /**
     * リストがタップされた時の処理が記述されたメンバクラス
     */
    private class ListItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id){
            // 注文確認ダイアログフラグメントオブジェクトを生成
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();
            // ダイアログを表示
            dialogFragment.show(getSupportFragmentManager(), "OrderConfirmDialogFragment");
        }
    }
}
