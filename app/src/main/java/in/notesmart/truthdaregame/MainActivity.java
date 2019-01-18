package in.notesmart.truthdaregame;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView image_view;
    Random r = new Random();
    int lastdir;
    boolean spin;
    MediaPlayer mediaPlayer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image_view = findViewById(R.id.image_view);

        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.spin);
    }
    public void click(View v) {
        if (!spin) {
            int newDir = r.nextInt(30000);
            float pivotX = image_view.getWidth() / 2;
            float pivotY = image_view.getHeight() / 2;
            mediaPlayer.start();

            Animation rotate = new RotateAnimation(lastdir, newDir, pivotX, pivotY);
            rotate.setDuration(10000);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    spin = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    spin = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });

            lastdir = newDir;
            image_view.startAnimation(rotate);
        }
    }
}
