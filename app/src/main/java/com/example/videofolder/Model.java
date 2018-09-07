package com.example.videofolder;

public class Model {
    String folder;

    public Model(String folder) {
        this.folder = folder;
    }

    public String getFolder() {
        return folder;
    }

    public void setFolder(String folder) {
        this.folder = folder;
    }
}




//
//        String selection=MediaStore.Video.Media.DATA +" like?";
//        String[] selectionArgs=new String[]{"%WhatsApp Video%"};
//        videocursor = managedQuery(Exuri,
//                null, selection, selectionArgs, MediaStore.Video.Media.DATE_TAKEN + " DESC");
//
//        fl=videocursor.getColumnIndexOrThrow(MediaStore.Video.Media.BUCKET_DISPLAY_NAME);
//        while (videocursor.moveToNext()){
//            folderData.add(videocursor.getString(fl));
//        }
//
//        for (String s:folderData){
//            System.out.println("Data_Folder: "+s);
//        }
//
//        String path = Environment.getExternalStorageDirectory()
//                + File.separator + "WhatsApp";
//        File directory = new File(path);
//        File[] files = directory.listFiles();
//        for (int i = 0; i < files.length; i++)
//        {
//            String file_name = files[i].getName();
//            // you can store name to arraylist and use it later
//            filenames.add(file_name);
//        }
//        for (String s:filenames){
//            System.out.println("Files_Name: "+s);
//        }



//            if (Excursor!=null && Excursor.moveToNext()){
//                while (Excursor.moveToNext()){
//                    fileList.get(Integer.parseInt(Excursor.getString(Excursor.getColumnIndex(MediaStore.Video.Media.BUCKET_DISPLAY_NAME))));
//                    arrayList.add(fileList);
//                }
//            }
//
//            listView.setAdapter(arrayList);











//        for (String s:data){
//            System.out.println("Data"+s);
//        }

//        for (int i=0;i<data.size();i++){
//            System.out.println("Data"+data.get(i));
//        }

//        for (int i=0;i<data.size();i++){
//            for (int j=1;j<data.size();j++){
//                if (data.get(i).equalsIgnoreCase(data.get(j))){
//                    if (filenames.isEmpty()){
//                        filenames.add(data.get(i));
////                        folderData.add(data.get(i));
//                        value=data.get(i);
//                    }
//                }
//                if (value.equalsIgnoreCase(data.get(i))){
//                    folderData.add(data.get(i));
//                }
//            }
//        }
//