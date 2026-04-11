package t7;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.Scope;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final q7.d[] f12265x = new q7.d[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public n7.a f12267b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f12268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final e0 f12269d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final q7.f f12270e;
    public final w f;
    public r i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f12273j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IInterface f12274k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public y f12276m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f12278o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f12279p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f12280q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f12281r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile String f12282s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f12266a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f12271g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f12272h = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f12275l = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f12277n = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public q7.b f12283t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f12284u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile b0 f12285v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicInteger f12286w = new AtomicInteger(0);

    public e(Context context, Looper looper, e0 e0Var, q7.f fVar, int i, b bVar, c cVar, String str) {
        v.i(context, "Context must not be null");
        this.f12268c = context;
        v.i(looper, "Looper must not be null");
        v.i(e0Var, "Supervisor must not be null");
        this.f12269d = e0Var;
        v.i(fVar, "API availability must not be null");
        this.f12270e = fVar;
        this.f = new w(this, looper);
        this.f12280q = i;
        this.f12278o = bVar;
        this.f12279p = cVar;
        this.f12281r = str;
    }

    public static /* bridge */ /* synthetic */ void y(e eVar) {
        int i;
        int i10;
        synchronized (eVar.f12271g) {
            i = eVar.f12277n;
        }
        if (i == 3) {
            eVar.f12284u = true;
            i10 = 5;
        } else {
            i10 = 4;
        }
        w wVar = eVar.f;
        wVar.sendMessage(wVar.obtainMessage(i10, eVar.f12286w.get(), 16));
    }

    public static /* bridge */ /* synthetic */ boolean z(e eVar, int i, int i10, IInterface iInterface) {
        synchronized (eVar.f12271g) {
            try {
                if (eVar.f12277n != i) {
                    return false;
                }
                eVar.A(i10, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void A(int i, IInterface iInterface) {
        n7.a aVar;
        v.a((i == 4) == (iInterface != null));
        synchronized (this.f12271g) {
            try {
                this.f12277n = i;
                this.f12274k = iInterface;
                if (i == 1) {
                    y yVar = this.f12276m;
                    if (yVar != null) {
                        e0 e0Var = this.f12269d;
                        String str = this.f12267b.f8825c;
                        v.h(str);
                        this.f12267b.getClass();
                        if (this.f12281r == null) {
                            this.f12268c.getClass();
                        }
                        e0Var.c(str, yVar, this.f12267b.f8824b);
                        this.f12276m = null;
                    }
                } else if (i == 2 || i == 3) {
                    y yVar2 = this.f12276m;
                    if (yVar2 != null && (aVar = this.f12267b) != null) {
                        Log.e("GmsClient", "Calling connect() while still connected, missing disconnect() for " + aVar.f8825c + " on com.google.android.gms");
                        e0 e0Var2 = this.f12269d;
                        String str2 = this.f12267b.f8825c;
                        v.h(str2);
                        this.f12267b.getClass();
                        if (this.f12281r == null) {
                            this.f12268c.getClass();
                        }
                        e0Var2.c(str2, yVar2, this.f12267b.f8824b);
                        this.f12286w.incrementAndGet();
                    }
                    y yVar3 = new y(this, this.f12286w.get());
                    this.f12276m = yVar3;
                    String strW = w();
                    boolean zX = x();
                    this.f12267b = new n7.a(strW, zX, 3);
                    if (zX && f() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f12267b.f8825c)));
                    }
                    e0 e0Var3 = this.f12269d;
                    String str3 = this.f12267b.f8825c;
                    v.h(str3);
                    this.f12267b.getClass();
                    String name = this.f12281r;
                    if (name == null) {
                        name = this.f12268c.getClass().getName();
                    }
                    if (!e0Var3.d(new c0(str3, this.f12267b.f8824b), yVar3, name, null)) {
                        Log.w("GmsClient", "unable to connect to service: " + this.f12267b.f8825c + " on com.google.android.gms");
                        int i10 = this.f12286w.get();
                        a0 a0Var = new a0(this, 16);
                        w wVar = this.f;
                        wVar.sendMessage(wVar.obtainMessage(7, i10, -1, a0Var));
                    }
                } else if (i == 4) {
                    v.h(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }

    public final void a(h hVar, Set set) {
        Bundle bundleS = s();
        String str = this.f12282s;
        int i = q7.f.f11039a;
        Scope[] scopeArr = g.I;
        Bundle bundle = new Bundle();
        int i10 = this.f12280q;
        q7.d[] dVarArr = g.J;
        g gVar = new g(6, i10, i, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        gVar.f12303x = this.f12268c.getPackageName();
        gVar.A = bundleS;
        if (set != null) {
            gVar.f12305z = (Scope[]) set.toArray(new Scope[0]);
        }
        if (m()) {
            Account accountQ = q();
            if (accountQ == null) {
                accountQ = new Account("<<default account>>", "com.google");
            }
            gVar.B = accountQ;
            if (hVar != null) {
                gVar.f12304y = hVar.asBinder();
            }
        }
        gVar.C = f12265x;
        gVar.D = r();
        try {
            synchronized (this.f12272h) {
                try {
                    r rVar = this.i;
                    if (rVar != null) {
                        rVar.c(new x(this, this.f12286w.get()), gVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e10) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e10);
            int i11 = this.f12286w.get();
            w wVar = this.f;
            wVar.sendMessage(wVar.obtainMessage(6, i11, 3));
        } catch (RemoteException e11) {
            e = e11;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i12 = this.f12286w.get();
            z zVar = new z(this, 8, null, null);
            w wVar2 = this.f;
            wVar2.sendMessage(wVar2.obtainMessage(1, i12, -1, zVar));
        } catch (SecurityException e12) {
            throw e12;
        } catch (RuntimeException e13) {
            e = e13;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i122 = this.f12286w.get();
            z zVar2 = new z(this, 8, null, null);
            w wVar22 = this.f;
            wVar22.sendMessage(wVar22.obtainMessage(1, i122, -1, zVar2));
        }
    }

    public final boolean b() {
        boolean z2;
        synchronized (this.f12271g) {
            z2 = this.f12277n == 4;
        }
        return z2;
    }

    public final void d(String str) {
        this.f12266a = str;
        l();
    }

    public final void e(d dVar) {
        this.f12273j = dVar;
        A(2, null);
    }

    public abstract int f();

    public final void g(a1 a1Var) {
        ((s7.j) a1Var.f8343u).f11898n.G.post(new androidx.fragment.app.e(23, a1Var));
    }

    public final boolean h() {
        boolean z2;
        synchronized (this.f12271g) {
            int i = this.f12277n;
            z2 = true;
            if (i != 2 && i != 3) {
                z2 = false;
            }
        }
        return z2;
    }

    public final q7.d[] i() {
        b0 b0Var = this.f12285v;
        if (b0Var == null) {
            return null;
        }
        return b0Var.f12252v;
    }

    public final void j() {
        if (!b() || this.f12267b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    public final String k() {
        return this.f12266a;
    }

    public final void l() {
        this.f12286w.incrementAndGet();
        synchronized (this.f12275l) {
            try {
                int size = this.f12275l.size();
                for (int i = 0; i < size; i++) {
                    ((p) this.f12275l.get(i)).c();
                }
                this.f12275l.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f12272h) {
            this.i = null;
        }
        A(1, null);
    }

    public boolean m() {
        return false;
    }

    public final void o() {
        int iB = this.f12270e.b(this.f12268c, f());
        if (iB == 0) {
            e(new u5.d(29, this));
            return;
        }
        A(1, null);
        this.f12273j = new u5.d(29, this);
        int i = this.f12286w.get();
        w wVar = this.f;
        wVar.sendMessage(wVar.obtainMessage(3, i, iB, null));
    }

    public abstract IInterface p(IBinder iBinder);

    public Account q() {
        return null;
    }

    public q7.d[] r() {
        return f12265x;
    }

    public Bundle s() {
        return new Bundle();
    }

    public Set t() {
        return Collections.EMPTY_SET;
    }

    public final IInterface u() {
        IInterface iInterface;
        synchronized (this.f12271g) {
            try {
                if (this.f12277n == 5) {
                    throw new DeadObjectException();
                }
                if (!b()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f12274k;
                v.i(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String v();

    public abstract String w();

    public boolean x() {
        return f() >= 211700000;
    }
}
