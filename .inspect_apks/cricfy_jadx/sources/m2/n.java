package m2;

import androidx.media3.decoder.DecoderInputBuffer;
import java.io.IOException;
import java.util.ArrayList;
import l4.c0;
import s2.a1;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class n implements a1 {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f8099v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r f8100w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f8101x = -1;

    public n(r rVar, int i) {
        this.f8100w = rVar;
        this.f8099v = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            int r0 = r6.f8101x
            r1 = 1
            r2 = -1
            if (r0 != r2) goto L8
            r0 = r1
            goto L9
        L8:
            r0 = 0
        L9:
            y1.d.b(r0)
            m2.r r0 = r6.f8100w
            r0.c()
            int[] r3 = r0.f8116f0
            r3.getClass()
            int[] r3 = r0.f8116f0
            int r4 = r6.f8099v
            r3 = r3[r4]
            r5 = -2
            if (r3 != r2) goto L31
            java.util.Set r1 = r0.f8115e0
            s2.l1 r0 = r0.f8114d0
            v1.g1 r0 = r0.a(r4)
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L2f
            r3 = -3
            goto L3a
        L2f:
            r3 = r5
            goto L3a
        L31:
            boolean[] r0 = r0.f8119i0
            boolean r2 = r0[r3]
            if (r2 == 0) goto L38
            goto L2f
        L38:
            r0[r3] = r1
        L3a:
            r6.f8101x = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.n.a():void");
    }

    @Override // s2.a1
    public final boolean b() {
        if (this.f8101x == -3) {
            return true;
        }
        if (!d()) {
            return false;
        }
        int i = this.f8101x;
        r rVar = this.f8100w;
        return !rVar.E() && rVar.Q[i].x(rVar.o0);
    }

    @Override // s2.a1
    public final void c() throws IOException {
        int i = this.f8101x;
        r rVar = this.f8100w;
        if (i == -2) {
            rVar.c();
            throw new a2.a(l0.e.k("Unable to bind a sample queue to TrackGroup with MIME type ", rVar.f8114d0.a(this.f8099v).f12705d[0].f12946n, "."));
        }
        if (i == -1) {
            rVar.G();
        } else if (i != -3) {
            rVar.G();
            rVar.Q[i].z();
        }
    }

    public final boolean d() {
        int i = this.f8101x;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // s2.a1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int e(long r5) {
        /*
            r4 = this;
            boolean r0 = r4.d()
            if (r0 == 0) goto L63
            int r0 = r4.f8101x
            m2.r r1 = r4.f8100w
            boolean r2 = r1.E()
            if (r2 == 0) goto L11
            goto L63
        L11:
            m2.q[] r2 = r1.Q
            r2 = r2[r0]
            boolean r3 = r1.o0
            int r5 = r2.v(r3, r5)
            java.util.ArrayList r6 = r1.I
            if (r6 == 0) goto L31
            boolean r1 = r6.isEmpty()
            if (r1 == 0) goto L26
            goto L47
        L26:
            int r1 = r6.size()
            int r1 = r1 + (-1)
            java.lang.Object r6 = r6.get(r1)
            goto L48
        L31:
            java.util.Iterator r6 = r6.iterator()
            boolean r1 = r6.hasNext()
            if (r1 == 0) goto L47
        L3b:
            java.lang.Object r1 = r6.next()
            boolean r3 = r6.hasNext()
            if (r3 != 0) goto L3b
            r6 = r1
            goto L48
        L47:
            r6 = 0
        L48:
            m2.k r6 = (m2.k) r6
            if (r6 == 0) goto L5f
            boolean r1 = r6.h()
            if (r1 != 0) goto L5f
            int r1 = r2.t()
            int r6 = r6.g(r0)
            int r6 = r6 - r1
            int r5 = java.lang.Math.min(r5, r6)
        L5f:
            r2.H(r5)
            return r5
        L63:
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: m2.n.e(long):int");
    }

    @Override // s2.a1
    public final int p(c0 c0Var, DecoderInputBuffer decoderInputBuffer, int i) {
        v1.p pVar;
        if (this.f8101x == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (d()) {
            int i10 = this.f8101x;
            r rVar = this.f8100w;
            ArrayList arrayList = rVar.I;
            if (!rVar.E()) {
                int i11 = 0;
                if (!arrayList.isEmpty()) {
                    int i12 = 0;
                    loop0: while (i12 < arrayList.size() - 1) {
                        int i13 = ((k) arrayList.get(i12)).F;
                        int length = rVar.Q.length;
                        for (int i14 = 0; i14 < length; i14++) {
                            if (rVar.f8119i0[i14] && rVar.Q[i14].B() == i13) {
                                break loop0;
                            }
                        }
                        i12++;
                    }
                    a0.T(arrayList, 0, i12);
                    k kVar = (k) arrayList.get(0);
                    v1.p pVar2 = kVar.f11851y;
                    if (!pVar2.equals(rVar.f8112b0)) {
                        rVar.F.f(rVar.f8130w, pVar2, kVar.f11852z, kVar.A, kVar.B);
                    }
                    rVar.f8112b0 = pVar2;
                }
                if (arrayList.isEmpty() || ((k) arrayList.get(0)).h()) {
                    int iC = rVar.Q[i10].C(c0Var, decoderInputBuffer, i, rVar.o0);
                    if (iC == -5) {
                        v1.p pVarD = (v1.p) c0Var.f7706x;
                        pVarD.getClass();
                        if (i10 == rVar.W) {
                            int iL = com.bumptech.glide.d.l(rVar.Q[i10].B());
                            while (i11 < arrayList.size() && ((k) arrayList.get(i11)).F != iL) {
                                i11++;
                            }
                            if (i11 < arrayList.size()) {
                                pVar = ((k) arrayList.get(i11)).f11851y;
                            } else {
                                pVar = rVar.f8111a0;
                                pVar.getClass();
                            }
                            pVarD = pVarD.d(pVar);
                        }
                        c0Var.f7706x = pVarD;
                    }
                    return iC;
                }
            }
        }
        return -3;
    }
}
