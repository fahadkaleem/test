package com.mohammedfahadkaleem.extremematerialui.activity;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import com.mohammedfahadkaleem.extremematerialui.R;
import com.mohammedfahadkaleem.extremematerialui.adapter.AdapterMainActivity;
import com.mohammedfahadkaleem.extremematerialui.data.DataGenerator;
import com.mohammedfahadkaleem.extremematerialui.model.MaterialComponents;
import com.mohammedfahadkaleem.extremematerialui.utils.Utils;
import java.util.List;

public class MainActivity extends AppCompatActivity {
  private View parent_view;
  private RecyclerView recyclerView;
  private AdapterMainActivity mAdapter;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    parent_view = findViewById(R.id.main_activity_parent);

    initToolbar();
    initComponent();
  }

  private void initToolbar() {
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    getSupportActionBar().setTitle("Extreme Material Components");
    Utils.setSystemBarColor(this);
  }

  private void initComponent() {
    recyclerView = findViewById(R.id.recyclerView);
    recyclerView.setLayoutManager(new GridLayoutManager(this,2));
    recyclerView.setHasFixedSize(true);

    List<MaterialComponents> items = DataGenerator.getMaterialComponents(this);

    //set data and list adapter
    mAdapter = new AdapterMainActivity(this, items);
    recyclerView.setAdapter(mAdapter);

    // on item list clicked
    mAdapter.setOnItemClickListener(new AdapterMainActivity.OnItemClickListener() {
      @Override
      public void onItemClick(View view, MaterialComponents obj, int position) {
        Snackbar.make(parent_view, "Item " + obj.getComponentName() + " clicked", Snackbar.LENGTH_SHORT).show();
      }
    });

  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
    } else {
      Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
    }
    return super.onOptionsItemSelected(item);
  }
}