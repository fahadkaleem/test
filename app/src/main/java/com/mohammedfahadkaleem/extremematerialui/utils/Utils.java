package com.mohammedfahadkaleem.extremematerialui.utils;

import android.app.Activity;
import android.os.Build;
import android.view.Window;
import android.view.WindowManager;
import com.mohammedfahadkaleem.extremematerialui.R;

/**
 * Created by fahadkaleem on 1/3/19.
 */
public class Utils {
  public static void setSystemBarColor(Activity act) {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window window = act.getWindow();
      window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      window.setStatusBarColor(act.getResources().getColor(R.color.colorPrimaryDark));
    }
  }
}
