package o5;

import android.view.animation.Interpolator;
import java.util.ArrayList;
import java.util.List;
import k8.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f9377c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public p2.c f9379e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f9375a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f9376b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f9378d = 0.0f;
    public Object f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f9380g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f9381h = -1.0f;

    public e(List list) {
        b dVar;
        if (list.isEmpty()) {
            dVar = new z(21);
        } else {
            dVar = list.size() == 1 ? new d(list) : new c(list);
        }
        this.f9377c = dVar;
    }

    public final void a(a aVar) {
        this.f9375a.add(aVar);
    }

    public float b() {
        if (this.f9381h == -1.0f) {
            this.f9381h = this.f9377c.d();
        }
        return this.f9381h;
    }

    public final float c() {
        y5.a aVarK = this.f9377c.k();
        if (aVarK == null || aVarK.c()) {
            return 0.0f;
        }
        return aVarK.f14524d.getInterpolation(d());
    }

    public final float d() {
        if (this.f9376b) {
            return 0.0f;
        }
        y5.a aVarK = this.f9377c.k();
        if (aVarK.c()) {
            return 0.0f;
        }
        return (this.f9378d - aVarK.b()) / (aVarK.a() - aVarK.b());
    }

    public Object e() {
        float fD = d();
        p2.c cVar = this.f9379e;
        b bVar = this.f9377c;
        if (cVar == null && bVar.h(fD)) {
            return this.f;
        }
        y5.a aVarK = bVar.k();
        Interpolator interpolator = aVarK.f14525e;
        Interpolator interpolator2 = aVarK.f;
        Object objF = (interpolator == null || interpolator2 == null) ? f(aVarK, c()) : g(aVarK, fD, interpolator.getInterpolation(fD), interpolator2.getInterpolation(fD));
        this.f = objF;
        return objF;
    }

    public abstract Object f(y5.a aVar, float f);

    public Object g(y5.a aVar, float f, float f4, float f10) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void h() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f9375a;
            if (i >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i)).b();
            i++;
        }
    }

    public void i(float f) {
        b bVar = this.f9377c;
        if (bVar.isEmpty()) {
            return;
        }
        if (this.f9380g == -1.0f) {
            this.f9380g = bVar.j();
        }
        float f4 = this.f9380g;
        if (f < f4) {
            if (f4 == -1.0f) {
                this.f9380g = bVar.j();
            }
            f = this.f9380g;
        } else if (f > b()) {
            f = b();
        }
        if (f == this.f9378d) {
            return;
        }
        this.f9378d = f;
        if (bVar.n(f)) {
            h();
        }
    }

    public final void j(p2.c cVar) {
        p2.c cVar2 = this.f9379e;
        if (cVar2 != null) {
            cVar2.getClass();
        }
        this.f9379e = cVar;
    }
}
