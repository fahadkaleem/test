package com.mohammedfahadkaleem.extremematerialui.data;

import android.content.Context;
import android.content.res.TypedArray;
import com.mohammedfahadkaleem.extremematerialui.R;
import com.mohammedfahadkaleem.extremematerialui.model.MaterialComponents;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by fahadkaleem on 1/3/19.
 */
public class DataGenerator {

  public static List<MaterialComponents> getMaterialComponents(Context ctx) {
    List<MaterialComponents> componentsList = new ArrayList<>();
    TypedArray componentImages = ctx.getResources().obtainTypedArray(R.array.material_components_icons);
    String componentNamesArray[] = ctx.getResources().getStringArray(R.array.material_components);

    for (int i = 0; i < componentNamesArray.length; i++) {
      MaterialComponents component = new MaterialComponents();
      component.setComponentIcon(componentImages.getResourceId(i, -1));
      component.setComponentName(componentNamesArray[i]);
      //obj.email = Tools.getEmailFromName(obj.name);
      component.setComponentIconDrawable(ctx.getResources().getDrawable(component.getComponentIcon()));
      componentsList.add(component);
    }
    return componentsList;
  }

}
