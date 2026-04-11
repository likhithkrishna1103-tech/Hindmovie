package com.google.android.gms.internal.measurement;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class v0 extends p8.a {
    public static final Parcelable.Creator<v0> CREATOR = new u0(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2658v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2659w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Intent f2660x;

    public v0(int i, String str, Intent intent) {
        this.f2658v = i;
        this.f2659w = str;
        this.f2660x = intent;
    }

    public static v0 a(Activity activity) {
        return new v0(activity.hashCode(), activity.getClass().getCanonicalName(), activity.getIntent());
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v0)) {
            return false;
        }
        v0 v0Var = (v0) obj;
        return this.f2658v == v0Var.f2658v && Objects.equals(this.f2659w, v0Var.f2659w) && Objects.equals(this.f2660x, v0Var.f2660x);
    }

    public final int hashCode() {
        return this.f2658v;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = qb.t1.w(parcel, 20293);
        qb.t1.v(parcel, 1, 4);
        parcel.writeInt(this.f2658v);
        qb.t1.r(parcel, 2, this.f2659w);
        qb.t1.q(parcel, 3, this.f2660x, i);
        qb.t1.y(parcel, iW);
    }
}
