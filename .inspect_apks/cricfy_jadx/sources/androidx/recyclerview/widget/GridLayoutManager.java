package androidx.recyclerview.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.fragment.app.h;
import g2.l0;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.WeakHashMap;
import q4.a;
import t0.m0;
import u0.c;
import u0.d;
import u0.e;
import v.g;
import v4.h0;
import v4.i0;
import v4.m;
import v4.n;
import v4.n0;
import v4.p;
import v4.q;
import v4.t0;
import v4.z;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
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
        this.K = new m();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        t1(h0.H(context, attributeSet, i, i10).f13232b);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final boolean D0() {
        return this.f1422z == null && !this.E;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(t0 t0Var, q qVar, g gVar) {
        int i;
        int iJ = this.F;
        for (int i10 = 0; i10 < this.F && (i = qVar.f13329d) >= 0 && i < t0Var.b() && iJ > 0; i10++) {
            int i11 = qVar.f13329d;
            gVar.b(i11, Math.max(0, qVar.f13331g));
            iJ -= this.K.j(i11);
            qVar.f13329d += qVar.f13330e;
        }
    }

    @Override // v4.h0
    public final int I(n0 n0Var, t0 t0Var) {
        if (this.f1412p == 0) {
            return Math.min(this.F, B());
        }
        if (t0Var.b() < 1) {
            return 0;
        }
        return p1(t0Var.b() - 1, n0Var, t0Var) + 1;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final View R0(n0 n0Var, t0 t0Var, boolean z10, boolean z11) {
        int i;
        int iV;
        int iV2 = v();
        int i10 = 1;
        if (z11) {
            iV = v() - 1;
            i = -1;
            i10 = -1;
        } else {
            i = iV2;
            iV = 0;
        }
        int iB = t0Var.b();
        K0();
        int iM = this.f1414r.m();
        int i11 = this.f1414r.i();
        View view = null;
        View view2 = null;
        while (iV != i) {
            View viewU = u(iV);
            int iG = h0.G(viewU);
            if (iG >= 0 && iG < iB && q1(iG, n0Var, t0Var) == 0) {
                if (((i0) viewU.getLayoutParams()).f13261a.h()) {
                    if (view2 == null) {
                        view2 = viewU;
                    }
                } else {
                    if (this.f1414r.g(viewU) < i11 && this.f1414r.d(viewU) >= iM) {
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
    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View T(android.view.View r23, int r24, v4.n0 r25, v4.t0 r26) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.GridLayoutManager.T(android.view.View, int, v4.n0, v4.t0):android.view.View");
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final void V(n0 n0Var, t0 t0Var, e eVar) {
        super.V(n0Var, t0Var, eVar);
        eVar.i(GridView.class.getName());
        z zVar = this.f13248b.H;
        if (zVar == null || zVar.a() <= 1) {
            return;
        }
        eVar.b(c.f12055p);
    }

    @Override // v4.h0
    public final void X(n0 n0Var, t0 t0Var, View view, e eVar) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!(layoutParams instanceof n)) {
            W(view, eVar);
            return;
        }
        n nVar = (n) layoutParams;
        int iP1 = p1(nVar.f13261a.b(), n0Var, t0Var);
        if (this.f1412p == 0) {
            eVar.j(d.a(nVar.f13306e, nVar.f, iP1, 1, false, false));
        } else {
            eVar.j(d.a(iP1, 1, nVar.f13306e, nVar.f, false, false));
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r12v26 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v34 */
    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void X0(n0 n0Var, t0 t0Var, q qVar, p pVar) {
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
        int iL = this.f1414r.l();
        boolean z10 = iL != 1073741824;
        int i13 = v() > 0 ? this.G[this.F] : 0;
        if (z10) {
            u1();
        }
        boolean z11 = qVar.f13330e == 1;
        int iQ1 = this.F;
        if (!z11) {
            iQ1 = q1(qVar.f13329d, n0Var, t0Var) + r1(qVar.f13329d, n0Var, t0Var);
        }
        int i14 = 0;
        while (i14 < this.F && (i12 = qVar.f13329d) >= 0 && i12 < t0Var.b() && iQ1 > 0) {
            int i15 = qVar.f13329d;
            int iR1 = r1(i15, n0Var, t0Var);
            if (iR1 > this.F) {
                throw new IllegalArgumentException(a.o(a.r(i15, iR1, "Item at position ", " requires ", " spans but GridLayoutManager has only "), this.F, " spans."));
            }
            iQ1 -= iR1;
            if (iQ1 < 0 || (viewB = qVar.b(n0Var)) == null) {
                break;
            }
            this.H[i14] = viewB;
            i14++;
        }
        if (i14 == 0) {
            pVar.f13322b = true;
            return;
        }
        if (z11) {
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
            n nVar = (n) view.getLayoutParams();
            int iR12 = r1(h0.G(view), n0Var, t0Var);
            nVar.f = iR12;
            nVar.f13306e = i16;
            i16 += iR12;
            i += i11;
        }
        float f = 0.0f;
        int i17 = 0;
        for (int i18 = 0; i18 < i14; i18++) {
            View view2 = this.H[i18];
            if (qVar.f13334k != null) {
                r12 = 0;
                r12 = 0;
                if (z11) {
                    b(view2, -1, true);
                } else {
                    b(view2, 0, true);
                }
            } else if (z11) {
                r12 = 0;
                b(view2, -1, false);
            } else {
                r12 = 0;
                b(view2, 0, false);
            }
            RecyclerView recyclerView = this.f13248b;
            Rect rect = this.L;
            if (recyclerView == null) {
                rect.set(r12, r12, r12, r12);
            } else {
                rect.set(recyclerView.N(view2));
            }
            s1(view2, iL, r12);
            int iE = this.f1414r.e(view2);
            if (iE > i17) {
                i17 = iE;
            }
            float f10 = (this.f1414r.f(view2) * 1.0f) / ((n) view2.getLayoutParams()).f;
            if (f10 > f) {
                f = f10;
            }
        }
        if (z10) {
            i1(Math.max(Math.round(f * this.F), i13));
            i17 = 0;
            for (int i19 = 0; i19 < i14; i19++) {
                View view3 = this.H[i19];
                s1(view3, 1073741824, true);
                int iE2 = this.f1414r.e(view3);
                if (iE2 > i17) {
                    i17 = iE2;
                }
            }
        }
        for (int i20 = 0; i20 < i14; i20++) {
            View view4 = this.H[i20];
            if (this.f1414r.e(view4) != i17) {
                n nVar2 = (n) view4.getLayoutParams();
                Rect rect2 = nVar2.f13262b;
                int i21 = rect2.top + rect2.bottom + ((ViewGroup.MarginLayoutParams) nVar2).topMargin + ((ViewGroup.MarginLayoutParams) nVar2).bottomMargin;
                int i22 = rect2.left + rect2.right + ((ViewGroup.MarginLayoutParams) nVar2).leftMargin + ((ViewGroup.MarginLayoutParams) nVar2).rightMargin;
                int iO1 = o1(nVar2.f13306e, nVar2.f);
                if (this.f1412p == 1) {
                    iW2 = h0.w(false, iO1, 1073741824, i22, ((ViewGroup.MarginLayoutParams) nVar2).width);
                    iW = View.MeasureSpec.makeMeasureSpec(i17 - i21, 1073741824);
                } else {
                    int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i17 - i22, 1073741824);
                    iW = h0.w(false, iO1, 1073741824, i21, ((ViewGroup.MarginLayoutParams) nVar2).height);
                    iW2 = iMakeMeasureSpec;
                }
                if (A0(view4, iW2, iW, (i0) view4.getLayoutParams())) {
                    view4.measure(iW2, iW);
                }
            }
        }
        pVar.f13321a = i17;
        if (this.f1412p != 1) {
            if (qVar.f == -1) {
                int i23 = qVar.f13327b;
                iD = i23 - i17;
                iF2 = 0;
                iF = i23;
            } else {
                int i24 = qVar.f13327b;
                iF = i24 + i17;
                iF2 = 0;
                iD = i24;
            }
            iF3 = iF2;
        } else if (qVar.f == -1) {
            iF3 = qVar.f13327b;
            iF2 = iF3 - i17;
            iD = 0;
            iF = 0;
        } else {
            int i25 = qVar.f13327b;
            iF = 0;
            iF2 = i25;
            iF3 = i25 + i17;
            iD = 0;
        }
        for (int i26 = 0; i26 < i14; i26++) {
            View view5 = this.H[i26];
            n nVar3 = (n) view5.getLayoutParams();
            if (this.f1412p != 1) {
                iF2 = F() + this.G[nVar3.f13306e];
                iF3 = this.f1414r.f(view5) + iF2;
            } else if (W0()) {
                int iD2 = D() + this.G[this.F - nVar3.f13306e];
                iF = iD2;
                iD = iD2 - this.f1414r.f(view5);
            } else {
                iD = D() + this.G[nVar3.f13306e];
                iF = this.f1414r.f(view5) + iD;
            }
            h0.N(view5, iD, iF2, iF, iF3);
            if (nVar3.f13261a.h() || nVar3.f13261a.k()) {
                pVar.f13323c = true;
            }
            pVar.f13324d = view5.hasFocusable() | pVar.f13324d;
        }
        Arrays.fill(this.H, (Object) null);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void Y0(n0 n0Var, t0 t0Var, l0 l0Var, int i) {
        u1();
        if (t0Var.b() > 0 && !t0Var.f13366g) {
            boolean z10 = i == 1;
            int iQ1 = q1(l0Var.f4793b, n0Var, t0Var);
            if (z10) {
                while (iQ1 > 0) {
                    int i10 = l0Var.f4793b;
                    if (i10 <= 0) {
                        break;
                    }
                    int i11 = i10 - 1;
                    l0Var.f4793b = i11;
                    iQ1 = q1(i11, n0Var, t0Var);
                }
            } else {
                int iB = t0Var.b() - 1;
                int i12 = l0Var.f4793b;
                while (i12 < iB) {
                    int i13 = i12 + 1;
                    int iQ12 = q1(i13, n0Var, t0Var);
                    if (iQ12 <= iQ1) {
                        break;
                    }
                    i12 = i13;
                    iQ1 = iQ12;
                }
                l0Var.f4793b = i12;
            }
        }
        j1();
    }

    @Override // v4.h0
    public final void Z(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f994b).clear();
    }

    @Override // v4.h0
    public final void a0() {
        this.K.k();
        ((SparseIntArray) this.K.f994b).clear();
    }

    @Override // v4.h0
    public final void b0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f994b).clear();
    }

    @Override // v4.h0
    public final void c0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f994b).clear();
    }

    @Override // v4.h0
    public final void d0(int i, int i10) {
        this.K.k();
        ((SparseIntArray) this.K.f994b).clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final void e0(n0 n0Var, t0 t0Var) {
        boolean z10 = t0Var.f13366g;
        SparseIntArray sparseIntArray = this.J;
        SparseIntArray sparseIntArray2 = this.I;
        if (z10) {
            int iV = v();
            for (int i = 0; i < iV; i++) {
                n nVar = (n) u(i).getLayoutParams();
                int iB = nVar.f13261a.b();
                sparseIntArray2.put(iB, nVar.f);
                sparseIntArray.put(iB, nVar.f13306e);
            }
        }
        super.e0(n0Var, t0Var);
        sparseIntArray2.clear();
        sparseIntArray.clear();
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void e1(boolean z10) {
        if (z10) {
            throw new UnsupportedOperationException("GridLayoutManager does not support stack from end. Consider using reverse layout");
        }
        super.e1(false);
    }

    @Override // v4.h0
    public final boolean f(i0 i0Var) {
        return i0Var instanceof n;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
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
    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int k(t0 t0Var) {
        return H0(t0Var);
    }

    public final int k1(int i) {
        if (this.f1412p == 0) {
            RecyclerView recyclerView = this.f13248b;
            return p1(i, recyclerView.f1451x, recyclerView.B0);
        }
        RecyclerView recyclerView2 = this.f13248b;
        return q1(i, recyclerView2.f1451x, recyclerView2.B0);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int l(t0 t0Var) {
        return I0(t0Var);
    }

    public final int l1(int i) {
        if (this.f1412p == 1) {
            RecyclerView recyclerView = this.f13248b;
            return p1(i, recyclerView.f1451x, recyclerView.B0);
        }
        RecyclerView recyclerView2 = this.f13248b;
        return q1(i, recyclerView2.f1451x, recyclerView2.B0);
    }

    public final HashSet m1(int i) {
        return n1(l1(i), i);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int n(t0 t0Var) {
        return H0(t0Var);
    }

    public final HashSet n1(int i, int i10) {
        HashSet hashSet = new HashSet();
        RecyclerView recyclerView = this.f13248b;
        int iR1 = r1(i10, recyclerView.f1451x, recyclerView.B0);
        for (int i11 = i; i11 < i + iR1; i11++) {
            hashSet.add(Integer.valueOf(i11));
        }
        return hashSet;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int o(t0 t0Var) {
        return I0(t0Var);
    }

    public final int o1(int i, int i10) {
        if (this.f1412p != 1 || !W0()) {
            int[] iArr = this.G;
            return iArr[i10 + i] - iArr[i];
        }
        int[] iArr2 = this.G;
        int i11 = this.F;
        return iArr2[i11 - i] - iArr2[(i11 - i) - i10];
    }

    public final int p1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f13366g) {
            return this.K.h(i, this.F);
        }
        int iB = n0Var.b(i);
        if (iB != -1) {
            return this.K.h(iB, this.F);
        }
        Log.w("GridLayoutManager", "Cannot find span size for pre layout position. " + i);
        return 0;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int q0(int i, n0 n0Var, t0 t0Var) {
        u1();
        j1();
        return super.q0(i, n0Var, t0Var);
    }

    public final int q1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f13366g) {
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final i0 r() {
        return this.f1412p == 0 ? new n(-2, -1) : new n(-1, -2);
    }

    public final int r1(int i, n0 n0Var, t0 t0Var) {
        if (!t0Var.f13366g) {
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

    @Override // v4.h0
    public final i0 s(Context context, AttributeSet attributeSet) {
        n nVar = new n(context, attributeSet);
        nVar.f13306e = -1;
        nVar.f = 0;
        return nVar;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final int s0(int i, n0 n0Var, t0 t0Var) {
        u1();
        j1();
        return super.s0(i, n0Var, t0Var);
    }

    public final void s1(View view, int i, boolean z10) {
        int iW;
        int iW2;
        n nVar = (n) view.getLayoutParams();
        Rect rect = nVar.f13262b;
        int i10 = rect.top + rect.bottom + ((ViewGroup.MarginLayoutParams) nVar).topMargin + ((ViewGroup.MarginLayoutParams) nVar).bottomMargin;
        int i11 = rect.left + rect.right + ((ViewGroup.MarginLayoutParams) nVar).leftMargin + ((ViewGroup.MarginLayoutParams) nVar).rightMargin;
        int iO1 = o1(nVar.f13306e, nVar.f);
        if (this.f1412p == 1) {
            iW2 = h0.w(false, iO1, i, i11, ((ViewGroup.MarginLayoutParams) nVar).width);
            iW = h0.w(true, this.f1414r.n(), this.f13257m, i10, ((ViewGroup.MarginLayoutParams) nVar).height);
        } else {
            int iW3 = h0.w(false, iO1, i, i10, ((ViewGroup.MarginLayoutParams) nVar).height);
            int iW4 = h0.w(true, this.f1414r.n(), this.f13256l, i11, ((ViewGroup.MarginLayoutParams) nVar).width);
            iW = iW3;
            iW2 = iW4;
        }
        i0 i0Var = (i0) view.getLayoutParams();
        if (z10 ? A0(view, iW2, iW, i0Var) : y0(view, iW2, iW, i0Var)) {
            view.measure(iW2, iW);
        }
    }

    @Override // v4.h0
    public final i0 t(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            n nVar = new n((ViewGroup.MarginLayoutParams) layoutParams);
            nVar.f13306e = -1;
            nVar.f = 0;
            return nVar;
        }
        n nVar2 = new n(layoutParams);
        nVar2.f13306e = -1;
        nVar2.f = 0;
        return nVar2;
    }

    public final void t1(int i) {
        if (i == this.F) {
            return;
        }
        this.E = true;
        if (i < 1) {
            throw new IllegalArgumentException(l0.e.g(i, "Span count should be at least 1. Provided "));
        }
        this.F = i;
        this.K.k();
        p0();
    }

    public final void u1() {
        int iC;
        int iF;
        if (this.f1412p == 1) {
            iC = this.f13258n - E();
            iF = D();
        } else {
            iC = this.f13259o - C();
            iF = F();
        }
        i1(iC - iF);
    }

    @Override // v4.h0
    public final void v0(Rect rect, int i, int i10) {
        int iG;
        int iG2;
        if (this.G == null) {
            super.v0(rect, i, i10);
        }
        int iE = E() + D();
        int iC = C() + F();
        if (this.f1412p == 1) {
            int iHeight = rect.height() + iC;
            RecyclerView recyclerView = this.f13248b;
            WeakHashMap weakHashMap = m0.f11777a;
            iG2 = h0.g(i10, iHeight, recyclerView.getMinimumHeight());
            int[] iArr = this.G;
            iG = h0.g(i, iArr[iArr.length - 1] + iE, this.f13248b.getMinimumWidth());
        } else {
            int iWidth = rect.width() + iE;
            RecyclerView recyclerView2 = this.f13248b;
            WeakHashMap weakHashMap2 = m0.f11777a;
            iG = h0.g(i, iWidth, recyclerView2.getMinimumWidth());
            int[] iArr2 = this.G;
            iG2 = h0.g(i10, iArr2[iArr2.length - 1] + iC, this.f13248b.getMinimumHeight());
        }
        this.f13248b.setMeasuredDimension(iG, iG2);
    }

    @Override // v4.h0
    public final int x(n0 n0Var, t0 t0Var) {
        if (this.f1412p == 1) {
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
        this.K = new m();
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
        this.K = new m();
        this.L = new Rect();
        this.M = -1;
        this.N = -1;
        this.O = -1;
        t1(i);
    }
}
