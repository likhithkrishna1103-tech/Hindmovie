package s7;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.measurement.r0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import n.a1;
import t7.v;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements r7.c, r7.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final r7.a f11891e;
    public final a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final p2.c f11892g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f11894j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f11895k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f11898n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f11890d = new LinkedList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet f11893h = new HashSet();
    public final HashMap i = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f11896l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public q7.b f11897m = null;

    public j(d dVar, v7.c cVar) {
        this.f11898n = dVar;
        Looper looper = dVar.G.getLooper();
        Context context = cVar.f13324a;
        kc.b bVar = new kc.b(16);
        Set set = Collections.EMPTY_SET;
        if (((s.f) bVar.f7620v) == null) {
            bVar.f7620v = new s.f(0);
        }
        ((s.f) bVar.f7620v).addAll(set);
        bVar.f7622x = context.getClass().getName();
        bVar.f7621w = context.getPackageName();
        kc.b bVar2 = new kc.b((s.f) bVar.f7620v, (String) bVar.f7621w, (String) bVar.f7622x);
        v7.b bVar3 = (v7.b) cVar.f13326c.f10310v;
        v.h(bVar3);
        t7.m mVar = cVar.f13327d;
        Context context2 = cVar.f13324a;
        bVar3.getClass();
        v7.d dVar2 = new v7.d(context2, looper, bVar2, mVar, this, this);
        String str = cVar.f13325b;
        if (str != null) {
            dVar2.f12282s = str;
        }
        this.f11891e = dVar2;
        this.f = cVar.f13328e;
        this.f11892g = new p2.c(12);
        this.f11894j = cVar.f;
    }

    public final void a(q7.b bVar) {
        HashSet hashSet = this.f11893h;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (v.k(bVar, q7.b.f11026y)) {
                this.f11891e.j();
            }
            throw null;
        }
    }

    public final void b(Status status) {
        v.b(this.f11898n.G);
        d(status, null, false);
    }

    @Override // r7.d
    public final void c(q7.b bVar) {
        o(bVar, null);
    }

    public final void d(Status status, Exception exc, boolean z2) {
        v.b(this.f11898n.G);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f11890d.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (!z2 || nVar.f11903a == 2) {
                if (status != null) {
                    nVar.c(status);
                } else {
                    nVar.d(exc);
                }
                it.remove();
            }
        }
    }

    @Override // r7.c
    public final void e(int i) {
        Looper looperMyLooper = Looper.myLooper();
        r0 r0Var = this.f11898n.G;
        if (looperMyLooper == r0Var.getLooper()) {
            i(i);
        } else {
            r0Var.post(new androidx.emoji2.text.k(i, 4, this));
        }
    }

    @Override // r7.c
    public final void f() {
        Looper looperMyLooper = Looper.myLooper();
        r0 r0Var = this.f11898n.G;
        if (looperMyLooper == r0Var.getLooper()) {
            h();
        } else {
            r0Var.post(new androidx.fragment.app.e(22, this));
        }
    }

    public final void g() {
        LinkedList linkedList = this.f11890d;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n nVar = (n) arrayList.get(i);
            if (!this.f11891e.b()) {
                return;
            }
            if (k(nVar)) {
                linkedList.remove(nVar);
            }
        }
    }

    public final void h() {
        d dVar = this.f11898n;
        v.b(dVar.G);
        this.f11897m = null;
        a(q7.b.f11026y);
        r0 r0Var = dVar.G;
        if (this.f11895k) {
            a aVar = this.f;
            r0Var.removeMessages(11, aVar);
            r0Var.removeMessages(9, aVar);
            this.f11895k = false;
        }
        Iterator it = this.i.values().iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
        g();
        j();
    }

    public final void i(int i) {
        d dVar = this.f11898n;
        r0 r0Var = dVar.G;
        v.b(dVar.G);
        this.f11897m = null;
        this.f11895k = true;
        String strK = this.f11891e.k();
        p2.c cVar = this.f11892g;
        cVar.getClass();
        StringBuilder sb2 = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb2.append(" due to service disconnection.");
        } else if (i == 3) {
            sb2.append(" due to dead object exception.");
        }
        if (strK != null) {
            sb2.append(" Last reason for disconnect: ");
            sb2.append(strK);
        }
        cVar.x(true, new Status(20, sb2.toString(), null, null));
        a aVar = this.f;
        r0Var.sendMessageDelayed(Message.obtain(r0Var, 9, aVar), 5000L);
        r0Var.sendMessageDelayed(Message.obtain(r0Var, 11, aVar), 120000L);
        ((SparseIntArray) dVar.A.f10130v).clear();
        Iterator it = this.i.values().iterator();
        if (it.hasNext()) {
            throw l4.a.k(it);
        }
    }

    public final void j() {
        d dVar = this.f11898n;
        r0 r0Var = dVar.G;
        a aVar = this.f;
        r0Var.removeMessages(12, aVar);
        r0Var.sendMessageDelayed(r0Var.obtainMessage(12, aVar), dVar.f11883u);
    }

    public final boolean k(n nVar) {
        q7.d dVar;
        if (nVar == null) {
            p2.c cVar = this.f11892g;
            r7.a aVar = this.f11891e;
            nVar.f(cVar, aVar.m());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused) {
                e(1);
                aVar.d("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        q7.d[] dVarArrB = nVar.b(this);
        if (dVarArrB == null || dVarArrB.length == 0) {
            dVar = null;
        } else {
            q7.d[] dVarArrI = this.f11891e.i();
            if (dVarArrI == null) {
                dVarArrI = new q7.d[0];
            }
            s.e eVar = new s.e(dVarArrI.length);
            for (q7.d dVar2 : dVarArrI) {
                eVar.put(dVar2.f11034u, Long.valueOf(dVar2.b()));
            }
            int length = dVarArrB.length;
            for (int i = 0; i < length; i++) {
                dVar = dVarArrB[i];
                Long l10 = (Long) eVar.get(dVar.f11034u);
                if (l10 == null || l10.longValue() < dVar.b()) {
                    break;
                }
            }
            dVar = null;
        }
        if (dVar == null) {
            p2.c cVar2 = this.f11892g;
            r7.a aVar2 = this.f11891e;
            nVar.f(cVar2, aVar2.m());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                e(1);
                aVar2.d("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.f11891e.getClass().getName() + " could not execute call because it requires feature (" + dVar.f11034u + ", " + dVar.b() + ").");
        if (!this.f11898n.H || !nVar.a(this)) {
            nVar.d(new r7.g(dVar));
            return true;
        }
        k kVar = new k(this.f, dVar);
        int iIndexOf = this.f11896l.indexOf(kVar);
        if (iIndexOf >= 0) {
            k kVar2 = (k) this.f11896l.get(iIndexOf);
            this.f11898n.G.removeMessages(15, kVar2);
            r0 r0Var = this.f11898n.G;
            r0Var.sendMessageDelayed(Message.obtain(r0Var, 15, kVar2), 5000L);
        } else {
            this.f11896l.add(kVar);
            r0 r0Var2 = this.f11898n.G;
            r0Var2.sendMessageDelayed(Message.obtain(r0Var2, 15, kVar), 5000L);
            r0 r0Var3 = this.f11898n.G;
            r0Var3.sendMessageDelayed(Message.obtain(r0Var3, 16, kVar), 120000L);
            q7.b bVar = new q7.b(2, null);
            if (!l(bVar)) {
                this.f11898n.a(bVar, this.f11894j);
            }
        }
        return false;
    }

    public final boolean l(q7.b bVar) {
        synchronized (d.K) {
        }
        return false;
    }

    public final void m() {
        d dVar = this.f11898n;
        v.b(dVar.G);
        r7.a aVar = this.f11891e;
        if (aVar.b() || aVar.h()) {
            return;
        }
        try {
            p2.c cVar = dVar.A;
            Context context = dVar.f11887y;
            SparseIntArray sparseIntArray = (SparseIntArray) cVar.f10130v;
            v.h(context);
            int iF = aVar.f();
            int iB = ((SparseIntArray) cVar.f10130v).get(iF, -1);
            if (iB == -1) {
                iB = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > iF && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iB == -1) {
                    iB = ((q7.e) cVar.f10131w).b(context, iF);
                }
                sparseIntArray.put(iF, iB);
            }
            if (iB == 0) {
                o2.p pVar = new o2.p(dVar, aVar, this.f);
                if (aVar.m()) {
                    v.h(null);
                    throw null;
                }
                try {
                    aVar.e(pVar);
                    return;
                } catch (SecurityException e10) {
                    o(new q7.b(10), e10);
                    return;
                }
            }
            q7.b bVar = new q7.b(iB, null);
            Log.w("GoogleApiManager", "The service for " + aVar.getClass().getName() + " is not available: " + bVar.toString());
            o(bVar, null);
        } catch (IllegalStateException e11) {
            o(new q7.b(10), e11);
        }
    }

    public final void n(n nVar) {
        v.b(this.f11898n.G);
        boolean zB = this.f11891e.b();
        LinkedList linkedList = this.f11890d;
        if (zB) {
            if (k(nVar)) {
                j();
                return;
            } else {
                linkedList.add(nVar);
                return;
            }
        }
        linkedList.add(nVar);
        q7.b bVar = this.f11897m;
        if (bVar == null || bVar.f11028v == 0 || bVar.f11029w == null) {
            m();
        } else {
            o(bVar, null);
        }
    }

    public final void o(q7.b bVar, RuntimeException runtimeException) {
        v.b(this.f11898n.G);
        v.b(this.f11898n.G);
        this.f11897m = null;
        ((SparseIntArray) this.f11898n.A.f10130v).clear();
        a(bVar);
        if ((this.f11891e instanceof v7.d) && bVar.f11028v != 24) {
            d dVar = this.f11898n;
            dVar.f11884v = true;
            r0 r0Var = dVar.G;
            r0Var.sendMessageDelayed(r0Var.obtainMessage(19), 300000L);
        }
        if (bVar.f11028v == 4) {
            b(d.J);
            return;
        }
        if (this.f11890d.isEmpty()) {
            this.f11897m = bVar;
            return;
        }
        if (runtimeException != null) {
            v.b(this.f11898n.G);
            d(null, runtimeException, false);
            return;
        }
        if (!this.f11898n.H) {
            b(d.b(this.f, bVar));
            return;
        }
        d(d.b(this.f, bVar), null, true);
        if (this.f11890d.isEmpty() || l(bVar) || this.f11898n.a(bVar, this.f11894j)) {
            return;
        }
        if (bVar.f11028v == 18) {
            this.f11895k = true;
        }
        if (!this.f11895k) {
            b(d.b(this.f, bVar));
            return;
        }
        d dVar2 = this.f11898n;
        a aVar = this.f;
        r0 r0Var2 = dVar2.G;
        r0Var2.sendMessageDelayed(Message.obtain(r0Var2, 9, aVar), 5000L);
    }

    public final void p() {
        v.b(this.f11898n.G);
        Status status = d.I;
        b(status);
        this.f11892g.x(false, status);
        for (g gVar : (g[]) this.i.keySet().toArray(new g[0])) {
            n(new s(new o8.h()));
        }
        a(new q7.b(4));
        r7.a aVar = this.f11891e;
        if (aVar.b()) {
            aVar.g(new a1(this));
        }
    }
}
