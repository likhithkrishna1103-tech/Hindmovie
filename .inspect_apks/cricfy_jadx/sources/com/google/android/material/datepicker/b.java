package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new android.support.v4.media.a(11);
    public final int A;
    public final int B;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final r f2843v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final r f2844w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d f2845x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final r f2846y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f2847z;

    public b(r rVar, r rVar2, d dVar, r rVar3, int i) {
        Objects.requireNonNull(rVar, "start cannot be null");
        Objects.requireNonNull(rVar2, "end cannot be null");
        Objects.requireNonNull(dVar, "validator cannot be null");
        this.f2843v = rVar;
        this.f2844w = rVar2;
        this.f2846y = rVar3;
        this.f2847z = i;
        this.f2845x = dVar;
        if (rVar3 != null && rVar.f2887v.compareTo(rVar3.f2887v) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (rVar3 != null && rVar3.f2887v.compareTo(rVar2.f2887v) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > z.c(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.B = rVar.d(rVar2) + 1;
        this.A = (rVar2.f2889x - rVar.f2889x) + 1;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f2843v.equals(bVar.f2843v) && this.f2844w.equals(bVar.f2844w) && Objects.equals(this.f2846y, bVar.f2846y) && this.f2847z == bVar.f2847z && this.f2845x.equals(bVar.f2845x);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f2843v, this.f2844w, this.f2846y, Integer.valueOf(this.f2847z), this.f2845x});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f2843v, 0);
        parcel.writeParcelable(this.f2844w, 0);
        parcel.writeParcelable(this.f2846y, 0);
        parcel.writeParcelable(this.f2845x, 0);
        parcel.writeInt(this.f2847z);
    }
}
