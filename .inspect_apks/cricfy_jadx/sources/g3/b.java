package g3;

import a3.l;
import a3.o;
import a3.p;
import a3.q;
import a3.r;
import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t f4959a = new t(4);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t f4960b = new t(9);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final t f4961c = new t(11);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final t f4962d = new t();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f4963e;
    public r f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f4964g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f4965h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f4966j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public int f4967k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f4968l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public long f4969m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public boolean f4970n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public a f4971o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public e f4972p;

    public b() {
        c cVar = new c(2, new o());
        cVar.f4973x = -9223372036854775807L;
        cVar.f4974y = new long[0];
        cVar.f4975z = new long[0];
        this.f4963e = cVar;
        this.f4964g = 1;
    }

    public final t b(q qVar) {
        int i = this.f4968l;
        t tVar = this.f4962d;
        byte[] bArr = tVar.f14609a;
        if (i > bArr.length) {
            tVar.H(0, new byte[Math.max(bArr.length * 2, i)]);
        } else {
            tVar.J(0);
        }
        tVar.I(this.f4968l);
        qVar.readFully(tVar.f14609a, 0, this.f4968l);
        return tVar;
    }

    @Override // a3.p
    public final void c(r rVar) {
        this.f = rVar;
    }

    @Override // a3.p
    public final void e(long j4, long j7) {
        if (j4 == 0) {
            this.f4964g = 1;
            this.f4965h = false;
        } else {
            this.f4964g = 3;
        }
        this.f4966j = 0;
    }

    @Override // a3.p
    public final List f() {
        g0 g0Var = i0.f12341w;
        return z0.f12413z;
    }

    @Override // a3.p
    public final boolean h(q qVar) throws EOFException, InterruptedIOException {
        t tVar = this.f4959a;
        l lVar = (l) qVar;
        lVar.v(tVar.f14609a, 0, 3, false);
        tVar.J(0);
        if (tVar.A() == 4607062) {
            lVar.v(tVar.f14609a, 0, 2, false);
            tVar.J(0);
            if ((tVar.D() & 250) == 0) {
                lVar.v(tVar.f14609a, 0, 4, false);
                tVar.J(0);
                int iJ = tVar.j();
                lVar.A = 0;
                lVar.b(iJ, false);
                lVar.v(tVar.f14609a, 0, 4, false);
                tVar.J(0);
                if (tVar.j() == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x03b3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0009 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x017a  */
    @Override // a3.p
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int i(a3.q r29, a3.t r30) throws v1.n0 {
        /*
            Method dump skipped, instruction units count: 1120
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: g3.b.i(a3.q, a3.t):int");
    }

    @Override // a3.p
    public final p a() {
        return this;
    }

    @Override // a3.p
    public final void release() {
    }
}
