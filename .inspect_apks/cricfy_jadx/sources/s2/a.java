package s2;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f11147a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final HashSet f11148b = new HashSet(1);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f3.a f11149c = new f3.a(new CopyOnWriteArrayList(), 0, (c0) null);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final l2.k f11150d = new l2.k(new CopyOnWriteArrayList(), 0, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Looper f11151e;
    public v1.f1 f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public h2.l f11152g;

    public boolean a(v1.g0 g0Var) {
        return false;
    }

    public final f3.a b(c0 c0Var) {
        return new f3.a((CopyOnWriteArrayList) this.f11149c.f3937y, 0, c0Var);
    }

    public abstract a0 c(c0 c0Var, w2.e eVar, long j4);

    public final void d(d0 d0Var) {
        HashSet hashSet = this.f11148b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(d0Var);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        e();
    }

    public final void f(d0 d0Var) {
        this.f11151e.getClass();
        HashSet hashSet = this.f11148b;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(d0Var);
        if (zIsEmpty) {
            g();
        }
    }

    public v1.f1 h() {
        return null;
    }

    public abstract v1.g0 i();

    public boolean j() {
        return true;
    }

    public abstract void k();

    public final void l(d0 d0Var, b2.h0 h0Var, h2.l lVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f11151e;
        y1.d.b(looper == null || looper == looperMyLooper);
        this.f11152g = lVar;
        v1.f1 f1Var = this.f;
        this.f11147a.add(d0Var);
        if (this.f11151e == null) {
            this.f11151e = looperMyLooper;
            this.f11148b.add(d0Var);
            m(h0Var);
        } else if (f1Var != null) {
            f(d0Var);
            d0Var.a(this, f1Var);
        }
    }

    public abstract void m(b2.h0 h0Var);

    public final void n(v1.f1 f1Var) {
        this.f = f1Var;
        ArrayList arrayList = this.f11147a;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((d0) obj).a(this, f1Var);
        }
    }

    public abstract void o(a0 a0Var);

    public final void p(d0 d0Var) {
        ArrayList arrayList = this.f11147a;
        arrayList.remove(d0Var);
        if (!arrayList.isEmpty()) {
            d(d0Var);
            return;
        }
        this.f11151e = null;
        this.f = null;
        this.f11152g = null;
        this.f11148b.clear();
        q();
    }

    public abstract void q();

    public final void r(l2.l lVar) {
        CopyOnWriteArrayList<l2.j> copyOnWriteArrayList = this.f11150d.f7673c;
        for (l2.j jVar : copyOnWriteArrayList) {
            if (jVar.f7670b == lVar) {
                copyOnWriteArrayList.remove(jVar);
            }
        }
    }

    public final void s(i0 i0Var) {
        CopyOnWriteArrayList<h0> copyOnWriteArrayList = (CopyOnWriteArrayList) this.f11149c.f3937y;
        for (h0 h0Var : copyOnWriteArrayList) {
            if (h0Var.f11221b == i0Var) {
                copyOnWriteArrayList.remove(h0Var);
            }
        }
    }

    public void e() {
    }

    public void g() {
    }

    public void t(v1.g0 g0Var) {
    }
}
