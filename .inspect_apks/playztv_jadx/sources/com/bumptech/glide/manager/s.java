package com.bumptech.glide.manager;

import a2.g0;
import a2.i0;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import androidx.lifecycle.u;
import androidx.savedstate.Recreator;
import g4.b0;
import g4.m0;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import p1.s0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements ea.s {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static volatile s f2859y;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2860u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f2861v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f2862w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f2863x;

    public s(q0.e eVar, q7.d[] dVarArr, boolean z2) {
        this.f2860u = 7;
        this.f2861v = eVar;
        this.f2863x = dVarArr;
        boolean z10 = false;
        if (dVarArr != null && z2) {
            z10 = true;
        }
        this.f2862w = z10;
    }

    public static s d(Context context) {
        if (f2859y == null) {
            synchronized (s.class) {
                try {
                    if (f2859y == null) {
                        f2859y = new s(context.getApplicationContext());
                    }
                } finally {
                }
            }
        }
        return f2859y;
    }

    public boolean a(t6.c cVar) {
        boolean z2 = true;
        if (cVar == null) {
            return true;
        }
        boolean zRemove = ((Set) this.f2863x).remove(cVar);
        if (!((HashSet) this.f2861v).remove(cVar) && !zRemove) {
            z2 = false;
        }
        if (z2) {
            cVar.clear();
        }
        return z2;
    }

    public void b(r7.a aVar, o8.h hVar) {
        ta.j jVar = (ta.j) ((q0.e) this.f2861v).f10436v;
        jVar.getClass();
        v7.a aVar2 = (v7.a) ((v7.d) aVar).u();
        t7.l lVar = (t7.l) jVar.f12372u;
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.writeInterfaceToken(aVar2.f13323e);
        int i = d8.b.f4099a;
        if (lVar == null) {
            parcelObtain.writeInt(0);
        } else {
            parcelObtain.writeInt(1);
            lVar.writeToParcel(parcelObtain, 0);
        }
        try {
            aVar2.f13322d.transact(1, parcelObtain, null, 1);
            parcelObtain.recycle();
            hVar.a(null);
        } catch (Throwable th) {
            parcelObtain.recycle();
            throw th;
        }
    }

    @Override // ea.s
    public void c(Object obj) {
        switch (this.f2860u) {
            case 3:
                b0 b0Var = (b0) this.f2861v;
                g4.s sVar = (g4.s) this.f2863x;
                boolean z2 = this.f2862w;
                z7.a.C(b0Var.f4973t, (g4.t) obj);
                s1.b0.F(b0Var.f4973t);
                if (z2) {
                    b0Var.p(sVar);
                }
                break;
            default:
                b0 b0Var2 = ((m0) this.f2861v).f5115g;
                Handler handler = b0Var2.f4965l;
                g4.s sVar2 = (g4.s) this.f2863x;
                s1.b0.S(handler, new g0(b0Var2, sVar2, new i0(this, (g4.t) obj, this.f2862w, sVar2)));
                break;
        }
    }

    public void f() {
        x4.d dVar = (x4.d) this.f2863x;
        u uVarF = dVar.f();
        if (uVarF.f1504c != androidx.lifecycle.n.f1483v) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        uVarF.a(new Recreator(dVar));
        n.s sVar = (n.s) this.f2861v;
        sVar.getClass();
        if (sVar.f8524c) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        uVarF.a(new c.h(2, sVar));
        sVar.f8524c = true;
        this.f2862w = true;
    }

    public void g(Bundle bundle) {
        if (!this.f2862w) {
            f();
        }
        u uVarF = ((x4.d) this.f2863x).f();
        if (uVarF.f1504c.compareTo(androidx.lifecycle.n.f1485x) >= 0) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + uVarF.f1504c).toString());
        }
        n.s sVar = (n.s) this.f2861v;
        if (!sVar.f8524c) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (sVar.f8525d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        sVar.f8522a = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        sVar.f8525d = true;
    }

    public void h(Bundle bundle) {
        n.s sVar = (n.s) this.f2861v;
        sVar.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = (Bundle) sVar.f8522a;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        p.f fVar = (p.f) sVar.f;
        fVar.getClass();
        p.d dVar = new p.d(fVar);
        fVar.f9605w.put(dVar, Boolean.FALSE);
        while (dVar.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar.next();
            bundle2.putBundle((String) entry.getKey(), ((x4.c) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }

    public void i(o8.n nVar) {
        synchronized (this.f2863x) {
            try {
                if (((ArrayDeque) this.f2861v) == null) {
                    this.f2861v = new ArrayDeque();
                }
                ((ArrayDeque) this.f2861v).add(nVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void j(o8.o oVar) {
        o8.n nVar;
        synchronized (this.f2863x) {
            if (((ArrayDeque) this.f2861v) != null && !this.f2862w) {
                this.f2862w = true;
                while (true) {
                    synchronized (this.f2863x) {
                        try {
                            nVar = (o8.n) ((ArrayDeque) this.f2861v).poll();
                            if (nVar == null) {
                                this.f2862w = false;
                                return;
                            }
                        } finally {
                        }
                    }
                    nVar.a(oVar);
                }
            }
        }
    }

    @Override // ea.s
    public void p(Throwable th) {
        switch (this.f2860u) {
            case 3:
                b0 b0Var = (b0) this.f2861v;
                if (th instanceof UnsupportedOperationException) {
                    s1.b.q("MediaSessionImpl", "UnsupportedOperationException: Make sure to implement MediaSession.Callback.onPlaybackResumption() if you add a media button receiver to your manifest or if you implement the recent media item contract with your MediaLibraryService.", th);
                } else {
                    s1.b.h("MediaSessionImpl", "Failure calling MediaSession.Callback.onPlaybackResumption(): " + th.getMessage(), th);
                }
                s1.b0.F(b0Var.f4973t);
                if (this.f2862w) {
                    b0Var.p((g4.s) this.f2863x);
                }
                break;
        }
    }

    public String toString() {
        switch (this.f2860u) {
            case 1:
                return super.toString() + "{numRequests=" + ((Set) this.f2863x).size() + ", isPaused=" + this.f2862w + "}";
            default:
                return super.toString();
        }
    }

    public s(int i) {
        this.f2860u = i;
        switch (i) {
            case 2:
                break;
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                this.f2863x = new Object();
                break;
            default:
                this.f2863x = Collections.newSetFromMap(new WeakHashMap());
                this.f2861v = new HashSet();
                break;
        }
    }

    public s(x4.d dVar) {
        this.f2860u = 8;
        this.f2863x = dVar;
        this.f2861v = new n.s();
    }

    public s(Context context) {
        Object rVar;
        this.f2860u = 0;
        this.f2861v = new HashSet();
        q7.h hVar = new q7.h(new c7.k(context));
        m mVar = new m(this);
        if (Build.VERSION.SDK_INT >= 24) {
            rVar = new a2.c(hVar, mVar);
        } else {
            rVar = new r(context, hVar, mVar);
        }
        this.f2863x = rVar;
    }

    public s(v1.g gVar) {
        this.f2860u = 5;
        this.f2863x = gVar;
        this.f2861v = new k8.b0(27);
    }

    public s(m0 m0Var, g4.s sVar, boolean z2) {
        this.f2860u = 4;
        this.f2861v = m0Var;
        this.f2863x = sVar;
        this.f2862w = z2;
    }

    public s(b0 b0Var, g4.s sVar, boolean z2, s0 s0Var) {
        this.f2860u = 3;
        this.f2861v = b0Var;
        this.f2863x = sVar;
        this.f2862w = z2;
    }

    private final void e(Throwable th) {
    }
}
