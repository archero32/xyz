import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class BootAnimationActivity extends Activity {

    private AnimationDrawable bootAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the activity to fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        // Set the boot animation XML as the activity's content view
        setContentView(R.layout.boot_animation);

        // Get the ImageView that will display the boot animation frames
        ImageView bootImageView = findViewById(R.id.boot_image_view);

        // Set the boot animation as the image view's background
        bootAnimation = (AnimationDrawable) bootImageView.getBackground();
        bootAnimation.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Stop the boot animation when the activity is destroyed
        if (bootAnimation != null) {
            bootAnimation.stop();
        }
    }
}
