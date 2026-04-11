package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class z0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f1427a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1428b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final v f1429c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f1430d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final HashSet f1431e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f1432g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final u0 f1433h;

    public z0(int i, int i10, u0 u0Var, m0.c cVar) {
        v vVar = u0Var.f1374c;
        this.f1430d = new ArrayList();
        this.f1431e = new HashSet();
        this.f = false;
        this.f1432g = false;
        this.f1427a = i;
        this.f1428b = i10;
        this.f1429c = vVar;
        cVar.a(new wb.c(3, this));
        this.f1433h = u0Var;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.f1431e.isEmpty()) {
            b();
            return;
        }
        ArrayList arrayList = new ArrayList(this.f1431e);
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            m0.c cVar = (m0.c) obj;
            synchronized (cVar) {
                try {
                    if (!cVar.f8276a) {
                        cVar.f8276a = true;
                        cVar.f8278c = true;
                        m0.b bVar = cVar.f8277b;
                        if (bVar != null) {
                            try {
                                bVar.onCancel();
                            } catch (Throwable th) {
                                synchronized (cVar) {
                                    cVar.f8278c = false;
                                    cVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (cVar) {
                            cVar.f8278c = false;
                            cVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.f1432g) {
            if (n0.G(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f1432g = true;
            ArrayList arrayList = this.f1430d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.f1433h.k();
    }

    public final void c(int i, int i10) {
        int iC = v.e.c(i10);
        v vVar = this.f1429c;
        if (iC == 0) {
            if (this.f1427a != 1) {
                if (n0.G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + vVar + " mFinalState = " + l4.a.y(this.f1427a) + " -> " + l4.a.y(i) + ". ");
                }
                this.f1427a = i;
                return;
            }
            return;
        }
        if (iC == 1) {
            if (this.f1427a == 1) {
                if (n0.G(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + vVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + l4.a.x(this.f1428b) + " to ADDING.");
                }
                this.f1427a = 2;
                this.f1428b = 2;
                return;
            }
            return;
        }
        if (iC != 2) {
            return;
        }
        if (n0.G(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + vVar + " mFinalState = " + l4.a.y(this.f1427a) + " -> REMOVED. mLifecycleImpact  = " + l4.a.x(this.f1428b) + " to REMOVING.");
        }
        this.f1427a = 1;
        this.f1428b = 3;
    }

    public final void d() {
        int i = this.f1428b;
        u0 u0Var = this.f1433h;
        if (i != 2) {
            if (i == 3) {
                v vVar = u0Var.f1374c;
                View viewI = vVar.I();
                if (n0.G(2)) {
                    Log.v("FragmentManager", "Clearing focus " + viewI.findFocus() + " on view " + viewI + " for Fragment " + vVar);
                }
                viewI.clearFocus();
                return;
            }
            return;
        }
        v vVar2 = u0Var.f1374c;
        View viewFindFocus = vVar2.f1378a0.findFocus();
        if (viewFindFocus != null) {
            vVar2.g().f1369k = viewFindFocus;
            if (n0.G(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + vVar2);
            }
        }
        View viewI2 = this.f1429c.I();
        if (viewI2.getParent() == null) {
            u0Var.b();
            viewI2.setAlpha(0.0f);
        }
        if (viewI2.getAlpha() == 0.0f && viewI2.getVisibility() == 0) {
            viewI2.setVisibility(4);
        }
        t tVar = vVar2.f1381d0;
        viewI2.setAlpha(tVar == null ? 1.0f : tVar.f1368j);
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + l4.a.y(this.f1427a) + "} {mLifecycleImpact = " + l4.a.x(this.f1428b) + "} {mFragment = " + this.f1429c + "}";
    }
}
