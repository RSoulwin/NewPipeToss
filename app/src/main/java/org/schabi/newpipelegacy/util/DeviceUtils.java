package org.schabi.newpipelegacy.util;

import android.app.UiModeManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.BatteryManager;
import android.os.Build;
import android.util.TypedValue;
import android.view.KeyEvent;

import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;

import org.schabi.newpipelegacy.App;

public final class DeviceUtils {

    private static final String AMAZON_FEATURE_FIRE_TV = "amazon.hardware.fire_tv";
    private static Boolean isTV = null;

    /*
     * Devices that do not support media tunneling
     */
    // Formuler Z8 Pro, Z8, CC, Z Alpha, Z+ Neo
    private static final boolean HI3798MV200 = Build.VERSION.SDK_INT == 24
            && Build.DEVICE.equals("Hi3798MV200");
    // Zephir TS43UHD-2
    private static final boolean CVT_MT5886_EU_1G = Build.VERSION.SDK_INT == 24
            && Build.DEVICE.equals("cvt_mt5886_eu_1g");
    // Hilife TV
    private static final boolean REALTEKATV = Build.VERSION.SDK_INT == 25
            && Build.DEVICE.equals("RealtekATV");
    // Philips QM16XE
    private static final boolean QM16XE_U = Build.VERSION.SDK_INT == 23
            && Build.DEVICE.equals("QM16XE_U");
    // Sony Bravia VH1 with Processor: MT5895
    private static final boolean BRAVIA_VH1 = Build.VERSION.SDK_INT == 29
            && Build.DEVICE.equals("BRAVIA_VH1");
    // Sony Bravia VH2 this includes model A90J
    private static final boolean BRAVIA_VH2 = Build.VERSION.SDK_INT == 29
            && Build.DEVICE.equals("BRAVIA_VH2");
    // Sony Bravia Android TV platform 2
	// Uses a MediaTek MT5891 (MT5596) SoC
    private static final boolean BRAVIA_ATV2 = Build.VERSION.SDK_INT == 29
            && Build.DEVICE.equals("BRAVIA_ATV2");
    // Sony Bravia Android TV platform 3 4K
	// Uses ARM MT5891 and a BRAVIA_ATV2 motherboard
    private static final boolean BRAVIA_ATV3_4K = Build.VERSION.SDK_INT == 29
            && Build.DEVICE.equals("BRAVIA_ATV3_4K");
    // Panasonic 4KTV-JUP
    private static final boolean TX_50JXW834 = Build.VERSION.SDK_INT == 30
            && Build.DEVICE.equals("TX_50JXW834");
    // Bouygtel4K / Bouygues Telecom Bbox 4K
    private static final boolean HMB9213NW = Build.VERSION.SDK_INT == 28
            && Build.DEVICE.equals("HMB9213NW");
    // Phillips 4K (O)LED TV
    private static final boolean PH7M_EU_5596 = Build.VERSION.SDK_INT == 26
            && Build.DEVICE.equals("PH7M_EU_5596");

    private DeviceUtils() {
    }

    public static boolean isTv(final Context context) {
        if (isTV != null) {
            return isTV;
        }

        final PackageManager pm = App.getApp().getPackageManager();

        // from doc: https://developer.android.com/training/tv/start/hardware.html#runtime-check
        boolean isTv = ContextCompat.getSystemService(context, UiModeManager.class)
                .getCurrentModeType() == Configuration.UI_MODE_TYPE_TELEVISION
                || pm.hasSystemFeature(AMAZON_FEATURE_FIRE_TV)
                || pm.hasSystemFeature(PackageManager.FEATURE_TELEVISION);

        // from https://stackoverflow.com/a/58932366
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            final boolean isBatteryAbsent = context.getSystemService(BatteryManager.class)
                    .getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY) == 0;
            isTv = isTv || (isBatteryAbsent
                    && !pm.hasSystemFeature(PackageManager.FEATURE_TOUCHSCREEN)
                    && pm.hasSystemFeature(PackageManager.FEATURE_USB_HOST)
                    && pm.hasSystemFeature(PackageManager.FEATURE_ETHERNET));
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            isTv = isTv || pm.hasSystemFeature(PackageManager.FEATURE_LEANBACK);
        }

        DeviceUtils.isTV = isTv;
        return DeviceUtils.isTV;
    }

    public static boolean isTablet(@NonNull final Context context) {
        return (context
                .getResources()
                .getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    public static boolean isConfirmKey(final int keyCode) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_DPAD_CENTER:
            case KeyEvent.KEYCODE_ENTER:
            case KeyEvent.KEYCODE_SPACE:
            case KeyEvent.KEYCODE_NUMPAD_ENTER:
                return true;
            default:
                return false;
        }
    }

    public static int dpToPx(@Dimension(unit = Dimension.DP) final int dp,
                             @NonNull final Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dp,
                context.getResources().getDisplayMetrics());
    }

    public static int spToPx(@Dimension(unit = Dimension.SP) final int sp,
                             @NonNull final Context context) {
        return (int) TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_SP,
                sp,
                context.getResources().getDisplayMetrics());
    }

    /**
     * Some devices have broken tunneled video playback but claim to support it.
     * See https://github.com/TeamNewPipe/NewPipe/issues/5911
     * @return false if Kitkat (does not support tunneling) or affected device
     */
    public static boolean shouldSupportMediaTunneling() {
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP
                && !HI3798MV200
                && !CVT_MT5886_EU_1G
                && !REALTEKATV
                && !QM16XE_U
				&& !BRAVIA_VH1
				&& !BRAVIA_VH2
				&& !BRAVIA_ATV2
				&& !BRAVIA_ATV3_4K
				&& !TX_50JXW834
				&& !HMB9213NW
				&& !PH7M_EU_5596;
    }
}
