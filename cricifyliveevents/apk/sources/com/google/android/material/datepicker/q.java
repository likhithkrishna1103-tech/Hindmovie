package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class q<S> extends w {

    /* JADX INFO: renamed from: t0, reason: collision with root package name */
    public int f2885t0;

    /* JADX INFO: renamed from: u0, reason: collision with root package name */
    public b f2886u0;

    @Override // androidx.fragment.app.y
    public final void D(Bundle bundle) {
        bundle.putInt("THEME_RES_ID_KEY", this.f2885t0);
        bundle.putParcelable("DATE_SELECTOR_KEY", null);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f2886u0);
    }

    @Override // androidx.fragment.app.y
    public final void w(Bundle bundle) {
        super.w(bundle);
        if (bundle == null) {
            bundle = this.B;
        }
        this.f2885t0 = bundle.getInt("THEME_RES_ID_KEY");
        if (bundle.getParcelable("DATE_SELECTOR_KEY") != null) {
            throw new ClassCastException();
        }
        this.f2886u0 = (b) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.app.y
    public final View x(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(j(), this.f2885t0));
        throw null;
    }
}
