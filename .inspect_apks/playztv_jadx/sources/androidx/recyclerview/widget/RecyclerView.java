package androidx.recyclerview.widget;

import android.R;
import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Parcelable;
import android.os.SystemClock;
import android.os.Trace;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.WeakHashMap;
import k5.b;
import n.a1;
import n.p;
import p2.c;
import p4.a;
import q0.e;
import q0.h;
import q0.l;
import q0.m;
import q0.o0;
import q4.c0;
import q4.d0;
import q4.e0;
import q4.f0;
import q4.g1;
import q4.h0;
import q4.i0;
import q4.j;
import q4.j0;
import q4.k;
import q4.k0;
import q4.l0;
import q4.m0;
import q4.n0;
import q4.p0;
import q4.q0;
import q4.t;
import q4.t0;
import q4.u0;
import q4.v0;
import q4.w0;
import q4.x;
import q4.x0;
import q4.y;
import q4.y0;
import q4.z;
import s.g;
import s.i;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class RecyclerView extends ViewGroup implements l {
    public static boolean V0 = false;
    public static boolean W0 = false;
    public static final int[] X0 = {R.attr.nestedScrollingEnabled};
    public static final float Y0 = (float) (Math.log(0.78d) / Math.log(0.9d));
    public static final boolean Z0 = true;
    public static final boolean a1 = true;

    /* JADX INFO: renamed from: b1, reason: collision with root package name */
    public static final Class[] f1640b1;

    /* JADX INFO: renamed from: c1, reason: collision with root package name */
    public static final b f1641c1;

    /* JADX INFO: renamed from: d1, reason: collision with root package name */
    public static final u0 f1642d1;
    public final c A;
    public final t0 A0;
    public boolean B;
    public k0 B0;
    public final x C;
    public ArrayList C0;
    public final Rect D;
    public boolean D0;
    public final Rect E;
    public boolean E0;
    public final RectF F;
    public final y F0;
    public z G;
    public boolean G0;
    public h0 H;
    public y0 H0;
    public final ArrayList I;
    public final int[] I0;
    public final ArrayList J;
    public m J0;
    public final ArrayList K;
    public final int[] K0;
    public j L;
    public final int[] L0;
    public boolean M;
    public final int[] M0;
    public boolean N;
    public final ArrayList N0;
    public boolean O;
    public final x O0;
    public int P;
    public boolean P0;
    public boolean Q;
    public int Q0;
    public boolean R;
    public int R0;
    public boolean S;
    public final boolean S0;
    public int T;
    public final y T0;
    public boolean U;
    public final h U0;
    public final AccessibilityManager V;
    public boolean W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f1643a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public int f1644b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1645c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public d0 f1646d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public EdgeEffect f1647e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public EdgeEffect f1648f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public EdgeEffect f1649g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public EdgeEffect f1650h0;

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public e0 f1651i0;

    /* JADX INFO: renamed from: j0, reason: collision with root package name */
    public int f1652j0;

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public int f1653k0;
    public VelocityTracker l0;

    /* JADX INFO: renamed from: m0, reason: collision with root package name */
    public int f1654m0;

    /* JADX INFO: renamed from: n0, reason: collision with root package name */
    public int f1655n0;

    /* JADX INFO: renamed from: o0, reason: collision with root package name */
    public int f1656o0;

    /* JADX INFO: renamed from: p0, reason: collision with root package name */
    public int f1657p0;

    /* JADX INFO: renamed from: q0, reason: collision with root package name */
    public int f1658q0;

    /* JADX INFO: renamed from: r0, reason: collision with root package name */
    public j0 f1659r0;

    /* JADX INFO: renamed from: s0, reason: collision with root package name */
    public final int f1660s0;

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public final int f1661t0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final float f1662u;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public final float f1663u0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final p0 f1664v;

    /* JADX INFO: renamed from: v0, reason: collision with root package name */
    public final float f1665v0;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final n0 f1666w;

    /* JADX INFO: renamed from: w0, reason: collision with root package name */
    public boolean f1667w0;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public q0 f1668x;

    /* JADX INFO: renamed from: x0, reason: collision with root package name */
    public final w0 f1669x0;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final p f1670y;

    /* JADX INFO: renamed from: y0, reason: collision with root package name */
    public q4.m f1671y0;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final d4.e0 f1672z;

    /* JADX INFO: renamed from: z0, reason: collision with root package name */
    public final k f1673z0;

    static {
        Class cls = Integer.TYPE;
        f1640b1 = new Class[]{Context.class, AttributeSet.class, cls, cls};
        f1641c1 = new b(1);
        f1642d1 = new u0();
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, a.recyclerViewStyle);
    }

    public static RecyclerView G(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            RecyclerView recyclerViewG = G(viewGroup.getChildAt(i));
            if (recyclerViewG != null) {
                return recyclerViewG;
            }
        }
        return null;
    }

    public static x0 M(View view) {
        if (view == null) {
            return null;
        }
        return ((i0) view.getLayoutParams()).f10831a;
    }

    private m getScrollingChildHelper() {
        if (this.J0 == null) {
            this.J0 = new m(this);
        }
        return this.J0;
    }

    public static void l(x0 x0Var) {
        WeakReference weakReference = x0Var.f10963b;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            while (view != null) {
                if (view == x0Var.f10962a) {
                    return;
                }
                Object parent = view.getParent();
                view = parent instanceof View ? (View) parent : null;
            }
            x0Var.f10963b = null;
        }
    }

    public static int o(int i, EdgeEffect edgeEffect, EdgeEffect edgeEffect2, int i10) {
        if (i > 0 && edgeEffect != null && com.bumptech.glide.c.k(edgeEffect) != 0.0f) {
            int iRound = Math.round(com.bumptech.glide.c.q(edgeEffect, ((-i) * 4.0f) / i10, 0.5f) * ((-i10) / 4.0f));
            if (iRound != i) {
                edgeEffect.finish();
            }
            return i - iRound;
        }
        if (i >= 0 || edgeEffect2 == null || com.bumptech.glide.c.k(edgeEffect2) == 0.0f) {
            return i;
        }
        float f = i10;
        int iRound2 = Math.round(com.bumptech.glide.c.q(edgeEffect2, (i * 4.0f) / f, 0.5f) * (f / 4.0f));
        if (iRound2 != i) {
            edgeEffect2.finish();
        }
        return i - iRound2;
    }

    public static void setDebugAssertionsEnabled(boolean z2) {
        V0 = z2;
    }

    public static void setVerboseLoggingEnabled(boolean z2) {
        W0 = z2;
    }

    public final void A() {
        if (this.f1648f0 != null) {
            return;
        }
        ((u0) this.f1646d0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1648f0 = edgeEffect;
        if (this.B) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final String B() {
        return " " + super.toString() + ", adapter:" + this.G + ", layout:" + this.H + ", context:" + getContext();
    }

    public final void C(t0 t0Var) {
        if (getScrollState() != 2) {
            t0Var.getClass();
            return;
        }
        OverScroller overScroller = this.f1669x0.f10955w;
        overScroller.getFinalX();
        overScroller.getCurrX();
        t0Var.getClass();
        overScroller.getFinalY();
        overScroller.getCurrY();
    }

    public final View D(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && parent != this && (parent instanceof View)) {
            view = parent;
            parent = view.getParent();
        }
        if (parent == this) {
            return view;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x005e A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0061 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean E(android.view.MotionEvent r12) {
        /*
            r11 = this;
            int r0 = r12.getAction()
            java.util.ArrayList r1 = r11.K
            int r2 = r1.size()
            r3 = 0
            r4 = r3
        Lc:
            if (r4 >= r2) goto L64
            java.lang.Object r5 = r1.get(r4)
            q4.j r5 = (q4.j) r5
            int r6 = r5.f10854v
            r7 = 1
            r8 = 2
            if (r6 != r7) goto L59
            float r6 = r12.getX()
            float r9 = r12.getY()
            boolean r6 = r5.d(r6, r9)
            float r9 = r12.getX()
            float r10 = r12.getY()
            boolean r9 = r5.c(r9, r10)
            int r10 = r12.getAction()
            if (r10 != 0) goto L61
            if (r6 != 0) goto L3c
            if (r9 == 0) goto L61
        L3c:
            if (r9 == 0) goto L49
            r5.f10855w = r7
            float r6 = r12.getX()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f10848p = r6
            goto L55
        L49:
            if (r6 == 0) goto L55
            r5.f10855w = r8
            float r6 = r12.getY()
            int r6 = (int) r6
            float r6 = (float) r6
            r5.f10845m = r6
        L55:
            r5.f(r8)
            goto L5b
        L59:
            if (r6 != r8) goto L61
        L5b:
            r6 = 3
            if (r0 == r6) goto L61
            r11.L = r5
            return r7
        L61:
            int r4 = r4 + 1
            goto Lc
        L64:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.E(android.view.MotionEvent):boolean");
    }

    public final void F(int[] iArr) {
        int i = this.f1672z.i();
        if (i == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i10 = Integer.MAX_VALUE;
        int i11 = Integer.MIN_VALUE;
        for (int i12 = 0; i12 < i; i12++) {
            x0 x0VarM = M(this.f1672z.h(i12));
            if (!x0VarM.o()) {
                int iB = x0VarM.b();
                if (iB < i10) {
                    i10 = iB;
                }
                if (iB > i11) {
                    i11 = iB;
                }
            }
        }
        iArr[0] = i10;
        iArr[1] = i11;
    }

    public final x0 H(int i) {
        x0 x0Var = null;
        if (this.W) {
            return null;
        }
        int iL = this.f1672z.l();
        for (int i10 = 0; i10 < iL; i10++) {
            x0 x0VarM = M(this.f1672z.k(i10));
            if (x0VarM != null && !x0VarM.h() && J(x0VarM) == i) {
                if (!((ArrayList) this.f1672z.f3840y).contains(x0VarM.f10962a)) {
                    return x0VarM;
                }
                x0Var = x0VarM;
            }
        }
        return x0Var;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00d0 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00fa  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean I(int r21, int r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 576
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.I(int, int, int, int):boolean");
    }

    public final int J(x0 x0Var) {
        if ((x0Var.f10969j & 524) == 0 && x0Var.e()) {
            int i = x0Var.f10964c;
            ArrayList arrayList = (ArrayList) this.f1670y.f8477c;
            int size = arrayList.size();
            for (int i10 = 0; i10 < size; i10++) {
                q4.a aVar = (q4.a) arrayList.get(i10);
                int i11 = aVar.f10737a;
                if (i11 != 1) {
                    if (i11 == 2) {
                        int i12 = aVar.f10738b;
                        if (i12 <= i) {
                            int i13 = aVar.f10740d;
                            if (i12 + i13 <= i) {
                                i -= i13;
                            }
                        } else {
                            continue;
                        }
                    } else if (i11 == 8) {
                        int i14 = aVar.f10738b;
                        if (i14 == i) {
                            i = aVar.f10740d;
                        } else {
                            if (i14 < i) {
                                i--;
                            }
                            if (aVar.f10740d <= i) {
                                i++;
                            }
                        }
                    }
                } else if (aVar.f10738b <= i) {
                    i += aVar.f10740d;
                }
            }
            return i;
        }
        return -1;
    }

    public final long K(x0 x0Var) {
        return this.G.f10983b ? x0Var.f10966e : x0Var.f10964c;
    }

    public final x0 L(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return M(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    public final Rect N(View view) {
        i0 i0Var = (i0) view.getLayoutParams();
        boolean z2 = i0Var.f10833c;
        Rect rect = i0Var.f10832b;
        if (!z2 || (this.A0.f10940g && (i0Var.f10831a.k() || i0Var.f10831a.f()))) {
            return rect;
        }
        rect.set(0, 0, 0, 0);
        ArrayList arrayList = this.J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Rect rect2 = this.D;
            rect2.set(0, 0, 0, 0);
            ((f0) arrayList.get(i)).getClass();
            ((i0) view.getLayoutParams()).f10831a.getClass();
            rect2.set(0, 0, 0, 0);
            rect.left += rect2.left;
            rect.top += rect2.top;
            rect.right += rect2.right;
            rect.bottom += rect2.bottom;
        }
        i0Var.f10833c = false;
        return rect;
    }

    public final boolean O() {
        return !this.O || this.W || this.f1670y.m();
    }

    public final boolean P() {
        return this.f1644b0 > 0;
    }

    public final void Q(int i) {
        if (this.H == null) {
            return;
        }
        setScrollState(2);
        this.H.r0(i);
        awakenScrollBars();
    }

    public final void R() {
        int iL = this.f1672z.l();
        for (int i = 0; i < iL; i++) {
            ((i0) this.f1672z.k(i).getLayoutParams()).f10833c = true;
        }
        ArrayList arrayList = this.f1666w.f10883c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            i0 i0Var = (i0) ((x0) arrayList.get(i10)).f10962a.getLayoutParams();
            if (i0Var != null) {
                i0Var.f10833c = true;
            }
        }
    }

    public final void S(int i, int i10, boolean z2) {
        int i11 = i + i10;
        int iL = this.f1672z.l();
        for (int i12 = 0; i12 < iL; i12++) {
            x0 x0VarM = M(this.f1672z.k(i12));
            if (x0VarM != null && !x0VarM.o()) {
                int i13 = x0VarM.f10964c;
                t0 t0Var = this.A0;
                if (i13 >= i11) {
                    if (W0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i12 + " holder " + x0VarM + " now at position " + (x0VarM.f10964c - i10));
                    }
                    x0VarM.l(-i10, z2);
                    t0Var.f = true;
                } else if (i13 >= i) {
                    if (W0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove attached child " + i12 + " holder " + x0VarM + " now REMOVED");
                    }
                    x0VarM.a(8);
                    x0VarM.l(-i10, z2);
                    x0VarM.f10964c = i - 1;
                    t0Var.f = true;
                }
            }
        }
        n0 n0Var = this.f1666w;
        ArrayList arrayList = n0Var.f10883c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x0 x0Var = (x0) arrayList.get(size);
            if (x0Var != null) {
                int i14 = x0Var.f10964c;
                if (i14 >= i11) {
                    if (W0) {
                        Log.d("RecyclerView", "offsetPositionRecordsForRemove cached " + size + " holder " + x0Var + " now at position " + (x0Var.f10964c - i10));
                    }
                    x0Var.l(-i10, z2);
                } else if (i14 >= i) {
                    x0Var.a(8);
                    n0Var.g(size);
                }
            }
        }
        requestLayout();
    }

    public final void T() {
        this.f1644b0++;
    }

    public final void U(boolean z2) {
        int i;
        AccessibilityManager accessibilityManager;
        int i10 = this.f1644b0 - 1;
        this.f1644b0 = i10;
        if (i10 < 1) {
            if (V0 && i10 < 0) {
                throw new IllegalStateException(e6.j.k(this, new StringBuilder("layout or scroll counter cannot go below zero.Some calls are not matching")));
            }
            this.f1644b0 = 0;
            if (z2) {
                int i11 = this.T;
                this.T = 0;
                if (i11 != 0 && (accessibilityManager = this.V) != null && accessibilityManager.isEnabled()) {
                    AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain();
                    accessibilityEventObtain.setEventType(2048);
                    accessibilityEventObtain.setContentChangeTypes(i11);
                    sendAccessibilityEventUnchecked(accessibilityEventObtain);
                }
                ArrayList arrayList = this.N0;
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    x0 x0Var = (x0) arrayList.get(size);
                    if (x0Var.f10962a.getParent() == this && !x0Var.o() && (i = x0Var.f10976q) != -1) {
                        x0Var.f10962a.setImportantForAccessibility(i);
                        x0Var.f10976q = -1;
                    }
                }
                arrayList.clear();
            }
        }
    }

    public final void V(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f1653k0) {
            int i = actionIndex == 0 ? 1 : 0;
            this.f1653k0 = motionEvent.getPointerId(i);
            int x10 = (int) (motionEvent.getX(i) + 0.5f);
            this.f1656o0 = x10;
            this.f1654m0 = x10;
            int y10 = (int) (motionEvent.getY(i) + 0.5f);
            this.f1657p0 = y10;
            this.f1655n0 = y10;
        }
    }

    public final void W() {
        if (this.G0 || !this.M) {
            return;
        }
        WeakHashMap weakHashMap = o0.f10475a;
        postOnAnimation(this.O0);
        this.G0 = true;
    }

    public final void X() {
        boolean z2;
        boolean z10 = false;
        if (this.W) {
            p pVar = this.f1670y;
            pVar.u((ArrayList) pVar.f8477c);
            pVar.u((ArrayList) pVar.f8478d);
            pVar.f8475a = 0;
            if (this.f1643a0) {
                this.H.a0();
            }
        }
        if (this.f1651i0 == null || !this.H.D0()) {
            this.f1670y.e();
        } else {
            this.f1670y.t();
        }
        boolean z11 = this.D0 || this.E0;
        boolean z12 = this.O && this.f1651i0 != null && ((z2 = this.W) || z11 || this.H.f) && (!z2 || this.G.f10983b);
        t0 t0Var = this.A0;
        t0Var.f10942j = z12;
        if (z12 && z11 && !this.W && this.f1651i0 != null && this.H.D0()) {
            z10 = true;
        }
        t0Var.f10943k = z10;
    }

    public final void Y(boolean z2) {
        this.f1643a0 = z2 | this.f1643a0;
        this.W = true;
        int iL = this.f1672z.l();
        for (int i = 0; i < iL; i++) {
            x0 x0VarM = M(this.f1672z.k(i));
            if (x0VarM != null && !x0VarM.o()) {
                x0VarM.a(6);
            }
        }
        R();
        n0 n0Var = this.f1666w;
        ArrayList arrayList = n0Var.f10883c;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            x0 x0Var = (x0) arrayList.get(i10);
            if (x0Var != null) {
                x0Var.a(6);
                x0Var.a(1024);
            }
        }
        z zVar = n0Var.f10887h.G;
        if (zVar == null || !zVar.f10983b) {
            n0Var.f();
        }
    }

    public final void Z(x0 x0Var, b2.m mVar) {
        x0Var.f10969j &= -8193;
        boolean z2 = this.A0.f10941h;
        c cVar = this.A;
        if (z2 && x0Var.k() && !x0Var.h() && !x0Var.o()) {
            ((g) cVar.f10131w).h(K(x0Var), x0Var);
        }
        i iVar = (i) cVar.f10130v;
        g1 g1VarA = (g1) iVar.get(x0Var);
        if (g1VarA == null) {
            g1VarA = g1.a();
            iVar.put(x0Var, g1VarA);
        }
        g1VarA.f10803b = mVar;
        g1VarA.f10802a |= 4;
    }

    public final void a0() {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1647e0;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            zIsFinished = this.f1647e0.isFinished();
        } else {
            zIsFinished = false;
        }
        EdgeEffect edgeEffect2 = this.f1648f0;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            zIsFinished |= this.f1648f0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1649g0;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            zIsFinished |= this.f1649g0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1650h0;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            zIsFinished |= this.f1650h0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void addFocusables(ArrayList arrayList, int i, int i10) {
        h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.getClass();
        }
        super.addFocusables(arrayList, i, i10);
    }

    public final int b0(int i, float f) {
        float height = f / getHeight();
        float width = i / getWidth();
        EdgeEffect edgeEffect = this.f1647e0;
        float f4 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.c.k(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1649g0;
            if (edgeEffect2 != null && com.bumptech.glide.c.k(edgeEffect2) != 0.0f) {
                if (canScrollHorizontally(1)) {
                    this.f1649g0.onRelease();
                } else {
                    float fQ = com.bumptech.glide.c.q(this.f1649g0, width, height);
                    if (com.bumptech.glide.c.k(this.f1649g0) == 0.0f) {
                        this.f1649g0.onRelease();
                    }
                    f4 = fQ;
                }
                invalidate();
            }
        } else {
            if (canScrollHorizontally(-1)) {
                this.f1647e0.onRelease();
            } else {
                float f10 = -com.bumptech.glide.c.q(this.f1647e0, -width, 1.0f - height);
                if (com.bumptech.glide.c.k(this.f1647e0) == 0.0f) {
                    this.f1647e0.onRelease();
                }
                f4 = f10;
            }
            invalidate();
        }
        return Math.round(f4 * getWidth());
    }

    public final int c0(int i, float f) {
        float width = f / getWidth();
        float height = i / getHeight();
        EdgeEffect edgeEffect = this.f1648f0;
        float f4 = 0.0f;
        if (edgeEffect == null || com.bumptech.glide.c.k(edgeEffect) == 0.0f) {
            EdgeEffect edgeEffect2 = this.f1650h0;
            if (edgeEffect2 != null && com.bumptech.glide.c.k(edgeEffect2) != 0.0f) {
                if (canScrollVertically(1)) {
                    this.f1650h0.onRelease();
                } else {
                    float fQ = com.bumptech.glide.c.q(this.f1650h0, height, 1.0f - width);
                    if (com.bumptech.glide.c.k(this.f1650h0) == 0.0f) {
                        this.f1650h0.onRelease();
                    }
                    f4 = fQ;
                }
                invalidate();
            }
        } else {
            if (canScrollVertically(-1)) {
                this.f1648f0.onRelease();
            } else {
                float f10 = -com.bumptech.glide.c.q(this.f1648f0, -height, width);
                if (com.bumptech.glide.c.k(this.f1648f0) == 0.0f) {
                    this.f1648f0.onRelease();
                }
                f4 = f10;
            }
            invalidate();
        }
        return Math.round(f4 * getHeight());
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof i0) && this.H.f((i0) layoutParams);
    }

    @Override // android.view.View
    public final int computeHorizontalScrollExtent() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.d()) {
            return this.H.j(this.A0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollOffset() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.d()) {
            return this.H.k(this.A0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeHorizontalScrollRange() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.d()) {
            return this.H.l(this.A0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollExtent() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.e()) {
            return this.H.m(this.A0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollOffset() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.e()) {
            return this.H.n(this.A0);
        }
        return 0;
    }

    @Override // android.view.View
    public final int computeVerticalScrollRange() {
        h0 h0Var = this.H;
        if (h0Var != null && h0Var.e()) {
            return this.H.o(this.A0);
        }
        return 0;
    }

    public final void d0(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        int width = view3.getWidth();
        int height = view3.getHeight();
        Rect rect = this.D;
        rect.set(0, 0, width, height);
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof i0) {
            i0 i0Var = (i0) layoutParams;
            if (!i0Var.f10833c) {
                Rect rect2 = i0Var.f10832b;
                rect.left -= rect2.left;
                rect.right += rect2.right;
                rect.top -= rect2.top;
                rect.bottom += rect2.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, rect);
            offsetRectIntoDescendantCoords(view, rect);
        }
        this.H.o0(this, view, this.D, !this.O, view2 == null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (super.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        h0 layoutManager = getLayoutManager();
        int iA = 0;
        if (layoutManager != null) {
            if (layoutManager.e()) {
                int keyCode = keyEvent.getKeyCode();
                if (keyCode == 92 || keyCode == 93) {
                    int measuredHeight = getMeasuredHeight();
                    if (keyCode == 93) {
                        i0(0, measuredHeight, false);
                        return true;
                    }
                    i0(0, -measuredHeight, false);
                    return true;
                }
                if (keyCode == 122 || keyCode == 123) {
                    boolean zL = layoutManager.L();
                    if (keyCode == 122) {
                        if (zL) {
                            iA = getAdapter().a();
                        }
                    } else if (!zL) {
                        iA = getAdapter().a();
                    }
                    j0(iA);
                    return true;
                }
            } else if (layoutManager.d()) {
                int keyCode2 = keyEvent.getKeyCode();
                if (keyCode2 == 92 || keyCode2 == 93) {
                    int measuredWidth = getMeasuredWidth();
                    if (keyCode2 == 93) {
                        i0(measuredWidth, 0, false);
                        return true;
                    }
                    i0(-measuredWidth, 0, false);
                    return true;
                }
                if (keyCode2 == 122 || keyCode2 == 123) {
                    boolean zL2 = layoutManager.L();
                    if (keyCode2 == 122) {
                        if (zL2) {
                            iA = getAdapter().a();
                        }
                    } else if (!zL2) {
                        iA = getAdapter().a();
                    }
                    j0(iA);
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f4, boolean z2) {
        return getScrollingChildHelper().a(f, f4, z2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f4) {
        return getScrollingChildHelper().b(f, f4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i10, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i10, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i10, int i11, int i12, int[] iArr) {
        return getScrollingChildHelper().d(i, i10, i11, i12, iArr, 0, null);
    }

    @Override // android.view.View
    public final boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchRestoreInstanceState(SparseArray sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchSaveInstanceState(SparseArray sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        boolean z2;
        super.draw(canvas);
        ArrayList arrayList = this.J;
        int size = arrayList.size();
        boolean z10 = false;
        for (int i = 0; i < size; i++) {
            ((f0) arrayList.get(i)).b(canvas, this);
        }
        EdgeEffect edgeEffect = this.f1647e0;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int iSave = canvas.save();
            int paddingBottom = this.B ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((-getHeight()) + paddingBottom, 0.0f);
            EdgeEffect edgeEffect2 = this.f1647e0;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(iSave);
        }
        EdgeEffect edgeEffect3 = this.f1648f0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int iSave2 = canvas.save();
            if (this.B) {
                canvas.translate(getPaddingLeft(), getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f1648f0;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(iSave2);
        }
        EdgeEffect edgeEffect5 = this.f1649g0;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int iSave3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.B ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate(paddingTop, -width);
            EdgeEffect edgeEffect6 = this.f1649g0;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(iSave3);
        }
        EdgeEffect edgeEffect7 = this.f1650h0;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int iSave4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.B) {
                canvas.translate(getPaddingRight() + (-getWidth()), getPaddingBottom() + (-getHeight()));
            } else {
                canvas.translate(-getWidth(), -getHeight());
            }
            EdgeEffect edgeEffect8 = this.f1650h0;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z10 = true;
            }
            z2 |= z10;
            canvas.restoreToCount(iSave4);
        }
        if ((z2 || this.f1651i0 == null || arrayList.size() <= 0 || !this.f1651i0.f()) ? z2 : true) {
            postInvalidateOnAnimation();
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j5) {
        return super.drawChild(canvas, view, j5);
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00cb  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0108  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean e0(int r19, int r20, android.view.MotionEvent r21, int r22) {
        /*
            Method dump skipped, instruction units count: 322
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.e0(int, int, android.view.MotionEvent, int):boolean");
    }

    public final void f0(int i, int i10, int[] iArr) {
        x0 x0Var;
        k0();
        T();
        Trace.beginSection("RV Scroll");
        t0 t0Var = this.A0;
        C(t0Var);
        n0 n0Var = this.f1666w;
        int iQ0 = i != 0 ? this.H.q0(i, n0Var, t0Var) : 0;
        int iS0 = i10 != 0 ? this.H.s0(i10, n0Var, t0Var) : 0;
        Trace.endSection();
        int i11 = this.f1672z.i();
        for (int i12 = 0; i12 < i11; i12++) {
            View viewH = this.f1672z.h(i12);
            x0 x0VarL = L(viewH);
            if (x0VarL != null && (x0Var = x0VarL.i) != null) {
                View view = x0Var.f10962a;
                int left = viewH.getLeft();
                int top = viewH.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
        U(true);
        m0(false);
        if (iArr != null) {
            iArr[0] = iQ0;
            iArr[1] = iS0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:118:0x0167  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0197 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0061  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00ce A[ADDED_TO_REGION] */
    @Override // android.view.ViewGroup, android.view.ViewParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View focusSearch(android.view.View r17, int r18) {
        /*
            Method dump skipped, instruction units count: 413
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.focusSearch(android.view.View, int):android.view.View");
    }

    public final void g0(int i) {
        if (this.R) {
            return;
        }
        o0();
        h0 h0Var = this.H;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h0Var.r0(i);
            awakenScrollBars();
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h0 h0Var = this.H;
        if (h0Var != null) {
            return h0Var.r();
        }
        throw new IllegalStateException(e6.j.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        h0 h0Var = this.H;
        if (h0Var != null) {
            return h0Var.s(getContext(), attributeSet);
        }
        throw new IllegalStateException(e6.j.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Override // android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public z getAdapter() {
        return this.G;
    }

    @Override // android.view.View
    public int getBaseline() {
        h0 h0Var = this.H;
        if (h0Var == null) {
            return super.getBaseline();
        }
        h0Var.getClass();
        return -1;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        return super.getChildDrawingOrder(i, i10);
    }

    @Override // android.view.ViewGroup
    public boolean getClipToPadding() {
        return this.B;
    }

    public y0 getCompatAccessibilityDelegate() {
        return this.H0;
    }

    public d0 getEdgeEffectFactory() {
        return this.f1646d0;
    }

    public e0 getItemAnimator() {
        return this.f1651i0;
    }

    public int getItemDecorationCount() {
        return this.J.size();
    }

    public h0 getLayoutManager() {
        return this.H;
    }

    public int getMaxFlingVelocity() {
        return this.f1661t0;
    }

    public int getMinFlingVelocity() {
        return this.f1660s0;
    }

    public long getNanoTime() {
        if (a1) {
            return System.nanoTime();
        }
        return 0L;
    }

    public j0 getOnFlingListener() {
        return this.f1659r0;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f1667w0;
    }

    public m0 getRecycledViewPool() {
        return this.f1666w.c();
    }

    public int getScrollState() {
        return this.f1652j0;
    }

    public final void h(x0 x0Var) {
        View view = x0Var.f10962a;
        boolean z2 = view.getParent() == this;
        this.f1666w.l(L(view));
        if (x0Var.j()) {
            this.f1672z.c(view, -1, view.getLayoutParams(), true);
            return;
        }
        if (!z2) {
            this.f1672z.b(view, -1, true);
            return;
        }
        d4.e0 e0Var = this.f1672z;
        int iIndexOfChild = ((RecyclerView) ((e) e0Var.f3838w).f10436v).indexOfChild(view);
        if (iIndexOfChild >= 0) {
            ((af.a) e0Var.f3839x).L(iIndexOfChild);
            e0Var.m(view);
        } else {
            throw new IllegalArgumentException("view is not a child, cannot hide " + view);
        }
    }

    public final boolean h0(EdgeEffect edgeEffect, int i, int i10) {
        if (i > 0) {
            return true;
        }
        float fK = com.bumptech.glide.c.k(edgeEffect) * i10;
        float fAbs = Math.abs(-i) * 0.35f;
        float f = this.f1662u * 0.015f;
        double dLog = Math.log(fAbs / f);
        double d10 = Y0;
        return ((float) (Math.exp((d10 / (d10 - 1.0d)) * dLog) * ((double) f))) < fK;
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().f(0);
    }

    public final void i(f0 f0Var) {
        h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.c("Cannot add item decoration during a scroll  or layout");
        }
        ArrayList arrayList = this.J;
        if (arrayList.isEmpty()) {
            setWillNotDraw(false);
        }
        arrayList.add(f0Var);
        R();
        requestLayout();
    }

    public final void i0(int i, int i10, boolean z2) {
        h0 h0Var = this.H;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R) {
            return;
        }
        if (!h0Var.d()) {
            i = 0;
        }
        if (!this.H.e()) {
            i10 = 0;
        }
        if (i == 0 && i10 == 0) {
            return;
        }
        if (z2) {
            int i11 = i != 0 ? 1 : 0;
            if (i10 != 0) {
                i11 |= 2;
            }
            getScrollingChildHelper().g(i11, 1);
        }
        this.f1669x0.c(i, i10, Integer.MIN_VALUE, null);
    }

    @Override // android.view.View
    public final boolean isAttachedToWindow() {
        return this.M;
    }

    @Override // android.view.ViewGroup
    public final boolean isLayoutSuppressed() {
        return this.R;
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().f10467d;
    }

    public final void j(k0 k0Var) {
        if (this.C0 == null) {
            this.C0 = new ArrayList();
        }
        this.C0.add(k0Var);
    }

    public final void j0(int i) {
        if (this.R) {
            return;
        }
        h0 h0Var = this.H;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else {
            h0Var.B0(this, i);
        }
    }

    public final void k(String str) {
        if (P()) {
            if (str != null) {
                throw new IllegalStateException(str);
            }
            throw new IllegalStateException(e6.j.k(this, new StringBuilder("Cannot call this method while RecyclerView is computing a layout or scrolling")));
        }
        if (this.f1645c0 > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException(e6.j.k(this, new StringBuilder(""))));
        }
    }

    public final void k0() {
        int i = this.P + 1;
        this.P = i;
        if (i != 1 || this.R) {
            return;
        }
        this.Q = false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void l0(int i) {
        boolean zD = this.H.d();
        int i10 = zD;
        if (this.H.e()) {
            i10 = (zD ? 1 : 0) | 2;
        }
        getScrollingChildHelper().g(i10, i);
    }

    public final void m() {
        int iL = this.f1672z.l();
        for (int i = 0; i < iL; i++) {
            x0 x0VarM = M(this.f1672z.k(i));
            if (!x0VarM.o()) {
                x0VarM.f10965d = -1;
                x0VarM.f10967g = -1;
            }
        }
        n0 n0Var = this.f1666w;
        ArrayList arrayList = n0Var.f10881a;
        ArrayList arrayList2 = n0Var.f10883c;
        int size = arrayList2.size();
        for (int i10 = 0; i10 < size; i10++) {
            x0 x0Var = (x0) arrayList2.get(i10);
            x0Var.f10965d = -1;
            x0Var.f10967g = -1;
        }
        int size2 = arrayList.size();
        for (int i11 = 0; i11 < size2; i11++) {
            x0 x0Var2 = (x0) arrayList.get(i11);
            x0Var2.f10965d = -1;
            x0Var2.f10967g = -1;
        }
        ArrayList arrayList3 = n0Var.f10882b;
        if (arrayList3 != null) {
            int size3 = arrayList3.size();
            for (int i12 = 0; i12 < size3; i12++) {
                x0 x0Var3 = (x0) n0Var.f10882b.get(i12);
                x0Var3.f10965d = -1;
                x0Var3.f10967g = -1;
            }
        }
    }

    public final void m0(boolean z2) {
        if (this.P < 1) {
            if (V0) {
                throw new IllegalStateException(e6.j.k(this, new StringBuilder("stopInterceptRequestLayout was called more times than startInterceptRequestLayout.")));
            }
            this.P = 1;
        }
        if (!z2 && !this.R) {
            this.Q = false;
        }
        if (this.P == 1) {
            if (z2 && this.Q && !this.R && this.H != null && this.G != null) {
                r();
            }
            if (!this.R) {
                this.Q = false;
            }
        }
        this.P--;
    }

    public final void n(int i, int i10) {
        boolean zIsFinished;
        EdgeEffect edgeEffect = this.f1647e0;
        if (edgeEffect == null || edgeEffect.isFinished() || i <= 0) {
            zIsFinished = false;
        } else {
            this.f1647e0.onRelease();
            zIsFinished = this.f1647e0.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f1649g0;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i < 0) {
            this.f1649g0.onRelease();
            zIsFinished |= this.f1649g0.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f1648f0;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i10 > 0) {
            this.f1648f0.onRelease();
            zIsFinished |= this.f1648f0.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f1650h0;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i10 < 0) {
            this.f1650h0.onRelease();
            zIsFinished |= this.f1650h0.isFinished();
        }
        if (zIsFinished) {
            postInvalidateOnAnimation();
        }
    }

    public final void n0(int i) {
        getScrollingChildHelper().h(i);
    }

    public final void o0() {
        t tVar;
        setScrollState(0);
        w0 w0Var = this.f1669x0;
        w0Var.A.removeCallbacks(w0Var);
        w0Var.f10955w.abortAnimation();
        h0 h0Var = this.H;
        if (h0Var == null || (tVar = h0Var.f10821e) == null) {
            return;
        }
        tVar.i();
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0058  */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onAttachedToWindow() {
        /*
            r5 = this;
            super.onAttachedToWindow()
            r0 = 0
            r5.f1644b0 = r0
            r1 = 1
            r5.M = r1
            boolean r2 = r5.O
            if (r2 == 0) goto L15
            boolean r2 = r5.isLayoutRequested()
            if (r2 != 0) goto L15
            r2 = r1
            goto L16
        L15:
            r2 = r0
        L16:
            r5.O = r2
            q4.n0 r2 = r5.f1666w
            r2.d()
            q4.h0 r2 = r5.H
            if (r2 == 0) goto L26
            r2.f10822g = r1
            r2.R(r5)
        L26:
            r5.G0 = r0
            boolean r0 = androidx.recyclerview.widget.RecyclerView.a1
            if (r0 == 0) goto L80
            java.lang.ThreadLocal r0 = q4.m.f10872y
            java.lang.Object r1 = r0.get()
            q4.m r1 = (q4.m) r1
            r5.f1671y0 = r1
            if (r1 != 0) goto L66
            q4.m r1 = new q4.m
            r1.<init>()
            r5.f1671y0 = r1
            java.util.WeakHashMap r1 = q0.o0.f10475a
            android.view.Display r1 = r5.getDisplay()
            boolean r2 = r5.isInEditMode()
            if (r2 != 0) goto L58
            if (r1 == 0) goto L58
            float r1 = r1.getRefreshRate()
            r2 = 1106247680(0x41f00000, float:30.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 < 0) goto L58
            goto L5a
        L58:
            r1 = 1114636288(0x42700000, float:60.0)
        L5a:
            q4.m r2 = r5.f1671y0
            r3 = 1315859240(0x4e6e6b28, float:1.0E9)
            float r3 = r3 / r1
            long r3 = (long) r3
            r2.f10876w = r3
            r0.set(r2)
        L66:
            q4.m r0 = r5.f1671y0
            java.util.ArrayList r0 = r0.f10874u
            boolean r1 = androidx.recyclerview.widget.RecyclerView.V0
            if (r1 == 0) goto L7d
            boolean r1 = r0.contains(r5)
            if (r1 != 0) goto L75
            goto L7d
        L75:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "RecyclerView already present in worker list!"
            r0.<init>(r1)
            throw r0
        L7d:
            r0.add(r5)
        L80:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onAttachedToWindow():void");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        q4.m mVar;
        super.onDetachedFromWindow();
        e0 e0Var = this.f1651i0;
        if (e0Var != null) {
            e0Var.e();
        }
        o0();
        int i = 0;
        this.M = false;
        h0 h0Var = this.H;
        if (h0Var != null) {
            h0Var.f10822g = false;
            h0Var.S(this);
        }
        this.N0.clear();
        removeCallbacks(this.O0);
        this.A.getClass();
        while (g1.f10801d.i() != null) {
        }
        n0 n0Var = this.f1666w;
        ArrayList arrayList = n0Var.f10883c;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            w0.a.a(((x0) arrayList.get(i10)).f10962a);
        }
        n0Var.e(n0Var.f10887h.G, false);
        int i11 = w0.a.f13504a;
        while (i < getChildCount()) {
            int i12 = i + 1;
            View childAt = getChildAt(i);
            if (childAt == null) {
                throw new IndexOutOfBoundsException();
            }
            int i13 = w0.a.f13504a;
            w0.b bVar = (w0.b) childAt.getTag(i13);
            if (bVar == null) {
                bVar = new w0.b();
                childAt.setTag(i13, bVar);
            }
            ArrayList arrayList2 = bVar.f13506a;
            int iR = od.j.R(arrayList2);
            if (-1 < iR) {
                arrayList2.get(iR).getClass();
                throw new ClassCastException();
            }
            i = i12;
        }
        if (!a1 || (mVar = this.f1671y0) == null) {
            return;
        }
        boolean zRemove = mVar.f10874u.remove(this);
        if (V0 && !zRemove) {
            throw new IllegalStateException("RecyclerView removal failed!");
        }
        this.f1671y0 = null;
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        ArrayList arrayList = this.J;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((f0) arrayList.get(i)).a(this);
        }
    }

    @Override // android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue;
        int i;
        boolean z2;
        if (this.H != null && !this.R && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                float f = this.H.e() ? -motionEvent.getAxisValue(9) : 0.0f;
                axisValue = this.H.d() ? motionEvent.getAxisValue(10) : 0.0f;
                i = 0;
                z2 = false;
                f = f;
            } else if ((motionEvent.getSource() & 4194304) != 0) {
                axisValue = motionEvent.getAxisValue(26);
                if (this.H.e()) {
                    float f4 = -axisValue;
                    axisValue = 0.0f;
                    f = f4;
                } else if (!this.H.d()) {
                    axisValue = 0.0f;
                }
                i = 26;
                z2 = this.S0;
            } else {
                axisValue = 0.0f;
                i = 0;
                z2 = false;
            }
            int i10 = (int) (f * this.f1665v0);
            int i11 = (int) (axisValue * this.f1663u0);
            if (z2) {
                OverScroller overScroller = this.f1669x0.f10955w;
                i0((overScroller.getFinalX() - overScroller.getCurrX()) + i11, (overScroller.getFinalY() - overScroller.getCurrY()) + i10, true);
            } else {
                h0 h0Var = this.H;
                if (h0Var == null) {
                    Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
                } else if (!this.R) {
                    int[] iArr = this.M0;
                    iArr[0] = 0;
                    iArr[1] = 0;
                    boolean zD = h0Var.d();
                    boolean zE = this.H.e();
                    int i12 = zE ? (zD ? 1 : 0) | 2 : zD ? 1 : 0;
                    float y10 = motionEvent.getY();
                    float x10 = motionEvent.getX();
                    int iB0 = i11 - b0(i11, y10);
                    int iC0 = i10 - c0(i10, x10);
                    getScrollingChildHelper().g(i12, 1);
                    if (u(zD ? iB0 : 0, zE ? iC0 : 0, 1, this.M0, this.K0)) {
                        iB0 -= iArr[0];
                        iC0 -= iArr[1];
                    }
                    e0(zD ? iB0 : 0, zE ? iC0 : 0, motionEvent, 1);
                    q4.m mVar = this.f1671y0;
                    if (mVar != null && (iB0 != 0 || iC0 != 0)) {
                        mVar.a(this, iB0, iC0);
                    }
                    n0(1);
                }
            }
            if (i != 0 && !z2) {
                this.U0.a(motionEvent, i);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        boolean z10;
        if (!this.R) {
            this.L = null;
            if (E(motionEvent)) {
                VelocityTracker velocityTracker = this.l0;
                if (velocityTracker != null) {
                    velocityTracker.clear();
                }
                n0(0);
                a0();
                setScrollState(0);
                return true;
            }
            h0 h0Var = this.H;
            if (h0Var != null) {
                boolean zD = h0Var.d();
                boolean zE = this.H.e();
                if (this.l0 == null) {
                    this.l0 = VelocityTracker.obtain();
                }
                this.l0.addMovement(motionEvent);
                int actionMasked = motionEvent.getActionMasked();
                int actionIndex = motionEvent.getActionIndex();
                if (actionMasked == 0) {
                    if (this.S) {
                        this.S = false;
                    }
                    this.f1653k0 = motionEvent.getPointerId(0);
                    int x10 = (int) (motionEvent.getX() + 0.5f);
                    this.f1656o0 = x10;
                    this.f1654m0 = x10;
                    int y10 = (int) (motionEvent.getY() + 0.5f);
                    this.f1657p0 = y10;
                    this.f1655n0 = y10;
                    EdgeEffect edgeEffect = this.f1647e0;
                    if (edgeEffect == null || com.bumptech.glide.c.k(edgeEffect) == 0.0f || canScrollHorizontally(-1)) {
                        z2 = false;
                    } else {
                        com.bumptech.glide.c.q(this.f1647e0, 0.0f, 1.0f - (motionEvent.getY() / getHeight()));
                        z2 = true;
                    }
                    EdgeEffect edgeEffect2 = this.f1649g0;
                    if (edgeEffect2 != null && com.bumptech.glide.c.k(edgeEffect2) != 0.0f && !canScrollHorizontally(1)) {
                        com.bumptech.glide.c.q(this.f1649g0, 0.0f, motionEvent.getY() / getHeight());
                        z2 = true;
                    }
                    EdgeEffect edgeEffect3 = this.f1648f0;
                    if (edgeEffect3 != null && com.bumptech.glide.c.k(edgeEffect3) != 0.0f && !canScrollVertically(-1)) {
                        com.bumptech.glide.c.q(this.f1648f0, 0.0f, motionEvent.getX() / getWidth());
                        z2 = true;
                    }
                    EdgeEffect edgeEffect4 = this.f1650h0;
                    if (edgeEffect4 != null && com.bumptech.glide.c.k(edgeEffect4) != 0.0f && !canScrollVertically(1)) {
                        com.bumptech.glide.c.q(this.f1650h0, 0.0f, 1.0f - (motionEvent.getX() / getWidth()));
                        z2 = true;
                    }
                    if (z2 || this.f1652j0 == 2) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        setScrollState(1);
                        n0(1);
                    }
                    int[] iArr = this.L0;
                    iArr[1] = 0;
                    iArr[0] = 0;
                    l0(0);
                } else if (actionMasked == 1) {
                    this.l0.clear();
                    n0(0);
                } else if (actionMasked == 2) {
                    int iFindPointerIndex = motionEvent.findPointerIndex(this.f1653k0);
                    if (iFindPointerIndex < 0) {
                        Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f1653k0 + " not found. Did any MotionEvents get skipped?");
                        return false;
                    }
                    int x11 = (int) (motionEvent.getX(iFindPointerIndex) + 0.5f);
                    int y11 = (int) (motionEvent.getY(iFindPointerIndex) + 0.5f);
                    if (this.f1652j0 != 1) {
                        int i = x11 - this.f1654m0;
                        int i10 = y11 - this.f1655n0;
                        if (!zD || Math.abs(i) <= this.f1658q0) {
                            z10 = false;
                        } else {
                            this.f1656o0 = x11;
                            z10 = true;
                        }
                        if (zE && Math.abs(i10) > this.f1658q0) {
                            this.f1657p0 = y11;
                            z10 = true;
                        }
                        if (z10) {
                            setScrollState(1);
                        }
                    }
                } else if (actionMasked == 3) {
                    VelocityTracker velocityTracker2 = this.l0;
                    if (velocityTracker2 != null) {
                        velocityTracker2.clear();
                    }
                    n0(0);
                    a0();
                    setScrollState(0);
                } else if (actionMasked == 5) {
                    this.f1653k0 = motionEvent.getPointerId(actionIndex);
                    int x12 = (int) (motionEvent.getX(actionIndex) + 0.5f);
                    this.f1656o0 = x12;
                    this.f1654m0 = x12;
                    int y12 = (int) (motionEvent.getY(actionIndex) + 0.5f);
                    this.f1657p0 = y12;
                    this.f1655n0 = y12;
                } else if (actionMasked == 6) {
                    V(motionEvent);
                }
                if (this.f1652j0 == 1) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        Trace.beginSection("RV OnLayout");
        r();
        Trace.endSection();
        this.O = true;
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        h0 h0Var = this.H;
        if (h0Var == null) {
            q(i, i10);
            return;
        }
        boolean zK = h0Var.K();
        boolean z2 = false;
        t0 t0Var = this.A0;
        if (zK) {
            int mode = View.MeasureSpec.getMode(i);
            int mode2 = View.MeasureSpec.getMode(i10);
            this.H.f10818b.q(i, i10);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.P0 = z2;
            if (z2 || this.G == null) {
                return;
            }
            if (t0Var.f10938d == 1) {
                s();
            }
            this.H.u0(i, i10);
            t0Var.i = true;
            t();
            this.H.w0(i, i10);
            if (this.H.z0()) {
                this.H.u0(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824));
                t0Var.i = true;
                t();
                this.H.w0(i, i10);
            }
            this.Q0 = getMeasuredWidth();
            this.R0 = getMeasuredHeight();
            return;
        }
        if (this.N) {
            this.H.f10818b.q(i, i10);
            return;
        }
        if (this.U) {
            k0();
            T();
            X();
            U(true);
            if (t0Var.f10943k) {
                t0Var.f10940g = true;
            } else {
                this.f1670y.e();
                t0Var.f10940g = false;
            }
            this.U = false;
            m0(false);
        } else if (t0Var.f10943k) {
            setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
            return;
        }
        z zVar = this.G;
        if (zVar != null) {
            t0Var.f10939e = zVar.a();
        } else {
            t0Var.f10939e = 0;
        }
        k0();
        this.H.f10818b.q(i, i10);
        m0(false);
        t0Var.f10940g = false;
    }

    @Override // android.view.ViewGroup
    public final boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (P()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i, rect);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof q0)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        q0 q0Var = (q0) parcelable;
        this.f1668x = q0Var;
        super.onRestoreInstanceState(q0Var.f14205u);
        requestLayout();
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        q0 q0Var = new q0(super.onSaveInstanceState());
        q0 q0Var2 = this.f1668x;
        if (q0Var2 != null) {
            q0Var.f10901w = q0Var2.f10901w;
            return q0Var;
        }
        h0 h0Var = this.H;
        if (h0Var != null) {
            q0Var.f10901w = h0Var.h0();
            return q0Var;
        }
        q0Var.f10901w = null;
        return q0Var;
    }

    @Override // android.view.View
    public final void onSizeChanged(int i, int i10, int i11, int i12) {
        super.onSizeChanged(i, i10, i11, i12);
        if (i == i11 && i10 == i12) {
            return;
        }
        this.f1650h0 = null;
        this.f1648f0 = null;
        this.f1649g0 = null;
        this.f1647e0 = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x020b A[PHI: r1
      0x020b: PHI (r1v50 int) = (r1v34 int), (r1v54 int) binds: [B:95:0x01f4, B:99:0x0207] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:103:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0224  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onTouchEvent(android.view.MotionEvent r19) {
        /*
            Method dump skipped, instruction units count: 799
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public final void p() {
        if (!this.O || this.W) {
            Trace.beginSection("RV FullInvalidate");
            r();
            Trace.endSection();
            return;
        }
        if (this.f1670y.m()) {
            p pVar = this.f1670y;
            int i = pVar.f8475a;
            if ((i & 4) == 0 || (i & 11) != 0) {
                if (pVar.m()) {
                    Trace.beginSection("RV FullInvalidate");
                    r();
                    Trace.endSection();
                    return;
                }
                return;
            }
            Trace.beginSection("RV PartialInvalidate");
            k0();
            T();
            this.f1670y.t();
            if (!this.Q) {
                int i10 = this.f1672z.i();
                int i11 = 0;
                while (true) {
                    if (i11 < i10) {
                        x0 x0VarM = M(this.f1672z.h(i11));
                        if (x0VarM != null && !x0VarM.o() && x0VarM.k()) {
                            r();
                            break;
                        }
                        i11++;
                    } else {
                        this.f1670y.d();
                        break;
                    }
                }
            }
            m0(true);
            U(true);
            Trace.endSection();
        }
    }

    public final void q(int i, int i10) {
        int paddingRight = getPaddingRight() + getPaddingLeft();
        WeakHashMap weakHashMap = o0.f10475a;
        setMeasuredDimension(h0.g(i, paddingRight, getMinimumWidth()), h0.g(i10, getPaddingBottom() + getPaddingTop(), getMinimumHeight()));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:166:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x03aa  */
    /* JADX WARN: Type inference failed for: r3v12 */
    /* JADX WARN: Type inference failed for: r3v19 */
    /* JADX WARN: Type inference failed for: r3v20, types: [int] */
    /* JADX WARN: Type inference failed for: r3v23 */
    /* JADX WARN: Type inference failed for: r3v26 */
    /* JADX WARN: Type inference failed for: r3v27 */
    /* JADX WARN: Type inference failed for: r3v28 */
    /* JADX WARN: Type inference failed for: r3v29 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r() {
        /*
            Method dump skipped, instruction units count: 1040
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.r():void");
    }

    @Override // android.view.ViewGroup
    public final void removeDetachedView(View view, boolean z2) {
        x0 x0VarM = M(view);
        if (x0VarM != null) {
            if (x0VarM.j()) {
                x0VarM.f10969j &= -257;
            } else if (!x0VarM.o()) {
                StringBuilder sb2 = new StringBuilder("Called removeDetachedView with a view which is not flagged as tmp detached.");
                sb2.append(x0VarM);
                throw new IllegalArgumentException(e6.j.k(this, sb2));
            }
        } else if (V0) {
            StringBuilder sb3 = new StringBuilder("No ViewHolder found for child: ");
            sb3.append(view);
            throw new IllegalArgumentException(e6.j.k(this, sb3));
        }
        view.clearAnimation();
        M(view);
        super.removeDetachedView(view, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestChildFocus(View view, View view2) {
        t tVar = this.H.f10821e;
        if ((tVar == null || !tVar.f10925e) && !P() && view2 != null) {
            d0(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.H.o0(this, view, rect, z2, false);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        ArrayList arrayList = this.K;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((j) arrayList.get(i)).getClass();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.P != 0 || this.R) {
            this.Q = true;
        } else {
            super.requestLayout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0066  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void s() {
        /*
            Method dump skipped, instruction units count: 523
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.s():void");
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i10) {
        h0 h0Var = this.H;
        if (h0Var == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return;
        }
        if (this.R) {
            return;
        }
        boolean zD = h0Var.d();
        boolean zE = this.H.e();
        if (zD || zE) {
            if (!zD) {
                i = 0;
            }
            if (!zE) {
                i10 = 0;
            }
            e0(i, i10, null, 0);
        }
    }

    @Override // android.view.View
    public final void scrollTo(int i, int i10) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    @Override // android.view.View, android.view.accessibility.AccessibilityEventSource
    public final void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!P()) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        } else {
            int contentChangeTypes = accessibilityEvent != null ? accessibilityEvent.getContentChangeTypes() : 0;
            this.T |= contentChangeTypes != 0 ? contentChangeTypes : 0;
        }
    }

    public void setAccessibilityDelegateCompat(y0 y0Var) {
        this.H0 = y0Var;
        o0.n(this, y0Var);
    }

    public void setAdapter(z zVar) {
        setLayoutFrozen(false);
        z zVar2 = this.G;
        p0 p0Var = this.f1664v;
        if (zVar2 != null) {
            zVar2.f10982a.unregisterObserver(p0Var);
            this.G.getClass();
        }
        e0 e0Var = this.f1651i0;
        if (e0Var != null) {
            e0Var.e();
        }
        h0 h0Var = this.H;
        n0 n0Var = this.f1666w;
        if (h0Var != null) {
            h0Var.k0(n0Var);
            this.H.l0(n0Var);
        }
        n0Var.f10881a.clear();
        n0Var.f();
        p pVar = this.f1670y;
        pVar.u((ArrayList) pVar.f8477c);
        pVar.u((ArrayList) pVar.f8478d);
        pVar.f8475a = 0;
        z zVar3 = this.G;
        this.G = zVar;
        if (zVar != null) {
            zVar.f10982a.registerObserver(p0Var);
        }
        h0 h0Var2 = this.H;
        if (h0Var2 != null) {
            h0Var2.Q();
        }
        z zVar4 = this.G;
        n0Var.f10881a.clear();
        n0Var.f();
        n0Var.e(zVar3, true);
        m0 m0VarC = n0Var.c();
        if (zVar3 != null) {
            m0VarC.f10879b--;
        }
        if (m0VarC.f10879b == 0) {
            SparseArray sparseArray = m0VarC.f10878a;
            for (int i = 0; i < sparseArray.size(); i++) {
                l0 l0Var = (l0) sparseArray.valueAt(i);
                ArrayList arrayList = l0Var.f10868a;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    w0.a.a(((x0) obj).f10962a);
                }
                l0Var.f10868a.clear();
            }
        }
        if (zVar4 != null) {
            m0VarC.f10879b++;
        }
        n0Var.d();
        this.A0.f = true;
        Y(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(c0 c0Var) {
        if (c0Var == null) {
            return;
        }
        setChildrenDrawingOrderEnabled(false);
    }

    @Override // android.view.ViewGroup
    public void setClipToPadding(boolean z2) {
        if (z2 != this.B) {
            this.f1650h0 = null;
            this.f1648f0 = null;
            this.f1649g0 = null;
            this.f1647e0 = null;
        }
        this.B = z2;
        super.setClipToPadding(z2);
        if (this.O) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(d0 d0Var) {
        d0Var.getClass();
        this.f1646d0 = d0Var;
        this.f1650h0 = null;
        this.f1648f0 = null;
        this.f1649g0 = null;
        this.f1647e0 = null;
    }

    public void setHasFixedSize(boolean z2) {
        this.N = z2;
    }

    public void setItemAnimator(e0 e0Var) {
        e0 e0Var2 = this.f1651i0;
        if (e0Var2 != null) {
            e0Var2.e();
            this.f1651i0.f10776a = null;
        }
        this.f1651i0 = e0Var;
        if (e0Var != null) {
            e0Var.f10776a = this.F0;
        }
    }

    public void setItemViewCacheSize(int i) {
        n0 n0Var = this.f1666w;
        n0Var.f10885e = i;
        n0Var.m();
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(h0 h0Var) {
        if (h0Var == this.H) {
            return;
        }
        o0();
        h0 h0Var2 = this.H;
        n0 n0Var = this.f1666w;
        if (h0Var2 != null) {
            e0 e0Var = this.f1651i0;
            if (e0Var != null) {
                e0Var.e();
            }
            this.H.k0(n0Var);
            this.H.l0(n0Var);
            n0Var.f10881a.clear();
            n0Var.f();
            if (this.M) {
                h0 h0Var3 = this.H;
                h0Var3.f10822g = false;
                h0Var3.S(this);
            }
            this.H.x0(null);
            this.H = null;
        } else {
            n0Var.f10881a.clear();
            n0Var.f();
        }
        d4.e0 e0Var2 = this.f1672z;
        RecyclerView recyclerView = (RecyclerView) ((e) e0Var2.f3838w).f10436v;
        ((af.a) e0Var2.f3839x).K();
        ArrayList arrayList = (ArrayList) e0Var2.f3840y;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            x0 x0VarM = M((View) arrayList.get(size));
            if (x0VarM != null) {
                int i = x0VarM.f10975p;
                if (recyclerView.P()) {
                    x0VarM.f10976q = i;
                    recyclerView.N0.add(x0VarM);
                } else {
                    x0VarM.f10962a.setImportantForAccessibility(i);
                }
                x0VarM.f10975p = 0;
            }
            arrayList.remove(size);
        }
        int childCount = recyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = recyclerView.getChildAt(i10);
            M(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeAllViews();
        this.H = h0Var;
        if (h0Var != null) {
            if (h0Var.f10818b != null) {
                StringBuilder sb2 = new StringBuilder("LayoutManager ");
                sb2.append(h0Var);
                sb2.append(" is already attached to a RecyclerView:");
                throw new IllegalArgumentException(e6.j.k(h0Var.f10818b, sb2));
            }
            h0Var.x0(this);
            if (this.M) {
                h0 h0Var4 = this.H;
                h0Var4.f10822g = true;
                h0Var4.R(this);
            }
        }
        n0Var.m();
        requestLayout();
    }

    @Override // android.view.ViewGroup
    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (layoutTransition != null) {
            throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
        }
        super.setLayoutTransition(null);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        m scrollingChildHelper = getScrollingChildHelper();
        if (scrollingChildHelper.f10467d) {
            ViewGroup viewGroup = scrollingChildHelper.f10466c;
            WeakHashMap weakHashMap = o0.f10475a;
            q0.f0.m(viewGroup);
        }
        scrollingChildHelper.f10467d = z2;
    }

    public void setOnFlingListener(j0 j0Var) {
        this.f1659r0 = j0Var;
    }

    @Deprecated
    public void setOnScrollListener(k0 k0Var) {
        this.B0 = k0Var;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f1667w0 = z2;
    }

    public void setRecycledViewPool(m0 m0Var) {
        n0 n0Var = this.f1666w;
        RecyclerView recyclerView = n0Var.f10887h;
        n0Var.e(recyclerView.G, false);
        if (n0Var.f10886g != null) {
            r2.f10879b--;
        }
        n0Var.f10886g = m0Var;
        if (m0Var != null && recyclerView.getAdapter() != null) {
            n0Var.f10886g.f10879b++;
        }
        n0Var.d();
    }

    public void setScrollState(int i) {
        t tVar;
        if (i == this.f1652j0) {
            return;
        }
        if (W0) {
            Log.d("RecyclerView", "setting scroll state to " + i + " from " + this.f1652j0, new Exception());
        }
        this.f1652j0 = i;
        if (i != 2) {
            w0 w0Var = this.f1669x0;
            w0Var.A.removeCallbacks(w0Var);
            w0Var.f10955w.abortAnimation();
            h0 h0Var = this.H;
            if (h0Var != null && (tVar = h0Var.f10821e) != null) {
                tVar.i();
            }
        }
        h0 h0Var2 = this.H;
        if (h0Var2 != null) {
            h0Var2.i0(i);
        }
        k0 k0Var = this.B0;
        if (k0Var != null) {
            k0Var.a(this, i);
        }
        ArrayList arrayList = this.C0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k0) this.C0.get(size)).a(this, i);
            }
        }
    }

    public void setScrollingTouchSlop(int i) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i != 0) {
            if (i == 1) {
                this.f1658q0 = viewConfiguration.getScaledPagingTouchSlop();
                return;
            }
            Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i + "; using default value");
        }
        this.f1658q0 = viewConfiguration.getScaledTouchSlop();
    }

    public void setViewCacheExtension(v0 v0Var) {
        this.f1666w.getClass();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return getScrollingChildHelper().g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        getScrollingChildHelper().h(0);
    }

    @Override // android.view.ViewGroup
    public final void suppressLayout(boolean z2) {
        if (z2 != this.R) {
            k("Do not suppressLayout in layout or scroll");
            if (z2) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                onTouchEvent(MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0));
                this.R = true;
                this.S = true;
                o0();
                return;
            }
            this.R = false;
            if (this.Q && this.H != null && this.G != null) {
                requestLayout();
            }
            this.Q = false;
        }
    }

    public final void t() {
        k0();
        T();
        t0 t0Var = this.A0;
        t0Var.a(6);
        this.f1670y.e();
        t0Var.f10939e = this.G.a();
        t0Var.f10937c = 0;
        if (this.f1668x != null) {
            z zVar = this.G;
            int iC = v.e.c(zVar.f10984c);
            if (iC == 1 ? zVar.a() > 0 : iC != 2) {
                Parcelable parcelable = this.f1668x.f10901w;
                if (parcelable != null) {
                    this.H.g0(parcelable);
                }
                this.f1668x = null;
            }
        }
        t0Var.f10940g = false;
        this.H.e0(this.f1666w, t0Var);
        t0Var.f = false;
        t0Var.f10942j = t0Var.f10942j && this.f1651i0 != null;
        t0Var.f10938d = 4;
        U(true);
        m0(false);
    }

    public final boolean u(int i, int i10, int i11, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().c(i, i10, i11, iArr, iArr2);
    }

    public final void v(int i, int i10, int i11, int i12, int[] iArr, int i13, int[] iArr2) {
        getScrollingChildHelper().d(i, i10, i11, i12, iArr, i13, iArr2);
    }

    public final void w(int i, int i10) {
        this.f1645c0++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i, scrollY - i10);
        k0 k0Var = this.B0;
        if (k0Var != null) {
            k0Var.b(this, i, i10);
        }
        ArrayList arrayList = this.C0;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                ((k0) this.C0.get(size)).b(this, i, i10);
            }
        }
        this.f1645c0--;
    }

    public final void x() {
        if (this.f1650h0 != null) {
            return;
        }
        ((u0) this.f1646d0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1650h0 = edgeEffect;
        if (this.B) {
            edgeEffect.setSize((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom());
        } else {
            edgeEffect.setSize(getMeasuredWidth(), getMeasuredHeight());
        }
    }

    public final void y() {
        if (this.f1647e0 != null) {
            return;
        }
        ((u0) this.f1646d0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1647e0 = edgeEffect;
        if (this.B) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public final void z() {
        if (this.f1649g0 != null) {
            return;
        }
        ((u0) this.f1646d0).getClass();
        EdgeEffect edgeEffect = new EdgeEffect(getContext());
        this.f1649g0 = edgeEffect;
        if (this.B) {
            edgeEffect.setSize((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight());
        } else {
            edgeEffect.setSize(getMeasuredHeight(), getMeasuredWidth());
        }
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i) {
        float fA;
        char c9;
        char c10;
        int i10;
        TypedArray typedArray;
        Constructor constructor;
        super(context, attributeSet, i);
        this.f1664v = new p0(this);
        this.f1666w = new n0(this);
        this.A = new c(5);
        this.C = new x(this, 0);
        this.D = new Rect();
        this.E = new Rect();
        this.F = new RectF();
        this.I = new ArrayList();
        this.J = new ArrayList();
        this.K = new ArrayList();
        this.P = 0;
        this.W = false;
        this.f1643a0 = false;
        this.f1644b0 = 0;
        this.f1645c0 = 0;
        this.f1646d0 = f1642d1;
        q4.h hVar = new q4.h();
        Object[] objArr = null;
        hVar.f10776a = null;
        hVar.f10777b = new ArrayList();
        hVar.f10778c = 120L;
        hVar.f10779d = 120L;
        hVar.f10780e = 250L;
        hVar.f = 250L;
        int i11 = 1;
        hVar.f10806g = true;
        hVar.f10807h = new ArrayList();
        hVar.i = new ArrayList();
        hVar.f10808j = new ArrayList();
        hVar.f10809k = new ArrayList();
        hVar.f10810l = new ArrayList();
        hVar.f10811m = new ArrayList();
        hVar.f10812n = new ArrayList();
        hVar.f10813o = new ArrayList();
        hVar.f10814p = new ArrayList();
        hVar.f10815q = new ArrayList();
        hVar.f10816r = new ArrayList();
        this.f1651i0 = hVar;
        this.f1652j0 = 0;
        this.f1653k0 = -1;
        this.f1663u0 = Float.MIN_VALUE;
        this.f1665v0 = Float.MIN_VALUE;
        this.f1667w0 = true;
        this.f1669x0 = new w0(this);
        this.f1673z0 = a1 ? new k() : null;
        t0 t0Var = new t0();
        t0Var.f10935a = -1;
        t0Var.f10936b = 0;
        t0Var.f10937c = 0;
        t0Var.f10938d = 1;
        t0Var.f10939e = 0;
        t0Var.f = false;
        t0Var.f10940g = false;
        t0Var.f10941h = false;
        t0Var.i = false;
        t0Var.f10942j = false;
        t0Var.f10943k = false;
        this.A0 = t0Var;
        this.D0 = false;
        this.E0 = false;
        y yVar = new y(this);
        this.F0 = yVar;
        this.G0 = false;
        this.I0 = new int[2];
        this.K0 = new int[2];
        this.L0 = new int[2];
        this.M0 = new int[2];
        this.N0 = new ArrayList();
        this.O0 = new x(this, i11);
        this.Q0 = 0;
        this.R0 = 0;
        this.T0 = new y(this);
        this.U0 = new h(getContext(), new o4.c(this));
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f1658q0 = viewConfiguration.getScaledTouchSlop();
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 26) {
            Method method = q0.p0.f10482a;
            fA = j0.a.b(viewConfiguration);
        } else {
            fA = q0.p0.a(viewConfiguration, context);
        }
        this.f1663u0 = fA;
        this.f1665v0 = i12 >= 26 ? j0.a.c(viewConfiguration) : q0.p0.a(viewConfiguration, context);
        this.f1660s0 = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1661t0 = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f1662u = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        setWillNotDraw(getOverScrollMode() == 2);
        this.f1651i0.f10776a = yVar;
        this.f1670y = new p(new a1(this));
        this.f1672z = new d4.e0(new e(3, this));
        WeakHashMap weakHashMap = o0.f10475a;
        if ((i12 >= 26 ? q0.i0.a(this) : 0) == 0 && i12 >= 26) {
            q0.i0.b(this, 8);
        }
        if (getImportantForAccessibility() == 0) {
            setImportantForAccessibility(1);
        }
        this.V = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new y0(this));
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, p4.c.RecyclerView, i, 0);
        o0.m(this, context, p4.c.RecyclerView, attributeSet, typedArrayObtainStyledAttributes, i);
        String string = typedArrayObtainStyledAttributes.getString(p4.c.RecyclerView_layoutManager);
        if (typedArrayObtainStyledAttributes.getInt(p4.c.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.B = typedArrayObtainStyledAttributes.getBoolean(p4.c.RecyclerView_android_clipToPadding, true);
        if (typedArrayObtainStyledAttributes.getBoolean(p4.c.RecyclerView_fastScrollEnabled, false)) {
            StateListDrawable stateListDrawable = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(p4.c.RecyclerView_fastScrollVerticalThumbDrawable);
            Drawable drawable = typedArrayObtainStyledAttributes.getDrawable(p4.c.RecyclerView_fastScrollVerticalTrackDrawable);
            StateListDrawable stateListDrawable2 = (StateListDrawable) typedArrayObtainStyledAttributes.getDrawable(p4.c.RecyclerView_fastScrollHorizontalThumbDrawable);
            Drawable drawable2 = typedArrayObtainStyledAttributes.getDrawable(p4.c.RecyclerView_fastScrollHorizontalTrackDrawable);
            if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
                throw new IllegalArgumentException(e6.j.k(this, new StringBuilder("Trying to set fast scroller without both required drawables.")));
            }
            Resources resources = getContext().getResources();
            c9 = 2;
            c10 = 3;
            typedArray = typedArrayObtainStyledAttributes;
            i10 = i;
            new j(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(p4.b.fastscroll_default_thickness), resources.getDimensionPixelSize(p4.b.fastscroll_minimum_range), resources.getDimensionPixelOffset(p4.b.fastscroll_margin));
        } else {
            c9 = 2;
            c10 = 3;
            i10 = i;
            typedArray = typedArrayObtainStyledAttributes;
        }
        typedArray.recycle();
        this.S0 = context.getPackageManager().hasSystemFeature("android.hardware.rotaryencoder.lowres");
        if (string != null) {
            String strTrim = string.trim();
            if (!strTrim.isEmpty()) {
                if (strTrim.charAt(0) == '.') {
                    strTrim = context.getPackageName() + strTrim;
                } else if (!strTrim.contains(".")) {
                    strTrim = RecyclerView.class.getPackage().getName() + '.' + strTrim;
                }
                String str = strTrim;
                try {
                    Class<? extends U> clsAsSubclass = Class.forName(str, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(h0.class);
                    try {
                        constructor = clsAsSubclass.getConstructor(f1640b1);
                        Object[] objArr2 = new Object[4];
                        objArr2[0] = context;
                        objArr2[1] = attributeSet;
                        objArr2[c9] = Integer.valueOf(i10);
                        objArr2[c10] = 0;
                        objArr = objArr2;
                    } catch (NoSuchMethodException e10) {
                        try {
                            constructor = clsAsSubclass.getConstructor(null);
                        } catch (NoSuchMethodException e11) {
                            e11.initCause(e10);
                            throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + str, e11);
                        }
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h0) constructor.newInstance(objArr));
                } catch (ClassCastException e12) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + str, e12);
                } catch (ClassNotFoundException e13) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + str, e13);
                } catch (IllegalAccessException e14) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + str, e14);
                } catch (InstantiationException e15) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e15);
                } catch (InvocationTargetException e16) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + str, e16);
                }
            }
        }
        int[] iArr = X0;
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i10, 0);
        o0.m(this, context, iArr, attributeSet, typedArrayObtainStyledAttributes2, i10);
        boolean z2 = typedArrayObtainStyledAttributes2.getBoolean(0, true);
        typedArrayObtainStyledAttributes2.recycle();
        setNestedScrollingEnabled(z2);
        setTag(w0.a.f13505b, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        h0 h0Var = this.H;
        if (h0Var != null) {
            return h0Var.t(layoutParams);
        }
        throw new IllegalStateException(e6.j.k(this, new StringBuilder("RecyclerView has no LayoutManager")));
    }

    @Deprecated
    public void setRecyclerListener(q4.o0 o0Var) {
    }
}
