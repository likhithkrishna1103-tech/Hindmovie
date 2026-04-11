package g2;

import androidx.media3.decoder.DecoderInputBuffer;
import h4.z;
import java.io.IOException;
import java.util.ArrayList;
import o2.c1;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements c1 {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f4894u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f4895v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f4896w = -1;

    public m(q qVar, int i) {
        this.f4895v = qVar;
        this.f4894u = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r6 = this;
            int r0 = r6.f4896w
            r1 = 1
            r2 = -1
            if (r0 != r2) goto L8
            r0 = r1
            goto L9
        L8:
            r0 = 0
        L9:
            s1.d.b(r0)
            g2.q r0 = r6.f4895v
            r0.w()
            int[] r3 = r0.f4910e0
            r3.getClass()
            int[] r3 = r0.f4910e0
            int r4 = r6.f4894u
            r3 = r3[r4]
            r5 = -2
            if (r3 != r2) goto L31
            java.util.Set r1 = r0.f4909d0
            o2.n1 r0 = r0.f4908c0
            p1.g1 r0 = r0.a(r4)
            boolean r0 = r1.contains(r0)
            if (r0 == 0) goto L2f
            r3 = -3
            goto L3a
        L2f:
            r3 = r5
            goto L3a
        L31:
            boolean[] r0 = r0.f4913h0
            boolean r2 = r0[r3]
            if (r2 == 0) goto L38
            goto L2f
        L38:
            r0[r3] = r1
        L3a:
            r6.f4896w = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: g2.m.a():void");
    }

    @Override // o2.c1
    public final void b() throws IOException {
        int i = this.f4896w;
        q qVar = this.f4895v;
        if (i == -2) {
            qVar.w();
            throw new c6.c(e6.j.n("Unable to bind a sample queue to TrackGroup with MIME type ", qVar.f4908c0.a(this.f4894u).f9765d[0].f10023n, "."));
        }
        if (i == -1) {
            qVar.G();
        } else if (i != -3) {
            qVar.G();
            qVar.P[i].z();
        }
    }

    public final boolean c() {
        int i = this.f4896w;
        return (i == -1 || i == -3 || i == -2) ? false : true;
    }

    @Override // o2.c1
    public final int e(z zVar, DecoderInputBuffer decoderInputBuffer, int i) {
        p1.q qVar;
        if (this.f4896w == -3) {
            decoderInputBuffer.addFlag(4);
            return -4;
        }
        if (c()) {
            int i10 = this.f4896w;
            q qVar2 = this.f4895v;
            ArrayList arrayList = qVar2.H;
            if (!qVar2.E()) {
                int i11 = 0;
                if (!arrayList.isEmpty()) {
                    int i12 = 0;
                    loop0: while (i12 < arrayList.size() - 1) {
                        int i13 = ((j) arrayList.get(i12)).E;
                        int length = qVar2.P.length;
                        for (int i14 = 0; i14 < length; i14++) {
                            if (qVar2.f4913h0[i14] && qVar2.P[i14].B() == i13) {
                                break loop0;
                            }
                        }
                        i12++;
                    }
                    b0.T(arrayList, 0, i12);
                    j jVar = (j) arrayList.get(0);
                    p1.q qVar3 = jVar.f10146x;
                    if (!qVar3.equals(qVar2.f4906a0)) {
                        qVar2.E.g(qVar2.f4924v, qVar3, jVar.f10147y, jVar.f10148z, jVar.A);
                    }
                    qVar2.f4906a0 = qVar3;
                }
                if (arrayList.isEmpty() || ((j) arrayList.get(0)).h()) {
                    int iC = qVar2.P[i10].C(zVar, decoderInputBuffer, i, qVar2.f4918n0);
                    if (iC == -5) {
                        p1.q qVarD = (p1.q) zVar.f5868w;
                        qVarD.getClass();
                        if (i10 == qVar2.V) {
                            int iN = q1.c.n(qVar2.P[i10].B());
                            while (i11 < arrayList.size() && ((j) arrayList.get(i11)).E != iN) {
                                i11++;
                            }
                            if (i11 < arrayList.size()) {
                                qVar = ((j) arrayList.get(i11)).f10146x;
                            } else {
                                qVar = qVar2.Z;
                                qVar.getClass();
                            }
                            qVarD = qVarD.d(qVar);
                        }
                        zVar.f5868w = qVarD;
                    }
                    return iC;
                }
            }
        }
        return -3;
    }

    @Override // o2.c1
    public final boolean j() {
        if (this.f4896w == -3) {
            return true;
        }
        if (!c()) {
            return false;
        }
        int i = this.f4896w;
        q qVar = this.f4895v;
        return !qVar.E() && qVar.P[i].x(qVar.f4918n0);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    @Override // o2.c1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int q(long r5) {
        /*
            r4 = this;
            boolean r0 = r4.c()
            if (r0 == 0) goto L63
            int r0 = r4.f4896w
            g2.q r1 = r4.f4895v
            boolean r2 = r1.E()
            if (r2 == 0) goto L11
            goto L63
        L11:
            g2.p[] r2 = r1.P
            r2 = r2[r0]
            boolean r3 = r1.f4918n0
            int r5 = r2.v(r3, r5)
            java.util.ArrayList r6 = r1.H
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
            g2.j r6 = (g2.j) r6
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
        throw new UnsupportedOperationException("Method not decompiled: g2.m.q(long):int");
    }
}
