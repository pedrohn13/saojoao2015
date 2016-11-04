package br.edu.ufcg.embedded.saojoao.activity;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.model.MoldurasListView;
import br.edu.ufcg.embedded.saojoao.utils.CameraFile;

/**
 * Created by wertonguimaraes on 31/05/15.
 */
public class ImageActivity extends Activity {

    private ImageView ivPicture;
    private ImageView shared;
    private ImageView sharedIcon;
    private ImageView save;
    private ImageView close;
    private static int[] molduras = {R.drawable.moldura01, R.drawable.moldura02, R.drawable.moldura03, R.drawable.moldura04,
            R.drawable.moldura05, R.drawable.moldura06, R.drawable.moldura07};
    private static int[] moldurasPequenas = {R.drawable.moldura01_small, R.drawable.moldura02_small, R.drawable.moldura03_small, R.drawable.moldura04_small,
            R.drawable.moldura05_small, R.drawable.moldura06_small, R.drawable.moldura07_small};

    private File imgFile;
    private String pictureFile;
    private int moldura;

    private static final int QUALIDADE = 100;
    private static final String LOG = "Image Activity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_activity);
        Intent intent = getIntent();
        pictureFile = intent.getStringExtra("PICTURE_FILE");
        moldura = intent.getIntExtra("MOLDURA_POSICAO", 0);

        ivPicture = (ImageView) findViewById(R.id.iv_image_taked);
        shared = (ImageView) findViewById(R.id.iv_shared);
        sharedIcon = (ImageView) findViewById(R.id.iv_shared_icon);
        save = (ImageView) findViewById(R.id.iv_save);
        close = (ImageView) findViewById(R.id.iv_close);

        MoldurasListView listview = (MoldurasListView) findViewById(R.id.lv_molduras);
        listview.setAdapter(mAdapter);

        caputuraImagem(pictureFile);
        Bitmap bitmap = aplicaMoldura(moldura);
        ivPicture.setImageBitmap(bitmap);

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        shared.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = CameraFile.getOutputMediaFile();
                saveImageView(file);

                onShareClick(file);
            }
        });

        sharedIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = CameraFile.getOutputMediaFile();
                saveImageView(file);

                onShareClick(file);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = CameraFile.getOutputMediaFile();
                saveImageView(file);
                Toast toast = Toast.makeText(getApplicationContext(), getString(R.string.img_saved), Toast.LENGTH_LONG);
                toast.setGravity(Gravity.CENTER, 0, 0);
                toast.show();
                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(file);
                mediaScanIntent.setData(contentUri);
                ImageActivity.this.sendBroadcast(mediaScanIntent);
            }
        });
    }

    public void onShareClick(File file) {
        List<Intent> targetShareIntents = new ArrayList<Intent>();
        Intent shareIntent = new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.setType("image/jpeg");
        List<ResolveInfo> resInfos = getPackageManager().queryIntentActivities(shareIntent, 0);

        for (ResolveInfo resInfo : resInfos) {
            String packageName = resInfo.activityInfo.packageName;
            if ((packageName.contains("com.twitter.android") || packageName.contains("com.facebook.katana") || packageName.contains("com.instagram.android"))
                    && !resInfo.activityInfo.name.contains("com.twitter.android.DMActivity")) {
                Intent intent = getNewIntent();
                ComponentName comp = getNewComponentName(resInfo, packageName);
                intent.setComponent(comp);
                intent.setAction(Intent.ACTION_SEND);
                intent.setType("image/jpeg");
                intent.putExtra(Intent.EXTRA_STREAM, Uri.parse("file:///" + file.toString()));
                intent.putExtra(Intent.EXTRA_TEXT, "#oMaiorSãoJoãoDoMundo");
                intent.setPackage(packageName);
                targetShareIntents.add(intent);
            }
        }

        Intent chooserIntent = Intent.createChooser(targetShareIntents.remove(0), "Choose app to share");
        chooserIntent.putExtra(Intent.EXTRA_INITIAL_INTENTS, targetShareIntents.toArray(new Parcelable[]{}));
        startActivity(chooserIntent);
    }

    private ComponentName getNewComponentName(ResolveInfo resInfo, String packageName) {
        return new ComponentName(packageName, resInfo.activityInfo.name);
    }

    private Intent getNewIntent() {
        return new Intent();
    }

    private void saveImageView(File file) {
        Bitmap bitmap1 = ((BitmapDrawable) ivPicture.getDrawable()).getBitmap();
        FileOutputStream out = null;

        try {
            out = new FileOutputStream(file);
            bitmap1.compress(Bitmap.CompressFormat.PNG, QUALIDADE, out);
        } catch (Exception e) {
            Log.d(LOG,
                    "Error creating file, check storage permissions.");
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                Log.d(LOG,
                        "Error closing file");
            }
        }
    }

    private void caputuraImagem(String pictureFileAux) {
        imgFile = new File(pictureFileAux);
        if (imgFile.exists()) {
            Bitmap myBitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            ivPicture.setImageBitmap(myBitmap);
        }
    }

    private BaseAdapter mAdapter = new BaseAdapter() {

        @Override
        public int getCount() {
            return molduras.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            LayoutInflater viewAux = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View retval = viewAux.inflate(R.layout.list_item_image, parent, false);
            ImageView image = (ImageView) retval.findViewById(R.id.image);
            image.setImageResource(moldurasPequenas[position]);
            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    caputuraImagem(pictureFile);
                    Bitmap bitmap = aplicaMoldura(position);
                    ivPicture.setImageBitmap(bitmap);
                }
            });

            return retval;
        }
    };

    private Bitmap aplicaMoldura(int position) {
        Bitmap bitmap1 = ((BitmapDrawable) ivPicture.getDrawable()).getBitmap();

        Bitmap bitmap = Bitmap.createBitmap(bitmap1.getHeight(), bitmap1.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        bitmap1 = Bitmap.createBitmap(bitmap1, 0, 0, bitmap1.getHeight(), bitmap1.getHeight());

        Bitmap bitmap2 = BitmapFactory.decodeResource(getApplicationContext().getResources(), molduras[position]);
        Drawable drawable1 = new BitmapDrawable(bitmap1);
        Drawable drawable2 = new BitmapDrawable(bitmap2);

        drawable1.setBounds(0, 0, bitmap1.getHeight(), bitmap1.getHeight());
        drawable2.setBounds(0, 0, bitmap1.getHeight(), bitmap1.getHeight());
        drawable1.draw(canvas);
        drawable2.draw(canvas);
        return bitmap;
    }


}
