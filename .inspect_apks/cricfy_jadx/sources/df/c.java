package df;

import com.google.android.gms.internal.measurement.o4;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements ze.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c f3695a = new c();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final o f3696b = new o("kotlin.Double", bf.b.f1909e);

    @Override // ze.a
    public final Object b(ff.k kVar) {
        ge.i.e(kVar, "decoder");
        ff.m mVar = (ff.m) kVar.f4589d;
        String strM = mVar.m();
        try {
            double d10 = Double.parseDouble(strM);
            ((ef.b) kVar.f4587b).f3893a.getClass();
            if (!Double.isInfinite(d10) && !Double.isNaN(d10)) {
                return Double.valueOf(d10);
            }
            ff.m.q(mVar, "Unexpected special floating-point value " + Double.valueOf(d10) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification", 0, 2);
            throw null;
        } catch (IllegalArgumentException unused) {
            ff.m.q(mVar, "Failed to parse type 'double' for input '" + strM + '\'', 0, 6);
            throw null;
        }
    }

    @Override // ze.a
    public final void c(ff.l lVar, Object obj) {
        double dDoubleValue = ((Number) obj).doubleValue();
        o4 o4Var = (o4) lVar.f4593c;
        if (lVar.f4592b) {
            lVar.j(String.valueOf(dDoubleValue));
        } else {
            ((ag.o) o4Var.f2561w).o(String.valueOf(dDoubleValue));
        }
        ((da.a) lVar.f4596g).getClass();
        if (Double.isInfinite(dDoubleValue) || Double.isNaN(dDoubleValue)) {
            throw new ff.d("Unexpected special floating-point value " + Double.valueOf(dDoubleValue) + ". By default, non-finite floating point values are prohibited because they do not conform JSON specification. It is possible to deserialize them using 'JsonBuilder.allowSpecialFloatingPointValues = true'\nCurrent output: " + ((Object) ff.i.d(((ag.o) o4Var.f2561w).toString(), -1)));
        }
    }

    @Override // ze.a
    public final bf.d d() {
        return f3696b;
    }
}
