package z5;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f14867a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long[] f14868b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final File[] f14869c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final File[] f14870d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f14871e;
    public a2.c f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c f14872g;

    public b(c cVar, String str) {
        this.f14872g = cVar;
        this.f14867a = str;
        int i = cVar.A;
        File file = cVar.f14873u;
        this.f14868b = new long[i];
        this.f14869c = new File[i];
        this.f14870d = new File[i];
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('.');
        int length = sb2.length();
        for (int i10 = 0; i10 < i; i10++) {
            sb2.append(i10);
            this.f14869c[i10] = new File(file, sb2.toString());
            sb2.append(".tmp");
            this.f14870d[i10] = new File(file, sb2.toString());
            sb2.setLength(length);
        }
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        for (long j5 : this.f14868b) {
            sb2.append(' ');
            sb2.append(j5);
        }
        return sb2.toString();
    }
}
