package o;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.MenuItem;
import android.widget.PopupWindow;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class l2 extends g2 implements h2 {
    public static final Method Z;
    public m2.e Y;

    static {
        try {
            if (Build.VERSION.SDK_INT <= 28) {
                Z = PopupWindow.class.getDeclaredMethod("setTouchModal", Boolean.TYPE);
            }
        } catch (NoSuchMethodException unused) {
            Log.i("MenuPopupWindow", "Could not find method setTouchModal() on PopupWindow. Oh well.");
        }
    }

    @Override // o.h2
    public final void g(n.k kVar, MenuItem menuItem) {
        m2.e eVar = this.Y;
        if (eVar != null) {
            eVar.g(kVar, menuItem);
        }
    }

    @Override // o.h2
    public final void n(n.k kVar, n.m mVar) {
        m2.e eVar = this.Y;
        if (eVar != null) {
            eVar.n(kVar, mVar);
        }
    }

    @Override // o.g2
    public final t1 q(Context context, boolean z10) {
        k2 k2Var = new k2(context, z10);
        k2Var.setHoverListener(this);
        return k2Var;
    }
}
