package td;

import be.h;
import be.o;
import be.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class g extends c implements be.f {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f12493x;

    public g(int i, rd.c cVar) {
        super(cVar);
        this.f12493x = i;
    }

    @Override // be.f
    public final int d() {
        return this.f12493x;
    }

    @Override // td.a
    public final String toString() {
        if (this.f12487u != null) {
            return super.toString();
        }
        o.f2046a.getClass();
        String strA = p.a(this);
        h.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
