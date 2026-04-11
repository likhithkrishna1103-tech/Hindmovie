package n2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f8642a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f8643b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f8644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f8645d;

    public d(String str, double d10) {
        this.f8642a = str;
        this.f8643b = 2;
        this.f8644c = d10;
        this.f8645d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f8643b == dVar.f8643b && Double.compare(this.f8644c, dVar.f8644c) == 0 && Objects.equals(this.f8642a, dVar.f8642a) && Objects.equals(this.f8645d, dVar.f8645d);
    }

    public final int hashCode() {
        return Objects.hash(this.f8642a, Integer.valueOf(this.f8643b), Double.valueOf(this.f8644c), this.f8645d);
    }

    public d(int i, String str, String str2) {
        boolean z10 = true;
        if (i == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
            z10 = false;
        }
        y1.d.g(z10);
        this.f8642a = str;
        this.f8643b = i;
        this.f8645d = str2;
        this.f8644c = 0.0d;
    }
}
