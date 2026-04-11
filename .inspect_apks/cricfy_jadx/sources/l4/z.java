package l4;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class z implements Parcelable {
    public static final Parcelable.Creator<z> CREATOR = new p(1);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final o f7776v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f7777w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public MediaSession.QueueItem f7778x;

    public z(o oVar, long j4) {
        if (j4 == -1) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.f7776v = oVar;
        this.f7777w = j4;
        this.f7778x = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("MediaSession.QueueItem { Description=");
        sb.append(this.f7776v);
        sb.append(", Id=");
        return q4.a.p(sb, this.f7777w, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.f7776v.writeToParcel(parcel, i);
        parcel.writeLong(this.f7777w);
    }

    public z(Parcel parcel) {
        this.f7776v = o.CREATOR.createFromParcel(parcel);
        this.f7777w = parcel.readLong();
    }
}
