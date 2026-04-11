package h2;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f5666a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f5667b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final double f5668c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f5669d;

    public d(String str, double d10) {
        this.f5666a = str;
        this.f5667b = 2;
        this.f5668c = d10;
        this.f5669d = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return this.f5667b == dVar.f5667b && Double.compare(this.f5668c, dVar.f5668c) == 0 && Objects.equals(this.f5666a, dVar.f5666a) && Objects.equals(this.f5669d, dVar.f5669d);
    }

    public final int hashCode() {
        return Objects.hash(this.f5666a, Integer.valueOf(this.f5667b), Double.valueOf(this.f5668c), this.f5669d);
    }

    public d(int i, String str, String str2) {
        boolean z2 = true;
        if (i == 1 && !str2.startsWith("0x") && !str2.startsWith("0X")) {
            z2 = false;
        }
        s1.d.g(z2);
        this.f5666a = str;
        this.f5667b = i;
        this.f5669d = str2;
        this.f5668c = 0.0d;
    }
}
