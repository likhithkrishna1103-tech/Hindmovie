package q7;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;
import k8.x;
import t7.v;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b extends u7.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f11027u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f11028v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final PendingIntent f11029w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final String f11030x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final b f11026y = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new x(13);

    public b(int i, int i10, PendingIntent pendingIntent, String str) {
        this.f11027u = i;
        this.f11028v = i10;
        this.f11029w = pendingIntent;
        this.f11030x = str;
    }

    public static String b(int i) {
        if (i == 99) {
            return "UNFINISHED";
        }
        if (i == 1500) {
            return "DRIVE_EXTERNAL_STORAGE_REQUIRED";
        }
        switch (i) {
            case -1:
                return "UNKNOWN";
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return "SUCCESS";
            case 1:
                return "SERVICE_MISSING";
            case 2:
                return "SERVICE_VERSION_UPDATE_REQUIRED";
            case 3:
                return "SERVICE_DISABLED";
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return "SIGN_IN_REQUIRED";
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return "INVALID_ACCOUNT";
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return "RESOLUTION_REQUIRED";
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return "NETWORK_ERROR";
            case 8:
                return "INTERNAL_ERROR";
            case 9:
                return "SERVICE_INVALID";
            case 10:
                return "DEVELOPER_ERROR";
            case 11:
                return "LICENSE_CHECK_FAILED";
            default:
                switch (i) {
                    case 13:
                        return "CANCELED";
                    case 14:
                        return "TIMEOUT";
                    case 15:
                        return "INTERRUPTED";
                    case 16:
                        return "API_UNAVAILABLE";
                    case 17:
                        return "SIGN_IN_FAILED";
                    case 18:
                        return "SERVICE_UPDATING";
                    case 19:
                        return "SERVICE_MISSING_PERMISSION";
                    case 20:
                        return "RESTRICTED_PROFILE";
                    case 21:
                        return "API_VERSION_UPDATE_REQUIRED";
                    case 22:
                        return "RESOLUTION_ACTIVITY_NOT_FOUND";
                    case 23:
                        return "API_DISABLED";
                    case 24:
                        return "API_DISABLED_FOR_CONNECTION";
                    default:
                        return e6.j.j(i, "UNKNOWN_ERROR_CODE(", ")");
                }
        }
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f11028v == bVar.f11028v && v.k(this.f11029w, bVar.f11029w) && v.k(this.f11030x, bVar.f11030x);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f11028v), this.f11029w, this.f11030x});
    }

    public final String toString() {
        p2.c cVar = new p2.c(this);
        cVar.b(b(this.f11028v), "statusCode");
        cVar.b(this.f11029w, "resolution");
        cVar.b(this.f11030x, "message");
        return cVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iE = t1.E(parcel, 20293);
        t1.H(parcel, 1, 4);
        parcel.writeInt(this.f11027u);
        t1.H(parcel, 2, 4);
        parcel.writeInt(this.f11028v);
        t1.B(parcel, 3, this.f11029w, i);
        t1.C(parcel, 4, this.f11030x);
        t1.G(parcel, iE);
    }

    public b(int i) {
        this(1, i, null, null);
    }

    public b(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
