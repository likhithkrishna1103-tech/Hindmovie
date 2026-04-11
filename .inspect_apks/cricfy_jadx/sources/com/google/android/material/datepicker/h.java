package com.google.android.material.datepicker;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import v4.t0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
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

    @Override // androidx.recyclerview.widget.LinearLayoutManager, v4.h0
    public final void B0(RecyclerView recyclerView, int i) {
        x xVar = new x(recyclerView.getContext());
        xVar.f13346a = i;
        C0(xVar);
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void E0(t0 t0Var, int[] iArr) {
        int i = this.E;
        m mVar = this.F;
        if (i == 0) {
            iArr[0] = mVar.f2872z0.getWidth();
            iArr[1] = mVar.f2872z0.getWidth();
        } else {
            iArr[0] = mVar.f2872z0.getHeight();
            iArr[1] = mVar.f2872z0.getHeight();
        }
    }
}
