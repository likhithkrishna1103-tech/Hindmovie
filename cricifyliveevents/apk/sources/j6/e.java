package j6;

import android.view.animation.Interpolator;
import f9.a0;
import java.util.ArrayList;
import java.util.List;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class e {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final b f6632c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public w f6634e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ArrayList f6630a = new ArrayList(1);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f6631b = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public float f6633d = 0.0f;
    public Object f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public float f6635g = -1.0f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f6636h = -1.0f;

    public e(List list) {
        b dVar;
        if (list.isEmpty()) {
            dVar = new a0(14);
        } else {
            dVar = list.size() == 1 ? new d(list) : new c(list);
        }
        this.f6632c = dVar;
    }

    public final void a(a aVar) {
        this.f6630a.add(aVar);
    }

    public float b() {
        if (this.f6636h == -1.0f) {
            this.f6636h = this.f6632c.b();
        }
        return this.f6636h;
    }

    public final float c() {
        Interpolator interpolator;
        t6.a aVarE = this.f6632c.e();
        if (aVarE == null || aVarE.c() || (interpolator = aVarE.f11934d) == null) {
            return 0.0f;
        }
        return interpolator.getInterpolation(d());
    }

    public final float d() {
        if (this.f6631b) {
            return 0.0f;
        }
        t6.a aVarE = this.f6632c.e();
        if (aVarE.c()) {
            return 0.0f;
        }
        return (this.f6633d - aVarE.b()) / (aVarE.a() - aVarE.b());
    }

    public Object e() {
        float fD = d();
        w wVar = this.f6634e;
        b bVar = this.f6632c;
        if (wVar == null && bVar.c(fD) && !k()) {
            return this.f;
        }
        t6.a aVarE = bVar.e();
        Interpolator interpolator = aVarE.f11935e;
        Interpolator interpolator2 = aVarE.f;
        Object objF = (interpolator == null || interpolator2 == null) ? f(aVarE, c()) : g(aVarE, fD, interpolator.getInterpolation(fD), interpolator2.getInterpolation(fD));
        this.f = objF;
        return objF;
    }

    public abstract Object f(t6.a aVar, float f);

    public Object g(t6.a aVar, float f, float f10, float f11) {
        throw new UnsupportedOperationException("This animation does not support split dimensions!");
    }

    public void h() {
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6630a;
            if (i >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i)).b();
            i++;
        }
    }

    public void i(float f) {
        b bVar = this.f6632c;
        if (bVar.isEmpty()) {
            return;
        }
        if (this.f6635g == -1.0f) {
            this.f6635g = bVar.d();
        }
        float f10 = this.f6635g;
        if (f < f10) {
            if (f10 == -1.0f) {
                this.f6635g = bVar.d();
            }
            f = this.f6635g;
        } else if (f > b()) {
            f = b();
        }
        if (f == this.f6633d) {
            return;
        }
        this.f6633d = f;
        if (bVar.f(f)) {
            h();
        }
    }

    public final void j(w wVar) {
        w wVar2 = this.f6634e;
        if (wVar2 != null) {
            wVar2.getClass();
        }
        this.f6634e = wVar;
    }

    public boolean k() {
        return false;
    }
}
