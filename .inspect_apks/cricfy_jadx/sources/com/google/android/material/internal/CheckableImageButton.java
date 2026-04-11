package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.datepicker.j;
import da.b;
import g.a;
import o.v;
import t0.m0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends v implements Checkable {
    public static final int[] B = {R.attr.state_checked};
    public boolean A;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f2921y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f2922z;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.imageButtonStyle);
        this.f2922z = true;
        this.A = true;
        m0.n(this, new j(1, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f2921y;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.f2921y ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), B) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f112v);
        setChecked(bVar.f3566x);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f3566x = this.f2921y;
        return bVar;
    }

    public void setCheckable(boolean z10) {
        if (this.f2922z != z10) {
            this.f2922z = z10;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z10) {
        if (!this.f2922z || this.f2921y == z10) {
            return;
        }
        this.f2921y = z10;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z10) {
        this.A = z10;
    }

    @Override // android.view.View
    public void setPressed(boolean z10) {
        if (this.A) {
            super.setPressed(z10);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f2921y);
    }
}
