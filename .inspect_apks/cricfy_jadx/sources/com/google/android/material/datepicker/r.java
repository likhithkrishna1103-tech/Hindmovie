package com.google.android.material.datepicker;

import android.icu.text.DateFormat;
import android.icu.text.DisplayContext;
import android.icu.util.TimeZone;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.format.DateUtils;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class r implements Comparable, Parcelable {
    public static final Parcelable.Creator<r> CREATOR = new android.support.v4.media.a(13);
    public final long A;
    public String B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Calendar f2887v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f2888w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f2889x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f2890y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f2891z;

    public r(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarA = z.a(calendar);
        this.f2887v = calendarA;
        this.f2888w = calendarA.get(2);
        this.f2889x = calendarA.get(1);
        this.f2890y = calendarA.getMaximum(7);
        this.f2891z = calendarA.getActualMaximum(5);
        this.A = calendarA.getTimeInMillis();
    }

    public static r a(int i, int i10) {
        Calendar calendarC = z.c(null);
        calendarC.set(1, i);
        calendarC.set(2, i10);
        return new r(calendarC);
    }

    public static r b(long j4) {
        Calendar calendarC = z.c(null);
        calendarC.setTimeInMillis(j4);
        return new r(calendarC);
    }

    public final String c() {
        String dateTime;
        if (this.B == null) {
            long timeInMillis = this.f2887v.getTimeInMillis();
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
            this.B = dateTime;
        }
        return this.B;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f2887v.compareTo(((r) obj).f2887v);
    }

    public final int d(r rVar) {
        if (!(this.f2887v instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (rVar.f2888w - this.f2888w) + ((rVar.f2889x - this.f2889x) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f2888w == rVar.f2888w && this.f2889x == rVar.f2889x;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2888w), Integer.valueOf(this.f2889x)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f2889x);
        parcel.writeInt(this.f2888w);
    }
}
