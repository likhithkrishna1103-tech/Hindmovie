package w1;

import java.util.Objects;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final f f13790e = new f(-1, -1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f13791a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f13792b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13793c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f13794d;

    public f(int i, int i10, int i11) {
        this.f13791a = i;
        this.f13792b = i10;
        this.f13793c = i11;
        this.f13794d = a0.J(i11) ? a0.r(i11) * i10 : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof f)) {
            return false;
        }
        f fVar = (f) obj;
        return this.f13791a == fVar.f13791a && this.f13792b == fVar.f13792b && this.f13793c == fVar.f13793c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f13791a), Integer.valueOf(this.f13792b), Integer.valueOf(this.f13793c));
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f13791a + ", channelCount=" + this.f13792b + ", encoding=" + this.f13793c + ']';
    }
}
