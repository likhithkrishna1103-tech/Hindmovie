package com.google.android.gms.common.api;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import com.google.android.gms.common.internal.ReflectedParcelable;
import g1.h;
import java.util.Arrays;
import l4.p;
import l8.b;
import nb.w;
import o8.u;
import p8.a;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class Status extends a implements ReflectedParcelable {
    public static final Parcelable.Creator<Status> CREATOR = new p(12);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2306v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f2307w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PendingIntent f2308x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final b f2309y;

    public Status(int i, String str, PendingIntent pendingIntent, b bVar) {
        this.f2306v = i;
        this.f2307w = str;
        this.f2308x = pendingIntent;
        this.f2309y = bVar;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Status)) {
            return false;
        }
        Status status = (Status) obj;
        return this.f2306v == status.f2306v && u.j(this.f2307w, status.f2307w) && u.j(this.f2308x, status.f2308x) && u.j(this.f2309y, status.f2309y);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f2306v), this.f2307w, this.f2308x, this.f2309y});
    }

    public final String toString() {
        w wVar = new w(this);
        String string = this.f2307w;
        if (string == null) {
            int i = this.f2306v;
            switch (i) {
                case -1:
                    string = "SUCCESS_CACHE";
                    break;
                case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                    string = "SUCCESS";
                    break;
                case 1:
                case 9:
                case 11:
                case 12:
                default:
                    StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 21);
                    sb.append("unknown status code: ");
                    sb.append(i);
                    string = sb.toString();
                    break;
                case 2:
                    string = "SERVICE_VERSION_UPDATE_REQUIRED";
                    break;
                case 3:
                    string = "SERVICE_DISABLED";
                    break;
                case h.LONG_FIELD_NUMBER /* 4 */:
                    string = "SIGN_IN_REQUIRED";
                    break;
                case h.STRING_FIELD_NUMBER /* 5 */:
                    string = "INVALID_ACCOUNT";
                    break;
                case h.STRING_SET_FIELD_NUMBER /* 6 */:
                    string = "RESOLUTION_REQUIRED";
                    break;
                case h.DOUBLE_FIELD_NUMBER /* 7 */:
                    string = "NETWORK_ERROR";
                    break;
                case h.BYTES_FIELD_NUMBER /* 8 */:
                    string = "INTERNAL_ERROR";
                    break;
                case 10:
                    string = "DEVELOPER_ERROR";
                    break;
                case 13:
                    string = "ERROR";
                    break;
                case 14:
                    string = "INTERRUPTED";
                    break;
                case 15:
                    string = "TIMEOUT";
                    break;
                case 16:
                    string = "CANCELED";
                    break;
                case 17:
                    string = "API_NOT_CONNECTED";
                    break;
                case 18:
                    string = "DEAD_CLIENT";
                    break;
                case 19:
                    string = "REMOTE_EXCEPTION";
                    break;
                case 20:
                    string = "CONNECTION_SUSPENDED_DURING_CALL";
                    break;
                case 21:
                    string = "RECONNECTION_TIMED_OUT_DURING_UPDATE";
                    break;
                case 22:
                    string = "RECONNECTION_TIMED_OUT";
                    break;
            }
        }
        wVar.v(string, "statusCode");
        wVar.v(this.f2308x, "resolution");
        return wVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f2306v);
        t1.r(parcel, 2, this.f2307w);
        t1.q(parcel, 3, this.f2308x, i);
        t1.q(parcel, 4, this.f2309y, i);
        t1.y(parcel, iW);
    }
}
