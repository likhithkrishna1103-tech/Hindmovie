package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.common.internal.ReflectedParcelable;
import e6.j;
import java.util.Arrays;
import k8.x;
import p2.c;
import q7.b;
import t7.v;
import u7.a;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new x(17);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f2871u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2872v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PendingIntent f2873w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final b f2874x;

    public Status(int i, String str, PendingIntent pendingIntent, b bVar) {
        this.f2871u = i;
        this.f2872v = str;
        this.f2873w = pendingIntent;
        this.f2874x = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2871u == status.f2871u && v.k(this.f2872v, status.f2872v) && v.k(this.f2873w, status.f2873w) && v.k(this.f2874x, status.f2874x);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2871u), this.f2872v, this.f2873w, this.f2874x});
    }

    public final String toString() {
        c cVar = new c(this);
        String strL = this.f2872v;
        if (strL == null) {
            int i = this.f2871u;
            switch (i) {
                case -1:
                    strL = "SUCCESS_CACHE";
                    break;
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    strL = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    strL = j.l("unknown status code: ", i);
                    break;
                case 2:
                    strL = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    strL = "SERVICE_DISABLED";
                    break;
                case b1.j.LONG_FIELD_NUMBER /* 4 */:
                    strL = "SIGN_IN_REQUIRED";
                    break;
                case b1.j.STRING_FIELD_NUMBER /* 5 */:
                    strL = "INVALID_ACCOUNT";
                    break;
                case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                    strL = "RESOLUTION_REQUIRED";
                    break;
                case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                    strL = "NETWORK_ERROR";
                    break;
                case 8:
                    strL = "INTERNAL_ERROR";
                    break;
                case 10:
                    strL = "DEVELOPER_ERROR";
                    break;
                case 13:
                    strL = "ERROR";
                    break;
                case 14:
                    strL = "INTERRUPTED";
                    break;
                case 15:
                    strL = "TIMEOUT";
                    break;
                case 16:
                    strL = "CANCELED";
                    break;
                case 17:
                    strL = "API_NOT_CONNECTED";
                    break;
                case 18:
                    strL = "DEAD_CLIENT";
                    break;
                case 19:
                    strL = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    strL = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    strL = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    strL = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        cVar.b(strL, "statusCode");
        cVar.b(this.f2873w, "resolution");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f2871u);
        t1.C(parcel, 2, this.f2872v);
        t1.B(parcel, 3, this.f2873w, i);
        t1.B(parcel, 4, this.f2874x, i);
        t1.G(parcel, iE);
    }
}
