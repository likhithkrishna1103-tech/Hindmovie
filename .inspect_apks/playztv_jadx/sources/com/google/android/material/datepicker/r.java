package com.google.android.material.datepicker;

import android.widget.BaseAdapter;
import java.util.Calendar;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class r extends BaseAdapter {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final int f3432x = y.c(null).getMaximum(4);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final int f3433y = (y.c(null).getMaximum(7) + y.c(null).getMaximum(5)) - 1;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q f3434u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public c f3435v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final b f3436w;

    public r(q qVar, b bVar) {
        this.f3434u = qVar;
        this.f3436w = bVar;
        throw null;
    }

    public final int a() {
        int firstDayOfWeek = this.f3436w.f3390y;
        q qVar = this.f3434u;
        Calendar calendar = qVar.f3426u;
        int i = calendar.get(7);
        if (firstDayOfWeek <= 0) {
            firstDayOfWeek = calendar.getFirstDayOfWeek();
        }
        int i10 = i - firstDayOfWeek;
        return i10 < 0 ? i10 + qVar.f3429x : i10;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final Long getItem(int i) {
        if (i < a() || i > c()) {
            return null;
        }
        int iA = (i - a()) + 1;
        Calendar calendarA = y.a(this.f3434u.f3426u);
        calendarA.set(5, iA);
        return Long.valueOf(calendarA.getTimeInMillis());
    }

    public final int c() {
        return (a() + this.f3434u.f3430y) - 1;
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        return f3433y;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i / this.f3434u.f3429x;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005c  */
    @Override // android.widget.Adapter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View getView(int r5, android.view.View r6, android.view.ViewGroup r7) {
        /*
            r4 = this;
            android.content.Context r0 = r7.getContext()
            com.google.android.material.datepicker.c r1 = r4.f3435v
            if (r1 != 0) goto Lf
            com.google.android.material.datepicker.c r1 = new com.google.android.material.datepicker.c
            r1.<init>(r0)
            r4.f3435v = r1
        Lf:
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
            r1 = 0
            if (r6 != 0) goto L26
            android.content.Context r6 = r7.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r0 = p8.h.mtrl_calendar_day
            android.view.View r6 = r6.inflate(r0, r7, r1)
            r0 = r6
            android.widget.TextView r0 = (android.widget.TextView) r0
        L26:
            int r6 = r4.a()
            int r6 = r5 - r6
            if (r6 < 0) goto L5c
            com.google.android.material.datepicker.q r7 = r4.f3434u
            int r2 = r7.f3430y
            if (r6 < r2) goto L35
            goto L5c
        L35:
            r2 = 1
            int r6 = r6 + r2
            r0.setTag(r7)
            android.content.res.Resources r7 = r0.getResources()
            android.content.res.Configuration r7 = r7.getConfiguration()
            java.util.Locale r7 = r7.locale
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object[] r3 = new java.lang.Object[r2]
            r3[r1] = r6
            java.lang.String r6 = "%d"
            java.lang.String r6 = java.lang.String.format(r7, r6, r3)
            r0.setText(r6)
            r0.setVisibility(r1)
            r0.setEnabled(r2)
            goto L64
        L5c:
            r6 = 8
            r0.setVisibility(r6)
            r0.setEnabled(r1)
        L64:
            java.lang.Long r5 = r4.getItem(r5)
            if (r5 != 0) goto L6b
            goto L6d
        L6b:
            if (r0 != 0) goto L6e
        L6d:
            return r0
        L6e:
            r0.getContext()
            java.util.Calendar r5 = com.google.android.material.datepicker.y.b()
            r5.getTimeInMillis()
            r5 = 0
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.datepicker.r.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public final boolean hasStableIds() {
        return true;
    }
}
