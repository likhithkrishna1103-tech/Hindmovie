package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w0 implements androidx.lifecycle.i, x4.d, androidx.lifecycle.u0 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final v f1408u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final androidx.lifecycle.t0 f1409v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public androidx.lifecycle.r0 f1410w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public androidx.lifecycle.u f1411x = null;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public com.bumptech.glide.manager.s f1412y = null;

    public w0(v vVar, androidx.lifecycle.t0 t0Var) {
        this.f1408u = vVar;
        this.f1409v = t0Var;
    }

    @Override // x4.d
    public final n.s a() {
        g();
        return (n.s) this.f1412y.f2861v;
    }

    public final void b(androidx.lifecycle.m mVar) {
        this.f1411x.d(mVar);
    }

    @Override // androidx.lifecycle.i
    public final androidx.lifecycle.r0 c() {
        Application application;
        v vVar = this.f1408u;
        androidx.lifecycle.r0 r0VarC = vVar.c();
        if (!r0VarC.equals(vVar.l0)) {
            this.f1410w = r0VarC;
            return r0VarC;
        }
        if (this.f1410w == null) {
            Context applicationContext = vVar.H().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f1410w = new androidx.lifecycle.m0(application, this, vVar.A);
        }
        return this.f1410w;
    }

    @Override // androidx.lifecycle.i
    public final n1.c d() {
        Application application;
        v vVar = this.f1408u;
        Context applicationContext = vVar.H().getApplicationContext();
        while (true) {
            if (!(applicationContext instanceof ContextWrapper)) {
                application = null;
                break;
            }
            if (applicationContext instanceof Application) {
                application = (Application) applicationContext;
                break;
            }
            applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
        }
        n1.c cVar = new n1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f2454v;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.p0.f1494a, application);
        }
        linkedHashMap.put(androidx.lifecycle.i0.f1466a, this);
        linkedHashMap.put(androidx.lifecycle.i0.f1467b, this);
        Bundle bundle = vVar.A;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.i0.f1468c, bundle);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        g();
        return this.f1409v;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        g();
        return this.f1411x;
    }

    public final void g() {
        if (this.f1411x == null) {
            this.f1411x = new androidx.lifecycle.u(this);
            com.bumptech.glide.manager.s sVar = new com.bumptech.glide.manager.s(this);
            this.f1412y = sVar;
            sVar.f();
            androidx.lifecycle.i0.d(this);
        }
    }
}
