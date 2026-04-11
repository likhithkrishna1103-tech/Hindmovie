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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q implements Comparable, Parcelable {
    public static final Parcelable.Creator<q> CREATOR = new a9.b(13);
    public String A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Calendar f3426u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f3427v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f3428w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f3429x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3430y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f3431z;

    public q(Calendar calendar) {
        calendar.set(5, 1);
        Calendar calendarA = y.a(calendar);
        this.f3426u = calendarA;
        this.f3427v = calendarA.get(2);
        this.f3428w = calendarA.get(1);
        this.f3429x = calendarA.getMaximum(7);
        this.f3430y = calendarA.getActualMaximum(5);
        this.f3431z = calendarA.getTimeInMillis();
    }

    public static q a(int i, int i10) {
        Calendar calendarC = y.c(null);
        calendarC.set(1, i);
        calendarC.set(2, i10);
        return new q(calendarC);
    }

    public static q b(long j5) {
        Calendar calendarC = y.c(null);
        calendarC.setTimeInMillis(j5);
        return new q(calendarC);
    }

    public final String c() {
        String dateTime;
        if (this.A == null) {
            long timeInMillis = this.f3426u.getTimeInMillis();
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
            this.A = dateTime;
        }
        return this.A;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.f3426u.compareTo(((q) obj).f3426u);
    }

    public final int d(q qVar) {
        if (!(this.f3426u instanceof GregorianCalendar)) {
            throw new IllegalArgumentException("Only Gregorian calendars are supported.");
        }
        return (qVar.f3427v - this.f3427v) + ((qVar.f3428w - this.f3428w) * 12);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f3427v == qVar.f3427v && this.f3428w == qVar.f3428w;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f3427v), Integer.valueOf(this.f3428w)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f3428w);
        parcel.writeInt(this.f3427v);
    }
}
