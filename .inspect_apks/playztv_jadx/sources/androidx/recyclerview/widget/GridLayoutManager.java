package androidx.recyclerview.widget;

import a2.u0;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.h;
import e6.j;
import e7.c;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import l4.a;
import q0.o0;
import q4.h0;
import q4.i0;
import q4.k;
import q4.n;
import q4.n0;
import q4.o;
import q4.q;
import q4.r;
import q4.t0;
import q4.z;
import r0.d;
import r0.e;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class GridLayoutManager extends LinearLayoutManager {
    public static final Set P = Collections.unmodifiableSet(new HashSet(Arrays.asList(17, 66, 33, 130)));
    public boolean E;
    public int F;
    public int[] G;
    public View[] H;
    public final SparseIntArray I;
    public final SparseIntArray J;
    public h K;
    public final Rect L;
    public int M;
    public int N;
    public int O;

    public GridLayoutManager(Context context, AttributeSet attributeSet, int i, int i10) {
        super(context, attributeSet, i, i10);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new n();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        t1(h0.H(context, attributeSet, i, i10).f10798b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final boolean D0() {
        return this.f1639z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(t0 t0Var, r rVar, k kVar) {
        int i;
        int iJ = this.F;
        for (int i10 = 0; i10 < this.F && (i = rVar.f10905d) >= 0 && i < t0Var.b() && iJ > 0; i10++) {
            int i11 = rVar.f10905d;
            kVar.b(i11, Math.max(0, rVar.f10907g));
            iJ -= this.K.j(i11);
            rVar.f10905d += rVar.f10906e;
        }
    }

    @Override // q4.h0
    public final int I(n0 n0Var, t0 t0Var) {
        if (this.f1629p == 0) {
            return Math.min(this.F, B());
        }
        if (t0Var.b() < 1) {
            return 0;
        }
        return p1(t0Var.b() - 1, n0Var, t0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View R0(n0 n0Var, t0 t0Var, boolean z2, boolean z10) {
        int i;
        int iV;
        int iV2 = v();
        int i10 = 1;
        if (z10) {
            iV = v() - 1;
            i = -1;
            i10 = -1;
        } else {
            i = iV2;
            iV = 0;
        }
        int iB = t0Var.b();
        K0();
        int iM = this.f1631r.m();
        int i11 = this.f1631r.i();
        View view = null;
        View view2 = null;
        while (iV != i) {
            View viewU = u(iV);
            int iG = h0.G(viewU);
            if (iG >= 0 && iG < iB && q1(iG, n0Var, t0Var) == 0) {
                if (((i0) viewU.getLayoutParams()).f10831a.h()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.f1631r.g(viewU) < i11 && this.f1631r.d(viewU) >= iM) {
                        return viewU;
                    }
                    if (view == null) {
                        view = viewU;
                    }
                }
            }
            iV += i10;
        }
        return view != null ? view : view2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e2, code lost:
    
        if (r13 == (r2 > r15)) goto L57;
     */
    /* JADX WARN: Code restructure failed: missing block: B:84:0x0142, code lost:
    
        if (r16 == null) goto L86;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0144, code lost:
    
        return r16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0145, code lost:
    
        return r17;
     */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r23, int r24, q4.n0 r25, q4.t0 r26) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.T(android.view.View, int, q4.n0, q4.t0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final void V(n0 n0Var, t0 t0Var, e eVar) {
        super.V(n0Var, t0Var, eVar);
        eVar.i(GridView.class.getName());
        z zVar = this.f10818b.G;
        if (zVar == null || zVar.a() <= 1) {
            return;
        }
        eVar.b(d.f11220p);
    }

    @Override // q4.h0
    public final void X(n0 n0Var, t0 t0Var, View view, e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof o)) {
            W(view, eVar);
            return;
        }
        o oVar = (o) layoutParams;
        int iP1 = p1(oVar.f10831a.b(), n0Var, t0Var);
        if (this.f1629p == 0) {
            eVar.j(c.a(oVar.f10888e, oVar.f, iP1, 1, false, false));
        } else {
            eVar.j(c.a(iP1, 1, oVar.f10888e, oVar.f, false, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v34 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void X0(n0 n0Var, t0 t0Var, r rVar, q qVar) {
        int i;
        int i10;
        int i11;
        int iF;
        int iF2;
        int iD;
        int iF3;
        int iW;
        int iW2;
        ?? r12;
        int i12;
        View viewB;
        int iL = this.f1631r.l();
        boolean z2 = iL != 1073741824;
        int i13 = v() > 0 ? this.G[this.F] : 0;
        if (z2) {
            u1();
        }
        boolean z10 = rVar.f10906e == 1;
        int iQ1 = this.F;
        if (!z10) {
            iQ1 = q1(rVar.f10905d, n0Var, t0Var) + r1(rVar.f10905d, n0Var, t0Var);
        }
        int i14 = 0;
        while (i14 < this.F && (i12 = rVar.f10905d) >= 0 && i12 < t0Var.b() && iQ1 > 0) {
            int i15 = rVar.f10905d;
            int iR1 = r1(i15, n0Var, t0Var);
            if (iR1 > this.F) {
                throw new IllegalArgumentException(x.c.a(a.p(i15, iR1, "Item at position ", " requires ", " spans but GridLayoutManager has only "), this.F, " spans."));
            }
            iQ1 -= iR1;
            if (iQ1 < 0 || (viewB = rVar.b(n0Var)) == null) {
                break;
            }
            this.H[i14] = viewB;
            i14++;
        }
        if (i14 == 0) {
            qVar.f10898b = true;
            return;
        }
        if (z10) {
            i11 = 1;
            i10 = i14;
            i = 0;
        } else {
            i = i14 - 1;
            i10 = -1;
            i11 = -1;
        }
        int i16 = 0;
        while (i != i10) {
            View view = this.H[i];
            o oVar = (o) view.getLayoutParams();
            int iR12 = r1(h0.G(view), n0Var, t0Var);
            oVar.f = iR12;
            oVar.f10888e = i16;
            i16 += iR12;
            i += i11;
        }
        float f = 0.0f;
        int i17 = 0;
        for (int i18 = 0; i18 < i14; i18++) {
            View view2 = this.H[i18];
            if (rVar.f10910k != null) {
                r12 = 0;
                r12 = 0;
                if (z10) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z10) {
                r12 = 0;
                b(view2, -1, false);
            } else {
                r12 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.f10818b;
            Rect rect = this.L;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.N(view2));
            }
            s1(view2, iL, r12);
            int iE = this.f1631r.e(view2);
            if (iE > i17) {
                i17 = iE;
            }
            float f4 = (this.f1631r.f(view2) * 1.0f) / ((o) view2.getLayoutParams()).f;
            if (f4 > f) {
                f = f4;
            }
        }
        if (z2) {
            i1(Math.max(Math.round(f * this.F), i13));
            i17 = 0;
            for (int i19 = 0; i19 < i14; i19++) {
                View view3 = this.H[i19];
                s1(view3, 1073741824, true);
                int iE2 = this.f1631r.e(view3);
                if (iE2 > i17) {
                    i17 = iE2;
                }
            }
        }
        for (int i20 = 0; i20 < i14; i20++) {
            View view4 = this.H[i20];
            if (this.f1631r.e(view4) != i17) {
                o oVar2 = (o) view4.getLayoutParams();
                Rect rect2 = oVar2.f10832b;
                int i21 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) oVar2).topMargin + ((ViewGroup.MarginLayoutParams) oVar2).bottomMargin;
                int i22 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) oVar2).leftMargin + ((ViewGroup.MarginLayoutParams) oVar2).rightMargin;
                int iO1 = o1(oVar2.f10888e, oVar2.f);
                if (this.f1629p == 1) {
                    iW2 = h0.w(false, iO1, 1073741824, i22, ((ViewGroup.MarginLayoutParams) oVar2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i22, 1073741824);
                    iW = h0.w(false, iO1, 1073741824, i21, ((ViewGroup.MarginLayoutParams) oVar2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (A0(view4, iW2, iW, (i0) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        qVar.f10897a = i17;
        if (this.f1629p != 1) {
            if (rVar.f == -1) {
                int i23 = rVar.f10903b;
                iD = i23 - i17;
                iF2 = 0;
                iF = i23;
            } else {
                int i24 = rVar.f10903b;
                iF = i24 + i17;
                iF2 = 0;
                iD = i24;
            }
            iF3 = iF2;
        } else if (rVar.f == -1) {
            iF3 = rVar.f10903b;
            iF2 = iF3 - i17;
            iD = 0;
            iF = 0;
        } else {
            int i25 = rVar.f10903b;
            iF = 0;
            iF2 = i25;
            iF3 = i25 + i17;
            iD = 0;
        }
        for (int i26 = 0; i26 < i14; i26++) {
            View view5 = this.H[i26];
            o oVar3 = (o) view5.getLayoutParams();
            if (this.f1629p != 1) {
                iF2 = F() + this.G[oVar3.f10888e];
                iF3 = this.f1631r.f(view5) + iF2;
            } else if (W0()) {
                int iD2 = D() + this.G[this.F - oVar3.f10888e];
                iF = iD2;
                iD = iD2 - this.f1631r.f(view5);
            } else {
                iD = D() + this.G[oVar3.f10888e];
                iF = this.f1631r.f(view5) + iD;
            }
            h0.N(view5, iD, iF2, iF, iF3);
            if (oVar3.f10831a.h() || oVar3.f10831a.k()) {
                qVar.f10899c = true;
            }
            qVar.f10900d = view5.hasFocusable() | qVar.f10900d;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Y0(n0 n0Var, t0 t0Var, u0 u0Var, int i) {
        u1();
        if (t0Var.b() > 0 && !t0Var.f10940g) {
            boolean z2 = i == 1;
            int iQ1 = q1(u0Var.f443b, n0Var, t0Var);
            if (z2) {
                while (iQ1 > 0) {
                    int i10 = u0Var.f443b;
                    if (i10 <= 0) {
                        break;
                    }
                    int i11 = i10 - 1;
                    u0Var.f443b = i11;
                    iQ1 = q1(i11, n0Var, t0Var);
                }
            } else {
                int iB = t0Var.b() - 1;
                int i12 = u0Var.f443b;
                while (i12 < iB) {
                    int i13 = i12 + 1;
                    int iQ12 = q1(i13, n0Var, t0Var);
                    if (iQ12 <= iQ1) {
                        break;
                    }
                    i12 = i13;
                    iQ1 = iQ12;
                }
                u0Var.f443b = i12;
            }
        }
        j1();
    }

    @Override // q4.h0
    public final void Z(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f1283b).clear();
    }

    @Override // q4.h0
    public final void a0() {
        this.K.k();
        ((SparseIntArray) this.K.f1283b).clear();
    }

    @Override // q4.h0
    public final void b0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f1283b).clear();
    }

    @Override // q4.h0
    public final void c0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f1283b).clear();
    }

    @Override // q4.h0
    public final void d0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f1283b).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final void e0(n0 n0Var, t0 t0Var) {
        boolean z2 = t0Var.f10940g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z2) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                o oVar = (o) u(i).getLayoutParams();
                int iB = oVar.f10831a.b();
                sparseIntArray2.put(iB, oVar.f);
                sparseIntArray.put(iB, oVar.f10888e);
            }
        }
        super.e0(n0Var, t0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void e1(boolean z2) {
        if (z2) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.e1(false);
    }

    @Override // q4.h0
    public final boolean f(i0 i0Var) {
        return i0Var instanceof o;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final void f0(t0 t0Var) {
        View viewQ;
        super.f0(t0Var);
        this.E = false;
        int i = this.M;
        if (i == -1 || (viewQ = q(i)) == null) {
            return;
        }
        viewQ.sendAccessibilityEvent(67108864);
        this.M = -1;
    }

    public final void i1(int i) {
        int i10;
        int[] iArr = this.G;
        int i11 = this.F;
        if (iArr == null || iArr.length != i11 + 1 || iArr[iArr.length - 1] != i) {
            iArr = new int[i11 + 1];
        }
        int i12 = 0;
        iArr[0] = 0;
        int i13 = i / i11;
        int i14 = i % i11;
        int i15 = 0;
        for (int i16 = 1; i16 <= i11; i16++) {
            i12 += i14;
            if (i12 <= 0 || i11 - i12 >= i14) {
                i10 = i13;
            } else {
                i10 = i13 + 1;
                i12 -= i11;
            }
            i15 += i10;
            iArr[i16] = i15;
        }
        this.G = iArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:122:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x01af A[EDGE_INSN: B:214:0x01af->B:126:0x01af BREAK  A[LOOP:2: B:130:0x01bf->B:139:0x01e8, LOOP_LABEL: LOOP:2: B:130:0x01bf->B:139:0x01e8], EDGE_INSN: B:220:0x01af->B:126:0x01af BREAK  A[LOOP:5: B:152:0x0227->B:163:0x0257, LOOP_LABEL: LOOP:5: B:152:0x0227->B:163:0x0257]] */
    /* JADX WARN: Removed duplicated region for block: B:146:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0284  */
    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean j0(int r12, android.os.Bundle r13) {
        /*
            Method dump skipped, instruction units count: 745
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.j0(int, android.os.Bundle):boolean");
    }

    public final void j1() {
        View[] viewArr = this.H;
        if (viewArr == null || viewArr.length != this.F) {
            this.H = new View[this.F];
        }
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int k(t0 t0Var) {
        return H0(t0Var);
    }

    public final int k1(int i) {
        if (this.f1629p == 0) {
            RecyclerView recyclerView = this.f10818b;
            return p1(i, recyclerView.f1666w, recyclerView.A0);
        }
        RecyclerView recyclerView2 = this.f10818b;
        return q1(i, recyclerView2.f1666w, recyclerView2.A0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int l(t0 t0Var) {
        return I0(t0Var);
    }

    public final int l1(int i) {
        if (this.f1629p == 1) {
            RecyclerView recyclerView = this.f10818b;
            return p1(i, recyclerView.f1666w, recyclerView.A0);
        }
        RecyclerView recyclerView2 = this.f10818b;
        return q1(i, recyclerView2.f1666w, recyclerView2.A0);
    }

    public final HashSet m1(int i) {
        return n1(l1(i), i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int n(t0 t0Var) {
        return H0(t0Var);
    }

    public final HashSet n1(int i, int i10) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.f10818b;
        int iR1 = r1(i10, recyclerView.f1666w, recyclerView.A0);
        for (int i11 = i; i11 < i + iR1; i11++) {
            hashSet.add(Integer.valueOf(i11));
        }
        return hashSet;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int o(t0 t0Var) {
        return I0(t0Var);
    }

    public final int o1(int i, int i10) {
        if (this.f1629p != 1 || !W0()) {
            int[] iArr = this.G;
            return iArr[i10 + i] - iArr[i];
        }
        int[] iArr2 = this.G;
        int i11 = this.F;
        return iArr2[i11 - i] - iArr2[(i11 - i) - i10];
    }

    public final int p1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f10940g) {
            return this.K.h(i, this.F);
        }
        int iB = n0Var.b(i);
        if (iB != -1) {
            return this.K.h(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int q0(int i, n0 n0Var, t0 t0Var) {
        u1();
        j1();
        return super.q0(i, n0Var, t0Var);
    }

    public final int q1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f10940g) {
            return this.K.i(i, this.F);
        }
        int i10 = this.J.get(i, -1);
        if (i10 != -1) {
            return i10;
        }
        int iB = n0Var.b(i);
        if (iB != -1) {
            return this.K.i(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final i0 r() {
        return this.f1629p == 0 ? new o(-2, -1) : new o(-1, -2);
    }

    public final int r1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f10940g) {
            return this.K.j(i);
        }
        int i10 = this.I.get(i, -1);
        if (i10 != -1) {
            return i10;
        }
        int iB = n0Var.b(i);
        if (iB != -1) {
            return this.K.j(iB);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. It is not cached, not in the adapter. Pos:" + i);
        return 1;
    }

    @Override // q4.h0
    public final i0 s(Context context, AttributeSet attributeSet) {
        o oVar = new o(context, attributeSet);
        oVar.f10888e = -1;
        oVar.f = 0;
        return oVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final int s0(int i, n0 n0Var, t0 t0Var) {
        u1();
        j1();
        return super.s0(i, n0Var, t0Var);
    }

    public final void s1(View view, int i, boolean z2) {
        int iW;
        int iW2;
        o oVar = (o) view.getLayoutParams();
        Rect rect = oVar.f10832b;
        int i10 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) oVar).topMargin + ((ViewGroup.MarginLayoutParams) oVar).bottomMargin;
        int i11 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) oVar).leftMargin + ((ViewGroup.MarginLayoutParams) oVar).rightMargin;
        int iO1 = o1(oVar.f10888e, oVar.f);
        if (this.f1629p == 1) {
            iW2 = h0.w(false, iO1, i, i11, ((ViewGroup.MarginLayoutParams) oVar).width);
            iW = h0.w(true, this.f1631r.n(), this.f10827m, i10, ((ViewGroup.MarginLayoutParams) oVar).height);
        } else {
            int iW3 = h0.w(false, iO1, i, i10, ((ViewGroup.MarginLayoutParams) oVar).height);
            int iW4 = h0.w(true, this.f1631r.n(), this.f10826l, i11, ((ViewGroup.MarginLayoutParams) oVar).width);
            iW = iW3;
            iW2 = iW4;
        }
        i0 i0Var = (i0) view.getLayoutParams();
        if (z2 ? A0(view, iW2, iW, i0Var) : y0(view, iW2, iW, i0Var)) {
            view.measure(iW2, iW);
        }
    }

    @Override // q4.h0
    public final i0 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            o oVar = new o((ViewGroup.MarginLayoutParams) layoutParams);
            oVar.f10888e = -1;
            oVar.f = 0;
            return oVar;
        }
        o oVar2 = new o(layoutParams);
        oVar2.f10888e = -1;
        oVar2.f = 0;
        return oVar2;
    }

    public final void t1(int i) {
        if (i == this.F) {
            return;
        }
        this.E = true;
        if (i < 1) {
            throw new IllegalArgumentException(j.l("Span count should be at least 1. Provided ", i));
        }
        this.F = i;
        this.K.k();
        p0();
    }

    public final void u1() {
        int iC;
        int iF;
        if (this.f1629p == 1) {
            iC = this.f10828n - E();
            iF = D();
        } else {
            iC = this.f10829o - C();
            iF = F();
        }
        i1(iC - iF);
    }

    @Override // q4.h0
    public final void v0(Rect rect, int i, int i10) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.v0(rect, i, i10);
        }
        int iE = E() + D();
        int iC = C() + F();
        if (this.f1629p == 1) {
            int iHeight = rect.height() + iC;
            RecyclerView recyclerView = this.f10818b;
            WeakHashMap weakHashMap = o0.f10475a;
            iG2 = h0.g(i10, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = h0.g(i, iArr[iArr.length - 1] + iE, this.f10818b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iE;
            RecyclerView recyclerView2 = this.f10818b;
            WeakHashMap weakHashMap2 = o0.f10475a;
            iG = h0.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = h0.g(i10, iArr2[iArr2.length - 1] + iC, this.f10818b.getMinimumHeight());
        }
        this.f10818b.setMeasuredDimension(iG, iG2);
    }

    @Override // q4.h0
    public final int x(n0 n0Var, t0 t0Var) {
        if (this.f1629p == 1) {
            return Math.min(this.F, B());
        }
        if (t0Var.b() < 1) {
            return 0;
        }
        return p1(t0Var.b() - 1, n0Var, t0Var) + 1;
    }

    public GridLayoutManager(int i, int i10) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new n();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        t1(i);
    }

    public GridLayoutManager(int i) {
        super(1);
        this.E = false;
        this.F = -1;
        this.I = new SparseIntArray();
        this.J = new SparseIntArray();
        this.K = new n();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        t1(i);
    }
}
