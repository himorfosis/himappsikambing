package com.dinaham.sikarbing;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

/**
 * Created by him on 5/5/2018.
 */

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNumOfTabs;

    public PagerAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                UtamaFragBeranda tab1 = new UtamaFragBeranda();
                return tab1;
            case 1:
                UtamaFragBantuan tab2 = new UtamaFragBantuan();
                return tab2;

            case 2:
                UtamaFragPengguna tab3 = new UtamaFragPengguna();
                return tab3;

            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNumOfTabs;
//        return 3;
    }
}
