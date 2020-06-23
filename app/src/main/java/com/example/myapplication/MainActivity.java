package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.widget.Toast;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;

public class MainActivity extends AppCompatActivity {

    private MeowBottomNavigation meowBottomNavigation;

    private final static int HOME = 1;
    private final static int CATEGORY = 2;
    private final static int WISHLIST = 3;
    private final static int SEARCH = 4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        meowBottomNavigation = (MeowBottomNavigation) findViewById(R.id.meow_bottom_navigation);

        meowBottomNavigation.add(new MeowBottomNavigation.Model(1, R.mipmap.featured));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(2, R.mipmap.search));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(3, R.mipmap.category));
        meowBottomNavigation.add(new MeowBottomNavigation.Model(4, R.mipmap.favourite));
        /*meowBottomNavigation.add(new MeowBottomNavigation.Model(5, R.mipmap.web));*/

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main_activity, new HomeFragment()).commit();

        meowBottomNavigation.setOnClickMenuListener(new MeowBottomNavigation.ClickListener() {
            @Override
            public void onClickItem(MeowBottomNavigation.Model item) {
//                Toast.makeText(MainActivity.this, "Clicked Item "+item.getId(), Toast.LENGTH_SHORT).show();
            }
        });

        meowBottomNavigation.setOnShowListener(new MeowBottomNavigation.ShowListener() {
            @Override
            public void onShowItem(MeowBottomNavigation.Model item) {
                Fragment selectFragment = null;
                switch (item.getId()){
                    case HOME:
                        selectFragment = new HomeFragment();
                        break;
                    case CATEGORY:
                        selectFragment = new CategoryFragment();
                        break;
                    case WISHLIST:
                        selectFragment = new WishlistFragment();
                        break;
                    case SEARCH:

                    default:
                        return;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_main_activity, selectFragment).commit();
            }
        });

        meowBottomNavigation.setOnReselectListener(new MeowBottomNavigation.ReselectListener() {
            @Override
            public void onReselectItem(MeowBottomNavigation.Model item) {
                // your codes
            }
        });

    }
}
