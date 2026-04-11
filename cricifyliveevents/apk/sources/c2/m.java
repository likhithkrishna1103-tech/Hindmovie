package c2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Cipher f2029a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final SecretKeySpec f2030b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final vb.b f2031c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f2032d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public t f2033e;

    public m(File file) {
        this.f2031c = new vb.b(file);
    }

    public static int i(k kVar, int i) {
        int iHashCode = kVar.f2020b.hashCode() + (kVar.f2019a * 31);
        if (i < 2) {
            long jE = q4.a.e(kVar.f2023e);
            return (iHashCode * 31) + ((int) (jE ^ (jE >>> 32)));
        }
        return kVar.f2023e.hashCode() + (iHashCode * 31);
    }

    public static k j(int i, DataInputStream dataInputStream) throws IOException {
        q qVarA;
        int i10 = dataInputStream.readInt();
        String utf = dataInputStream.readUTF();
        if (i < 2) {
            long j4 = dataInputStream.readLong();
            g gVar = new g();
            gVar.a(Long.valueOf(j4), "exo_len");
            qVarA = q.f2040c.a(gVar);
        } else {
            qVarA = o.a(dataInputStream);
        }
        return new k(i10, utf, qVarA);
    }

    @Override // c2.n
    public final boolean a() {
        vb.b bVar = this.f2031c;
        return ((File) bVar.f13551w).exists() || ((File) bVar.f13552x).exists();
    }

    @Override // c2.n
    public final void b(HashMap map) throws Throwable {
        if (this.f2032d) {
            d(map);
        }
    }

    @Override // c2.n
    public final void c(k kVar) {
        this.f2032d = true;
    }

    @Override // c2.n
    public final void d(HashMap map) throws Throwable {
        DataOutputStream dataOutputStream;
        vb.b bVar = this.f2031c;
        DataOutputStream dataOutputStream2 = null;
        try {
            y1.a aVarK = bVar.k();
            t tVar = this.f2033e;
            if (tVar == null) {
                this.f2033e = new t(aVarK);
            } else {
                tVar.a(aVarK);
            }
            dataOutputStream = new DataOutputStream(this.f2033e);
        } catch (Throwable th) {
            th = th;
        }
        try {
            dataOutputStream.writeInt(2);
            dataOutputStream.writeInt(0);
            dataOutputStream.writeInt(map.size());
            int i = 0;
            for (k kVar : map.values()) {
                dataOutputStream.writeInt(kVar.f2019a);
                dataOutputStream.writeUTF(kVar.f2020b);
                o.b(kVar.f2023e, dataOutputStream);
                i += i(kVar, 2);
            }
            dataOutputStream.writeInt(i);
            dataOutputStream.close();
            ((File) bVar.f13552x).delete();
            int i10 = a0.f14551a;
            this.f2032d = false;
        } catch (Throwable th2) {
            th = th2;
            dataOutputStream2 = dataOutputStream;
            a0.g(dataOutputStream2);
            throw th;
        }
    }

    @Override // c2.n
    public final void f(k kVar, boolean z10) {
        this.f2032d = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x008f A[Catch: all -> 0x0078, IOException -> 0x007b, LOOP:0: B:37:0x008d->B:38:0x008f, LOOP_END, TryCatch #6 {IOException -> 0x007b, all -> 0x0078, blocks: (B:13:0x003f, B:18:0x0049, B:25:0x005b, B:26:0x0065, B:27:0x006c, B:34:0x0080, B:35:0x0085, B:36:0x0086, B:38:0x008f, B:39:0x00a5), top: B:58:0x003f }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00b1  */
    @Override // c2.n
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(java.util.HashMap r13, android.util.SparseArray r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 212
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: c2.m.g(java.util.HashMap, android.util.SparseArray):void");
    }

    @Override // c2.n
    public final void h() {
        vb.b bVar = this.f2031c;
        ((File) bVar.f13551w).delete();
        ((File) bVar.f13552x).delete();
    }

    @Override // c2.n
    public final void e(long j4) {
    }
}
