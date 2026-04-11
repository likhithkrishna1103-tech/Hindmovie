package androidx.lifecycle;

import android.os.Looper;
import android.util.Log;
import android.view.View;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class y {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Object f1211j = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Object f1212a = new Object();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final q.f f1213b = new q.f();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1214c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f1215d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public volatile Object f1216e;
    public volatile Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f1217g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f1218h;
    public boolean i;

    public y() {
        Object obj = f1211j;
        this.f = obj;
        this.f1216e = obj;
        this.f1217g = -1;
    }

    public static void a(String str) {
        p.b.M().f9865a.getClass();
        if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException(l0.e.k("Cannot invoke ", str, " on a background thread"));
        }
    }

    public final void b(x xVar) {
        if (xVar.f1208w) {
            if (!xVar.d()) {
                xVar.b(false);
                return;
            }
            int i = xVar.f1209x;
            int i10 = this.f1217g;
            if (i >= i10) {
                return;
            }
            xVar.f1209x = i10;
            p6.c cVar = xVar.f1207v;
            Object obj = this.f1216e;
            cVar.getClass();
            s sVar = (s) obj;
            androidx.fragment.app.q qVar = (androidx.fragment.app.q) cVar.f10035w;
            if (sVar == null || !qVar.f1039z0) {
                return;
            }
            View viewL = qVar.L();
            if (viewL.getParent() != null) {
                throw new IllegalStateException("DialogFragment can not be attached to a container view");
            }
            if (qVar.D0 != null) {
                if (androidx.fragment.app.r0.J(3)) {
                    Log.d("FragmentManager", "DialogFragment " + cVar + " setting the content view on " + qVar.D0);
                }
                qVar.D0.setContentView(viewL);
            }
        }
    }

    public final void c(x xVar) {
        if (this.f1218h) {
            this.i = true;
            return;
        }
        this.f1218h = true;
        do {
            this.i = false;
            if (xVar != null) {
                b(xVar);
                xVar = null;
            } else {
                q.f fVar = this.f1213b;
                fVar.getClass();
                q.d dVar = new q.d(fVar);
                fVar.f10319x.put(dVar, Boolean.FALSE);
                while (dVar.hasNext()) {
                    b((x) ((Map.Entry) dVar.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.f1218h = false;
    }

    public final void d(p6.c cVar) {
        Object obj;
        a("observeForever");
        w wVar = new w(this, cVar);
        q.f fVar = this.f1213b;
        q.c cVarA = fVar.a(cVar);
        if (cVarA != null) {
            obj = cVarA.f10311w;
        } else {
            q.c cVar2 = new q.c(cVar, wVar);
            fVar.f10320y++;
            q.c cVar3 = fVar.f10318w;
            if (cVar3 == null) {
                fVar.f10317v = cVar2;
                fVar.f10318w = cVar2;
            } else {
                cVar3.f10312x = cVar2;
                cVar2.f10313y = cVar3;
                fVar.f10318w = cVar2;
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
        this.f1217g++;
        this.f1216e = obj;
        c(null);
    }
}
