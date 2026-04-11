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
import com.google.android.material.datepicker.l;
import g.f;
import g.g;
import g.j;
import m.y;
import n.k;
import n.u3;
import q0.o0;
import q0.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ActionBarContextView extends ViewGroup {
    public boolean A;
    public boolean B;
    public CharSequence C;
    public CharSequence D;
    public View E;
    public View F;
    public View G;
    public LinearLayout H;
    public TextView I;
    public TextView J;
    public final int K;
    public final int L;
    public boolean M;
    public final int N;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final g9.b f872u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f873v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public ActionMenuView f874w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public k f875x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public int f876y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public t0 f877z;

    /* JADX WARN: Illegal instructions before constructor call */
    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        int resourceId;
        int i = g.a.actionModeStyle;
        super(context, attributeSet, i);
        g9.b bVar = new g9.b();
        bVar.f5333c = this;
        bVar.f5331a = false;
        this.f872u = bVar;
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(g.a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f873v = context;
        } else {
            this.f873v = new ContextThemeWrapper(context, typedValue.resourceId);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, j.ActionMode, i, 0);
        int i10 = j.ActionMode_background;
        setBackground((!typedArrayObtainStyledAttributes.hasValue(i10) || (resourceId = typedArrayObtainStyledAttributes.getResourceId(i10, 0)) == 0) ? typedArrayObtainStyledAttributes.getDrawable(i10) : com.bumptech.glide.d.p(context, resourceId));
        this.K = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_titleTextStyle, 0);
        this.L = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_subtitleTextStyle, 0);
        this.f876y = typedArrayObtainStyledAttributes.getLayoutDimension(j.ActionMode_height, 0);
        this.N = typedArrayObtainStyledAttributes.getResourceId(j.ActionMode_closeItemLayout, g.abc_action_mode_close_item_material);
        typedArrayObtainStyledAttributes.recycle();
    }

    public static int f(View view, int i, int i10) {
        view.measure(View.MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i10);
        return Math.max(0, i - view.getMeasuredWidth());
    }

    public static int g(int i, int i10, int i11, View view, boolean z2) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i12 = ((i11 - measuredHeight) / 2) + i10;
        if (z2) {
            view.layout(i - measuredWidth, i12, i, measuredHeight + i12);
        } else {
            view.layout(i, i12, i + measuredWidth, measuredHeight + i12);
        }
        return z2 ? -measuredWidth : measuredWidth;
    }

    public final void c(l.a aVar) {
        View view = this.E;
        if (view == null) {
            View viewInflate = LayoutInflater.from(getContext()).inflate(this.N, (ViewGroup) this, false);
            this.E = viewInflate;
            addView(viewInflate);
        } else if (view.getParent() == null) {
            addView(this.E);
        }
        View viewFindViewById = this.E.findViewById(f.action_mode_close_button);
        this.F = viewFindViewById;
        viewFindViewById.setOnClickListener(new l(6, aVar));
        m.k kVarC = aVar.c();
        k kVar = this.f875x;
        if (kVar != null) {
            kVar.d();
            n.f fVar = kVar.O;
            if (fVar != null && fVar.b()) {
                fVar.i.dismiss();
            }
        }
        k kVar2 = new k(getContext());
        this.f875x = kVar2;
        kVar2.G = true;
        kVar2.H = true;
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-2, -1);
        kVarC.b(this.f875x, this.f873v);
        k kVar3 = this.f875x;
        y yVar = kVar3.B;
        if (yVar == null) {
            y yVar2 = (y) kVar3.f8424x.inflate(kVar3.f8426z, (ViewGroup) this, false);
            kVar3.B = yVar2;
            yVar2.b(kVar3.f8423w);
            kVar3.f(true);
        }
        y yVar3 = kVar3.B;
        if (yVar != yVar3) {
            ((ActionMenuView) yVar3).setPresenter(kVar3);
        }
        ActionMenuView actionMenuView = (ActionMenuView) yVar3;
        this.f874w = actionMenuView;
        actionMenuView.setBackground(null);
        addView(this.f874w, layoutParams);
    }

    public final void d() {
        if (this.H == null) {
            LayoutInflater.from(getContext()).inflate(g.abc_action_bar_title_item, this);
            LinearLayout linearLayout = (LinearLayout) getChildAt(getChildCount() - 1);
            this.H = linearLayout;
            this.I = (TextView) linearLayout.findViewById(f.action_bar_title);
            this.J = (TextView) this.H.findViewById(f.action_bar_subtitle);
            int i = this.K;
            if (i != 0) {
                this.I.setTextAppearance(getContext(), i);
            }
            int i10 = this.L;
            if (i10 != 0) {
                this.J.setTextAppearance(getContext(), i10);
            }
        }
        this.I.setText(this.C);
        this.J.setText(this.D);
        boolean zIsEmpty = TextUtils.isEmpty(this.C);
        boolean zIsEmpty2 = TextUtils.isEmpty(this.D);
        this.J.setVisibility(!zIsEmpty2 ? 0 : 8);
        this.H.setVisibility((zIsEmpty && zIsEmpty2) ? 8 : 0);
        if (this.H.getParent() == null) {
            addView(this.H);
        }
    }

    public final void e() {
        removeAllViews();
        this.G = null;
        this.f874w = null;
        this.f875x = null;
        View view = this.F;
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
        return this.f877z != null ? this.f872u.f5332b : getVisibility();
    }

    public int getContentHeight() {
        return this.f876y;
    }

    public CharSequence getSubtitle() {
        return this.D;
    }

    public CharSequence getTitle() {
        return this.C;
    }

    @Override // android.view.View
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final void setVisibility(int i) {
        if (i != getVisibility()) {
            t0 t0Var = this.f877z;
            if (t0Var != null) {
                t0Var.b();
            }
            super.setVisibility(i);
        }
    }

    public final t0 i(int i, long j5) {
        t0 t0Var = this.f877z;
        if (t0Var != null) {
            t0Var.b();
        }
        g9.b bVar = this.f872u;
        if (i != 0) {
            t0 t0VarA = o0.a(this);
            t0VarA.a(0.0f);
            t0VarA.c(j5);
            ((ActionBarContextView) bVar.f5333c).f877z = t0VarA;
            bVar.f5332b = i;
            t0VarA.d(bVar);
            return t0VarA;
        }
        if (getVisibility() != 0) {
            setAlpha(0.0f);
        }
        t0 t0VarA2 = o0.a(this);
        t0VarA2.a(1.0f);
        t0VarA2.c(j5);
        ((ActionBarContextView) bVar.f5333c).f877z = t0VarA2;
        bVar.f5332b = i;
        t0VarA2.d(bVar);
        return t0VarA2;
    }

    @Override // android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        TypedArray typedArrayObtainStyledAttributes = getContext().obtainStyledAttributes(null, j.ActionBar, g.a.actionBarStyle, 0);
        setContentHeight(typedArrayObtainStyledAttributes.getLayoutDimension(j.ActionBar_height, 0));
        typedArrayObtainStyledAttributes.recycle();
        k kVar = this.f875x;
        if (kVar != null) {
            Configuration configuration2 = kVar.f8422v.getResources().getConfiguration();
            int i = configuration2.screenWidthDp;
            int i10 = configuration2.screenHeightDp;
            kVar.K = (configuration2.smallestScreenWidthDp > 600 || i > 600 || (i > 960 && i10 > 720) || (i > 720 && i10 > 960)) ? 5 : (i >= 500 || (i > 640 && i10 > 480) || (i > 480 && i10 > 640)) ? 4 : i >= 360 ? 3 : 2;
            m.k kVar2 = kVar.f8423w;
            if (kVar2 != null) {
                kVar2.p(true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        k kVar = this.f875x;
        if (kVar != null) {
            kVar.d();
            n.f fVar = this.f875x.O;
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
            this.B = false;
        }
        if (!this.B) {
            boolean zOnHoverEvent = super.onHoverEvent(motionEvent);
            if (actionMasked == 9 && !zOnHoverEvent) {
                this.B = true;
            }
        }
        if (actionMasked != 10 && actionMasked != 3) {
            return true;
        }
        this.B = false;
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z2, int i, int i10, int i11, int i12) {
        boolean z10 = u3.f8547a;
        boolean z11 = getLayoutDirection() == 1;
        int paddingRight = z11 ? (i11 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i12 - i10) - getPaddingTop()) - getPaddingBottom();
        View view = this.E;
        if (view != null && view.getVisibility() != 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            int i13 = z11 ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i14 = z11 ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            int i15 = z11 ? paddingRight - i13 : paddingRight + i13;
            int iG = g(i15, paddingTop, paddingTop2, this.E, z11) + i15;
            paddingRight = z11 ? iG - i14 : iG + i14;
        }
        LinearLayout linearLayout = this.H;
        if (linearLayout != null && this.G == null && linearLayout.getVisibility() != 8) {
            paddingRight += g(paddingRight, paddingTop, paddingTop2, this.H, z11);
        }
        View view2 = this.G;
        if (view2 != null) {
            g(paddingRight, paddingTop, paddingTop2, view2, z11);
        }
        int paddingLeft = z11 ? getPaddingLeft() : (i11 - i) - getPaddingRight();
        ActionMenuView actionMenuView = this.f874w;
        if (actionMenuView != null) {
            g(paddingLeft, paddingTop, paddingTop2, actionMenuView, !z11);
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
        int size2 = this.f876y;
        if (size2 <= 0) {
            size2 = View.MeasureSpec.getSize(i10);
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        int iMin = size2 - paddingBottom;
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(iMin, Integer.MIN_VALUE);
        View view = this.E;
        if (view != null) {
            int iF = f(view, paddingLeft, iMakeMeasureSpec);
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.E.getLayoutParams();
            paddingLeft = iF - (marginLayoutParams.leftMargin + marginLayoutParams.rightMargin);
        }
        ActionMenuView actionMenuView = this.f874w;
        if (actionMenuView != null && actionMenuView.getParent() == this) {
            paddingLeft = f(this.f874w, paddingLeft, iMakeMeasureSpec);
        }
        LinearLayout linearLayout = this.H;
        if (linearLayout != null && this.G == null) {
            if (this.M) {
                this.H.measure(View.MeasureSpec.makeMeasureSpec(0, 0), iMakeMeasureSpec);
                int measuredWidth = this.H.getMeasuredWidth();
                boolean z2 = measuredWidth <= paddingLeft;
                if (z2) {
                    paddingLeft -= measuredWidth;
                }
                this.H.setVisibility(z2 ? 0 : 8);
            } else {
                paddingLeft = f(linearLayout, paddingLeft, iMakeMeasureSpec);
            }
        }
        View view2 = this.G;
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
            this.G.measure(View.MeasureSpec.makeMeasureSpec(paddingLeft, i12), View.MeasureSpec.makeMeasureSpec(iMin, i14));
        }
        if (this.f876y > 0) {
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
            this.A = false;
        }
        if (!this.A) {
            boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
            if (actionMasked == 0 && !zOnTouchEvent) {
                this.A = true;
            }
        }
        if (actionMasked != 1 && actionMasked != 3) {
            return true;
        }
        this.A = false;
        return true;
    }

    public void setContentHeight(int i) {
        this.f876y = i;
    }

    public void setCustomView(View view) {
        LinearLayout linearLayout;
        View view2 = this.G;
        if (view2 != null) {
            removeView(view2);
        }
        this.G = view;
        if (view != null && (linearLayout = this.H) != null) {
            removeView(linearLayout);
            this.H = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.D = charSequence;
        d();
    }

    public void setTitle(CharSequence charSequence) {
        this.C = charSequence;
        d();
        o0.o(this, charSequence);
    }

    public void setTitleOptional(boolean z2) {
        if (z2 != this.M) {
            requestLayout();
        }
        this.M = z2;
    }

    @Override // android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return false;
    }
}
