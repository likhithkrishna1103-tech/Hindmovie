package o8;

import android.accounts.Account;
import android.content.Context;
import android.os.Build;
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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final l8.d[] f9620x = new l8.d[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i8.a f9622b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Context f9623c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f0 f9624d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final l8.f f9625e;
    public final x f;
    public q i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public d f9628j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public IInterface f9629k;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public z f9631m;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f9633o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final c f9634p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final int f9635q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final String f9636r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public volatile String f9637s;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile String f9621a = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f9626g = new Object();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Object f9627h = new Object();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f9630l = new ArrayList();

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f9632n = 1;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public l8.b f9638t = null;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f9639u = false;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public volatile c0 f9640v = null;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final AtomicInteger f9641w = new AtomicInteger(0);

    public e(Context context, Looper looper, f0 f0Var, l8.f fVar, int i, b bVar, c cVar, String str) {
        u.h(context, "Context must not be null");
        this.f9623c = context;
        u.h(looper, "Looper must not be null");
        u.h(f0Var, "Supervisor must not be null");
        this.f9624d = f0Var;
        u.h(fVar, "API availability must not be null");
        this.f9625e = fVar;
        this.f = new x(this, looper);
        this.f9635q = i;
        this.f9633o = bVar;
        this.f9634p = cVar;
        this.f9636r = str;
    }

    public final void A(int i, IInterface iInterface) {
        i8.a aVar;
        u.b((i == 4) == (iInterface != null));
        synchronized (this.f9626g) {
            try {
                this.f9632n = i;
                this.f9629k = iInterface;
                Bundle bundle = null;
                if (i == 1) {
                    z zVar = this.f9631m;
                    if (zVar != null) {
                        f0 f0Var = this.f9624d;
                        String str = this.f9622b.f6351b;
                        u.g(str);
                        this.f9622b.getClass();
                        if (this.f9636r == null) {
                            this.f9623c.getClass();
                        }
                        f0Var.d(str, zVar, this.f9622b.f6352c);
                        this.f9631m = null;
                    }
                } else if (i == 2 || i == 3) {
                    z zVar2 = this.f9631m;
                    if (zVar2 != null && (aVar = this.f9622b) != null) {
                        String str2 = aVar.f6351b;
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 70 + "com.google.android.gms".length());
                        sb.append("Calling connect() while still connected, missing disconnect() for ");
                        sb.append(str2);
                        sb.append(" on com.google.android.gms");
                        Log.e("GmsClient", sb.toString());
                        f0 f0Var2 = this.f9624d;
                        String str3 = this.f9622b.f6351b;
                        u.g(str3);
                        this.f9622b.getClass();
                        if (this.f9636r == null) {
                            this.f9623c.getClass();
                        }
                        f0Var2.d(str3, zVar2, this.f9622b.f6352c);
                        this.f9641w.incrementAndGet();
                    }
                    z zVar3 = new z(this, this.f9641w.get());
                    this.f9631m = zVar3;
                    String strW = w();
                    boolean zX = x();
                    this.f9622b = new i8.a(strW, zX, 1);
                    if (zX && d() < 17895000) {
                        throw new IllegalStateException("Internal Error, the minimum apk version of this BaseGmsClient is too low to support dynamic lookup. Start service action: ".concat(String.valueOf(this.f9622b.f6351b)));
                    }
                    f0 f0Var3 = this.f9624d;
                    String str4 = this.f9622b.f6351b;
                    u.g(str4);
                    this.f9622b.getClass();
                    String name = this.f9636r;
                    if (name == null) {
                        name = this.f9623c.getClass().getName();
                    }
                    l8.b bVarC = f0Var3.c(new d0(str4, this.f9622b.f6352c), zVar3, name, null);
                    if (!(bVarC.f7878w == 0)) {
                        String str5 = this.f9622b.f6351b;
                        StringBuilder sb2 = new StringBuilder(String.valueOf(str5).length() + 34 + "com.google.android.gms".length());
                        sb2.append("unable to connect to service: ");
                        sb2.append(str5);
                        sb2.append(" on com.google.android.gms");
                        Log.w("GmsClient", sb2.toString());
                        int i10 = bVarC.f7878w;
                        if (i10 == -1) {
                            i10 = 16;
                        }
                        if (bVarC.f7879x != null) {
                            bundle = new Bundle();
                            bundle.putParcelable("pendingIntent", bVarC.f7879x);
                        }
                        int i11 = this.f9641w.get();
                        b0 b0Var = new b0(this, i10, bundle);
                        x xVar = this.f;
                        xVar.sendMessage(xVar.obtainMessage(7, i11, -1, b0Var));
                    }
                } else if (i == 4) {
                    u.g(iInterface);
                    System.currentTimeMillis();
                }
            } finally {
            }
        }
    }

    public final boolean a() {
        boolean z10;
        synchronized (this.f9626g) {
            z10 = this.f9632n == 4;
        }
        return z10;
    }

    public final void c(String str) {
        this.f9621a = str;
        i();
    }

    public abstract int d();

    public final boolean e() {
        boolean z10;
        synchronized (this.f9626g) {
            int i = this.f9632n;
            z10 = true;
            if (i != 2 && i != 3) {
                z10 = false;
            }
        }
        return z10;
    }

    public final l8.d[] f() {
        c0 c0Var = this.f9640v;
        if (c0Var == null) {
            return null;
        }
        return c0Var.f9614w;
    }

    public final void g() {
        if (!a() || this.f9622b == null) {
            throw new RuntimeException("Failed to connect when checking package");
        }
    }

    public final String h() {
        return this.f9621a;
    }

    public final void i() {
        this.f9641w.incrementAndGet();
        ArrayList arrayList = this.f9630l;
        synchronized (arrayList) {
            try {
                int size = arrayList.size();
                for (int i = 0; i < size; i++) {
                    ((p) arrayList.get(i)).d();
                }
                arrayList.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
        synchronized (this.f9627h) {
            this.i = null;
        }
        A(1, null);
    }

    public boolean j() {
        return false;
    }

    public final void l(d dVar) {
        this.f9628j = dVar;
        A(2, null);
    }

    public final void m(kf.i iVar) {
        ((n8.i) iVar.f7483w).f8881n.H.post(new androidx.fragment.app.m(19, iVar));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void n(h hVar, Set set) {
        Bundle bundleS = s();
        String str = Build.VERSION.SDK_INT < 31 ? this.f9637s : this.f9637s;
        int i = this.f9635q;
        int i10 = l8.f.f7889a;
        Scope[] scopeArr = g.J;
        Bundle bundle = new Bundle();
        l8.d[] dVarArr = g.K;
        g gVar = new g(6, i, i10, null, null, scopeArr, bundle, null, dVarArr, dVarArr, true, 0, false, str);
        gVar.f9662y = this.f9623c.getPackageName();
        gVar.B = bundleS;
        if (set != null) {
            gVar.A = (Scope[]) set.toArray(new Scope[0]);
        }
        if (j()) {
            Account accountQ = q();
            if (accountQ == null) {
                accountQ = new Account("<<default account>>", "com.google");
            }
            gVar.C = accountQ;
            if (hVar != 0) {
                gVar.f9663z = ((a9.a) hVar).f359e;
            }
        }
        gVar.D = f9620x;
        gVar.E = r();
        try {
            synchronized (this.f9627h) {
                try {
                    q qVar = this.i;
                    if (qVar != null) {
                        qVar.b(new y(this, this.f9641w.get()), gVar);
                    } else {
                        Log.w("GmsClient", "mServiceBroker is null, client disconnected");
                    }
                } finally {
                }
            }
        } catch (DeadObjectException e9) {
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e9);
            int i11 = this.f9641w.get();
            x xVar = this.f;
            xVar.sendMessage(xVar.obtainMessage(6, i11, 3));
        } catch (RemoteException e10) {
            e = e10;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i12 = this.f9641w.get();
            a0 a0Var = new a0(this, 8, null, null);
            x xVar2 = this.f;
            xVar2.sendMessage(xVar2.obtainMessage(1, i12, -1, a0Var));
        } catch (SecurityException e11) {
            throw e11;
        } catch (RuntimeException e12) {
            e = e12;
            Log.w("GmsClient", "IGmsServiceBroker.getService failed", e);
            int i122 = this.f9641w.get();
            a0 a0Var2 = new a0(this, 8, null, null);
            x xVar22 = this.f;
            xVar22.sendMessage(xVar22.obtainMessage(1, i122, -1, a0Var2));
        }
    }

    public final void o() {
        int iB = this.f9625e.b(this.f9623c, d());
        if (iB == 0) {
            l(new l4.a(this));
            return;
        }
        A(1, null);
        this.f9628j = new l4.a(this);
        int i = this.f9641w.get();
        x xVar = this.f;
        xVar.sendMessage(xVar.obtainMessage(3, i, iB, null));
    }

    public abstract IInterface p(IBinder iBinder);

    public Account q() {
        return null;
    }

    public l8.d[] r() {
        return f9620x;
    }

    public Bundle s() {
        return new Bundle();
    }

    public Set t() {
        return Collections.EMPTY_SET;
    }

    public final IInterface u() {
        IInterface iInterface;
        synchronized (this.f9626g) {
            try {
                if (this.f9632n == 5) {
                    throw new DeadObjectException();
                }
                if (!a()) {
                    throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
                }
                iInterface = this.f9629k;
                u.h(iInterface, "Client is connected but service is null");
            } catch (Throwable th) {
                throw th;
            }
        }
        return iInterface;
    }

    public abstract String v();

    public abstract String w();

    public boolean x() {
        return d() >= 211700000;
    }

    public final /* synthetic */ boolean y(int i, int i10, IInterface iInterface) {
        synchronized (this.f9626g) {
            try {
                if (this.f9632n != i) {
                    return false;
                }
                A(i10, iInterface);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final /* synthetic */ void z() {
        int i;
        int i10;
        synchronized (this.f9626g) {
            i = this.f9632n;
        }
        if (i == 3) {
            this.f9639u = true;
            i10 = 5;
        } else {
            i10 = 4;
        }
        x xVar = this.f;
        xVar.sendMessage(xVar.obtainMessage(i10, this.f9641w.get(), 16));
    }
}
