package cn.bluemobi.dylan.recyclerviewdemo;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (RecyclerView) findViewById(R.id.rv);
        initData();
    }

    /**
     * 初始化数据
     */

    private void initData() {
        List<Integer> datas = new ArrayList<>();
        for (int i = 0; i < 38; i++) {
            Resources res = getResources();
            datas.add(res.getIdentifier("ic_category_" + i, "mipmap", getPackageName()));
        }
        /**
         *用来确定每一个item如何进行排列摆放
         * LinearLayoutManager 相当于ListView的效果
         GridLayoutManager相当于GridView的效果
         StaggeredGridLayoutManager 瀑布流
         */
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.HORIZONTAL));
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {

                outRect.left = 10;
                outRect.top = 10;
                outRect.top = 10;
            }
        });
        rv.setAdapter(new RvAdpter(this, datas));
    }
}
