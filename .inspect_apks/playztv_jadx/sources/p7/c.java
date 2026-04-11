package p7;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10256a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f10256a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int iV = q1.c.V(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iV) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        q1.c.R(parcel, i);
                    } else {
                        intent = (Intent) q1.c.t(parcel, i, Intent.CREATOR);
                    }
                }
                q1.c.z(parcel, iV);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f10256a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new a[i];
            default:
                return new g[i];
        }
    }
}
