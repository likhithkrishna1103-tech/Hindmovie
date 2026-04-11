package b3;

import w2.e;
import w2.g;
import w2.h;
import w2.j;
import w2.p;
import w2.s;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e f1790a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final j f1791b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public g f1792c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f1793d;

    public a(h hVar, j jVar, long j5, long j8, long j10, long j11, long j12, int i) {
        this.f1791b = jVar;
        this.f1793d = i;
        this.f1790a = new e(hVar, j5, j8, j10, j11, j12);
    }

    public static int a(int i, byte[] bArr) {
        return (bArr[i + 3] & 255) | ((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16) | ((bArr[i + 2] & 255) << 8);
    }

    public static int c(p pVar, long j5, s sVar) {
        if (j5 == pVar.getPosition()) {
            return 0;
        }
        sVar.f13664a = j5;
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:32:0x00cc, code lost:
    
        return c(r28, r8, r29);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int b(w2.p r28, w2.s r29) {
        /*
            Method dump skipped, instruction units count: 205
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: b3.a.b(w2.p, w2.s):int");
    }

    public final void d(long j5) {
        g gVar = this.f1792c;
        if (gVar == null || gVar.f13624a != j5) {
            e eVar = this.f1790a;
            this.f1792c = new g(j5, eVar.f13619a.e(j5), eVar.f13621c, eVar.f13622d, eVar.f13623e, eVar.f);
        }
    }
}
