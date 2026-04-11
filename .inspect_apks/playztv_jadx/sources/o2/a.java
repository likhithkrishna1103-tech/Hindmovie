package o2;

import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class a {
    public b2.o A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final ArrayList f9051u = new ArrayList(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final HashSet f9052v = new HashSet(1);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final aa.l0 f9053w = new aa.l0(new CopyOnWriteArrayList(), 0, (d0) null);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final f2.k f9054x = new f2.k(new CopyOnWriteArrayList(), 0, null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public Looper f9055y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public p1.f1 f9056z;

    public boolean a(p1.g0 g0Var) {
        return false;
    }

    public final aa.l0 b(d0 d0Var) {
        return new aa.l0((CopyOnWriteArrayList) this.f9053w.f707x, 0, d0Var);
    }

    public abstract b0 c(d0 d0Var, s2.e eVar, long j5);

    public final void e(e0 e0Var) {
        HashSet hashSet = this.f9052v;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.remove(e0Var);
        if (zIsEmpty || !hashSet.isEmpty()) {
            return;
        }
        f();
    }

    public final void g(e0 e0Var) {
        this.f9055y.getClass();
        HashSet hashSet = this.f9052v;
        boolean zIsEmpty = hashSet.isEmpty();
        hashSet.add(e0Var);
        if (zIsEmpty) {
            h();
        }
    }

    public p1.f1 i() {
        return null;
    }

    public abstract p1.g0 j();

    public boolean l() {
        return true;
    }

    public abstract void n();

    public final void o(e0 e0Var, v1.e0 e0Var2, b2.o oVar) {
        Looper looperMyLooper = Looper.myLooper();
        Looper looper = this.f9055y;
        s1.d.b(looper == null || looper == looperMyLooper);
        this.A = oVar;
        p1.f1 f1Var = this.f9056z;
        this.f9051u.add(e0Var);
        if (this.f9055y == null) {
            this.f9055y = looperMyLooper;
            this.f9052v.add(e0Var);
            p(e0Var2);
        } else if (f1Var != null) {
            g(e0Var);
            e0Var.a(this, f1Var);
        }
    }

    public abstract void p(v1.e0 e0Var);

    public final void q(p1.f1 f1Var) {
        this.f9056z = f1Var;
        ArrayList arrayList = this.f9051u;
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            ((e0) obj).a(this, f1Var);
        }
    }

    public abstract void r(b0 b0Var);

    public final void s(e0 e0Var) {
        ArrayList arrayList = this.f9051u;
        arrayList.remove(e0Var);
        if (!arrayList.isEmpty()) {
            e(e0Var);
            return;
        }
        this.f9055y = null;
        this.f9056z = null;
        this.A = null;
        this.f9052v.clear();
        t();
    }

    public abstract void t();

    public final void v(f2.l lVar) {
        CopyOnWriteArrayList<f2.j> copyOnWriteArrayList = this.f9054x.f4741c;
        for (f2.j jVar : copyOnWriteArrayList) {
            if (jVar.f4738b == lVar) {
                copyOnWriteArrayList.remove(jVar);
            }
        }
    }

    public final void w(k0 k0Var) {
        CopyOnWriteArrayList<j0> copyOnWriteArrayList = (CopyOnWriteArrayList) this.f9053w.f707x;
        for (j0 j0Var : copyOnWriteArrayList) {
            if (j0Var.f9147b == k0Var) {
                copyOnWriteArrayList.remove(j0Var);
            }
        }
    }

    public void f() {
    }

    public void h() {
    }

    public void x(p1.g0 g0Var) {
    }
}
