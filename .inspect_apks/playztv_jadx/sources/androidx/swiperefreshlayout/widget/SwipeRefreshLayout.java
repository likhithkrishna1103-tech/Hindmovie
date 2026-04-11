package androidx.swiperefreshlayout.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import b2.m;
import e5.a;
import e5.d;
import e5.e;
import e5.f;
import e5.g;
import e5.h;
import e5.i;
import e5.j;
import e5.k;
import java.util.WeakHashMap;
import q0.f0;
import q0.l;
import q0.n;
import q0.o;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements o, n, l {

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public static final int[] f1690h0 = {R.attr.enabled};
    public final m A;
    public final q0.m B;
    public final int[] C;
    public final int[] D;
    public final int[] E;
    public boolean F;
    public final int G;
    public int H;
    public float I;
    public float J;
    public boolean K;
    public int L;
    public final DecelerateInterpolator M;
    public final a N;
    public int O;
    public int P;
    public final int Q;
    public final int R;
    public int S;
    public final e T;
    public g U;
    public g V;
    public h W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public h f1691a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f1692b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public int f1693c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public boolean f1694d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public final f f1695e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final g f1696f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final g f1697g0;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public View f1698u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public j f1699v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public boolean f1700w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f1701x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public float f1702y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1703z;

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1700w = false;
        this.f1702y = -1.0f;
        this.C = new int[2];
        this.D = new int[2];
        this.E = new int[2];
        this.L = -1;
        this.O = -1;
        this.f1695e0 = new f(this, 0);
        this.f1696f0 = new g(this, 2);
        this.f1697g0 = new g(this, 3);
        this.f1701x = ViewConfiguration.get(context).getScaledTouchSlop();
        this.G = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.M = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1693c0 = (int) (displayMetrics.density * 40.0f);
        a aVar = new a(getContext());
        float f = aVar.getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = aVar.getContext().obtainStyledAttributes(d5.a.SwipeRefreshLayout);
        aVar.f4429v = typedArrayObtainStyledAttributes.getColor(d5.a.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = o0.f10475a;
        f0.k(aVar, f * 4.0f);
        shapeDrawable.getPaint().setColor(aVar.f4429v);
        aVar.setBackground(shapeDrawable);
        this.N = aVar;
        e eVar = new e(getContext());
        this.T = eVar;
        eVar.c(1);
        this.N.setImageDrawable(this.T);
        this.N.setVisibility(8);
        addView(this.N);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.R = i;
        this.f1702y = i;
        this.A = new m();
        this.B = new q0.m(this);
        setNestedScrollingEnabled(true);
        int i10 = -this.f1693c0;
        this.H = i10;
        this.Q = i10;
        k(1.0f);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1690h0);
        setEnabled(typedArrayObtainStyledAttributes2.getBoolean(0, true));
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i) {
        this.N.getBackground().setAlpha(i);
        this.T.setAlpha(i);
    }

    @Override // q0.n
    public final void a(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // q0.n
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // q0.n
    public final void c(View view, int i, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            onNestedPreScroll(view, i, i10, iArr);
        }
    }

    @Override // q0.o
    public final void d(View view, int i, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i13 != 0) {
            return;
        }
        int i14 = iArr[1];
        if (i13 == 0) {
            this.B.d(i, i10, i11, i12, this.D, i13, iArr);
        }
        int i15 = i12 - (iArr[1] - i14);
        if ((i15 == 0 ? i12 + this.D[1] : i15) >= 0 || g()) {
            return;
        }
        float fAbs = this.f1703z + Math.abs(r14);
        this.f1703z = fAbs;
        j(fAbs);
        iArr[1] = iArr[1] + i15;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f4, boolean z2) {
        return this.B.a(f, f4, z2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f4) {
        return this.B.b(f, f4);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i10, int[] iArr, int[] iArr2) {
        return this.B.c(i, i10, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i10, int i11, int i12, int[] iArr) {
        return this.B.d(i, i10, i11, i12, iArr, 0, null);
    }

    @Override // q0.n
    public final void e(View view, int i, int i10, int i11, int i12, int i13) {
        d(view, i, i10, i11, i12, i13, this.E);
    }

    @Override // q0.n
    public final boolean f(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public final boolean g() {
        View view = this.f1698u;
        return view instanceof ListView ? ((ListView) view).canScrollList(-1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        int i11 = this.O;
        return i11 < 0 ? i10 : i10 == i + (-1) ? i11 : i10 >= i11 ? i10 + 1 : i10;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        m mVar = this.A;
        return mVar.f1762b | mVar.f1761a;
    }

    public int getProgressCircleDiameter() {
        return this.f1693c0;
    }

    public int getProgressViewEndOffset() {
        return this.R;
    }

    public int getProgressViewStartOffset() {
        return this.Q;
    }

    public final void h() {
        if (this.f1698u == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.N)) {
                    this.f1698u = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.B.f(0);
    }

    public final void i(float f) {
        if (f > this.f1702y) {
            m(true, true);
            return;
        }
        this.f1700w = false;
        e eVar = this.T;
        d dVar = eVar.f4453u;
        dVar.f4438e = 0.0f;
        dVar.f = 0.0f;
        eVar.invalidateSelf();
        f fVar = new f(this, 1);
        this.P = this.H;
        g gVar = this.f1697g0;
        gVar.reset();
        gVar.setDuration(200L);
        gVar.setInterpolator(this.M);
        a aVar = this.N;
        aVar.f4428u = fVar;
        aVar.clearAnimation();
        this.N.startAnimation(gVar);
        e eVar2 = this.T;
        d dVar2 = eVar2.f4453u;
        if (dVar2.f4445n) {
            dVar2.f4445n = false;
        }
        eVar2.invalidateSelf();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.B.f10467d;
    }

    public final void j(float f) {
        h hVar;
        h hVar2;
        e eVar = this.T;
        d dVar = eVar.f4453u;
        if (!dVar.f4445n) {
            dVar.f4445n = true;
        }
        eVar.invalidateSelf();
        float fMin = Math.min(1.0f, Math.abs(f / this.f1702y));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f) - this.f1702y;
        int i = this.S;
        if (i <= 0) {
            i = this.R;
        }
        float f4 = i;
        double dMax = Math.max(0.0f, Math.min(fAbs, f4 * 2.0f) / f4) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i10 = this.Q + ((int) ((f4 * fMin) + (f4 * fPow * 2.0f)));
        if (this.N.getVisibility() != 0) {
            this.N.setVisibility(0);
        }
        this.N.setScaleX(1.0f);
        this.N.setScaleY(1.0f);
        if (f < this.f1702y) {
            if (this.T.f4453u.f4451t > 76 && ((hVar2 = this.W) == null || !hVar2.hasStarted() || hVar2.hasEnded())) {
                h hVar3 = new h(this, this.T.f4453u.f4451t, 76);
                hVar3.setDuration(300L);
                a aVar = this.N;
                aVar.f4428u = null;
                aVar.clearAnimation();
                this.N.startAnimation(hVar3);
                this.W = hVar3;
            }
        } else if (this.T.f4453u.f4451t < 255 && ((hVar = this.f1691a0) == null || !hVar.hasStarted() || hVar.hasEnded())) {
            h hVar4 = new h(this, this.T.f4453u.f4451t, 255);
            hVar4.setDuration(300L);
            a aVar2 = this.N;
            aVar2.f4428u = null;
            aVar2.clearAnimation();
            this.N.startAnimation(hVar4);
            this.f1691a0 = hVar4;
        }
        float fMin2 = Math.min(0.8f, fMax * 0.8f);
        e eVar2 = this.T;
        d dVar2 = eVar2.f4453u;
        dVar2.f4438e = 0.0f;
        dVar2.f = fMin2;
        eVar2.invalidateSelf();
        float fMin3 = Math.min(1.0f, fMax);
        e eVar3 = this.T;
        d dVar3 = eVar3.f4453u;
        if (fMin3 != dVar3.f4447p) {
            dVar3.f4447p = fMin3;
        }
        eVar3.invalidateSelf();
        e eVar4 = this.T;
        eVar4.f4453u.f4439g = ((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f;
        eVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i10 - this.H);
    }

    public final void k(float f) {
        setTargetOffsetTopAndBottom((this.P + ((int) ((this.Q - r0) * f))) - this.N.getTop());
    }

    public final void l() {
        this.N.clearAnimation();
        this.T.stop();
        this.N.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.Q - this.H);
        this.H = this.N.getTop();
    }

    public final void m(boolean z2, boolean z10) {
        if (this.f1700w != z2) {
            this.f1692b0 = z10;
            h();
            this.f1700w = z2;
            f fVar = this.f1695e0;
            if (!z2) {
                g gVar = new g(this, 1);
                this.V = gVar;
                gVar.setDuration(150L);
                a aVar = this.N;
                aVar.f4428u = fVar;
                aVar.clearAnimation();
                this.N.startAnimation(this.V);
                return;
            }
            this.P = this.H;
            g gVar2 = this.f1696f0;
            gVar2.reset();
            gVar2.setDuration(200L);
            gVar2.setInterpolator(this.M);
            if (fVar != null) {
                this.N.f4428u = fVar;
            }
            this.N.clearAnimation();
            this.N.startAnimation(gVar2);
        }
    }

    public final void n(float f) {
        float f4 = this.J;
        float f10 = f - f4;
        float f11 = this.f1701x;
        if (f10 <= f11 || this.K) {
            return;
        }
        this.I = f4 + f11;
        this.K = true;
        this.T.setAlpha(76);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        l();
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x005f  */
    @Override // android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            r5.h()
            int r0 = r6.getActionMasked()
            boolean r1 = r5.isEnabled()
            r2 = 0
            if (r1 == 0) goto L88
            boolean r1 = r5.g()
            if (r1 != 0) goto L88
            boolean r1 = r5.f1700w
            if (r1 != 0) goto L88
            boolean r1 = r5.F
            if (r1 == 0) goto L1e
            goto L88
        L1e:
            if (r0 == 0) goto L64
            r1 = 1
            r3 = -1
            if (r0 == r1) goto L5f
            r4 = 2
            if (r0 == r4) goto L44
            r4 = 3
            if (r0 == r4) goto L5f
            r3 = 6
            if (r0 == r3) goto L2e
            goto L85
        L2e:
            int r0 = r6.getActionIndex()
            int r3 = r6.getPointerId(r0)
            int r4 = r5.L
            if (r3 != r4) goto L85
            if (r0 != 0) goto L3d
            r2 = r1
        L3d:
            int r6 = r6.getPointerId(r2)
            r5.L = r6
            goto L85
        L44:
            int r0 = r5.L
            if (r0 != r3) goto L50
            java.lang.String r6 = "SwipeRefreshLayout"
            java.lang.String r0 = "Got ACTION_MOVE event but don't have an active pointer id."
            android.util.Log.e(r6, r0)
            return r2
        L50:
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L57
            goto L88
        L57:
            float r6 = r6.getY(r0)
            r5.n(r6)
            goto L85
        L5f:
            r5.K = r2
            r5.L = r3
            goto L85
        L64:
            e5.a r0 = r5.N
            int r0 = r0.getTop()
            int r1 = r5.Q
            int r1 = r1 - r0
            r5.setTargetOffsetTopAndBottom(r1)
            int r0 = r6.getPointerId(r2)
            r5.L = r0
            r5.K = r2
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L7f
            goto L88
        L7f:
            float r6 = r6.getY(r0)
            r5.J = r6
        L85:
            boolean r6 = r5.K
            return r6
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f1698u == null) {
            h();
        }
        View view = this.f1698u;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.N.getMeasuredWidth();
        int measuredHeight2 = this.N.getMeasuredHeight();
        int i13 = measuredWidth / 2;
        int i14 = measuredWidth2 / 2;
        int i15 = this.H;
        this.N.layout(i13 - i14, i15, i13 + i14, measuredHeight2 + i15);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (this.f1698u == null) {
            h();
        }
        View view = this.f1698u;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.N.measure(View.MeasureSpec.makeMeasureSpec(this.f1693c0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f1693c0, 1073741824));
        this.O = -1;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.N) {
                this.O = i11;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f4, boolean z2) {
        return this.B.a(f, f4, z2);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f4) {
        return this.B.b(f, f4);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i10, int[] iArr) {
        if (i10 > 0) {
            float f = this.f1703z;
            if (f > 0.0f) {
                float f4 = i10;
                if (f4 > f) {
                    iArr[1] = (int) f;
                    this.f1703z = 0.0f;
                } else {
                    this.f1703z = f - f4;
                    iArr[1] = i10;
                }
                j(this.f1703z);
            }
        }
        int i11 = i - iArr[0];
        int i12 = i10 - iArr[1];
        int[] iArr2 = this.C;
        if (dispatchNestedPreScroll(i11, i12, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i10, int i11, int i12) {
        d(view, i, i10, i11, i12, 0, this.E);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        this.A.f1761a = i;
        startNestedScroll(i & 2);
        this.f1703z = 0.0f;
        this.F = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        k kVar = (k) parcelable;
        super.onRestoreInstanceState(kVar.getSuperState());
        setRefreshing(kVar.f4466u);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new k(super.onSaveInstanceState(), this.f1700w);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f1700w || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.A.f1761a = 0;
        this.F = false;
        float f = this.f1703z;
        if (f > 0.0f) {
            i(f);
            this.f1703z = 0.0f;
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !g() && !this.f1700w && !this.F) {
            if (actionMasked == 0) {
                this.L = motionEvent.getPointerId(0);
                this.K = false;
                return true;
            }
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.L);
                if (iFindPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.K) {
                    float y10 = (motionEvent.getY(iFindPointerIndex) - this.I) * 0.5f;
                    this.K = false;
                    i(y10);
                }
                this.L = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.L);
                if (iFindPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y11 = motionEvent.getY(iFindPointerIndex2);
                n(y11);
                if (this.K) {
                    float f = (y11 - this.I) * 0.5f;
                    if (f > 0.0f) {
                        getParent().requestDisallowInterceptTouchEvent(true);
                        j(f);
                    }
                }
                return true;
            }
            if (actionMasked != 3) {
                if (actionMasked != 5) {
                    if (actionMasked == 6) {
                        int actionIndex = motionEvent.getActionIndex();
                        if (motionEvent.getPointerId(actionIndex) == this.L) {
                            this.L = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
                            return true;
                        }
                    }
                    return true;
                }
                int actionIndex2 = motionEvent.getActionIndex();
                if (actionIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                    return false;
                }
                this.L = motionEvent.getPointerId(actionIndex2);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z2) {
        ViewParent parent;
        View view = this.f1698u;
        if (view != null) {
            WeakHashMap weakHashMap = o0.f10475a;
            if (!f0.h(view)) {
                if (this.f1694d0 || (parent = getParent()) == null) {
                    return;
                }
                parent.requestDisallowInterceptTouchEvent(z2);
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void setAnimationProgress(float f) {
        this.N.setScaleX(f);
        this.N.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        h();
        e eVar = this.T;
        d dVar = eVar.f4453u;
        dVar.i = iArr;
        dVar.a(0);
        dVar.a(0);
        eVar.invalidateSelf();
    }

    public void setColorSchemeResources(int... iArr) {
        Context context = getContext();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = context.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1702y = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        if (z2) {
            return;
        }
        l();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z2) {
        this.f1694d0 = z2;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z2) {
        q0.m mVar = this.B;
        if (mVar.f10467d) {
            ViewGroup viewGroup = mVar.f10466c;
            WeakHashMap weakHashMap = o0.f10475a;
            f0.m(viewGroup);
        }
        mVar.f10467d = z2;
    }

    public void setOnRefreshListener(j jVar) {
        this.f1699v = jVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.N.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i));
    }

    public void setRefreshing(boolean z2) {
        if (!z2 || this.f1700w == z2) {
            m(z2, false);
            return;
        }
        this.f1700w = z2;
        setTargetOffsetTopAndBottom((this.R + this.Q) - this.H);
        this.f1692b0 = false;
        this.N.setVisibility(0);
        this.T.setAlpha(255);
        g gVar = new g(this, 0);
        this.U = gVar;
        gVar.setDuration(this.G);
        f fVar = this.f1695e0;
        if (fVar != null) {
            this.N.f4428u = fVar;
        }
        this.N.clearAnimation();
        this.N.startAnimation(this.U);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f1693c0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f1693c0 = (int) (displayMetrics.density * 40.0f);
            }
            this.N.setImageDrawable(null);
            this.T.c(i);
            this.N.setImageDrawable(this.T);
        }
    }

    public void setSlingshotDistance(int i) {
        this.S = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        a aVar = this.N;
        aVar.bringToFront();
        WeakHashMap weakHashMap = o0.f10475a;
        aVar.offsetTopAndBottom(i);
        this.H = aVar.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.B.g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.B.h(0);
    }

    public void setOnChildScrollUpCallback(i iVar) {
    }
}
