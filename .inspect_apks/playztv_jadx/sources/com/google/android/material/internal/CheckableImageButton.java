package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Checkable;
import com.google.android.material.datepicker.j;
import g.a;
import j9.b;
import n.x;
import q0.o0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class CheckableImageButton extends x implements Checkable {
    public static final int[] A = {R.attr.state_checked};

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public boolean f3458x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f3459y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3460z;

    public CheckableImageButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, a.imageButtonStyle);
        this.f3459y = true;
        this.f3460z = true;
        o0.n(this, new j(1, this));
    }

    @Override // android.widget.Checkable
    public final boolean isChecked() {
        return this.f3458x;
    }

    @Override // android.widget.ImageView, android.view.View
    public final int[] onCreateDrawableState(int i) {
        return this.f3458x ? View.mergeDrawableStates(super.onCreateDrawableState(i + 1), A) : super.onCreateDrawableState(i);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof b)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        b bVar = (b) parcelable;
        super.onRestoreInstanceState(bVar.f14205u);
        setChecked(bVar.f6842w);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        b bVar = new b(super.onSaveInstanceState());
        bVar.f6842w = this.f3458x;
        return bVar;
    }

    public void setCheckable(boolean z2) {
        if (this.f3459y != z2) {
            this.f3459y = z2;
            sendAccessibilityEvent(0);
        }
    }

    @Override // android.widget.Checkable
    public void setChecked(boolean z2) {
        if (!this.f3459y || this.f3458x == z2) {
            return;
        }
        this.f3458x = z2;
        refreshDrawableState();
        sendAccessibilityEvent(2048);
    }

    public void setPressable(boolean z2) {
        this.f3460z = z2;
    }

    @Override // android.view.View
    public void setPressed(boolean z2) {
        if (this.f3460z) {
            super.setPressed(z2);
        }
    }

    @Override // android.widget.Checkable
    public final void toggle() {
        setChecked(!this.f3458x);
    }
}
