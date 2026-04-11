package o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import android.util.Log;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final PorterDuff.Mode f9335b = PorterDuff.Mode.SRC_IN;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static r f9336c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public o2 f9337a;

    public static synchronized r a() {
        try {
            if (f9336c == null) {
                d();
            }
        } catch (Throwable th) {
            throw th;
        }
        return f9336c;
    }

    public static synchronized PorterDuffColorFilter c(int i, PorterDuff.Mode mode) {
        return o2.h(i, mode);
    }

    public static synchronized void d() {
        if (f9336c == null) {
            r rVar = new r();
            f9336c = rVar;
            rVar.f9337a = o2.d();
            f9336c.f9337a.m(new c2.o(5));
        }
    }

    public static void e(Drawable drawable, kf.j jVar, int[] iArr) {
        PorterDuff.Mode mode = o2.f9290h;
        int[] state = drawable.getState();
        if (drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z10 = jVar.f7485b;
        if (z10 || jVar.f7484a) {
            PorterDuffColorFilter porterDuffColorFilterH = null;
            ColorStateList colorStateList = z10 ? (ColorStateList) jVar.f7486c : null;
            PorterDuff.Mode mode2 = jVar.f7484a ? (PorterDuff.Mode) jVar.f7487d : o2.f9290h;
            if (colorStateList != null && mode2 != null) {
                porterDuffColorFilterH = o2.h(colorStateList.getColorForState(iArr, 0), mode2);
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
        return this.f9337a.f(context, i);
    }
}
