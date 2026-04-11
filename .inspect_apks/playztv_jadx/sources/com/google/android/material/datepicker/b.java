package com.google.android.material.datepicker;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable {
    public static final Parcelable.Creator<b> CREATOR = new a9.b(11);
    public final int A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final q f3386u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final q f3387v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final d f3388w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final q f3389x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final int f3390y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final int f3391z;

    public b(q qVar, q qVar2, d dVar, q qVar3, int i) {
        Objects.requireNonNull(qVar, "start cannot be null");
        Objects.requireNonNull(qVar2, "end cannot be null");
        Objects.requireNonNull(dVar, "validator cannot be null");
        this.f3386u = qVar;
        this.f3387v = qVar2;
        this.f3389x = qVar3;
        this.f3390y = i;
        this.f3388w = dVar;
        if (qVar3 != null && qVar.f3426u.compareTo(qVar3.f3426u) > 0) {
            throw new IllegalArgumentException("start Month cannot be after current Month");
        }
        if (qVar3 != null && qVar3.f3426u.compareTo(qVar2.f3426u) > 0) {
            throw new IllegalArgumentException("current Month cannot be after end Month");
        }
        if (i < 0 || i > y.c(null).getMaximum(7)) {
            throw new IllegalArgumentException("firstDayOfWeek is not valid");
        }
        this.A = qVar.d(qVar2) + 1;
        this.f3391z = (qVar2.f3428w - qVar.f3428w) + 1;
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
        return this.f3386u.equals(bVar.f3386u) && this.f3387v.equals(bVar.f3387v) && Objects.equals(this.f3389x, bVar.f3389x) && this.f3390y == bVar.f3390y && this.f3388w.equals(bVar.f3388w);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.f3386u, this.f3387v, this.f3389x, Integer.valueOf(this.f3390y), this.f3388w});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f3386u, 0);
        parcel.writeParcelable(this.f3387v, 0);
        parcel.writeParcelable(this.f3389x, 0);
        parcel.writeParcelable(this.f3388w, 0);
        parcel.writeInt(this.f3390y);
    }
}
