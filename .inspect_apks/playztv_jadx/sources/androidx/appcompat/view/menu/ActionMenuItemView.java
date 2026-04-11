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
import m.b;
import m.c;
import m.j;
import m.k;
import m.m;
import m.x;
import n.d1;
import n.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class ActionMenuItemView extends d1 implements x, View.OnClickListener, l {
    public m B;
    public CharSequence C;
    public Drawable D;
    public j E;
    public b F;
    public c G;
    public boolean H;
    public boolean I;
    public final int J;
    public int K;
    public final int L;

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        Resources resources = context.getResources();
        this.H = g();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, g.j.ActionMenuItemView, 0, 0);
        this.J = typedArrayObtainStyledAttributes.getDimensionPixelSize(g.j.ActionMenuItemView_android_minWidth, 0);
        typedArrayObtainStyledAttributes.recycle();
        this.L = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.K = -1;
        setSaveEnabled(false);
    }

    @Override // m.x
    public final void a(m mVar) {
        this.B = mVar;
        setIcon(mVar.getIcon());
        setTitle(mVar.getTitleCondensed());
        setId(mVar.f8230a);
        setVisibility(mVar.isVisible() ? 0 : 8);
        setEnabled(mVar.isEnabled());
        if (mVar.hasSubMenu() && this.F == null) {
            this.F = new b(this);
        }
    }

    @Override // n.l
    public final boolean b() {
        return !TextUtils.isEmpty(getText());
    }

    @Override // n.l
    public final boolean c() {
        return !TextUtils.isEmpty(getText()) && this.B.getIcon() == null;
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

    @Override // m.x
    public m getItemData() {
        return this.B;
    }

    public final void h() {
        boolean z2 = true;
        boolean z10 = !TextUtils.isEmpty(this.C);
        if (this.D != null && ((this.B.f8252y & 4) != 4 || (!this.H && !this.I))) {
            z2 = false;
        }
        boolean z11 = z10 & z2;
        setText(z11 ? this.C : null);
        CharSequence charSequence = this.B.f8244q;
        if (TextUtils.isEmpty(charSequence)) {
            setContentDescription(z11 ? null : this.B.f8234e);
        } else {
            setContentDescription(charSequence);
        }
        CharSequence charSequence2 = this.B.f8245r;
        if (TextUtils.isEmpty(charSequence2)) {
            q1.c.N(this, z11 ? null : this.B.f8234e);
        } else {
            q1.c.N(this, charSequence2);
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        j jVar = this.E;
        if (jVar != null) {
            jVar.c(this.B);
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.H = g();
        h();
    }

    @Override // n.d1, android.widget.TextView, android.view.View
    public final void onMeasure(int i, int i10) {
        int i11;
        boolean zIsEmpty = TextUtils.isEmpty(getText());
        if (!zIsEmpty && (i11 = this.K) >= 0) {
            super.setPadding(i11, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i10);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int i12 = this.J;
        int iMin = mode == Integer.MIN_VALUE ? Math.min(size, i12) : i12;
        if (mode != 1073741824 && i12 > 0 && measuredWidth < iMin) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(iMin, 1073741824), i10);
        }
        if (!zIsEmpty || this.D == null) {
            return;
        }
        super.setPadding((getMeasuredWidth() - this.D.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
    }

    @Override // android.widget.TextView, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState(null);
    }

    @Override // android.widget.TextView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        b bVar;
        if (this.B.hasSubMenu() && (bVar = this.F) != null && bVar.onTouch(this, motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setExpandedFormat(boolean z2) {
        if (this.I != z2) {
            this.I = z2;
            m mVar = this.B;
            if (mVar != null) {
                k kVar = mVar.f8241n;
                kVar.f8213k = true;
                kVar.p(true);
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.D = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.L;
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
        this.E = jVar;
    }

    @Override // android.widget.TextView, android.view.View
    public final void setPadding(int i, int i10, int i11, int i12) {
        this.K = i;
        super.setPadding(i, i10, i11, i12);
    }

    public void setPopupCallback(c cVar) {
        this.G = cVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.C = charSequence;
        h();
    }

    public void setCheckable(boolean z2) {
    }

    public void setChecked(boolean z2) {
    }
}
