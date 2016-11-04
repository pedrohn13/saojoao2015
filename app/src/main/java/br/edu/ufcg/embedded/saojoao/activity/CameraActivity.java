package br.edu.ufcg.embedded.saojoao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import br.edu.ufcg.embedded.saojoao.R;
import br.edu.ufcg.embedded.saojoao.model.CameraPreview;
import br.edu.ufcg.embedded.saojoao.utils.CameraFile;

/**
 * Created by wertonguimaraes on 31/05/15.
 */
public class CameraActivity extends Activity implements View.OnClickListener {

    private static final String TAG = "Camera Activity";
    private static final int NOVENTA_GRAUS_HORARIO = 90;
    private static final int NOVENTA_GRAUS_ANTI_HORARIO = -90;
    private static final double TRINTA_PORCENTO = 0.3;

    private int mCurrentCamera;


    private Camera mCamera;
    private CameraPreview mPreview;
    private FrameLayout mPreviewContainer;
    private ImageView ivMoldura;
    private static int[] molduras = {R.drawable.moldura07_c, R.drawable.moldura06_c, R.drawable.moldura05_c, R.drawable.moldura04_c,
            R.drawable.moldura03_c, R.drawable.moldura02_c, R.drawable.moldura01_c};
    private static int[] moldurasPequenas = {R.drawable.moldura07_small, R.drawable.moldura06_small, R.drawable.moldura05_small, R.drawable.moldura04_small,
            R.drawable.moldura03_small, R.drawable.moldura02_small, R.drawable.moldura01_small};
    private int posicaoAtualDaMoldura = 6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.camera_activity);

        ((ImageButton) findViewById(R.id.button_capture)).setOnClickListener(this);
        ((ImageButton) findViewById(R.id.button_capture_icon)).setOnClickListener(this);
        ((ImageButton) findViewById(R.id.button_switch_camera)).setOnClickListener(this);
        ((ImageButton) findViewById(R.id.button_close)).setOnClickListener(this);
        mPreviewContainer = (FrameLayout) findViewById(R.id.camera_preview);
        ivMoldura = (ImageView) findViewById(R.id.moldura);

        ivMoldura.setBackgroundResource(molduras[posicaoAtualDaMoldura]);

        ListView listview = (ListView) findViewById(R.id.lv_molduras);
        listview.setAdapter(mAdapter);
        listview.setSelection(7);


        if (!checkCameraHardware(this)) {
            showToast(getString(R.string.no_camera));
            return;
        }

        mCurrentCamera = Camera.CameraInfo.CAMERA_FACING_BACK;

        mCamera = getCameraInstance(mCurrentCamera);

        if (mCamera == null) {
            return;
        }

        mPreview = new CameraPreview(this, mCamera);
        mPreviewContainer.removeAllViews();
        mPreviewContainer.addView(mPreview);


    }

    private void switchCamera() {

        if (mCamera != null) {
            mCamera.stopPreview(); // stop preview
            mCamera.release(); // release previous camera
        }


        if (mCurrentCamera == Camera.CameraInfo.CAMERA_FACING_BACK) {
            mCurrentCamera = Camera.CameraInfo.CAMERA_FACING_FRONT;
            ((ImageButton) findViewById(R.id.button_switch_camera)).setImageResource(R.drawable.ic_capture_cam1);
        } else {
            mCurrentCamera = Camera.CameraInfo.CAMERA_FACING_BACK;
            ((ImageButton) findViewById(R.id.button_switch_camera)).setImageResource(R.drawable.ic_capture_cam2);
        }

        // Create an instance of Camera
        mCamera = getCameraInstance(mCurrentCamera);

        if (mCamera == null) {
            return;
        }

        mPreview = new CameraPreview(this, mCamera);
        mPreviewContainer.removeAllViews();
        mPreviewContainer.addView(mPreview);
    }


    private void showToast(String text) {
        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }

    /**
     * Check if device has camera
     */
    private boolean checkCameraHardware(Context context) {
        return context.getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA);
    }

    private Camera getCameraInstance(int type) {
        Camera camera = null;
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.CameraInfo info = getNewCameraInfo();
            Camera.getCameraInfo(i, info);
            if (info.facing == type) {
                try {
                    camera = Camera.open(i); // attempt to get a Camera instance
                } catch (Exception e) {
                    // Camera is not available
                    showToast(getString(R.string.camera_not_found));
                }
                break;
            }
        }
        return camera;
    }

    private Camera.CameraInfo getNewCameraInfo() {
        return new Camera.CameraInfo();
    }

    private Camera.PictureCallback mPicture = new Camera.PictureCallback() {

        @Override
        public void onPictureTaken(byte[] data, Camera camera) {

            mPreview.initPreview();


            File pictureFile = CameraFile.getOutputMediaFile();
            if (pictureFile == null) {
                Log.d(TAG,
                        "Error creating media file, check storage permissions.");
                showToast(getString(R.string.error_create_media));
                return;
            }

            try {
                FileOutputStream fos = new FileOutputStream(pictureFile);
                Matrix matrix = new Matrix();
                Bitmap bitmap1 = BitmapFactory.decodeByteArray(data, 0, data.length);

                Bitmap bitmap = Bitmap.createBitmap(mPreview.getHeight(), mPreview.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(bitmap);

                int  alturaInicialBitmap1 = (bitmap1.getWidth() - bitmap1.getHeight()) / 2;

                if (mCurrentCamera == Camera.CameraInfo.CAMERA_FACING_BACK) {
                    alturaInicialBitmap1 = alturaInicialBitmap1 - (int) (alturaInicialBitmap1 * TRINTA_PORCENTO);
                } else {
                    alturaInicialBitmap1 = alturaInicialBitmap1 + (int) (alturaInicialBitmap1 * TRINTA_PORCENTO);
                    matrix.preScale(-1.0f, 1.0f);
                }
                matrix.postRotate(NOVENTA_GRAUS_HORARIO);


                bitmap1 = Bitmap.createBitmap(bitmap1, alturaInicialBitmap1, 0, bitmap1.getHeight(), bitmap1.getHeight(), matrix, true);

                Drawable drawable1 = new BitmapDrawable(bitmap1);
                drawable1.setBounds(0, 0, mPreview.getHeight(), mPreview.getHeight());
                drawable1.draw(canvas);

                ByteArrayOutputStream blob = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.PNG, 0 /*ignored for PNG*/, blob);
                data = blob.toByteArray();

                fos.write(data);
                fos.close();

                Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
                Uri contentUri = Uri.fromFile(pictureFile);
                mediaScanIntent.setData(contentUri);
                CameraActivity.this.sendBroadcast(mediaScanIntent);


            } catch (FileNotFoundException e) {
                Log.d(TAG, "File not found: " + e.getMessage());
            } catch (IOException e) {
                Log.d(TAG, "Error accessing file: " + e.getMessage());
            }

            Intent myIntent = new Intent(CameraActivity.this, ImageActivity.class);
            myIntent.putExtra("PICTURE_FILE", pictureFile.toString());
            myIntent.putExtra("MOLDURA_POSICAO", (mAdapter.getCount() - 1) - posicaoAtualDaMoldura);
            CameraActivity.this.startActivity(myIntent);

            onPause();
            onResume();
        }


    };

    private Camera.ShutterCallback mShutterCallback = new Camera.ShutterCallback() {
        public void onShutter() {
            TextView toast = (TextView) findViewById(R.id.toastText);
            toast.setText("Espere! Aplicando moldura");
            toast.setVisibility(View.VISIBLE);

             // do stuff like playing shutter sound here
        }
    };

    public Camera.ShutterCallback getmShutterCallback() {
        return mShutterCallback;
    }

    private void captureImage() {
        mCamera.takePicture(getmShutterCallback(), null, mPicture);

    }

    @Override
    protected void onPause() {
        if (mCamera != null) {
            mCamera.stopPreview(); // stop preview
        }
        super.onPause();
    }

    @Override
    protected void onStop() {
        TextView progressBar = (TextView) findViewById(R.id.toastText);
        progressBar.setVisibility(View.INVISIBLE);
        super.onStop();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (mCamera != null) {
            mCamera.stopPreview(); // stop preview
            mCamera.release(); // release previous camera
        }

        mCamera = getCameraInstance(mCurrentCamera);

        if (mCamera == null) {
            return;
        }

        mPreview = new CameraPreview(this, mCamera);
        mPreviewContainer.removeAllViews();
        mPreviewContainer.addView(mPreview);
    }

    @Override
    public void onClick(View view) {
        int viewId = view.getId();
        if (viewId == R.id.button_switch_camera) {
            switchCamera();
        } else if (viewId == R.id.button_capture) {
            captureImage();
        } else if (viewId == R.id.button_capture_icon) {
            captureImage();
        } else if (viewId == R.id.button_close) {
            onBackPressed();
        }
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mCamera != null) {
            mCamera.release(); // release the camera for other applications
            mCamera = null;
        }
        MainActivity.getToast().setVisibility(View.INVISIBLE);
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
            View retval = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_image, parent, false);
            ImageView image = (ImageView) retval.findViewById(R.id.image);
            image.setImageResource(moldurasPequenas[position]);
            image.setRotation(NOVENTA_GRAUS_ANTI_HORARIO);

            image.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    posicaoAtualDaMoldura = position;
                    ivMoldura.setBackgroundResource(molduras[position]);
                }
            });
            return retval;
        }
    };

}