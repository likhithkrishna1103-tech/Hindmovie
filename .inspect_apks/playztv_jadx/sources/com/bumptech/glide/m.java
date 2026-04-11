package com.bumptech.glide;

import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.util.Log;
import com.bumptech.glide.manager.s;
import com.bumptech.glide.manager.t;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class m implements ComponentCallbacks2, com.bumptech.glide.manager.h {
    public static final t6.g E = (t6.g) ((t6.g) new t6.g().d(Bitmap.class)).i();
    public static final t6.g F = (t6.g) ((t6.g) new t6.g().d(p6.b.class)).i();
    public final androidx.fragment.app.e A;
    public final com.bumptech.glide.manager.b B;
    public final CopyOnWriteArrayList C;
    public t6.g D;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b f2824u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f2825v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final com.bumptech.glide.manager.g f2826w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final s f2827x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final com.bumptech.glide.manager.l f2828y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final t f2829z;

    static {
    }

    public m(b bVar, com.bumptech.glide.manager.g gVar, com.bumptech.glide.manager.l lVar, Context context) {
        s sVar = new s(1);
        q9.e eVar = bVar.f2765z;
        this.f2829z = new t();
        androidx.fragment.app.e eVar2 = new androidx.fragment.app.e(3, this);
        this.A = eVar2;
        this.f2824u = bVar;
        this.f2826w = gVar;
        this.f2828y = lVar;
        this.f2827x = sVar;
        this.f2825v = context;
        Context applicationContext = context.getApplicationContext();
        l lVar2 = new l(this, sVar);
        eVar.getClass();
        boolean z2 = f0.c.a(applicationContext, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if (Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", z2 ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor");
        }
        com.bumptech.glide.manager.b cVar = z2 ? new com.bumptech.glide.manager.c(applicationContext, lVar2) : new com.bumptech.glide.manager.j();
        this.B = cVar;
        synchronized (bVar.A) {
            if (bVar.A.contains(this)) {
                throw new IllegalStateException("Cannot register already registered manager");
            }
            bVar.A.add(this);
        }
        char[] cArr = x6.m.f14291a;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            gVar.b(this);
        } else {
            x6.m.f().post(eVar2);
        }
        gVar.b(cVar);
        this.C = new CopyOnWriteArrayList(bVar.f2762w.f2776e);
        u(bVar.f2762w.a());
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void d() {
        this.f2829z.d();
        s();
    }

    public k f(Class cls) {
        return new k(this.f2824u, this, cls, this.f2825v);
    }

    public k i() {
        return f(Bitmap.class).a(E);
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void l() {
        t();
        this.f2829z.l();
    }

    @Override // com.bumptech.glide.manager.h
    public final synchronized void m() {
        this.f2829z.m();
        q();
        s sVar = this.f2827x;
        ArrayList arrayListE = x6.m.e((Set) sVar.f2863x);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            sVar.a((t6.c) obj);
        }
        ((HashSet) sVar.f2861v).clear();
        this.f2826w.e(this);
        this.f2826w.e(this.B);
        x6.m.f().removeCallbacks(this.A);
        this.f2824u.c(this);
    }

    public k n() {
        return f(Drawable.class);
    }

    public k o() {
        return f(p6.b.class).a(F);
    }

    public final void p(u6.d dVar) {
        if (dVar == null) {
            return;
        }
        boolean zV = v(dVar);
        t6.c cVarG = dVar.g();
        if (zV) {
            return;
        }
        b bVar = this.f2824u;
        synchronized (bVar.A) {
            try {
                ArrayList arrayList = bVar.A;
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj = arrayList.get(i);
                    i++;
                    if (((m) obj).v(dVar)) {
                        return;
                    }
                }
                if (cVarG != null) {
                    dVar.j(null);
                    cVarG.clear();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void q() {
        try {
            ArrayList arrayListE = x6.m.e(this.f2829z.f2864u);
            int size = arrayListE.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayListE.get(i);
                i++;
                p((u6.d) obj);
            }
            this.f2829z.f2864u.clear();
        } catch (Throwable th) {
            throw th;
        }
    }

    public k r(String str) {
        return n().I(str);
    }

    public final synchronized void s() {
        s sVar = this.f2827x;
        sVar.f2862w = true;
        ArrayList arrayListE = x6.m.e((Set) sVar.f2863x);
        int size = arrayListE.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            t6.c cVar = (t6.c) obj;
            if (cVar.isRunning()) {
                cVar.f();
                ((HashSet) sVar.f2861v).add(cVar);
            }
        }
    }

    public final synchronized void t() {
        s sVar = this.f2827x;
        int i = 0;
        sVar.f2862w = false;
        ArrayList arrayListE = x6.m.e((Set) sVar.f2863x);
        int size = arrayListE.size();
        while (i < size) {
            Object obj = arrayListE.get(i);
            i++;
            t6.c cVar = (t6.c) obj;
            if (!cVar.k() && !cVar.isRunning()) {
                cVar.h();
            }
        }
        ((HashSet) sVar.f2861v).clear();
    }

    public final synchronized String toString() {
        return super.toString() + "{tracker=" + this.f2827x + ", treeNode=" + this.f2828y + "}";
    }

    public synchronized void u(t6.g gVar) {
        this.D = (t6.g) ((t6.g) gVar.clone()).b();
    }

    public final synchronized boolean v(u6.d dVar) {
        t6.c cVarG = dVar.g();
        if (cVarG == null) {
            return true;
        }
        if (!this.f2827x.a(cVarG)) {
            return false;
        }
        this.f2829z.f2864u.remove(dVar);
        dVar.j(null);
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
