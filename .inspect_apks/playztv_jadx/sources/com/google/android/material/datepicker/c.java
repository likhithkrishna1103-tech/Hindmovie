package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final t7.j f3392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final t7.j f3393b;

    public c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(z7.a.B(p8.b.materialCalendarStyle, context, m.class.getCanonicalName()).data, p8.l.MaterialCalendar);
        t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_dayStyle, 0));
        t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_dayInvalidStyle, 0));
        t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_daySelectedStyle, 0));
        t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListI = a.a.i(context, typedArrayObtainStyledAttributes, p8.l.MaterialCalendar_rangeFillColor);
        this.f3392a = t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_yearStyle, 0));
        t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_yearSelectedStyle, 0));
        this.f3393b = t7.j.p(context, typedArrayObtainStyledAttributes.getResourceId(p8.l.MaterialCalendar_yearTodayStyle, 0));
        new Paint().setColor(colorStateListI.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
