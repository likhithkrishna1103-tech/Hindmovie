package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.manager.v;
import com.google.android.gms.internal.measurement.i4;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class p implements ComponentCallbacks2, com.bumptech.glide.manager.h {
    public static final o7.g F = (o7.g) ((o7.g) new o7.g().d(Bitmap.class)).i();
    public final v A;
    public final androidx.fragment.app.m B;
    public final com.bumptech.glide.manager.b C;
    public final CopyOnWriteArrayList D;
    public o7.g E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final b f2295v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f2296w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final com.bumptech.glide.manager.g f2297x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final i4 f2298y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final com.bumptech.glide.manager.m f2299z;

    static {
    }

    public p(b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.m mVar, Context context) {
        i4 i4Var = new i4(1);
        ka.f fVar = bVar.A;
        this.A = new v();
        androidx.fragment.app.m mVar2 = new androidx.fragment.app.m(4, this);
        this.B = mVar2;
        this.f2295v = bVar;
        this.f2297x = gVar;
        this.f2299z = mVar;
        this.f2298y = i4Var;
        this.f2296w = context;
        Context applicationContext = context.getApplicationContext();
        o oVar = new o(this, i4Var);
        fVar.getClass();
        boolean z10 = i0.c.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z10 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        com.bumptech.glide.manager.b cVar = z10 ? new com.bumptech.glide.manager.c(applicationContext, oVar) : new com.bumptech.glide.manager.j();
        this.C = cVar;
        synchronized (bVar.B) {
            if (bVar.B.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.B.add(this);
        }
        char[] cArr = s7.m.f11607a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.b(this);
        } else {
            s7.m.f().post(mVar2);
        }
        gVar.b(cVar);
        this.D = new CopyOnWriteArrayList(bVar.f2195x.f2205e);
        t(bVar.f2195x.a());
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void c() {
        this.A.c();
        r();
    }

    public n h(Class cls) {
        return new n(this.f2295v, this, cls, this.f2296w);
    }

    public n i() {
        return h(Bitmap.class).a(F);
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void l() {
        s();
        this.A.l();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void m() {
        this.A.m();
        p();
        i4 i4Var = this.f2298y;
        ArrayList arrayListE = s7.m.e((Set) i4Var.f2483x);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            i4Var.b((o7.c) obj);
        }
        ((HashSet) i4Var.f2484y).clear();
        this.f2297x.c(this);
        this.f2297x.c(this.C);
        s7.m.f().removeCallbacks(this.B);
        this.f2295v.c(this);
    }

    public n n() {
        return h(Drawable.class);
    }

    public final void o(p7.d dVar) {
        if (dVar == null) {
            return;
        }
        boolean zU = u(dVar);
        o7.c cVarJ = dVar.j();
        if (zU) {
            return;
        }
        b bVar = this.f2295v;
        synchronized (bVar.B) {
            try {
                ArrayList arrayList = bVar.B;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((p) obj).u(dVar)) {
                        return;
                    }
                }
                if (cVarJ != null) {
                    dVar.d(null);
                    cVarJ.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void p() {
        try {
            ArrayList arrayListE = s7.m.e(this.A.f2292v);
            int size = arrayListE.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListE.get(i);
                i++;
                o((p7.d) obj);
            }
            this.A.f2292v.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public n q(String str) {
        return n().E(str);
    }

    public final synchronized void r() {
        i4 i4Var = this.f2298y;
        i4Var.f2482w = true;
        ArrayList arrayListE = s7.m.e((Set) i4Var.f2483x);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            o7.c cVar = (o7.c) obj;
            if (cVar.isRunning()) {
                cVar.c();
                ((HashSet) i4Var.f2484y).add(cVar);
            }
        }
    }

    public final synchronized void s() {
        i4 i4Var = this.f2298y;
        int i = 0;
        i4Var.f2482w = false;
        ArrayList arrayListE = s7.m.e((Set) i4Var.f2483x);
        int size = arrayListE.size();
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            o7.c cVar = (o7.c) obj;
            if (!cVar.j() && !cVar.isRunning()) {
                cVar.h();
            }
        }
        ((HashSet) i4Var.f2484y).clear();
    }

    public synchronized void t(o7.g gVar) {
        this.E = (o7.g) ((o7.g) gVar.clone()).b();
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f2298y + ", treeNode=" + this.f2299z + "}";
    }

    public final synchronized boolean u(p7.d dVar) {
        o7.c cVarJ = dVar.j();
        if (cVarJ == null) {
            return true;
        }
        if (!this.f2298y.b(cVarJ)) {
            return false;
        }
        this.A.f2292v.remove(dVar);
        dVar.d(null);
        return true;
    }

    @Override // android.content.ComponentCallbacks
    public final void onLowMemory() {
    }

    @Override // android.content.ComponentCallbacks
    public final void onConfigurationChanged(Configuration configuration) {
    }

    @Override // android.content.ComponentCallbacks2
    public final void onTrimMemory(int i) {
    }
}
