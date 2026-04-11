package c2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f1993a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f1994b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f1995c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b2.o f1996d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f1997e;
    public File f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OutputStream f1998g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f1999h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public t f2000j;

    public d(v vVar) {
        vVar.getClass();
        this.f1993a = vVar;
        this.f1994b = 5242880L;
        this.f1995c = 20480;
    }

    public final void a() {
        OutputStream outputStream = this.f1998g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            a0.g(this.f1998g);
            this.f1998g = null;
            File file = this.f;
            this.f = null;
            b bVar = this.f1993a;
            long j4 = this.f1999h;
            v vVar = (v) bVar;
            synchronized (vVar) {
                if (file.exists()) {
                    if (j4 == 0) {
                        file.delete();
                        return;
                    }
                    w wVarB = w.b(file, j4, -9223372036854775807L, vVar.f2051c);
                    wVarB.getClass();
                    k kVarL = vVar.f2051c.l(wVarB.f2012v);
                    kVarL.getClass();
                    y1.d.g(kVarL.a(wVarB.f2013w, wVarB.f2014x));
                    long jE = q4.a.e(kVarL.f2023e);
                    if (jE != -1) {
                        y1.d.g(wVarB.f2013w + wVarB.f2014x <= jE);
                    }
                    if (vVar.f2052d == null) {
                        vVar.b(wVarB);
                        vVar.f2051c.A();
                        vVar.notifyAll();
                        return;
                    }
                    try {
                        vVar.f2052d.e(wVarB.f2014x, wVarB.A, file.getName());
                        vVar.b(wVarB);
                        try {
                            vVar.f2051c.A();
                            vVar.notifyAll();
                            return;
                        } catch (IOException e9) {
                            throw new a(e9);
                        }
                    } catch (IOException e10) {
                        throw new a(e10);
                    }
                }
            }
        } catch (Throwable th) {
            a0.g(this.f1998g);
            this.f1998g = null;
            File file2 = this.f;
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void b(b2.o oVar) {
        File fileC;
        long j4 = oVar.f1719g;
        long jMin = j4 == -1 ? -1L : Math.min(j4 - this.i, this.f1997e);
        b bVar = this.f1993a;
        String str = oVar.f1720h;
        int i = a0.f14551a;
        long j7 = oVar.f + this.i;
        v vVar = (v) bVar;
        synchronized (vVar) {
            try {
                vVar.d();
                k kVarL = vVar.f2051c.l(str);
                kVarL.getClass();
                y1.d.g(kVarL.a(j7, jMin));
                if (!vVar.f2049a.exists()) {
                    v.e(vVar.f2049a);
                    vVar.l();
                }
                s sVar = vVar.f2050b;
                if (jMin != -1) {
                    sVar.a(vVar, jMin);
                } else {
                    sVar.getClass();
                }
                File file = new File(vVar.f2049a, Integer.toString(vVar.f.nextInt(10)));
                if (!file.exists()) {
                    v.e(file);
                }
                fileC = w.c(file, kVarL.f2019a, j7, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f = fileC;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.f1995c > 0) {
            t tVar = this.f2000j;
            if (tVar == null) {
                this.f2000j = new t(fileOutputStream, this.f1995c);
            } else {
                tVar.a(fileOutputStream);
            }
            this.f1998g = this.f2000j;
        } else {
            this.f1998g = fileOutputStream;
        }
        this.f1999h = 0L;
    }
}
