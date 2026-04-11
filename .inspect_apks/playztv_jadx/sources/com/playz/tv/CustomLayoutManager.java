package com.playz.tv;

import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import gc.c;
import ic.k;
import q4.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public class CustomLayoutManager extends GridLayoutManager {
    public CustomLayoutManager(k kVar) {
        super(3);
        this.K = new c(kVar);
    }

    @Override // q4.h0
    public final void Y(View view, int i) {
        try {
            int iG = h0.G(view);
            int iB = B();
            int i10 = this.F + iG;
            if (i != 130 || iG < 0 || i10 >= iB) {
                return;
            }
            r0(i10);
        } catch (Exception e10) {
            e10.printStackTrace();
        }
    }
}
