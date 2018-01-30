package com.example.nazaruk.shad;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);

        final ImageView avatarView = findViewById(R.id.avatar);
        avatarView.setImageDrawable(roundImage(R.drawable.avatar));
    }

    private RoundedBitmapDrawable roundImage(final int avatar) {
        final Bitmap avatarBitmap = BitmapFactory.decodeResource(getResources(), avatar);

        final int length = Math.min(avatarBitmap.getWidth(), avatarBitmap.getHeight());
        final Bitmap squareAvatar = Bitmap.createBitmap(avatarBitmap, 0, 0, length, length);

        final RoundedBitmapDrawable roundedAvatarBitmap =
                RoundedBitmapDrawableFactory.create(getResources(), squareAvatar);
        roundedAvatarBitmap.setCircular(true);

        return roundedAvatarBitmap;
    }
}
