package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Bundle;
import java.util.LinkedHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b1 implements androidx.lifecycle.i, b5.f, androidx.lifecycle.u0 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final y f944v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final androidx.lifecycle.t0 f945w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final androidx.emoji2.text.w f946x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public androidx.lifecycle.r0 f947y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public androidx.lifecycle.u f948z = null;
    public com.bumptech.glide.manager.u A = null;

    public b1(y yVar, androidx.lifecycle.t0 t0Var, androidx.emoji2.text.w wVar) {
        this.f944v = yVar;
        this.f945w = t0Var;
        this.f946x = wVar;
    }

    @Override // b5.f
    public final b5.e a() {
        g();
        return (b5.e) this.A.f2291x;
    }

    public final void b(androidx.lifecycle.m mVar) {
        this.f948z.d(mVar);
    }

    @Override // androidx.lifecycle.i
    public final androidx.lifecycle.r0 c() {
        Application application;
        y yVar = this.f944v;
        androidx.lifecycle.r0 r0VarC = yVar.c();
        if (!r0VarC.equals(yVar.f1114m0)) {
            this.f947y = r0VarC;
            return r0VarC;
        }
        if (this.f947y == null) {
            Context applicationContext = yVar.K().getApplicationContext();
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
            this.f947y = new androidx.lifecycle.m0(application, yVar, yVar.B);
        }
        return this.f947y;
    }

    @Override // androidx.lifecycle.i
    public final a7.a d() {
        Application application;
        y yVar = this.f944v;
        Context applicationContext = yVar.K().getApplicationContext();
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
        t1.c cVar = new t1.c(0);
        LinkedHashMap linkedHashMap = (LinkedHashMap) cVar.f307w;
        if (application != null) {
            linkedHashMap.put(androidx.lifecycle.p0.f1190a, application);
        }
        linkedHashMap.put(androidx.lifecycle.i0.f1163a, yVar);
        linkedHashMap.put(androidx.lifecycle.i0.f1164b, this);
        Bundle bundle = yVar.B;
        if (bundle != null) {
            linkedHashMap.put(androidx.lifecycle.i0.f1165c, bundle);
        }
        return cVar;
    }

    @Override // androidx.lifecycle.u0
    public final androidx.lifecycle.t0 e() {
        g();
        return this.f945w;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.u f() {
        g();
        return this.f948z;
    }

    public final void g() {
        if (this.f948z == null) {
            this.f948z = new androidx.lifecycle.u(this);
            com.bumptech.glide.manager.u uVar = new com.bumptech.glide.manager.u(this);
            this.A = uVar;
            uVar.d();
            this.f946x.run();
        }
    }
}
