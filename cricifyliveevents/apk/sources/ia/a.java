package ia;

import android.R;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import l0.b;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f6378a = {R.attr.state_pressed};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f6379b = {R.attr.state_focused};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f6380c = {R.attr.state_selected, R.attr.state_pressed};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f6381d = {R.attr.state_selected};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f6382e = {R.attr.state_enabled, R.attr.state_pressed};
    public static final String f = a.class.getSimpleName();

    public static int a(ColorStateList colorStateList, int[] iArr) {
        int colorForState = colorStateList != null ? colorStateList.getColorForState(iArr, colorStateList.getDefaultColor()) : 0;
        return b.d(colorForState, Math.min(Color.alpha(colorForState) * 2, 255));
    }

    public static ColorStateList b(ColorStateList colorStateList) {
        if (colorStateList == null) {
            return ColorStateList.valueOf(0);
        }
        if (Build.VERSION.SDK_INT <= 27 && Color.alpha(colorStateList.getDefaultColor()) == 0 && Color.alpha(colorStateList.getColorForState(f6382e, 0)) != 0) {
            Log.w(f, "Use a non-transparent color for the default color as it will be used to finish ripple animations.");
        }
        return colorStateList;
    }
}
