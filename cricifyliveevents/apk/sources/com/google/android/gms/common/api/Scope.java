package com.google.android.gms.common.api;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import l4.p;
import o8.u;
import p8.a;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class Scope extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Scope> CREATOR = new p(11);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2304v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2305w;

    public Scope(int i, String str) {
        u.e(str, "scopeUri must not be null or empty");
        this.f2304v = i;
        this.f2305w = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Scope)) {
            return false;
        }
        return this.f2305w.equals(((Scope) obj).f2305w);
    }

    public final int hashCode() {
        return this.f2305w.hashCode();
    }

    public final String toString() {
        return this.f2305w;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f2304v);
        t1.r(parcel, 2, this.f2305w);
        t1.y(parcel, iW);
    }
}
