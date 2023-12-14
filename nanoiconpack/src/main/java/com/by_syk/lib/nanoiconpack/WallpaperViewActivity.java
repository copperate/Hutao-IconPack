package com.by_syk.lib.nanoiconpack;

import android.Manifest;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.by_syk.lib.globaltoast.GlobalToast;
import com.by_syk.lib.nanoiconpack.databinding.ActivityWallpaperViewBinding;
import com.by_syk.lib.nanoiconpack.util.C;
import com.by_syk.lib.nanoiconpack.util.ExtraUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class WallpaperViewActivity extends AppCompatActivity {

private ActivityWallpaperViewBinding binding;

    int bgcode;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        bgcode=intent.getIntExtra("BgCode",1);
        setContentView(R.layout.activity_wallpaper_view);
        Toolbar toolbar_wallpeper = findViewById(R.id.toolbar_wallpaperview);
        setSupportActionBar(toolbar_wallpeper);
        ImageShow(bgcode);
    }
    public void ImageShow(int i)
    {
        ImageView imageshowarea = findViewById(R.id.imageViewWallpaperPreview);
        switch (i)
        {
            case 1:imageshowarea.setImageDrawable(getDrawable(R.drawable.wallpaper_01));break;
            case 2:imageshowarea.setImageDrawable(getDrawable(R.drawable.wallpaper_02));break;
            case 3:imageshowarea.setImageDrawable(getDrawable(R.drawable.wallpaper_03));break;
            case 4:imageshowarea.setImageDrawable(getDrawable(R.drawable.wallpaper_04));break;
            case 5:imageshowarea.setImageDrawable(getDrawable(R.drawable.wallpaper_05));break;
            default:finish();break;
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish(); // back button
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public void closeView(View view)
    {
        this.finish();
    }
    @TargetApi(23)
    public void saveIcon(View view) {
        if (C.SDK >= 23 && this.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 0);
            return;
        }
        String BgName = "HuTao_Wallpaper_";
        boolean ok;
        switch (bgcode)
        {
            case 1:BgName = BgName + "01";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_01),
                        BgName);break;
            case 2:BgName = BgName + "02";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_02),BgName);break;
            case 3:BgName = BgName + "03";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_03),BgName);break;
            case 4:BgName = BgName + "04";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_04),BgName);break;
            case 5:BgName = BgName + "05";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_05),BgName);break;
            default:BgName = BgName + "05";
                ok = savePic(this, getResources().getDrawable(R.drawable.wallpaper_05),BgName);break;
        }



        //if (ok) {((ImageView) viewActionSave).getDrawable().mutate().setTint(ContextCompat.getColor(this, R.color.positive));}
        GlobalToast.show(this, ok ? R.string.toast_wallpaper_saved
                : R.string.toast_wallpaper_save_failed);
    }
    @SuppressLint("NewApi")
    public static boolean savePic(Context context, Drawable drawable, String name) {
        if (context == null || drawable == null || TextUtils.isEmpty(name)) {
            return false;
        }

        Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        if (bitmap == null) {
            return false;
        }

        // Create a path where we will place our picture
        // in the user's public pictures directory.
        File picDir = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "Wallpaper");
        // Make sure the Pictures directory exists.
        picDir.mkdirs();
        File targetFile = new File(picDir, name + "_"
                + bitmap.getByteCount() + ".png");

        boolean result = false;
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(targetFile);
            result = bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        if (!result) {
            targetFile.delete();
            return false;
        }

        return true;
    }

}