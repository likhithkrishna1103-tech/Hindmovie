package w1;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Comparable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final String f13527u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final long f13528v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f13529w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final boolean f13530x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final File f13531y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final long f13532z;

    public i(String str, long j5, long j8, long j10, File file) {
        this.f13527u = str;
        this.f13528v = j5;
        this.f13529w = j8;
        this.f13530x = file != null;
        this.f13531y = file;
        this.f13532z = j10;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(i iVar) {
        String str = iVar.f13527u;
        String str2 = this.f13527u;
        if (!str2.equals(str)) {
            return str2.compareTo(iVar.f13527u);
        }
        long j5 = this.f13528v - iVar.f13528v;
        if (j5 == 0) {
            return 0;
        }
        return j5 < 0 ? -1 : 1;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("[");
        sb2.append(this.f13528v);
        sb2.append(", ");
        return l4.a.n(sb2, this.f13529w, "]");
    }
}
