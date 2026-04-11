package t3;

import aa.j0;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final j0 f12071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f12072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f12073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f12074d;

    public a(long j5, long j8, List list) {
        this.f12071a = j0.r(list);
        this.f12072b = j5;
        this.f12073c = j8;
        long j10 = -9223372036854775807L;
        if (j5 != -9223372036854775807L && j8 != -9223372036854775807L) {
            j10 = j5 + j8;
        }
        this.f12074d = j10;
    }
}
