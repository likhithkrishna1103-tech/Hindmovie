package x3;

import java.util.List;
import ua.g0;
import ua.i0;
import ua.w0;
import ua.z0;
import v1.b0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements g {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final ua.p f14296x = new ua.p(new b0(14), w0.f12403w);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final i0 f14297v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long[] f14298w;

    /* JADX WARN: Removed duplicated region for block: B:37:0x00cf  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public d(ua.z0 r19) {
        /*
            Method dump skipped, instruction units count: 285
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: x3.d.<init>(ua.z0):void");
    }

    @Override // x3.g
    public final int a(long j4) {
        int iA = a0.a(this.f14298w, j4, false);
        if (iA < this.f14297v.size()) {
            return iA;
        }
        return -1;
    }

    @Override // x3.g
    public final long e(int i) {
        y1.d.b(i < this.f14297v.size());
        return this.f14298w[i];
    }

    @Override // x3.g
    public final List i(long j4) {
        int iE = a0.e(this.f14298w, j4, false);
        if (iE != -1) {
            return (i0) this.f14297v.get(iE);
        }
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // x3.g
    public final int j() {
        return this.f14297v.size();
    }
}
