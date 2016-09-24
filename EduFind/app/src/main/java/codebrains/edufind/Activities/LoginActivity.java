package codebrains.edufind.Activities;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import codebrains.edufind.Adapters.MainTabsAdapter;
import codebrains.edufind.Fragments.CreateAccountFragment;
import codebrains.edufind.R;

public class LoginActivity extends ActionBarActivity implements android.support.v7.app.ActionBar.TabListener {

    private ViewPager tabsviewPager;
    private MainTabsAdapter mTabsAdapter;
    private ActionBar actionBar;


    //Fragment objects
    private CreateAccountFragment caf;

    //Constructor
    public LoginActivity() {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize fragment objects
        caf = new CreateAccountFragment();





        //Initializing the tab view of this activity
        tabsviewPager = (ViewPager) findViewById(R.id.tabspager);
        mTabsAdapter = new MainTabsAdapter(getSupportFragmentManager());
        tabsviewPager.setAdapter(mTabsAdapter);
        actionBar = getSupportActionBar();

        this.getSupportActionBar().setHomeButtonEnabled(false);
        this.getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        ActionBar.Tab loginTab = getSupportActionBar().newTab()
                .setText(" Login")
                .setTabListener(this);

        ActionBar.Tab createAccountTab = getSupportActionBar().newTab()
                .setText(" Create Account")
                .setTabListener(this);

        getSupportActionBar().addTab(loginTab);
        getSupportActionBar().addTab(createAccountTab);

        //Event listener that runs whenever the tabs are swiped, it is used to make enable the
        //respective tab.
        tabsviewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                actionBar.setSelectedNavigationItem(position); //Enable the respective tab.
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }

    /**
     * Method that calls the block of code to render the geolocation info of a certain user.
     * @param view The view object that called this event.
     */
    public void GetGeolocationOfUser(View view) {

        this.caf.GetGeolocationInfo(this);

    }



    @Override
    public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
        tabsviewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {

    }

    @Override
    public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        tabsviewPager.setCurrentItem(tab.getPosition());
    }


}
