package o5;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class i extends k {
    @Override // o5.e
    public final Object f(y5.a aVar, float f) {
        return Float.valueOf(l(aVar, f));
    }

    public final float k() {
        return l(this.f9377c.k(), c());
    }

    public final float l(y5.a aVar, float f) {
        float f4;
        Object obj = aVar.f14522b;
        Object obj2 = aVar.f14522b;
        if (obj == null || aVar.f14523c == null) {
            throw new IllegalStateException("Missing values for keyframe.");
        }
        p2.c cVar = this.f9379e;
        if (cVar != null) {
            f4 = f;
            Float f10 = (Float) cVar.n(aVar.f14526g, aVar.f14527h.floatValue(), (Float) obj2, (Float) aVar.f14523c, f4, d(), this.f9378d);
            if (f10 != null) {
                return f10.floatValue();
            }
        } else {
            f4 = f;
        }
        if (aVar.i == -3987645.8f) {
            aVar.i = ((Float) obj2).floatValue();
        }
        float f11 = aVar.i;
        if (aVar.f14528j == -3987645.8f) {
            aVar.f14528j = ((Float) aVar.f14523c).floatValue();
        }
        return x5.f.e(f11, aVar.f14528j, f4);
    }
}
