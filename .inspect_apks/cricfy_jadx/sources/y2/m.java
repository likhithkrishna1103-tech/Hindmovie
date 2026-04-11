package y2;

import android.content.Context;
import android.util.Pair;
import android.view.Surface;
import java.util.List;
import ua.g0;
import ua.i0;
import ua.z0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public i0 f14702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public v1.p f14703b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f14704c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f14705d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f14706e;

    public m(q qVar, Context context) {
        this.f14706e = qVar;
        y1.a0.K(context);
        g0 g0Var = i0.f12341w;
        this.f14702a = z0.f12413z;
        this.f14705d = -9223372036854775807L;
    }

    @Override // y2.f0
    public final void a() {
        int i = y1.u.f14612c.f14613a;
        this.f14706e.f14715j = null;
    }

    @Override // y2.f0
    public final boolean b() {
        return false;
    }

    @Override // y2.f0
    public final Surface c() {
        y1.d.g(false);
        throw null;
    }

    @Override // y2.f0
    public final void d(v1.p pVar, long j4, int i, List list) {
        y1.d.g(false);
        this.f14702a = i0.k(list);
        this.f14703b = pVar;
        this.f14706e.f14719n = false;
        v1.o oVarA = pVar.a();
        v1.g gVar = pVar.D;
        if (gVar == null || !gVar.d()) {
            gVar = v1.g.f12678h;
        }
        oVarA.C = gVar;
        oVarA.a();
        throw null;
    }

    @Override // y2.f0
    public final void e(float f) {
        this.f14706e.f14712e.e(f);
    }

    @Override // y2.f0
    public final void f(boolean z10) {
        this.f14705d = -9223372036854775807L;
        q qVar = this.f14706e;
        c cVar = qVar.f14712e;
        if (qVar.f14717l == 1) {
            qVar.f14716k++;
            cVar.f(z10);
            while (qVar.f14714h.h() > 1) {
                qVar.f14714h.e();
            }
            if (qVar.f14714h.h() == 1) {
                ((p) qVar.f14714h.e()).getClass();
                throw null;
            }
            qVar.f14718m = -9223372036854775807L;
            qVar.f14719n = false;
            y1.x xVar = qVar.i;
            y1.d.h(xVar);
            xVar.c(new pa.c(15, qVar));
        }
    }

    @Override // y2.f0
    public final void g(List list) {
        if (this.f14702a.equals(list)) {
            return;
        }
        this.f14702a = i0.k(list);
        v1.p pVar = this.f14703b;
        if (pVar == null) {
            return;
        }
        v1.o oVarA = pVar.a();
        v1.g gVar = pVar.D;
        if (gVar == null || !gVar.d()) {
            gVar = v1.g.f12678h;
        }
        oVarA.C = gVar;
        oVarA.a();
        throw null;
    }

    @Override // y2.f0
    public final void h() {
        q qVar = this.f14706e;
        if (qVar.f14711d) {
            qVar.f14712e.h();
        }
    }

    @Override // y2.f0
    public final void j(long j4, long j7) {
        this.f14706e.f14712e.j(j4 + this.f14704c, j7);
    }

    @Override // y2.f0
    public final void k(boolean z10) {
        q qVar = this.f14706e;
        if (qVar.f14711d) {
            qVar.f14712e.k(z10);
        }
    }

    @Override // y2.f0
    public final boolean l(boolean z10) {
        return this.f14706e.f14712e.f14636a.b(false);
    }

    @Override // y2.f0
    public final void m() {
        q qVar = this.f14706e;
        if (qVar.f14711d) {
            qVar.f14712e.m();
        }
    }

    @Override // y2.f0
    public final void n(u uVar) {
        this.f14706e.f14712e.i = uVar;
    }

    @Override // y2.f0
    public final void p(Surface surface, y1.u uVar) {
        q qVar = this.f14706e;
        Pair pair = qVar.f14715j;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((y1.u) qVar.f14715j.second).equals(uVar)) {
            return;
        }
        qVar.f14715j = Pair.create(surface, uVar);
        int i = uVar.f14613a;
    }

    @Override // y2.f0
    public final void q(long j4) {
        this.f14704c = j4;
    }

    @Override // y2.f0
    public final boolean r(long j4, g gVar) {
        y1.d.g(false);
        int i = this.f14706e.f14720o;
        if (i == -1 || i != 0) {
            return false;
        }
        throw null;
    }

    @Override // y2.f0
    public final void release() {
        q qVar = this.f14706e;
        if (qVar.f14717l == 2) {
            return;
        }
        y1.x xVar = qVar.i;
        if (xVar != null) {
            xVar.f14618a.removeCallbacksAndMessages(null);
        }
        qVar.f14715j = null;
        qVar.f14717l = 2;
    }

    @Override // y2.f0
    public final void s() {
        long j4 = this.f14705d;
        q qVar = this.f14706e;
        if (qVar.f14718m >= j4) {
            qVar.f14712e.s();
            qVar.f14719n = true;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    @Override // y2.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean t(v1.p r11) throws y2.e0 {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r0 = r0 ^ r1
            y1.d.g(r0)
            java.lang.String r0 = "Color transfer "
            y2.q r2 = r10.f14706e
            int r3 = r2.f14717l
            r4 = 0
            if (r3 != 0) goto L11
            r3 = r1
            goto L12
        L11:
            r3 = r4
        L12:
            y1.d.g(r3)
            v1.g r3 = r11.D
            if (r3 == 0) goto L20
            boolean r5 = r3.d()
            if (r5 == 0) goto L20
            goto L22
        L20:
            v1.g r3 = v1.g.f12678h
        L22:
            int r3 = r3.f12686c
            java.lang.String r5 = "EGL_EXT_gl_colorspace_bt2020_pq"
            r6 = 33
            r7 = 7
            if (r3 != r7) goto L3f
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: y1.k -> L3d
            r9 = 34
            if (r8 >= r9) goto L3f
            if (r8 < r6) goto L3f
            boolean r8 = y1.b.l(r5)     // Catch: y1.k -> L3d
            if (r8 != 0) goto L3a
            goto L3f
        L3a:
            v1.g r11 = new v1.g     // Catch: y1.k -> L3d
            goto L80
        L3d:
            r0 = move-exception
            goto L7a
        L3f:
            r8 = 6
            if (r3 != r8) goto L4f
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: y1.k -> L3d
            if (r7 < r6) goto L4d
            boolean r5 = y1.b.l(r5)     // Catch: y1.k -> L3d
            if (r5 == 0) goto L4d
            goto L57
        L4d:
            r1 = r4
            goto L57
        L4f:
            if (r3 != r7) goto L57
            java.lang.String r1 = "EGL_EXT_gl_colorspace_bt2020_hlg"
            boolean r1 = y1.b.l(r1)     // Catch: y1.k -> L3d
        L57:
            if (r1 != 0) goto L80
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: y1.k -> L3d
            r4 = 29
            if (r1 < r4) goto L80
            java.lang.String r1 = "PlaybackVidGraphWrapper"
            java.util.Locale r4 = java.util.Locale.US     // Catch: y1.k -> L3d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: y1.k -> L3d
            r4.<init>(r0)     // Catch: y1.k -> L3d
            r4.append(r3)     // Catch: y1.k -> L3d
            java.lang.String r0 = " is not supported. Falling back to OpenGl tone mapping."
            r4.append(r0)     // Catch: y1.k -> L3d
            java.lang.String r0 = r4.toString()     // Catch: y1.k -> L3d
            y1.b.p(r1, r0)     // Catch: y1.k -> L3d
            v1.g r11 = v1.g.f12678h     // Catch: y1.k -> L3d
            goto L80
        L7a:
            y2.e0 r1 = new y2.e0
            r1.<init>(r0, r11)
            throw r1
        L80:
            y1.v r11 = r2.f
            android.os.Looper r0 = android.os.Looper.myLooper()
            y1.d.h(r0)
            r1 = 0
            y1.x r11 = r11.a(r0, r1)
            r2.i = r11
            y2.o r11 = r2.f14709b
            r11.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: y2.m.t(v1.p):boolean");
    }

    @Override // y2.f0
    public final boolean u() {
        return false;
    }

    @Override // y2.f0
    public final void v() {
        q qVar = this.f14706e;
        if (qVar.f14714h.h() == 0) {
            qVar.f14712e.v();
            return;
        }
        pa.o oVar = new pa.o();
        if (qVar.f14714h.h() <= 0) {
            qVar.f14714h = oVar;
        } else {
            ((p) qVar.f14714h.e()).getClass();
            throw null;
        }
    }

    @Override // y2.f0
    public final void w(int i) {
        this.f14706e.f14712e.w(i);
    }

    @Override // y2.f0
    public final void o() {
    }

    @Override // y2.f0
    public final void i(l4.a aVar) {
    }
}
