package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o8.j f2849a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o8.j f2850b;

    public c(Context context) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(android.support.v4.media.session.b.I(k9.b.materialCalendarStyle, context, m.class.getCanonicalName()).data, k9.l.MaterialCalendar);
        o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_dayStyle, 0));
        o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_dayInvalidStyle, 0));
        o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_daySelectedStyle, 0));
        o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_dayTodayStyle, 0));
        ColorStateList colorStateListI = com.bumptech.glide.c.i(context, typedArrayObtainStyledAttributes, k9.l.MaterialCalendar_rangeFillColor);
        this.f2849a = o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_yearStyle, 0));
        o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_yearSelectedStyle, 0));
        this.f2850b = o8.j.h(context, typedArrayObtainStyledAttributes.getResourceId(k9.l.MaterialCalendar_yearTodayStyle, 0));
        new Paint().setColor(colorStateListI.getDefaultColor());
        typedArrayObtainStyledAttributes.recycle();
    }
}
