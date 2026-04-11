package com.google.android.material.snackbar;

import android.content.Context;
import android.text.Layout;
import android.util.AttributeSet;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import b8.h;
import java.util.WeakHashMap;
import p8.b;
import p8.d;
import p8.f;
import q0.o0;
import q8.a;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class SnackbarContentLayout extends LinearLayout {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public TextView f3472u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Button f3473v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public int f3474w;

    public SnackbarContentLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.y(context, b.motionEasingEmphasizedInterpolator, a.f11073b);
    }

    public final boolean a(int i, int i10, int i11) {
        boolean z2;
        if (i != getOrientation()) {
            setOrientation(i);
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f3472u.getPaddingTop() == i10 && this.f3472u.getPaddingBottom() == i11) {
            return z2;
        }
        TextView textView = this.f3472u;
        WeakHashMap weakHashMap = o0.f10475a;
        if (textView.isPaddingRelative()) {
            textView.setPaddingRelative(textView.getPaddingStart(), i10, textView.getPaddingEnd(), i11);
            return true;
        }
        textView.setPadding(textView.getPaddingLeft(), i10, textView.getPaddingRight(), i11);
        return true;
    }

    public Button getActionView() {
        return this.f3473v;
    }

    public TextView getMessageView() {
        return this.f3472u;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        this.f3472u = (TextView) findViewById(f.snackbar_text);
        this.f3473v = (Button) findViewById(f.snackbar_action);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i, int i10) {
        super.onMeasure(i, i10);
        if (getOrientation() == 1) {
            return;
        }
        int dimensionPixelSize = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical_2lines);
        int dimensionPixelSize2 = getResources().getDimensionPixelSize(d.design_snackbar_padding_vertical);
        Layout layout = this.f3472u.getLayout();
        boolean z2 = layout != null && layout.getLineCount() > 1;
        if (!z2 || this.f3474w <= 0 || this.f3473v.getMeasuredWidth() <= this.f3474w) {
            if (!z2) {
                dimensionPixelSize = dimensionPixelSize2;
            }
            if (!a(0, dimensionPixelSize, dimensionPixelSize)) {
                return;
            }
        } else if (!a(1, dimensionPixelSize, dimensionPixelSize - dimensionPixelSize2)) {
            return;
        }
        super.onMeasure(i, i10);
    }

    public void setMaxInlineActionWidth(int i) {
        this.f3474w = i;
    }
}
