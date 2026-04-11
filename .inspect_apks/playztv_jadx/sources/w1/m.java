package w1;

import bf.c0;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import s1.b0;
import ue.w;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f13545a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f13546b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f13547c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f13548d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Object f13549e;

    public m(ye.h hVar, ye.d dVar, ze.d dVar2) {
        be.h.e(dVar, "finder");
        this.f13546b = hVar;
        this.f13547c = dVar;
        this.f13548d = dVar2;
        this.f13549e = dVar2.h();
    }

    public static int j(k kVar, int i) {
        int iHashCode = kVar.f13536b.hashCode() + (kVar.f13535a * 31);
        if (i < 2) {
            long jD = e6.j.d(kVar.f13539e);
            return (iHashCode * 31) + ((int) (jD ^ (jD >>> 32)));
        }
        return kVar.f13539e.hashCode() + (iHashCode * 31);
    }

    public static k k(int i, DataInputStream dataInputStream) throws IOException {
        p pVarA;
        int i10 = dataInputStream.readInt();
        String utf = dataInputStream.readUTF();
        if (i < 2) {
            long j5 = dataInputStream.readLong();
            g gVar = new g();
            gVar.a(Long.valueOf(j5), "exo_len");
            pVarA = p.f13550c.a(gVar);
        } else {
            pVarA = b2.g.a(dataInputStream);
        }
        return new k(i10, utf, pVarA);
    }

    @Override // w1.n
    public void a(k kVar) {
        this.f13545a = true;
    }

    @Override // w1.n
    public void b(k kVar, boolean z2) {
        this.f13545a = true;
    }

    @Override // w1.n
    public boolean c() {
        pb.c cVar = (pb.c) this.f13548d;
        return ((File) cVar.f10310v).exists() || ((File) cVar.f10311w).exists();
    }

    @Override // w1.n
    public void d(HashMap map) throws Throwable {
        if (this.f13545a) {
            e(map);
        }
    }

    @Override // w1.n
    public void e(HashMap map) throws Throwable {
        DataOutputStream dataOutputStream;
        pb.c cVar = (pb.c) this.f13548d;
        DataOutputStream dataOutputStream2 = null;
        try {
            s1.a aVarO = cVar.o();
            s sVar = (s) this.f13549e;
            if (sVar == null) {
                this.f13549e = new s(aVarO);
            } else {
                sVar.a(aVarO);
            }
            dataOutputStream = new DataOutputStream((s) this.f13549e);
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(map.size());
            int iJ = 0;
            for (k kVar : map.values()) {
                dataOutputStream.writeInt(kVar.f13535a);
                dataOutputStream.writeUTF(kVar.f13536b);
                b2.g.b(kVar.f13539e, dataOutputStream);
                iJ += j(kVar, 2);
            }
            dataOutputStream.writeInt(iJ);
            dataOutputStream.close();
            ((File) cVar.f10311w).delete();
            int i = b0.f11647a;
            this.f13545a = false;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            b0.g(dataOutputStream2);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x0095 A[Catch: all -> 0x007e, IOException -> 0x0081, LOOP:0: B:36:0x0093->B:37:0x0095, LOOP_END, TryCatch #4 {IOException -> 0x0081, all -> 0x007e, blocks: (B:13:0x0045, B:18:0x004f, B:24:0x005f, B:25:0x0069, B:26:0x0072, B:33:0x0086, B:34:0x008b, B:35:0x008c, B:37:0x0095, B:38:0x00ab), top: B:61:0x0045 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7  */
    @Override // w1.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void g(java.util.HashMap r13, android.util.SparseArray r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 218
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: w1.m.g(java.util.HashMap, android.util.SparseArray):void");
    }

    @Override // w1.n
    public void h() {
        pb.c cVar = (pb.c) this.f13548d;
        ((File) cVar.f10310v).delete();
        ((File) cVar.f10311w).delete();
    }

    public IOException i(boolean z2, boolean z10, IOException iOException) {
        ye.h hVar = (ye.h) this.f13546b;
        if (iOException != null) {
            m(iOException);
        }
        return hVar.h(this, z10, z2, iOException);
    }

    public w l(boolean z2) throws IOException {
        try {
            w wVarG = ((ze.d) this.f13548d).g(z2);
            if (wVarG == null) {
                return wVarG;
            }
            wVarG.f13065m = this;
            return wVarG;
        } catch (IOException e10) {
            m(e10);
            throw e10;
        }
    }

    public void m(IOException iOException) {
        this.f13545a = true;
        ((ye.d) this.f13547c).c(iOException);
        ye.k kVarH = ((ze.d) this.f13548d).h();
        ye.h hVar = (ye.h) this.f13546b;
        synchronized (kVarH) {
            try {
                if (!(iOException instanceof c0)) {
                    if (!(kVarH.f14732g != null) || (iOException instanceof bf.a)) {
                        kVarH.f14734j = true;
                        if (kVarH.f14737m == 0) {
                            ye.k.d(hVar.f14718u, kVarH.f14728b, iOException);
                            kVarH.f14736l++;
                        }
                    }
                } else if (((c0) iOException).f2063u == 8) {
                    int i = kVarH.f14738n + 1;
                    kVarH.f14738n = i;
                    if (i > 1) {
                        kVarH.f14734j = true;
                        kVarH.f14736l++;
                    }
                } else if (((c0) iOException).f2063u != 9 || !hVar.G) {
                    kVarH.f14734j = true;
                    kVarH.f14736l++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public m(File file) {
        this.f13546b = null;
        this.f13547c = null;
        this.f13548d = new pb.c(file);
    }

    @Override // w1.n
    public void f(long j5) {
    }
}
