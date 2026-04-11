package c2;

import java.io.File;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public abstract class i implements Comparable {
    public final long A;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f2012v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final long f2013w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final long f2014x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final boolean f2015y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final File f2016z;

    public i(String str, long j4, long j7, long j10, File file) {
        this.f2012v = str;
        this.f2013w = j4;
        this.f2014x = j7;
        this.f2015y = file != null;
        this.f2016z = file;
        this.A = j10;
    }

    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final int compareTo(i iVar) {
        String str = iVar.f2012v;
        String str2 = this.f2012v;
        if (!str2.equals(str)) {
            return str2.compareTo(iVar.f2012v);
        }
        long j4 = this.f2013w - iVar.f2013w;
        if (j4 == 0) {
            return 0;
        }
        return j4 < 0 ? -1 : 1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        sb.append(this.f2013w);
        sb.append(", ");
        return q4.a.p(sb, this.f2014x, "]");
    }
}
