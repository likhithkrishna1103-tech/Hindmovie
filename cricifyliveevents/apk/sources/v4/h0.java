package v4;

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

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class h0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ff.m f13247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public RecyclerView f13248b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final nb.w f13249c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final nb.w f13250d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public s f13251e;
    public boolean f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f13252g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f13253h;
    public final boolean i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public int f13254j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f13255k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public int f13256l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public int f13257m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public int f13258n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public int f13259o;

    public h0() {
        kf.i iVar = new kf.i(22, this);
        l4.a aVar = new l4.a(this);
        this.f13249c = new nb.w((e1) iVar);
        this.f13250d = new nb.w((e1) aVar);
        this.f = false;
        this.f13252g = false;
        this.f13253h = true;
        this.i = true;
    }

    public static int A(View view) {
        Rect rect = ((i0) view.getLayoutParams()).f13262b;
        return view.getMeasuredWidth() + rect.left + rect.right;
    }

    public static int G(View view) {
        return ((i0) view.getLayoutParams()).f13261a.b();
    }

    public static g0 H(Context context, AttributeSet attributeSet, int i, int i10) {
        g0 g0Var = new g0();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, u4.c.RecyclerView, i, i10);
        g0Var.f13231a = typedArrayObtainStyledAttributes.getInt(u4.c.RecyclerView_android_orientation, 1);
        g0Var.f13232b = typedArrayObtainStyledAttributes.getInt(u4.c.RecyclerView_spanCount, 1);
        g0Var.f13233c = typedArrayObtainStyledAttributes.getBoolean(u4.c.RecyclerView_reverseLayout, false);
        g0Var.f13234d = typedArrayObtainStyledAttributes.getBoolean(u4.c.RecyclerView_stackFromEnd, false);
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
        Rect rect = i0Var.f13262b;
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
        throw new UnsupportedOperationException("Method not decompiled: v4.h0.w(boolean, int, int, int, int):int");
    }

    public static int z(View view) {
        Rect rect = ((i0) view.getLayoutParams()).f13262b;
        return view.getMeasuredHeight() + rect.top + rect.bottom;
    }

    public final boolean A0(View view, int i, int i10, i0 i0Var) {
        return (this.f13253h && M(view.getMeasuredWidth(), i, ((ViewGroup.MarginLayoutParams) i0Var).width) && M(view.getMeasuredHeight(), i10, ((ViewGroup.MarginLayoutParams) i0Var).height)) ? false : true;
    }

    public final int B() {
        RecyclerView recyclerView = this.f13248b;
        z adapter = recyclerView != null ? recyclerView.getAdapter() : null;
        if (adapter != null) {
            return adapter.a();
        }
        return 0;
    }

    public abstract void B0(RecyclerView recyclerView, int i);

    public final int C() {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            return recyclerView.getPaddingBottom();
        }
        return 0;
    }

    public final void C0(s sVar) {
        s sVar2 = this.f13251e;
        if (sVar2 != null && sVar != sVar2 && sVar2.f13350e) {
            sVar2.i();
        }
        this.f13251e = sVar;
        RecyclerView recyclerView = this.f13248b;
        w0 w0Var = recyclerView.f1454y0;
        w0Var.B.removeCallbacks(w0Var);
        w0Var.f13382x.abortAnimation();
        if (sVar.f13352h) {
            Log.w("RecyclerView", "An instance of " + sVar.getClass().getSimpleName() + " was started more than once. Each instance of" + sVar.getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
        }
        sVar.f13347b = recyclerView;
        sVar.f13348c = this;
        int i = sVar.f13346a;
        if (i == -1) {
            throw new IllegalArgumentException("Invalid target position");
        }
        recyclerView.B0.f13361a = i;
        sVar.f13350e = true;
        sVar.f13349d = true;
        sVar.f = recyclerView.I.q(i);
        sVar.f13347b.f1454y0.b();
        sVar.f13352h = true;
    }

    public final int D() {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            return recyclerView.getPaddingLeft();
        }
        return 0;
    }

    public boolean D0() {
        return false;
    }

    public final int E() {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            return recyclerView.getPaddingRight();
        }
        return 0;
    }

    public final int F() {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            return recyclerView.getPaddingTop();
        }
        return 0;
    }

    public int I(n0 n0Var, t0 t0Var) {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView == null || recyclerView.H == null || !e()) {
            return 1;
        }
        return this.f13248b.H.a();
    }

    public final void J(Rect rect, View view) {
        Matrix matrix;
        Rect rect2 = ((i0) view.getLayoutParams()).f13262b;
        rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
        if (this.f13248b != null && (matrix = view.getMatrix()) != null && !matrix.isIdentity()) {
            RectF rectF = this.f13248b.G;
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
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            int iV = recyclerView.A.v();
            for (int i10 = 0; i10 < iV; i10++) {
                recyclerView.A.u(i10).offsetLeftAndRight(i);
            }
        }
    }

    public void P(int i) {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            int iV = recyclerView.A.v();
            for (int i10 = 0; i10 < iV; i10++) {
                recyclerView.A.u(i10).offsetTopAndBottom(i);
            }
        }
    }

    public abstract void S(RecyclerView recyclerView);

    public abstract View T(View view, int i, n0 n0Var, t0 t0Var);

    public void U(AccessibilityEvent accessibilityEvent) {
        RecyclerView recyclerView = this.f13248b;
        n0 n0Var = recyclerView.f1451x;
        if (accessibilityEvent == null) {
            return;
        }
        boolean z10 = true;
        if (!recyclerView.canScrollVertically(1) && !this.f13248b.canScrollVertically(-1) && !this.f13248b.canScrollHorizontally(-1) && !this.f13248b.canScrollHorizontally(1)) {
            z10 = false;
        }
        accessibilityEvent.setScrollable(z10);
        z zVar = this.f13248b.H;
        if (zVar != null) {
            accessibilityEvent.setItemCount(zVar.a());
        }
    }

    public void V(n0 n0Var, t0 t0Var, u0.e eVar) {
        if (this.f13248b.canScrollVertically(-1) || this.f13248b.canScrollHorizontally(-1)) {
            eVar.a(8192);
            eVar.k(true);
            eVar.h(67108864, true);
        }
        if (this.f13248b.canScrollVertically(1) || this.f13248b.canScrollHorizontally(1)) {
            eVar.a(4096);
            eVar.k(true);
            eVar.h(67108864, true);
        }
        eVar.f12062a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(I(n0Var, t0Var), x(n0Var, t0Var), false, 0));
    }

    public final void W(View view, u0.e eVar) {
        x0 x0VarM = RecyclerView.M(view);
        if (x0VarM == null || x0VarM.h()) {
            return;
        }
        ff.m mVar = this.f13247a;
        if (((ArrayList) mVar.f4602z).contains(x0VarM.f13387a)) {
            return;
        }
        RecyclerView recyclerView = this.f13248b;
        X(recyclerView.f1451x, recyclerView.B0, view, eVar);
    }

    public void X(n0 n0Var, t0 t0Var, View view, u0.e eVar) {
        eVar.j(u0.d.a(e() ? G(view) : 0, 1, d() ? G(view) : 0, 1, false, false));
    }

    public final void b(View view, int i, boolean z10) {
        x0 x0VarM = RecyclerView.M(view);
        if (z10 || x0VarM.h()) {
            v.k kVar = (v.k) this.f13248b.B.f9016w;
            f1 f1VarA = (f1) kVar.get(x0VarM);
            if (f1VarA == null) {
                f1VarA = f1.a();
                kVar.put(x0VarM, f1VarA);
            }
            f1VarA.f13223a |= 1;
        } else {
            this.f13248b.B.N(x0VarM);
        }
        i0 i0Var = (i0) view.getLayoutParams();
        if (x0VarM.p() || x0VarM.i()) {
            if (x0VarM.i()) {
                x0VarM.f13398n.m(x0VarM);
            } else {
                x0VarM.f13394j &= -33;
            }
            this.f13247a.f(view, i, view.getLayoutParams(), false);
        } else {
            if (view.getParent() == this.f13248b) {
                ff.m mVar = this.f13247a;
                f9.s0 s0Var = (f9.s0) mVar.f4601y;
                int iIndexOfChild = ((RecyclerView) ((kf.i) mVar.f4600x).f7483w).indexOfChild(view);
                int iD = (iIndexOfChild == -1 || s0Var.G(iIndexOfChild)) ? -1 : iIndexOfChild - s0Var.D(iIndexOfChild);
                if (i == -1) {
                    i = this.f13247a.v();
                }
                if (iD == -1) {
                    StringBuilder sb = new StringBuilder("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:");
                    sb.append(this.f13248b.indexOfChild(view));
                    throw new IllegalStateException(l0.e.i(this.f13248b, sb));
                }
                if (iD != i) {
                    h0 h0Var = this.f13248b.I;
                    View viewU = h0Var.u(iD);
                    if (viewU == null) {
                        throw new IllegalArgumentException("Cannot move a child from non-existing index:" + iD + h0Var.f13248b.toString());
                    }
                    h0Var.u(iD);
                    h0Var.f13247a.o(iD);
                    i0 i0Var2 = (i0) viewU.getLayoutParams();
                    x0 x0VarM2 = RecyclerView.M(viewU);
                    if (x0VarM2.h()) {
                        v.k kVar2 = (v.k) h0Var.f13248b.B.f9016w;
                        f1 f1VarA2 = (f1) kVar2.get(x0VarM2);
                        if (f1VarA2 == null) {
                            f1VarA2 = f1.a();
                            kVar2.put(x0VarM2, f1VarA2);
                        }
                        f1VarA2.f13223a = 1 | f1VarA2.f13223a;
                    } else {
                        h0Var.f13248b.B.N(x0VarM2);
                    }
                    h0Var.f13247a.f(viewU, i, i0Var2, x0VarM2.h());
                }
            } else {
                this.f13247a.d(view, i, false);
                i0Var.f13263c = true;
                s sVar = this.f13251e;
                if (sVar != null && sVar.f13350e) {
                    sVar.f13347b.getClass();
                    x0 x0VarM3 = RecyclerView.M(view);
                    if ((x0VarM3 != null ? x0VarM3.b() : -1) == sVar.f13346a) {
                        sVar.f = view;
                        if (RecyclerView.X0) {
                            Log.d("RecyclerView", "smooth scroll target view has been attached");
                        }
                    }
                }
            }
        }
        if (i0Var.f13264d) {
            if (RecyclerView.X0) {
                Log.d("RecyclerView", "consuming pending invalidate on child " + i0Var.f13261a);
            }
            x0VarM.f13387a.invalidate();
            i0Var.f13264d = false;
        }
    }

    public void c(String str) {
        RecyclerView recyclerView = this.f13248b;
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
        throw new UnsupportedOperationException("Method not decompiled: v4.h0.j0(int, android.os.Bundle):boolean");
    }

    public abstract int k(t0 t0Var);

    public final void k0(n0 n0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            if (!RecyclerView.M(u(iV)).o()) {
                View viewU = u(iV);
                n0(iV);
                n0Var.i(viewU);
            }
        }
    }

    public abstract int l(t0 t0Var);

    public final void l0(n0 n0Var) {
        ArrayList arrayList = n0Var.f13307a;
        int size = arrayList.size();
        for (int i = size - 1; i >= 0; i--) {
            View view = ((x0) arrayList.get(i)).f13387a;
            x0 x0VarM = RecyclerView.M(view);
            if (!x0VarM.o()) {
                x0VarM.n(false);
                if (x0VarM.j()) {
                    this.f13248b.removeDetachedView(view, false);
                }
                e0 e0Var = this.f13248b.f1436j0;
                if (e0Var != null) {
                    e0Var.d(x0VarM);
                }
                x0VarM.n(true);
                x0 x0VarM2 = RecyclerView.M(view);
                x0VarM2.f13398n = null;
                x0VarM2.f13399o = false;
                x0VarM2.f13394j &= -33;
                n0Var.j(x0VarM2);
            }
        }
        arrayList.clear();
        ArrayList arrayList2 = n0Var.f13308b;
        if (arrayList2 != null) {
            arrayList2.clear();
        }
        if (size > 0) {
            this.f13248b.invalidate();
        }
    }

    public abstract int m(t0 t0Var);

    public final void m0(View view, n0 n0Var) {
        ff.m mVar = this.f13247a;
        kf.i iVar = (kf.i) mVar.f4600x;
        int i = mVar.f4599w;
        if (i == 1) {
            throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
        }
        if (i == 2) {
            throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
        }
        try {
            mVar.f4599w = 1;
            mVar.A = view;
            int iIndexOfChild = ((RecyclerView) iVar.f7483w).indexOfChild(view);
            if (iIndexOfChild >= 0) {
                if (((f9.s0) mVar.f4601y).J(iIndexOfChild)) {
                    mVar.E(view);
                }
                iVar.L(iIndexOfChild);
            }
            mVar.f4599w = 0;
            mVar.A = null;
            n0Var.i(view);
        } catch (Throwable th) {
            mVar.f4599w = 0;
            mVar.A = null;
            throw th;
        }
    }

    public abstract int n(t0 t0Var);

    public final void n0(int i) {
        if (u(i) != null) {
            ff.m mVar = this.f13247a;
            kf.i iVar = (kf.i) mVar.f4600x;
            int i10 = mVar.f4599w;
            if (i10 == 1) {
                throw new IllegalStateException("Cannot call removeView(At) within removeView(At)");
            }
            if (i10 == 2) {
                throw new IllegalStateException("Cannot call removeView(At) within removeViewIfHidden");
            }
            try {
                int iW = mVar.w(i);
                View childAt = ((RecyclerView) iVar.f7483w).getChildAt(iW);
                if (childAt != null) {
                    mVar.f4599w = 1;
                    mVar.A = childAt;
                    if (((f9.s0) mVar.f4601y).J(iW)) {
                        mVar.E(childAt);
                    }
                    iVar.L(iW);
                }
                mVar.f4599w = 0;
                mVar.A = null;
            } catch (Throwable th) {
                mVar.f4599w = 0;
                mVar.A = null;
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
            int r2 = r8.f13258n
            int r3 = r8.E()
            int r2 = r2 - r3
            int r3 = r8.f13259o
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
            androidx.recyclerview.widget.RecyclerView r3 = r8.f13248b
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
            int r3 = r8.f13258n
            int r4 = r8.E()
            int r3 = r3 - r4
            int r4 = r8.f13259o
            int r5 = r8.C()
            int r4 = r4 - r5
            androidx.recyclerview.widget.RecyclerView r5 = r8.f13248b
            android.graphics.Rect r5 = r5.E
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
        throw new UnsupportedOperationException("Method not decompiled: v4.h0.o0(androidx.recyclerview.widget.RecyclerView, android.view.View, android.graphics.Rect, boolean, boolean):boolean");
    }

    public final void p(n0 n0Var) {
        for (int iV = v() - 1; iV >= 0; iV--) {
            View viewU = u(iV);
            x0 x0VarM = RecyclerView.M(viewU);
            if (x0VarM.o()) {
                if (RecyclerView.X0) {
                    Log.d("RecyclerView", "ignoring view " + x0VarM);
                }
            } else if (!x0VarM.f() || x0VarM.h() || this.f13248b.H.f13408b) {
                u(iV);
                this.f13247a.o(iV);
                n0Var.k(viewU);
                this.f13248b.B.N(x0VarM);
            } else {
                n0(iV);
                n0Var.j(x0VarM);
            }
        }
    }

    public final void p0() {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView != null) {
            recyclerView.requestLayout();
        }
    }

    public View q(int i) {
        int iV = v();
        for (int i10 = 0; i10 < iV; i10++) {
            View viewU = u(i10);
            x0 x0VarM = RecyclerView.M(viewU);
            if (x0VarM != null && x0VarM.b() == i && !x0VarM.o() && (this.f13248b.B0.f13366g || !x0VarM.h())) {
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
        ff.m mVar = this.f13247a;
        if (mVar != null) {
            return mVar.u(i);
        }
        return null;
    }

    public final void u0(int i, int i10) {
        this.f13258n = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        this.f13256l = mode;
        if (mode == 0 && !RecyclerView.f1423a1) {
            this.f13258n = 0;
        }
        this.f13259o = View.MeasureSpec.getSize(i10);
        int mode2 = View.MeasureSpec.getMode(i10);
        this.f13257m = mode2;
        if (mode2 != 0 || RecyclerView.f1423a1) {
            return;
        }
        this.f13259o = 0;
    }

    public final int v() {
        ff.m mVar = this.f13247a;
        if (mVar != null) {
            return mVar.v();
        }
        return 0;
    }

    public void v0(Rect rect, int i, int i10) {
        int iE = E() + D() + rect.width();
        int iC = C() + F() + rect.height();
        RecyclerView recyclerView = this.f13248b;
        WeakHashMap weakHashMap = t0.m0.f11777a;
        this.f13248b.setMeasuredDimension(g(i, iE, recyclerView.getMinimumWidth()), g(i10, iC, this.f13248b.getMinimumHeight()));
    }

    public final void w0(int i, int i10) {
        int iV = v();
        if (iV == 0) {
            this.f13248b.q(i, i10);
            return;
        }
        int i11 = Integer.MIN_VALUE;
        int i12 = Integer.MAX_VALUE;
        int i13 = Integer.MIN_VALUE;
        int i14 = Integer.MAX_VALUE;
        for (int i15 = 0; i15 < iV; i15++) {
            View viewU = u(i15);
            Rect rect = this.f13248b.E;
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
        this.f13248b.E.set(i14, i12, i11, i13);
        v0(this.f13248b.E, i, i10);
    }

    public int x(n0 n0Var, t0 t0Var) {
        RecyclerView recyclerView = this.f13248b;
        if (recyclerView == null || recyclerView.H == null || !d()) {
            return 1;
        }
        return this.f13248b.H.a();
    }

    public final void x0(RecyclerView recyclerView) {
        if (recyclerView == null) {
            this.f13248b = null;
            this.f13247a = null;
            this.f13258n = 0;
            this.f13259o = 0;
        } else {
            this.f13248b = recyclerView;
            this.f13247a = recyclerView.A;
            this.f13258n = recyclerView.getWidth();
            this.f13259o = recyclerView.getHeight();
        }
        this.f13256l = 1073741824;
        this.f13257m = 1073741824;
    }

    public void y(Rect rect, View view) {
        boolean z10 = RecyclerView.W0;
        i0 i0Var = (i0) view.getLayoutParams();
        Rect rect2 = i0Var.f13262b;
        rect.set((view.getLeft() - rect2.left) - ((ViewGroup.MarginLayoutParams) i0Var).leftMargin, (view.getTop() - rect2.top) - ((ViewGroup.MarginLayoutParams) i0Var).topMargin, view.getRight() + rect2.right + ((ViewGroup.MarginLayoutParams) i0Var).rightMargin, view.getBottom() + rect2.bottom + ((ViewGroup.MarginLayoutParams) i0Var).bottomMargin);
    }

    public final boolean y0(View view, int i, int i10, i0 i0Var) {
        return (!view.isLayoutRequested() && this.f13253h && M(view.getWidth(), i, ((ViewGroup.MarginLayoutParams) i0Var).width) && M(view.getHeight(), i10, ((ViewGroup.MarginLayoutParams) i0Var).height)) ? false : true;
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

    public void i(int i, v.g gVar) {
    }

    public void h(int i, int i10, t0 t0Var, v.g gVar) {
    }
}
