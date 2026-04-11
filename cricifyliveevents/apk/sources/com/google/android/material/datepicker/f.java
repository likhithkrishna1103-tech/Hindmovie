package com.google.android.material.datepicker;

import android.view.View;
import androidx.media3.decoder.DecoderInputBuffer;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.Calendar;
import v4.h0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements View.OnClickListener {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f2856v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ v f2857w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final /* synthetic */ m f2858x;

    public /* synthetic */ f(m mVar, v vVar, int i) {
        this.f2856v = i;
        this.f2858x = mVar;
        this.f2857w = vVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f2856v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                m mVar = this.f2858x;
                int iO0 = ((LinearLayoutManager) mVar.f2872z0.getLayoutManager()).O0() - 1;
                Calendar calendarA = z.a(this.f2857w.f2901d.f2843v.f2887v);
                calendarA.add(2, iO0);
                mVar.R(new r(calendarA));
                break;
            default:
                m mVar2 = this.f2858x;
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mVar2.f2872z0.getLayoutManager();
                View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false);
                int iG = viewQ0 == null ? -1 : h0.G(viewQ0);
                Calendar calendarA2 = z.a(this.f2857w.f2901d.f2843v.f2887v);
                calendarA2.add(2, iG + 1);
                mVar2.R(new r(calendarA2));
                break;
        }
    }
}
