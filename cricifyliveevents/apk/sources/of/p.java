package of;

import f9.x0;
import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.NoSuchElementException;
import kf.a0;
import kf.b0;
import kf.c0;
import kf.v;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final nf.d f9836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final x0 f9837b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f9838c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f9839d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f9840e;
    public final int f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f9841g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f9842h;
    public final kf.a i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final m2.e f9843j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final n f9844k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f9845l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public t f9846m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public u f9847n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public c0 f9848o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final sd.h f9849p;

    public p(nf.d dVar, x0 x0Var, int i, int i10, int i11, int i12, boolean z10, boolean z11, kf.a aVar, m2.e eVar, n nVar, c2.o oVar) {
        ge.i.e(dVar, "taskRunner");
        ge.i.e(x0Var, "connectionPool");
        ge.i.e(eVar, "routeDatabase");
        this.f9836a = dVar;
        this.f9837b = x0Var;
        this.f9838c = i;
        this.f9839d = i10;
        this.f9840e = i11;
        this.f = i12;
        this.f9841g = z10;
        this.f9842h = z11;
        this.i = aVar;
        this.f9843j = eVar;
        this.f9844k = nVar;
        this.f9845l = !ge.i.a((String) oVar.f2036c, "GET");
        this.f9849p = new sd.h();
    }

    public final boolean a(o oVar) {
        u uVar;
        c0 c0Var;
        if (this.f9849p.isEmpty() && this.f9848o == null) {
            if (oVar != null) {
                synchronized (oVar) {
                    c0Var = null;
                    if (oVar.f9830l == 0 && oVar.f9828j && lf.f.a(oVar.f9823c.f7452a.f7432h, this.i.f7432h)) {
                        c0Var = oVar.f9823c;
                    }
                }
                if (c0Var != null) {
                    this.f9848o = c0Var;
                    return true;
                }
            }
            t tVar = this.f9846m;
            if ((tVar == null || tVar.f9855b >= tVar.f9854a.size()) && (uVar = this.f9847n) != null) {
                return uVar.a();
            }
        }
        return true;
    }

    public final s b() {
        Socket socketJ;
        q qVar;
        o oVar = this.f9844k.C;
        if (oVar == null) {
            qVar = null;
        } else {
            boolean zI = oVar.i(this.f9845l);
            synchronized (oVar) {
                try {
                    if (zI) {
                        socketJ = (oVar.f9828j || !f(oVar.f9823c.f7452a.f7432h)) ? this.f9844k.j() : null;
                    } else {
                        oVar.f9828j = true;
                        socketJ = this.f9844k.j();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (this.f9844k.C == null) {
                if (socketJ != null) {
                    lf.f.b(socketJ);
                }
                qVar = null;
            } else {
                if (socketJ != null) {
                    throw new IllegalStateException("Check failed.");
                }
                qVar = new q(oVar);
            }
        }
        if (qVar != null) {
            return qVar;
        }
        q qVarE = e(null, null);
        if (qVarE != null) {
            return qVarE;
        }
        if (!this.f9849p.isEmpty()) {
            return (s) this.f9849p.removeFirst();
        }
        d dVarC = c();
        q qVarE2 = e(dVarC, dVarC.f9788k);
        return qVarE2 != null ? qVarE2 : dVarC;
    }

    /* JADX WARN: Type inference failed for: r2v31, types: [java.lang.Object, java.util.List] */
    public final d c() throws IOException {
        String hostAddress;
        int port;
        List listA;
        boolean zContains;
        c0 c0Var = this.f9848o;
        if (c0Var != null) {
            this.f9848o = null;
            return d(c0Var, null);
        }
        t tVar = this.f9846m;
        if (tVar != null && tVar.f9855b < tVar.f9854a.size()) {
            int i = tVar.f9855b;
            ArrayList arrayList = tVar.f9854a;
            if (i >= arrayList.size()) {
                throw new NoSuchElementException();
            }
            int i10 = tVar.f9855b;
            tVar.f9855b = i10 + 1;
            return d((c0) arrayList.get(i10), null);
        }
        u uVar = this.f9847n;
        if (uVar == null) {
            uVar = new u(this.i, this.f9843j, this.f9844k, this.f9842h);
            this.f9847n = uVar;
        }
        if (!uVar.a()) {
            throw new IOException("exhausted all routes");
        }
        if (!uVar.a()) {
            throw new NoSuchElementException();
        }
        ArrayList arrayList2 = new ArrayList();
        while (uVar.f9860e < uVar.f9859d.size()) {
            kf.a aVar = uVar.f9856a;
            if (uVar.f9860e >= uVar.f9859d.size()) {
                throw new SocketException("No route to " + aVar.f7432h.f7518d + "; exhausted proxy configurations: " + uVar.f9859d);
            }
            List list = uVar.f9859d;
            int i11 = uVar.f9860e;
            uVar.f9860e = i11 + 1;
            Proxy proxy = (Proxy) list.get(i11);
            ArrayList arrayList3 = new ArrayList();
            uVar.f = arrayList3;
            if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
                kf.q qVar = aVar.f7432h;
                hostAddress = qVar.f7518d;
                port = qVar.f7519e;
            } else {
                SocketAddress socketAddressAddress = proxy.address();
                if (!(socketAddressAddress instanceof InetSocketAddress)) {
                    throw new IllegalArgumentException(("Proxy.address() is not an InetSocketAddress: " + socketAddressAddress.getClass()).toString());
                }
                InetSocketAddress inetSocketAddress = (InetSocketAddress) socketAddressAddress;
                InetAddress address = inetSocketAddress.getAddress();
                if (address == null) {
                    hostAddress = inetSocketAddress.getHostName();
                    ge.i.d(hostAddress, "getHostName(...)");
                } else {
                    hostAddress = address.getHostAddress();
                    ge.i.d(hostAddress, "getHostAddress(...)");
                }
                port = inetSocketAddress.getPort();
            }
            if (1 > port || port >= 65536) {
                throw new SocketException("No route to " + hostAddress + ':' + port + "; port is out of range");
            }
            if (proxy.type() == Proxy.Type.SOCKS) {
                arrayList3.add(InetSocketAddress.createUnresolved(hostAddress, port));
            } else {
                ne.g gVar = lf.c.f7959a;
                ge.i.e(hostAddress, "<this>");
                ne.g gVar2 = lf.c.f7959a;
                gVar2.getClass();
                if (gVar2.f9145v.matcher(hostAddress).matches()) {
                    listA = n5.a.x(InetAddress.getByName(hostAddress));
                } else {
                    aVar.f7426a.getClass();
                    try {
                        InetAddress[] allByName = InetAddress.getAllByName(hostAddress);
                        ge.i.d(allByName, "getAllByName(...)");
                        List listG = sd.i.G(allByName);
                        if (listG.isEmpty()) {
                            throw new UnknownHostException(aVar.f7426a + " returned no addresses for " + hostAddress);
                        }
                        listA = listG;
                    } catch (NullPointerException e9) {
                        UnknownHostException unknownHostException = new UnknownHostException("Broken system behaviour for dns lookup of ".concat(hostAddress));
                        unknownHostException.initCause(e9);
                        throw unknownHostException;
                    }
                }
                if (uVar.f9858c && listA.size() >= 2) {
                    ArrayList arrayList4 = new ArrayList();
                    ArrayList arrayList5 = new ArrayList();
                    for (Object obj : listA) {
                        if (((InetAddress) obj) instanceof Inet6Address) {
                            arrayList4.add(obj);
                        } else {
                            arrayList5.add(obj);
                        }
                    }
                    if (!arrayList4.isEmpty() && !arrayList5.isEmpty()) {
                        byte[] bArr = lf.d.f7960a;
                        Iterator it = arrayList4.iterator();
                        Iterator it2 = arrayList5.iterator();
                        td.c cVarH = n5.a.h();
                        while (true) {
                            if (!it.hasNext() && !it2.hasNext()) {
                                break;
                            }
                            if (it.hasNext()) {
                                cVarH.add(it.next());
                            }
                            if (it2.hasNext()) {
                                cVarH.add(it2.next());
                            }
                        }
                        listA = n5.a.a(cVarH);
                    }
                }
                Iterator it3 = listA.iterator();
                while (it3.hasNext()) {
                    arrayList3.add(new InetSocketAddress((InetAddress) it3.next(), port));
                }
            }
            Iterator it4 = uVar.f.iterator();
            while (it4.hasNext()) {
                c0 c0Var2 = new c0(uVar.f9856a, proxy, (InetSocketAddress) it4.next());
                m2.e eVar = uVar.f9857b;
                synchronized (eVar) {
                    zContains = ((LinkedHashSet) eVar.f8050v).contains(c0Var2);
                }
                if (zContains) {
                    uVar.f9861g.add(c0Var2);
                } else {
                    arrayList2.add(c0Var2);
                }
            }
            if (!arrayList2.isEmpty()) {
                break;
            }
        }
        if (arrayList2.isEmpty()) {
            sd.j.g0(uVar.f9861g, arrayList2);
            uVar.f9861g.clear();
        }
        t tVar2 = new t(arrayList2);
        this.f9846m = tVar2;
        if (this.f9844k.K) {
            throw new IOException("Canceled");
        }
        if (tVar2.f9855b >= arrayList2.size()) {
            throw new NoSuchElementException();
        }
        int i12 = tVar2.f9855b;
        tVar2.f9855b = i12 + 1;
        return d((c0) arrayList2.get(i12), arrayList2);
    }

    public final d d(c0 c0Var, ArrayList arrayList) throws UnknownServiceException {
        v vVar = v.B;
        ge.i.e(c0Var, "route");
        kf.a aVar = c0Var.f7452a;
        if (aVar.f7428c == null) {
            if (!aVar.f7433j.contains(kf.k.f)) {
                throw new UnknownServiceException("CLEARTEXT communication not enabled for client");
            }
            String str = c0Var.f7452a.f7432h.f7518d;
            uf.f fVar = uf.f.f12506a;
            if (!uf.f.f12506a.i(str)) {
                throw new UnknownServiceException(l0.e.k("CLEARTEXT communication to ", str, " not permitted by network security policy"));
            }
        } else if (aVar.i.contains(vVar)) {
            throw new UnknownServiceException("H2_PRIOR_KNOWLEDGE cannot be used with HTTPS");
        }
        c2.o oVar = null;
        if (c0Var.f7453b.type() == Proxy.Type.HTTP) {
            kf.a aVar2 = c0Var.f7452a;
            if (aVar2.f7428c != null || aVar2.i.contains(vVar)) {
                dd.c cVar = new dd.c();
                kf.q qVar = c0Var.f7452a.f7432h;
                ge.i.e(qVar, "url");
                cVar.f3672w = qVar;
                cVar.p("CONNECT", null);
                kf.a aVar3 = c0Var.f7452a;
                cVar.o("Host", lf.f.h(aVar3.f7432h, true));
                cVar.o("Proxy-Connection", "Keep-Alive");
                cVar.o("User-Agent", "okhttp/5.3.2");
                oVar = new c2.o(cVar);
                a0 a0Var = b0.f7439v;
                kf.o oVar2 = new kf.o(0);
                n5.a.t("Proxy-Authenticate");
                n5.a.u("OkHttp-Preemptive", "Proxy-Authenticate");
                oVar2.e("Proxy-Authenticate");
                n5.a.f(oVar2, "Proxy-Authenticate", "OkHttp-Preemptive");
                oVar2.b();
                ge.i.e(a0Var, "body");
                aVar3.f.getClass();
            }
        }
        return new d(this.f9836a, this.f9837b, this.f9838c, this.f9839d, this.f9840e, this.f, this.f9841g, this.f9844k, this, c0Var, arrayList, oVar, -1, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0045 A[Catch: all -> 0x0043, TryCatch #0 {all -> 0x0043, blocks: (B:14:0x0038, B:22:0x0045, B:25:0x004c), top: B:51:0x0038 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final of.q e(of.d r11, java.util.List r12) {
        /*
            r10 = this;
            f9.x0 r0 = r10.f9837b
            boolean r1 = r10.f9845l
            kf.a r2 = r10.i
            of.n r3 = r10.f9844k
            r4 = 0
            r5 = 1
            if (r11 == 0) goto L14
            boolean r6 = r11.b()
            if (r6 == 0) goto L14
            r6 = r5
            goto L15
        L14:
            r6 = r4
        L15:
            r0.getClass()
            java.lang.Object r0 = r0.f4474e
            java.util.concurrent.ConcurrentLinkedQueue r0 = (java.util.concurrent.ConcurrentLinkedQueue) r0
            java.util.Iterator r0 = r0.iterator()
            java.lang.String r7 = "iterator(...)"
            ge.i.d(r0, r7)
        L25:
            boolean r7 = r0.hasNext()
            r8 = 0
            if (r7 == 0) goto L6d
            java.lang.Object r7 = r0.next()
            of.o r7 = (of.o) r7
            ge.i.b(r7)
            monitor-enter(r7)
            if (r6 == 0) goto L45
            rf.q r9 = r7.i     // Catch: java.lang.Throwable -> L43
            if (r9 == 0) goto L3e
            r9 = r5
            goto L3f
        L3e:
            r9 = r4
        L3f:
            if (r9 != 0) goto L45
        L41:
            r9 = r4
            goto L50
        L43:
            r11 = move-exception
            goto L6b
        L45:
            boolean r9 = r7.g(r2, r12)     // Catch: java.lang.Throwable -> L43
            if (r9 != 0) goto L4c
            goto L41
        L4c:
            r3.b(r7)     // Catch: java.lang.Throwable -> L43
            r9 = r5
        L50:
            monitor-exit(r7)
            if (r9 == 0) goto L25
            boolean r9 = r7.i(r1)
            if (r9 == 0) goto L5a
            goto L6e
        L5a:
            monitor-enter(r7)
            r7.f9828j = r5     // Catch: java.lang.Throwable -> L68
            java.net.Socket r8 = r3.j()     // Catch: java.lang.Throwable -> L68
            monitor-exit(r7)
            if (r8 == 0) goto L25
            lf.f.b(r8)
            goto L25
        L68:
            r11 = move-exception
            monitor-exit(r7)
            throw r11
        L6b:
            monitor-exit(r7)
            throw r11
        L6d:
            r7 = r8
        L6e:
            if (r7 != 0) goto L71
            return r8
        L71:
            if (r11 == 0) goto L7e
            kf.c0 r12 = r11.f9787j
            r10.f9848o = r12
            java.net.Socket r11 = r11.f9794q
            if (r11 == 0) goto L7e
            lf.f.b(r11)
        L7e:
            of.q r11 = new of.q
            r11.<init>(r7)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: of.p.e(of.d, java.util.List):of.q");
    }

    public final boolean f(kf.q qVar) {
        ge.i.e(qVar, "url");
        kf.q qVar2 = this.i.f7432h;
        return qVar.f7519e == qVar2.f7519e && ge.i.a(qVar.f7518d, qVar2.f7518d);
    }
}
