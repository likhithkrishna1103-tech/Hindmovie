package com.bumptech.glide.manager;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import androidx.savedstate.Recreator;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Map;
import k4.b0;
import k4.l0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements ya.r {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile u f2288y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f2289v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f2290w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2291x;

    public u() {
        this.f2290w = new Object();
    }

    public static u c(Context context) {
        if (f2288y == null) {
            synchronized (u.class) {
                try {
                    if (f2288y == null) {
                        f2288y = new u(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f2288y;
    }

    @Override // ya.r
    public void a(Object obj) {
        b0 b0Var = ((l0) this.f2291x).f7060g;
        Handler handler = b0Var.f6916l;
        k4.s sVar = (k4.s) this.f2290w;
        a0.S(handler, new androidx.fragment.app.d(b0Var, sVar, new g2.a0(this, (k4.t) obj, this.f2289v, sVar)));
    }

    public void b(m8.a aVar, j9.i iVar) {
        l4.a aVar2 = (l4.a) ((m2.e) this.f2291x).f8050v;
        aVar2.getClass();
        q8.a aVar3 = (q8.a) ((q8.d) aVar).u();
        o8.l lVar = (o8.l) aVar2.f7697v;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar3.f10447e);
        int i = y8.a.f14973a;
        if (lVar == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            lVar.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar3.f10446d.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            iVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    public void d() {
        b5.f fVar = (b5.f) this.f2290w;
        androidx.lifecycle.u uVarF = fVar.f();
        if (uVarF.f1200c != androidx.lifecycle.n.f1180w) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        uVarF.a(new Recreator(fVar));
        b5.e eVar = (b5.e) this.f2291x;
        eVar.getClass();
        if (eVar.f1785a) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        uVarF.a(new c.h(2, eVar));
        eVar.f1785a = true;
        this.f2289v = true;
    }

    public void e(Bundle bundle) {
        if (!this.f2289v) {
            d();
        }
        androidx.lifecycle.u uVarF = ((b5.f) this.f2290w).f();
        if (uVarF.f1200c.compareTo(androidx.lifecycle.n.f1182y) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + uVarF.f1200c).toString());
        }
        b5.e eVar = (b5.e) this.f2291x;
        if (!eVar.f1785a) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (eVar.f1786b) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        eVar.f1789e = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        eVar.f1786b = true;
    }

    public void f(Bundle bundle) {
        b5.e eVar = (b5.e) this.f2291x;
        eVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) eVar.f1789e;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        q.f fVar = (q.f) eVar.f1788d;
        fVar.getClass();
        q.d dVar = new q.d(fVar);
        fVar.f10319x.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((b5.d) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void h(j9.o oVar) {
        synchronized (this.f2290w) {
            try {
                if (((ArrayDeque) this.f2291x) == null) {
                    this.f2291x = new ArrayDeque();
                }
                ((ArrayDeque) this.f2291x).add(oVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void i(j9.p pVar) {
        j9.o oVar;
        synchronized (this.f2290w) {
            if (((ArrayDeque) this.f2291x) != null && !this.f2289v) {
                this.f2289v = true;
                while (true) {
                    synchronized (this.f2290w) {
                        try {
                            oVar = (j9.o) ((ArrayDeque) this.f2291x).poll();
                            if (oVar == null) {
                                this.f2289v = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    oVar.c(pVar);
                }
            }
        }
    }

    public u(m2.e eVar, l8.d[] dVarArr, boolean z10) {
        this.f2291x = eVar;
        this.f2290w = dVarArr;
        boolean z11 = false;
        if (dVarArr != null && z10) {
            z11 = true;
        }
        this.f2289v = z11;
    }

    public u(b5.f fVar) {
        this.f2290w = fVar;
        this.f2291x = new b5.e();
    }

    public u(Context context) {
        Object tVar;
        this.f2291x = new HashSet();
        l8.i iVar = new l8.i(new ad.b(context, false));
        n nVar = new n(this);
        if (Build.VERSION.SDK_INT >= 24) {
            tVar = new com.bumptech.glide.l(iVar, nVar);
        } else {
            tVar = new t(context, iVar, nVar);
        }
        this.f2290w = tVar;
    }

    public u(l0 l0Var, k4.s sVar, boolean z10) {
        this.f2291x = l0Var;
        this.f2290w = sVar;
        this.f2289v = z10;
    }

    @Override // ya.r
    public void g(Throwable th) {
    }
}
