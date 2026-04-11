package o5;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class o extends e {
    public final PointF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f9400j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f9401k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f9402l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public p2.c f9403m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public p2.c f9404n;

    public o(i iVar, i iVar2) {
        super(Collections.EMPTY_LIST);
        this.i = new PointF();
        this.f9400j = new PointF();
        this.f9401k = iVar;
        this.f9402l = iVar2;
        i(this.f9378d);
    }

    @Override // o5.e
    public final Object e() {
        return k(0.0f);
    }

    @Override // o5.e
    public final /* bridge */ /* synthetic */ Object f(y5.a aVar, float f) {
        return k(f);
    }

    @Override // o5.e
    public final void i(float f) {
        i iVar = this.f9401k;
        iVar.i(f);
        i iVar2 = this.f9402l;
        iVar2.i(f);
        this.i.set(((Float) iVar.e()).floatValue(), ((Float) iVar2.e()).floatValue());
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f9375a;
            if (i >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i)).b();
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0036  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF k(float r12) {
        /*
            r11 = this;
            p2.c r0 = r11.f9403m
            r1 = 0
            if (r0 == 0) goto L36
            o5.i r0 = r11.f9401k
            o5.b r2 = r0.f9377c
            y5.a r2 = r2.k()
            if (r2 == 0) goto L36
            float r10 = r0.c()
            java.lang.Float r0 = r2.f14527h
            p2.c r3 = r11.f9403m
            float r4 = r2.f14526g
            if (r0 != 0) goto L1d
            r5 = r4
            goto L22
        L1d:
            float r0 = r0.floatValue()
            r5 = r0
        L22:
            java.lang.Object r0 = r2.f14522b
            r6 = r0
            java.lang.Float r6 = (java.lang.Float) r6
            java.lang.Object r0 = r2.f14523c
            r7 = r0
            java.lang.Float r7 = (java.lang.Float) r7
            r9 = r12
            r8 = r12
            java.lang.Object r12 = r3.n(r4, r5, r6, r7, r8, r9, r10)
            r7 = r8
            java.lang.Float r12 = (java.lang.Float) r12
            goto L38
        L36:
            r7 = r12
            r12 = r1
        L38:
            p2.c r0 = r11.f9404n
            if (r0 == 0) goto L6c
            o5.i r0 = r11.f9402l
            o5.b r2 = r0.f9377c
            y5.a r2 = r2.k()
            if (r2 == 0) goto L6c
            float r9 = r0.c()
            java.lang.Float r0 = r2.f14527h
            r1 = r2
            p2.c r2 = r11.f9404n
            float r3 = r1.f14526g
            if (r0 != 0) goto L55
            r4 = r3
            goto L5a
        L55:
            float r0 = r0.floatValue()
            r4 = r0
        L5a:
            java.lang.Object r0 = r1.f14522b
            r5 = r0
            java.lang.Float r5 = (java.lang.Float) r5
            java.lang.Object r0 = r1.f14523c
            r6 = r0
            java.lang.Float r6 = (java.lang.Float) r6
            r8 = r7
            java.lang.Object r0 = r2.n(r3, r4, r5, r6, r7, r8, r9)
            r1 = r0
            java.lang.Float r1 = (java.lang.Float) r1
        L6c:
            r0 = 0
            android.graphics.PointF r2 = r11.i
            android.graphics.PointF r3 = r11.f9400j
            if (r12 != 0) goto L79
            float r12 = r2.x
            r3.set(r12, r0)
            goto L80
        L79:
            float r12 = r12.floatValue()
            r3.set(r12, r0)
        L80:
            if (r1 != 0) goto L8a
            float r12 = r3.x
            float r0 = r2.y
            r3.set(r12, r0)
            return r3
        L8a:
            float r12 = r3.x
            float r0 = r1.floatValue()
            r3.set(r12, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: o5.o.k(float):android.graphics.PointF");
    }
}
