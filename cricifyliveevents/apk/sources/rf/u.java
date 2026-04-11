package rf;

import java.io.Closeable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class u implements Closeable {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Logger f11120y;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ag.g f11121v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t f11122w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final e f11123x;

    static {
        Logger logger = Logger.getLogger(h.class.getName());
        ge.i.d(logger, "getLogger(...)");
        f11120y = logger;
    }

    public u(ag.q qVar) {
        ge.i.e(qVar, "source");
        this.f11121v = qVar;
        t tVar = new t(qVar);
        this.f11122w = tVar;
        this.f11123x = new e(tVar);
    }

    public final void A(p pVar, int i, int i10, int i11) throws IOException {
        if (i != 8) {
            throw new IOException(l0.e.g(i, "TYPE_PING length != 8: "));
        }
        if (i11 != 0) {
            throw new IOException("TYPE_PING streamId != 0");
        }
        final int i12 = this.f11121v.readInt();
        final int i13 = this.f11121v.readInt();
        if (!((i10 & 1) != 0)) {
            nf.c cVar = pVar.f11102w.C;
            String strQ = q4.a.q(new StringBuilder(), pVar.f11102w.f11105x, " ping");
            final q qVar = pVar.f11102w;
            nf.c.c(cVar, strQ, new fe.a() { // from class: rf.o
                @Override // fe.a
                public final Object b() {
                    q qVar2 = qVar;
                    try {
                        qVar2.R.A(i12, i13, true);
                    } catch (IOException e9) {
                        b bVar = b.f11050y;
                        qVar2.a(bVar, bVar, e9);
                    }
                    return rd.l.f11003a;
                }
            });
            return;
        }
        q qVar2 = pVar.f11102w;
        synchronized (qVar2) {
            try {
                if (i12 == 1) {
                    qVar2.G++;
                } else if (i12 == 2) {
                    qVar2.I++;
                } else if (i12 == 3) {
                    qVar2.notifyAll();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void C(p pVar, int i, int i10, int i11) throws IOException {
        int i12;
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0");
        }
        int i13 = 0;
        if ((i10 & 8) != 0) {
            byte b8 = this.f11121v.readByte();
            byte[] bArr = lf.d.f7960a;
            i12 = b8 & 255;
        } else {
            i12 = 0;
        }
        int i14 = this.f11121v.readInt() & Integer.MAX_VALUE;
        List listS = s(s.a(i - 4, i10, i12), i12, i10, i11);
        q qVar = pVar.f11102w;
        synchronized (qVar) {
            if (qVar.T.contains(Integer.valueOf(i14))) {
                qVar.J(i14, b.f11050y);
                return;
            }
            qVar.T.add(Integer.valueOf(i14));
            nf.c.c(qVar.D, qVar.f11105x + '[' + i14 + "] onRequest", new l(qVar, i14, listS, i13));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0149, code lost:
    
        throw new java.io.IOException(l0.e.g(r7, "PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: "));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean a(boolean r13, rf.p r14) throws java.lang.Exception {
        /*
            Method dump skipped, instruction units count: 610
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.u.a(boolean, rf.p):boolean");
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.f11121v.close();
    }

    /* JADX WARN: Code restructure failed: missing block: B:64:0x0117, code lost:
    
        if (r19 == false) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x0119, code lost:
    
        r9.j(kf.p.f7513w, true);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(rf.p r17, int r18, int r19, final int r20) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 310
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: rf.u.g(rf.p, int, int, int):void");
    }

    public final void q(p pVar, int i, int i10) throws IOException {
        b bVar;
        Object[] array;
        if (i < 8) {
            throw new IOException(l0.e.g(i, "TYPE_GOAWAY length < 8: "));
        }
        if (i10 != 0) {
            throw new IOException("TYPE_GOAWAY streamId != 0");
        }
        int i11 = this.f11121v.readInt();
        int i12 = this.f11121v.readInt();
        int i13 = i - 8;
        b.f11048w.getClass();
        b[] bVarArrValues = b.values();
        int length = bVarArrValues.length;
        int i14 = 0;
        while (true) {
            if (i14 >= length) {
                bVar = null;
                break;
            }
            bVar = bVarArrValues[i14];
            if (bVar.f11052v == i12) {
                break;
            } else {
                i14++;
            }
        }
        if (bVar == null) {
            throw new IOException(l0.e.g(i12, "TYPE_GOAWAY unexpected error code: "));
        }
        ag.h hVarK = ag.h.f430y;
        if (i13 > 0) {
            hVarK = this.f11121v.k(i13);
        }
        ge.i.e(hVarK, "debugData");
        hVarK.a();
        q qVar = pVar.f11102w;
        synchronized (qVar) {
            array = qVar.f11104w.values().toArray(new y[0]);
            qVar.A = true;
        }
        for (y yVar : (y[]) array) {
            if (yVar.f11134v > i11 && yVar.h()) {
                yVar.k(b.B);
                pVar.f11102w.s(yVar.f11134v);
            }
        }
    }

    public final List s(int i, int i10, int i11, int i12) throws IOException {
        t tVar = this.f11122w;
        tVar.f11119z = i;
        tVar.f11116w = i;
        tVar.A = i10;
        tVar.f11117x = i11;
        tVar.f11118y = i12;
        e eVar = this.f11123x;
        ag.q qVar = eVar.f11067c;
        ArrayList arrayList = eVar.f11066b;
        while (!qVar.a()) {
            byte b8 = qVar.readByte();
            byte[] bArr = lf.d.f7960a;
            int i13 = b8 & 255;
            if (i13 == 128) {
                throw new IOException("index == 0");
            }
            if ((b8 & 128) == 128) {
                int iE = eVar.e(i13, 127);
                int i14 = iE - 1;
                if (i14 >= 0) {
                    d[] dVarArr = g.f11078a;
                    if (i14 <= dVarArr.length - 1) {
                        arrayList.add(dVarArr[i14]);
                    }
                }
                int length = eVar.f11069e + 1 + (i14 - g.f11078a.length);
                if (length >= 0) {
                    d[] dVarArr2 = eVar.f11068d;
                    if (length < dVarArr2.length) {
                        d dVar = dVarArr2[length];
                        ge.i.b(dVar);
                        arrayList.add(dVar);
                    }
                }
                throw new IOException(l0.e.g(iE, "Header index too large "));
            }
            if (i13 == 64) {
                d[] dVarArr3 = g.f11078a;
                ag.h hVarD = eVar.d();
                g.a(hVarD);
                eVar.c(new d(hVarD, eVar.d()));
            } else if ((b8 & 64) == 64) {
                eVar.c(new d(eVar.b(eVar.e(i13, 63) - 1), eVar.d()));
            } else if ((b8 & 32) == 32) {
                int iE2 = eVar.e(i13, 31);
                eVar.f11065a = iE2;
                if (iE2 < 0 || iE2 > 4096) {
                    throw new IOException("Invalid dynamic table size update " + eVar.f11065a);
                }
                int i15 = eVar.f11070g;
                if (iE2 < i15) {
                    if (iE2 == 0) {
                        d[] dVarArr4 = eVar.f11068d;
                        sd.i.p(dVarArr4, 0, dVarArr4.length);
                        eVar.f11069e = eVar.f11068d.length - 1;
                        eVar.f = 0;
                        eVar.f11070g = 0;
                    } else {
                        eVar.a(i15 - iE2);
                    }
                }
            } else if (i13 == 16 || i13 == 0) {
                d[] dVarArr5 = g.f11078a;
                ag.h hVarD2 = eVar.d();
                g.a(hVarD2);
                arrayList.add(new d(hVarD2, eVar.d()));
            } else {
                arrayList.add(new d(eVar.b(eVar.e(i13, 15) - 1), eVar.d()));
            }
        }
        List listR0 = sd.j.r0(arrayList);
        arrayList.clear();
        return listR0;
    }

    public final void z(p pVar, int i, int i10, int i11) throws IOException {
        if (i11 == 0) {
            throw new IOException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0");
        }
        int i12 = 0;
        boolean z10 = (i10 & 1) != 0;
        if ((i10 & 8) != 0) {
            byte b8 = this.f11121v.readByte();
            byte[] bArr = lf.d.f7960a;
            i12 = b8 & 255;
        }
        if ((i10 & 32) != 0) {
            ag.g gVar = this.f11121v;
            gVar.readInt();
            gVar.readByte();
            byte[] bArr2 = lf.d.f7960a;
            i -= 5;
        }
        List listS = s(s.a(i, i10, i12), i12, i10, i11);
        q qVar = pVar.f11102w;
        if (i11 != 0 && (i11 & 1) == 0) {
            nf.c.c(qVar.D, qVar.f11105x + '[' + i11 + "] onHeaders", new l(qVar, i11, listS, z10));
            return;
        }
        synchronized (qVar) {
            y yVarG = qVar.g(i11);
            if (yVarG != null) {
                yVarG.j(lf.f.g(listS), z10);
                return;
            }
            if (qVar.A) {
                return;
            }
            if (i11 <= qVar.f11106y) {
                return;
            }
            if (i11 % 2 == qVar.f11107z % 2) {
                return;
            }
            y yVar = new y(i11, qVar, false, z10, lf.f.g(listS));
            qVar.f11106y = i11;
            qVar.f11104w.put(Integer.valueOf(i11), yVar);
            nf.c.c(qVar.B.d(), qVar.f11105x + '[' + i11 + "] onStream", new ff.h(3, qVar, yVar));
        }
    }
}
