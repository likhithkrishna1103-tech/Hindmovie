package t4;

import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f12123a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ae.a f12124b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final ReentrantLock f12125c = new ReentrantLock();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public int f12126d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f12127e;
    public final f[] f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final se.h f12128g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final androidx.datastore.preferences.protobuf.i f12129h;

    public h(int i, ae.a aVar) {
        this.f12123a = i;
        this.f12124b = aVar;
        this.f = new f[i];
        int i10 = se.i.f11953a;
        this.f12128g = new se.h(i, 0);
        androidx.datastore.preferences.protobuf.i iVar = new androidx.datastore.preferences.protobuf.i();
        if (i < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        }
        if (i > 1073741824) {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
        i = Integer.bitCount(i) != 1 ? Integer.highestOneBit(i - 1) << 1 : i;
        iVar.f1066c = i - 1;
        iVar.f1067d = new Object[i];
        this.f12129h = iVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:26:0x0064, code lost:
    
        r0.e(r4, r9.f11952v);
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object a(td.c r9) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 237
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: t4.h.a(td.c):java.lang.Object");
    }

    public final void b() {
        ReentrantLock reentrantLock = this.f12125c;
        reentrantLock.lock();
        try {
            this.f12127e = true;
            for (f fVar : this.f) {
                if (fVar != null) {
                    fVar.close();
                }
            }
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(StringBuilder sb2) {
        androidx.datastore.preferences.protobuf.i iVar = this.f12129h;
        ReentrantLock reentrantLock = this.f12125c;
        reentrantLock.lock();
        try {
            pd.c cVarN = android.support.v4.media.session.b.n();
            int i = (iVar.f1065b - iVar.f1064a) & iVar.f1066c;
            for (int i10 = 0; i10 < i; i10++) {
                if (i10 >= 0) {
                    int i11 = iVar.f1065b;
                    int i12 = iVar.f1064a;
                    int i13 = iVar.f1066c;
                    if (i10 < ((i11 - i12) & i13)) {
                        Object obj = ((Object[]) iVar.f1067d)[(i12 + i10) & i13];
                        be.h.b(obj);
                        cVarN.add(obj);
                    }
                }
                throw new ArrayIndexOutOfBoundsException();
            }
            pd.c cVarC = android.support.v4.media.session.b.c(cVarN);
            sb2.append('\t' + toString() + " (");
            sb2.append("capacity=" + this.f12123a + ", ");
            StringBuilder sb3 = new StringBuilder();
            sb3.append("permits=");
            se.h hVar = this.f12128g;
            hVar.getClass();
            sb3.append(Math.max(se.g.A.get(hVar), 0));
            sb3.append(", ");
            sb2.append(sb3.toString());
            sb2.append("queue=(size=" + cVarC.b() + ")[" + od.i.b0(cVarC, null, null, null, null, 63) + "], ");
            sb2.append(")");
            sb2.append('\n');
            f[] fVarArr = this.f;
            int length = fVarArr.length;
            int i14 = 0;
            for (int i15 = 0; i15 < length; i15++) {
                f fVar = fVarArr[i15];
                i14++;
                StringBuilder sb4 = new StringBuilder();
                sb4.append("\t\t[");
                sb4.append(i14);
                sb4.append("] - ");
                sb4.append(fVar != null ? fVar.f12116u.toString() : null);
                sb2.append(sb4.toString());
                sb2.append('\n');
                if (fVar != null) {
                    fVar.v(sb2);
                }
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void d(f fVar) {
        be.h.e(fVar, "connection");
        ReentrantLock reentrantLock = this.f12125c;
        reentrantLock.lock();
        try {
            this.f12129h.a(fVar);
            reentrantLock.unlock();
            this.f12128g.c();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }
}
