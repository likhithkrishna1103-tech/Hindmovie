package v3;

import a3.q;
import java.io.EOFException;
import v1.n0;
import y1.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f13149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f13150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f13151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f13152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f13153e;
    public final int[] f = new int[255];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final t f13154g = new t(255);

    public final boolean a(q qVar, boolean z10) throws n0, EOFException {
        boolean zV;
        boolean zV2;
        this.f13149a = 0;
        this.f13150b = 0L;
        this.f13151c = 0;
        this.f13152d = 0;
        this.f13153e = 0;
        t tVar = this.f13154g;
        tVar.G(27);
        try {
            zV = qVar.v(tVar.f14609a, 0, 27, z10);
        } catch (EOFException e9) {
            if (!z10) {
                throw e9;
            }
            zV = false;
        }
        if (zV && tVar.z() == 1332176723) {
            if (tVar.x() == 0) {
                this.f13149a = tVar.x();
                this.f13150b = tVar.m();
                tVar.o();
                tVar.o();
                tVar.o();
                int iX = tVar.x();
                this.f13151c = iX;
                this.f13152d = iX + 27;
                tVar.G(iX);
                try {
                    zV2 = qVar.v(tVar.f14609a, 0, this.f13151c, z10);
                } catch (EOFException e10) {
                    if (!z10) {
                        throw e10;
                    }
                    zV2 = false;
                }
                if (zV2) {
                    for (int i = 0; i < this.f13151c; i++) {
                        int iX2 = tVar.x();
                        this.f[i] = iX2;
                        this.f13153e += iX2;
                    }
                    return true;
                }
            } else if (!z10) {
                throw n0.c("unsupported bit stream revision");
            }
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x004b, code lost:
    
        if (r11 == (-1)) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0053, code lost:
    
        if (r10.getPosition() >= r11) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r10.a(1) == (-1)) goto L34;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005d, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean b(a3.q r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.getPosition()
            long r2 = r10.x()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            y1.d.b(r0)
            y1.t r0 = r9.f13154g
            r3 = 4
            r0.G(r3)
        L1a:
            r4 = -1
            int r4 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r4 == 0) goto L2b
            long r5 = r10.getPosition()
            r7 = 4
            long r5 = r5 + r7
            int r5 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r5 >= 0) goto L4b
        L2b:
            byte[] r5 = r0.f14609a
            boolean r5 = r10.v(r5, r1, r3, r2)     // Catch: java.io.EOFException -> L32
            goto L33
        L32:
            r5 = r1
        L33:
            if (r5 == 0) goto L4b
            r0.J(r1)
            long r4 = r0.z()
            r6 = 1332176723(0x4f676753, double:6.58182753E-315)
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 != 0) goto L47
            r10.k()
            return r2
        L47:
            r10.n(r2)
            goto L1a
        L4b:
            if (r4 == 0) goto L55
            long r5 = r10.getPosition()
            int r0 = (r5 > r11 ? 1 : (r5 == r11 ? 0 : -1))
            if (r0 >= 0) goto L5d
        L55:
            int r0 = r10.a(r2)
            r3 = -1
            if (r0 == r3) goto L5d
            goto L4b
        L5d:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.f.b(a3.q, long):boolean");
    }
}
