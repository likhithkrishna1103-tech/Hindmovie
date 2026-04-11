package l3;

import java.util.Locale;
import java.util.Objects;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f7811a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f7812b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f7813c;

    public b(int i, long j5, long j8) {
        s1.d.b(j5 < j8);
        this.f7811a = j5;
        this.f7812b = j8;
        this.f7813c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f7811a == bVar.f7811a && this.f7812b == bVar.f7812b && this.f7813c == bVar.f7813c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f7811a), Long.valueOf(this.f7812b), Integer.valueOf(this.f7813c));
    }

    public final String toString() {
        int i = b0.f11647a;
        Locale locale = Locale.US;
        return "Segment: startTimeMs=" + this.f7811a + ", endTimeMs=" + this.f7812b + ", speedDivisor=" + this.f7813c;
    }
}
