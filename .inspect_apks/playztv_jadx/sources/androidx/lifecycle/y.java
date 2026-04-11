package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f1515j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1516a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p.f f1517b = new p.f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1518c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1519d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f1520e;
    public volatile Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1521g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1522h;
    public boolean i;

    public y() {
        Object obj = f1515j;
        this.f = obj;
        this.f1520e = obj;
        this.f1521g = -1;
    }

    public static void a(String str) {
        o.a.Y().f.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(e6.j.n("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(x xVar) {
        if (xVar.f1512v) {
            if (!xVar.e()) {
                xVar.b(false);
                return;
            }
            int i = xVar.f1513w;
            int i10 = this.f1521g;
            if (i >= i10) {
                return;
            }
            xVar.f1513w = i10;
            u5.c cVar = xVar.f1511u;
            Object obj = this.f1520e;
            cVar.getClass();
            s sVar = (s) obj;
            androidx.fragment.app.n nVar = (androidx.fragment.app.n) cVar.f12782v;
            if (sVar == null || !nVar.f1308y0) {
                return;
            }
            View viewI = nVar.I();
            if (viewI.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (nVar.C0 != null) {
                if (androidx.fragment.app.n0.G(3)) {
                    Log.d("FragmentManager", "DialogFragment " + cVar + " setting the content view on " + nVar.C0);
                }
                nVar.C0.setContentView(viewI);
            }
        }
    }

    public final void c(x xVar) {
        if (this.f1522h) {
            this.i = true;
            return;
        }
        this.f1522h = true;
        do {
            this.i = false;
            if (xVar != null) {
                b(xVar);
                xVar = null;
            } else {
                p.f fVar = this.f1517b;
                fVar.getClass();
                p.d dVar = new p.d(fVar);
                fVar.f9605w.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((x) ((Map.Entry) dVar.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.f1522h = false;
    }

    public final void d(u5.c cVar) {
        Object obj;
        a("observeForever");
        w wVar = new w(this, cVar);
        p.f fVar = this.f1517b;
        p.c cVarB = fVar.b(cVar);
        if (cVarB != null) {
            obj = cVarB.f9597v;
        } else {
            p.c cVar2 = new p.c(cVar, wVar);
            fVar.f9606x++;
            p.c cVar3 = fVar.f9604v;
            if (cVar3 == null) {
                fVar.f9603u = cVar2;
                fVar.f9604v = cVar2;
            } else {
                cVar3.f9598w = cVar2;
                cVar2.f9599x = cVar3;
                fVar.f9604v = cVar2;
            }
            obj = null;
        }
        x xVar = (x) obj;
        if (xVar instanceof LiveData$LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (xVar != null) {
            return;
        }
        wVar.b(true);
    }

    public final void e(Object obj) {
        a("setValue");
        this.f1521g++;
        this.f1520e = obj;
        c(null);
    }
}
