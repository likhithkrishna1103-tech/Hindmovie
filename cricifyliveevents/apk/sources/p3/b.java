package p3;

import java.util.Locale;
import java.util.Objects;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f9982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f9983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9984c;

    public b(int i, long j4, long j7) {
        y1.d.b(j4 < j7);
        this.f9982a = j4;
        this.f9983b = j7;
        this.f9984c = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && b.class == obj.getClass()) {
            b bVar = (b) obj;
            if (this.f9982a == bVar.f9982a && this.f9983b == bVar.f9983b && this.f9984c == bVar.f9984c) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.f9982a), Long.valueOf(this.f9983b), Integer.valueOf(this.f9984c));
    }

    public final String toString() {
        int i = a0.f14551a;
        Locale locale = Locale.US;
        return "Segment: startTimeMs=" + this.f9982a + ", endTimeMs=" + this.f9983b + ", speedDivisor=" + this.f9984c;
    }
}
