package u2;

import aa.c1;
import aa.h0;
import aa.j0;
import android.content.Context;
import android.util.Pair;
import android.view.Surface;
import java.util.List;
import n.a1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements f0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public j0 f12625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public p1.q f12626b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public long f12627c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public long f12628d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ q f12629e;

    public m(q qVar, Context context) {
        this.f12629e = qVar;
        s1.b0.K(context);
        h0 h0Var = j0.f690v;
        this.f12625a = c1.f650y;
        this.f12628d = -9223372036854775807L;
    }

    @Override // u2.f0
    public final void a() {
        int i = s1.v.f11712c.f11713a;
        this.f12629e.f12638j = null;
    }

    @Override // u2.f0
    public final boolean b() {
        return false;
    }

    @Override // u2.f0
    public final Surface c() {
        s1.d.g(false);
        throw null;
    }

    @Override // u2.f0
    public final boolean d(long j5, g gVar) {
        s1.d.g(false);
        int i = this.f12629e.f12643o;
        if (i == -1 || i != 0) {
            return false;
        }
        throw null;
    }

    @Override // u2.f0
    public final void e(boolean z2) {
        this.f12628d = -9223372036854775807L;
        q qVar = this.f12629e;
        c cVar = qVar.f12635e;
        if (qVar.f12640l == 1) {
            qVar.f12639k++;
            cVar.e(z2);
            while (qVar.f12637h.h() > 1) {
                qVar.f12637h.e();
            }
            if (qVar.f12637h.h() == 1) {
                ((p) qVar.f12637h.e()).getClass();
                throw null;
            }
            qVar.f12641m = -9223372036854775807L;
            qVar.f12642n = false;
            s1.y yVar = qVar.i;
            s1.d.h(yVar);
            yVar.c(new nc.b(7, qVar));
        }
    }

    @Override // u2.f0
    public final void f(List list) {
        if (this.f12625a.equals(list)) {
            return;
        }
        this.f12625a = j0.r(list);
        p1.q qVar = this.f12626b;
        if (qVar == null) {
            return;
        }
        p1.p pVarA = qVar.a();
        p1.h hVar = qVar.D;
        if (hVar == null || !hVar.d()) {
            hVar = p1.h.f9767h;
        }
        pVarA.C = hVar;
        pVarA.a();
        throw null;
    }

    @Override // u2.f0
    public final void g() {
        q qVar = this.f12629e;
        if (qVar.f12634d) {
            qVar.f12635e.g();
        }
    }

    @Override // u2.f0
    public final void h(u uVar) {
        this.f12629e.f12635e.i = uVar;
    }

    @Override // u2.f0
    public final void i(float f) {
        this.f12629e.f12635e.i(f);
    }

    @Override // u2.f0
    public final void j(long j5, long j8) throws e0 {
        this.f12629e.f12635e.j(j5 + this.f12627c, j8);
    }

    @Override // u2.f0
    public final void k(Surface surface, s1.v vVar) {
        q qVar = this.f12629e;
        Pair pair = qVar.f12638j;
        if (pair != null && ((Surface) pair.first).equals(surface) && ((s1.v) qVar.f12638j.second).equals(vVar)) {
            return;
        }
        qVar.f12638j = Pair.create(surface, vVar);
        int i = vVar.f11713a;
    }

    @Override // u2.f0
    public final void l(boolean z2) {
        q qVar = this.f12629e;
        if (qVar.f12634d) {
            qVar.f12635e.l(z2);
        }
    }

    @Override // u2.f0
    public final boolean m(boolean z2) {
        return this.f12629e.f12635e.f12557a.b(false);
    }

    @Override // u2.f0
    public final void n() {
        q qVar = this.f12629e;
        if (qVar.f12634d) {
            qVar.f12635e.n();
        }
    }

    @Override // u2.f0
    public final void q(p1.q qVar, long j5, int i, List list) {
        s1.d.g(false);
        this.f12625a = j0.r(list);
        this.f12626b = qVar;
        this.f12629e.f12642n = false;
        p1.p pVarA = qVar.a();
        p1.h hVar = qVar.D;
        if (hVar == null || !hVar.d()) {
            hVar = p1.h.f9767h;
        }
        pVarA.C = hVar;
        pVarA.a();
        throw null;
    }

    @Override // u2.f0
    public final void r(long j5) {
        this.f12627c = j5;
    }

    @Override // u2.f0
    public final void release() {
        q qVar = this.f12629e;
        if (qVar.f12640l == 2) {
            return;
        }
        s1.y yVar = qVar.i;
        if (yVar != null) {
            yVar.f11718a.removeCallbacksAndMessages(null);
        }
        qVar.f12638j = null;
        qVar.f12640l = 2;
    }

    @Override // u2.f0
    public final void s() {
        long j5 = this.f12628d;
        q qVar = this.f12629e;
        if (qVar.f12641m >= j5) {
            qVar.f12635e.s();
            qVar.f12642n = true;
        }
    }

    @Override // u2.f0
    public final boolean t() {
        return false;
    }

    @Override // u2.f0
    public final void u() {
        q qVar = this.f12629e;
        if (qVar.f12637h.h() == 0) {
            qVar.f12635e.u();
            return;
        }
        q3.d dVar = new q3.d();
        if (qVar.f12637h.h() <= 0) {
            qVar.f12637h = dVar;
        } else {
            ((p) qVar.f12637h.e()).getClass();
            throw null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x003f  */
    @Override // u2.f0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean v(p1.q r11) throws u2.e0 {
        /*
            r10 = this;
            r0 = 0
            r1 = 1
            r0 = r0 ^ r1
            s1.d.g(r0)
            java.lang.String r0 = "Color transfer "
            u2.q r2 = r10.f12629e
            int r3 = r2.f12640l
            r4 = 0
            if (r3 != 0) goto L11
            r3 = r1
            goto L12
        L11:
            r3 = r4
        L12:
            s1.d.g(r3)
            p1.h r3 = r11.D
            if (r3 == 0) goto L20
            boolean r5 = r3.d()
            if (r5 == 0) goto L20
            goto L22
        L20:
            p1.h r3 = p1.h.f9767h
        L22:
            int r3 = r3.f9775c
            java.lang.String r5 = "EGL_EXT_gl_colorspace_bt2020_pq"
            r6 = 33
            r7 = 7
            if (r3 != r7) goto L3f
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch: s1.k -> L3d
            r9 = 34
            if (r8 >= r9) goto L3f
            if (r8 < r6) goto L3f
            boolean r8 = s1.b.l(r5)     // Catch: s1.k -> L3d
            if (r8 != 0) goto L3a
            goto L3f
        L3a:
            p1.h r11 = new p1.h     // Catch: s1.k -> L3d
            goto L80
        L3d:
            r0 = move-exception
            goto L7a
        L3f:
            r8 = 6
            if (r3 != r8) goto L4f
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch: s1.k -> L3d
            if (r7 < r6) goto L4d
            boolean r5 = s1.b.l(r5)     // Catch: s1.k -> L3d
            if (r5 == 0) goto L4d
            goto L57
        L4d:
            r1 = r4
            goto L57
        L4f:
            if (r3 != r7) goto L57
            java.lang.String r1 = "EGL_EXT_gl_colorspace_bt2020_hlg"
            boolean r1 = s1.b.l(r1)     // Catch: s1.k -> L3d
        L57:
            if (r1 != 0) goto L80
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch: s1.k -> L3d
            r4 = 29
            if (r1 < r4) goto L80
            java.lang.String r1 = "PlaybackVidGraphWrapper"
            java.util.Locale r4 = java.util.Locale.US     // Catch: s1.k -> L3d
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: s1.k -> L3d
            r4.<init>(r0)     // Catch: s1.k -> L3d
            r4.append(r3)     // Catch: s1.k -> L3d
            java.lang.String r0 = " is not supported. Falling back to OpenGl tone mapping."
            r4.append(r0)     // Catch: s1.k -> L3d
            java.lang.String r0 = r4.toString()     // Catch: s1.k -> L3d
            s1.b.p(r1, r0)     // Catch: s1.k -> L3d
            p1.h r11 = p1.h.f9767h     // Catch: s1.k -> L3d
            goto L80
        L7a:
            u2.e0 r1 = new u2.e0
            r1.<init>(r0, r11)
            throw r1
        L80:
            s1.w r11 = r2.f
            android.os.Looper r0 = android.os.Looper.myLooper()
            s1.d.h(r0)
            r1 = 0
            s1.y r11 = r11.a(r0, r1)
            r2.i = r11
            u2.o r11 = r2.f12632b
            r11.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: u2.m.v(p1.q):boolean");
    }

    @Override // u2.f0
    public final void w(int i) {
        this.f12629e.f12635e.w(i);
    }

    @Override // u2.f0
    public final void o() {
    }

    @Override // u2.f0
    public final void p(a1 a1Var) {
    }
}
