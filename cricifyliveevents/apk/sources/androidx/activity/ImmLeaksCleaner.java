package androidx.activity;

import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import c.x;
import c.y;
import ge.i;
import rd.j;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements q {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final j f512w = new j(new x(0));

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final h.j f513v;

    public ImmLeaksCleaner(h.j jVar) {
        this.f513v = jVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar != m.ON_DESTROY) {
            return;
        }
        Object systemService = this.f513v.getSystemService("input_method");
        i.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        y yVar = (y) f512w.getValue();
        Object objB = yVar.b(inputMethodManager);
        if (objB == null) {
            return;
        }
        synchronized (objB) {
            View viewC = yVar.c(inputMethodManager);
            if (viewC == null) {
                return;
            }
            if (viewC.isAttachedToWindow()) {
                return;
            }
            boolean zA = yVar.a(inputMethodManager);
            if (zA) {
                inputMethodManager.isActive();
            }
        }
    }
}
