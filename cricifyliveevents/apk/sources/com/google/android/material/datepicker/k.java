package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.text.format.DateUtils;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.button.MaterialButton;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import v4.h0;
import v4.k0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ v f2862a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ m f2863b;

    public k(m mVar, v vVar) {
        this.f2863b = mVar;
        this.f2862a = vVar;
    }

    @Override // v4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        int iO0;
        String dateTime;
        b bVar = this.f2862a.f2901d;
        m mVar = this.f2863b;
        if (i < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mVar.f2872z0.getLayoutManager();
            View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false);
            iO0 = viewQ0 == null ? -1 : h0.G(viewQ0);
        } else {
            iO0 = ((LinearLayoutManager) mVar.f2872z0.getLayoutManager()).O0();
        }
        Calendar calendarA = z.a(bVar.f2843v.f2887v);
        calendarA.add(2, iO0);
        r rVar = new r(calendarA);
        mVar.f2868v0 = rVar;
        MaterialButton materialButton = mVar.E0;
        Calendar calendarA2 = z.a(bVar.f2843v.f2887v);
        calendarA2.add(2, iO0);
        calendarA2.set(5, 1);
        Calendar calendarA3 = z.a(calendarA2);
        calendarA3.get(2);
        calendarA3.get(1);
        calendarA3.getMaximum(7);
        calendarA3.getActualMaximum(5);
        calendarA3.getTimeInMillis();
        long timeInMillis = calendarA3.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = z.f2905a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            DisplayContext unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            dateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            dateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        materialButton.setText(dateTime);
        mVar.T(bVar.f2843v.d(rVar));
    }
}
