package i4;

import a3.i0;
import a3.p;
import a3.q;
import a3.r;
import java.util.List;
import ua.g0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public r f6200a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public i0 f6201b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6202c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f6203d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public b f6204e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f6205g;

    @Override // a3.p
    public final void c(r rVar) {
        this.f6200a = rVar;
        this.f6201b = rVar.p(0, 1);
        rVar.e();
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        this.f6202c = j4 == 0 ? 0 : 4;
        b bVar = this.f6204e;
        if (bVar != null) {
            bVar.b(j7);
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = ua.i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) {
        return f.a(qVar);
    }

    /* JADX WARN: Code restructure failed: missing block: B:77:0x0213, code lost:
    
        if (r9 != 65534) goto L78;
     */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x023a  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r21, a3.t r22) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 692
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i4.d.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
