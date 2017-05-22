package com.plbtw_asek.restopedia;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.IdRes;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


import com.plbtw_asek.restopedia.API.ApiClient;
import com.plbtw_asek.restopedia.API.ApiInterface;
import com.plbtw_asek.restopedia.Model.StatusMessage;
import com.restopedia_team.restopedia.R;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import cn.pedant.SweetAlert.SweetAlertDialog;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TabActivity2 extends Activity {

    String USERNAME;
    String API_KEY;
    StatusMessage statusMessage;

    Bitmap bi = null;
    boolean isColored;

    boolean flag;

    private int SIZE = 256;
    // Red, Green, Blue
    private int NUMBER_OF_COLOURS = 3;

    public final int RED = 0;
    public final int GREEN = 1;
    public final int BLUE = 2;

    ImageView img;

    private int[][] colourBins;
    private volatile boolean loaded = false;

    float offset = 1;

    EditText text_nama;
    EditText text_detail;
    EditText text_alamat;
    EditText text_kota;
    Button btn_upload;

    String nama = "";
    String detail = "";
    String alamat = "";
    String kota = "";

    String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab2);

        Bundle b = getIntent().getExtras();
        USERNAME = b.getString("username");
        API_KEY = b.getString("api_key");

        text_nama = (EditText) findViewById(R.id.name);
        text_detail = (EditText) findViewById(R.id.detail);
        text_alamat = (EditText) findViewById(R.id.alamat);
        text_kota = (EditText) findViewById(R.id.kota);
        btn_upload = (Button) findViewById(R.id.upload);

        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);

        if (metrics.densityDpi == DisplayMetrics.DENSITY_LOW)
            offset = 0.75f;
        else if (metrics.densityDpi == DisplayMetrics.DENSITY_MEDIUM)
            offset = 1f;
        else if (metrics.densityDpi == DisplayMetrics.DENSITY_TV)
            offset = 1.33f;
        else if (metrics.densityDpi == DisplayMetrics.DENSITY_HIGH)
            offset = 1.5f;
        else if (metrics.densityDpi == DisplayMetrics.DENSITY_XHIGH)
            offset = 2f;

        Log.e("NIRAV", "" + offset);

        colourBins = new int[NUMBER_OF_COLOURS][];
        for (int i = 0; i < NUMBER_OF_COLOURS; i++) {
            colourBins[i] = new int[SIZE];
        }

        img = (ImageView) findViewById(R.id.original_pic);

        loaded = false;

        /// UNTUK AMBIL GAMBAR DARI GALLERY
        Button gallery = (Button) findViewById(R.id.gallery);
        gallery.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent it = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(it, 101);
                flag = true;

            }
        });

        /// UNTUK AMBIL GAMBAR DARI KAMERA

        Button camera = (Button) findViewById(R.id.camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                File file = getFile();
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(file));
                startActivityForResult(cameraIntent, 102);
                flag = true;
            }
        });

        //klik upload
        btn_upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                klik_upload();
            }
        });

    }

    private File getFile() {
        File folder = new File("sdcard/camera_app");
        if (!folder.exists()) {
            folder.mkdir();
        }
        return new File(folder, "cam_image.jpg");
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        switch (requestCode) {

            case 101:
                if (resultCode == RESULT_OK) {
                    Uri selectedImage = imageReturnedIntent.getData();
                    String filename = getRealPathFromURI(selectedImage);
                    bi = BitmapFactory.decodeFile(filename);
                /*
                ByteArrayOutputStream out = new ByteArrayOutputStream();
                bi.compress(Bitmap.CompressFormat.JPEG,10,out);
                bi = BitmapFactory.decodeStream(new ByteArrayInputStream(out.toByteArray()));*/

                    if (bi != null) {
                        try {
                            new MyAsync().execute();
                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                }

            case 102:
                String path = "sdcard/camera_app/cam_image.jpg";
                img.setImageDrawable(Drawable.createFromPath(path));
        }
    }

    public String getRealPathFromURI(Uri contentUri) {
        Log.e("TEST", "GetRealPath : " + contentUri);

        try {
            if (contentUri.toString().contains("video")) {
                String[] proj = {MediaStore.Video.Media.DATA};
                Cursor cursor = managedQuery(contentUri, proj, null, null, null);
                int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            } else {
                String[] proj = {MediaStore.Images.Media.DATA};
                Cursor cursor = managedQuery(contentUri, proj, null, null, null);
                int column_index = cursor
                        .getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
                cursor.moveToFirst();
                return cursor.getString(column_index);
            }
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }

    class MyAsync extends AsyncTask {
        @Override
        protected void onPreExecute() {
            // TODO Auto-generated method stub
            super.onPreExecute();
            showDialog(0);
        }

        @Override
        protected Object doInBackground(Object... params) {
            // TODO Auto-generated method stub

            try {
                load(bi);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            return null;
        }

        @Override
        protected void onPostExecute(Object result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            img.setImageBitmap(bi);
            dismissDialog(0);
            isColored = true;
        }

    }

    public void load(Bitmap bi) throws IOException {

        if (bi != null) {
            // Reset all the bins
            for (int i = 0; i < NUMBER_OF_COLOURS; i++) {
                for (int j = 0; j < SIZE; j++) {
                    colourBins[i][j] = 0;
                }
            }

            for (int x = 0; x < bi.getWidth(); x++) {
                for (int y = 0; y < bi.getHeight(); y++) {

                    int pixel = bi.getPixel(x, y);

                    colourBins[RED][Color.red(pixel)]++;
                    colourBins[GREEN][Color.green(pixel)]++;
                    colourBins[BLUE][Color.blue(pixel)]++;
                }
            }

            int maxY = 0;

            for (int i = 0; i < NUMBER_OF_COLOURS; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (maxY < colourBins[i][j]) {
                        maxY = colourBins[i][j];
                    }
                }
            }
            loaded = true;
        } else {
            loaded = false;
        }
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        ProgressDialog dataLoadProgress = new ProgressDialog(this);
        dataLoadProgress.setMessage("Loading...");
        dataLoadProgress.setIndeterminate(true);
        dataLoadProgress.setCancelable(false);
        dataLoadProgress.setProgressStyle(android.R.attr.progressBarStyleLarge);
        return dataLoadProgress;
    }

    //post gambar

    @Override
    public View findViewById(@IdRes int id) {
        return super.findViewById(id);
    }

    void userUpload(String gambar, String namagambar) {
        nama = text_nama.getText().toString();
        detail = text_detail.getText().toString();
        alamat = text_alamat.getText().toString();
        kota = text_kota.getText().toString();

        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<StatusMessage> call = apiService.addKonten(API_KEY, USERNAME, nama, detail, alamat, kota, gambar, namagambar);
        call.enqueue(new Callback<StatusMessage>() {
            @Override
            public void onResponse(Call<StatusMessage> call, Response<StatusMessage> response) {
                statusMessage = response.body();
                Log.i("Success", "Upload Success");
                onUploadSuccess();
            }

            @Override
            public void onFailure(Call<StatusMessage> call, Throwable t) {
                Log.i("Failed", "Upload Failed");
                onUploadFailed();
            }
        });
    }

    public void onUploadSuccess() {
        btn_upload.setEnabled(true);
        setResult(RESULT_OK, null);
        Toast.makeText(getBaseContext(), "Upload Success", Toast.LENGTH_LONG).show();

        Intent i = new Intent(getApplicationContext(), LoginActivity.class);
        startActivity(i);
    }

    public void onUploadFailed() {
        btn_upload.setEnabled(true);

        Toast.makeText(getBaseContext(), "Upload Failed", Toast.LENGTH_LONG).show();
    }

    void klik_upload() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ((BitmapDrawable) img.getDrawable()).getBitmap().compress(Bitmap.CompressFormat.JPEG, 50, byteArrayOutputStream);
        String gambar = Base64.encodeToString(byteArrayOutputStream.toByteArray(), Base64.DEFAULT);

        String namagambar = "user_" + USERNAME + "_konten_" + timeStamp + ".jpg";

        userUpload(gambar, namagambar);
    }

    @Override
    public void onBackPressed() {

        SweetAlertDialog sweetAlertDialog = new SweetAlertDialog(TabActivity2.this, SweetAlertDialog.WARNING_TYPE);
        sweetAlertDialog.setCanceledOnTouchOutside(false);
        sweetAlertDialog.setTitleText("Log out")
                .setContentText("Do you want to logout ?")
                .setConfirmText("Yes")
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.dismissWithAnimation();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }
                })
                .setCancelText("Cancel")
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sweetAlertDialog) {
                        sweetAlertDialog.dismissWithAnimation();
                    }
                })
                .show();
    }
}