package n;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f8532b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static t f8533c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public n2 f8534a;

    public static synchronized t a() {
        try {
            if (f8533c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f8533c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return n2.h(i, mode);
    }

    public static synchronized void d() {
        if (f8533c == null) {
            t tVar = new t();
            f8533c = tVar;
            tVar.f8534a = n2.d();
            f8533c.f8534a.m(new b2.g());
        }
    }

    public static void e(Drawable drawable, d3 d3Var, int[] iArr) {
        PorterDuff.Mode mode = n2.f8460h;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z2 = d3Var.f8374b;
        if (z2 || d3Var.f8373a) {
            PorterDuffColorFilter porterDuffColorFilterH = null;
            ColorStateList colorStateList = z2 ? (ColorStateList) d3Var.f8375c : null;
            PorterDuff.Mode mode2 = d3Var.f8373a ? (PorterDuff.Mode) d3Var.f8376d : n2.f8460h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilterH = n2.h(colorStateList.getColorForState(iArr, 0), mode2);
            }
            drawable.setColorFilter(porterDuffColorFilterH);
        } else {
            drawable.clearColorFilter();
        }
        if (Build.VERSION.SDK_INT <= 23) {
            drawable.invalidateSelf();
        }
    }

    public final synchronized Drawable b(Context context, int i) {
        return this.f8534a.f(context, i);
    }
}
