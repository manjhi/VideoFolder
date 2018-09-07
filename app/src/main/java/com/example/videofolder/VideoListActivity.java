package com.example.videofolder;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class VideoListActivity extends AppCompatActivity {

    String getdata;
    VideoFolderAdapter videoFolderAdapter;
    RecyclerView recyclerView;
    ArrayList allvideo=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_list);


        recyclerView=findViewById(R.id.get);
        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        Intent intent=getIntent();
        getdata=intent.getStringExtra("MyData");

        final Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                VideosData();
            }
        },500);

    }
    public void VideosData(){
        int int_position=0;
        Uri uri;
        Cursor cursor;
        int indexData,indexFolder,id,thum;
        String Path=null;
        uri= MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection={MediaStore.MediaColumns.DATA, MediaStore.Video.Media.BUCKET_DISPLAY_NAME, MediaStore.Video.Media._ID, MediaStore.Video.Thumbnails.DATA};
        final String orderby= MediaStore.Images.Media.DATE_TAKEN;

        cursor=getApplicationContext().getContentResolver().query(uri,projection, MediaStore.Video.Media.DATA+"like ?",new String[]{"%"+getdata+"%"},orderby +"DESC");
        indexData=cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        indexFolder=cursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
        id=cursor.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
        thum=cursor.getColumnIndexOrThrow(MediaStore.Video.Thumbnails.DATA);

        while (cursor.moveToNext()){
            Path=cursor.getString(indexData);

            Log.d("Path",Path);
            Log.d("Folder:",cursor.getString(indexFolder));
            Log.d("IDs",cursor.getString(id));
            Log.d("Thumnials:",cursor.getString(thum));


            ModelVideo modelVideo=new ModelVideo();
            modelVideo.setSelected(false);
            modelVideo.setPath(Path);
            modelVideo.setThum(cursor.getString(thum));
            allvideo.add(modelVideo);
        }
        videoFolderAdapter=new VideoFolderAdapter(allvideo,getApplicationContext(),VideoListActivity.this);
        recyclerView.setAdapter(videoFolderAdapter);
    }
}
