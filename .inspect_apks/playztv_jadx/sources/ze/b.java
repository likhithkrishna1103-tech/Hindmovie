package ze;

import be.h;
import hf.q;
import java.io.IOException;
import java.net.ProtocolException;
import ue.p;
import ue.v;
import ue.w;
import ue.x;
import ue.z;
import w1.m;
import ye.k;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class b implements p {
    @Override // ue.p
    public final x a(f fVar) throws Throwable {
        w wVarL;
        IOException iOException;
        m mVar = fVar.f14970d;
        h.b(mVar);
        ye.h hVar = (ye.h) mVar.f13546b;
        d dVar = (d) mVar.f13548d;
        k kVar = (k) mVar.f13549e;
        b2.g gVar = fVar.f14971e;
        v vVar = (v) gVar.f1740e;
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                dVar.e(gVar);
                boolean z2 = true;
                try {
                    if (!android.support.v4.media.session.b.L((String) gVar.f1738c) || vVar == null) {
                        hVar.h(mVar, true, false, null);
                        wVarL = null;
                    } else {
                        if ("100-continue".equalsIgnoreCase(((ue.m) gVar.f1739d).b("Expect"))) {
                            try {
                                dVar.c();
                                wVarL = mVar.l(true);
                            } catch (IOException e10) {
                                mVar.m(e10);
                                throw e10;
                            }
                        } else {
                            wVarL = null;
                        }
                        if (wVarL == null) {
                            h.b(vVar);
                            long jC = vVar.c();
                            hf.p pVar = new hf.p(new ye.b(mVar, dVar.f(gVar, jC), jC));
                            vVar.n(pVar);
                            pVar.close();
                        } else {
                            hVar.h(mVar, true, false, null);
                            if (kVar.f14732g == null) {
                                z2 = false;
                            }
                            if (!z2) {
                                dVar.h().l();
                            }
                        }
                    }
                    try {
                        dVar.b();
                        iOException = null;
                    } catch (IOException e11) {
                        mVar.m(e11);
                        throw e11;
                    }
                } catch (IOException e12) {
                    e = e12;
                    if ((e instanceof bf.a) || !mVar.f13545a) {
                        throw e;
                    }
                    iOException = e;
                }
            } catch (IOException e13) {
                mVar.m(e13);
                throw e13;
            }
        } catch (IOException e14) {
            e = e14;
            wVarL = null;
        }
        if (wVarL == null) {
            try {
                wVarL = mVar.l(false);
                h.b(wVarL);
            } catch (IOException e15) {
                if (iOException == null) {
                    throw e15;
                }
                com.bumptech.glide.d.d(iOException, e15);
                throw iOException;
            }
        }
        wVarL.f13055a = gVar;
        wVarL.f13059e = kVar.f14731e;
        wVarL.f13063k = jCurrentTimeMillis;
        wVarL.f13064l = System.currentTimeMillis();
        x xVarA = wVarL.a();
        int i = xVarA.f13069x;
        if (i == 100 || (102 <= i && i < 200)) {
            w wVarL2 = mVar.l(false);
            h.b(wVarL2);
            wVarL2.f13055a = gVar;
            wVarL2.f13059e = kVar.f14731e;
            wVarL2.f13063k = jCurrentTimeMillis;
            wVarL2.f13064l = System.currentTimeMillis();
            xVarA = wVarL2.a();
            i = xVarA.f13069x;
        }
        w wVarD = xVarA.d();
        try {
            String strA = x.a("Content-Type", xVarA);
            long jA = dVar.a(xVarA);
            wVarD.f13060g = new g(strA, jA, new q(new ye.c(mVar, dVar.d(xVarA), jA)));
            x xVarA2 = wVarD.a();
            if ("close".equalsIgnoreCase(((ue.m) xVarA2.f13066u.f1739d).b("Connection")) || "close".equalsIgnoreCase(x.a("Connection", xVarA2))) {
                dVar.h().l();
            }
            if (i == 204 || i == 205) {
                z zVar = xVarA2.A;
                if ((zVar != null ? zVar.a() : -1L) > 0) {
                    StringBuilder sb2 = new StringBuilder("HTTP ");
                    sb2.append(i);
                    sb2.append(" had non-zero Content-Length: ");
                    z zVar2 = xVarA2.A;
                    sb2.append(zVar2 != null ? Long.valueOf(zVar2.a()) : null);
                    throw new ProtocolException(sb2.toString());
                }
            }
            return xVarA2;
        } catch (IOException e16) {
            mVar.m(e16);
            throw e16;
        }
    }
}
