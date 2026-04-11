package r3;

import java.io.EOFException;
import p1.n0;
import s1.u;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f11379a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public long f11380b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f11381c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f11382d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11383e;
    public final int[] f = new int[255];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final u f11384g = new u(255);

    public final boolean a(p pVar, boolean z2) throws EOFException, n0 {
        boolean zR;
        boolean zR2;
        this.f11379a = 0;
        this.f11380b = 0L;
        this.f11381c = 0;
        this.f11382d = 0;
        this.f11383e = 0;
        u uVar = this.f11384g;
        uVar.G(27);
        try {
            zR = pVar.r(uVar.f11709a, 0, 27, z2);
        } catch (EOFException e10) {
            if (!z2) {
                throw e10;
            }
            zR = false;
        }
        if (zR && uVar.z() == 1332176723) {
            if (uVar.x() == 0) {
                this.f11379a = uVar.x();
                this.f11380b = uVar.m();
                uVar.o();
                uVar.o();
                uVar.o();
                int iX = uVar.x();
                this.f11381c = iX;
                this.f11382d = iX + 27;
                uVar.G(iX);
                try {
                    zR2 = pVar.r(uVar.f11709a, 0, this.f11381c, z2);
                } catch (EOFException e11) {
                    if (!z2) {
                        throw e11;
                    }
                    zR2 = false;
                }
                if (zR2) {
                    for (int i = 0; i < this.f11381c; i++) {
                        int iX2 = uVar.x();
                        this.f[i] = iX2;
                        this.f11383e += iX2;
                    }
                    return true;
                }
            } else if (!z2) {
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
    public final boolean b(w2.p r10, long r11) {
        /*
            r9 = this;
            long r0 = r10.getPosition()
            long r2 = r10.s()
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L10
            r0 = r2
            goto L11
        L10:
            r0 = r1
        L11:
            s1.d.b(r0)
            s1.u r0 = r9.f11384g
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
            byte[] r5 = r0.f11709a
            boolean r5 = r10.r(r5, r1, r3, r2)     // Catch: java.io.EOFException -> L32
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
            r10.l()
            return r2
        L47:
            r10.m(r2)
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
        throw new UnsupportedOperationException("Method not decompiled: r3.f.b(w2.p, long):boolean");
    }
}
