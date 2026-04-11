package o;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.media3.decoder.DecoderInputBuffer;
import java.lang.reflect.Method;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class s3 implements View.OnLongClickListener, View.OnHoverListener, View.OnAttachStateChangeListener {
    public static s3 F;
    public static s3 G;
    public int A;
    public int B;
    public t3 C;
    public boolean D;
    public boolean E;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final View f9350v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final CharSequence f9351w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f9352x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r3 f9353y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final r3 f9354z;

    /* JADX WARN: Type inference failed for: r0v0, types: [o.r3] */
    /* JADX WARN: Type inference failed for: r0v1, types: [o.r3] */
    public s3(View view, CharSequence charSequence) {
        final int i = 0;
        this.f9353y = new Runnable(this) { // from class: o.r3

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ s3 f9345w;

            {
                this.f9345w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f9345w.c(false);
                        break;
                    default:
                        this.f9345w.a();
                        break;
                }
            }
        };
        final int i10 = 1;
        this.f9354z = new Runnable(this) { // from class: o.r3

            /* JADX INFO: renamed from: w, reason: collision with root package name */
            public final /* synthetic */ s3 f9345w;

            {
                this.f9345w = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                switch (i10) {
                    case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                        this.f9345w.c(false);
                        break;
                    default:
                        this.f9345w.a();
                        break;
                }
            }
        };
        this.f9350v = view;
        this.f9351w = charSequence;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(view.getContext());
        Method method = t0.n0.f11784a;
        this.f9352x = Build.VERSION.SDK_INT >= 28 ? j0.a.i(viewConfiguration) : viewConfiguration.getScaledTouchSlop() / 2;
        this.E = true;
        view.setOnLongClickListener(this);
        view.setOnHoverListener(this);
    }

    public static void b(s3 s3Var) {
        s3 s3Var2 = F;
        if (s3Var2 != null) {
            s3Var2.f9350v.removeCallbacks(s3Var2.f9353y);
        }
        F = s3Var;
        if (s3Var != null) {
            s3Var.f9350v.postDelayed(s3Var.f9353y, ViewConfiguration.getLongPressTimeout());
        }
    }

    public final void a() {
        s3 s3Var = G;
        View view = this.f9350v;
        if (s3Var == this) {
            G = null;
            t3 t3Var = this.C;
            if (t3Var != null) {
                View view2 = (View) t3Var.f9368w;
                if (view2.getParent() != null) {
                    ((WindowManager) ((Context) t3Var.f9367v).getSystemService("window")).removeView(view2);
                }
                this.C = null;
                this.E = true;
                view.removeOnAttachStateChangeListener(this);
            } else {
                Log.e("TooltipCompatHandler", "sActiveHandler.mPopup == null");
            }
        }
        if (F == this) {
            b(null);
        }
        view.removeCallbacks(this.f9354z);
    }

    public final void c(boolean z10) {
        int height;
        int i;
        int i10;
        boolean z11;
        int i11;
        int i12;
        long longPressTimeout;
        long j4;
        long j7;
        View view = this.f9350v;
        if (view.isAttachedToWindow()) {
            b(null);
            s3 s3Var = G;
            if (s3Var != null) {
                s3Var.a();
            }
            G = this;
            this.D = z10;
            t3 t3Var = new t3(view.getContext());
            View view2 = (View) t3Var.f9368w;
            Context context = (Context) t3Var.f9367v;
            this.C = t3Var;
            int width = this.A;
            int i13 = this.B;
            boolean z12 = this.D;
            WindowManager.LayoutParams layoutParams = (WindowManager.LayoutParams) t3Var.f9370y;
            if (view2.getParent() != null && view2.getParent() != null) {
                ((WindowManager) context.getSystemService("window")).removeView(view2);
            }
            ((TextView) t3Var.f9369x).setText(this.f9351w);
            int[] iArr = (int[]) t3Var.B;
            int[] iArr2 = (int[]) t3Var.A;
            Rect rect = (Rect) t3Var.f9371z;
            layoutParams.token = view.getApplicationWindowToken();
            int dimensionPixelOffset = context.getResources().getDimensionPixelOffset(g.d.tooltip_precise_anchor_threshold);
            if (view.getWidth() < dimensionPixelOffset) {
                width = view.getWidth() / 2;
            }
            if (view.getHeight() >= dimensionPixelOffset) {
                int dimensionPixelOffset2 = context.getResources().getDimensionPixelOffset(g.d.tooltip_precise_anchor_extra_offset);
                height = i13 + dimensionPixelOffset2;
                i = i13 - dimensionPixelOffset2;
            } else {
                height = view.getHeight();
                i = 0;
            }
            layoutParams.gravity = 49;
            int dimensionPixelOffset3 = context.getResources().getDimensionPixelOffset(z12 ? g.d.tooltip_y_offset_touch : g.d.tooltip_y_offset_non_touch);
            View rootView = view.getRootView();
            ViewGroup.LayoutParams layoutParams2 = rootView.getLayoutParams();
            int i14 = width;
            if (!(layoutParams2 instanceof WindowManager.LayoutParams) || ((WindowManager.LayoutParams) layoutParams2).type != 2) {
                Context context2 = view.getContext();
                while (true) {
                    if (!(context2 instanceof ContextWrapper)) {
                        break;
                    }
                    if (context2 instanceof Activity) {
                        rootView = ((Activity) context2).getWindow().getDecorView();
                        break;
                    }
                    context2 = ((ContextWrapper) context2).getBaseContext();
                }
            }
            if (rootView == null) {
                Log.e("TooltipPopup", "Cannot find app view");
                i12 = 1;
            } else {
                rootView.getWindowVisibleDisplayFrame(rect);
                if (rect.left >= 0 || rect.top >= 0) {
                    i10 = i;
                    z11 = z12;
                    i11 = 0;
                    i12 = 1;
                } else {
                    Resources resources = context.getResources();
                    i12 = 1;
                    i10 = i;
                    z11 = z12;
                    int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
                    int dimensionPixelSize = identifier != 0 ? resources.getDimensionPixelSize(identifier) : 0;
                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                    i11 = 0;
                    rect.set(0, dimensionPixelSize, displayMetrics.widthPixels, displayMetrics.heightPixels);
                }
                rootView.getLocationOnScreen(iArr);
                view.getLocationOnScreen(iArr2);
                int i15 = iArr2[i11] - iArr[i11];
                iArr2[i11] = i15;
                iArr2[i12] = iArr2[i12] - iArr[i12];
                layoutParams.x = (i15 + i14) - (rootView.getWidth() / 2);
                int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(i11, i11);
                view2.measure(iMakeMeasureSpec, iMakeMeasureSpec);
                int measuredHeight = view2.getMeasuredHeight();
                int i16 = iArr2[i12];
                int i17 = ((i16 + i10) - dimensionPixelOffset3) - measuredHeight;
                int i18 = i16 + height + dimensionPixelOffset3;
                if (z11) {
                    if (i17 >= 0) {
                        layoutParams.y = i17;
                    } else {
                        layoutParams.y = i18;
                    }
                } else if (measuredHeight + i18 <= rect.height()) {
                    layoutParams.y = i18;
                } else {
                    layoutParams.y = i17;
                }
            }
            ((WindowManager) context.getSystemService("window")).addView(view2, layoutParams);
            view.addOnAttachStateChangeListener(this);
            if (this.D) {
                j7 = 2500;
            } else {
                WeakHashMap weakHashMap = t0.m0.f11777a;
                if ((view.getWindowSystemUiVisibility() & 1) == i12) {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 3000;
                } else {
                    longPressTimeout = ViewConfiguration.getLongPressTimeout();
                    j4 = 15000;
                }
                j7 = j4 - longPressTimeout;
            }
            r3 r3Var = this.f9354z;
            view.removeCallbacks(r3Var);
            view.postDelayed(r3Var, j7);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x0066  */
    @Override // android.view.View.OnHoverListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onHover(android.view.View r4, android.view.MotionEvent r5) {
        /*
            r3 = this;
            o.t3 r4 = r3.C
            r0 = 0
            if (r4 == 0) goto La
            boolean r4 = r3.D
            if (r4 == 0) goto La
            goto L6f
        La:
            android.view.View r4 = r3.f9350v
            android.content.Context r1 = r4.getContext()
            java.lang.String r2 = "accessibility"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.view.accessibility.AccessibilityManager r1 = (android.view.accessibility.AccessibilityManager) r1
            boolean r2 = r1.isEnabled()
            if (r2 == 0) goto L25
            boolean r1 = r1.isTouchExplorationEnabled()
            if (r1 == 0) goto L25
            goto L6f
        L25:
            int r1 = r5.getAction()
            r2 = 7
            if (r1 == r2) goto L38
            r4 = 10
            if (r1 == r4) goto L31
            goto L6f
        L31:
            r4 = 1
            r3.E = r4
            r3.a()
            return r0
        L38:
            boolean r4 = r4.isEnabled()
            if (r4 == 0) goto L6f
            o.t3 r4 = r3.C
            if (r4 != 0) goto L6f
            float r4 = r5.getX()
            int r4 = (int) r4
            float r5 = r5.getY()
            int r5 = (int) r5
            boolean r1 = r3.E
            if (r1 != 0) goto L66
            int r1 = r3.A
            int r1 = r4 - r1
            int r1 = java.lang.Math.abs(r1)
            int r2 = r3.f9352x
            if (r1 > r2) goto L66
            int r1 = r3.B
            int r1 = r5 - r1
            int r1 = java.lang.Math.abs(r1)
            if (r1 <= r2) goto L6f
        L66:
            r3.A = r4
            r3.B = r5
            r3.E = r0
            b(r3)
        L6f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o.s3.onHover(android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View view) {
        this.A = view.getWidth() / 2;
        this.B = view.getHeight() / 2;
        c(true);
        return true;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
        a();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
    }
}
