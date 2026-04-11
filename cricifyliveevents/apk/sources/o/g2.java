package o;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.PopupWindow;
import com.google.android.gms.internal.measurement.j4;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class g2 implements n.a0 {
    public static final Method V;
    public static final Method W;
    public static final Method X;
    public int A;
    public int B;
    public boolean D;
    public boolean E;
    public boolean F;
    public d2 I;
    public View J;
    public AdapterView.OnItemClickListener K;
    public AdapterView.OnItemSelectedListener L;
    public final Handler Q;
    public Rect S;
    public boolean T;
    public final y U;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f9229v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ListAdapter f9230w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public t1 f9231x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f9232y = -2;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f9233z = -2;
    public final int C = 1002;
    public int G = 0;
    public final int H = Integer.MAX_VALUE;
    public final c2 M = new c2(this, 1);
    public final f2 N = new f2(this);
    public final e2 O = new e2(this);
    public final c2 P = new c2(this, 0);
    public final Rect R = new Rect();

    static {
        int i = Build.VERSION.SDK_INT;
        Class cls = Boolean.TYPE;
        if (i <= 28) {
            try {
                V = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", cls);
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                X = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", Rect.class);
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            try {
                W = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", View.class, Integer.TYPE, cls);
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public g2(Context context, AttributeSet attributeSet, int i, int i10) {
        int resourceId;
        this.f9229v = context;
        this.Q = new Handler(context.getMainLooper());
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.ListPopupWindow, i, 0);
        this.A = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        int dimensionPixelOffset = typedArrayObtainStyledAttributes.getDimensionPixelOffset(g.j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        this.B = dimensionPixelOffset;
        if (dimensionPixelOffset != 0) {
            this.D = true;
        }
        typedArrayObtainStyledAttributes.recycle();
        y yVar = new y(context, attributeSet, i, 0);
        TypedArray typedArrayObtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, g.j.PopupWindow, i, 0);
        if (typedArrayObtainStyledAttributes2.hasValue(g.j.PopupWindow_overlapAnchor)) {
            yVar.setOverlapAnchor(typedArrayObtainStyledAttributes2.getBoolean(g.j.PopupWindow_overlapAnchor, false));
        }
        int i11 = g.j.PopupWindow_android_popupBackground;
        yVar.setBackgroundDrawable((!typedArrayObtainStyledAttributes2.hasValue(i11) || (resourceId = typedArrayObtainStyledAttributes2.getResourceId(i11, 0)) == 0) ? typedArrayObtainStyledAttributes2.getDrawable(i11) : j4.i(context, resourceId));
        typedArrayObtainStyledAttributes2.recycle();
        this.U = yVar;
        yVar.setInputMethodMode(1);
    }

    @Override // n.a0
    public final boolean a() {
        return this.U.isShowing();
    }

    public final int b() {
        return this.A;
    }

    public final Drawable c() {
        return this.U.getBackground();
    }

    @Override // n.a0
    public final void d() {
        int i;
        int iA;
        int paddingBottom;
        t1 t1Var;
        t1 t1Var2 = this.f9231x;
        Context context = this.f9229v;
        y yVar = this.U;
        if (t1Var2 == null) {
            t1 t1VarQ = q(context, !this.T);
            this.f9231x = t1VarQ;
            t1VarQ.setAdapter(this.f9230w);
            this.f9231x.setOnItemClickListener(this.K);
            this.f9231x.setFocusable(true);
            this.f9231x.setFocusableInTouchMode(true);
            this.f9231x.setOnItemSelectedListener(new z1(0, this));
            this.f9231x.setOnScrollListener(this.O);
            AdapterView.OnItemSelectedListener onItemSelectedListener = this.L;
            if (onItemSelectedListener != null) {
                this.f9231x.setOnItemSelectedListener(onItemSelectedListener);
            }
            yVar.setContentView(this.f9231x);
        }
        Drawable background = yVar.getBackground();
        Rect rect = this.R;
        if (background != null) {
            background.getPadding(rect);
            int i10 = rect.top;
            i = rect.bottom + i10;
            if (!this.D) {
                this.B = -i10;
            }
        } else {
            rect.setEmpty();
            i = 0;
        }
        boolean z10 = yVar.getInputMethodMode() == 2;
        View view = this.J;
        int i11 = this.B;
        if (Build.VERSION.SDK_INT <= 23) {
            Method method = W;
            if (method != null) {
                try {
                    iA = ((Integer) method.invoke(yVar, view, Integer.valueOf(i11), Boolean.valueOf(z10))).intValue();
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
                    iA = yVar.getMaxAvailableHeight(view, i11);
                }
            } else {
                iA = yVar.getMaxAvailableHeight(view, i11);
            }
        } else {
            iA = a2.a(yVar, view, i11, z10);
        }
        int i12 = this.f9232y;
        if (i12 == -1) {
            paddingBottom = iA + i;
        } else {
            int i13 = this.f9233z;
            int iA2 = this.f9231x.a(i13 != -2 ? i13 != -1 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), 1073741824) : View.MeasureSpec.makeMeasureSpec(context.getResources().getDisplayMetrics().widthPixels - (rect.left + rect.right), Integer.MIN_VALUE), iA);
            paddingBottom = iA2 + (iA2 > 0 ? this.f9231x.getPaddingBottom() + this.f9231x.getPaddingTop() + i : 0);
        }
        boolean z11 = yVar.getInputMethodMode() == 2;
        yVar.setWindowLayoutType(this.C);
        if (yVar.isShowing()) {
            if (this.J.isAttachedToWindow()) {
                int width = this.f9233z;
                if (width == -1) {
                    width = -1;
                } else if (width == -2) {
                    width = this.J.getWidth();
                }
                if (i12 == -1) {
                    i12 = z11 ? paddingBottom : -1;
                    if (z11) {
                        yVar.setWidth(this.f9233z == -1 ? -1 : 0);
                        yVar.setHeight(0);
                    } else {
                        yVar.setWidth(this.f9233z == -1 ? -1 : 0);
                        yVar.setHeight(-1);
                    }
                } else if (i12 == -2) {
                    i12 = paddingBottom;
                }
                yVar.setOutsideTouchable(true);
                View view2 = this.J;
                int i14 = width;
                int i15 = this.A;
                int i16 = this.B;
                int i17 = i14 < 0 ? -1 : i14;
                if (i12 < 0) {
                    i12 = -1;
                }
                yVar.update(view2, i15, i16, i17, i12);
                return;
            }
            return;
        }
        int width2 = this.f9233z;
        if (width2 == -1) {
            width2 = -1;
        } else if (width2 == -2) {
            width2 = this.J.getWidth();
        }
        if (i12 == -1) {
            i12 = -1;
        } else if (i12 == -2) {
            i12 = paddingBottom;
        }
        yVar.setWidth(width2);
        yVar.setHeight(i12);
        if (Build.VERSION.SDK_INT <= 28) {
            Method method2 = V;
            if (method2 != null) {
                try {
                    method2.invoke(yVar, Boolean.TRUE);
                } catch (Exception unused2) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            b2.b(yVar, true);
        }
        yVar.setOutsideTouchable(true);
        yVar.setTouchInterceptor(this.N);
        if (this.F) {
            yVar.setOverlapAnchor(this.E);
        }
        if (Build.VERSION.SDK_INT <= 28) {
            Method method3 = X;
            if (method3 != null) {
                try {
                    method3.invoke(yVar, this.S);
                } catch (Exception e9) {
                    Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e9);
                }
            }
        } else {
            b2.a(yVar, this.S);
        }
        yVar.showAsDropDown(this.J, this.A, this.B, this.G);
        this.f9231x.setSelection(-1);
        if ((!this.T || this.f9231x.isInTouchMode()) && (t1Var = this.f9231x) != null) {
            t1Var.setListSelectionHidden(true);
            t1Var.requestLayout();
        }
        if (this.T) {
            return;
        }
        this.Q.post(this.P);
    }

    @Override // n.a0
    public final void dismiss() {
        y yVar = this.U;
        yVar.dismiss();
        yVar.setContentView(null);
        this.f9231x = null;
        this.Q.removeCallbacks(this.M);
    }

    @Override // n.a0
    public final t1 f() {
        return this.f9231x;
    }

    public final void h(Drawable drawable) {
        this.U.setBackgroundDrawable(drawable);
    }

    public final void i(int i) {
        this.B = i;
        this.D = true;
    }

    public final void k(int i) {
        this.A = i;
    }

    public final int m() {
        if (this.D) {
            return this.B;
        }
        return 0;
    }

    public void p(ListAdapter listAdapter) {
        d2 d2Var = this.I;
        if (d2Var == null) {
            this.I = new d2(0, this);
        } else {
            ListAdapter listAdapter2 = this.f9230w;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(d2Var);
            }
        }
        this.f9230w = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.I);
        }
        t1 t1Var = this.f9231x;
        if (t1Var != null) {
            t1Var.setAdapter(this.f9230w);
        }
    }

    public t1 q(Context context, boolean z10) {
        return new t1(context, z10);
    }

    public final void r(int i) {
        Drawable background = this.U.getBackground();
        if (background == null) {
            this.f9233z = i;
            return;
        }
        Rect rect = this.R;
        background.getPadding(rect);
        this.f9233z = rect.left + rect.right + i;
    }
}
