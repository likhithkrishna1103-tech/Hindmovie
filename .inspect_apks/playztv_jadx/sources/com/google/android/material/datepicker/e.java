package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3395x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Calendar f3396u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f3397v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f3398w;

    static {
        f3395x = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarC = y.c(null);
        this.f3396u = calendarC;
        this.f3397v = calendarC.getMaximum(7);
        this.f3398w = calendarC.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f3397v;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i10 = this.f3397v;
        if (i >= i10) {
            return null;
        }
        int i11 = i + this.f3398w;
        if (i11 > i10) {
            i11 -= i10;
        }
        return Integer.valueOf(i11);
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        TextView textView = (TextView) view;
        if (view == null) {
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(p8.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i10 = i + this.f3398w;
        int i11 = this.f3397v;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f3396u;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, f3395x, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(p8.j.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public e(int i) {
        Calendar calendarC = y.c(null);
        this.f3396u = calendarC;
        this.f3397v = calendarC.getMaximum(7);
        this.f3398w = i;
    }
}
