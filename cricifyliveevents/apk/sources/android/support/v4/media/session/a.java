package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements Parcelable.Creator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f506a;

    public /* synthetic */ a(int i) {
        this.f506a = i;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        switch (this.f506a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f489v = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 1:
                return new Parcelable(parcel) { // from class: android.support.v4.media.session.MediaSessionCompat$QueueItem
                    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new a(1);

                    /* JADX INFO: renamed from: v, reason: collision with root package name */
                    public final MediaDescriptionCompat f487v;

                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                    public final long f488w;

                    {
                        this.f487v = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                        this.f488w = parcel.readLong();
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        StringBuilder sb = new StringBuilder("MediaSession.QueueItem {Description=");
                        sb.append(this.f487v);
                        sb.append(", Id=");
                        return q4.a.p(sb, this.f488w, " }");
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        this.f487v.writeToParcel(parcel2, i);
                        parcel2.writeLong(this.f488w);
                    }
                };
            case 2:
                final Parcelable parcelable = parcel.readParcelable(null);
                return new Parcelable(parcelable) { // from class: android.support.v4.media.session.MediaSessionCompat$Token
                    public static final Parcelable.Creator<MediaSessionCompat$Token> CREATOR = new a(2);

                    /* JADX INFO: renamed from: v, reason: collision with root package name */
                    public final Object f490v = new Object();

                    /* JADX INFO: renamed from: w, reason: collision with root package name */
                    public final Object f491w;

                    {
                        this.f491w = parcelable;
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof MediaSessionCompat$Token)) {
                            return false;
                        }
                        Object obj2 = ((MediaSessionCompat$Token) obj).f491w;
                        Object obj3 = this.f491w;
                        if (obj3 == null) {
                            return obj2 == null;
                        }
                        if (obj2 == null) {
                            return false;
                        }
                        return obj3.equals(obj2);
                    }

                    public final int hashCode() {
                        Object obj = this.f491w;
                        if (obj == null) {
                            return 0;
                        }
                        return obj.hashCode();
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i) {
                        parcel2.writeParcelable((Parcelable) this.f491w, i);
                    }
                };
            case 3:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.f492v = parcel.readInt();
                parcelableVolumeInfo.f494x = parcel.readInt();
                parcelableVolumeInfo.f495y = parcel.readInt();
                parcelableVolumeInfo.f496z = parcel.readInt();
                parcelableVolumeInfo.f493w = parcel.readInt();
                return parcelableVolumeInfo;
            default:
                return new PlaybackStateCompat(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.f506a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                return new MediaSessionCompat$ResultReceiverWrapper[i];
            case 1:
                return new MediaSessionCompat$QueueItem[i];
            case 2:
                return new MediaSessionCompat$Token[i];
            case 3:
                return new ParcelableVolumeInfo[i];
            default:
                return new PlaybackStateCompat[i];
        }
    }
}
