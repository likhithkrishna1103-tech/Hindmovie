package n;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k2 extends f2 implements g2 {
    public static final Method Y;
    public rc.b X;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                Y = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // n.g2
    public final void B(m.k kVar, MenuItem menuItem) {
        rc.b bVar = this.X;
        if (bVar != null) {
            bVar.B(kVar, menuItem);
        }
    }

    @Override // n.g2
    public final void h(m.k kVar, m.m mVar) {
        rc.b bVar = this.X;
        if (bVar != null) {
            bVar.h(kVar, mVar);
        }
    }

    @Override // n.f2
    public final t1 p(Context context, boolean z2) {
        j2 j2Var = new j2(context, z2);
        j2Var.setHoverListener(this);
        return j2Var;
    }
}
