package com.mohammedfahadkaleem.extremematerialui.model;

import android.graphics.drawable.Drawable;

/**
 * Created by fahadkaleem on 1/3/19.
 */
public class MaterialComponents {
  public int componentIcon;
  private String componentName;
  public Drawable componentIconDrawable;

  public int getComponentIcon() {
    return componentIcon;
  }

  public void setComponentIcon(int componentIcon) {
    this.componentIcon = componentIcon;
  }

  public String getComponentName() {
    return componentName;
  }

  public void setComponentName(String componentName) {
    this.componentName = componentName;
  }

  public Drawable getComponentIconDrawable() {
    return componentIconDrawable;
  }

  public void setComponentIconDrawable(Drawable componentIconDrawable) {
    this.componentIconDrawable = componentIconDrawable;
  }
}
