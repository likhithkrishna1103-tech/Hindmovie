package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.measurement.j4;
import com.google.android.material.datepicker.l;
import g.f;
import g.g;
import g.j;
import n.y;
import o.k;
import o.x3;
import t0.m0;
import t0.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public q0 A;
    public boolean B;
    public boolean C;
    public CharSequence D;
    public CharSequence E;
    public View F;
    public View G;
    public View H;
    public LinearLayout I;
    public TextView J;
    public TextView K;
    public final int L;
    public final int M;
    public boolean N;
    public final int O;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final aa.b f530v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Context f531w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public ActionMenuView f532x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public k f533y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public int f534z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = g.a.actionModeStyle;
        super(context, attributeSet, i);
        aa.b bVar = new aa.b();
        bVar.f376c = this;
        bVar.f374a = false;
        this.f530v = bVar;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(g.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f531w = context;
        } else {
            this.f531w = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMode, i, 0);
        int i10 = j.ActionMode_background;
        setBackground((!typedArrayObtainStyledAttributes.hasValue(i10) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i10, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(i10) : j4.i(context, resourceId));
        this.L = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_titleTextStyle, 0);
        this.M = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_subtitleTextStyle, 0);
        this.f534z = typedArrayObtainStyledAttributes.getLayoutDimension(j.ActionMode_height, 0);
        this.O = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i10);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(int i, int i10, int i11, View view, boolean z10) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = ((i11 - measuredHeight) / 2) + i10;
        if (z10) {
            view.layout(i - measuredWidth, i12, i, measuredHeight + i12);
        } else {
            view.layout(i, i12, i + measuredWidth, measuredHeight + i12);
        }
        return z10 ? -measuredWidth : measuredWidth;
    }

    public final void c(m.a aVar) {
        View view = this.F;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.O, (ViewGroup) this, false);
            this.F = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.F);
        }
        View viewFindViewById = this.F.findViewById(f.action_mode_close_button);
        this.G = viewFindViewById;
        viewFindViewById.setOnClickListener(new l(5, aVar));
        n.k kVarC = aVar.c();
        k kVar = this.f533y;
        if (kVar != null) {
            kVar.d();
            o.f fVar = kVar.P;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        k kVar2 = new k(getContext());
        this.f533y = kVar2;
        kVar2.H = true;
        kVar2.I = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        kVarC.b(this.f533y, this.f531w);
        k kVar3 = this.f533y;
        y yVar = kVar3.C;
        if (yVar == null) {
            y yVar2 = (y) kVar3.f9252y.inflate(kVar3.A, (ViewGroup) this, false);
            kVar3.C = yVar2;
            yVar2.b(kVar3.f9251x);
            kVar3.e();
        }
        y yVar3 = kVar3.C;
        if (yVar != yVar3) {
            ((ActionMenuView) yVar3).setPresenter(kVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) yVar3;
        this.f532x = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f532x, layoutParams);
    }

    public final void d() {
        if (this.I == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.I = linearLayout;
            this.J = (TextView) linearLayout.findViewById(f.action_bar_title);
            this.K = (TextView) this.I.findViewById(f.action_bar_subtitle);
            int i = this.L;
            if (i != 0) {
                this.J.setTextAppearance(getContext(), i);
            }
            int i10 = this.M;
            if (i10 != 0) {
                this.K.setTextAppearance(getContext(), i10);
            }
        }
        this.J.setText(this.D);
        this.K.setText(this.E);
        boolean zIsEmpty = TextUtils.isEmpty(this.D);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.E);
        this.K.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.I.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.I.getParent() == null) {
            addView(this.I);
        }
    }

    public final void e() {
        removeAllViews();
        this.H = null;
        this.f532x = null;
        this.f533y = null;
        View view = this.G;
        if (view != null) {
            view.setOnClickListener(null);
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new ViewGroup.MarginLayoutParams(-1, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public int getAnimatedVisibility() {
        return this.A != null ? this.f530v.f375b : getVisibility();
    }

    public int getContentHeight() {
        return this.f534z;
    }

    public CharSequence getSubtitle() {
        return this.E;
    }

    public CharSequence getTitle() {
        return this.D;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            q0 q0Var = this.A;
            if (q0Var != null) {
                q0Var.b();
            }
            super.setVisibility(i);
        }
    }

    public final q0 i(int i, long j4) {
        q0 q0Var = this.A;
        if (q0Var != null) {
            q0Var.b();
        }
        aa.b bVar = this.f530v;
        if (i != 0) {
            q0 q0VarA = m0.a(this);
            q0VarA.a(0.0f);
            q0VarA.c(j4);
            ((ActionBarContextView) bVar.f376c).A = q0VarA;
            bVar.f375b = i;
            q0VarA.d(bVar);
            return q0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        q0 q0VarA2 = m0.a(this);
        q0VarA2.a(1.0f);
        q0VarA2.c(j4);
        ((ActionBarContextView) bVar.f376c).A = q0VarA2;
        bVar.f375b = i;
        q0VarA2.d(bVar);
        return q0VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, g.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        k kVar = this.f533y;
        if (kVar != null) {
            Configuration configuration2 = kVar.f9250w.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i10 = configuration2.screenHeightDp;
            kVar.L = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i10 > 720) || (i > 720 && i10 > 960)) ? 5 : (i >= 500 || (i > 640 && i10 > 480) || (i > 480 && i10 > 640)) ? 4 : i >= 360 ? 3 : 2;
            n.k kVar2 = kVar.f9251x;
            if (kVar2 != null) {
                kVar2.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f533y;
        if (kVar != null) {
            kVar.d();
            o.f fVar = this.f533y.P;
            if (fVar == null || !fVar.b()) {
                return;
            }
            fVar.i.dismiss();
        }
    }

    @Override // android.view.View
    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 9) {
            this.C = false;
        }
        if (!this.C) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.C = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.C = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z10, int i, int i10, int i11, int i12) {
        boolean z11 = x3.f9407a;
        boolean z12 = getLayoutDirection() == 1;
        int paddingRight = z12 ? (i11 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
        View view = this.F;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
            int i13 = z12 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i14 = z12 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i15 = z12 ? paddingRight - i13 : paddingRight + i13;
            int iG = g(i15, paddingTop, paddingTop2, this.F, z12) + i15;
            paddingRight = z12 ? iG - i14 : iG + i14;
        }
        LinearLayout linearLayout = this.I;
        if (linearLayout != null && this.H == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(paddingRight, paddingTop, paddingTop2, this.I, z12);
        }
        View view2 = this.H;
        if (view2 != null) {
            g(paddingRight, paddingTop, paddingTop2, view2, z12);
        }
        int paddingLeft = z12 ? getPaddingLeft() : (i11 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f532x;
        if (actionMenuView != null) {
            g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z12);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i, int i10) {
        if (View.MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_width=\"match_parent\" (or fill_parent)"));
        }
        if (View.MeasureSpec.getMode(i10) == 0) {
            throw new IllegalStateException(getClass().getSimpleName().concat(" can only be used with android:layout_height=\"wrap_content\""));
        }
        int size = View.MeasureSpec.getSize(i);
        int size2 = this.f534z;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i10);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.F;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.F.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f532x;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f532x, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.I;
        if (linearLayout != null && this.H == null) {
            if (this.N) {
                this.I.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.I.getMeasuredWidth();
                boolean z10 = measuredWidth <= paddingLeft;
                if (z10) {
                    paddingLeft -= measuredWidth;
                }
                this.I.setVisibility(z10 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.H;
        if (view2 != null) {
            ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
            int i11 = layoutParams.width;
            int i12 = i11 != -2 ? 1073741824 : Integer.MIN_VALUE;
            if (i11 >= 0) {
                paddingLeft = Math.min(i11, paddingLeft);
            }
            int i13 = layoutParams.height;
            int i14 = i13 == -2 ? Integer.MIN_VALUE : 1073741824;
            if (i13 >= 0) {
                iMin = Math.min(i13, iMin);
            }
            this.H.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(iMin, i14));
        }
        if (this.f534z > 0) {
            setMeasuredDimension(size, size2);
            return;
        }
        int childCount = getChildCount();
        int i15 = 0;
        for (int i16 = 0; i16 < childCount; i16++) {
            int measuredHeight = getChildAt(i16).getMeasuredHeight() + paddingBottom;
            if (measuredHeight > i15) {
                i15 = measuredHeight;
            }
        }
        setMeasuredDimension(size, i15);
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.B = false;
        }
        if (!this.B) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.B = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.B = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.f534z = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.H;
        if (view2 != null) {
            removeView(view2);
        }
        this.H = view;
        if (view != null && (linearLayout = this.I) != null) {
            removeView(linearLayout);
            this.I = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.E = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.D = charSequence;
        d();
        m0.o(this, charSequence);
    }

    public void setTitleOptional(boolean z10) {
        if (z10 != this.N) {
            requestLayout();
        }
        this.N = z10;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
