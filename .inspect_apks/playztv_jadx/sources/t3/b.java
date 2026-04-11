package t3;

import aa.c1;
import aa.h0;
import aa.j0;
import aa.p;
import aa.z0;
import java.util.List;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements d {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final p f12075w = new p(new r2.h(3), z0.f767v);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final j0 f12076u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long[] f12077v;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b(aa.c1 r19) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t3.b.<init>(aa.c1):void");
    }

    @Override // t3.d
    public final int a(long j5) {
        int iA = b0.a(this.f12077v, j5, false);
        if (iA < this.f12076u.size()) {
            return iA;
        }
        return -1;
    }

    @Override // t3.d
    public final long f(int i) {
        s1.d.b(i < this.f12076u.size());
        return this.f12077v[i];
    }

    @Override // t3.d
    public final List i(long j5) {
        int iE = b0.e(this.f12077v, j5, false);
        if (iE != -1) {
            return (j0) this.f12076u.get(iE);
        }
        h0 h0Var = j0.f690v;
        return c1.f650y;
    }

    @Override // t3.d
    public final int j() {
        return this.f12076u.size();
    }
}
