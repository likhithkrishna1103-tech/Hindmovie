package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.material.datepicker.j;
import da.f;
import g.a;
import k0.k;
import k9.d;
import k9.e;
import k9.h;
import n.m;
import n.x;
import o.x1;
import t0.m0;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends f implements x {

    /* JADX INFO: renamed from: e0, reason: collision with root package name */
    public static final int[] f2924e0 = {R.attr.state_checked};
    public int Q;
    public boolean R;
    public boolean S;
    public boolean T;
    public final CheckedTextView U;
    public FrameLayout V;
    public m W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public ColorStateList f2925a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public boolean f2926b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public Drawable f2927c0;

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public final j f2928d0;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.T = true;
        j jVar = new j(2, this);
        this.f2928d0 = jVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(k9.f.design_menu_item_text);
        this.U = checkedTextView;
        m0.n(checkedTextView, jVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.V == null) {
                this.V = (FrameLayout) ((ViewStub) findViewById(k9.f.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.V.removeAllViews();
            this.V.addView(view);
        }
    }

    @Override // n.x
    public final void a(m mVar) {
        StateListDrawable stateListDrawable;
        this.W = mVar;
        int i = mVar.f8544a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(mVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(a.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f2924e0, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            setBackground(stateListDrawable);
        }
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setTitle(mVar.f8548e);
        setIcon(mVar.getIcon());
        setActionView(mVar.getActionView());
        setContentDescription(mVar.f8558q);
        v.t(this, mVar.f8559r);
        m mVar2 = this.W;
        CharSequence charSequence = mVar2.f8548e;
        CheckedTextView checkedTextView = this.U;
        if (charSequence == null && mVar2.getIcon() == null && this.W.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.V;
            if (frameLayout != null) {
                x1 x1Var = (x1) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) x1Var).width = -1;
                this.V.setLayoutParams(x1Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.V;
        if (frameLayout2 != null) {
            x1 x1Var2 = (x1) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) x1Var2).width = -2;
            this.V.setLayoutParams(x1Var2);
        }
    }

    @Override // n.x
    public m getItemData() {
        return this.W;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        m mVar = this.W;
        if (mVar != null && mVar.isCheckable() && this.W.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f2924e0);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z10) {
        refreshDrawableState();
        if (this.S != z10) {
            this.S = z10;
            this.f2928d0.h(this.U, 2048);
        }
    }

    public void setChecked(boolean z10) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.U;
        checkedTextView.setChecked(z10);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z10 && this.T) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f2926b0) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.f2925a0);
            }
            int i = this.Q;
            drawable.setBounds(0, 0, i, i);
        } else if (this.R) {
            if (this.f2927c0 == null) {
                Resources resources = getResources();
                int i10 = e.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = k.f6774a;
                Drawable drawable2 = resources.getDrawable(i10, theme);
                this.f2927c0 = drawable2;
                if (drawable2 != null) {
                    int i11 = this.Q;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f2927c0;
        }
        this.U.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.U.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.Q = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.f2925a0 = colorStateList;
        this.f2926b0 = colorStateList != null;
        m mVar = this.W;
        if (mVar != null) {
            setIcon(mVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.U.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z10) {
        this.R = z10;
    }

    public void setTextAppearance(int i) {
        this.U.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.U.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.U.setText(charSequence);
    }
}
