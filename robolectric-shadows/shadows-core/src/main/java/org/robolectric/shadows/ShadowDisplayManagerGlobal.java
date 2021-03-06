package org.robolectric.shadows;

import android.hardware.display.DisplayManagerGlobal;
import android.hardware.display.IDisplayManager;
import android.hardware.display.RoboDisplayManager;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;
import org.robolectric.internal.Shadow;
import org.robolectric.util.ReflectionHelpers;
import org.robolectric.util.ReflectionHelpers.ClassParameter;

@Implements(value = DisplayManagerGlobal.class, isInAndroidSdk = false)
public class ShadowDisplayManagerGlobal {
  private static final RoboDisplayManager displayManager = new RoboDisplayManager();

  @Implementation
  public static Object getInstance() {
    return ReflectionHelpers.callConstructor(DisplayManagerGlobal.class,
        ClassParameter.from(IDisplayManager.class, displayManager));
  }

  @Implementation
  public Object getDisplayInfo(int displayId) {
    return Shadow.newInstanceOf("android.view.DisplayInfo");
  }
}
