package com.e.taskapps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class OnBoardActivity extends AppCompatActivity {
   private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_board);

        viewPager= findViewById(R.id.viewPager);
        SectionPagerAdapter adapter= new SectionPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        TabLayout tabLayout = findViewById(R.id.tab_layout);
        tabLayout.setupWithViewPager(viewPager, true);
    }

    public class SectionPagerAdapter extends FragmentStatePagerAdapter{

        public SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            BoardFragment boardFragment= new BoardFragment();
            Bundle bundle= new Bundle();
            bundle.putInt("pos", position);
            boardFragment.setArguments(bundle);
            return boardFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
