package l8;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import java.util.Arrays;
import nb.w;
import qb.t1;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b extends p8.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f7877v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f7878w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final PendingIntent f7879x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final String f7880y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final b f7876z = new b(0);
    public static final Parcelable.Creator<b> CREATOR = new l4.p(8);

    public b(int i, int i10, PendingIntent pendingIntent, String str) {
        this.f7877v = i;
        this.f7878w = i10;
        this.f7879x = pendingIntent;
        this.f7880y = str;
    }

    public static String a(int i) {
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
            case g1.h.LONG_FIELD_NUMBER /* 4 */:
                return "SIGN_IN_REQUIRED";
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return "INVALID_ACCOUNT";
            case g1.h.STRING_SET_FIELD_NUMBER /* 6 */:
                return "RESOLUTION_REQUIRED";
            case g1.h.DOUBLE_FIELD_NUMBER /* 7 */:
                return "NETWORK_ERROR";
            case g1.h.BYTES_FIELD_NUMBER /* 8 */:
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
                    case 25:
                        return "API_INSTALL_REQUIRED";
                    default:
                        StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 20);
                        sb.append("UNKNOWN_ERROR_CODE(");
                        sb.append(i);
                        sb.append(")");
                        return sb.toString();
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
        return this.f7878w == bVar.f7878w && o8.u.j(this.f7879x, bVar.f7879x) && o8.u.j(this.f7880y, bVar.f7880y);
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f7878w), this.f7879x, this.f7880y});
    }

    public final String toString() {
        w wVar = new w(this);
        wVar.v(a(this.f7878w), "statusCode");
        wVar.v(this.f7879x, "resolution");
        wVar.v(this.f7880y, "message");
        return wVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iW = t1.w(parcel, 20293);
        t1.v(parcel, 1, 4);
        parcel.writeInt(this.f7877v);
        t1.v(parcel, 2, 4);
        parcel.writeInt(this.f7878w);
        t1.q(parcel, 3, this.f7879x, i);
        t1.r(parcel, 4, this.f7880y);
        t1.y(parcel, iW);
    }

    public b(int i) {
        this(1, i, null, null);
    }

    public b(int i, PendingIntent pendingIntent) {
        this(1, i, pendingIntent, null);
    }
}
