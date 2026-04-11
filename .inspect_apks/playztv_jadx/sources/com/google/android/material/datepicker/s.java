package com.google.android.material.datepicker;

import android.view.View;
import android.widget.AdapterView;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class s implements AdapterView.OnItemClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ MaterialCalendarGridView f3437u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f3438v;

    public s(u uVar, MaterialCalendarGridView materialCalendarGridView) {
        this.f3438v = uVar;
        this.f3437u = materialCalendarGridView;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j5) {
        MaterialCalendarGridView materialCalendarGridView = this.f3437u;
        r rVarA = materialCalendarGridView.a();
        if (i < rVarA.a() || i > rVarA.c()) {
            return;
        }
        if (materialCalendarGridView.a().getItem(i).longValue() >= ((m) this.f3438v.f3442e.f12782v).f3411t0.f3388w.f3394u) {
            throw null;
        }
    }
}
