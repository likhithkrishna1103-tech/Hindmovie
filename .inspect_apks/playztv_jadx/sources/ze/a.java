package ze;

import androidx.media3.decoder.DecoderInputBuffer;
import be.h;
import hf.k;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.net.ssl.SSLSocketFactory;
import k8.t0;
import od.i;
import ue.m;
import ue.o;
import ue.p;
import ue.q;
import ue.s;
import ue.v;
import ue.w;
import ue.x;
import ue.z;
import ye.l;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class a implements p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14964a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f14965b;

    public a(ue.b bVar) {
        h.e(bVar, "cookieJar");
        this.f14965b = bVar;
    }

    public static int d(x xVar, int i) {
        String strA = x.a("Retry-After", xVar);
        if (strA == null) {
            return i;
        }
        Pattern patternCompile = Pattern.compile("\\d+");
        h.d(patternCompile, "compile(...)");
        if (!patternCompile.matcher(strA).matches()) {
            return Integer.MAX_VALUE;
        }
        Integer numValueOf = Integer.valueOf(strA);
        h.d(numValueOf, "valueOf(header)");
        return numValueOf.intValue();
    }

    @Override // ue.p
    public final x a(f fVar) {
        z zVar;
        SSLSocketFactory sSLSocketFactory;
        gf.c cVar;
        ue.f fVar2;
        switch (this.f14964a) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ue.b bVar = (ue.b) this.f14965b;
                b2.g gVar = fVar.f14971e;
                m mVar = (m) gVar.f1739d;
                zc.c cVarT = gVar.t();
                o oVar = (o) gVar.f1737b;
                v vVar = (v) gVar.f1740e;
                if (vVar != null) {
                    q qVarD = vVar.d();
                    if (qVarD != null) {
                        cVarT.p("Content-Type", qVarD.f13017a);
                    }
                    long jC = vVar.c();
                    if (jC != -1) {
                        cVarT.p("Content-Length", String.valueOf(jC));
                        ((q2.d) cVarT.f14947w).i("Transfer-Encoding");
                    } else {
                        cVarT.p("Transfer-Encoding", "chunked");
                        ((q2.d) cVarT.f14947w).i("Content-Length");
                    }
                }
                boolean z2 = false;
                if (mVar.b("Host") == null) {
                    cVarT.p("Host", ve.b.u(oVar, false));
                }
                if (mVar.b("Connection") == null) {
                    cVarT.p("Connection", "Keep-Alive");
                }
                if (mVar.b("Accept-Encoding") == null && mVar.b("Range") == null) {
                    cVarT.p("Accept-Encoding", "gzip");
                    z2 = true;
                }
                bVar.getClass();
                h.e(oVar, "url");
                if (mVar.b("User-Agent") == null) {
                    cVarT.p("User-Agent", "okhttp/4.12.0");
                }
                x xVarB = fVar.b(cVarT.m());
                m mVar2 = xVarB.f13071z;
                e.b(bVar, oVar, mVar2);
                w wVarD = xVarB.d();
                wVarD.f13055a = gVar;
                if (z2 && "gzip".equalsIgnoreCase(x.a("Content-Encoding", xVarB)) && e.a(xVarB) && (zVar = xVarB.A) != null) {
                    k kVar = new k(zVar.v());
                    q2.d dVarE = mVar2.e();
                    dVarE.i("Content-Encoding");
                    dVarE.i("Content-Length");
                    wVarD.f = dVarE.g().e();
                    wVarD.f13060g = new g(x.a("Content-Type", xVarB), -1L, new hf.q(kVar));
                }
                return wVarD.a();
            default:
                b2.g gVar2 = fVar.f14971e;
                ye.h hVar = fVar.f14967a;
                List listD0 = od.q.f9570u;
                x xVar = null;
                int i = 0;
                b2.g gVarB = gVar2;
                while (true) {
                    boolean z10 = true;
                    while (hVar.C == null) {
                        synchronized (hVar) {
                            try {
                                if (hVar.E) {
                                    throw new IllegalStateException("cannot make a new request because the previous response is still open: please call response.close()");
                                }
                                if (hVar.D) {
                                    throw new IllegalStateException("Check failed.");
                                }
                            } catch (Throwable th) {
                                throw th;
                            }
                        }
                        if (z10) {
                            t0 t0Var = hVar.f14720w;
                            o oVar2 = (o) gVarB.f1737b;
                            s sVar = hVar.f14718u;
                            if (oVar2.i) {
                                SSLSocketFactory sSLSocketFactory2 = sVar.I;
                                if (sSLSocketFactory2 == null) {
                                    throw new IllegalStateException("CLEARTEXT-only client");
                                }
                                gf.c cVar2 = sVar.M;
                                fVar2 = sVar.N;
                                sSLSocketFactory = sSLSocketFactory2;
                                cVar = cVar2;
                            } else {
                                sSLSocketFactory = null;
                                cVar = null;
                                fVar2 = null;
                            }
                            hVar.A = new ye.d(t0Var, new ue.a(oVar2.f13011d, oVar2.f13012e, sVar.E, sVar.H, sSLSocketFactory, cVar, fVar2, sVar.G, sVar.L, sVar.K, sVar.F), hVar);
                        }
                        try {
                            if (hVar.G) {
                                throw new IOException("Canceled");
                            }
                            try {
                                try {
                                    x xVarB2 = fVar.b(gVarB);
                                    if (xVar != null) {
                                        w wVarD2 = xVarB2.d();
                                        w wVarD3 = xVar.d();
                                        wVarD3.f13060g = null;
                                        x xVarA = wVarD3.a();
                                        if (xVarA.A != null) {
                                            throw new IllegalArgumentException("priorResponse.body != null");
                                        }
                                        wVarD2.f13062j = xVarA;
                                        xVarB2 = wVarD2.a();
                                    }
                                    xVar = xVarB2;
                                    gVarB = b(xVar, hVar.C);
                                    if (gVarB == null) {
                                        hVar.f(false);
                                        return xVar;
                                    }
                                    z zVar2 = xVar.A;
                                    if (zVar2 != null) {
                                        ve.b.c(zVar2);
                                    }
                                    i++;
                                    if (i > 20) {
                                        throw new ProtocolException("Too many follow-up requests: " + i);
                                    }
                                    hVar.f(true);
                                } catch (IOException e10) {
                                    if (!c(e10, hVar, gVarB, !(e10 instanceof bf.a))) {
                                        Iterator it = listD0.iterator();
                                        while (it.hasNext()) {
                                            com.bumptech.glide.d.d(e10, (Exception) it.next());
                                        }
                                        throw e10;
                                    }
                                    listD0 = i.d0(listD0, e10);
                                    hVar.f(true);
                                    z10 = false;
                                }
                            } catch (l e11) {
                                if (!c(e11.f14743v, hVar, gVarB, false)) {
                                    IOException iOException = e11.f14742u;
                                    h.e(iOException, "<this>");
                                    Iterator it2 = listD0.iterator();
                                    while (it2.hasNext()) {
                                        com.bumptech.glide.d.d(iOException, (Exception) it2.next());
                                    }
                                    throw iOException;
                                }
                                listD0 = i.d0(listD0, e11.f14742u);
                                hVar.f(true);
                                z10 = false;
                            }
                        } catch (Throwable th2) {
                            hVar.f(true);
                            throw th2;
                        }
                    }
                    throw new IllegalStateException("Check failed.");
                }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:66:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public b2.g b(ue.x r12, w1.m r13) throws java.net.ProtocolException {
        /*
            Method dump skipped, instruction units count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: ze.a.b(ue.x, w1.m):b2.g");
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0085  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean c(java.io.IOException r4, ye.h r5, b2.g r6, boolean r7) {
        /*
            r3 = this;
            java.lang.Object r6 = r3.f14965b
            ue.s r6 = (ue.s) r6
            boolean r6 = r6.f13045z
            r0 = 0
            if (r6 != 0) goto Lb
            goto L9d
        Lb:
            if (r7 == 0) goto L12
            boolean r6 = r4 instanceof java.io.FileNotFoundException
            if (r6 == 0) goto L12
            return r0
        L12:
            boolean r6 = r4 instanceof java.net.ProtocolException
            if (r6 == 0) goto L17
            return r0
        L17:
            boolean r6 = r4 instanceof java.io.InterruptedIOException
            if (r6 == 0) goto L22
            boolean r4 = r4 instanceof java.net.SocketTimeoutException
            if (r4 == 0) goto L9d
            if (r7 != 0) goto L9d
            goto L35
        L22:
            boolean r6 = r4 instanceof javax.net.ssl.SSLHandshakeException
            if (r6 == 0) goto L30
            java.lang.Throwable r6 = r4.getCause()
            boolean r6 = r6 instanceof java.security.cert.CertificateException
            if (r6 == 0) goto L30
            goto L9d
        L30:
            boolean r4 = r4 instanceof javax.net.ssl.SSLPeerUnverifiedException
            if (r4 == 0) goto L35
            return r0
        L35:
            ye.d r4 = r5.A
            be.h.b(r4)
            int r5 = r4.f
            r6 = 1
            if (r5 != 0) goto L49
            int r7 = r4.f14711g
            if (r7 != 0) goto L49
            int r7 = r4.f14712h
            if (r7 != 0) goto L49
            r4 = r0
            goto L9b
        L49:
            ue.a0 r7 = r4.i
            if (r7 == 0) goto L4e
            goto L96
        L4e:
            r7 = 0
            if (r5 > r6) goto L81
            int r5 = r4.f14711g
            if (r5 > r6) goto L81
            int r5 = r4.f14712h
            if (r5 <= 0) goto L5a
            goto L81
        L5a:
            ye.h r5 = r4.f14708c
            ye.k r5 = r5.B
            if (r5 != 0) goto L61
            goto L81
        L61:
            monitor-enter(r5)
            int r1 = r5.f14736l     // Catch: java.lang.Throwable -> L7e
            if (r1 == 0) goto L68
            monitor-exit(r5)
            goto L81
        L68:
            ue.a0 r1 = r5.f14728b     // Catch: java.lang.Throwable -> L7e
            ue.a r1 = r1.f12931a     // Catch: java.lang.Throwable -> L7e
            ue.o r1 = r1.f12929h     // Catch: java.lang.Throwable -> L7e
            ue.a r2 = r4.f14707b     // Catch: java.lang.Throwable -> L7e
            ue.o r2 = r2.f12929h     // Catch: java.lang.Throwable -> L7e
            boolean r1 = ve.b.a(r1, r2)     // Catch: java.lang.Throwable -> L7e
            if (r1 != 0) goto L7a
            monitor-exit(r5)
            goto L81
        L7a:
            ue.a0 r7 = r5.f14728b     // Catch: java.lang.Throwable -> L7e
            monitor-exit(r5)
            goto L81
        L7e:
            r4 = move-exception
            monitor-exit(r5)
            throw r4
        L81:
            if (r7 == 0) goto L87
            r4.i = r7
        L85:
            r4 = r6
            goto L9b
        L87:
            va.o r5 = r4.f14709d
            if (r5 == 0) goto L92
            boolean r5 = r5.b()
            if (r5 != r6) goto L92
            goto L96
        L92:
            n.p r4 = r4.f14710e
            if (r4 != 0) goto L97
        L96:
            goto L85
        L97:
            boolean r4 = r4.l()
        L9b:
            if (r4 != 0) goto L9e
        L9d:
            return r0
        L9e:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: ze.a.c(java.io.IOException, ye.h, b2.g, boolean):boolean");
    }

    public a(s sVar) {
        this.f14965b = sVar;
    }
}
