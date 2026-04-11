package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import q4.t0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h extends LinearLayoutManager {
    public final /* synthetic */ int E;
    public final /* synthetic */ m F;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(m mVar, int i, int i10) {
        super(i);
        this.F = mVar;
        this.E = i10;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager, q4.h0
    public final void B0(RecyclerView recyclerView, int i) {
        w wVar = new w(recyclerView.getContext());
        wVar.f10921a = i;
        C0(wVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void E0(t0 t0Var, int[] iArr) {
        int i = this.E;
        m mVar = this.F;
        if (i == 0) {
            iArr[0] = mVar.f3416y0.getWidth();
            iArr[1] = mVar.f3416y0.getWidth();
        } else {
            iArr[0] = mVar.f3416y0.getHeight();
            iArr[1] = mVar.f3416y0.getHeight();
        }
    }
}
