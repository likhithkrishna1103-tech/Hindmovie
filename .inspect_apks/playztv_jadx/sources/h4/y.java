package h4;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class y implements Parcelable {
    public static final Parcelable.Creator<y> CREATOR = new a9.b(21);

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final MediaSession.Token f5863v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public h f5864w;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f5862u = new Object();

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i5.d f5865x = null;

    public y(MediaSession.Token token, s sVar) {
        this.f5863v = token;
        this.f5864w = sVar;
    }

    public final h a() {
        h hVar;
        synchronized (this.f5862u) {
            hVar = this.f5864w;
        }
        return hVar;
    }

    public final void b(h hVar) {
        synchronized (this.f5862u) {
            this.f5864w = hVar;
        }
    }

    public final void c(i5.d dVar) {
        synchronized (this.f5862u) {
            this.f5865x = dVar;
        }
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof y) {
            return this.f5863v.equals(((y) obj).f5863v);
        }
        return false;
    }

    public final int hashCode() {
        return this.f5863v.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f5863v, i);
    }
}
