package androidx.recyclerview.widget;

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
import g2.l0;
import u0.c;
import u0.e;
import u8.a;
import v.g;
import v4.g0;
import v4.h0;
import v4.i0;
import v4.n0;
import v4.p;
import v4.q;
import v4.r;
import v4.s;
import v4.s0;
import v4.t0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class LinearLayoutManager extends h0 implements s0 {
    public final l0 A;
    public final p B;
    public final int C;
    public final int[] D;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public int f1412p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public q f1413q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public h f1414r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public boolean f1415s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final boolean f1416t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public boolean f1417u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f1418v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final boolean f1419w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public int f1420x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f1421y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public r f1422z;

    public LinearLayoutManager(int i) {
        this.f1412p = 1;
        this.f1416t = false;
        this.f1417u = false;
        this.f1418v = false;
        this.f1419w = true;
        this.f1420x = -1;
        this.f1421y = Integer.MIN_VALUE;
        this.f1422z = null;
        this.A = new l0();
        this.B = new p();
        this.C = 2;
        this.D = new int[2];
        d1(i);
        c(null);
        if (this.f1416t) {
            this.f1416t = false;
            p0();
        }
    }

    @Override // v4.h0
    public void B0(RecyclerView recyclerView, int i) {
        s sVar = new s(recyclerView.getContext());
        sVar.f13346a = i;
        C0(sVar);
    }

    @Override // v4.h0
    public boolean D0() {
        return this.f1422z == null && this.f1415s == this.f1418v;
    }

    public void E0(t0 t0Var, int[] iArr) {
        int i;
        int iN = t0Var.f13361a != -1 ? this.f1414r.n() : 0;
        if (this.f1413q.f == -1) {
            i = 0;
        } else {
            i = iN;
            iN = 0;
        }
        iArr[0] = iN;
        iArr[1] = i;
    }

    public void F0(t0 t0Var, q qVar, g gVar) {
        int i = qVar.f13329d;
        if (i < 0 || i >= t0Var.b()) {
            return;
        }
        gVar.b(i, Math.max(0, qVar.f13331g));
    }

    public final int G0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1414r;
        boolean z10 = !this.f1419w;
        return a.h(t0Var, hVar, N0(z10), M0(z10), this, this.f1419w);
    }

    public final int H0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1414r;
        boolean z10 = !this.f1419w;
        return a.i(t0Var, hVar, N0(z10), M0(z10), this, this.f1419w, this.f1417u);
    }

    public final int I0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        K0();
        h hVar = this.f1414r;
        boolean z10 = !this.f1419w;
        return a.j(t0Var, hVar, N0(z10), M0(z10), this, this.f1419w);
    }

    public final int J0(int i) {
        return i != 1 ? i != 2 ? i != 17 ? i != 33 ? i != 66 ? (i == 130 && this.f1412p == 1) ? 1 : Integer.MIN_VALUE : this.f1412p == 0 ? 1 : Integer.MIN_VALUE : this.f1412p == 1 ? -1 : Integer.MIN_VALUE : this.f1412p == 0 ? -1 : Integer.MIN_VALUE : (this.f1412p != 1 && W0()) ? -1 : 1 : (this.f1412p != 1 && W0()) ? 1 : -1;
    }

    @Override // v4.h0
    public final boolean K() {
        return true;
    }

    public final void K0() {
        if (this.f1413q == null) {
            q qVar = new q();
            qVar.f13326a = true;
            qVar.f13332h = 0;
            qVar.i = 0;
            qVar.f13334k = null;
            this.f1413q = qVar;
        }
    }

    @Override // v4.h0
    public final boolean L() {
        return this.f1416t;
    }

    public final int L0(n0 n0Var, q qVar, t0 t0Var, boolean z10) {
        int i;
        int i10 = qVar.f13328c;
        int i11 = qVar.f13331g;
        if (i11 != Integer.MIN_VALUE) {
            if (i10 < 0) {
                qVar.f13331g = i11 + i10;
            }
            Z0(n0Var, qVar);
        }
        int i12 = qVar.f13328c + qVar.f13332h;
        while (true) {
            if ((!qVar.f13335l && i12 <= 0) || (i = qVar.f13329d) < 0 || i >= t0Var.b()) {
                break;
            }
            p pVar = this.B;
            pVar.f13321a = 0;
            pVar.f13322b = false;
            pVar.f13323c = false;
            pVar.f13324d = false;
            X0(n0Var, t0Var, qVar, pVar);
            if (!pVar.f13322b) {
                int i13 = qVar.f13327b;
                int i14 = pVar.f13321a;
                qVar.f13327b = (qVar.f * i14) + i13;
                if (!pVar.f13323c || qVar.f13334k != null || !t0Var.f13366g) {
                    qVar.f13328c -= i14;
                    i12 -= i14;
                }
                int i15 = qVar.f13331g;
                if (i15 != Integer.MIN_VALUE) {
                    int i16 = i15 + i14;
                    qVar.f13331g = i16;
                    int i17 = qVar.f13328c;
                    if (i17 < 0) {
                        qVar.f13331g = i16 + i17;
                    }
                    Z0(n0Var, qVar);
                }
                if (z10 && pVar.f13324d) {
                    break;
                }
            } else {
                break;
            }
        }
        return i10 - qVar.f13328c;
    }

    public final View M0(boolean z10) {
        return this.f1417u ? Q0(0, v(), z10) : Q0(v() - 1, -1, z10);
    }

    public final View N0(boolean z10) {
        return this.f1417u ? Q0(v() - 1, -1, z10) : Q0(0, v(), z10);
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
        if (this.f1414r.g(u(i)) < this.f1414r.m()) {
            i11 = 16644;
            i12 = 16388;
        } else {
            i11 = 4161;
            i12 = 4097;
        }
        return this.f1412p == 0 ? this.f13249c.C(i, i10, i11, i12) : this.f13250d.C(i, i10, i11, i12);
    }

    public final View Q0(int i, int i10, boolean z10) {
        K0();
        int i11 = z10 ? 24579 : 320;
        return this.f1412p == 0 ? this.f13249c.C(i, i10, i11, 320) : this.f13250d.C(i, i10, i11, 320);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.View R0(v4.n0 r17, v4.t0 r18, boolean r19, boolean r20) {
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
            androidx.emoji2.text.h r7 = r0.f1414r
            int r7 = r7.m()
            androidx.emoji2.text.h r8 = r0.f1414r
            int r8 = r8.i()
            r9 = 0
            r10 = r9
            r11 = r10
        L2b:
            if (r1 == r4) goto L7c
            android.view.View r12 = r0.u(r1)
            int r13 = v4.h0.G(r12)
            androidx.emoji2.text.h r14 = r0.f1414r
            int r14 = r14.g(r12)
            androidx.emoji2.text.h r15 = r0.f1414r
            int r15 = r15.d(r12)
            if (r13 < 0) goto L7a
            if (r13 >= r6) goto L7a
            android.view.ViewGroup$LayoutParams r13 = r12.getLayoutParams()
            v4.i0 r13 = (v4.i0) r13
            v4.x0 r13 = r13.f13261a
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
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.R0(v4.n0, v4.t0, boolean, boolean):android.view.View");
    }

    public final int S0(int i, n0 n0Var, t0 t0Var, boolean z10) {
        int i10;
        int i11 = this.f1414r.i() - i;
        if (i11 <= 0) {
            return 0;
        }
        int i12 = -c1(-i11, n0Var, t0Var);
        int i13 = i + i12;
        if (!z10 || (i10 = this.f1414r.i() - i13) <= 0) {
            return i12;
        }
        this.f1414r.q(i10);
        return i10 + i12;
    }

    @Override // v4.h0
    public View T(View view, int i, n0 n0Var, t0 t0Var) {
        int iJ0;
        b1();
        if (v() != 0 && (iJ0 = J0(i)) != Integer.MIN_VALUE) {
            K0();
            f1(iJ0, (int) (this.f1414r.n() * 0.33333334f), false, t0Var);
            q qVar = this.f1413q;
            qVar.f13331g = Integer.MIN_VALUE;
            qVar.f13326a = false;
            L0(n0Var, qVar, t0Var, true);
            View viewP0 = iJ0 == -1 ? this.f1417u ? P0(v() - 1, -1) : P0(0, v()) : this.f1417u ? P0(0, v()) : P0(v() - 1, -1);
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

    public final int T0(int i, n0 n0Var, t0 t0Var, boolean z10) {
        int iM;
        int iM2 = i - this.f1414r.m();
        if (iM2 <= 0) {
            return 0;
        }
        int i10 = -c1(iM2, n0Var, t0Var);
        int i11 = i + i10;
        if (!z10 || (iM = i11 - this.f1414r.m()) <= 0) {
            return i10;
        }
        this.f1414r.q(-iM);
        return i10 - iM;
    }

    @Override // v4.h0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            View viewQ0 = Q0(0, v(), false);
            accessibilityEvent.setFromIndex(viewQ0 == null ? -1 : h0.G(viewQ0));
            accessibilityEvent.setToIndex(O0());
        }
    }

    public final View U0() {
        return u(this.f1417u ? 0 : v() - 1);
    }

    @Override // v4.h0
    public void V(n0 n0Var, t0 t0Var, e eVar) {
        super.V(n0Var, t0Var, eVar);
        z zVar = this.f13248b.H;
        if (zVar == null || zVar.a() <= 0) {
            return;
        }
        eVar.b(c.f12052m);
    }

    public final View V0() {
        return u(this.f1417u ? v() - 1 : 0);
    }

    public final boolean W0() {
        return this.f13248b.getLayoutDirection() == 1;
    }

    public void X0(n0 n0Var, t0 t0Var, q qVar, p pVar) {
        int iD;
        int i;
        int i10;
        int iF;
        View viewB = qVar.b(n0Var);
        if (viewB == null) {
            pVar.f13322b = true;
            return;
        }
        i0 i0Var = (i0) viewB.getLayoutParams();
        if (qVar.f13334k == null) {
            if (this.f1417u == (qVar.f == -1)) {
                b(viewB, -1, false);
            } else {
                b(viewB, 0, false);
            }
        } else {
            if (this.f1417u == (qVar.f == -1)) {
                b(viewB, -1, true);
            } else {
                b(viewB, 0, true);
            }
        }
        i0 i0Var2 = (i0) viewB.getLayoutParams();
        Rect rectN = this.f13248b.N(viewB);
        int i11 = rectN.left + rectN.right;
        int i12 = rectN.top + rectN.bottom;
        int iW = h0.w(d(), this.f13258n, this.f13256l, E() + D() + ((ViewGroup.MarginLayoutParams) i0Var2).leftMargin + ((ViewGroup.MarginLayoutParams) i0Var2).rightMargin + i11, ((ViewGroup.MarginLayoutParams) i0Var2).width);
        int iW2 = h0.w(e(), this.f13259o, this.f13257m, C() + F() + ((ViewGroup.MarginLayoutParams) i0Var2).topMargin + ((ViewGroup.MarginLayoutParams) i0Var2).bottomMargin + i12, ((ViewGroup.MarginLayoutParams) i0Var2).height);
        if (y0(viewB, iW, iW2, i0Var2)) {
            viewB.measure(iW, iW2);
        }
        pVar.f13321a = this.f1414r.e(viewB);
        if (this.f1412p == 1) {
            if (W0()) {
                iF = this.f13258n - E();
                iD = iF - this.f1414r.f(viewB);
            } else {
                iD = D();
                iF = this.f1414r.f(viewB) + iD;
            }
            if (qVar.f == -1) {
                i = qVar.f13327b;
                i10 = i - pVar.f13321a;
            } else {
                i10 = qVar.f13327b;
                i = pVar.f13321a + i10;
            }
        } else {
            int iF2 = F();
            int iF3 = this.f1414r.f(viewB) + iF2;
            if (qVar.f == -1) {
                int i13 = qVar.f13327b;
                int i14 = i13 - pVar.f13321a;
                iF = i13;
                i = iF3;
                iD = i14;
                i10 = iF2;
            } else {
                int i15 = qVar.f13327b;
                int i16 = pVar.f13321a + i15;
                iD = i15;
                i = iF3;
                i10 = iF2;
                iF = i16;
            }
        }
        h0.N(viewB, iD, i10, iF, i);
        if (i0Var.f13261a.h() || i0Var.f13261a.k()) {
            pVar.f13323c = true;
        }
        pVar.f13324d = viewB.hasFocusable();
    }

    public final void Z0(n0 n0Var, q qVar) {
        if (!qVar.f13326a || qVar.f13335l) {
            return;
        }
        int i = qVar.f13331g;
        int i10 = qVar.i;
        if (qVar.f == -1) {
            int iV = v();
            if (i < 0) {
                return;
            }
            int iH = (this.f1414r.h() - i) + i10;
            if (this.f1417u) {
                for (int i11 = 0; i11 < iV; i11++) {
                    View viewU = u(i11);
                    if (this.f1414r.g(viewU) < iH || this.f1414r.p(viewU) < iH) {
                        a1(n0Var, 0, i11);
                        return;
                    }
                }
                return;
            }
            int i12 = iV - 1;
            for (int i13 = i12; i13 >= 0; i13--) {
                View viewU2 = u(i13);
                if (this.f1414r.g(viewU2) < iH || this.f1414r.p(viewU2) < iH) {
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
        if (!this.f1417u) {
            for (int i15 = 0; i15 < iV2; i15++) {
                View viewU3 = u(i15);
                if (this.f1414r.d(viewU3) > i14 || this.f1414r.o(viewU3) > i14) {
                    a1(n0Var, 0, i15);
                    return;
                }
            }
            return;
        }
        int i16 = iV2 - 1;
        for (int i17 = i16; i17 >= 0; i17--) {
            View viewU4 = u(i17);
            if (this.f1414r.d(viewU4) > i14 || this.f1414r.o(viewU4) > i14) {
                a1(n0Var, i16, i17);
                return;
            }
        }
    }

    @Override // v4.s0
    public final PointF a(int i) {
        if (v() == 0) {
            return null;
        }
        int i10 = (i < h0.G(u(0))) != this.f1417u ? -1 : 1;
        return this.f1412p == 0 ? new PointF(i10, 0.0f) : new PointF(0.0f, i10);
    }

    public final void a1(n0 n0Var, int i, int i10) {
        if (i == i10) {
            return;
        }
        if (i10 <= i) {
            while (i > i10) {
                View viewU = u(i);
                n0(i);
                n0Var.i(viewU);
                i--;
            }
            return;
        }
        for (int i11 = i10 - 1; i11 >= i; i11--) {
            View viewU2 = u(i11);
            n0(i11);
            n0Var.i(viewU2);
        }
    }

    public final void b1() {
        if (this.f1412p == 1 || !W0()) {
            this.f1417u = this.f1416t;
        } else {
            this.f1417u = !this.f1416t;
        }
    }

    @Override // v4.h0
    public final void c(String str) {
        if (this.f1422z == null) {
            super.c(str);
        }
    }

    public final int c1(int i, n0 n0Var, t0 t0Var) {
        if (v() != 0 && i != 0) {
            K0();
            this.f1413q.f13326a = true;
            int i10 = i > 0 ? 1 : -1;
            int iAbs = Math.abs(i);
            f1(i10, iAbs, true, t0Var);
            q qVar = this.f1413q;
            int iL0 = L0(n0Var, qVar, t0Var, false) + qVar.f13331g;
            if (iL0 >= 0) {
                if (iAbs > iL0) {
                    i = i10 * iL0;
                }
                this.f1414r.q(-i);
                this.f1413q.f13333j = i;
                return i;
            }
        }
        return 0;
    }

    @Override // v4.h0
    public final boolean d() {
        return this.f1412p == 0;
    }

    public final void d1(int i) {
        if (i != 0 && i != 1) {
            throw new IllegalArgumentException(l0.e.g(i, "invalid orientation:"));
        }
        c(null);
        if (i != this.f1412p || this.f1414r == null) {
            h hVarB = h.b(this, i);
            this.f1414r = hVarB;
            this.A.f = hVarB;
            this.f1412p = i;
            p0();
        }
    }

    @Override // v4.h0
    public final boolean e() {
        return this.f1412p == 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:111:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0194  */
    @Override // v4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e0(v4.n0 r18, v4.t0 r19) {
        /*
            Method dump skipped, instruction units count: 1085
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.e0(v4.n0, v4.t0):void");
    }

    public void e1(boolean z10) {
        c(null);
        if (this.f1418v == z10) {
            return;
        }
        this.f1418v = z10;
        p0();
    }

    @Override // v4.h0
    public void f0(t0 t0Var) {
        this.f1422z = null;
        this.f1420x = -1;
        this.f1421y = Integer.MIN_VALUE;
        this.A.g();
    }

    public final void f1(int i, int i10, boolean z10, t0 t0Var) {
        int iM;
        this.f1413q.f13335l = this.f1414r.k() == 0 && this.f1414r.h() == 0;
        this.f1413q.f = i;
        int[] iArr = this.D;
        iArr[0] = 0;
        iArr[1] = 0;
        E0(t0Var, iArr);
        int iMax = Math.max(0, iArr[0]);
        int iMax2 = Math.max(0, iArr[1]);
        boolean z11 = i == 1;
        q qVar = this.f1413q;
        int i11 = z11 ? iMax2 : iMax;
        qVar.f13332h = i11;
        if (!z11) {
            iMax = iMax2;
        }
        qVar.i = iMax;
        if (z11) {
            qVar.f13332h = this.f1414r.j() + i11;
            View viewU0 = U0();
            q qVar2 = this.f1413q;
            qVar2.f13330e = this.f1417u ? -1 : 1;
            int iG = h0.G(viewU0);
            q qVar3 = this.f1413q;
            qVar2.f13329d = iG + qVar3.f13330e;
            qVar3.f13327b = this.f1414r.d(viewU0);
            iM = this.f1414r.d(viewU0) - this.f1414r.i();
        } else {
            View viewV0 = V0();
            q qVar4 = this.f1413q;
            qVar4.f13332h = this.f1414r.m() + qVar4.f13332h;
            q qVar5 = this.f1413q;
            qVar5.f13330e = this.f1417u ? 1 : -1;
            int iG2 = h0.G(viewV0);
            q qVar6 = this.f1413q;
            qVar5.f13329d = iG2 + qVar6.f13330e;
            qVar6.f13327b = this.f1414r.g(viewV0);
            iM = (-this.f1414r.g(viewV0)) + this.f1414r.m();
        }
        q qVar7 = this.f1413q;
        qVar7.f13328c = i10;
        if (z10) {
            qVar7.f13328c = i10 - iM;
        }
        qVar7.f13331g = iM;
    }

    @Override // v4.h0
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof r) {
            r rVar = (r) parcelable;
            this.f1422z = rVar;
            if (this.f1420x != -1) {
                rVar.f13337v = -1;
            }
            p0();
        }
    }

    public final void g1(int i, int i10) {
        this.f1413q.f13328c = this.f1414r.i() - i10;
        q qVar = this.f1413q;
        qVar.f13330e = this.f1417u ? -1 : 1;
        qVar.f13329d = i;
        qVar.f = 1;
        qVar.f13327b = i10;
        qVar.f13331g = Integer.MIN_VALUE;
    }

    @Override // v4.h0
    public final void h(int i, int i10, t0 t0Var, g gVar) {
        if (this.f1412p != 0) {
            i = i10;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        K0();
        f1(i > 0 ? 1 : -1, Math.abs(i), true, t0Var);
        F0(t0Var, this.f1413q, gVar);
    }

    @Override // v4.h0
    public final Parcelable h0() {
        r rVar = this.f1422z;
        if (rVar != null) {
            r rVar2 = new r();
            rVar2.f13337v = rVar.f13337v;
            rVar2.f13338w = rVar.f13338w;
            rVar2.f13339x = rVar.f13339x;
            return rVar2;
        }
        r rVar3 = new r();
        if (v() <= 0) {
            rVar3.f13337v = -1;
            return rVar3;
        }
        K0();
        boolean z10 = this.f1415s ^ this.f1417u;
        rVar3.f13339x = z10;
        if (z10) {
            View viewU0 = U0();
            rVar3.f13338w = this.f1414r.i() - this.f1414r.d(viewU0);
            rVar3.f13337v = h0.G(viewU0);
            return rVar3;
        }
        View viewV0 = V0();
        rVar3.f13337v = h0.G(viewV0);
        rVar3.f13338w = this.f1414r.g(viewV0) - this.f1414r.m();
        return rVar3;
    }

    public final void h1(int i, int i10) {
        this.f1413q.f13328c = i10 - this.f1414r.m();
        q qVar = this.f1413q;
        qVar.f13329d = i;
        qVar.f13330e = this.f1417u ? 1 : -1;
        qVar.f = -1;
        qVar.f13327b = i10;
        qVar.f13331g = Integer.MIN_VALUE;
    }

    @Override // v4.h0
    public final void i(int i, g gVar) {
        boolean z10;
        int i10;
        r rVar = this.f1422z;
        if (rVar == null || (i10 = rVar.f13337v) < 0) {
            b1();
            z10 = this.f1417u;
            i10 = this.f1420x;
            if (i10 == -1) {
                i10 = z10 ? i - 1 : 0;
            }
        } else {
            z10 = rVar.f13339x;
        }
        int i11 = z10 ? -1 : 1;
        for (int i12 = 0; i12 < this.C && i10 >= 0 && i10 < i; i12++) {
            gVar.b(i10, 0);
            i10 += i11;
        }
    }

    @Override // v4.h0
    public final int j(t0 t0Var) {
        return G0(t0Var);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0048  */
    @Override // v4.h0
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
            int r5 = r4.f1412p
            r0 = -1
            if (r5 != r1) goto L2e
            java.lang.String r5 = "android.view.accessibility.action.ARGUMENT_ROW_INT"
            int r5 = r6.getInt(r5, r0)
            if (r5 >= 0) goto L1e
            goto L56
        L1e:
            androidx.recyclerview.widget.RecyclerView r6 = r4.f13248b
            v4.n0 r3 = r6.f1451x
            v4.t0 r6 = r6.B0
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
            androidx.recyclerview.widget.RecyclerView r6 = r4.f13248b
            v4.n0 r3 = r6.f1451x
            v4.t0 r6 = r6.B0
            int r6 = r4.x(r3, r6)
            int r6 = r6 - r1
            int r5 = java.lang.Math.min(r5, r6)
        L46:
            if (r5 < 0) goto L56
            r4.f1420x = r5
            r4.f1421y = r2
            v4.r r5 = r4.f1422z
            if (r5 == 0) goto L52
            r5.f13337v = r0
        L52:
            r4.p0()
            return r1
        L56:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.LinearLayoutManager.j0(int, android.os.Bundle):boolean");
    }

    @Override // v4.h0
    public int k(t0 t0Var) {
        return H0(t0Var);
    }

    @Override // v4.h0
    public int l(t0 t0Var) {
        return I0(t0Var);
    }

    @Override // v4.h0
    public final int m(t0 t0Var) {
        return G0(t0Var);
    }

    @Override // v4.h0
    public int n(t0 t0Var) {
        return H0(t0Var);
    }

    @Override // v4.h0
    public int o(t0 t0Var) {
        return I0(t0Var);
    }

    @Override // v4.h0
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

    @Override // v4.h0
    public int q0(int i, n0 n0Var, t0 t0Var) {
        if (this.f1412p == 1) {
            return 0;
        }
        return c1(i, n0Var, t0Var);
    }

    @Override // v4.h0
    public i0 r() {
        return new i0(-2, -2);
    }

    @Override // v4.h0
    public final void r0(int i) {
        this.f1420x = i;
        this.f1421y = Integer.MIN_VALUE;
        r rVar = this.f1422z;
        if (rVar != null) {
            rVar.f13337v = -1;
        }
        p0();
    }

    @Override // v4.h0
    public int s0(int i, n0 n0Var, t0 t0Var) {
        if (this.f1412p == 0) {
            return 0;
        }
        return c1(i, n0Var, t0Var);
    }

    @Override // v4.h0
    public final boolean z0() {
        if (this.f13257m != 1073741824 && this.f13256l != 1073741824) {
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
        this.f1412p = 1;
        this.f1416t = false;
        this.f1417u = false;
        this.f1418v = false;
        this.f1419w = true;
        this.f1420x = -1;
        this.f1421y = Integer.MIN_VALUE;
        this.f1422z = null;
        this.A = new l0();
        this.B = new p();
        this.C = 2;
        this.D = new int[2];
        g0 g0VarH = h0.H(context, attributeSet, i, i10);
        d1(g0VarH.f13231a);
        boolean z10 = g0VarH.f13233c;
        c(null);
        if (z10 != this.f1416t) {
            this.f1416t = z10;
            p0();
        }
        e1(g0VarH.f13234d);
    }

    @Override // v4.h0
    public final void S(RecyclerView recyclerView) {
    }

    public void Y0(n0 n0Var, t0 t0Var, l0 l0Var, int i) {
    }
}
