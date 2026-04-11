package c0;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;
import j9.v;
import l9.l;
import l9.q;
import n.k3;
import n.x2;
import q4.q0;
import v9.y;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g implements Parcelable.ClassLoaderCreator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2225a;

    public /* synthetic */ g(int i) {
        this.f2225a = i;
    }

    @Override // android.os.Parcelable.ClassLoaderCreator
    public final Object createFromParcel(Parcel parcel, ClassLoader classLoader) {
        switch (this.f2225a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new h(parcel, classLoader);
            case 1:
                return new e1.e(parcel, classLoader);
            case 2:
                return new j9.b(parcel, classLoader);
            case 3:
                return new v(parcel, classLoader);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new k5.h(parcel, classLoader);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new l(parcel, classLoader);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new q(parcel, classLoader);
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new x2(parcel, classLoader);
            case 8:
                return new k3(parcel, classLoader);
            case 9:
                return new q0(parcel, classLoader);
            case 10:
                return new r9.d(parcel, classLoader);
            case 11:
                return new t9.a(parcel, classLoader);
            case 12:
                return new y(parcel, classLoader);
            case 13:
                return new w8.a(parcel, classLoader);
            case 14:
                if (parcel.readParcelable(classLoader) == null) {
                    return x0.b.f14204v;
                }
                throw new IllegalStateException("superState must be null");
            default:
                return new x8.b(parcel, classLoader);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f2225a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new h[i];
            case 1:
                return new e1.e[i];
            case 2:
                return new j9.b[i];
            case 3:
                return new v[i];
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new k5.h[i];
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new l[i];
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new q[i];
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new x2[i];
            case 8:
                return new k3[i];
            case 9:
                return new q0[i];
            case 10:
                return new r9.d[i];
            case 11:
                return new t9.a[i];
            case 12:
                return new y[i];
            case 13:
                return new w8.a[i];
            case 14:
                return new x0.b[i];
            default:
                return new x8.b[i];
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f2225a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new h(parcel, null);
            case 1:
                return new e1.e(parcel, null);
            case 2:
                return new j9.b(parcel, null);
            case 3:
                return new v(parcel, null);
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                return new k5.h(parcel, null);
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
                return new l(parcel, null);
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
                return new q(parcel, null);
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                return new x2(parcel, null);
            case 8:
                return new k3(parcel, null);
            case 9:
                return new q0(parcel, null);
            case 10:
                return new r9.d(parcel, null);
            case 11:
                return new t9.a(parcel, null);
            case 12:
                return new y(parcel, null);
            case 13:
                return new w8.a(parcel, null);
            case 14:
                if (parcel.readParcelable(null) == null) {
                    return x0.b.f14204v;
                }
                throw new IllegalStateException("superState must be null");
            default:
                return new x8.b(parcel, null);
        }
    }
}
