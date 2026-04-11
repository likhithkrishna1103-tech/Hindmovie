package androidx.fragment.app;

import android.content.Context;
import android.content.IntentFilter;
import android.util.SparseIntArray;
import android.view.MenuItem;
import android.view.View;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Object f994b;

    public h(Context context) {
        this.f993a = context;
    }

    public void c() {
        com.bumptech.glide.manager.r rVar = (com.bumptech.glide.manager.r) this.f993a;
        if (rVar != null) {
            try {
                ((h.a0) this.f994b).F.unregisterReceiver(rVar);
            } catch (IllegalArgumentException unused) {
            }
            this.f993a = null;
        }
    }

    public void d() {
        e1 e1Var = (e1) this.f993a;
        p0.c cVar = (p0.c) this.f994b;
        LinkedHashSet linkedHashSet = e1Var.f977e;
        if (linkedHashSet.remove(cVar) && linkedHashSet.isEmpty()) {
            e1Var.b();
        }
    }

    public abstract IntentFilter e();

    public abstract int f();

    public MenuItem g(MenuItem menuItem) {
        if (!(menuItem instanceof n0.a)) {
            return menuItem;
        }
        n0.a aVar = (n0.a) menuItem;
        if (((v.k) this.f994b) == null) {
            this.f994b = new v.k(0);
        }
        MenuItem menuItem2 = (MenuItem) ((v.k) this.f994b).get(aVar);
        if (menuItem2 != null) {
            return menuItem2;
        }
        n.r rVar = new n.r((Context) this.f993a, aVar);
        ((v.k) this.f994b).put(aVar, rVar);
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
        ((SparseIntArray) this.f993a).clear();
    }

    public boolean l() {
        e1 e1Var = (e1) this.f993a;
        View view = e1Var.f975c.f1103b0;
        ge.i.d(view, "operation.fragment.mView");
        int i = 4;
        if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
            int visibility = view.getVisibility();
            if (visibility == 0) {
                i = 2;
            } else if (visibility != 4) {
                if (visibility != 8) {
                    throw new IllegalArgumentException(l0.e.g(visibility, "Unknown visibility "));
                }
                i = 3;
            }
        }
        int i10 = e1Var.f973a;
        if (i != i10) {
            return (i == 2 || i10 == 2) ? false : true;
        }
        return true;
    }

    public abstract void m();

    public void n() {
        c();
        IntentFilter intentFilterE = e();
        if (intentFilterE.countActions() == 0) {
            return;
        }
        if (((com.bumptech.glide.manager.r) this.f993a) == null) {
            this.f993a = new com.bumptech.glide.manager.r(2, this);
        }
        ((h.a0) this.f994b).F.registerReceiver((com.bumptech.glide.manager.r) this.f993a, intentFilterE);
    }

    public h(e1 e1Var, p0.c cVar) {
        this.f993a = e1Var;
        this.f994b = cVar;
    }

    public h() {
        this.f993a = new SparseIntArray();
        this.f994b = new SparseIntArray();
    }

    public h(h.a0 a0Var) {
        this.f994b = a0Var;
    }
}
