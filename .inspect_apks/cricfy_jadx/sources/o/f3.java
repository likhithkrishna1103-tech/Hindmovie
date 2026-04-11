package o;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class f3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadLocal f9219a = new ThreadLocal();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int[] f9220b = {-16842910};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int[] f9221c = {R.attr.state_focused};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int[] f9222d = {R.attr.state_pressed};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int[] f9223e = {R.attr.state_checked};
    public static final int[] f = new int[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int[] f9224g = new int[1];

    public static void a(Context context, View view) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(g.j.AppCompatTheme);
        try {
            if (!typedArrayObtainStyledAttributes.hasValue(g.j.AppCompatTheme_windowActionBar)) {
                Log.e("ThemeUtils", "View " + view.getClass() + " is an AppCompat widget that can only be used with a Theme.AppCompat theme (or descendant).");
            }
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    public static int b(Context context, int i) {
        ColorStateList colorStateListD = d(context, i);
        if (colorStateListD != null && colorStateListD.isStateful()) {
            return colorStateListD.getColorForState(f9220b, colorStateListD.getDefaultColor());
        }
        ThreadLocal threadLocal = f9219a;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue == null) {
            typedValue = new TypedValue();
            threadLocal.set(typedValue);
        }
        context.getTheme().resolveAttribute(R.attr.disabledAlpha, typedValue, true);
        float f10 = typedValue.getFloat();
        return l0.b.d(c(context, i), Math.round(Color.alpha(r4) * f10));
    }

    public static int c(Context context, int i) {
        int[] iArr = f9224g;
        iArr[0] = i;
        l7.a aVarE = l7.a.E(context, null, iArr);
        try {
            return ((TypedArray) aVarE.f7867x).getColor(0, 0);
        } finally {
            aVarE.G();
        }
    }

    public static ColorStateList d(Context context, int i) {
        int[] iArr = f9224g;
        iArr[0] = i;
        l7.a aVarE = l7.a.E(context, null, iArr);
        try {
            return aVarE.r(0);
        } finally {
            aVarE.G();
        }
    }
}
