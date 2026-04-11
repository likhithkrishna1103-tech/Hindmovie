package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import q4.x0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a0 extends q4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f3385d;

    public a0(m mVar) {
        this.f3385d = mVar;
    }

    @Override // q4.z
    public final int a() {
        return this.f3385d.f3411t0.f3391z;
    }

    @Override // q4.z
    public final void d(x0 x0Var, int i) {
        m mVar = this.f3385d;
        int i10 = mVar.f3411t0.f3386u.f3428w + i;
        TextView textView = ((z) x0Var).f3446u;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i10)));
        Context context = textView.getContext();
        textView.setContentDescription(y.b().get(1) == i10 ? String.format(context.getString(p8.j.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i10)) : String.format(context.getString(p8.j.mtrl_picker_navigate_to_year_description), Integer.valueOf(i10)));
        c cVar = mVar.f3414w0;
        if (y.b().get(1) == i10) {
            t7.j jVar = cVar.f3393b;
        } else {
            t7.j jVar2 = cVar.f3392a;
        }
        throw null;
    }

    @Override // q4.z
    public final x0 e(ViewGroup viewGroup, int i) {
        return new z((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(p8.h.mtrl_calendar_year, viewGroup, false));
    }
}
