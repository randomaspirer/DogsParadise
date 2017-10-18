package randomtechsolutions.com.dogsparadise;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class BottomNavigationActivity extends AppCompatActivity {
    
    private TextView mTextMessage;
    
    private static final String BREEDS_FRAGMENT_TAG = "breeds";
    private static final String IMAGES_FRAGMENT_TAG = "images";
    
    
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_breeds:
                    createBreedFragment();
                    return true;
                case R.id.navigation_images:
                    createImagesFragment();
                    return true;
                case R.id.navigation_saved:
                    mTextMessage.setText(R.string.title_saved);
                    return true;
            }
            return false;
        }
    };
    
    private void createBreedFragment(){
        if(getSupportFragmentManager().findFragmentByTag(BREEDS_FRAGMENT_TAG)==null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new BreedsFragment(), BREEDS_FRAGMENT_TAG)
                    .commit();
        }
    }
    
    private void createImagesFragment(){
       /* if(getSupportFragmentManager().findFragmentByTag(IMAGES_FRAGMENT_TAG)!=null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, new ImagesFragment(), IMAGES_FRAGMENT_TAG)
                    .commit();
        }*/
    }
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        
        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        
        
        
    }
    
    @Override
    protected void onDestroy() {
        super.onDestroy();
        
    }
}
