package k8;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f7253a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f7253a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                int iO = n5.a.O(parcel);
                Intent intent = null;
                while (parcel.dataPosition() < iO) {
                    int i = parcel.readInt();
                    if (((char) i) != 1) {
                        n5.a.K(parcel, i);
                    } else {
                        intent = (Intent) n5.a.i(parcel, i, Intent.CREATOR);
                    }
                }
                n5.a.m(parcel, iO);
                return new a(intent);
            default:
                return new g(parcel.readStrongBinder());
        }
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        switch (this.f7253a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new a[i];
            default:
                return new g[i];
        }
    }
}
