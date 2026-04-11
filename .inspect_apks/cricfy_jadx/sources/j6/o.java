package j6;

import android.graphics.PointF;
import java.util.ArrayList;
import java.util.Collections;
import nb.w;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o extends e {
    public final PointF i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PointF f6656j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final i f6657k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final i f6658l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public w f6659m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public w f6660n;

    public o(i iVar, i iVar2) {
        super(Collections.EMPTY_LIST);
        this.i = new PointF();
        this.f6656j = new PointF();
        this.f6657k = iVar;
        this.f6658l = iVar2;
        i(this.f6633d);
    }

    @Override // j6.e
    public final Object e() {
        return l();
    }

    @Override // j6.e
    public final /* bridge */ /* synthetic */ Object f(t6.a aVar, float f) {
        return l();
    }

    @Override // j6.e
    public final void i(float f) {
        i iVar = this.f6657k;
        iVar.i(f);
        i iVar2 = this.f6658l;
        iVar2.i(f);
        this.i.set(((Float) iVar.e()).floatValue(), ((Float) iVar2.e()).floatValue());
        int i = 0;
        while (true) {
            ArrayList arrayList = this.f6630a;
            if (i >= arrayList.size()) {
                return;
            }
            ((a) arrayList.get(i)).b();
            i++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF l() {
        /*
            r12 = this;
            nb.w r0 = r12.f6659m
            r1 = 0
            if (r0 == 0) goto L39
            j6.i r0 = r12.f6657k
            j6.b r2 = r0.f6632c
            t6.a r2 = r2.e()
            if (r2 == 0) goto L39
            java.lang.Float r3 = r2.f11937h
            nb.w r4 = r12.f6659m
            float r5 = r2.f11936g
            if (r3 != 0) goto L19
            r6 = r5
            goto L1e
        L19:
            float r3 = r3.floatValue()
            r6 = r3
        L1e:
            java.lang.Object r3 = r2.f11932b
            r7 = r3
            java.lang.Float r7 = (java.lang.Float) r7
            java.lang.Object r2 = r2.f11933c
            r8 = r2
            java.lang.Float r8 = (java.lang.Float) r8
            float r9 = r0.c()
            float r10 = r0.d()
            float r11 = r0.f6633d
            java.lang.Object r0 = r4.G(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Float r0 = (java.lang.Float) r0
            goto L3a
        L39:
            r0 = r1
        L3a:
            nb.w r2 = r12.f6660n
            if (r2 == 0) goto L71
            j6.i r2 = r12.f6658l
            j6.b r3 = r2.f6632c
            t6.a r3 = r3.e()
            if (r3 == 0) goto L71
            java.lang.Float r1 = r3.f11937h
            nb.w r4 = r12.f6660n
            float r5 = r3.f11936g
            if (r1 != 0) goto L52
            r6 = r5
            goto L57
        L52:
            float r1 = r1.floatValue()
            r6 = r1
        L57:
            java.lang.Object r1 = r3.f11932b
            r7 = r1
            java.lang.Float r7 = (java.lang.Float) r7
            java.lang.Object r1 = r3.f11933c
            r8 = r1
            java.lang.Float r8 = (java.lang.Float) r8
            float r9 = r2.c()
            float r10 = r2.d()
            float r11 = r2.f6633d
            java.lang.Object r1 = r4.G(r5, r6, r7, r8, r9, r10, r11)
            java.lang.Float r1 = (java.lang.Float) r1
        L71:
            r2 = 0
            android.graphics.PointF r3 = r12.i
            android.graphics.PointF r4 = r12.f6656j
            if (r0 != 0) goto L7e
            float r0 = r3.x
            r4.set(r0, r2)
            goto L85
        L7e:
            float r0 = r0.floatValue()
            r4.set(r0, r2)
        L85:
            if (r1 != 0) goto L8f
            float r0 = r4.x
            float r1 = r3.y
            r4.set(r0, r1)
            return r4
        L8f:
            float r0 = r4.x
            float r1 = r1.floatValue()
            r4.set(r0, r1)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: j6.o.l():android.graphics.PointF");
    }
}
