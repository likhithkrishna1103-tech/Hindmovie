package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import n.b;
import n.c;
import n.j;
import n.k;
import n.m;
import n.x;
import o.a1;
import o.l;
import w4.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends a1 implements x, View.OnClickListener, l {
    public m C;
    public CharSequence D;
    public Drawable E;
    public j F;
    public b G;
    public c H;
    public boolean I;
    public boolean J;
    public final int K;
    public int L;
    public final int M;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.I = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.ActionMenuItemView, 0, 0);
        this.K = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.M = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.L = -1;
        setSaveEnabled(false);
    }

    @Override // n.x
    public final void a(m mVar) {
        this.C = mVar;
        setIcon(mVar.getIcon());
        setTitle(mVar.getTitleCondensed());
        setId(mVar.f8544a);
        setVisibility(mVar.isVisible() ? 0 : 8);
        setEnabled(mVar.isEnabled());
        if (mVar.hasSubMenu() && this.G == null) {
            this.G = new b(this);
        }
    }

    @Override // o.l
    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // o.l
    public final boolean c() {
        return !TextUtils.isEmpty(getText()) && this.C.getIcon() == null;
    }

    public final boolean g() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        int i10 = configuration.screenHeightDp;
        if (i < 480) {
            return (i >= 640 && i10 >= 480) || configuration.orientation == 2;
        }
        return true;
    }

    @Override // android.widget.TextView, android.view.View
    public CharSequence getAccessibilityClassName() {
        return Button.class.getName();
    }

    @Override // n.x
    public m getItemData() {
        return this.C;
    }

    public final void h() {
        boolean z10 = true;
        boolean z11 = !TextUtils.isEmpty(this.D);
        if (this.E != null && ((this.C.f8566y & 4) != 4 || (!this.I && !this.J))) {
            z10 = false;
        }
        boolean z12 = z11 & z10;
        setText(z12 ? this.D : null);
        CharSequence charSequence = this.C.f8558q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z12 ? null : this.C.f8548e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.C.f8559r;
        if (TextUtils.isEmpty(charSequence2)) {
            v.t(this, z12 ? null : this.C.f8548e);
        } else {
            v.t(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.F;
        if (jVar != null) {
            jVar.c(this.C);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.I = g();
        h();
    }

    @Override // o.a1, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i11 = this.L) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i10);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i12 = this.K;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i12) : i12;
        if (mode != 1073741824 && i12 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i10);
        }
        if (!zIsEmpty || this.E == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.E.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.C.hasSubMenu() && (bVar = this.G) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z10) {
        if (this.J != z10) {
            this.J = z10;
            m mVar = this.C;
            if (mVar != null) {
                k kVar = mVar.f8555n;
                kVar.f8527k = true;
                kVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.E = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.M;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (intrinsicHeight * (i / intrinsicWidth));
                intrinsicWidth = i;
            }
            if (intrinsicHeight > i) {
                intrinsicWidth = (int) (intrinsicWidth * (i / intrinsicHeight));
            } else {
                i = intrinsicHeight;
            }
            drawable.setBounds(0, 0, intrinsicWidth, i);
        }
        setCompoundDrawables(drawable, null, null, null);
        h();
    }

    public void setItemInvoker(j jVar) {
        this.F = jVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
        this.L = i;
        super.setPadding(i, i10, i11, i12);
    }

    public void setPopupCallback(c cVar) {
        this.H = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.D = charSequence;
        h();
    }

    public void setCheckable(boolean z10) {
    }

    public void setChecked(boolean z10) {
    }
}
