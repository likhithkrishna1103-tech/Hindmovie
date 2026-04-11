package w1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f13507a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final long f13508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f13509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public v1.m f13510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f13511e;
    public File f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public OutputStream f13512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public long f13513h;
    public long i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public s f13514j;

    public d(u uVar) {
        uVar.getClass();
        this.f13507a = uVar;
        this.f13508b = 5242880L;
        this.f13509c = 20480;
    }

    public final void a() {
        OutputStream outputStream = this.f13512g;
        if (outputStream == null) {
            return;
        }
        try {
            outputStream.flush();
            b0.g(this.f13512g);
            this.f13512g = null;
            File file = this.f;
            this.f = null;
            b bVar = this.f13507a;
            long j5 = this.f13513h;
            u uVar = (u) bVar;
            synchronized (uVar) {
                if (file.exists()) {
                    if (j5 == 0) {
                        file.delete();
                        return;
                    }
                    v vVarB = v.b(file, j5, -9223372036854775807L, uVar.f13561c);
                    vVarB.getClass();
                    k kVarK = uVar.f13561c.k(vVarB.f13527u);
                    kVarK.getClass();
                    s1.d.g(kVarK.a(vVarB.f13528v, vVarB.f13529w));
                    long jD = e6.j.d(kVarK.f13539e);
                    if (jD != -1) {
                        s1.d.g(vVarB.f13528v + vVarB.f13529w <= jD);
                    }
                    if (uVar.f13562d == null) {
                        uVar.b(vVarB);
                        uVar.f13561c.y();
                        uVar.notifyAll();
                        return;
                    }
                    try {
                        uVar.f13562d.e(vVarB.f13529w, vVarB.f13532z, file.getName());
                        uVar.b(vVarB);
                        try {
                            uVar.f13561c.y();
                            uVar.notifyAll();
                            return;
                        } catch (IOException e10) {
                            throw new a(e10);
                        }
                    } catch (IOException e11) {
                        throw new a(e11);
                    }
                }
            }
        } catch (Throwable th) {
            b0.g(this.f13512g);
            this.f13512g = null;
            File file2 = this.f;
            this.f = null;
            file2.delete();
            throw th;
        }
    }

    public final void b(v1.m mVar) {
        File fileC;
        long j5 = mVar.f13162g;
        long jMin = j5 == -1 ? -1L : Math.min(j5 - this.i, this.f13511e);
        b bVar = this.f13507a;
        String str = mVar.f13163h;
        int i = b0.f11647a;
        long j8 = mVar.f + this.i;
        u uVar = (u) bVar;
        synchronized (uVar) {
            try {
                uVar.d();
                k kVarK = uVar.f13561c.k(str);
                kVarK.getClass();
                s1.d.g(kVarK.a(j8, jMin));
                if (!uVar.f13559a.exists()) {
                    u.e(uVar.f13559a);
                    uVar.l();
                }
                r rVar = uVar.f13560b;
                if (jMin != -1) {
                    rVar.a(uVar, jMin);
                } else {
                    rVar.getClass();
                }
                File file = new File(uVar.f13559a, Integer.toString(uVar.f.nextInt(10)));
                if (!file.exists()) {
                    u.e(file);
                }
                fileC = v.c(file, kVarK.f13535a, j8, System.currentTimeMillis());
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f = fileC;
        FileOutputStream fileOutputStream = new FileOutputStream(this.f);
        if (this.f13509c > 0) {
            s sVar = this.f13514j;
            if (sVar == null) {
                this.f13514j = new s(fileOutputStream, this.f13509c);
            } else {
                sVar.a(fileOutputStream);
            }
            this.f13512g = this.f13514j;
        } else {
            this.f13512g = fileOutputStream;
        }
        this.f13513h = 0L;
    }
}
