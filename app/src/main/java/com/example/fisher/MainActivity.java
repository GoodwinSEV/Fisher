package com.example.fisher;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.fisher.settings.SettingsActivity;
import com.example.fisher.utils.CustomArrayAdapter;
import com.example.fisher.utils.ListItemClass;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private ListView list;
    private String[] array, arraySecName;
    private CustomArrayAdapter adapter;
    private Toolbar toolbar;
    private int category_index;
    private List<ListItemClass> listItemMain;
    private ListItemClass listItem;
    private DrawerLayout drawer;

    //private ArrayAdapter<String > adapter;

    private int[] array_dog_color = new int [] {R.color.yellow, R.color.red, R.color.green,R.color.red,R.color.green};




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        list = findViewById(R.id.listView);
        listItemMain = new ArrayList<>();

        fillArray(R.string.akita,
                getResources().getStringArray(R.array.slujeb_array),
                getResources().getStringArray(R.array.slujeb_array2),0);

        adapter = new CustomArrayAdapter(this, R.layout.list_view_item1,listItemMain,getLayoutInflater());
        list.setAdapter(adapter);

        array = getResources().getStringArray(R.array.slujeb_array);
        arraySecName = getResources().getStringArray(R.array.slujeb_array2);



    //    adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));



        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent intent = new Intent(MainActivity.this, Text_Content_Activity.class);
                intent.putExtra("category", category_index);
                intent.putExtra("position", position);
                startActivity(intent);

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        toolbar.setTitle(R.string.menu_slujeb);
        return true;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Intent intent = new Intent(MainActivity.this, SettingsActivity.class);

            startActivity(intent);
        }

return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_sluj) {
            fillArray(R.string.menu_slujeb,getResources().getStringArray(R.array.slujeb_array),getResources().getStringArray(R.array.slujeb_array2), 0);
        } else
            if (id == R.id.nav_decor)
            {
            fillArray(R.string.menu_decor,getResources().getStringArray(R.array.decor_array),getResources().getStringArray(R.array.decor_array), 1);

        } else
            if (id == R.id.nav_ohota)
            {
            fillArray(R.string.menu_ohota,getResources().getStringArray(R.array.ohota_array),getResources().getStringArray(R.array.ohota_array), 2);

        } else
            if (id == R.id.nav_zdorov)
            {
            fillArray(R.string.menu_zdorov,getResources().getStringArray(R.array.pitanie_array),getResources().getStringArray(R.array.pitanie_array), 3);

        } else
            if (id == R.id.nav_inters)
            {
            fillArray(R.string.menu_inters,getResources().getStringArray(R.array.inters_array),getResources().getStringArray(R.array.inters_array), 4);

        }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }

    private void fillArray(int title, String[] array, String[] arraySecName, int index)
    {
        toolbar.setTitle(title);
        if (adapter != null) adapter.clear();

        for (int i =0; i < array.length; i++)
        {
            listItem = new ListItemClass();
            listItem.setName(array[i]);
            listItem.setSecond_name(arraySecName[i]);
            listItem.setImage_id(array_dog_color[i]);
            listItemMain.add(listItem);
        }

        if (adapter != null) adapter.notifyDataSetChanged();

        category_index = index;

    }
}