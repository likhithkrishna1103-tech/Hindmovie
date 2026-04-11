package se;

import androidx.media3.decoder.DecoderInputBuffer;
import java.util.ArrayList;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements te.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final vd.h f11675v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f11676w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final re.a f11677x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final /* synthetic */ int f11678y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f11679z;

    public b(Object obj, vd.h hVar, int i, re.a aVar, int i10) {
        this.f11678y = i10;
        this.f11675v = hVar;
        this.f11676w = i;
        this.f11677x = aVar;
        this.f11679z = obj;
    }

    public final Object a(d dVar, xd.c cVar) throws Throwable {
        d1.u uVar = new d1.u(dVar, this, (vd.c) null);
        ue.q qVar = new ue.q(cVar, cVar.h());
        Object objR = a.a.r(qVar, qVar, uVar);
        return objR == wd.a.f14143v ? objR : rd.l.f11003a;
    }

    public final String b() {
        ArrayList arrayList = new ArrayList(4);
        vd.i iVar = vd.i.f13722v;
        vd.h hVar = this.f11675v;
        if (hVar != iVar) {
            arrayList.add("context=" + hVar);
        }
        int i = this.f11676w;
        if (i != -3) {
            arrayList.add("capacity=" + i);
        }
        re.a aVar = re.a.f11004v;
        re.a aVar2 = this.f11677x;
        if (aVar2 != aVar) {
            arrayList.add("onBufferOverflow=" + aVar2);
        }
        return getClass().getSimpleName() + '[' + sd.j.l0(arrayList, ", ", null, null, null, 62) + ']';
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0017  */
    @Override // te.e
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final se.c j(vd.h r8, int r9, re.a r10) {
        /*
            r7 = this;
            vd.h r0 = r7.f11675v
            vd.h r3 = r8.q(r0)
            re.a r8 = re.a.f11004v
            re.a r1 = r7.f11677x
            int r2 = r7.f11676w
            if (r10 == r8) goto L11
            r5 = r10
        Lf:
            r4 = r9
            goto L29
        L11:
            r8 = -3
            if (r2 != r8) goto L15
            goto L27
        L15:
            if (r9 != r8) goto L19
        L17:
            r9 = r2
            goto L27
        L19:
            r8 = -2
            if (r2 != r8) goto L1d
            goto L27
        L1d:
            if (r9 != r8) goto L20
            goto L17
        L20:
            int r9 = r9 + r2
            if (r9 < 0) goto L24
            goto L27
        L24:
            r9 = 2147483647(0x7fffffff, float:NaN)
        L27:
            r5 = r1
            goto Lf
        L29:
            boolean r8 = ge.i.a(r3, r0)
            if (r8 == 0) goto L34
            if (r4 != r2) goto L34
            if (r5 != r1) goto L34
            return r7
        L34:
            int r8 = r7.f11678y
            switch(r8) {
                case 0: goto L45;
                default: goto L39;
            }
        L39:
            se.b r1 = new se.b
            java.lang.Object r8 = r7.f11679z
            r2 = r8
            se.c r2 = (se.c) r2
            r6 = 1
            r1.<init>(r2, r3, r4, r5, r6)
            goto L50
        L45:
            se.b r1 = new se.b
            java.lang.Object r8 = r7.f11679z
            r2 = r8
            d1.u r2 = (d1.u) r2
            r6 = 0
            r1.<init>(r2, r3, r4, r5, r6)
        L50:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: se.b.j(vd.h, int, re.a):se.c");
    }

    public final String toString() {
        switch (this.f11678y) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "block[" + ((d1.u) this.f11679z) + "] -> " + b();
            default:
                return ((c) this.f11679z) + " -> " + b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x007d  */
    @Override // se.c
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object z(se.d r7, xd.c r8) throws java.lang.Throwable {
        /*
            r6 = this;
            int r0 = r6.f11678y
            switch(r0) {
                case 1: goto La;
                default: goto L5;
            }
        L5:
            java.lang.Object r7 = r6.a(r7, r8)
            return r7
        La:
            int r0 = r6.f11676w
            r1 = -3
            wd.a r2 = wd.a.f14143v
            rd.l r3 = rd.l.f11003a
            if (r0 != r1) goto L7d
            vd.h r0 = r8.h()
            java.lang.Boolean r1 = java.lang.Boolean.FALSE
            pe.q r4 = new pe.q
            r5 = 0
            r4.<init>(r5)
            vd.h r5 = r6.f11675v
            java.lang.Object r1 = r5.J(r1, r4)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L32
            vd.h r1 = r0.q(r5)
            goto L37
        L32:
            r1 = 0
            vd.h r1 = pe.x.d(r0, r5, r1)
        L37:
            boolean r4 = ge.i.a(r1, r0)
            if (r4 == 0) goto L4d
            java.lang.Object r0 = r6.f11679z
            se.c r0 = (se.c) r0
            java.lang.Object r7 = r0.z(r7, r8)
            if (r7 != r2) goto L48
            goto L49
        L48:
            r7 = r3
        L49:
            if (r7 != r2) goto L84
        L4b:
            r3 = r7
            goto L84
        L4d:
            vd.d r4 = vd.d.f13721v
            vd.f r5 = r1.C(r4)
            vd.f r0 = r0.C(r4)
            boolean r0 = ge.i.a(r5, r0)
            if (r0 == 0) goto L7d
            vd.h r0 = r8.h()
            boolean r4 = r7 instanceof te.j
            if (r4 != 0) goto L6b
            se.o r4 = new se.o
            r4.<init>(r7, r0)
            r7 = r4
        L6b:
            d1.e r0 = new d1.e
            r4 = 0
            r5 = 7
            r0.<init>(r6, r4, r5)
            java.lang.Object r4 = ue.a.k(r1)
            java.lang.Object r7 = te.c.a(r1, r7, r4, r0, r8)
            if (r7 != r2) goto L84
            goto L4b
        L7d:
            java.lang.Object r7 = r6.a(r7, r8)
            if (r7 != r2) goto L84
            goto L4b
        L84:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: se.b.z(se.d, xd.c):java.lang.Object");
    }
}
