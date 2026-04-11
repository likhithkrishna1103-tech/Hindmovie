package h4;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class w implements Parcelable {
    public static final Parcelable.Creator<w> CREATOR = new a9.b(19);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final n f5858u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f5859v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public MediaSession.QueueItem f5860w;

    public w(n nVar, long j5) {
        if (j5 == -1) {
            throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
        }
        this.f5858u = nVar;
        this.f5859v = j5;
        this.f5860w = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MediaSession.QueueItem { Description=");
        sb2.append(this.f5858u);
        sb2.append(", Id=");
        return l4.a.n(sb2, this.f5859v, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        this.f5858u.writeToParcel(parcel, i);
        parcel.writeLong(this.f5859v);
    }

    public w(Parcel parcel) {
        this.f5858u = n.CREATOR.createFromParcel(parcel);
        this.f5859v = parcel.readLong();
    }
}
