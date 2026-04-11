package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.util.SparseIntArray;
import android.view.MenuItem;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f1282a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f1283b;

    public h(Context context) {
        this.f1282a = context;
    }

    public void c() {
        c2.e eVar = (c2.e) this.f1282a;
        if (eVar != null) {
            try {
                ((h.b0) this.f1283b).E.unregisterReceiver(eVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f1282a = null;
        }
    }

    public void d() {
        z0 z0Var = (z0) this.f1282a;
        m0.c cVar = (m0.c) this.f1283b;
        HashSet hashSet = z0Var.f1431e;
        if (hashSet.remove(cVar) && hashSet.isEmpty()) {
            z0Var.b();
        }
    }

    public abstract IntentFilter e();

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof k0.a)) {
            return menuItem;
        }
        k0.a aVar = (k0.a) menuItem;
        if (((s.i) this.f1283b) == null) {
            this.f1283b = new s.i(0);
        }
        MenuItem menuItem2 = (MenuItem) ((s.i) this.f1283b).get(aVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        m.r rVar = new m.r((Context) this.f1282a, aVar);
        ((s.i) this.f1283b).put(aVar, rVar);
        return rVar;
    }

    public int h(int i, int i10) {
        int iJ = j(i);
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < i; i13++) {
            int iJ2 = j(i13);
            i11 += iJ2;
            if (i11 == i10) {
                i12++;
                i11 = 0;
            } else if (i11 > i10) {
                i12++;
                i11 = iJ2;
            }
        }
        return i11 + iJ > i10 ? i12 + 1 : i12;
    }

    public int i(int i, int i10) {
        int iJ = j(i);
        if (iJ == i10) {
            return 0;
        }
        int i11 = 0;
        for (int i12 = 0; i12 < i; i12++) {
            int iJ2 = j(i12);
            i11 += iJ2;
            if (i11 == i10) {
                i11 = 0;
            } else if (i11 > i10) {
                i11 = iJ2;
            }
        }
        if (iJ + i11 <= i10) {
            return i11;
        }
        return 0;
    }

    public abstract int j(int i);

    public void k() {
        ((SparseIntArray) this.f1282a).clear();
    }

    public abstract void l();

    public void m() {
        c();
        IntentFilter intentFilterE = e();
        if (intentFilterE.countActions() == 0) {
            return;
        }
        if (((c2.e) this.f1282a) == null) {
            this.f1282a = new c2.e(4, this);
        }
        ((h.b0) this.f1283b).E.registerReceiver((c2.e) this.f1282a, intentFilterE);
    }

    public h(z0 z0Var, m0.c cVar) {
        this.f1282a = z0Var;
        this.f1283b = cVar;
    }

    public h() {
        this.f1282a = new SparseIntArray();
        this.f1283b = new SparseIntArray();
    }

    public h(h.b0 b0Var) {
        this.f1283b = b0Var;
    }
}
