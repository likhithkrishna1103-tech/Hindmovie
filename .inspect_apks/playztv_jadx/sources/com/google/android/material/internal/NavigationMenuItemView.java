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
import g.a;
import h0.k;
import j9.f;
import java.util.WeakHashMap;
import m.m;
import m.x;
import n.x1;
import p8.d;
import p8.e;
import p8.h;
import q0.o0;
import q1.c;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class NavigationMenuItemView extends f implements x {

    /* JADX INFO: renamed from: d0, reason: collision with root package name */
    public static final int[] f3461d0 = {R.attr.state_checked};
    public int P;
    public boolean Q;
    public boolean R;
    public boolean S;
    public final CheckedTextView T;
    public FrameLayout U;
    public m V;
    public ColorStateList W;

    /* JADX INFO: renamed from: a0, reason: collision with root package name */
    public boolean f3462a0;

    /* JADX INFO: renamed from: b0, reason: collision with root package name */
    public Drawable f3463b0;

    /* JADX INFO: renamed from: c0, reason: collision with root package name */
    public final j f3464c0;

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.S = true;
        j jVar = new j(2, this);
        this.f3464c0 = jVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(h.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(d.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(p8.f.design_menu_item_text);
        this.T = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        o0.n(checkedTextView, jVar);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.U == null) {
                this.U = (FrameLayout) ((ViewStub) findViewById(p8.f.design_menu_item_action_area_stub)).inflate();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            this.U.removeAllViews();
            this.U.addView(view);
        }
    }

    @Override // m.x
    public final void a(m mVar) {
        StateListDrawable stateListDrawable;
        this.V = mVar;
        int i = mVar.f8230a;
        if (i > 0) {
            setId(i);
        }
        setVisibility(mVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(a.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(f3461d0, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = o0.f10475a;
            setBackground(stateListDrawable);
        }
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setTitle(mVar.f8234e);
        setIcon(mVar.getIcon());
        setActionView(mVar.getActionView());
        setContentDescription(mVar.f8244q);
        c.N(this, mVar.f8245r);
        m mVar2 = this.V;
        CharSequence charSequence = mVar2.f8234e;
        CheckedTextView checkedTextView = this.T;
        if (charSequence == null && mVar2.getIcon() == null && this.V.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.U;
            if (frameLayout != null) {
                x1 x1Var = (x1) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) x1Var).width = -1;
                this.U.setLayoutParams(x1Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.U;
        if (frameLayout2 != null) {
            x1 x1Var2 = (x1) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) x1Var2).width = -2;
            this.U.setLayoutParams(x1Var2);
        }
    }

    @Override // m.x
    public m getItemData() {
        return this.V;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i) {
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + 1);
        m mVar = this.V;
        if (mVar != null && mVar.isCheckable() && this.V.isChecked()) {
            View.mergeDrawableStates(iArrOnCreateDrawableState, f3461d0);
        }
        return iArrOnCreateDrawableState;
    }

    public void setCheckable(boolean z2) {
        refreshDrawableState();
        if (this.R != z2) {
            this.R = z2;
            this.f3464c0.h(this.T, 2048);
        }
    }

    public void setChecked(boolean z2) {
        refreshDrawableState();
        CheckedTextView checkedTextView = this.T;
        checkedTextView.setChecked(z2);
        checkedTextView.setTypeface(checkedTextView.getTypeface(), (z2 && this.S) ? 1 : 0);
    }

    public void setHorizontalPadding(int i) {
        setPadding(i, getPaddingTop(), i, getPaddingBottom());
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.f3462a0) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                drawable.setTintList(this.W);
            }
            int i = this.P;
            drawable.setBounds(0, 0, i, i);
        } else if (this.Q) {
            if (this.f3463b0 == null) {
                Resources resources = getResources();
                int i10 = e.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = k.f5599a;
                Drawable drawable2 = resources.getDrawable(i10, theme);
                this.f3463b0 = drawable2;
                if (drawable2 != null) {
                    int i11 = this.P;
                    drawable2.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.f3463b0;
        }
        this.T.setCompoundDrawablesRelative(drawable, null, null, null);
    }

    public void setIconPadding(int i) {
        this.T.setCompoundDrawablePadding(i);
    }

    public void setIconSize(int i) {
        this.P = i;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.W = colorStateList;
        this.f3462a0 = colorStateList != null;
        m mVar = this.V;
        if (mVar != null) {
            setIcon(mVar.getIcon());
        }
    }

    public void setMaxLines(int i) {
        this.T.setMaxLines(i);
    }

    public void setNeedsEmptyIcon(boolean z2) {
        this.Q = z2;
    }

    public void setTextAppearance(int i) {
        this.T.setTextAppearance(i);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.T.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.T.setText(charSequence);
    }
}
