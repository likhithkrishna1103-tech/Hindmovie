package bc;

import e6.j;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f1999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f2001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f2002d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f2003e;
    public byte f;

    public final c a() {
        if (this.f == 1 && this.f1999a != null && this.f2000b != null && this.f2001c != null && this.f2002d != null) {
            return new c(this.f1999a, this.f2000b, this.f2001c, this.f2002d, this.f2003e);
        }
        StringBuilder sb2 = new StringBuilder();
        if (this.f1999a == null) {
            sb2.append(" rolloutId");
        }
        if (this.f2000b == null) {
            sb2.append(" variantId");
        }
        if (this.f2001c == null) {
            sb2.append(" parameterKey");
        }
        if (this.f2002d == null) {
            sb2.append(" parameterValue");
        }
        if ((1 & this.f) == 0) {
            sb2.append(" templateVersion");
        }
        throw new IllegalStateException(j.o("Missing required properties:", sb2));
    }
}
