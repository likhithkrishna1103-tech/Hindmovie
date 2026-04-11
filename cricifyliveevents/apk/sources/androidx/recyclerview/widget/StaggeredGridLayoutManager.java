package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.emoji2.text.h;
import androidx.fragment.app.m;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.WeakHashMap;
import nb.w;
import t0.m0;
import u0.d;
import u0.e;
import u8.a;
import v.g;
import v.j;
import v4.a1;
import v4.b1;
import v4.d1;
import v4.g0;
import v4.h0;
import v4.i0;
import v4.n0;
import v4.o;
import v4.s;
import v4.s0;
import v4.t0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class StaggeredGridLayoutManager extends h0 implements s0 {
    public final w B;
    public final int C;
    public boolean D;
    public boolean E;
    public d1 F;
    public final Rect G;
    public final a1 H;
    public final boolean I;
    public int[] J;
    public final m K;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f1457p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final j[] f1458q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final h f1459r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final h f1460s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final int f1461t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public int f1462u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o f1463v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1464w;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final BitSet f1466y;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1465x = false;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f1467z = -1;
    public int A = Integer.MIN_VALUE;

    public StaggeredGridLayoutManager(Context context, AttributeSet attributeSet, int i, int i10) {
        this.f1457p = -1;
        this.f1464w = false;
        w wVar = new w(27, false);
        this.B = wVar;
        this.C = 2;
        this.G = new Rect();
        this.H = new a1(this);
        this.I = true;
        this.K = new m(29, this);
        g0 g0VarH = h0.H(context, attributeSet, i, i10);
        int i11 = g0VarH.f13231a;
        if (i11 != 0 && i11 != 1) {
            throw new IllegalArgumentException("invalid orientation.");
        }
        c(null);
        if (i11 != this.f1461t) {
            this.f1461t = i11;
            h hVar = this.f1459r;
            this.f1459r = this.f1460s;
            this.f1460s = hVar;
            p0();
        }
        int i12 = g0VarH.f13232b;
        c(null);
        if (i12 != this.f1457p) {
            wVar.y();
            p0();
            this.f1457p = i12;
            this.f1466y = new BitSet(this.f1457p);
            this.f1458q = new j[this.f1457p];
            for (int i13 = 0; i13 < this.f1457p; i13++) {
                this.f1458q[i13] = new j(this, i13);
            }
            p0();
        }
        boolean z10 = g0VarH.f13233c;
        c(null);
        d1 d1Var = this.F;
        if (d1Var != null && d1Var.C != z10) {
            d1Var.C = z10;
        }
        this.f1464w = z10;
        p0();
        o oVar = new o();
        oVar.f13314a = true;
        oVar.f = 0;
        oVar.f13319g = 0;
        this.f1463v = oVar;
        this.f1459r = h.b(this, this.f1461t);
        this.f1460s = h.b(this, 1 - this.f1461t);
    }

    public static int e1(int i, int i10, int i11) {
        int mode;
        return (!(i10 == 0 && i11 == 0) && ((mode = View.MeasureSpec.getMode(i)) == Integer.MIN_VALUE || mode == 1073741824)) ? View.MeasureSpec.makeMeasureSpec(Math.max(0, (View.MeasureSpec.getSize(i) - i10) - i11), mode) : i;
    }

    @Override // v4.h0
    public final void B0(RecyclerView recyclerView, int i) {
        s sVar = new s(recyclerView.getContext());
        sVar.f13346a = i;
        C0(sVar);
    }

    @Override // v4.h0
    public final boolean D0() {
        return this.F == null;
    }

    public final boolean E0() {
        int iL0;
        if (v() != 0 && this.C != 0 && this.f13252g) {
            if (this.f1465x) {
                iL0 = M0();
                L0();
            } else {
                iL0 = L0();
                M0();
            }
            if (iL0 == 0 && Q0() != null) {
                this.B.y();
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
        boolean z10 = !this.I;
        return a.i(t0Var, this.f1459r, I0(z10), H0(z10), this, this.I, this.f1465x);
    }

    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v24 */
    /* JADX WARN: Type inference failed for: r8v3, types: [boolean, int] */
    public final int G0(n0 n0Var, o oVar, t0 t0Var) {
        j jVar;
        ?? r82;
        int iK;
        int iE;
        int iM;
        int iE2;
        int i;
        int i10;
        int i11;
        int i12 = 0;
        int i13 = 1;
        this.f1466y.set(0, this.f1457p, true);
        o oVar2 = this.f1463v;
        int i14 = oVar2.i ? oVar.f13318e == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE : oVar.f13318e == 1 ? oVar.f13319g + oVar.f13315b : oVar.f - oVar.f13315b;
        int i15 = oVar.f13318e;
        for (int i16 = 0; i16 < this.f1457p; i16++) {
            if (!((ArrayList) this.f1458q[i16].f).isEmpty()) {
                d1(this.f1458q[i16], i15, i14);
            }
        }
        int i17 = this.f1465x ? this.f1459r.i() : this.f1459r.m();
        boolean z10 = false;
        while (true) {
            int i18 = oVar.f13316c;
            if (i18 < 0 || i18 >= t0Var.b() || (!oVar2.i && this.f1466y.isEmpty())) {
                break;
            }
            View viewD = n0Var.d(oVar.f13316c);
            oVar.f13316c += oVar.f13317d;
            b1 b1Var = (b1) viewD.getLayoutParams();
            int iB = b1Var.f13261a.b();
            w wVar = this.B;
            int[] iArr = (int[]) wVar.f9016w;
            int i19 = (iArr == null || iB >= iArr.length) ? -1 : iArr[iB];
            if (i19 == -1) {
                if (U0(oVar.f13318e)) {
                    i11 = this.f1457p - i13;
                    i10 = -1;
                    i = -1;
                } else {
                    i = i13;
                    i10 = this.f1457p;
                    i11 = i12;
                }
                j jVar2 = null;
                if (oVar.f13318e == i13) {
                    int iM2 = this.f1459r.m();
                    int i20 = Integer.MAX_VALUE;
                    while (i11 != i10) {
                        j jVar3 = this.f1458q[i11];
                        int i21 = jVar3.i(iM2);
                        if (i21 < i20) {
                            i20 = i21;
                            jVar2 = jVar3;
                        }
                        i11 += i;
                    }
                } else {
                    int i22 = this.f1459r.i();
                    int i23 = Integer.MIN_VALUE;
                    while (i11 != i10) {
                        j jVar4 = this.f1458q[i11];
                        int iK2 = jVar4.k(i22);
                        if (iK2 > i23) {
                            jVar2 = jVar4;
                            i23 = iK2;
                        }
                        i11 += i;
                    }
                }
                jVar = jVar2;
                wVar.B(iB);
                ((int[]) wVar.f9016w)[iB] = jVar.f12538e;
            } else {
                jVar = this.f1458q[i19];
            }
            b1Var.f13187e = jVar;
            if (oVar.f13318e == 1) {
                r82 = 0;
                b(viewD, -1, false);
            } else {
                r82 = 0;
                b(viewD, 0, false);
            }
            if (this.f1461t == 1) {
                S0(viewD, h0.w(r82, this.f1462u, this.f13256l, r82, ((ViewGroup.MarginLayoutParams) b1Var).width), h0.w(true, this.f13259o, this.f13257m, C() + F(), ((ViewGroup.MarginLayoutParams) b1Var).height));
            } else {
                S0(viewD, h0.w(true, this.f13258n, this.f13256l, E() + D(), ((ViewGroup.MarginLayoutParams) b1Var).width), h0.w(false, this.f1462u, this.f13257m, 0, ((ViewGroup.MarginLayoutParams) b1Var).height));
            }
            if (oVar.f13318e == 1) {
                iE = jVar.i(i17);
                iK = this.f1459r.e(viewD) + iE;
            } else {
                iK = jVar.k(i17);
                iE = iK - this.f1459r.e(viewD);
            }
            if (oVar.f13318e == 1) {
                j jVar5 = b1Var.f13187e;
                jVar5.getClass();
                b1 b1Var2 = (b1) viewD.getLayoutParams();
                b1Var2.f13187e = jVar5;
                ArrayList arrayList = (ArrayList) jVar5.f;
                arrayList.add(viewD);
                jVar5.f12536c = Integer.MIN_VALUE;
                if (arrayList.size() == 1) {
                    jVar5.f12535b = Integer.MIN_VALUE;
                }
                if (b1Var2.f13261a.h() || b1Var2.f13261a.k()) {
                    jVar5.f12537d = ((StaggeredGridLayoutManager) jVar5.f12539g).f1459r.e(viewD) + jVar5.f12537d;
                }
            } else {
                j jVar6 = b1Var.f13187e;
                jVar6.getClass();
                b1 b1Var3 = (b1) viewD.getLayoutParams();
                b1Var3.f13187e = jVar6;
                ArrayList arrayList2 = (ArrayList) jVar6.f;
                arrayList2.add(0, viewD);
                jVar6.f12535b = Integer.MIN_VALUE;
                if (arrayList2.size() == 1) {
                    jVar6.f12536c = Integer.MIN_VALUE;
                }
                if (b1Var3.f13261a.h() || b1Var3.f13261a.k()) {
                    jVar6.f12537d = ((StaggeredGridLayoutManager) jVar6.f12539g).f1459r.e(viewD) + jVar6.f12537d;
                }
            }
            if (R0() && this.f1461t == 1) {
                iE2 = this.f1460s.i() - (((this.f1457p - 1) - jVar.f12538e) * this.f1462u);
                iM = iE2 - this.f1460s.e(viewD);
            } else {
                iM = this.f1460s.m() + (jVar.f12538e * this.f1462u);
                iE2 = this.f1460s.e(viewD) + iM;
            }
            if (this.f1461t == 1) {
                h0.N(viewD, iM, iE, iE2, iK);
            } else {
                h0.N(viewD, iE, iM, iK, iE2);
            }
            d1(jVar, oVar2.f13318e, i14);
            W0(n0Var, oVar2);
            if (oVar2.f13320h && viewD.hasFocusable()) {
                this.f1466y.set(jVar.f12538e, false);
            }
            i13 = 1;
            z10 = true;
            i12 = 0;
        }
        if (!z10) {
            W0(n0Var, oVar2);
        }
        int iM3 = oVar2.f13318e == -1 ? this.f1459r.m() - O0(this.f1459r.m()) : N0(this.f1459r.i()) - this.f1459r.i();
        if (iM3 > 0) {
            return Math.min(oVar.f13315b, iM3);
        }
        return 0;
    }

    public final View H0(boolean z10) {
        int iM = this.f1459r.m();
        int i = this.f1459r.i();
        View view = null;
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            int iG = this.f1459r.g(viewU);
            int iD = this.f1459r.d(viewU);
            if (iD > iM && iG < i) {
                if (iD <= i || !z10) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    @Override // v4.h0
    public final int I(n0 n0Var, t0 t0Var) {
        if (this.f1461t == 0) {
            return Math.min(this.f1457p, t0Var.b());
        }
        return -1;
    }

    public final View I0(boolean z10) {
        int iM = this.f1459r.m();
        int i = this.f1459r.i();
        int iV = v();
        View view = null;
        for (int i10 = 0; i10 < iV; i10++) {
            View viewU = u(i10);
            int iG = this.f1459r.g(viewU);
            if (this.f1459r.d(viewU) > iM && iG < i) {
                if (iG >= iM || !z10) {
                    return viewU;
                }
                if (view == null) {
                    view = viewU;
                }
            }
        }
        return view;
    }

    public final void J0(n0 n0Var, t0 t0Var, boolean z10) {
        int i;
        int iN0 = N0(Integer.MIN_VALUE);
        if (iN0 != Integer.MIN_VALUE && (i = this.f1459r.i() - iN0) > 0) {
            int i10 = i - (-a1(-i, n0Var, t0Var));
            if (!z10 || i10 <= 0) {
                return;
            }
            this.f1459r.q(i10);
        }
    }

    @Override // v4.h0
    public final boolean K() {
        return this.C != 0;
    }

    public final void K0(n0 n0Var, t0 t0Var, boolean z10) {
        int iM;
        int iO0 = O0(Integer.MAX_VALUE);
        if (iO0 != Integer.MAX_VALUE && (iM = iO0 - this.f1459r.m()) > 0) {
            int iA1 = iM - a1(iM, n0Var, t0Var);
            if (!z10 || iA1 <= 0) {
                return;
            }
            this.f1459r.q(-iA1);
        }
    }

    @Override // v4.h0
    public final boolean L() {
        return this.f1464w;
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
        int i10 = this.f1458q[0].i(i);
        for (int i11 = 1; i11 < this.f1457p; i11++) {
            int i12 = this.f1458q[i11].i(i);
            if (i12 > i10) {
                i10 = i12;
            }
        }
        return i10;
    }

    @Override // v4.h0
    public final void O(int i) {
        super.O(i);
        for (int i10 = 0; i10 < this.f1457p; i10++) {
            j jVar = this.f1458q[i10];
            int i11 = jVar.f12535b;
            if (i11 != Integer.MIN_VALUE) {
                jVar.f12535b = i11 + i;
            }
            int i12 = jVar.f12536c;
            if (i12 != Integer.MIN_VALUE) {
                jVar.f12536c = i12 + i;
            }
        }
    }

    public final int O0(int i) {
        int iK = this.f1458q[0].k(i);
        for (int i10 = 1; i10 < this.f1457p; i10++) {
            int iK2 = this.f1458q[i10].k(i);
            if (iK2 < iK) {
                iK = iK2;
            }
        }
        return iK;
    }

    @Override // v4.h0
    public final void P(int i) {
        super.P(i);
        for (int i10 = 0; i10 < this.f1457p; i10++) {
            j jVar = this.f1458q[i10];
            int i11 = jVar.f12535b;
            if (i11 != Integer.MIN_VALUE) {
                jVar.f12535b = i11 + i;
            }
            int i12 = jVar.f12536c;
            if (i12 != Integer.MIN_VALUE) {
                jVar.f12536c = i12 + i;
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

    @Override // v4.h0
    public final void Q() {
        this.B.y();
        for (int i = 0; i < this.f1457p; i++) {
            this.f1458q[i].b();
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
        return this.f13248b.getLayoutDirection() == 1;
    }

    @Override // v4.h0
    public final void S(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f13248b;
        if (recyclerView2 != null) {
            recyclerView2.removeCallbacks(this.K);
        }
        for (int i = 0; i < this.f1457p; i++) {
            this.f1458q[i].b();
        }
        recyclerView.requestLayout();
    }

    public final void S0(View view, int i, int i10) {
        RecyclerView recyclerView = this.f13248b;
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
    @Override // v4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r9, int r10, v4.n0 r11, v4.t0 r12) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T(android.view.View, int, v4.n0, v4.t0):android.view.View");
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
    public final void T0(v4.n0 r17, v4.t0 r18, boolean r19) {
        /*
            Method dump skipped, instruction units count: 1076
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.StaggeredGridLayoutManager.T0(v4.n0, v4.t0, boolean):void");
    }

    @Override // v4.h0
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
        if (this.f1461t == 0) {
            return (i == -1) != this.f1465x;
        }
        return ((i == -1) == this.f1465x) == R0();
    }

    @Override // v4.h0
    public final void V(n0 n0Var, t0 t0Var, e eVar) {
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
        o oVar = this.f1463v;
        oVar.f13314a = true;
        c1(iL0, t0Var);
        b1(i10);
        oVar.f13316c = iL0 + oVar.f13317d;
        oVar.f13315b = Math.abs(i);
    }

    public final void W0(n0 n0Var, o oVar) {
        if (!oVar.f13314a || oVar.i) {
            return;
        }
        if (oVar.f13315b == 0) {
            if (oVar.f13318e == -1) {
                X0(n0Var, oVar.f13319g);
                return;
            } else {
                Y0(n0Var, oVar.f);
                return;
            }
        }
        int i = 1;
        if (oVar.f13318e == -1) {
            int i10 = oVar.f;
            int iK = this.f1458q[0].k(i10);
            while (i < this.f1457p) {
                int iK2 = this.f1458q[i].k(i10);
                if (iK2 > iK) {
                    iK = iK2;
                }
                i++;
            }
            int i11 = i10 - iK;
            X0(n0Var, i11 < 0 ? oVar.f13319g : oVar.f13319g - Math.min(i11, oVar.f13315b));
            return;
        }
        int i12 = oVar.f13319g;
        int i13 = this.f1458q[0].i(i12);
        while (i < this.f1457p) {
            int i14 = this.f1458q[i].i(i12);
            if (i14 < i13) {
                i13 = i14;
            }
            i++;
        }
        int i15 = i13 - oVar.f13319g;
        Y0(n0Var, i15 < 0 ? oVar.f : Math.min(i15, oVar.f13315b) + oVar.f);
    }

    @Override // v4.h0
    public final void X(n0 n0Var, t0 t0Var, View view, e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof b1)) {
            W(view, eVar);
            return;
        }
        b1 b1Var = (b1) layoutParams;
        if (this.f1461t == 0) {
            j jVar = b1Var.f13187e;
            eVar.j(d.a(jVar != null ? jVar.f12538e : -1, 1, -1, -1, false, false));
        } else {
            j jVar2 = b1Var.f13187e;
            eVar.j(d.a(-1, -1, jVar2 != null ? jVar2.f12538e : -1, 1, false, false));
        }
    }

    public final void X0(n0 n0Var, int i) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            if (this.f1459r.g(viewU) < i || this.f1459r.p(viewU) < i) {
                return;
            }
            b1 b1Var = (b1) viewU.getLayoutParams();
            b1Var.getClass();
            if (((ArrayList) b1Var.f13187e.f).size() == 1) {
                return;
            }
            j jVar = b1Var.f13187e;
            ArrayList arrayList = (ArrayList) jVar.f;
            int size = arrayList.size();
            View view = (View) arrayList.remove(size - 1);
            b1 b1Var2 = (b1) view.getLayoutParams();
            b1Var2.f13187e = null;
            if (b1Var2.f13261a.h() || b1Var2.f13261a.k()) {
                jVar.f12537d -= ((StaggeredGridLayoutManager) jVar.f12539g).f1459r.e(view);
            }
            if (size == 1) {
                jVar.f12535b = Integer.MIN_VALUE;
            }
            jVar.f12536c = Integer.MIN_VALUE;
            m0(viewU, n0Var);
        }
    }

    public final void Y0(n0 n0Var, int i) {
        while (v() > 0) {
            View viewU = u(0);
            if (this.f1459r.d(viewU) > i || this.f1459r.o(viewU) > i) {
                return;
            }
            b1 b1Var = (b1) viewU.getLayoutParams();
            b1Var.getClass();
            if (((ArrayList) b1Var.f13187e.f).size() == 1) {
                return;
            }
            j jVar = b1Var.f13187e;
            ArrayList arrayList = (ArrayList) jVar.f;
            View view = (View) arrayList.remove(0);
            b1 b1Var2 = (b1) view.getLayoutParams();
            b1Var2.f13187e = null;
            if (arrayList.size() == 0) {
                jVar.f12536c = Integer.MIN_VALUE;
            }
            if (b1Var2.f13261a.h() || b1Var2.f13261a.k()) {
                jVar.f12537d -= ((StaggeredGridLayoutManager) jVar.f12539g).f1459r.e(view);
            }
            jVar.f12535b = Integer.MIN_VALUE;
            m0(viewU, n0Var);
        }
    }

    @Override // v4.h0
    public final void Z(int i, int i10) {
        P0(i, i10, 1);
    }

    public final void Z0() {
        if (this.f1461t == 1 || !R0()) {
            this.f1465x = this.f1464w;
        } else {
            this.f1465x = !this.f1464w;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x000c  */
    @Override // v4.s0
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
            boolean r4 = r3.f1465x
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
            boolean r0 = r3.f1465x
            if (r4 == r0) goto Lc
        L1b:
            android.graphics.PointF r4 = new android.graphics.PointF
            r4.<init>()
            if (r1 != 0) goto L24
            r4 = 0
            return r4
        L24:
            int r0 = r3.f1461t
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

    @Override // v4.h0
    public final void a0() {
        this.B.y();
        p0();
    }

    public final int a1(int i, n0 n0Var, t0 t0Var) {
        if (v() == 0 || i == 0) {
            return 0;
        }
        V0(i, t0Var);
        o oVar = this.f1463v;
        int iG0 = G0(n0Var, oVar, t0Var);
        if (oVar.f13315b >= iG0) {
            i = i < 0 ? -iG0 : iG0;
        }
        this.f1459r.q(-i);
        this.D = this.f1465x;
        oVar.f13315b = 0;
        W0(n0Var, oVar);
        return i;
    }

    @Override // v4.h0
    public final void b0(int i, int i10) {
        P0(i, i10, 8);
    }

    public final void b1(int i) {
        o oVar = this.f1463v;
        oVar.f13318e = i;
        oVar.f13317d = this.f1465x != (i == -1) ? -1 : 1;
    }

    @Override // v4.h0
    public final void c(String str) {
        if (this.F == null) {
            super.c(str);
        }
    }

    @Override // v4.h0
    public final void c0(int i, int i10) {
        P0(i, i10, 2);
    }

    public final void c1(int i, t0 t0Var) {
        int iN;
        int iN2;
        int i10;
        o oVar = this.f1463v;
        boolean z10 = false;
        oVar.f13315b = 0;
        oVar.f13316c = i;
        s sVar = this.f13251e;
        if (sVar == null || !sVar.f13350e || (i10 = t0Var.f13361a) == -1) {
            iN = 0;
            iN2 = 0;
        } else {
            if (this.f1465x == (i10 < i)) {
                iN = this.f1459r.n();
                iN2 = 0;
            } else {
                iN2 = this.f1459r.n();
                iN = 0;
            }
        }
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView == null || !recyclerView.C) {
            oVar.f13319g = this.f1459r.h() + iN;
            oVar.f = -iN2;
        } else {
            oVar.f = this.f1459r.m() - iN2;
            oVar.f13319g = this.f1459r.i() + iN;
        }
        oVar.f13320h = false;
        oVar.f13314a = true;
        if (this.f1459r.k() == 0 && this.f1459r.h() == 0) {
            z10 = true;
        }
        oVar.i = z10;
    }

    @Override // v4.h0
    public final boolean d() {
        return this.f1461t == 0;
    }

    @Override // v4.h0
    public final void d0(int i, int i10) {
        P0(i, i10, 4);
    }

    public final void d1(j jVar, int i, int i10) {
        int i11 = jVar.f12537d;
        int i12 = jVar.f12538e;
        if (i != -1) {
            int i13 = jVar.f12536c;
            if (i13 == Integer.MIN_VALUE) {
                jVar.a();
                i13 = jVar.f12536c;
            }
            if (i13 - i11 >= i10) {
                this.f1466y.set(i12, false);
                return;
            }
            return;
        }
        int i14 = jVar.f12535b;
        if (i14 == Integer.MIN_VALUE) {
            View view = (View) ((ArrayList) jVar.f).get(0);
            b1 b1Var = (b1) view.getLayoutParams();
            jVar.f12535b = ((StaggeredGridLayoutManager) jVar.f12539g).f1459r.g(view);
            b1Var.getClass();
            i14 = jVar.f12535b;
        }
        if (i14 + i11 <= i10) {
            this.f1466y.set(i12, false);
        }
    }

    @Override // v4.h0
    public final boolean e() {
        return this.f1461t == 1;
    }

    @Override // v4.h0
    public final void e0(n0 n0Var, t0 t0Var) {
        T0(n0Var, t0Var, true);
    }

    @Override // v4.h0
    public final boolean f(i0 i0Var) {
        return i0Var instanceof b1;
    }

    @Override // v4.h0
    public final void f0(t0 t0Var) {
        this.f1467z = -1;
        this.A = Integer.MIN_VALUE;
        this.F = null;
        this.H.a();
    }

    @Override // v4.h0
    public final void g0(Parcelable parcelable) {
        if (parcelable instanceof d1) {
            d1 d1Var = (d1) parcelable;
            this.F = d1Var;
            if (this.f1467z != -1) {
                d1Var.f13202v = -1;
                d1Var.f13203w = -1;
                d1Var.f13205y = null;
                d1Var.f13204x = 0;
                d1Var.f13206z = 0;
                d1Var.A = null;
                d1Var.B = null;
            }
            p0();
        }
    }

    @Override // v4.h0
    public final void h(int i, int i10, t0 t0Var, g gVar) {
        o oVar;
        int i11;
        int iK;
        if (this.f1461t != 0) {
            i = i10;
        }
        if (v() == 0 || i == 0) {
            return;
        }
        V0(i, t0Var);
        int[] iArr = this.J;
        if (iArr == null || iArr.length < this.f1457p) {
            this.J = new int[this.f1457p];
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            int i14 = this.f1457p;
            oVar = this.f1463v;
            if (i12 >= i14) {
                break;
            }
            if (oVar.f13317d == -1) {
                i11 = oVar.f;
                iK = this.f1458q[i12].k(i11);
            } else {
                i11 = this.f1458q[i12].i(oVar.f13319g);
                iK = oVar.f13319g;
            }
            int i15 = i11 - iK;
            if (i15 >= 0) {
                this.J[i13] = i15;
                i13++;
            }
            i12++;
        }
        Arrays.sort(this.J, 0, i13);
        for (int i16 = 0; i16 < i13; i16++) {
            int i17 = oVar.f13316c;
            if (i17 < 0 || i17 >= t0Var.b()) {
                return;
            }
            gVar.b(oVar.f13316c, this.J[i16]);
            oVar.f13316c += oVar.f13317d;
        }
    }

    @Override // v4.h0
    public final Parcelable h0() {
        int iK;
        int iM;
        int[] iArr;
        d1 d1Var = this.F;
        if (d1Var != null) {
            d1 d1Var2 = new d1();
            d1Var2.f13204x = d1Var.f13204x;
            d1Var2.f13202v = d1Var.f13202v;
            d1Var2.f13203w = d1Var.f13203w;
            d1Var2.f13205y = d1Var.f13205y;
            d1Var2.f13206z = d1Var.f13206z;
            d1Var2.A = d1Var.A;
            d1Var2.C = d1Var.C;
            d1Var2.D = d1Var.D;
            d1Var2.E = d1Var.E;
            d1Var2.B = d1Var.B;
            return d1Var2;
        }
        d1 d1Var3 = new d1();
        d1Var3.C = this.f1464w;
        d1Var3.D = this.D;
        d1Var3.E = this.E;
        w wVar = this.B;
        if (wVar == null || (iArr = (int[]) wVar.f9016w) == null) {
            d1Var3.f13206z = 0;
        } else {
            d1Var3.A = iArr;
            d1Var3.f13206z = iArr.length;
            d1Var3.B = (ArrayList) wVar.f9017x;
        }
        if (v() <= 0) {
            d1Var3.f13202v = -1;
            d1Var3.f13203w = -1;
            d1Var3.f13204x = 0;
            return d1Var3;
        }
        d1Var3.f13202v = this.D ? M0() : L0();
        View viewH0 = this.f1465x ? H0(true) : I0(true);
        d1Var3.f13203w = viewH0 != null ? h0.G(viewH0) : -1;
        int i = this.f1457p;
        d1Var3.f13204x = i;
        d1Var3.f13205y = new int[i];
        for (int i10 = 0; i10 < this.f1457p; i10++) {
            if (this.D) {
                iK = this.f1458q[i10].i(Integer.MIN_VALUE);
                if (iK != Integer.MIN_VALUE) {
                    iM = this.f1459r.i();
                    iK -= iM;
                }
            } else {
                iK = this.f1458q[i10].k(Integer.MIN_VALUE);
                if (iK != Integer.MIN_VALUE) {
                    iM = this.f1459r.m();
                    iK -= iM;
                }
            }
            d1Var3.f13205y[i10] = iK;
        }
        return d1Var3;
    }

    @Override // v4.h0
    public final void i0(int i) {
        if (i == 0) {
            E0();
        }
    }

    @Override // v4.h0
    public final int j(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.h(t0Var, this.f1459r, I0(z10), H0(z10), this, this.I);
    }

    @Override // v4.h0
    public final int k(t0 t0Var) {
        return F0(t0Var);
    }

    @Override // v4.h0
    public final int l(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.j(t0Var, this.f1459r, I0(z10), H0(z10), this, this.I);
    }

    @Override // v4.h0
    public final int m(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.h(t0Var, this.f1459r, I0(z10), H0(z10), this, this.I);
    }

    @Override // v4.h0
    public final int n(t0 t0Var) {
        return F0(t0Var);
    }

    @Override // v4.h0
    public final int o(t0 t0Var) {
        if (v() == 0) {
            return 0;
        }
        boolean z10 = !this.I;
        return a.j(t0Var, this.f1459r, I0(z10), H0(z10), this, this.I);
    }

    @Override // v4.h0
    public final int q0(int i, n0 n0Var, t0 t0Var) {
        return a1(i, n0Var, t0Var);
    }

    @Override // v4.h0
    public final i0 r() {
        return this.f1461t == 0 ? new b1(-2, -1) : new b1(-1, -2);
    }

    @Override // v4.h0
    public final void r0(int i) {
        d1 d1Var = this.F;
        if (d1Var != null && d1Var.f13202v != i) {
            d1Var.f13205y = null;
            d1Var.f13204x = 0;
            d1Var.f13202v = -1;
            d1Var.f13203w = -1;
        }
        this.f1467z = i;
        this.A = Integer.MIN_VALUE;
        p0();
    }

    @Override // v4.h0
    public final i0 s(Context context, AttributeSet attributeSet) {
        return new b1(context, attributeSet);
    }

    @Override // v4.h0
    public final int s0(int i, n0 n0Var, t0 t0Var) {
        return a1(i, n0Var, t0Var);
    }

    @Override // v4.h0
    public final i0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new b1((ViewGroup.MarginLayoutParams) layoutParams) : new b1(layoutParams);
    }

    @Override // v4.h0
    public final void v0(Rect rect, int i, int i10) {
        int iG;
        int iG2;
        int iE = E() + D();
        int iC = C() + F();
        int i11 = this.f1461t;
        int i12 = this.f1457p;
        if (i11 == 1) {
            int iHeight = rect.height() + iC;
            RecyclerView recyclerView = this.f13248b;
            WeakHashMap weakHashMap = m0.f11777a;
            iG2 = h0.g(i10, iHeight, recyclerView.getMinimumHeight());
            iG = h0.g(i, (this.f1462u * i12) + iE, this.f13248b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iE;
            RecyclerView recyclerView2 = this.f13248b;
            WeakHashMap weakHashMap2 = m0.f11777a;
            iG = h0.g(i, iWidth, recyclerView2.getMinimumWidth());
            iG2 = h0.g(i10, (this.f1462u * i12) + iC, this.f13248b.getMinimumHeight());
        }
        this.f13248b.setMeasuredDimension(iG, iG2);
    }

    @Override // v4.h0
    public final int x(n0 n0Var, t0 t0Var) {
        if (this.f1461t == 1) {
            return Math.min(this.f1457p, t0Var.b());
        }
        return -1;
    }
}
