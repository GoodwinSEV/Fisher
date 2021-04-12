package com.example.fisher;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

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

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    private DrawerLayout drawer;
    private ListView list;
    private String[] array;
    private ArrayAdapter<String > adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        array = getResources().getStringArray(R.array.slujeb_array);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, new ArrayList<String>(Arrays.asList(array)));
        list.setAdapter(adapter);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();

        if (id == R.id.nav_sluj) {
            array = getResources().getStringArray(R.array.slujeb_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
            Toast.makeText(this, "Nav_home pressed", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_decor) {
            array = getResources().getStringArray(R.array.decor_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();

        } else if (id == R.id.nav_ohota) {
            array = getResources().getStringArray(R.array.ohota_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        } else if (id == R.id.nav_zdorov) {
            array = getResources().getStringArray(R.array.pitanie_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        } else if (id == R.id.nav_inters) {
            array = getResources().getStringArray(R.array.inters_array);
            adapter.clear();
            adapter.addAll(array);
            adapter.notifyDataSetChanged();
        }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;

    }
}