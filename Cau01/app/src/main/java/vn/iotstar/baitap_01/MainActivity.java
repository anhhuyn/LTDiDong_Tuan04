package vn.iotstar.baitap_01;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView backgroundImage;
    private Switch swtBackground;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        backgroundImage = findViewById(R.id.imgBackground);
        changeBackground();
        swtBackground = findViewById(R.id.swtBackground);
        swtBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeBackground();
            }
        });
    }
    private void changeBackground()
    {
        int[] backgrounds = {
                R.drawable.bg1,
                R.drawable.bg2,
                R.drawable.bg3,
                R.drawable.bg4
        };

        Random random = new Random();
        int randomBg = backgrounds[random.nextInt(backgrounds.length)];

        backgroundImage.setImageResource(randomBg);
    }
}
