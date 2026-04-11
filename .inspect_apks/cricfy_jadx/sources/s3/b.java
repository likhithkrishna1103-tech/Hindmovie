package s3;

import a3.q;
import java.util.ArrayDeque;
import kf.i;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final byte[] f11399a = new byte[8];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayDeque f11400b = new ArrayDeque();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final e f11401c = new e();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public i f11402d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f11403e;
    public int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public long f11404g;

    public final long a(q qVar, int i) {
        byte[] bArr = this.f11399a;
        qVar.readFully(bArr, 0, i);
        long j4 = 0;
        for (int i10 = 0; i10 < i; i10++) {
            j4 = (j4 << 8) | ((long) (bArr[i10] & 255));
        }
        return j4;
    }
}
