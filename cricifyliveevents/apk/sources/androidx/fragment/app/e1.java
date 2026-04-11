package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final y f975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final ArrayList f976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final LinkedHashSet f977e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final z0 f979h;

    public e1(int i, int i10, z0 z0Var, p0.c cVar) {
        q4.a.s(i, "finalState");
        q4.a.s(i10, "lifecycleImpact");
        y yVar = z0Var.f1129c;
        ge.i.d(yVar, "fragmentStateManager.fragment");
        q4.a.s(i, "finalState");
        q4.a.s(i10, "lifecycleImpact");
        ge.i.e(yVar, "fragment");
        this.f973a = i;
        this.f974b = i10;
        this.f975c = yVar;
        this.f976d = new ArrayList();
        this.f977e = new LinkedHashSet();
        cVar.a(new f1(0, this));
        this.f979h = z0Var;
    }

    public final void a() {
        if (this.f) {
            return;
        }
        this.f = true;
        if (this.f977e.isEmpty()) {
            b();
            return;
        }
        LinkedHashSet linkedHashSet = this.f977e;
        ge.i.e(linkedHashSet, "<this>");
        for (p0.c cVar : new LinkedHashSet(linkedHashSet)) {
            synchronized (cVar) {
                try {
                    if (!cVar.f9868a) {
                        cVar.f9868a = true;
                        cVar.f9870c = true;
                        p0.b bVar = cVar.f9869b;
                        if (bVar != null) {
                            try {
                                bVar.onCancel();
                            } catch (Throwable th) {
                                synchronized (cVar) {
                                    cVar.f9870c = false;
                                    cVar.notifyAll();
                                    throw th;
                                }
                            }
                        }
                        synchronized (cVar) {
                            cVar.f9870c = false;
                            cVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.f978g) {
            if (r0.J(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f978g = true;
            ArrayList arrayList = this.f976d;
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                ((Runnable) obj).run();
            }
        }
        this.f979h.k();
    }

    public final void c(int i, int i10) {
        q4.a.s(i, "finalState");
        q4.a.s(i10, "lifecycleImpact");
        int iC = y.e.c(i10);
        y yVar = this.f975c;
        if (iC == 0) {
            if (this.f973a != 1) {
                if (r0.J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + yVar + " mFinalState = " + q4.a.z(this.f973a) + " -> " + q4.a.z(i) + '.');
                }
                this.f973a = i;
                return;
            }
            return;
        }
        if (iC == 1) {
            if (this.f973a == 1) {
                if (r0.J(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + yVar + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + q4.a.y(this.f974b) + " to ADDING.");
                }
                this.f973a = 2;
                this.f974b = 2;
                return;
            }
            return;
        }
        if (iC != 2) {
            return;
        }
        if (r0.J(2)) {
            Log.v("FragmentManager", "SpecialEffectsController: For fragment " + yVar + " mFinalState = " + q4.a.z(this.f973a) + " -> REMOVED. mLifecycleImpact  = " + q4.a.y(this.f974b) + " to REMOVING.");
        }
        this.f973a = 1;
        this.f974b = 3;
    }

    public final void d() {
        int i = this.f974b;
        z0 z0Var = this.f979h;
        if (i != 2) {
            if (i == 3) {
                y yVar = z0Var.f1129c;
                ge.i.d(yVar, "fragmentStateManager.fragment");
                View viewL = yVar.L();
                if (r0.J(2)) {
                    Log.v("FragmentManager", "Clearing focus " + viewL.findFocus() + " on view " + viewL + " for Fragment " + yVar);
                }
                viewL.clearFocus();
                return;
            }
            return;
        }
        y yVar2 = z0Var.f1129c;
        ge.i.d(yVar2, "fragmentStateManager.fragment");
        View viewFindFocus = yVar2.f1103b0.findFocus();
        if (viewFindFocus != null) {
            yVar2.g().f1095k = viewFindFocus;
            if (r0.J(2)) {
                Log.v("FragmentManager", "requestFocus: Saved focused view " + viewFindFocus + " for Fragment " + yVar2);
            }
        }
        View viewL2 = this.f975c.L();
        if (viewL2.getParent() == null) {
            z0Var.b();
            viewL2.setAlpha(0.0f);
        }
        if (viewL2.getAlpha() == 0.0f && viewL2.getVisibility() == 0) {
            viewL2.setVisibility(4);
        }
        w wVar = yVar2.f1106e0;
        viewL2.setAlpha(wVar == null ? 1.0f : wVar.f1094j);
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {finalState = " + q4.a.z(this.f973a) + " lifecycleImpact = " + q4.a.y(this.f974b) + " fragment = " + this.f975c + '}';
    }
}
