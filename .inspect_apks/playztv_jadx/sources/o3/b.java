package o3;

import java.util.ArrayDeque;
import w2.p;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f9265a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f9266b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f9267c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public u5.d f9268d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f9269e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f9270g;

    public final long a(p pVar, int i) {
        byte[] bArr = this.f9265a;
        pVar.readFully(bArr, 0, i);
        long j5 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            j5 = (j5 << 8) | ((long) (bArr[i10] & 255));
        }
        return j5;
    }
}
