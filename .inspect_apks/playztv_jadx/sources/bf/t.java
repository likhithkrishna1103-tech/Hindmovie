package bf;

import com.google.android.gms.dynamite.descriptors.com.google.android.gms.measurement.dynamite.ModuleDescriptor;
import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class t implements Closeable {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Logger f2112x;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final hf.h f2113u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final s f2114v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final c f2115w;

    static {
        Logger logger = Logger.getLogger(f.class.getName());
        be.h.d(logger, "getLogger(Http2::class.java.name)");
        f2112x = logger;
    }

    public t(hf.q qVar) {
        be.h.e(qVar, "source");
        this.f2113u = qVar;
        s sVar = new s(qVar);
        this.f2114v = sVar;
        this.f2115w = new c(sVar);
    }

    public final void F(k kVar, int i, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i12 = 0;
        int i13 = 1;
        boolean z2 = (i10 & 1) != 0;
        if ((i10 & 8) != 0) {
            byte b10 = this.f2113u.readByte();
            byte[] bArr = ve.b.f13497a;
            i12 = b10 & 255;
        }
        if ((i10 & 32) != 0) {
            hf.h hVar = this.f2113u;
            hVar.readInt();
            hVar.readByte();
            byte[] bArr2 = ve.b.f13497a;
            i -= 5;
        }
        List listX = x(r.a(i, i10, i12), i12, i10, i11);
        p pVar = kVar.f2084v;
        if (i11 != 0 && (i11 & 1) == 0) {
            pVar.C.c(new m(pVar.f2095w + '[' + i11 + "] onHeaders", pVar, i11, listX, z2), 0L);
            return;
        }
        synchronized (pVar) {
            x xVarD = pVar.d(i11);
            if (xVarD != null) {
                xVarD.j(ve.b.t(listX), z2);
                return;
            }
            if (pVar.f2098z) {
                return;
            }
            if (i11 <= pVar.f2096x) {
                return;
            }
            if (i11 % 2 == pVar.f2097y % 2) {
                return;
            }
            x xVar = new x(i11, pVar, false, z2, ve.b.t(listX));
            pVar.f2096x = i11;
            pVar.f2094v.put(Integer.valueOf(i11), xVar);
            pVar.A.e().c(new i(pVar.f2095w + '[' + i11 + "] onStream", pVar, xVar, i13), 0L);
        }
    }

    public final void G(k kVar, int i, int i10, int i11) throws IOException {
        if (i != 8) {
            throw new IOException(e6.j.l("TYPE_PING length != 8: ", i));
        }
        if (i11 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        int i12 = this.f2113u.readInt();
        int i13 = this.f2113u.readInt();
        if (!((i10 & 1) != 0)) {
            kVar.f2084v.B.c(new j(l4.a.o(new StringBuilder(), kVar.f2084v.f2095w, " ping"), kVar.f2084v, i12, i13, 0), 0L);
            return;
        }
        p pVar = kVar.f2084v;
        synchronized (pVar) {
            try {
                if (i12 == 1) {
                    pVar.F++;
                } else if (i12 == 2) {
                    pVar.H++;
                } else if (i12 == 3) {
                    pVar.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void H(k kVar, int i, int i10, int i11) throws IOException {
        int i12;
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        if ((i10 & 8) != 0) {
            byte b10 = this.f2113u.readByte();
            byte[] bArr = ve.b.f13497a;
            i12 = b10 & 255;
        } else {
            i12 = 0;
        }
        int i13 = this.f2113u.readInt() & Integer.MAX_VALUE;
        List listX = x(r.a(i - 4, i10, i12), i12, i10, i11);
        p pVar = kVar.f2084v;
        synchronized (pVar) {
            if (pVar.S.contains(Integer.valueOf(i13))) {
                pVar.J(i13, 2);
                return;
            }
            pVar.S.add(Integer.valueOf(i13));
            pVar.C.c(new m(pVar.f2095w + '[' + i13 + "] onRequest", pVar, i13, listX), 0L);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x013c, code lost:
    
        throw new java.io.IOException(e6.j.l("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: ", r13));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r18, bf.k r19) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 616
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.t.a(boolean, bf.k):boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f2113u.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x010b, code lost:
    
        if (r8 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x010d, code lost:
    
        r4.j(ve.b.f13498b, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d(bf.k r19, int r20, int r21, int r22) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: bf.t.d(bf.k, int, int, int):void");
    }

    public final void v(k kVar, int i, int i10) throws IOException {
        int i11;
        Object[] array;
        if (i < 8) {
            throw new IOException(e6.j.l("TYPE_GOAWAY length < 8: ", i));
        }
        if (i10 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i12 = this.f2113u.readInt();
        int i13 = this.f2113u.readInt();
        int i14 = i - 8;
        int[] iArrD = v.e.d(14);
        int length = iArrD.length;
        int i15 = 0;
        while (true) {
            if (i15 >= length) {
                i11 = 0;
                break;
            }
            i11 = iArrD[i15];
            if (v.e.c(i11) == i13) {
                break;
            } else {
                i15++;
            }
        }
        if (i11 == 0) {
            throw new IOException(e6.j.l("TYPE_GOAWAY unexpected error code: ", i13));
        }
        hf.i iVarM = hf.i.f6114x;
        if (i14 > 0) {
            iVarM = this.f2113u.m(i14);
        }
        be.h.e(iVarM, "debugData");
        iVarM.a();
        p pVar = kVar.f2084v;
        synchronized (pVar) {
            array = pVar.f2094v.values().toArray(new x[0]);
            pVar.f2098z = true;
        }
        for (x xVar : (x[]) array) {
            if (xVar.f2127a > i12 && xVar.h()) {
                xVar.k(8);
                kVar.f2084v.x(xVar.f2127a);
            }
        }
    }

    public final List x(int i, int i10, int i11, int i12) throws IOException {
        s sVar = this.f2114v;
        sVar.f2110y = i;
        sVar.f2107v = i;
        sVar.f2111z = i10;
        sVar.f2108w = i11;
        sVar.f2109x = i12;
        c cVar = this.f2115w;
        hf.q qVar = cVar.f2059c;
        ArrayList arrayList = cVar.f2058b;
        while (!qVar.a()) {
            byte b10 = qVar.readByte();
            byte[] bArr = ve.b.f13497a;
            int i13 = b10 & 255;
            if (i13 == 128) {
                throw new IOException("index == 0");
            }
            if ((b10 & 128) == 128) {
                int iE = cVar.e(i13, ModuleDescriptor.MODULE_VERSION);
                int i14 = iE - 1;
                if (i14 >= 0) {
                    b[] bVarArr = e.f2071a;
                    if (i14 <= bVarArr.length - 1) {
                        arrayList.add(bVarArr[i14]);
                    }
                }
                int length = cVar.f2061e + 1 + (i14 - e.f2071a.length);
                if (length >= 0) {
                    b[] bVarArr2 = cVar.f2060d;
                    if (length < bVarArr2.length) {
                        b bVar = bVarArr2[length];
                        be.h.b(bVar);
                        arrayList.add(bVar);
                    }
                }
                throw new IOException(e6.j.l("Header index too large ", iE));
            }
            if (i13 == 64) {
                b[] bVarArr3 = e.f2071a;
                hf.i iVarD = cVar.d();
                e.a(iVarD);
                cVar.c(new b(iVarD, cVar.d()));
            } else if ((b10 & 64) == 64) {
                cVar.c(new b(cVar.b(cVar.e(i13, 63) - 1), cVar.d()));
            } else if ((b10 & 32) == 32) {
                int iE2 = cVar.e(i13, 31);
                cVar.f2057a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + cVar.f2057a);
                }
                int i15 = cVar.f2062g;
                if (iE2 < i15) {
                    if (iE2 == 0) {
                        b[] bVarArr4 = cVar.f2060d;
                        od.h.W(bVarArr4, 0, bVarArr4.length);
                        cVar.f2061e = cVar.f2060d.length - 1;
                        cVar.f = 0;
                        cVar.f2062g = 0;
                    } else {
                        cVar.a(i15 - iE2);
                    }
                }
            } else if (i13 == 16 || i13 == 0) {
                b[] bVarArr5 = e.f2071a;
                hf.i iVarD2 = cVar.d();
                e.a(iVarD2);
                arrayList.add(new b(iVarD2, cVar.d()));
            } else {
                arrayList.add(new b(cVar.b(cVar.e(i13, 15) - 1), cVar.d()));
            }
        }
        List listH0 = od.i.h0(arrayList);
        arrayList.clear();
        return listH0;
    }
}
