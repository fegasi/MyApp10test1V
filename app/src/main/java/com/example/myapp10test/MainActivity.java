package com.example.myapp10test;



import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapp10test.adapters.PageAdapter;
import com.example.myapp10test.adapters.petAdaptador;
import com.example.myapp10test.fragments.PerfilFragment;
import com.example.myapp10test.fragments.RecyclerViewfragment;
import com.example.myapp10test.fragments.RecyclerViewpetfragment;
import com.example.myapp10test.pojo.SendMail;
import com.example.myapp10test.pojo.pet;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_READ_CONTACTS = 0;
    private static final int MY_PERMISSIONS_REQUEST_CAMERA = 0;
    private static final int REQUEST_CAMERA = 0;
    private ViewPager viewpager;
    private TabLayout tabs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        /*ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });*/
        Toolbar toolbar = findViewById(R.id.toolbar); // Find the toolbar by ID
        setSupportActionBar(toolbar); // Set t
        viewpager = findViewById(R.id.viewpager); // Find the toolbar by ID
        tabs = findViewById(R.id.tabs); // Find the toolbar by ID
        setUpViewPageAdapter();

    }
    public boolean onOptionsItemSelected(MenuItem item) {

        if( item.getTitle().equals("contacto")){

            Toast.makeText(getApplicationContext(),item.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, contacto.class);
            startActivity(intent);

        }
        if( item.getTitle().equals("Acerca de")){
            Toast.makeText(getApplicationContext(),item.getTitle(), Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(this, acercade.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_contexto,menu);
        return true;
    }

    private ArrayList<Fragment> agregarfragments()
    {
        ArrayList<Fragment> fragments=new ArrayList<>();
        fragments.add(new RecyclerViewfragment());
        fragments.add(new RecyclerViewpetfragment());
        return fragments;
    }
    public void setUpViewPageAdapter(){
        viewpager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarfragments()));
        tabs.setupWithViewPager(viewpager);
        tabs.getTabAt(0).setIcon(R.drawable.casaperroico);
        tabs.getTabAt(1).setIcon(R.drawable.caraperroico);
    }
// pendiente recicler view contacto grid fotos, correo biografia desarrollador javamail


    public void irasegunda(MenuItem menu)
    {
        Intent intent=new Intent(this, activity_5pet.class);
        startActivity(intent);
    }
    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void tomarfoto(View view) {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
            // Permission is not granted, so request it
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA)) {
                // Show an explanation to the user why the permission is needed
            } else {
                // No explanation needed, request the permission directly
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.CAMERA},
                        MY_PERMISSIONS_REQUEST_CAMERA); // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an app-defined int constant
            }
        } else {
            // Permission has already been granted, proceed with the operation
            //startActivity(new Intent(MediaStore.ACTION_IMAGE_CAPTURE, Uri.parse("tel:5516522458")));

            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            intent.putExtra(MediaStore.EXTRA_OUTPUT,
                    Uri.withAppendedPath(Uri.parse("."), "prueba"));
            //if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            //}
        }
    }
        public void llamar( View view) {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                // Permission is not granted, so request it
                if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CALL_PHONE)) {
                    // Show an explanation to the user why the permission is needed
                } else {
                    // No explanation needed, request the permission directly
                    ActivityCompat.requestPermissions(this,
                            new String[]{Manifest.permission.CALL_PHONE},
                            MY_PERMISSIONS_REQUEST_READ_CONTACTS); // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an app-defined int constant
                }
            } else {
                // Permission has already been granted, proceed with the operation
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:5516522458")));
            }


            // Ensure that there's a camera activity to handle the intent

    }
    public void mandarcorreo(){
        SendMail sm = new SendMail(this, findViewById(R.id.textView), "prueba", findViewById(R.id.textView2));
        sm.execute();
    }


}