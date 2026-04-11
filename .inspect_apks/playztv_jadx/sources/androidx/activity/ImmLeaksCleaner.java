package androidx.activity;

import a5.c;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import androidx.lifecycle.m;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import be.h;
import c.w;
import h.j;
import nd.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class ImmLeaksCleaner implements q {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public static final i f852v = new i(new c(2));

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j f853u;

    public ImmLeaksCleaner(j jVar) {
        this.f853u = jVar;
    }

    @Override // androidx.lifecycle.q
    public final void a(s sVar, m mVar) {
        if (mVar != m.ON_DESTROY) {
            return;
        }
        Object systemService = this.f853u.getSystemService("input_method");
        h.c(systemService, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager inputMethodManager = (InputMethodManager) systemService;
        w wVar = (w) f852v.getValue();
        Object objB = wVar.b(inputMethodManager);
        if (objB == null) {
            return;
        }
        synchronized (objB) {
            View viewC = wVar.c(inputMethodManager);
            if (viewC == null) {
                return;
            }
            if (viewC.isAttachedToWindow()) {
                return;
            }
            boolean zA = wVar.a(inputMethodManager);
            if (zA) {
                inputMethodManager.isActive();
            }
        }
    }
}
