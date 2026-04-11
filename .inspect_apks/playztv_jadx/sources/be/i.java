package be;

import java.io.Serializable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements f, Serializable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2042u;

    public i(int i) {
        this.f2042u = i;
    }

    @Override // be.f
    public final int d() {
        return this.f2042u;
    }

    public final String toString() {
        o.f2046a.getClass();
        String strA = p.a(this);
        h.d(strA, "renderLambdaToString(...)");
        return strA;
    }
}
