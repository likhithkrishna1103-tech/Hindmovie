package p3;

import com.bumptech.glide.e;
import v1.i0;
import v1.k0;
import v1.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class a implements k0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9977a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9978b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f9979c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f9980d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f9981e;

    public a(long j4, long j7, long j10, long j11, long j12) {
        this.f9977a = j4;
        this.f9978b = j7;
        this.f9979c = j10;
        this.f9980d = j11;
        this.f9981e = j12;
    }

    @Override // v1.k0
    public final /* synthetic */ p a() {
        return null;
    }

    @Override // v1.k0
    public final /* synthetic */ byte[] b() {
        return null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && a.class == obj.getClass()) {
            a aVar = (a) obj;
            if (this.f9977a == aVar.f9977a && this.f9978b == aVar.f9978b && this.f9979c == aVar.f9979c && this.f9980d == aVar.f9980d && this.f9981e == aVar.f9981e) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return e.g(this.f9981e) + ((e.g(this.f9980d) + ((e.g(this.f9979c) + ((e.g(this.f9978b) + ((e.g(this.f9977a) + 527) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "Motion photo metadata: photoStartPosition=" + this.f9977a + ", photoSize=" + this.f9978b + ", photoPresentationTimestampUs=" + this.f9979c + ", videoStartPosition=" + this.f9980d + ", videoSize=" + this.f9981e;
    }

    @Override // v1.k0
    public final /* synthetic */ void c(i0 i0Var) {
    }
}
