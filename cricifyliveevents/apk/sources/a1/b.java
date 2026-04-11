package a1;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import da.v;
import f0.g;
import g1.h;
import j1.e;
import la.d;
import o.b3;
import o.n3;
import p5.f;
import pa.b0;
import v4.q0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f110a;

    public /* synthetic */ b(int i) {
        this.f110a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f110a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (parcel.readParcelable(classLoader) == null) {
                    return c.f111w;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new da.b(parcel, classLoader);
            case 2:
                return new v(parcel, classLoader);
            case 3:
                return new g(parcel, classLoader);
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new fa.g(parcel, classLoader);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new e(parcel, classLoader);
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new d(parcel, classLoader);
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new na.a(parcel, classLoader);
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return new b3(parcel, classLoader);
            case 9:
                return new n3(parcel, classLoader);
            case 10:
                return new f(parcel, classLoader);
            case 11:
                return new b0(parcel, classLoader);
            case 12:
                return new q9.a(parcel, classLoader);
            case 13:
                return new r9.c(parcel, classLoader);
            default:
                return new q0(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f110a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new c[i];
            case 1:
                return new da.b[i];
            case 2:
                return new v[i];
            case 3:
                return new g[i];
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new fa.g[i];
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new e[i];
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new d[i];
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new na.a[i];
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return new b3[i];
            case 9:
                return new n3[i];
            case 10:
                return new f[i];
            case 11:
                return new b0[i];
            case 12:
                return new q9.a[i];
            case 13:
                return new r9.c[i];
            default:
                return new q0[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f110a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                if (parcel.readParcelable(null) == null) {
                    return c.f111w;
                }
                throw new IllegalStateException("superState must be null");
            case 1:
                return new da.b(parcel, null);
            case 2:
                return new v(parcel, null);
            case 3:
                return new g(parcel, null);
            case h.LONG_FIELD_NUMBER /* 4 */:
                return new fa.g(parcel, null);
            case h.STRING_FIELD_NUMBER /* 5 */:
                return new e(parcel, null);
            case h.STRING_SET_FIELD_NUMBER /* 6 */:
                return new d(parcel, null);
            case h.DOUBLE_FIELD_NUMBER /* 7 */:
                return new na.a(parcel, null);
            case h.BYTES_FIELD_NUMBER /* 8 */:
                return new b3(parcel, null);
            case 9:
                return new n3(parcel, null);
            case 10:
                return new f(parcel, null);
            case 11:
                return new b0(parcel, null);
            case 12:
                return new q9.a(parcel, null);
            case 13:
                return new r9.c(parcel, null);
            default:
                return new q0(parcel, null);
        }
    }
}
