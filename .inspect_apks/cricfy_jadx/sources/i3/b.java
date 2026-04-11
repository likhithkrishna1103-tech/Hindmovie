package i3;

import a3.l;
import a3.p;
import a3.q;
import a3.r;
import a3.u;
import f9.s0;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import u3.m;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public r f6166b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f6167c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f6168d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f6169e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public p3.a f6170g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public q f6171h;
    public s0 i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public m f6172j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f6165a = new t(2);
    public long f = -1;

    public final void b() {
        r rVar = this.f6166b;
        rVar.getClass();
        rVar.e();
        this.f6166b.s(new u(-9223372036854775807L));
        this.f6167c = 6;
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f6166b = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        if (j4 == 0) {
            this.f6167c = 0;
            this.f6172j = null;
        } else if (this.f6167c == 5) {
            m mVar = this.f6172j;
            mVar.getClass();
            mVar.e(j4, j7);
        }
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) throws EOFException, InterruptedIOException {
        l lVar = (l) qVar;
        t tVar = this.f6165a;
        tVar.G(2);
        lVar.v(tVar.f14609a, 0, 2, false);
        if (tVar.D() == 65496) {
            tVar.G(2);
            lVar.v(tVar.f14609a, 0, 2, false);
            int iD = tVar.D();
            this.f6168d = iD;
            if (iD == 65504) {
                tVar.G(2);
                lVar.v(tVar.f14609a, 0, 2, false);
                lVar.b(tVar.D() - 2, false);
                tVar.G(2);
                lVar.v(tVar.f14609a, 0, 2, false);
                this.f6168d = tVar.D();
            }
            if (this.f6168d == 65505) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0179  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r26, a3.t r27) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 458
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.b.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final void release() {
        m mVar = this.f6172j;
        if (mVar != null) {
            mVar.getClass();
        }
    }

    @Override // a3.p
    public final p a() {
        return this;
    }
}
