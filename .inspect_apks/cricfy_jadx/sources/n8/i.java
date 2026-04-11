package n8;

import android.content.Context;
import android.os.DeadObjectException;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseIntArray;
import com.google.android.gms.common.api.Status;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import nb.w;
import o8.u;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class i implements m8.c, m8.d {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final m8.a f8874e;
    public final a f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i2.k f8875g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final int f8877j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f8878k;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final /* synthetic */ d f8881n;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final LinkedList f8873d = new LinkedList();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final HashSet f8876h = new HashSet();
    public final HashMap i = new HashMap();

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ArrayList f8879l = new ArrayList();

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public l8.b f8880m = null;

    public i(d dVar, q8.c cVar) {
        this.f8881n = dVar;
        Looper looper = dVar.H.getLooper();
        Context context = cVar.f10448a;
        l7.a aVar = new l7.a(6, false);
        Set set = Collections.EMPTY_SET;
        if (((v.f) aVar.f7866w) == null) {
            aVar.f7866w = new v.f(0);
        }
        ((v.f) aVar.f7866w).addAll(set);
        aVar.f7868y = context.getClass().getName();
        aVar.f7867x = context.getPackageName();
        l7.a aVar2 = new l7.a((v.f) aVar.f7866w, (String) aVar.f7867x, (String) aVar.f7868y);
        q8.b bVar = (q8.b) cVar.f10450c.f6085v;
        u.g(bVar);
        o8.m mVar = cVar.f10451d;
        Context context2 = cVar.f10448a;
        bVar.getClass();
        q8.d dVar2 = new q8.d(context2, looper, aVar2, mVar, this, this);
        String str = cVar.f10449b;
        if (str != null) {
            dVar2.f9637s = str;
        }
        this.f8874e = dVar2;
        this.f = cVar.f10452e;
        this.f8875g = new i2.k(26);
        this.f8877j = cVar.f;
    }

    public final void a(l8.b bVar) {
        HashSet hashSet = this.f8876h;
        Iterator it = hashSet.iterator();
        if (!it.hasNext()) {
            hashSet.clear();
        } else {
            if (it.next() != null) {
                throw new ClassCastException();
            }
            if (u.j(bVar, l8.b.f7876z)) {
                this.f8874e.g();
            }
            throw null;
        }
    }

    @Override // m8.d
    public final void b(l8.b bVar) {
        o(bVar, null);
    }

    public final void c(Status status) {
        u.c(this.f8881n.H);
        d(status, null, false);
    }

    public final void d(Status status, Exception exc, boolean z10) {
        u.c(this.f8881n.H);
        if ((status == null) == (exc == null)) {
            throw new IllegalArgumentException("Status XOR exception should be null");
        }
        Iterator it = this.f8873d.iterator();
        while (it.hasNext()) {
            n nVar = (n) it.next();
            if (!z10 || nVar.f8892a == 2) {
                if (status != null) {
                    nVar.c(status);
                } else {
                    nVar.d(exc);
                }
                it.remove();
            }
        }
    }

    @Override // m8.c
    public final void e(int i) {
        Looper looperMyLooper = Looper.myLooper();
        a9.k kVar = this.f8881n.H;
        if (looperMyLooper == kVar.getLooper()) {
            i(i);
        } else {
            kVar.post(new androidx.emoji2.text.k(i, 2, this));
        }
    }

    @Override // m8.c
    public final void f() {
        Looper looperMyLooper = Looper.myLooper();
        a9.k kVar = this.f8881n.H;
        if (looperMyLooper == kVar.getLooper()) {
            h();
        } else {
            kVar.post(new androidx.fragment.app.m(18, this));
        }
    }

    public final void g() {
        LinkedList linkedList = this.f8873d;
        ArrayList arrayList = new ArrayList(linkedList);
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            n nVar = (n) arrayList.get(i);
            if (!this.f8874e.a()) {
                return;
            }
            if (k(nVar)) {
                linkedList.remove(nVar);
            }
        }
    }

    public final void h() {
        d dVar = this.f8881n;
        u.c(dVar.H);
        this.f8880m = null;
        a(l8.b.f7876z);
        a9.k kVar = dVar.H;
        if (this.f8878k) {
            a aVar = this.f;
            kVar.removeMessages(11, aVar);
            kVar.removeMessages(9, aVar);
            this.f8878k = false;
        }
        Iterator it = this.i.values().iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
        g();
        j();
    }

    public final void i(int i) {
        d dVar = this.f8881n;
        a9.k kVar = dVar.H;
        u.c(dVar.H);
        this.f8880m = null;
        this.f8878k = true;
        String strH = this.f8874e.h();
        i2.k kVar2 = this.f8875g;
        kVar2.getClass();
        StringBuilder sb = new StringBuilder("The connection to Google Play services was lost");
        if (i == 1) {
            sb.append(" due to service disconnection.");
        } else if (i == 3) {
            sb.append(" due to dead object exception.");
        }
        if (strH != null) {
            sb.append(" Last reason for disconnect: ");
            sb.append(strH);
        }
        kVar2.w(true, new Status(20, sb.toString(), null, null));
        a aVar = this.f;
        kVar.sendMessageDelayed(Message.obtain(kVar, 9, aVar), 5000L);
        kVar.sendMessageDelayed(Message.obtain(kVar, 11, aVar), 120000L);
        ((SparseIntArray) dVar.B.f9016w).clear();
        Iterator it = this.i.values().iterator();
        if (it.hasNext()) {
            throw q4.a.l(it);
        }
    }

    public final void j() {
        d dVar = this.f8881n;
        a9.k kVar = dVar.H;
        a aVar = this.f;
        kVar.removeMessages(12, aVar);
        kVar.sendMessageDelayed(kVar.obtainMessage(12, aVar), dVar.f8867v);
    }

    public final boolean k(n nVar) {
        l8.d dVar;
        if (nVar == null) {
            i2.k kVar = this.f8875g;
            m8.a aVar = this.f8874e;
            nVar.f(kVar, aVar.j());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused) {
                e(1);
                aVar.c("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        l8.d[] dVarArrB = nVar.b(this);
        if (dVarArrB == null || dVarArrB.length == 0) {
            dVar = null;
        } else {
            l8.d[] dVarArrF = this.f8874e.f();
            if (dVarArrF == null) {
                dVarArrF = new l8.d[0];
            }
            v.e eVar = new v.e(dVarArrF.length);
            for (l8.d dVar2 : dVarArrF) {
                eVar.put(dVar2.f7884v, Long.valueOf(dVar2.a()));
            }
            int length = dVarArrB.length;
            for (int i = 0; i < length; i++) {
                dVar = dVarArrB[i];
                Long l10 = (Long) eVar.get(dVar.f7884v);
                if (l10 == null || l10.longValue() < dVar.a()) {
                    break;
                }
            }
            dVar = null;
        }
        if (dVar == null) {
            i2.k kVar2 = this.f8875g;
            m8.a aVar2 = this.f8874e;
            nVar.f(kVar2, aVar2.j());
            try {
                nVar.e(this);
                return true;
            } catch (DeadObjectException unused2) {
                e(1);
                aVar2.c("DeadObjectException thrown while running ApiCallRunner.");
                return true;
            }
        }
        Log.w("GoogleApiManager", this.f8874e.getClass().getName() + " could not execute call because it requires feature (" + dVar.f7884v + ", " + dVar.a() + ").");
        if (!this.f8881n.I || !nVar.a(this)) {
            nVar.d(new m8.g(dVar));
            return true;
        }
        j jVar = new j(this.f, dVar);
        int iIndexOf = this.f8879l.indexOf(jVar);
        if (iIndexOf >= 0) {
            j jVar2 = (j) this.f8879l.get(iIndexOf);
            this.f8881n.H.removeMessages(15, jVar2);
            a9.k kVar3 = this.f8881n.H;
            kVar3.sendMessageDelayed(Message.obtain(kVar3, 15, jVar2), 5000L);
        } else {
            this.f8879l.add(jVar);
            a9.k kVar4 = this.f8881n.H;
            kVar4.sendMessageDelayed(Message.obtain(kVar4, 15, jVar), 5000L);
            a9.k kVar5 = this.f8881n.H;
            kVar5.sendMessageDelayed(Message.obtain(kVar5, 16, jVar), 120000L);
            l8.b bVar = new l8.b(2, null);
            if (!l(bVar)) {
                this.f8881n.a(bVar, this.f8877j);
            }
        }
        return false;
    }

    public final boolean l(l8.b bVar) {
        synchronized (d.L) {
        }
        return false;
    }

    public final void m() {
        d dVar = this.f8881n;
        u.c(dVar.H);
        m8.a aVar = this.f8874e;
        if (aVar.a() || aVar.e()) {
            return;
        }
        try {
            w wVar = dVar.B;
            Context context = dVar.f8871z;
            SparseIntArray sparseIntArray = (SparseIntArray) wVar.f9016w;
            u.g(context);
            int iD = aVar.d();
            int iB = ((SparseIntArray) wVar.f9016w).get(iD, -1);
            if (iB == -1) {
                iB = 0;
                int i = 0;
                while (true) {
                    if (i >= sparseIntArray.size()) {
                        iB = -1;
                        break;
                    }
                    int iKeyAt = sparseIntArray.keyAt(i);
                    if (iKeyAt > iD && sparseIntArray.get(iKeyAt) == 0) {
                        break;
                    } else {
                        i++;
                    }
                }
                if (iB == -1) {
                    iB = ((l8.e) wVar.f9017x).b(context, iD);
                }
                sparseIntArray.put(iD, iB);
            }
            if (iB == 0) {
                k kVar = new k(dVar, aVar, this.f);
                if (aVar.j()) {
                    u.g(null);
                    throw null;
                }
                try {
                    aVar.l(kVar);
                    return;
                } catch (SecurityException e9) {
                    o(new l8.b(10), e9);
                    return;
                }
            }
            l8.b bVar = new l8.b(iB, null);
            Log.w("GoogleApiManager", "The service for " + aVar.getClass().getName() + " is not available: " + bVar.toString());
            o(bVar, null);
        } catch (IllegalStateException e10) {
            o(new l8.b(10), e10);
        }
    }

    public final void n(n nVar) {
        u.c(this.f8881n.H);
        boolean zA = this.f8874e.a();
        LinkedList linkedList = this.f8873d;
        if (zA) {
            if (k(nVar)) {
                j();
                return;
            } else {
                linkedList.add(nVar);
                return;
            }
        }
        linkedList.add(nVar);
        l8.b bVar = this.f8880m;
        if (bVar == null || bVar.f7878w == 0 || bVar.f7879x == null) {
            m();
        } else {
            o(bVar, null);
        }
    }

    public final void o(l8.b bVar, RuntimeException runtimeException) {
        u.c(this.f8881n.H);
        u.c(this.f8881n.H);
        this.f8880m = null;
        ((SparseIntArray) this.f8881n.B.f9016w).clear();
        a(bVar);
        if ((this.f8874e instanceof q8.d) && bVar.f7878w != 24) {
            d dVar = this.f8881n;
            dVar.f8868w = true;
            a9.k kVar = dVar.H;
            kVar.sendMessageDelayed(kVar.obtainMessage(19), 300000L);
        }
        if (bVar.f7878w == 4) {
            c(d.K);
            return;
        }
        if (this.f8873d.isEmpty()) {
            this.f8880m = bVar;
            return;
        }
        if (runtimeException != null) {
            u.c(this.f8881n.H);
            d(null, runtimeException, false);
            return;
        }
        if (!this.f8881n.I) {
            c(d.b(this.f, bVar));
            return;
        }
        d(d.b(this.f, bVar), null, true);
        if (this.f8873d.isEmpty() || l(bVar) || this.f8881n.a(bVar, this.f8877j)) {
            return;
        }
        if (bVar.f7878w == 18) {
            this.f8878k = true;
        }
        if (!this.f8878k) {
            c(d.b(this.f, bVar));
            return;
        }
        d dVar2 = this.f8881n;
        a aVar = this.f;
        a9.k kVar2 = dVar2.H;
        kVar2.sendMessageDelayed(Message.obtain(kVar2, 9, aVar), 5000L);
    }

    public final void p() {
        u.c(this.f8881n.H);
        Status status = d.J;
        c(status);
        this.f8875g.w(false, status);
        for (f fVar : (f[]) this.i.keySet().toArray(new f[0])) {
            n(new s(new j9.i()));
        }
        a(new l8.b(4));
        m8.a aVar = this.f8874e;
        if (aVar.a()) {
            aVar.m(new kf.i(7, this));
        }
    }
}
