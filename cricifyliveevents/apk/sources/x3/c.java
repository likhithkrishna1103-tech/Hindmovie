package x3;

import java.util.List;
import ua.i0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final i0 f14292a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f14293b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final long f14294c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f14295d;

    public c(long j4, long j7, List list) {
        this.f14292a = i0.k(list);
        this.f14293b = j4;
        this.f14294c = j7;
        long j10 = -9223372036854775807L;
        if (j4 != -9223372036854775807L && j7 != -9223372036854775807L) {
            j10 = j4 + j7;
        }
        this.f14295d = j10;
    }
}
