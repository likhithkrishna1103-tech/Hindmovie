package f3;

import a3.f;
import a3.g;
import a3.h;
import a3.j;
import a3.q;
import a3.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final f f3938a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f3939b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f3940c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f3941d;

    public b(h hVar, j jVar, long j4, long j7, long j10, long j11, long j12, int i) {
        this.f3939b = jVar;
        this.f3941d = i;
        this.f3938a = new f(hVar, j4, j7, j10, j11, j12);
    }

    public static int a(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int c(q qVar, long j4, t tVar) {
        if (j4 == qVar.getPosition()) {
            return 0;
        }
        tVar.f227a = j4;
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        return c(r28, r8, r29);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(a3.q r28, a3.t r29) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: f3.b.b(a3.q, a3.t):int");
    }

    public final void d(long j4) {
        g gVar = this.f3940c;
        if (gVar == null || gVar.f181a != j4) {
            f fVar = this.f3938a;
            this.f3940c = new g(j4, fVar.f176a.d(j4), fVar.f178c, fVar.f179d, fVar.f180e, fVar.f);
        }
    }
}
