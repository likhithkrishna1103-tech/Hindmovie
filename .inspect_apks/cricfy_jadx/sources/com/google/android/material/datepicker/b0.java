package com.google.android.material.datepicker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.Locale;
import v4.x0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 extends v4.z {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f2848d;

    public b0(m mVar) {
        this.f2848d = mVar;
    }

    @Override // v4.z
    public final int a() {
        return this.f2848d.f2867u0.A;
    }

    @Override // v4.z
    public final void e(x0 x0Var, int i) {
        m mVar = this.f2848d;
        int i10 = mVar.f2867u0.f2843v.f2889x + i;
        TextView textView = ((a0) x0Var).f2842u;
        textView.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(i10)));
        Context context = textView.getContext();
        textView.setContentDescription(z.b().get(1) == i10 ? String.format(context.getString(k9.j.mtrl_picker_navigate_to_current_year_description), Integer.valueOf(i10)) : String.format(context.getString(k9.j.mtrl_picker_navigate_to_year_description), Integer.valueOf(i10)));
        c cVar = mVar.f2870x0;
        if (z.b().get(1) == i10) {
            o8.j jVar = cVar.f2850b;
        } else {
            o8.j jVar2 = cVar.f2849a;
        }
        throw null;
    }

    @Override // v4.z
    public final x0 f(ViewGroup viewGroup, int i) {
        return new a0((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(k9.h.mtrl_calendar_year, viewGroup, false));
    }
}
