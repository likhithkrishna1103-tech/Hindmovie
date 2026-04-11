package q4;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public d4.e0 f10817a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f10818b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final pb.c f10819c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final pb.c f10820d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f10821e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f10822g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f10823h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f10824j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f10825k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f10826l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f10827m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f10828n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f10829o;

    public h0() {
        o4.c cVar = new o4.c(this);
        q0.e eVar = new q0.e(4, this);
        this.f10819c = new pb.c(cVar);
        this.f10820d = new pb.c(eVar);
        this.f = false;
        this.f10822g = false;
        this.f10823h = true;
        this.i = true;
    }

    public static int A(View view) {
        Rect rect = ((i0) view.getLayoutParams()).f10832b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int G(View view) {
        return ((i0) view.getLayoutParams()).f10831a.b();
    }

    public static g0 H(Context context, AttributeSet attributeSet, int i, int i10) {
        g0 g0Var = new g0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p4.c.RecyclerView, i, i10);
        g0Var.f10797a = typedArrayObtainStyledAttributes.getInt(p4.c.RecyclerView_android_orientation, 1);
        g0Var.f10798b = typedArrayObtainStyledAttributes.getInt(p4.c.RecyclerView_spanCount, 1);
        g0Var.f10799c = typedArrayObtainStyledAttributes.getBoolean(p4.c.RecyclerView_reverseLayout, false);
        g0Var.f10800d = typedArrayObtainStyledAttributes.getBoolean(p4.c.RecyclerView_stackFromEnd, false);
        typedArrayObtainStyledAttributes.recycle();
        return g0Var;
    }

    public static boolean M(int i, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i10);
        if (i11 > 0 && i != i11) {
            return false;
        }
        if (mode == Integer.MIN_VALUE) {
            return size >= i;
        }
        if (mode != 0) {
            return mode == 1073741824 && size == i;
        }
        return true;
    }

    public static void N(View view, int i, int i10, int i11, int i12) {
        i0 i0Var = (i0) view.getLayoutParams();
        Rect rect = i0Var.f10832b;
        view.layout(i + rect.left + ((ViewGroup.MarginLayoutParams) i0Var).leftMargin, i10 + rect.top + ((ViewGroup.MarginLayoutParams) i0Var).topMargin, (i11 - rect.right) - ((ViewGroup.MarginLayoutParams) i0Var).rightMargin, (i12 - rect.bottom) - ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin);
    }

    public static int g(int i, int i10, int i11) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i10, i11) : size : Math.min(size, Math.max(i10, i11));
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x001a  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static int w(boolean r4, int r5, int r6, int r7, int r8) {
        /*
            int r5 = r5 - r7
            r7 = 0
            int r5 = java.lang.Math.max(r7, r5)
            r0 = -2
            r1 = -1
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = 1073741824(0x40000000, float:2.0)
            if (r4 == 0) goto L1d
            if (r8 < 0) goto L12
        L10:
            r6 = r3
            goto L30
        L12:
            if (r8 != r1) goto L1a
            if (r6 == r2) goto L22
            if (r6 == 0) goto L1a
            if (r6 == r3) goto L22
        L1a:
            r6 = r7
            r8 = r6
            goto L30
        L1d:
            if (r8 < 0) goto L20
            goto L10
        L20:
            if (r8 != r1) goto L24
        L22:
            r8 = r5
            goto L30
        L24:
            if (r8 != r0) goto L1a
            if (r6 == r2) goto L2e
            if (r6 != r3) goto L2b
            goto L2e
        L2b:
            r8 = r5
            r6 = r7
            goto L30
        L2e:
            r8 = r5
            r6 = r2
        L30:
            int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r8, r6)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.h0.w(boolean, int, int, int, int):int");
    }

    public static int z(View view) {
        Rect rect = ((i0) view.getLayoutParams()).f10832b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final boolean A0(View view, int i, int i10, i0 i0Var) {
        return (this.f10823h && M(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) i0Var).width) && M(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) i0Var).height)) ? false : true;
    }

    public final int B() {
        RecyclerView recyclerView = this.f10818b;
        z adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public abstract void B0(RecyclerView recyclerView, int i);

    public final int C() {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final void C0(t tVar) {
        t tVar2 = this.f10821e;
        if (tVar2 != null && tVar != tVar2 && tVar2.f10925e) {
            tVar2.i();
        }
        this.f10821e = tVar;
        RecyclerView recyclerView = this.f10818b;
        w0 w0Var = recyclerView.f1669x0;
        w0Var.A.removeCallbacks(w0Var);
        w0Var.f10955w.abortAnimation();
        if (tVar.f10927h) {
            Log.w("RecyclerView", "An instance of " + tVar.getClass().getSimpleName() + " was started more than once. Each instance of" + tVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        tVar.f10922b = recyclerView;
        tVar.f10923c = this;
        int i = tVar.f10921a;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.A0.f10935a = i;
        tVar.f10925e = true;
        tVar.f10924d = true;
        tVar.f = recyclerView.H.q(i);
        tVar.f10922b.f1669x0.b();
        tVar.f10927h = true;
    }

    public final int D() {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public boolean D0() {
        return false;
    }

    public final int E() {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int F() {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int I(n0 n0Var, t0 t0Var) {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView == null || recyclerView.G == null || !e()) {
            return 1;
        }
        return this.f10818b.G.a();
    }

    public final void J(Rect rect, View view) {
        Matrix matrix;
        Rect rect2 = ((i0) view.getLayoutParams()).f10832b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f10818b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f10818b.F;
            rectF.set(rect);
            matrix.mapRect(rectF);
            rect.set((int) Math.floor(rectF.left), (int) Math.floor(rectF.top), (int) Math.ceil(rectF.right), (int) Math.ceil(rectF.bottom));
        }
        rect.offset(view.getLeft(), view.getTop());
    }

    public abstract boolean K();

    public boolean L() {
        return false;
    }

    public void O(int i) {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            int i10 = recyclerView.f1672z.i();
            for (int i11 = 0; i11 < i10; i11++) {
                recyclerView.f1672z.h(i11).offsetLeftAndRight(i);
            }
        }
    }

    public void P(int i) {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            int i10 = recyclerView.f1672z.i();
            for (int i11 = 0; i11 < i10; i11++) {
                recyclerView.f1672z.h(i11).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void S(RecyclerView recyclerView);

    public abstract View T(View view, int i, n0 n0Var, t0 t0Var);

    public void U(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f10818b;
        n0 n0Var = recyclerView.f1666w;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z2 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f10818b.canScrollVertically(-1) && !this.f10818b.canScrollHorizontally(-1) && !this.f10818b.canScrollHorizontally(1)) {
            z2 = false;
        }
        accessibilityEvent.setScrollable(z2);
        z zVar = this.f10818b.G;
        if (zVar != null) {
            accessibilityEvent.setItemCount(zVar.a());
        }
    }

    public void V(n0 n0Var, t0 t0Var, r0.e eVar) {
        if (this.f10818b.canScrollVertically(-1) || this.f10818b.canScrollHorizontally(-1)) {
            eVar.a(8192);
            eVar.l(true);
            eVar.h(67108864, true);
        }
        if (this.f10818b.canScrollVertically(1) || this.f10818b.canScrollHorizontally(1)) {
            eVar.a(4096);
            eVar.l(true);
            eVar.h(67108864, true);
        }
        eVar.f11226a.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) n.a1.x(I(n0Var, t0Var), x(n0Var, t0Var), 0).f8343u);
    }

    public final void W(View view, r0.e eVar) {
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM == null || x0VarM.h()) {
            return;
        }
        d4.e0 e0Var = this.f10817a;
        if (((ArrayList) e0Var.f3840y).contains(x0VarM.f10962a)) {
            return;
        }
        RecyclerView recyclerView = this.f10818b;
        X(recyclerView.f1666w, recyclerView.A0, view, eVar);
    }

    public void X(n0 n0Var, t0 t0Var, View view, r0.e eVar) {
        eVar.j(e7.c.a(e() ? G(view) : 0, 1, d() ? G(view) : 0, 1, false, false));
    }

    public final void b(View view, int i, boolean z2) {
        x0 x0VarM = RecyclerView.M(view);
        if (z2 || x0VarM.h()) {
            s.i iVar = (s.i) this.f10818b.A.f10130v;
            g1 g1VarA = (g1) iVar.get(x0VarM);
            if (g1VarA == null) {
                g1VarA = g1.a();
                iVar.put(x0VarM, g1VarA);
            }
            g1VarA.f10802a |= 1;
        } else {
            this.f10818b.A.t(x0VarM);
        }
        i0 i0Var = (i0) view.getLayoutParams();
        if (x0VarM.p() || x0VarM.i()) {
            if (x0VarM.i()) {
                x0VarM.f10973n.l(x0VarM);
            } else {
                x0VarM.f10969j &= -33;
            }
            this.f10817a.c(view, i, view.getLayoutParams(), false);
        } else {
            if (view.getParent() == this.f10818b) {
                d4.e0 e0Var = this.f10817a;
                af.a aVar = (af.a) e0Var.f3839x;
                int iIndexOfChild = ((RecyclerView) ((q0.e) e0Var.f3838w).f10436v).indexOfChild(view);
                int iD = (iIndexOfChild == -1 || aVar.G(iIndexOfChild)) ? -1 : iIndexOfChild - aVar.D(iIndexOfChild);
                if (i == -1) {
                    i = this.f10817a.i();
                }
                if (iD == -1) {
                    StringBuilder sb2 = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb2.append(this.f10818b.indexOfChild(view));
                    throw new IllegalStateException(e6.j.k(this.f10818b, sb2));
                }
                if (iD != i) {
                    h0 h0Var = this.f10818b.H;
                    View viewU = h0Var.u(iD);
                    if (viewU == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iD + h0Var.f10818b.toString());
                    }
                    h0Var.u(iD);
                    h0Var.f10817a.f(iD);
                    i0 i0Var2 = (i0) viewU.getLayoutParams();
                    x0 x0VarM2 = RecyclerView.M(viewU);
                    if (x0VarM2.h()) {
                        s.i iVar2 = (s.i) h0Var.f10818b.A.f10130v;
                        g1 g1VarA2 = (g1) iVar2.get(x0VarM2);
                        if (g1VarA2 == null) {
                            g1VarA2 = g1.a();
                            iVar2.put(x0VarM2, g1VarA2);
                        }
                        g1VarA2.f10802a = 1 | g1VarA2.f10802a;
                    } else {
                        h0Var.f10818b.A.t(x0VarM2);
                    }
                    h0Var.f10817a.c(viewU, i, i0Var2, x0VarM2.h());
                }
            } else {
                this.f10817a.b(view, i, false);
                i0Var.f10833c = true;
                t tVar = this.f10821e;
                if (tVar != null && tVar.f10925e) {
                    tVar.f10922b.getClass();
                    x0 x0VarM3 = RecyclerView.M(view);
                    if ((x0VarM3 != null ? x0VarM3.b() : -1) == tVar.f10921a) {
                        tVar.f = view;
                        if (RecyclerView.W0) {
                            Log.d("RecyclerView", "smooth scroll target view has been attached");
                        }
                    }
                }
            }
        }
        if (i0Var.f10834d) {
            if (RecyclerView.W0) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + i0Var.f10831a);
            }
            x0VarM.f10962a.invalidate();
            i0Var.f10834d = false;
        }
    }

    public void c(String str) {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            recyclerView.k(str);
        }
    }

    public abstract boolean d();

    public abstract boolean e();

    public abstract void e0(n0 n0Var, t0 t0Var);

    public boolean f(i0 i0Var) {
        return i0Var != null;
    }

    public abstract void f0(t0 t0Var);

    public Parcelable h0() {
        return null;
    }

    public abstract int j(t0 t0Var);

    /* JADX WARN: Removed duplicated region for block: B:18:0x0060 A[PHI: r0
      0x0060: PHI (r0v8 int) = (r0v5 int), (r0v15 int) binds: [B:24:0x007c, B:16:0x0052] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean j0(int r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instruction units count: 244
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.h0.j0(int, android.os.Bundle):boolean");
    }

    public abstract int k(t0 t0Var);

    public final void k0(n0 n0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.M(u(iV)).o()) {
                View viewU = u(iV);
                n0(iV);
                n0Var.h(viewU);
            }
        }
    }

    public abstract int l(t0 t0Var);

    public final void l0(n0 n0Var) {
        ArrayList arrayList = n0Var.f10881a;
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((x0) arrayList.get(i)).f10962a;
            x0 x0VarM = RecyclerView.M(view);
            if (!x0VarM.o()) {
                x0VarM.n(false);
                if (x0VarM.j()) {
                    this.f10818b.removeDetachedView(view, false);
                }
                e0 e0Var = this.f10818b.f1651i0;
                if (e0Var != null) {
                    e0Var.d(x0VarM);
                }
                x0VarM.n(true);
                x0 x0VarM2 = RecyclerView.M(view);
                x0VarM2.f10973n = null;
                x0VarM2.f10974o = false;
                x0VarM2.f10969j &= -33;
                n0Var.i(x0VarM2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = n0Var.f10882b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f10818b.invalidate();
        }
    }

    public abstract int m(t0 t0Var);

    public final void m0(View view, n0 n0Var) {
        d4.e0 e0Var = this.f10817a;
        q0.e eVar = (q0.e) e0Var.f3838w;
        int i = e0Var.f3837v;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            e0Var.f3837v = 1;
            e0Var.f3841z = view;
            int iIndexOfChild = ((RecyclerView) eVar.f10436v).indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((af.a) e0Var.f3839x).J(iIndexOfChild)) {
                    e0Var.n(view);
                }
                eVar.m(iIndexOfChild);
            }
            e0Var.f3837v = 0;
            e0Var.f3841z = null;
            n0Var.h(view);
        } catch (Throwable th) {
            e0Var.f3837v = 0;
            e0Var.f3841z = null;
            throw th;
        }
    }

    public abstract int n(t0 t0Var);

    public final void n0(int i) {
        if (u(i) != null) {
            d4.e0 e0Var = this.f10817a;
            q0.e eVar = (q0.e) e0Var.f3838w;
            int i10 = e0Var.f3837v;
            if (i10 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i10 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iJ = e0Var.j(i);
                View childAt = ((RecyclerView) eVar.f10436v).getChildAt(iJ);
                if (childAt != null) {
                    e0Var.f3837v = 1;
                    e0Var.f3841z = childAt;
                    if (((af.a) e0Var.f3839x).J(iJ)) {
                        e0Var.n(childAt);
                    }
                    eVar.m(iJ);
                }
                e0Var.f3837v = 0;
                e0Var.f3841z = null;
            } catch (Throwable th) {
                e0Var.f3837v = 0;
                e0Var.f3841z = null;
                throw th;
            }
        }
    }

    public abstract int o(t0 t0Var);

    /* JADX WARN: Removed duplicated region for block: B:28:0x00b0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean o0(androidx.recyclerview.widget.RecyclerView r9, android.view.View r10, android.graphics.Rect r11, boolean r12, boolean r13) {
        /*
            r8 = this;
            int r0 = r8.D()
            int r1 = r8.F()
            int r2 = r8.f10828n
            int r3 = r8.E()
            int r2 = r2 - r3
            int r3 = r8.f10829o
            int r4 = r8.C()
            int r3 = r3 - r4
            int r4 = r10.getLeft()
            int r5 = r11.left
            int r4 = r4 + r5
            int r5 = r10.getScrollX()
            int r4 = r4 - r5
            int r5 = r10.getTop()
            int r6 = r11.top
            int r5 = r5 + r6
            int r10 = r10.getScrollY()
            int r5 = r5 - r10
            int r10 = r11.width()
            int r10 = r10 + r4
            int r11 = r11.height()
            int r11 = r11 + r5
            int r4 = r4 - r0
            r0 = 0
            int r6 = java.lang.Math.min(r0, r4)
            int r5 = r5 - r1
            int r1 = java.lang.Math.min(r0, r5)
            int r10 = r10 - r2
            int r2 = java.lang.Math.max(r0, r10)
            int r11 = r11 - r3
            int r11 = java.lang.Math.max(r0, r11)
            androidx.recyclerview.widget.RecyclerView r3 = r8.f10818b
            int r3 = r3.getLayoutDirection()
            r7 = 1
            if (r3 != r7) goto L5e
            if (r2 == 0) goto L59
            goto L66
        L59:
            int r2 = java.lang.Math.max(r6, r10)
            goto L66
        L5e:
            if (r6 == 0) goto L61
            goto L65
        L61:
            int r6 = java.lang.Math.min(r4, r2)
        L65:
            r2 = r6
        L66:
            if (r1 == 0) goto L69
            goto L6d
        L69:
            int r1 = java.lang.Math.min(r5, r11)
        L6d:
            int[] r10 = new int[]{r2, r1}
            r11 = r10[r0]
            r10 = r10[r7]
            if (r13 == 0) goto Lb0
            android.view.View r13 = r9.getFocusedChild()
            if (r13 != 0) goto L7e
            goto Lb5
        L7e:
            int r1 = r8.D()
            int r2 = r8.F()
            int r3 = r8.f10828n
            int r4 = r8.E()
            int r3 = r3 - r4
            int r4 = r8.f10829o
            int r5 = r8.C()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f10818b
            android.graphics.Rect r5 = r5.D
            r8.y(r5, r13)
            int r13 = r5.left
            int r13 = r13 - r11
            if (r13 >= r3) goto Lb5
            int r13 = r5.right
            int r13 = r13 - r11
            if (r13 <= r1) goto Lb5
            int r13 = r5.top
            int r13 = r13 - r10
            if (r13 >= r4) goto Lb5
            int r13 = r5.bottom
            int r13 = r13 - r10
            if (r13 > r2) goto Lb0
            goto Lb5
        Lb0:
            if (r11 != 0) goto Lb6
            if (r10 == 0) goto Lb5
            goto Lb6
        Lb5:
            return r0
        Lb6:
            if (r12 == 0) goto Lbc
            r9.scrollBy(r11, r10)
            return r7
        Lbc:
            r9.i0(r11, r10, r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: q4.h0.o0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void p(n0 n0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            x0 x0VarM = RecyclerView.M(viewU);
            if (x0VarM.o()) {
                if (RecyclerView.W0) {
                    Log.d("RecyclerView", "ignoring view " + x0VarM);
                }
            } else if (!x0VarM.f() || x0VarM.h() || this.f10818b.G.f10983b) {
                u(iV);
                this.f10817a.f(iV);
                n0Var.j(viewU);
                this.f10818b.A.t(x0VarM);
            } else {
                n0(iV);
                n0Var.i(x0VarM);
            }
        }
    }

    public final void p0() {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i10 = 0; i10 < iV; i10++) {
            View viewU = u(i10);
            x0 x0VarM = RecyclerView.M(viewU);
            if (x0VarM != null && x0VarM.b() == i && !x0VarM.o() && (this.f10818b.A0.f10940g || !x0VarM.h())) {
                return viewU;
            }
        }
        return null;
    }

    public abstract int q0(int i, n0 n0Var, t0 t0Var);

    public abstract i0 r();

    public abstract void r0(int i);

    public i0 s(Context context, AttributeSet attributeSet) {
        return new i0(context, attributeSet);
    }

    public abstract int s0(int i, n0 n0Var, t0 t0Var);

    public i0 t(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof i0 ? new i0((i0) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new i0((ViewGroup.MarginLayoutParams) layoutParams) : new i0(layoutParams);
    }

    public final void t0(RecyclerView recyclerView) {
        u0(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), 1073741824));
    }

    public final View u(int i) {
        d4.e0 e0Var = this.f10817a;
        if (e0Var != null) {
            return e0Var.h(i);
        }
        return null;
    }

    public final void u0(int i, int i10) {
        this.f10828n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.f10826l = mode;
        if (mode == 0 && !RecyclerView.Z0) {
            this.f10828n = 0;
        }
        this.f10829o = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.f10827m = mode2;
        if (mode2 != 0 || RecyclerView.Z0) {
            return;
        }
        this.f10829o = 0;
    }

    public final int v() {
        d4.e0 e0Var = this.f10817a;
        if (e0Var != null) {
            return e0Var.i();
        }
        return 0;
    }

    public void v0(Rect rect, int i, int i10) {
        int iE = E() + D() + rect.width();
        int iC = C() + F() + rect.height();
        RecyclerView recyclerView = this.f10818b;
        WeakHashMap weakHashMap = q0.o0.f10475a;
        this.f10818b.setMeasuredDimension(g(i, iE, recyclerView.getMinimumWidth()), g(i10, iC, this.f10818b.getMinimumHeight()));
    }

    public final void w0(int i, int i10) {
        int iV = v();
        if (iV == 0) {
            this.f10818b.q(i, i10);
            return;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MAX_VALUE;
        for (int i15 = 0; i15 < iV; i15++) {
            View viewU = u(i15);
            Rect rect = this.f10818b.D;
            y(rect, viewU);
            int i16 = rect.left;
            if (i16 < i14) {
                i14 = i16;
            }
            int i17 = rect.right;
            if (i17 > i11) {
                i11 = i17;
            }
            int i18 = rect.top;
            if (i18 < i12) {
                i12 = i18;
            }
            int i19 = rect.bottom;
            if (i19 > i13) {
                i13 = i19;
            }
        }
        this.f10818b.D.set(i14, i12, i11, i13);
        v0(this.f10818b.D, i, i10);
    }

    public int x(n0 n0Var, t0 t0Var) {
        RecyclerView recyclerView = this.f10818b;
        if (recyclerView == null || recyclerView.G == null || !d()) {
            return 1;
        }
        return this.f10818b.G.a();
    }

    public final void x0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f10818b = null;
            this.f10817a = null;
            this.f10828n = 0;
            this.f10829o = 0;
        } else {
            this.f10818b = recyclerView;
            this.f10817a = recyclerView.f1672z;
            this.f10828n = recyclerView.getWidth();
            this.f10829o = recyclerView.getHeight();
        }
        this.f10826l = 1073741824;
        this.f10827m = 1073741824;
    }

    public void y(Rect rect, View view) {
        boolean z2 = RecyclerView.V0;
        i0 i0Var = (i0) view.getLayoutParams();
        Rect rect2 = i0Var.f10832b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) i0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) i0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) i0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin);
    }

    public final boolean y0(View view, int i, int i10, i0 i0Var) {
        return (!view.isLayoutRequested() && this.f10823h && M(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) i0Var).width) && M(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) i0Var).height)) ? false : true;
    }

    public boolean z0() {
        return false;
    }

    public void Q() {
    }

    public void a0() {
    }

    public void R(RecyclerView recyclerView) {
    }

    public void g0(Parcelable parcelable) {
    }

    public void i0(int i) {
    }

    public void Y(View view, int i) {
    }

    public void Z(int i, int i10) {
    }

    public void b0(int i, int i10) {
    }

    public void c0(int i, int i10) {
    }

    public void d0(int i, int i10) {
    }

    public void i(int i, k kVar) {
    }

    public void h(int i, int i10, t0 t0Var, k kVar) {
    }
}
