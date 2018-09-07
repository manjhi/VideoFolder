package com.example.videofolder;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> data=new ArrayList<>();
    List<String> folderData=new ArrayList<>();
    List<String> filenames=new ArrayList<>();
    int Exfolder;
    Cursor Excursor;
    Uri Exuri;

    HashSet<String> Folders=new HashSet<>();
    String value;

    RecyclerView recyclerView;
    Adapter adapter;
    List<Model> models=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recycer);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        Exuri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//        Inuri= MediaStore.Video.Media.INTERNAL_CONTENT_URI;
        Excursor=getApplicationContext().getContentResolver().query(Exuri,null,null,null,null);

        Exfolder=Excursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
//
// Thum=Excursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails.DATA);

        while (Excursor.moveToNext()){
            Folders.add(Excursor.getString(Exfolder));
            data.add(Excursor.getString(Exfolder));
          }

        Iterator<String> itr=Folders.iterator();
        while (itr.hasNext()){
//            System.out.println("Folder: "+itr.next());
            filenames.add(itr.next());
        }

        for (int i=0;i<filenames.size();i++){
            Model model=new Model(filenames.get(i));
            models.add(model);

        }
        for (int i=0;i<models.size();i++){
            System.out.println("Output:"+models.get(i));
        }



        adapter=new Adapter(models, this, new Adapter.myclick() {
            @Override
            public void myonclick(int postion) {
//                Toast.makeText(MainActivity.this, "Position: "+postion, Toast.LENGTH_SHORT).show();
                String p=filenames.get(postion);
                Intent intent=new Intent(getApplicationContext(),VideoListActivity.class);
                intent.putExtra("MyData",p);
                startActivity(intent);


            }
        });
        recyclerView.setAdapter(adapter);
    }
}
