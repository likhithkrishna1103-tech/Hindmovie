package androidx.recyclerview.widget;

import a2.u0;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.h;
import cf.d;
import e6.j;
import q4.g0;
import q4.h0;
import q4.i0;
import q4.k;
import q4.n0;
import q4.q;
import q4.r;
import q4.s;
import q4.s0;
import q4.t;
import q4.t0;
import q4.z;
import r0.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends h0 implements s0 {
    public final u0 A;
    public final q B;
    public final int C;
    public final int[] D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1629p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public r f1630q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f1631r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1632s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f1633t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1634u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1635v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f1636w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1637x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1638y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public s f1639z;

    public LinearLayoutManager(int i) {
        this.f1629p = 1;
        this.f1633t = false;
        this.f1634u = false;
        this.f1635v = false;
        this.f1636w = true;
        this.f1637x = -1;
        this.f1638y = Integer.MIN_VALUE;
        this.f1639z = null;
        this.A = new u0();
        this.B = new q();
        this.C = 2;
        this.D = new int[2];
        d1(i);
        c(null);
        if (this.f1633t) {
            this.f1633t = false;
            p0();
        }
    }

    @Override // q4.h0
    public void B0(RecyclerView recyclerView, int i) {
        t tVar = new t(recyclerView.getContext());
        tVar.f10921a = i;
        C0(tVar);
    }

    @Override // q4.h0
    public boolean D0() {
        return this.f1639z == null && this.f1632s == this.f1635v;
    }

    public void E0(t0 t0Var, int[] iArr) {
        int i;
        int iN = t0Var.f10935a != -1 ? this.f1631r.n() : 0;
        if (this.f1630q.f == -1) {
            i = 0;
        } else {
            i = iN;
            iN = 0;
        }
        iArr[0] = iN;
        iArr[1] = i;
    }

    public void F0(t0 t0Var, r rVar, k kVar) {
        int i = rVar.f10905d;
        if (i < 0 || i >= t0Var.b()) {
            return;
        }
        kVar.b(i, Math.max(0, rVar.f10907g));
    }

    public final int G0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1631r;
        boolean z2 = !this.f1636w;
        return d.h(t0Var, hVar, N0(z2), M0(z2), this, this.f1636w);
    }

    public final int H0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1631r;
        boolean z2 = !this.f1636w;
        return d.i(t0Var, hVar, N0(z2), M0(z2), this, this.f1636w, this.f1634u);
    }

    public final int I0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1631r;
        boolean z2 = !this.f1636w;
        return d.j(t0Var, hVar, N0(z2), M0(z2), this, this.f1636w);
    }

    public final int J0(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f1629p == 1) ? 1 : Integer.MIN_VALUE : this.f1629p == 0 ? 1 : Integer.MIN_VALUE : this.f1629p == 1 ? -1 : Integer.MIN_VALUE : this.f1629p == 0 ? -1 : Integer.MIN_VALUE : (this.f1629p != 1 && W0()) ? -1 : 1 : (this.f1629p != 1 && W0()) ? 1 : -1;
    }

    @Override // q4.h0
    public final boolean K() {
        return true;
    }

    public final void K0() {
        if (this.f1630q == null) {
            r rVar = new r();
            rVar.f10902a = true;
            rVar.f10908h = 0;
            rVar.i = 0;
            rVar.f10910k = null;
            this.f1630q = rVar;
        }
    }

    @Override // q4.h0
    public final boolean L() {
        return this.f1633t;
    }

    public final int L0(n0 n0Var, r rVar, t0 t0Var, boolean z2) {
        int i;
        int i10 = rVar.f10904c;
        int i11 = rVar.f10907g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                rVar.f10907g = i11 + i10;
            }
            Z0(n0Var, rVar);
        }
        int i12 = rVar.f10904c + rVar.f10908h;
        while (true) {
            if ((!rVar.f10911l && i12 <= 0) || (i = rVar.f10905d) < 0 || i >= t0Var.b()) {
                break;
            }
            q qVar = this.B;
            qVar.f10897a = 0;
            qVar.f10898b = false;
            qVar.f10899c = false;
            qVar.f10900d = false;
            X0(n0Var, t0Var, rVar, qVar);
            if (!qVar.f10898b) {
                int i13 = rVar.f10903b;
                int i14 = qVar.f10897a;
                rVar.f10903b = (rVar.f * i14) + i13;
                if (!qVar.f10899c || rVar.f10910k != null || !t0Var.f10940g) {
                    rVar.f10904c -= i14;
                    i12 -= i14;
                }
                int i15 = rVar.f10907g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + i14;
                    rVar.f10907g = i16;
                    int i17 = rVar.f10904c;
                    if (i17 < 0) {
                        rVar.f10907g = i16 + i17;
                    }
                    Z0(n0Var, rVar);
                }
                if (z2 && qVar.f10900d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - rVar.f10904c;
    }

    public final View M0(boolean z2) {
        return this.f1634u ? Q0(0, v(), z2) : Q0(v() - 1, -1, z2);
    }

    public final View N0(boolean z2) {
        return this.f1634u ? Q0(v() - 1, -1, z2) : Q0(0, v(), z2);
    }

    public final int O0() {
        View viewQ0 = Q0(v() - 1, -1, false);
        if (viewQ0 == null) {
            return -1;
        }
        return h0.G(viewQ0);
    }

    public final View P0(int i, int i10) {
        int i11;
        int i12;
        K0();
        if (i10 <= i && i10 >= i) {
            return u(i);
        }
        if (this.f1631r.g(u(i)) < this.f1631r.m()) {
            i11 = 16644;
            i12 = 16388;
        } else {
            i11 = 4161;
            i12 = 4097;
        }
        return this.f1629p == 0 ? this.f10819c.c(i, i10, i11, i12) : this.f10820d.c(i, i10, i11, i12);
    }

    public final View Q0(int i, int i10, boolean z2) {
        K0();
        int i11 = z2 ? 24579 : 320;
        return this.f1629p == 0 ? this.f10819c.c(i, i10, i11, 320) : this.f10820d.c(i, i10, i11, 320);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View R0(q4.n0 r17, q4.t0 r18, boolean r19, boolean r20) {
        /*
            r16 = this;
            r0 = r16
            r0.K0()
            int r1 = r0.v()
            r2 = 0
            r3 = 1
            if (r20 == 0) goto L15
            int r1 = r0.v()
            int r1 = r1 - r3
            r4 = -1
            r5 = r4
            goto L18
        L15:
            r4 = r1
            r1 = r2
            r5 = r3
        L18:
            int r6 = r18.b()
            androidx.emoji2.text.h r7 = r0.f1631r
            int r7 = r7.m()
            androidx.emoji2.text.h r8 = r0.f1631r
            int r8 = r8.i()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = q4.h0.G(r12)
            androidx.emoji2.text.h r14 = r0.f1631r
            int r14 = r14.g(r12)
            androidx.emoji2.text.h r15 = r0.f1631r
            int r15 = r15.d(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            q4.i0 r13 = (q4.i0) r13
            q4.x0 r13 = r13.f10831a
            boolean r13 = r13.h()
            if (r13 == 0) goto L57
            if (r11 != 0) goto L7a
            r11 = r12
            goto L7a
        L57:
            if (r15 > r7) goto L5d
            if (r14 >= r7) goto L5d
            r13 = r3
            goto L5e
        L5d:
            r13 = r2
        L5e:
            if (r14 < r8) goto L64
            if (r15 <= r8) goto L64
            r14 = r3
            goto L65
        L64:
            r14 = r2
        L65:
            if (r13 != 0) goto L6b
            if (r14 == 0) goto L6a
            goto L6b
        L6a:
            return r12
        L6b:
            if (r19 == 0) goto L73
            if (r14 == 0) goto L70
            goto L75
        L70:
            if (r9 != 0) goto L7a
            goto L79
        L73:
            if (r13 == 0) goto L77
        L75:
            r10 = r12
            goto L7a
        L77:
            if (r9 != 0) goto L7a
        L79:
            r9 = r12
        L7a:
            int r1 = r1 + r5
            goto L2b
        L7c:
            if (r9 == 0) goto L7f
            return r9
        L7f:
            if (r10 == 0) goto L82
            return r10
        L82:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.R0(q4.n0, q4.t0, boolean, boolean):android.view.View");
    }

    public final int S0(int i, n0 n0Var, t0 t0Var, boolean z2) {
        int i10;
        int i11 = this.f1631r.i() - i;
        if (i11 <= 0) {
            return 0;
        }
        int i12 = -c1(-i11, n0Var, t0Var);
        int i13 = i + i12;
        if (!z2 || (i10 = this.f1631r.i() - i13) <= 0) {
            return i12;
        }
        this.f1631r.q(i10);
        return i10 + i12;
    }

    @Override // q4.h0
    public View T(View view, int i, n0 n0Var, t0 t0Var) {
        int iJ0;
        b1();
        if (v() != 0 && (iJ0 = J0(i)) != Integer.MIN_VALUE) {
            K0();
            f1(iJ0, (int) (this.f1631r.n() * 0.33333334f), false, t0Var);
            r rVar = this.f1630q;
            rVar.f10907g = Integer.MIN_VALUE;
            rVar.f10902a = false;
            L0(n0Var, rVar, t0Var, true);
            View viewP0 = iJ0 == -1 ? this.f1634u ? P0(v() - 1, -1) : P0(0, v()) : this.f1634u ? P0(0, v()) : P0(v() - 1, -1);
            View viewV0 = iJ0 == -1 ? V0() : U0();
            if (!viewV0.hasFocusable()) {
                return viewP0;
            }
            if (viewP0 != null) {
                return viewV0;
            }
        }
        return null;
    }

    public final int T0(int i, n0 n0Var, t0 t0Var, boolean z2) {
        int iM;
        int iM2 = i - this.f1631r.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i10 = -c1(iM2, n0Var, t0Var);
        int i11 = i + i10;
        if (!z2 || (iM = i11 - this.f1631r.m()) <= 0) {
            return i10;
        }
        this.f1631r.q(-iM);
        return i10 - iM;
    }

    @Override // q4.h0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            View viewQ0 = Q0(0, v(), false);
            accessibilityEvent.setFromIndex(viewQ0 == null ? -1 : h0.G(viewQ0));
            accessibilityEvent.setToIndex(O0());
        }
    }

    public final View U0() {
        return u(this.f1634u ? 0 : v() - 1);
    }

    @Override // q4.h0
    public void V(n0 n0Var, t0 t0Var, e eVar) {
        super.V(n0Var, t0Var, eVar);
        z zVar = this.f10818b.G;
        if (zVar == null || zVar.a() <= 0) {
            return;
        }
        eVar.b(r0.d.f11217m);
    }

    public final View V0() {
        return u(this.f1634u ? v() - 1 : 0);
    }

    public final boolean W0() {
        return this.f10818b.getLayoutDirection() == 1;
    }

    public void X0(n0 n0Var, t0 t0Var, r rVar, q qVar) {
        int iD;
        int i;
        int i10;
        int iF;
        View viewB = rVar.b(n0Var);
        if (viewB == null) {
            qVar.f10898b = true;
            return;
        }
        i0 i0Var = (i0) viewB.getLayoutParams();
        if (rVar.f10910k == null) {
            if (this.f1634u == (rVar.f == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (this.f1634u == (rVar.f == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        i0 i0Var2 = (i0) viewB.getLayoutParams();
        Rect rectN = this.f10818b.N(viewB);
        int i11 = rectN.left + rectN.right;
        int i12 = rectN.top + rectN.bottom;
        int iW = h0.w(d(), this.f10828n, this.f10826l, E() + D() + ((ViewGroup.MarginLayoutParams) i0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) i0Var2).rightMargin + i11, ((ViewGroup.MarginLayoutParams) i0Var2).width);
        int iW2 = h0.w(e(), this.f10829o, this.f10827m, C() + F() + ((ViewGroup.MarginLayoutParams) i0Var2).topMargin + ((ViewGroup.MarginLayoutParams) i0Var2).bottomMargin + i12, ((ViewGroup.MarginLayoutParams) i0Var2).height);
        if (y0(viewB, iW, iW2, i0Var2)) {
            viewB.measure(iW, iW2);
        }
        qVar.f10897a = this.f1631r.e(viewB);
        if (this.f1629p == 1) {
            if (W0()) {
                iF = this.f10828n - E();
                iD = iF - this.f1631r.f(viewB);
            } else {
                iD = D();
                iF = this.f1631r.f(viewB) + iD;
            }
            if (rVar.f == -1) {
                i = rVar.f10903b;
                i10 = i - qVar.f10897a;
            } else {
                i10 = rVar.f10903b;
                i = qVar.f10897a + i10;
            }
        } else {
            int iF2 = F();
            int iF3 = this.f1631r.f(viewB) + iF2;
            if (rVar.f == -1) {
                int i13 = rVar.f10903b;
                int i14 = i13 - qVar.f10897a;
                iF = i13;
                i = iF3;
                iD = i14;
                i10 = iF2;
            } else {
                int i15 = rVar.f10903b;
                int i16 = qVar.f10897a + i15;
                iD = i15;
                i = iF3;
                i10 = iF2;
                iF = i16;
            }
        }
        h0.N(viewB, iD, i10, iF, i);
        if (i0Var.f10831a.h() || i0Var.f10831a.k()) {
            qVar.f10899c = true;
        }
        qVar.f10900d = viewB.hasFocusable();
    }

    public final void Z0(n0 n0Var, r rVar) {
        if (!rVar.f10902a || rVar.f10911l) {
            return;
        }
        int i = rVar.f10907g;
        int i10 = rVar.i;
        if (rVar.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iH = (this.f1631r.h() - i) + i10;
            if (this.f1634u) {
                for (int i11 = 0; i11 < iV; i11++) {
                    View viewU = u(i11);
                    if (this.f1631r.g(viewU) < iH || this.f1631r.p(viewU) < iH) {
                        a1(n0Var, 0, i11);
                        return;
                    }
                }
                return;
            }
            int i12 = iV - 1;
            for (int i13 = i12; i13 >= 0; i13--) {
                View viewU2 = u(i13);
                if (this.f1631r.g(viewU2) < iH || this.f1631r.p(viewU2) < iH) {
                    a1(n0Var, i12, i13);
                    return;
                }
            }
            return;
        }
        if (i < 0) {
            return;
        }
        int i14 = i - i10;
        int iV2 = v();
        if (!this.f1634u) {
            for (int i15 = 0; i15 < iV2; i15++) {
                View viewU3 = u(i15);
                if (this.f1631r.d(viewU3) > i14 || this.f1631r.o(viewU3) > i14) {
                    a1(n0Var, 0, i15);
                    return;
                }
            }
            return;
        }
        int i16 = iV2 - 1;
        for (int i17 = i16; i17 >= 0; i17--) {
            View viewU4 = u(i17);
            if (this.f1631r.d(viewU4) > i14 || this.f1631r.o(viewU4) > i14) {
                a1(n0Var, i16, i17);
                return;
            }
        }
    }

    @Override // q4.s0
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i10 = (i < h0.G(u(0))) != this.f1634u ? -1 : 1;
        return this.f1629p == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }

    public final void a1(n0 n0Var, int i, int i10) {
        if (i == i10) {
            return;
        }
        if (i10 <= i) {
            while (i > i10) {
                View viewU = u(i);
                n0(i);
                n0Var.h(viewU);
                i--;
            }
            return;
        }
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            View viewU2 = u(i11);
            n0(i11);
            n0Var.h(viewU2);
        }
    }

    public final void b1() {
        if (this.f1629p == 1 || !W0()) {
            this.f1634u = this.f1633t;
        } else {
            this.f1634u = !this.f1633t;
        }
    }

    @Override // q4.h0
    public final void c(String str) {
        if (this.f1639z == null) {
            super.c(str);
        }
    }

    public final int c1(int i, n0 n0Var, t0 t0Var) {
        if (v() != 0 && i != 0) {
            K0();
            this.f1630q.f10902a = true;
            int i10 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            f1(i10, iAbs, true, t0Var);
            r rVar = this.f1630q;
            int iL0 = L0(n0Var, rVar, t0Var, false) + rVar.f10907g;
            if (iL0 >= 0) {
                if (iAbs > iL0) {
                    i = i10 * iL0;
                }
                this.f1631r.q(-i);
                this.f1630q.f10909j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // q4.h0
    public final boolean d() {
        return this.f1629p == 0;
    }

    public final void d1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(j.l("invalid orientation:", i));
        }
        c(null);
        if (i != this.f1629p || this.f1631r == null) {
            h hVarB = h.b(this, i);
            this.f1631r = hVarB;
            this.A.f = hVarB;
            this.f1629p = i;
            p0();
        }
    }

    @Override // q4.h0
    public final boolean e() {
        return this.f1629p == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0194  */
    @Override // q4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e0(q4.n0 r18, q4.t0 r19) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.e0(q4.n0, q4.t0):void");
    }

    public void e1(boolean z2) {
        c(null);
        if (this.f1635v == z2) {
            return;
        }
        this.f1635v = z2;
        p0();
    }

    @Override // q4.h0
    public void f0(t0 t0Var) {
        this.f1639z = null;
        this.f1637x = -1;
        this.f1638y = Integer.MIN_VALUE;
        this.A.g();
    }

    public final void f1(int i, int i10, boolean z2, t0 t0Var) {
        int iM;
        this.f1630q.f10911l = this.f1631r.k() == 0 && this.f1631r.h() == 0;
        this.f1630q.f = i;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        E0(t0Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z10 = i == 1;
        r rVar = this.f1630q;
        int i11 = z10 ? iMax2 : iMax;
        rVar.f10908h = i11;
        if (!z10) {
            iMax = iMax2;
        }
        rVar.i = iMax;
        if (z10) {
            rVar.f10908h = this.f1631r.j() + i11;
            View viewU0 = U0();
            r rVar2 = this.f1630q;
            rVar2.f10906e = this.f1634u ? -1 : 1;
            int iG = h0.G(viewU0);
            r rVar3 = this.f1630q;
            rVar2.f10905d = iG + rVar3.f10906e;
            rVar3.f10903b = this.f1631r.d(viewU0);
            iM = this.f1631r.d(viewU0) - this.f1631r.i();
        } else {
            View viewV0 = V0();
            r rVar4 = this.f1630q;
            rVar4.f10908h = this.f1631r.m() + rVar4.f10908h;
            r rVar5 = this.f1630q;
            rVar5.f10906e = this.f1634u ? 1 : -1;
            int iG2 = h0.G(viewV0);
            r rVar6 = this.f1630q;
            rVar5.f10905d = iG2 + rVar6.f10906e;
            rVar6.f10903b = this.f1631r.g(viewV0);
            iM = (-this.f1631r.g(viewV0)) + this.f1631r.m();
        }
        r rVar7 = this.f1630q;
        rVar7.f10904c = i10;
        if (z2) {
            rVar7.f10904c = i10 - iM;
        }
        rVar7.f10907g = iM;
    }

    @Override // q4.h0
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof s) {
            s sVar = (s) parcelable;
            this.f1639z = sVar;
            if (this.f1637x != -1) {
                sVar.f10918u = -1;
            }
            p0();
        }
    }

    public final void g1(int i, int i10) {
        this.f1630q.f10904c = this.f1631r.i() - i10;
        r rVar = this.f1630q;
        rVar.f10906e = this.f1634u ? -1 : 1;
        rVar.f10905d = i;
        rVar.f = 1;
        rVar.f10903b = i10;
        rVar.f10907g = Integer.MIN_VALUE;
    }

    @Override // q4.h0
    public final void h(int i, int i10, t0 t0Var, k kVar) {
        if (this.f1629p != 0) {
            i = i10;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        K0();
        f1(i > 0 ? 1 : -1, Math.abs(i), true, t0Var);
        F0(t0Var, this.f1630q, kVar);
    }

    @Override // q4.h0
    public final Parcelable h0() {
        s sVar = this.f1639z;
        if (sVar != null) {
            s sVar2 = new s();
            sVar2.f10918u = sVar.f10918u;
            sVar2.f10919v = sVar.f10919v;
            sVar2.f10920w = sVar.f10920w;
            return sVar2;
        }
        s sVar3 = new s();
        if (v() <= 0) {
            sVar3.f10918u = -1;
            return sVar3;
        }
        K0();
        boolean z2 = this.f1632s ^ this.f1634u;
        sVar3.f10920w = z2;
        if (z2) {
            View viewU0 = U0();
            sVar3.f10919v = this.f1631r.i() - this.f1631r.d(viewU0);
            sVar3.f10918u = h0.G(viewU0);
            return sVar3;
        }
        View viewV0 = V0();
        sVar3.f10918u = h0.G(viewV0);
        sVar3.f10919v = this.f1631r.g(viewV0) - this.f1631r.m();
        return sVar3;
    }

    public final void h1(int i, int i10) {
        this.f1630q.f10904c = i10 - this.f1631r.m();
        r rVar = this.f1630q;
        rVar.f10905d = i;
        rVar.f10906e = this.f1634u ? 1 : -1;
        rVar.f = -1;
        rVar.f10903b = i10;
        rVar.f10907g = Integer.MIN_VALUE;
    }

    @Override // q4.h0
    public final void i(int i, k kVar) {
        boolean z2;
        int i10;
        s sVar = this.f1639z;
        if (sVar == null || (i10 = sVar.f10918u) < 0) {
            b1();
            z2 = this.f1634u;
            i10 = this.f1637x;
            if (i10 == -1) {
                i10 = z2 ? i - 1 : 0;
            }
        } else {
            z2 = sVar.f10920w;
        }
        int i11 = z2 ? -1 : 1;
        for (int i12 = 0; i12 < this.C && i10 >= 0 && i10 < i; i12++) {
            kVar.b(i10, 0);
            i10 += i11;
        }
    }

    @Override // q4.h0
    public final int j(t0 t0Var) {
        return G0(t0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    @Override // q4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(int r5, android.os.Bundle r6) {
        /*
            r4 = this;
            boolean r0 = super.j0(r5, r6)
            r1 = 1
            if (r0 == 0) goto L8
            return r1
        L8:
            r0 = 16908343(0x1020037, float:2.3877383E-38)
            r2 = 0
            if (r5 != r0) goto L56
            if (r6 == 0) goto L56
            int r5 = r4.f1629p
            r0 = -1
            if (r5 != r1) goto L2e
            java.lang.String r5 = "android.view.accessibility.action.ARGUMENT_ROW_INT"
            int r5 = r6.getInt(r5, r0)
            if (r5 >= 0) goto L1e
            goto L56
        L1e:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f10818b
            q4.n0 r3 = r6.f1666w
            q4.t0 r6 = r6.A0
            int r6 = r4.I(r3, r6)
            int r6 = r6 - r1
            int r5 = java.lang.Math.min(r5, r6)
            goto L46
        L2e:
            java.lang.String r5 = "android.view.accessibility.action.ARGUMENT_COLUMN_INT"
            int r5 = r6.getInt(r5, r0)
            if (r5 >= 0) goto L37
            goto L56
        L37:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f10818b
            q4.n0 r3 = r6.f1666w
            q4.t0 r6 = r6.A0
            int r6 = r4.x(r3, r6)
            int r6 = r6 - r1
            int r5 = java.lang.Math.min(r5, r6)
        L46:
            if (r5 < 0) goto L56
            r4.f1637x = r5
            r4.f1638y = r2
            q4.s r5 = r4.f1639z
            if (r5 == 0) goto L52
            r5.f10918u = r0
        L52:
            r4.p0()
            return r1
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.j0(int, android.os.Bundle):boolean");
    }

    @Override // q4.h0
    public int k(t0 t0Var) {
        return H0(t0Var);
    }

    @Override // q4.h0
    public int l(t0 t0Var) {
        return I0(t0Var);
    }

    @Override // q4.h0
    public final int m(t0 t0Var) {
        return G0(t0Var);
    }

    @Override // q4.h0
    public int n(t0 t0Var) {
        return H0(t0Var);
    }

    @Override // q4.h0
    public int o(t0 t0Var) {
        return I0(t0Var);
    }

    @Override // q4.h0
    public final View q(int i) {
        int iV = v();
        if (iV == 0) {
            return null;
        }
        int iG = i - h0.G(u(0));
        if (iG >= 0 && iG < iV) {
            View viewU = u(iG);
            if (h0.G(viewU) == i) {
                return viewU;
            }
        }
        return super.q(i);
    }

    @Override // q4.h0
    public int q0(int i, n0 n0Var, t0 t0Var) {
        if (this.f1629p == 1) {
            return 0;
        }
        return c1(i, n0Var, t0Var);
    }

    @Override // q4.h0
    public i0 r() {
        return new i0(-2, -2);
    }

    @Override // q4.h0
    public final void r0(int i) {
        this.f1637x = i;
        this.f1638y = Integer.MIN_VALUE;
        s sVar = this.f1639z;
        if (sVar != null) {
            sVar.f10918u = -1;
        }
        p0();
    }

    @Override // q4.h0
    public int s0(int i, n0 n0Var, t0 t0Var) {
        if (this.f1629p == 0) {
            return 0;
        }
        return c1(i, n0Var, t0Var);
    }

    @Override // q4.h0
    public final boolean z0() {
        if (this.f10827m != 1073741824 && this.f10826l != 1073741824) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                ViewGroup.LayoutParams layoutParams = u(i).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressLint({"UnknownNullness"})
    public LinearLayoutManager(Context context, AttributeSet attributeSet, int i, int i10) {
        this.f1629p = 1;
        this.f1633t = false;
        this.f1634u = false;
        this.f1635v = false;
        this.f1636w = true;
        this.f1637x = -1;
        this.f1638y = Integer.MIN_VALUE;
        this.f1639z = null;
        this.A = new u0();
        this.B = new q();
        this.C = 2;
        this.D = new int[2];
        g0 g0VarH = h0.H(context, attributeSet, i, i10);
        d1(g0VarH.f10797a);
        boolean z2 = g0VarH.f10799c;
        c(null);
        if (z2 != this.f1633t) {
            this.f1633t = z2;
            p0();
        }
        e1(g0VarH.f10800d);
    }

    @Override // q4.h0
    public final void S(RecyclerView recyclerView) {
    }

    public void Y0(n0 n0Var, t0 t0Var, u0 u0Var, int i) {
    }
}
