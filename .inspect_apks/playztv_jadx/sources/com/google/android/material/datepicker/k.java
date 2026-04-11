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
import q4.h0;
import q4.k0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class k extends k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u f3405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ MaterialButton f3406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ m f3407c;

    public k(m mVar, u uVar, MaterialButton materialButton) {
        this.f3407c = mVar;
        this.f3405a = uVar;
        this.f3406b = materialButton;
    }

    @Override // q4.k0
    public final void a(RecyclerView recyclerView, int i) {
        if (i == 0) {
            recyclerView.announceForAccessibility(this.f3406b.getText());
        }
    }

    @Override // q4.k0
    public final void b(RecyclerView recyclerView, int i, int i10) {
        int iO0;
        String dateTime;
        b bVar = this.f3405a.f3441d;
        m mVar = this.f3407c;
        if (i < 0) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) mVar.f3416y0.getLayoutManager();
            View viewQ0 = linearLayoutManager.Q0(0, linearLayoutManager.v(), false);
            iO0 = viewQ0 == null ? -1 : h0.G(viewQ0);
        } else {
            iO0 = ((LinearLayoutManager) mVar.f3416y0.getLayoutManager()).O0();
        }
        Calendar calendarA = y.a(bVar.f3386u.f3426u);
        calendarA.add(2, iO0);
        mVar.f3412u0 = new q(calendarA);
        Calendar calendarA2 = y.a(bVar.f3386u.f3426u);
        calendarA2.add(2, iO0);
        calendarA2.set(5, 1);
        Calendar calendarA3 = y.a(calendarA2);
        calendarA3.get(2);
        calendarA3.get(1);
        calendarA3.getMaximum(7);
        calendarA3.getActualMaximum(5);
        calendarA3.getTimeInMillis();
        long timeInMillis = calendarA3.getTimeInMillis();
        if (Build.VERSION.SDK_INT >= 24) {
            Locale locale = Locale.getDefault();
            AtomicReference atomicReference = y.f3445a;
            DateFormat instanceForSkeleton = DateFormat.getInstanceForSkeleton("yMMMM", locale);
            instanceForSkeleton.setTimeZone(TimeZone.getTimeZone("UTC"));
            DisplayContext unused = DisplayContext.CAPITALIZATION_FOR_STANDALONE;
            instanceForSkeleton.setContext(DisplayContext.CAPITALIZATION_FOR_STANDALONE);
            dateTime = instanceForSkeleton.format(new Date(timeInMillis));
        } else {
            dateTime = DateUtils.formatDateTime(null, timeInMillis, 8228);
        }
        this.f3406b.setText(dateTime);
    }
}
