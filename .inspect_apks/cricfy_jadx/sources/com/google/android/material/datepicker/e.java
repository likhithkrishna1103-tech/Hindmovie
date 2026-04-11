package com.google.android.material.datepicker;

import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.Calendar;
import java.util.Locale;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class e extends BaseAdapter {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f2852y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Calendar f2853v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f2854w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f2855x;

    static {
        f2852y = Build.VERSION.SDK_INT >= 26 ? 4 : 1;
    }

    public e() {
        Calendar calendarC = z.c(null);
        this.f2853v = calendarC;
        this.f2854w = calendarC.getMaximum(7);
        this.f2855x = calendarC.getFirstDayOfWeek();
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return this.f2854w;
    }

    @Override // android.widget.Adapter
    public final Object getItem(int i) {
        int i10 = this.f2854w;
        if (i >= i10) {
            return null;
        }
        int i11 = i + this.f2855x;
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
            textView = (TextView) LayoutInflater.from(viewGroup.getContext()).inflate(k9.h.mtrl_calendar_day_of_week, viewGroup, false);
        }
        int i10 = i + this.f2855x;
        int i11 = this.f2854w;
        if (i10 > i11) {
            i10 -= i11;
        }
        Calendar calendar = this.f2853v;
        calendar.set(7, i10);
        textView.setText(calendar.getDisplayName(7, f2852y, textView.getResources().getConfiguration().locale));
        textView.setContentDescription(String.format(viewGroup.getContext().getString(k9.j.mtrl_picker_day_of_week_column_header), calendar.getDisplayName(7, 2, Locale.getDefault())));
        return textView;
    }

    public e(int i) {
        Calendar calendarC = z.c(null);
        this.f2853v = calendarC;
        this.f2854w = calendarC.getMaximum(7);
        this.f2855x = i;
    }
}
