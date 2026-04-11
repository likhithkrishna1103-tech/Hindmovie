package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class t implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f2897v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ v f2898w;

    public t(v vVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f2898w = vVar;
        this.f2897v = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j4) {
        MaterialCalendarGridView materialCalendarGridView = this.f2897v;
        s sVarA = materialCalendarGridView.a();
        if (i < sVarA.a() || i > sVarA.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i).longValue() >= ((m) this.f2898w.f2902e.f10037w).f2867u0.f2845x.f2851v) {
            throw null;
        }
    }
}
