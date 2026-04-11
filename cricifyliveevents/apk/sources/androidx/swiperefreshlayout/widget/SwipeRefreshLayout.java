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
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.ListView;
import androidx.emoji2.text.w;
import d4.e;
import j5.a;
import j5.c;
import j5.d;
import j5.f;
import j5.g;
import j5.h;
import j5.i;
import j5.j;
import java.util.WeakHashMap;
import t0.d0;
import t0.k;
import t0.l;
import t0.m;
import t0.m0;
import t0.n;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class SwipeRefreshLayout extends ViewGroup implements n, m, k {

    /* JADX INFO: renamed from: i0, reason: collision with root package name */
    public static final int[] f1473i0 = {R.attr.enabled};
    public float A;
    public final e B;
    public final l C;
    public final int[] D;
    public final int[] E;
    public final int[] F;
    public boolean G;
    public final int H;
    public int I;
    public float J;
    public float K;
    public boolean L;
    public int M;
    public final DecelerateInterpolator N;
    public final a O;
    public int P;
    public int Q;
    public final int R;
    public final int S;
    public int T;
    public final d U;
    public f V;
    public f W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public g f1474a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public g f1475b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public boolean f1476c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public int f1477d0;

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public boolean f1478e0;

    /* JADX INFO: renamed from: f0, reason: collision with root package name */
    public final j5.e f1479f0;

    /* JADX INFO: renamed from: g0, reason: collision with root package name */
    public final f f1480g0;

    /* JADX INFO: renamed from: h0, reason: collision with root package name */
    public final f f1481h0;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public View f1482v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public i f1483w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f1484x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f1485y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public float f1486z;

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1484x = false;
        this.f1486z = -1.0f;
        this.D = new int[2];
        this.E = new int[2];
        this.F = new int[2];
        this.M = -1;
        this.P = -1;
        this.f1479f0 = new j5.e(this, 0);
        this.f1480g0 = new f(this, 2);
        this.f1481h0 = new f(this, 3);
        this.f1485y = ViewConfiguration.get(context).getScaledTouchSlop();
        this.H = getResources().getInteger(R.integer.config_mediumAnimTime);
        setWillNotDraw(false);
        this.N = new DecelerateInterpolator(2.0f);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1477d0 = (int) (displayMetrics.density * 40.0f);
        a aVar = new a(getContext());
        float f = aVar.getContext().getResources().getDisplayMetrics().density;
        TypedArray typedArrayObtainStyledAttributes = aVar.getContext().obtainStyledAttributes(i5.a.SwipeRefreshLayout);
        aVar.f6589w = typedArrayObtainStyledAttributes.getColor(i5.a.SwipeRefreshLayout_swipeRefreshLayoutProgressSpinnerBackgroundColor, -328966);
        typedArrayObtainStyledAttributes.recycle();
        ShapeDrawable shapeDrawable = new ShapeDrawable(new OvalShape());
        WeakHashMap weakHashMap = m0.f11777a;
        d0.k(aVar, f * 4.0f);
        shapeDrawable.getPaint().setColor(aVar.f6589w);
        aVar.setBackground(shapeDrawable);
        this.O = aVar;
        d dVar = new d(getContext());
        this.U = dVar;
        dVar.c(1);
        this.O.setImageDrawable(this.U);
        this.O.setVisibility(8);
        addView(this.O);
        setChildrenDrawingOrderEnabled(true);
        int i = (int) (displayMetrics.density * 64.0f);
        this.S = i;
        this.f1486z = i;
        this.B = new e();
        this.C = new l(this);
        setNestedScrollingEnabled(true);
        int i10 = -this.f1477d0;
        this.I = i10;
        this.R = i10;
        k(1.0f);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, f1473i0);
        setEnabled(typedArrayObtainStyledAttributes2.getBoolean(0, true));
        typedArrayObtainStyledAttributes2.recycle();
    }

    private void setColorViewAlpha(int i) {
        this.O.getBackground().setAlpha(i);
        this.U.setAlpha(i);
    }

    @Override // t0.m
    public final void a(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            onNestedScrollAccepted(view, view2, i);
        }
    }

    @Override // t0.m
    public final void b(View view, int i) {
        if (i == 0) {
            onStopNestedScroll(view);
        }
    }

    @Override // t0.m
    public final void c(View view, int i, int i10, int[] iArr, int i11) {
        if (i11 == 0) {
            onNestedPreScroll(view, i, i10, iArr);
        }
    }

    @Override // t0.n
    public final void d(View view, int i, int i10, int i11, int i12, int i13, int[] iArr) {
        if (i13 != 0) {
            return;
        }
        int i14 = iArr[1];
        if (i13 == 0) {
            this.C.d(i, i10, i11, i12, this.E, i13, iArr);
        }
        int i15 = i12 - (iArr[1] - i14);
        if ((i15 == 0 ? i12 + this.E[1] : i15) >= 0 || g()) {
            return;
        }
        float fAbs = this.A + Math.abs(r14);
        this.A = fAbs;
        j(fAbs);
        iArr[1] = iArr[1] + i15;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent == null || keyEvent.getAction() != 1 || keyEvent.getKeyCode() != 285) {
            return super.dispatchKeyEvent(keyEvent);
        }
        n(true, true);
        return true;
    }

    @Override // android.view.View
    public final boolean dispatchNestedFling(float f, float f10, boolean z10) {
        return this.C.a(f, f10, z10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreFling(float f, float f10) {
        return this.C.b(f, f10);
    }

    @Override // android.view.View
    public final boolean dispatchNestedPreScroll(int i, int i10, int[] iArr, int[] iArr2) {
        return this.C.c(i, i10, 0, iArr, iArr2);
    }

    @Override // android.view.View
    public final boolean dispatchNestedScroll(int i, int i10, int i11, int i12, int[] iArr) {
        return this.C.d(i, i10, i11, i12, iArr, 0, null);
    }

    @Override // t0.m
    public final void e(View view, int i, int i10, int i11, int i12, int i13) {
        d(view, i, i10, i11, i12, i13, this.F);
    }

    @Override // t0.m
    public final boolean f(View view, View view2, int i, int i10) {
        if (i10 == 0) {
            return onStartNestedScroll(view, view2, i);
        }
        return false;
    }

    public final boolean g() {
        View view = this.f1482v;
        return view instanceof ListView ? ((ListView) view).canScrollList(-1) : view.canScrollVertically(-1);
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i, int i10) {
        int i11 = this.P;
        return i11 < 0 ? i10 : i10 == i + (-1) ? i11 : i10 >= i11 ? i10 + 1 : i10;
    }

    @Override // android.view.ViewGroup
    public int getNestedScrollAxes() {
        e eVar = this.B;
        return eVar.f3357b | eVar.f3356a;
    }

    public int getProgressCircleDiameter() {
        return this.f1477d0;
    }

    public int getProgressViewEndOffset() {
        return this.S;
    }

    public int getProgressViewStartOffset() {
        return this.R;
    }

    public final void h() {
        if (this.f1482v == null) {
            for (int i = 0; i < getChildCount(); i++) {
                View childAt = getChildAt(i);
                if (!childAt.equals(this.O)) {
                    this.f1482v = childAt;
                    return;
                }
            }
        }
    }

    @Override // android.view.View
    public final boolean hasNestedScrollingParent() {
        return this.C.f(0);
    }

    public final void i(float f) {
        if (f > this.f1486z) {
            m(true, true);
            return;
        }
        this.f1484x = false;
        d dVar = this.U;
        c cVar = dVar.f6611v;
        cVar.f6596e = 0.0f;
        cVar.f = 0.0f;
        dVar.invalidateSelf();
        j5.e eVar = new j5.e(this, 1);
        this.Q = this.I;
        f fVar = this.f1481h0;
        fVar.reset();
        fVar.setDuration(200L);
        fVar.setInterpolator(this.N);
        a aVar = this.O;
        aVar.f6588v = eVar;
        aVar.clearAnimation();
        this.O.startAnimation(fVar);
        d dVar2 = this.U;
        c cVar2 = dVar2.f6611v;
        if (cVar2.f6603n) {
            cVar2.f6603n = false;
        }
        dVar2.invalidateSelf();
    }

    @Override // android.view.View
    public final boolean isNestedScrollingEnabled() {
        return this.C.f11770d;
    }

    public final void j(float f) {
        g gVar;
        g gVar2;
        d dVar = this.U;
        c cVar = dVar.f6611v;
        if (!cVar.f6603n) {
            cVar.f6603n = true;
        }
        dVar.invalidateSelf();
        float fMin = Math.min(1.0f, Math.abs(f / this.f1486z));
        float fMax = (((float) Math.max(((double) fMin) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float fAbs = Math.abs(f) - this.f1486z;
        int i = this.T;
        if (i <= 0) {
            i = this.S;
        }
        float f10 = i;
        double dMax = Math.max(0.0f, Math.min(fAbs, f10 * 2.0f) / f10) / 4.0f;
        float fPow = ((float) (dMax - Math.pow(dMax, 2.0d))) * 2.0f;
        int i10 = this.R + ((int) ((f10 * fMin) + (f10 * fPow * 2.0f)));
        if (this.O.getVisibility() != 0) {
            this.O.setVisibility(0);
        }
        this.O.setScaleX(1.0f);
        this.O.setScaleY(1.0f);
        if (f < this.f1486z) {
            if (this.U.f6611v.f6609t > 76 && ((gVar2 = this.f1474a0) == null || !gVar2.hasStarted() || gVar2.hasEnded())) {
                g gVar3 = new g(this, this.U.f6611v.f6609t, 76);
                gVar3.setDuration(300L);
                a aVar = this.O;
                aVar.f6588v = null;
                aVar.clearAnimation();
                this.O.startAnimation(gVar3);
                this.f1474a0 = gVar3;
            }
        } else if (this.U.f6611v.f6609t < 255 && ((gVar = this.f1475b0) == null || !gVar.hasStarted() || gVar.hasEnded())) {
            g gVar4 = new g(this, this.U.f6611v.f6609t, 255);
            gVar4.setDuration(300L);
            a aVar2 = this.O;
            aVar2.f6588v = null;
            aVar2.clearAnimation();
            this.O.startAnimation(gVar4);
            this.f1475b0 = gVar4;
        }
        float fMin2 = Math.min(0.8f, fMax * 0.8f);
        d dVar2 = this.U;
        c cVar2 = dVar2.f6611v;
        cVar2.f6596e = 0.0f;
        cVar2.f = fMin2;
        dVar2.invalidateSelf();
        float fMin3 = Math.min(1.0f, fMax);
        d dVar3 = this.U;
        c cVar3 = dVar3.f6611v;
        if (fMin3 != cVar3.f6605p) {
            cVar3.f6605p = fMin3;
        }
        dVar3.invalidateSelf();
        d dVar4 = this.U;
        dVar4.f6611v.f6597g = ((fPow * 2.0f) + ((fMax * 0.4f) - 0.25f)) * 0.5f;
        dVar4.invalidateSelf();
        setTargetOffsetTopAndBottom(i10 - this.I);
    }

    public final void k(float f) {
        setTargetOffsetTopAndBottom((this.Q + ((int) ((this.R - r0) * f))) - this.O.getTop());
    }

    public final void l() {
        this.O.clearAnimation();
        this.U.stop();
        this.O.setVisibility(8);
        setColorViewAlpha(255);
        setTargetOffsetTopAndBottom(this.R - this.I);
        this.I = this.O.getTop();
    }

    public final void m(boolean z10, boolean z11) {
        if (this.f1484x != z10) {
            this.f1476c0 = z11;
            h();
            this.f1484x = z10;
            j5.e eVar = this.f1479f0;
            if (!z10) {
                f fVar = new f(this, 1);
                this.W = fVar;
                fVar.setDuration(150L);
                a aVar = this.O;
                aVar.f6588v = eVar;
                aVar.clearAnimation();
                this.O.startAnimation(this.W);
                return;
            }
            this.Q = this.I;
            f fVar2 = this.f1480g0;
            fVar2.reset();
            fVar2.setDuration(200L);
            fVar2.setInterpolator(this.N);
            if (eVar != null) {
                this.O.f6588v = eVar;
            }
            this.O.clearAnimation();
            this.O.startAnimation(fVar2);
        }
    }

    public final void n(boolean z10, boolean z11) {
        if (!z10 || this.f1484x == z10) {
            m(z10, false);
            return;
        }
        this.f1484x = z10;
        setTargetOffsetTopAndBottom((this.S + this.R) - this.I);
        this.f1476c0 = z11;
        this.O.setVisibility(0);
        this.U.setAlpha(255);
        f fVar = new f(this, 0);
        this.V = fVar;
        fVar.setDuration(this.H);
        j5.e eVar = this.f1479f0;
        if (eVar != null) {
            this.O.f6588v = eVar;
        }
        this.O.clearAnimation();
        this.O.startAnimation(this.V);
    }

    public final void o(float f) {
        float f10 = this.K;
        float f11 = f - f10;
        float f12 = this.f1485y;
        if (f11 <= f12 || this.L) {
            return;
        }
        this.J = f10 + f12;
        this.L = true;
        this.U.setAlpha(76);
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
            boolean r1 = r5.f1484x
            if (r1 != 0) goto L88
            boolean r1 = r5.G
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
            int r4 = r5.M
            if (r3 != r4) goto L85
            if (r0 != 0) goto L3d
            r2 = r1
        L3d:
            int r6 = r6.getPointerId(r2)
            r5.M = r6
            goto L85
        L44:
            int r0 = r5.M
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
            r5.o(r6)
            goto L85
        L5f:
            r5.L = r2
            r5.M = r3
            goto L85
        L64:
            j5.a r0 = r5.O
            int r0 = r0.getTop()
            int r1 = r5.R
            int r1 = r1 - r0
            r5.setTargetOffsetTopAndBottom(r1)
            int r0 = r6.getPointerId(r2)
            r5.M = r0
            r5.L = r2
            int r0 = r6.findPointerIndex(r0)
            if (r0 >= 0) goto L7f
            goto L88
        L7f:
            float r6 = r6.getY(r0)
            r5.K = r6
        L85:
            boolean r6 = r5.L
            return r6
        L88:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.swiperefreshlayout.widget.SwipeRefreshLayout.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() == 0) {
            return;
        }
        if (this.f1482v == null) {
            h();
        }
        View view = this.f1482v;
        if (view == null) {
            return;
        }
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
        int measuredWidth2 = this.O.getMeasuredWidth();
        int measuredHeight2 = this.O.getMeasuredHeight();
        int i13 = measuredWidth / 2;
        int i14 = measuredWidth2 / 2;
        int i15 = this.I;
        this.O.layout(i13 - i14, i15, i13 + i14, measuredHeight2 + i15);
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (this.f1482v == null) {
            h();
        }
        View view = this.f1482v;
        if (view == null) {
            return;
        }
        view.measure(View.MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), View.MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
        this.O.measure(View.MeasureSpec.makeMeasureSpec(this.f1477d0, 1073741824), View.MeasureSpec.makeMeasureSpec(this.f1477d0, 1073741824));
        this.P = -1;
        for (int i11 = 0; i11 < getChildCount(); i11++) {
            if (getChildAt(i11) == this.O) {
                this.P = i11;
                return;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedFling(View view, float f, float f10, boolean z10) {
        return this.C.a(f, f10, z10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onNestedPreFling(View view, float f, float f10) {
        return this.C.b(f, f10);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedPreScroll(View view, int i, int i10, int[] iArr) {
        if (i10 > 0) {
            float f = this.A;
            if (f > 0.0f) {
                float f10 = i10;
                if (f10 > f) {
                    iArr[1] = (int) f;
                    this.A = 0.0f;
                } else {
                    this.A = f - f10;
                    iArr[1] = i10;
                }
                j(this.A);
            }
        }
        int i11 = i - iArr[0];
        int i12 = i10 - iArr[1];
        int[] iArr2 = this.D;
        if (dispatchNestedPreScroll(i11, i12, iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr[1] + iArr2[1];
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScroll(View view, int i, int i10, int i11, int i12) {
        d(view, i, i10, i11, i12, 0, this.F);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onNestedScrollAccepted(View view, View view2, int i) {
        this.B.f3356a = i;
        startNestedScroll(i & 2);
        this.A = 0.0f;
        this.G = true;
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        j jVar = (j) parcelable;
        super.onRestoreInstanceState(jVar.getSuperState());
        setRefreshing(jVar.f6623v);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        return new j(super.onSaveInstanceState(), this.f1484x);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f1484x || (i & 2) == 0) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void onStopNestedScroll(View view) {
        this.B.f3356a = 0;
        this.G = false;
        float f = this.A;
        if (f > 0.0f) {
            i(f);
            this.A = 0.0f;
        } else {
            post(new w(17, this));
        }
        stopNestedScroll();
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (isEnabled() && !g() && !this.f1484x && !this.G) {
            if (actionMasked == 0) {
                this.M = motionEvent.getPointerId(0);
                this.L = false;
                return true;
            }
            if (actionMasked == 1) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.M);
                if (iFindPointerIndex < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                if (this.L) {
                    float y10 = (motionEvent.getY(iFindPointerIndex) - this.J) * 0.5f;
                    this.L = false;
                    i(y10);
                }
                this.M = -1;
                return false;
            }
            if (actionMasked == 2) {
                int iFindPointerIndex2 = motionEvent.findPointerIndex(this.M);
                if (iFindPointerIndex2 < 0) {
                    Log.e("SwipeRefreshLayout", "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                float y11 = motionEvent.getY(iFindPointerIndex2);
                o(y11);
                if (this.L) {
                    float f = (y11 - this.J) * 0.5f;
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
                        if (motionEvent.getPointerId(actionIndex) == this.M) {
                            this.M = motionEvent.getPointerId(actionIndex == 0 ? 1 : 0);
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
                this.M = motionEvent.getPointerId(actionIndex2);
                return true;
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void requestDisallowInterceptTouchEvent(boolean z10) {
        View view;
        if (this.f1478e0 && (view = this.f1482v) != null) {
            WeakHashMap weakHashMap = m0.f11777a;
            if (!d0.h(view)) {
                return;
            }
        }
        super.requestDisallowInterceptTouchEvent(z10);
    }

    public void setAnimationProgress(float f) {
        this.O.setScaleX(f);
        this.O.setScaleY(f);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeColors(int... iArr) {
        h();
        d dVar = this.U;
        c cVar = dVar.f6611v;
        cVar.i = iArr;
        cVar.a(0);
        cVar.a(0);
        dVar.invalidateSelf();
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
        this.f1486z = i;
    }

    @Override // android.view.View
    public void setEnabled(boolean z10) {
        super.setEnabled(z10);
        if (z10) {
            return;
        }
        l();
    }

    @Deprecated
    public void setLegacyRequestDisallowInterceptTouchEventEnabled(boolean z10) {
        this.f1478e0 = z10;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z10) {
        l lVar = this.C;
        if (lVar.f11770d) {
            ViewGroup viewGroup = lVar.f11769c;
            WeakHashMap weakHashMap = m0.f11777a;
            d0.m(viewGroup);
        }
        lVar.f11770d = z10;
    }

    public void setOnRefreshListener(i iVar) {
        this.f1483w = iVar;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.O.setBackgroundColor(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getContext().getColor(i));
    }

    public void setRefreshing(boolean z10) {
        n(z10, false);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            if (i == 0) {
                this.f1477d0 = (int) (displayMetrics.density * 56.0f);
            } else {
                this.f1477d0 = (int) (displayMetrics.density * 40.0f);
            }
            this.O.setImageDrawable(null);
            this.U.c(i);
            this.O.setImageDrawable(this.U);
        }
    }

    public void setSlingshotDistance(int i) {
        this.T = i;
    }

    public void setTargetOffsetTopAndBottom(int i) {
        a aVar = this.O;
        aVar.bringToFront();
        WeakHashMap weakHashMap = m0.f11777a;
        aVar.offsetTopAndBottom(i);
        this.I = aVar.getTop();
    }

    @Override // android.view.View
    public final boolean startNestedScroll(int i) {
        return this.C.g(i, 0);
    }

    @Override // android.view.View
    public final void stopNestedScroll() {
        this.C.h(0);
    }

    public void setOnChildScrollUpCallback(h hVar) {
    }
}
