package q1;

import java.util.Objects;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final e f10542e = new e(-1, -1, -1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f10543a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f10544b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f10545c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f10546d;

    public e(int i, int i10, int i11) {
        this.f10543a = i;
        this.f10544b = i10;
        this.f10545c = i11;
        this.f10546d = b0.J(i11) ? b0.r(i11) * i10 : -1;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e)) {
            return false;
        }
        e eVar = (e) obj;
        return this.f10543a == eVar.f10543a && this.f10544b == eVar.f10544b && this.f10545c == eVar.f10545c;
    }

    public final int hashCode() {
        return Objects.hash(Integer.valueOf(this.f10543a), Integer.valueOf(this.f10544b), Integer.valueOf(this.f10545c));
    }

    public final String toString() {
        return "AudioFormat[sampleRate=" + this.f10543a + ", channelCount=" + this.f10544b + ", encoding=" + this.f10545c + ']';
    }
}
