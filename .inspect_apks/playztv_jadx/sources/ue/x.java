package ue;

import java.io.Closeable;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class x implements Closeable {
    public final z A;
    public final x B;
    public final x C;
    public final x D;
    public final long E;
    public final long F;
    public final w1.m G;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final b2.g f13066u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final t f13067v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f13068w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final int f13069x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final l f13070y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final m f13071z;

    public x(b2.g gVar, t tVar, String str, int i, l lVar, m mVar, z zVar, x xVar, x xVar2, x xVar3, long j5, long j8, w1.m mVar2) {
        be.h.e(gVar, "request");
        be.h.e(tVar, "protocol");
        be.h.e(str, "message");
        this.f13066u = gVar;
        this.f13067v = tVar;
        this.f13068w = str;
        this.f13069x = i;
        this.f13070y = lVar;
        this.f13071z = mVar;
        this.A = zVar;
        this.B = xVar;
        this.C = xVar2;
        this.D = xVar3;
        this.E = j5;
        this.F = j8;
        this.G = mVar2;
    }

    public static String a(String str, x xVar) {
        xVar.getClass();
        String strB = xVar.f13071z.b(str);
        if (strB == null) {
            return null;
        }
        return strB;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        z zVar = this.A;
        if (zVar == null) {
            throw new IllegalStateException("response is not eligible for a body and must not be closed");
        }
        zVar.close();
    }

    public final w d() {
        w wVar = new w();
        wVar.f13055a = this.f13066u;
        wVar.f13056b = this.f13067v;
        wVar.f13057c = this.f13069x;
        wVar.f13058d = this.f13068w;
        wVar.f13059e = this.f13070y;
        wVar.f = this.f13071z.e();
        wVar.f13060g = this.A;
        wVar.f13061h = this.B;
        wVar.i = this.C;
        wVar.f13062j = this.D;
        wVar.f13063k = this.E;
        wVar.f13064l = this.F;
        wVar.f13065m = this.G;
        return wVar;
    }

    public final String toString() {
        return "Response{protocol=" + this.f13067v + ", code=" + this.f13069x + ", message=" + this.f13068w + ", url=" + ((o) this.f13066u.f1737b) + '}';
    }
}
