package l4;

import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b0 implements Parcelable {
    public static final Parcelable.Creator<b0> CREATOR = new p(3);

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final MediaSession.Token f7701w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public i f7702x;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f7700v = new Object();

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public n5.d f7703y = null;

    public b0(MediaSession.Token token, v vVar) {
        this.f7701w = token;
        this.f7702x = vVar;
    }

    public final i a() {
        i iVar;
        synchronized (this.f7700v) {
            iVar = this.f7702x;
        }
        return iVar;
    }

    public final void b(i iVar) {
        synchronized (this.f7700v) {
            this.f7702x = iVar;
        }
    }

    public final void c(n5.d dVar) {
        synchronized (this.f7700v) {
            this.f7703y = dVar;
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
        if (obj instanceof b0) {
            return this.f7701w.equals(((b0) obj).f7701w);
        }
        return false;
    }

    public final int hashCode() {
        return this.f7701w.hashCode();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.f7701w, i);
    }
}
