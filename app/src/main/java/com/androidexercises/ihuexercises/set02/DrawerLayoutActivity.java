package com.androidexercises.ihuexercises.set02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toolbar;

import com.androidexercises.ihuexercises.R;
import com.google.android.material.navigation.NavigationView;


/**
 * This activity combines a drawer layout with a custom toolbar, style, and utilises the calculator
 * and web browser interface.
 */
public class DrawerLayoutActivity extends AppCompatActivity {
    public static final String TAGS_HOME = "com.androidexercises.ihuexercises.set02.DrawerLayoutActivity.HOME";
    public static final String TAGS_CALC = "com.androidexercises.ihuexercises.set02.DrawerLayoutActivity.CALCULATOR";
    public static final String TAGS_WEB_VIEW = "com.androidexercises.ihuexercises.set02.DrawerLayoutActivity.WEB_BROWSER";

    private Toolbar navBar;
    private TextView title;
    private NavigationView sideMenu;
    private DrawerLayout layout;
    private CalculatorOperationsListener calcFrag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer_layout);
        sideMenu = findViewById(R.id.sideMenu);
        navBar = findViewById(R.id.navbar);
        title = findViewById(R.id.titleText);
        layout = findViewById(R.id.drawerActivityLayout);
        //setActionBar(navBar);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragCont, new DrawerLayoutHomeFragment(), TAGS_HOME).commit();
        sideMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment frag;
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction trans = manager.beginTransaction();
                Log.i("pressed","side menu pressed");
                switch (menuItem.getItemId()) {
                    case R.id.openHome:
                        title.setText(menuItem.getTitle());
                        layout.closeDrawers();
                        frag = new DrawerLayoutHomeFragment();
                        trans.replace(R.id.fragCont, frag, TAGS_HOME);
                        trans.commit();
                        return true;
                    case R.id.openCalc:
                        title.setText(menuItem.getTitle());
                        layout.closeDrawers();
                        frag = new CalculatorLayoutFragment();
                        trans.replace(R.id.fragCont, frag, TAGS_CALC);
                        trans.commit();
                        calcFrag = (CalculatorOperationsListener)frag;
                        return true;
                    case R.id.openBrowser:
                        title.setText(menuItem.getTitle());
                        layout.closeDrawers();
                        /*
                        frag = new WebSearchFragment();
                        trans.replace(R.id.fragCont, frag, TAGS_WEB_VIEW);
                        trans.addToBackStack(null);
                        trans.commit();*/
                        return true;
                }
                return false;
            }
        });
    }



    public void appendOperandCK(View v) {
        calcFrag.appendOperandCK(v);
    }

    public void appendOperatorCK(View v) {
        calcFrag.appendOperatorCK(v);
    }

    public void appendCommaCK(View v) {
        calcFrag.appendCommaCK(v);
    }

    public void clear(View v) {
        calcFrag.clear(v);
    }

    public void delChar(View v) {
        calcFrag.delChar(v);
    }

    public void calculateCK(View v) {
        calcFrag.calculateCK(v);
    }

    public void powerCalc(View v) {
        calcFrag.powerCalc(v);
    }

}
