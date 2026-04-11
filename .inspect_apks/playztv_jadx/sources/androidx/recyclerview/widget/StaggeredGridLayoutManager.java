package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.h;
import androidx.fragment.app.e;
import cf.d;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import p2.c;
import q0.o0;
import q4.a1;
import q4.b1;
import q4.d1;
import q4.e1;
import q4.g0;
import q4.h0;
import q4.i0;
import q4.k;
import q4.n0;
import q4.p;
import q4.s0;
import q4.t;
import q4.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends h0 implements s0 {
    public final c B;
    public final int C;
    public boolean D;
    public boolean E;
    public d1 F;
    public final Rect G;
    public final a1 H;
    public final boolean I;
    public int[] J;
    public final e K;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1674p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final e1[] f1675q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f1676r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f1677s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f1678t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1679u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p f1680v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1681w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final BitSet f1683y;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1682x = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1684z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i10) {
        this.f1674p = -1;
        this.f1681w = false;
        c cVar = new c(4, false);
        this.B = cVar;
        this.C = 2;
        this.G = new Rect();
        this.H = new a1(this);
        this.I = true;
        this.K = new e(20, this);
        g0 g0VarH = h0.H(context, attributeSet, i, i10);
        int i11 = g0VarH.f10797a;
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i11 != this.f1678t) {
            this.f1678t = i11;
            h hVar = this.f1676r;
            this.f1676r = this.f1677s;
            this.f1677s = hVar;
            p0();
        }
        int i12 = g0VarH.f10798b;
        c(null);
        if (i12 != this.f1674p) {
            cVar.f();
            p0();
            this.f1674p = i12;
            this.f1683y = new BitSet(this.f1674p);
            this.f1675q = new e1[this.f1674p];
            for (int i13 = 0; i13 < this.f1674p; i13++) {
                this.f1675q[i13] = new e1(this, i13);
            }
            p0();
        }
        boolean z2 = g0VarH.f10799c;
        c(null);
        d1 d1Var = this.F;
        if (d1Var != null && d1Var.B != z2) {
            d1Var.B = z2;
        }
        this.f1681w = z2;
        p0();
        p pVar = new p();
        pVar.f10889a = true;
        pVar.f = 0;
        pVar.f10894g = 0;
        this.f1680v = pVar;
        this.f1676r = h.b(this, this.f1678t);
        this.f1677s = h.b(this, 1 - this.f1678t);
    }

    public static int e1(int i, int i10, int i11) {
        int mode;
        return (!(i10 == 0 && i11 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i10) - i11), mode) : i;
    }

    @Override // q4.h0
    public final void B0(RecyclerView recyclerView, int i) {
        t tVar = new t(recyclerView.getContext());
        tVar.f10921a = i;
        C0(tVar);
    }

    @Override // q4.h0
    public final boolean D0() {
        return this.F == null;
    }

    public final boolean E0() {
        int iL0;
        if (v() != 0 && this.C != 0 && this.f10822g) {
            if (this.f1682x) {
                iL0 = M0();
                L0();
            } else {
                iL0 = L0();
                M0();
            }
            if (iL0 == 0 && Q0() != null) {
                this.B.f();
                this.f = true;
                p0();
                return true;
            }
        }
        return false;
    }

    public final int F0(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z2 = !this.I;
        return d.i(t0Var, this.f1676r, I0(z2), H0(z2), this, this.I, this.f1682x);
    }

    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    public final int G0(n0 n0Var, p pVar, t0 t0Var) {
        e1 e1Var;
        ?? r82;
        int iJ;
        int iE;
        int iM;
        int iE2;
        int i;
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 1;
        this.f1683y.set(0, this.f1674p, true);
        p pVar2 = this.f1680v;
        int i14 = pVar2.i ? pVar.f10893e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : pVar.f10893e == 1 ? pVar.f10894g + pVar.f10890b : pVar.f - pVar.f10890b;
        int i15 = pVar.f10893e;
        for (int i16 = 0; i16 < this.f1674p; i16++) {
            if (!((ArrayList) this.f1675q[i16].f).isEmpty()) {
                d1(this.f1675q[i16], i15, i14);
            }
        }
        int i17 = this.f1682x ? this.f1676r.i() : this.f1676r.m();
        boolean z2 = false;
        while (true) {
            int i18 = pVar.f10891c;
            if (i18 < 0 || i18 >= t0Var.b() || (!pVar2.i && this.f1683y.isEmpty())) {
                break;
            }
            View view = n0Var.k(pVar.f10891c, Long.MAX_VALUE).f10962a;
            pVar.f10891c += pVar.f10892d;
            b1 b1Var = (b1) view.getLayoutParams();
            int iB = b1Var.f10831a.b();
            c cVar = this.B;
            int[] iArr = (int[]) cVar.f10130v;
            int i19 = (iArr == null || iB >= iArr.length) ? -1 : iArr[iB];
            if (i19 == -1) {
                if (U0(pVar.f10893e)) {
                    i11 = this.f1674p - i13;
                    i10 = -1;
                    i = -1;
                } else {
                    i = i13;
                    i10 = this.f1674p;
                    i11 = i12;
                }
                e1 e1Var2 = null;
                if (pVar.f10893e == i13) {
                    int iM2 = this.f1676r.m();
                    int i20 = Integer.MAX_VALUE;
                    while (i11 != i10) {
                        e1 e1Var3 = this.f1675q[i11];
                        int iH = e1Var3.h(iM2);
                        if (iH < i20) {
                            i20 = iH;
                            e1Var2 = e1Var3;
                        }
                        i11 += i;
                    }
                } else {
                    int i21 = this.f1676r.i();
                    int i22 = Integer.MIN_VALUE;
                    while (i11 != i10) {
                        e1 e1Var4 = this.f1675q[i11];
                        int iJ2 = e1Var4.j(i21);
                        if (iJ2 > i22) {
                            e1Var2 = e1Var4;
                            i22 = iJ2;
                        }
                        i11 += i;
                    }
                }
                e1Var = e1Var2;
                cVar.h(iB);
                ((int[]) cVar.f10130v)[iB] = e1Var.f10785e;
            } else {
                e1Var = this.f1675q[i19];
            }
            b1Var.f10750e = e1Var;
            if (pVar.f10893e == 1) {
                r82 = 0;
                b(view, -1, false);
            } else {
                r82 = 0;
                b(view, 0, false);
            }
            if (this.f1678t == 1) {
                S0(view, h0.w(r82, this.f1679u, this.f10826l, r82, ((ViewGroup.MarginLayoutParams) b1Var).width), h0.w(true, this.f10829o, this.f10827m, C() + F(), ((ViewGroup.MarginLayoutParams) b1Var).height));
            } else {
                S0(view, h0.w(true, this.f10828n, this.f10826l, E() + D(), ((ViewGroup.MarginLayoutParams) b1Var).width), h0.w(false, this.f1679u, this.f10827m, 0, ((ViewGroup.MarginLayoutParams) b1Var).height));
            }
            if (pVar.f10893e == 1) {
                iE = e1Var.h(i17);
                iJ = this.f1676r.e(view) + iE;
            } else {
                iJ = e1Var.j(i17);
                iE = iJ - this.f1676r.e(view);
            }
            if (pVar.f10893e == 1) {
                e1 e1Var5 = b1Var.f10750e;
                e1Var5.getClass();
                b1 b1Var2 = (b1) view.getLayoutParams();
                b1Var2.f10750e = e1Var5;
                ArrayList arrayList = (ArrayList) e1Var5.f;
                arrayList.add(view);
                e1Var5.f10783c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    e1Var5.f10782b = Integer.MIN_VALUE;
                }
                if (b1Var2.f10831a.h() || b1Var2.f10831a.k()) {
                    e1Var5.f10784d = ((StaggeredGridLayoutManager) e1Var5.f10786g).f1676r.e(view) + e1Var5.f10784d;
                }
            } else {
                e1 e1Var6 = b1Var.f10750e;
                e1Var6.getClass();
                b1 b1Var3 = (b1) view.getLayoutParams();
                b1Var3.f10750e = e1Var6;
                ArrayList arrayList2 = (ArrayList) e1Var6.f;
                arrayList2.add(0, view);
                e1Var6.f10782b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    e1Var6.f10783c = Integer.MIN_VALUE;
                }
                if (b1Var3.f10831a.h() || b1Var3.f10831a.k()) {
                    e1Var6.f10784d = ((StaggeredGridLayoutManager) e1Var6.f10786g).f1676r.e(view) + e1Var6.f10784d;
                }
            }
            if (R0() && this.f1678t == 1) {
                iE2 = this.f1677s.i() - (((this.f1674p - 1) - e1Var.f10785e) * this.f1679u);
                iM = iE2 - this.f1677s.e(view);
            } else {
                iM = this.f1677s.m() + (e1Var.f10785e * this.f1679u);
                iE2 = this.f1677s.e(view) + iM;
            }
            if (this.f1678t == 1) {
                h0.N(view, iM, iE, iE2, iJ);
            } else {
                h0.N(view, iE, iM, iJ, iE2);
            }
            d1(e1Var, pVar2.f10893e, i14);
            W0(n0Var, pVar2);
            if (pVar2.f10895h && view.hasFocusable()) {
                this.f1683y.set(e1Var.f10785e, false);
            }
            i13 = 1;
            z2 = true;
            i12 = 0;
        }
        if (!z2) {
            W0(n0Var, pVar2);
        }
        int iM3 = pVar2.f10893e == -1 ? this.f1676r.m() - O0(this.f1676r.m()) : N0(this.f1676r.i()) - this.f1676r.i();
        if (iM3 > 0) {
            return Math.min(pVar.f10890b, iM3);
        }
        return 0;
    }

    public final View H0(boolean z2) {
        int iM = this.f1676r.m();
        int i = this.f1676r.i();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iG = this.f1676r.g(viewU);
            int iD = this.f1676r.d(viewU);
            if (iD > iM && iG < i) {
                if (iD <= i || !z2) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    @Override // q4.h0
    public final int I(n0 n0Var, t0 t0Var) {
        if (this.f1678t == 0) {
            return Math.min(this.f1674p, t0Var.b());
        }
        return -1;
    }

    public final View I0(boolean z2) {
        int iM = this.f1676r.m();
        int i = this.f1676r.i();
        int iV = v();
        View view = null;
        for (int i10 = 0; i10 < iV; i10++) {
            View viewU = u(i10);
            int iG = this.f1676r.g(viewU);
            if (this.f1676r.d(viewU) > iM && iG < i) {
                if (iG >= iM || !z2) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void J0(n0 n0Var, t0 t0Var, boolean z2) {
        int i;
        int iN0 = N0(Integer.MIN_VALUE);
        if (iN0 != Integer.MIN_VALUE && (i = this.f1676r.i() - iN0) > 0) {
            int i10 = i - (-a1(-i, n0Var, t0Var));
            if (!z2 || i10 <= 0) {
                return;
            }
            this.f1676r.q(i10);
        }
    }

    @Override // q4.h0
    public final boolean K() {
        return this.C != 0;
    }

    public final void K0(n0 n0Var, t0 t0Var, boolean z2) {
        int iM;
        int iO0 = O0(Integer.MAX_VALUE);
        if (iO0 != Integer.MAX_VALUE && (iM = iO0 - this.f1676r.m()) > 0) {
            int iA1 = iM - a1(iM, n0Var, t0Var);
            if (!z2 || iA1 <= 0) {
                return;
            }
            this.f1676r.q(-iA1);
        }
    }

    @Override // q4.h0
    public final boolean L() {
        return this.f1681w;
    }

    public final int L0() {
        if (v() == 0) {
            return 0;
        }
        return h0.G(u(0));
    }

    public final int M0() {
        int iV = v();
        if (iV == 0) {
            return 0;
        }
        return h0.G(u(iV - 1));
    }

    public final int N0(int i) {
        int iH = this.f1675q[0].h(i);
        for (int i10 = 1; i10 < this.f1674p; i10++) {
            int iH2 = this.f1675q[i10].h(i);
            if (iH2 > iH) {
                iH = iH2;
            }
        }
        return iH;
    }

    @Override // q4.h0
    public final void O(int i) {
        super.O(i);
        for (int i10 = 0; i10 < this.f1674p; i10++) {
            e1 e1Var = this.f1675q[i10];
            int i11 = e1Var.f10782b;
            if (i11 != Integer.MIN_VALUE) {
                e1Var.f10782b = i11 + i;
            }
            int i12 = e1Var.f10783c;
            if (i12 != Integer.MIN_VALUE) {
                e1Var.f10783c = i12 + i;
            }
        }
    }

    public final int O0(int i) {
        int iJ = this.f1675q[0].j(i);
        for (int i10 = 1; i10 < this.f1674p; i10++) {
            int iJ2 = this.f1675q[i10].j(i);
            if (iJ2 < iJ) {
                iJ = iJ2;
            }
        }
        return iJ;
    }

    @Override // q4.h0
    public final void P(int i) {
        super.P(i);
        for (int i10 = 0; i10 < this.f1674p; i10++) {
            e1 e1Var = this.f1675q[i10];
            int i11 = e1Var.f10782b;
            if (i11 != Integer.MIN_VALUE) {
                e1Var.f10782b = i11 + i;
            }
            int i12 = e1Var.f10783c;
            if (i12 != Integer.MIN_VALUE) {
                e1Var.f10783c = i12 + i;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0034  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x00a0  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x007a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void P0(int r10, int r11, int r12) {
        /*
            Method dump skipped, instruction units count: 223
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.P0(int, int, int):void");
    }

    @Override // q4.h0
    public final void Q() {
        this.B.f();
        for (int i = 0; i < this.f1674p; i++) {
            this.f1675q[i].b();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0103 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x002c A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View Q0() {
        /*
            Method dump skipped, instruction units count: 262
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.Q0():android.view.View");
    }

    public final boolean R0() {
        return this.f10818b.getLayoutDirection() == 1;
    }

    @Override // q4.h0
    public final void S(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f10818b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i = 0; i < this.f1674p; i++) {
            this.f1675q[i].b();
        }
        recyclerView.requestLayout();
    }

    public final void S0(View view, int i, int i10) {
        RecyclerView recyclerView = this.f10818b;
        Rect rect = this.G;
        if (recyclerView == null) {
            rect.set(0, 0, 0, 0);
        } else {
            rect.set(recyclerView.N(view));
        }
        b1 b1Var = (b1) view.getLayoutParams();
        int iE1 = e1(i, ((ViewGroup.MarginLayoutParams) b1Var).leftMargin + rect.left, ((ViewGroup.MarginLayoutParams) b1Var).rightMargin + rect.right);
        int iE12 = e1(i10, ((ViewGroup.MarginLayoutParams) b1Var).topMargin + rect.top, ((ViewGroup.MarginLayoutParams) b1Var).bottomMargin + rect.bottom);
        if (y0(view, iE1, iE12, b1Var)) {
            view.measure(iE1, iE12);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0053  */
    @Override // q4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r9, int r10, q4.n0 r11, q4.t0 r12) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T(android.view.View, int, q4.n0, q4.t0):android.view.View");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0419  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void T0(q4.n0 r17, q4.t0 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1076
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T0(q4.n0, q4.t0, boolean):void");
    }

    @Override // q4.h0
    public final void U(AccessibilityEvent accessibilityEvent) {
        super.U(accessibilityEvent);
        if (v() > 0) {
            View viewI0 = I0(false);
            View viewH0 = H0(false);
            if (viewI0 == null || viewH0 == null) {
                return;
            }
            int iG = h0.G(viewI0);
            int iG2 = h0.G(viewH0);
            if (iG < iG2) {
                accessibilityEvent.setFromIndex(iG);
                accessibilityEvent.setToIndex(iG2);
            } else {
                accessibilityEvent.setFromIndex(iG2);
                accessibilityEvent.setToIndex(iG);
            }
        }
    }

    public final boolean U0(int i) {
        if (this.f1678t == 0) {
            return (i == -1) != this.f1682x;
        }
        return ((i == -1) == this.f1682x) == R0();
    }

    @Override // q4.h0
    public final void V(n0 n0Var, t0 t0Var, r0.e eVar) {
        super.V(n0Var, t0Var, eVar);
        eVar.i("androidx.recyclerview.widget.StaggeredGridLayoutManager");
    }

    public final void V0(int i, t0 t0Var) {
        int iL0;
        int i10;
        if (i > 0) {
            iL0 = M0();
            i10 = 1;
        } else {
            iL0 = L0();
            i10 = -1;
        }
        p pVar = this.f1680v;
        pVar.f10889a = true;
        c1(iL0, t0Var);
        b1(i10);
        pVar.f10891c = iL0 + pVar.f10892d;
        pVar.f10890b = Math.abs(i);
    }

    public final void W0(n0 n0Var, p pVar) {
        if (!pVar.f10889a || pVar.i) {
            return;
        }
        if (pVar.f10890b == 0) {
            if (pVar.f10893e == -1) {
                X0(n0Var, pVar.f10894g);
                return;
            } else {
                Y0(n0Var, pVar.f);
                return;
            }
        }
        int i = 1;
        if (pVar.f10893e == -1) {
            int i10 = pVar.f;
            int iJ = this.f1675q[0].j(i10);
            while (i < this.f1674p) {
                int iJ2 = this.f1675q[i].j(i10);
                if (iJ2 > iJ) {
                    iJ = iJ2;
                }
                i++;
            }
            int i11 = i10 - iJ;
            X0(n0Var, i11 < 0 ? pVar.f10894g : pVar.f10894g - Math.min(i11, pVar.f10890b));
            return;
        }
        int i12 = pVar.f10894g;
        int iH = this.f1675q[0].h(i12);
        while (i < this.f1674p) {
            int iH2 = this.f1675q[i].h(i12);
            if (iH2 < iH) {
                iH = iH2;
            }
            i++;
        }
        int i13 = iH - pVar.f10894g;
        Y0(n0Var, i13 < 0 ? pVar.f : Math.min(i13, pVar.f10890b) + pVar.f);
    }

    @Override // q4.h0
    public final void X(n0 n0Var, t0 t0Var, View view, r0.e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b1)) {
            W(view, eVar);
            return;
        }
        b1 b1Var = (b1) layoutParams;
        if (this.f1678t == 0) {
            e1 e1Var = b1Var.f10750e;
            eVar.j(e7.c.a(e1Var != null ? e1Var.f10785e : -1, 1, -1, -1, false, false));
        } else {
            e1 e1Var2 = b1Var.f10750e;
            eVar.j(e7.c.a(-1, -1, e1Var2 != null ? e1Var2.f10785e : -1, 1, false, false));
        }
    }

    public final void X0(n0 n0Var, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.f1676r.g(viewU) < i || this.f1676r.p(viewU) < i) {
                return;
            }
            b1 b1Var = (b1) viewU.getLayoutParams();
            b1Var.getClass();
            if (((ArrayList) b1Var.f10750e.f).size() == 1) {
                return;
            }
            e1 e1Var = b1Var.f10750e;
            ArrayList arrayList = (ArrayList) e1Var.f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            b1 b1Var2 = (b1) view.getLayoutParams();
            b1Var2.f10750e = null;
            if (b1Var2.f10831a.h() || b1Var2.f10831a.k()) {
                e1Var.f10784d -= ((StaggeredGridLayoutManager) e1Var.f10786g).f1676r.e(view);
            }
            if (size == 1) {
                e1Var.f10782b = Integer.MIN_VALUE;
            }
            e1Var.f10783c = Integer.MIN_VALUE;
            m0(viewU, n0Var);
        }
    }

    public final void Y0(n0 n0Var, int i) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.f1676r.d(viewU) > i || this.f1676r.o(viewU) > i) {
                return;
            }
            b1 b1Var = (b1) viewU.getLayoutParams();
            b1Var.getClass();
            if (((ArrayList) b1Var.f10750e.f).size() == 1) {
                return;
            }
            e1 e1Var = b1Var.f10750e;
            ArrayList arrayList = (ArrayList) e1Var.f;
            View view = (View) arrayList.remove(0);
            b1 b1Var2 = (b1) view.getLayoutParams();
            b1Var2.f10750e = null;
            if (arrayList.size() == 0) {
                e1Var.f10783c = Integer.MIN_VALUE;
            }
            if (b1Var2.f10831a.h() || b1Var2.f10831a.k()) {
                e1Var.f10784d -= ((StaggeredGridLayoutManager) e1Var.f10786g).f1676r.e(view);
            }
            e1Var.f10782b = Integer.MIN_VALUE;
            m0(viewU, n0Var);
        }
    }

    @Override // q4.h0
    public final void Z(int i, int i10) {
        P0(i, i10, 1);
    }

    public final void Z0() {
        if (this.f1678t == 1 || !R0()) {
            this.f1682x = this.f1681w;
        } else {
            this.f1682x = !this.f1681w;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // q4.s0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.graphics.PointF a(int r4) {
        /*
            r3 = this;
            int r0 = r3.v()
            r1 = -1
            r2 = 1
            if (r0 != 0) goto Le
            boolean r4 = r3.f1682x
            if (r4 == 0) goto L1b
        Lc:
            r1 = r2
            goto L1b
        Le:
            int r0 = r3.L0()
            if (r4 >= r0) goto L16
            r4 = r2
            goto L17
        L16:
            r4 = 0
        L17:
            boolean r0 = r3.f1682x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.f1678t
            r2 = 0
            if (r0 != 0) goto L2f
            float r0 = (float) r1
            r4.x = r0
            r4.y = r2
            return r4
        L2f:
            r4.x = r2
            float r0 = (float) r1
            r4.y = r0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.a(int):android.graphics.PointF");
    }

    @Override // q4.h0
    public final void a0() {
        this.B.f();
        p0();
    }

    public final int a1(int i, n0 n0Var, t0 t0Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        V0(i, t0Var);
        p pVar = this.f1680v;
        int iG0 = G0(n0Var, pVar, t0Var);
        if (pVar.f10890b >= iG0) {
            i = i < 0 ? -iG0 : iG0;
        }
        this.f1676r.q(-i);
        this.D = this.f1682x;
        pVar.f10890b = 0;
        W0(n0Var, pVar);
        return i;
    }

    @Override // q4.h0
    public final void b0(int i, int i10) {
        P0(i, i10, 8);
    }

    public final void b1(int i) {
        p pVar = this.f1680v;
        pVar.f10893e = i;
        pVar.f10892d = this.f1682x != (i == -1) ? -1 : 1;
    }

    @Override // q4.h0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // q4.h0
    public final void c0(int i, int i10) {
        P0(i, i10, 2);
    }

    public final void c1(int i, t0 t0Var) {
        int iN;
        int iN2;
        int i10;
        p pVar = this.f1680v;
        boolean z2 = false;
        pVar.f10890b = 0;
        pVar.f10891c = i;
        t tVar = this.f10821e;
        if (tVar == null || !tVar.f10925e || (i10 = t0Var.f10935a) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.f1682x == (i10 < i)) {
                iN = this.f1676r.n();
                iN2 = 0;
            } else {
                iN2 = this.f1676r.n();
                iN = 0;
            }
        }
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView == null || !recyclerView.B) {
            pVar.f10894g = this.f1676r.h() + iN;
            pVar.f = -iN2;
        } else {
            pVar.f = this.f1676r.m() - iN2;
            pVar.f10894g = this.f1676r.i() + iN;
        }
        pVar.f10895h = false;
        pVar.f10889a = true;
        if (this.f1676r.k() == 0 && this.f1676r.h() == 0) {
            z2 = true;
        }
        pVar.i = z2;
    }

    @Override // q4.h0
    public final boolean d() {
        return this.f1678t == 0;
    }

    @Override // q4.h0
    public final void d0(int i, int i10) {
        P0(i, i10, 4);
    }

    public final void d1(e1 e1Var, int i, int i10) {
        int i11 = e1Var.f10784d;
        int i12 = e1Var.f10785e;
        if (i != -1) {
            int i13 = e1Var.f10783c;
            if (i13 == Integer.MIN_VALUE) {
                e1Var.a();
                i13 = e1Var.f10783c;
            }
            if (i13 - i11 >= i10) {
                this.f1683y.set(i12, false);
                return;
            }
            return;
        }
        int i14 = e1Var.f10782b;
        if (i14 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) e1Var.f).get(0);
            b1 b1Var = (b1) view.getLayoutParams();
            e1Var.f10782b = ((StaggeredGridLayoutManager) e1Var.f10786g).f1676r.g(view);
            b1Var.getClass();
            i14 = e1Var.f10782b;
        }
        if (i14 + i11 <= i10) {
            this.f1683y.set(i12, false);
        }
    }

    @Override // q4.h0
    public final boolean e() {
        return this.f1678t == 1;
    }

    @Override // q4.h0
    public final void e0(n0 n0Var, t0 t0Var) {
        T0(n0Var, t0Var, true);
    }

    @Override // q4.h0
    public final boolean f(i0 i0Var) {
        return i0Var instanceof b1;
    }

    @Override // q4.h0
    public final void f0(t0 t0Var) {
        this.f1684z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // q4.h0
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof d1) {
            d1 d1Var = (d1) parcelable;
            this.F = d1Var;
            if (this.f1684z != -1) {
                d1Var.f10765u = -1;
                d1Var.f10766v = -1;
                d1Var.f10768x = null;
                d1Var.f10767w = 0;
                d1Var.f10769y = 0;
                d1Var.f10770z = null;
                d1Var.A = null;
            }
            p0();
        }
    }

    @Override // q4.h0
    public final void h(int i, int i10, t0 t0Var, k kVar) {
        p pVar;
        int iH;
        int iJ;
        if (this.f1678t != 0) {
            i = i10;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        V0(i, t0Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f1674p) {
            this.J = new int[this.f1674p];
        }
        int i11 = 0;
        int i12 = 0;
        while (true) {
            int i13 = this.f1674p;
            pVar = this.f1680v;
            if (i11 >= i13) {
                break;
            }
            if (pVar.f10892d == -1) {
                iH = pVar.f;
                iJ = this.f1675q[i11].j(iH);
            } else {
                iH = this.f1675q[i11].h(pVar.f10894g);
                iJ = pVar.f10894g;
            }
            int i14 = iH - iJ;
            if (i14 >= 0) {
                this.J[i12] = i14;
                i12++;
            }
            i11++;
        }
        Arrays.sort(this.J, 0, i12);
        for (int i15 = 0; i15 < i12; i15++) {
            int i16 = pVar.f10891c;
            if (i16 < 0 || i16 >= t0Var.b()) {
                return;
            }
            kVar.b(pVar.f10891c, this.J[i15]);
            pVar.f10891c += pVar.f10892d;
        }
    }

    @Override // q4.h0
    public final Parcelable h0() {
        int iJ;
        int iM;
        int[] iArr;
        d1 d1Var = this.F;
        if (d1Var != null) {
            d1 d1Var2 = new d1();
            d1Var2.f10767w = d1Var.f10767w;
            d1Var2.f10765u = d1Var.f10765u;
            d1Var2.f10766v = d1Var.f10766v;
            d1Var2.f10768x = d1Var.f10768x;
            d1Var2.f10769y = d1Var.f10769y;
            d1Var2.f10770z = d1Var.f10770z;
            d1Var2.B = d1Var.B;
            d1Var2.C = d1Var.C;
            d1Var2.D = d1Var.D;
            d1Var2.A = d1Var.A;
            return d1Var2;
        }
        d1 d1Var3 = new d1();
        d1Var3.B = this.f1681w;
        d1Var3.C = this.D;
        d1Var3.D = this.E;
        c cVar = this.B;
        if (cVar == null || (iArr = (int[]) cVar.f10130v) == null) {
            d1Var3.f10769y = 0;
        } else {
            d1Var3.f10770z = iArr;
            d1Var3.f10769y = iArr.length;
            d1Var3.A = (ArrayList) cVar.f10131w;
        }
        if (v() <= 0) {
            d1Var3.f10765u = -1;
            d1Var3.f10766v = -1;
            d1Var3.f10767w = 0;
            return d1Var3;
        }
        d1Var3.f10765u = this.D ? M0() : L0();
        View viewH0 = this.f1682x ? H0(true) : I0(true);
        d1Var3.f10766v = viewH0 != null ? h0.G(viewH0) : -1;
        int i = this.f1674p;
        d1Var3.f10767w = i;
        d1Var3.f10768x = new int[i];
        for (int i10 = 0; i10 < this.f1674p; i10++) {
            if (this.D) {
                iJ = this.f1675q[i10].h(Integer.MIN_VALUE);
                if (iJ != Integer.MIN_VALUE) {
                    iM = this.f1676r.i();
                    iJ -= iM;
                }
            } else {
                iJ = this.f1675q[i10].j(Integer.MIN_VALUE);
                if (iJ != Integer.MIN_VALUE) {
                    iM = this.f1676r.m();
                    iJ -= iM;
                }
            }
            d1Var3.f10768x[i10] = iJ;
        }
        return d1Var3;
    }

    @Override // q4.h0
    public final void i0(int i) {
        if (i == 0) {
            E0();
        }
    }

    @Override // q4.h0
    public final int j(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z2 = !this.I;
        return d.h(t0Var, this.f1676r, I0(z2), H0(z2), this, this.I);
    }

    @Override // q4.h0
    public final int k(t0 t0Var) {
        return F0(t0Var);
    }

    @Override // q4.h0
    public final int l(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z2 = !this.I;
        return d.j(t0Var, this.f1676r, I0(z2), H0(z2), this, this.I);
    }

    @Override // q4.h0
    public final int m(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z2 = !this.I;
        return d.h(t0Var, this.f1676r, I0(z2), H0(z2), this, this.I);
    }

    @Override // q4.h0
    public final int n(t0 t0Var) {
        return F0(t0Var);
    }

    @Override // q4.h0
    public final int o(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z2 = !this.I;
        return d.j(t0Var, this.f1676r, I0(z2), H0(z2), this, this.I);
    }

    @Override // q4.h0
    public final int q0(int i, n0 n0Var, t0 t0Var) {
        return a1(i, n0Var, t0Var);
    }

    @Override // q4.h0
    public final i0 r() {
        return this.f1678t == 0 ? new b1(-2, -1) : new b1(-1, -2);
    }

    @Override // q4.h0
    public final void r0(int i) {
        d1 d1Var = this.F;
        if (d1Var != null && d1Var.f10765u != i) {
            d1Var.f10768x = null;
            d1Var.f10767w = 0;
            d1Var.f10765u = -1;
            d1Var.f10766v = -1;
        }
        this.f1684z = i;
        this.A = Integer.MIN_VALUE;
        p0();
    }

    @Override // q4.h0
    public final i0 s(Context context, AttributeSet attributeSet) {
        return new b1(context, attributeSet);
    }

    @Override // q4.h0
    public final int s0(int i, n0 n0Var, t0 t0Var) {
        return a1(i, n0Var, t0Var);
    }

    @Override // q4.h0
    public final i0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b1((ViewGroup.MarginLayoutParams) layoutParams) : new b1(layoutParams);
    }

    @Override // q4.h0
    public final void v0(Rect rect, int i, int i10) {
        int iG;
        int iG2;
        int iE = E() + D();
        int iC = C() + F();
        int i11 = this.f1678t;
        int i12 = this.f1674p;
        if (i11 == 1) {
            int iHeight = rect.height() + iC;
            RecyclerView recyclerView = this.f10818b;
            WeakHashMap weakHashMap = o0.f10475a;
            iG2 = h0.g(i10, iHeight, recyclerView.getMinimumHeight());
            iG = h0.g(i, (this.f1679u * i12) + iE, this.f10818b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iE;
            RecyclerView recyclerView2 = this.f10818b;
            WeakHashMap weakHashMap2 = o0.f10475a;
            iG = h0.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = h0.g(i10, (this.f1679u * i12) + iC, this.f10818b.getMinimumHeight());
        }
        this.f10818b.setMeasuredDimension(iG, iG2);
    }

    @Override // q4.h0
    public final int x(n0 n0Var, t0 t0Var) {
        if (this.f1678t == 1) {
            return Math.min(this.f1674p, t0Var.b());
        }
        return -1;
    }
}
