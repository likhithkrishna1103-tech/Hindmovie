package com.google.android.material.datepicker;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;
import q4.h0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f3399u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ u f3400v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ m f3401w;

    public /* synthetic */ f(m mVar, u uVar, int i) {
        this.f3399u = i;
        this.f3401w = mVar;
        this.f3400v = uVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f3399u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = this.f3401w;
                int iO0 = ((LinearLayoutManager) mVar.f3416y0.getLayoutManager()).O0() - 1;
                if (iO0 >= 0) {
                    Calendar calendarA = y.a(this.f3400v.f3441d.f3386u.f3426u);
                    calendarA.add(2, iO0);
                    mVar.P(new q(calendarA));
                }
                break;
            default:
                m mVar2 = this.f3401w;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mVar2.f3416y0.getLayoutManager();
                View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false);
                int iG = (viewQ0 == null ? -1 : h0.G(viewQ0)) + 1;
                if (iG < mVar2.f3416y0.getAdapter().a()) {
                    Calendar calendarA2 = y.a(this.f3400v.f3441d.f3386u.f3426u);
                    calendarA2.add(2, iG);
                    mVar2.P(new q(calendarA2));
                }
                break;
        }
    }
}
