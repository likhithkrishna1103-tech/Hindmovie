package o5;

import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends e {
    public final Object i;

    public r(Object obj, p2.c cVar) {
        super(Collections.EMPTY_LIST);
        j(cVar);
        this.i = obj;
    }

    @Override // o5.e
    public final float b() {
        return 1.0f;
    }

    @Override // o5.e
    public final Object e() {
        p2.c cVar = this.f9379e;
        Object obj = this.i;
        float f = this.f9378d;
        return cVar.n(0.0f, 0.0f, obj, obj, f, f, f);
    }

    @Override // o5.e
    public final Object f(y5.a aVar, float f) {
        return e();
    }

    @Override // o5.e
    public final void h() {
        if (this.f9379e != null) {
            super.h();
        }
    }

    @Override // o5.e
    public final void i(float f) {
        this.f9378d = f;
    }
}
