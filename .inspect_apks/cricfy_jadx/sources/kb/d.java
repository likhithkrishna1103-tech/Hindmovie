package kb;

import android.content.ClipData;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import androidx.media3.ui.PlayerView;
import app.cricfy.tv.activities.SplashActivity;
import cc.e;
import e2.g;
import j5.i;
import j9.h;
import j9.p;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledFuture;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import nc.x;
import nc.z;
import p2.w;
import rc.f;
import t0.m0;
import t0.m1;
import t0.o;
import t0.p1;
import ua.f0;
import ua.i0;
import ua.z0;
import v1.g1;
import v2.l;
import w7.m;
import w7.u;
import x3.j;
import x3.k;
import x5.n;
import x5.t;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class d implements hc.a, j9.a, j9.d, w, t, h, l, o, y1.h, i, g {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f7398v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ Object f7399w;

    public /* synthetic */ d(int i, Object obj) {
        this.f7398v = i;
        this.f7399w = obj;
    }

    @Override // j9.d
    public void A(p pVar) {
        switch (this.f7398v) {
            case 2:
                x.b((Intent) this.f7399w);
                break;
            case 3:
                ((z) this.f7399w).f9110b.c(null);
                break;
            default:
                ((ScheduledFuture) this.f7399w).cancel(false);
                break;
        }
    }

    @Override // j9.h
    public p B(Object obj) {
        return vf.g.A((f) this.f7399w);
    }

    @Override // x5.t
    public void a() {
        SplashActivity splashActivity = (SplashActivity) this.f7399w;
        int i = SplashActivity.f1541g0;
        splashActivity.y();
    }

    @Override // y1.h
    public void accept(Object obj) {
        switch (this.f7398v) {
            case 19:
                k kVar = (k) this.f7399w;
                x3.c cVar = (x3.c) obj;
                j jVar = new j(cVar.f14293b, x3.b.b(cVar.f14292a, cVar.f14294c));
                kVar.f14304c.add(jVar);
                long j4 = kVar.f14309j;
                if (j4 == -9223372036854775807L || cVar.f14295d >= j4) {
                    kVar.b(jVar);
                }
                break;
            default:
                ((f0) this.f7399w).a((x3.c) obj);
                break;
        }
    }

    @Override // v2.l
    public z0 b(int i, g1 g1Var, int[] iArr) {
        v2.i iVar = (v2.i) this.f7399w;
        f0 f0VarJ = i0.j();
        for (int i10 = 0; i10 < g1Var.f12702a; i10++) {
            f0VarJ.a(new v2.f(i, g1Var, i10, iVar, iArr[i10]));
        }
        return f0VarJ.g();
    }

    @Override // j9.a
    public Object c(p pVar) {
        switch (this.f7398v) {
            case 1:
                ((CountDownLatch) this.f7399w).countDown();
                return null;
            case g1.h.STRING_FIELD_NUMBER /* 5 */:
                return (p) ((nb.j) this.f7399w).call();
            default:
                ((Runnable) this.f7399w).run();
                return vf.g.A(null);
        }
    }

    @Override // j5.i
    public void d() {
        new Thread(new n((x5.p) this.f7399w, 0)).start();
    }

    @Override // p2.w
    public int e(Object obj) {
        v1.p pVar = (v1.p) this.f7399w;
        p2.o oVar = (p2.o) obj;
        String str = oVar.f9926b;
        return ((str.equals(pVar.f12946n) || str.equals(p2.x.b(pVar))) && oVar.c(pVar, false) && oVar.d(pVar)) ? 1 : 0;
    }

    @Override // e2.g
    public void f(e2.h hVar) {
        y3.i iVar = (y3.i) this.f7399w;
        y3.h hVar2 = (y3.h) hVar;
        hVar2.clear();
        iVar.f14833b.add(hVar2);
    }

    public o2.f g(l7.a aVar) throws IOException {
        v7.b bVar = (v7.b) this.f7399w;
        URL url = (URL) aVar.f7866w;
        String strG = vf.g.G("CctTransportBackend");
        if (Log.isLoggable(strG, 4)) {
            Log.i(strG, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(bVar.f13506g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) aVar.f7868y;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    p6.c cVar = bVar.f13501a;
                    m mVar = (m) aVar.f7867x;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    cc.d dVar = (cc.d) cVar.f10035w;
                    e eVar = new e(bufferedWriter, dVar.f2133a, dVar.f2134b, dVar.f2135c, dVar.f2136d);
                    eVar.h(mVar);
                    eVar.j();
                    eVar.f2138b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String strG2 = vf.g.G("CctTransportBackend");
                    if (Log.isLoggable(strG2, 4)) {
                        Log.i(strG2, String.format("Status Code: %d", numValueOf));
                    }
                    vf.g.t("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    vf.g.t("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new o2.f(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new o2.f(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            o2.f fVar = new o2.f(responseCode, null, u.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f14105a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return fVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (ac.b e9) {
            e = e9;
            vf.g.x("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new o2.f(400, null, 0L);
        } catch (ConnectException e10) {
            e = e10;
            vf.g.x("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new o2.f(500, null, 0L);
        } catch (UnknownHostException e11) {
            e = e11;
            vf.g.x("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new o2.f(500, null, 0L);
        } catch (IOException e12) {
            e = e12;
            vf.g.x("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new o2.f(400, null, 0L);
        }
    }

    public boolean h(m2.e eVar, int i, Bundle bundle) {
        t0.c eVar2;
        o.t tVar = (o.t) this.f7399w;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 25 && (i & 1) != 0) {
            try {
                ((v0.g) eVar.f8050v).g();
                Parcelable parcelable = (Parcelable) ((v0.g) eVar.f8050v).c();
                bundle = bundle == null ? new Bundle() : new Bundle(bundle);
                bundle.putParcelable("androidx.core.view.extra.INPUT_CONTENT_INFO", parcelable);
            } catch (Exception e9) {
                Log.w("InputConnectionCompat", "Can't insert content from IME; requestPermission() failed", e9);
                return false;
            }
        }
        v0.g gVar = (v0.g) eVar.f8050v;
        ClipData clipData = new ClipData(gVar.a(), new ClipData.Item(gVar.f()));
        if (i10 >= 31) {
            eVar2 = new m2.e(clipData, 2);
        } else {
            t0.d dVar = new t0.d();
            dVar.f11738w = clipData;
            dVar.f11739x = 2;
            eVar2 = dVar;
        }
        eVar2.i(gVar.h());
        eVar2.setExtras(bundle);
        return m0.j(tVar, eVar2.build()) == null;
    }

    public void i(Drawable drawable, boolean z10) {
        switch (this.f7398v) {
            case 13:
                s5.g gVar = (s5.g) this.f7399w;
                ImageView imageView = gVar.f11487v;
                if (z10) {
                    gVar.f11486u.setVisibility(0);
                    imageView.setVisibility(0);
                    imageView.setImageDrawable(drawable);
                }
                break;
            default:
                x5.b bVar = (x5.b) this.f7399w;
                if (!z10) {
                    bVar.R();
                } else {
                    ((ImageView) bVar.f14330s0.f1800w).setVisibility(0);
                    ((PlayerView) bVar.f14330s0.f1801x).setVisibility(8);
                    ((ImageView) bVar.f14330s0.f1800w).setImageDrawable(drawable);
                }
                break;
        }
    }

    @Override // hc.a
    public void j(hc.b bVar) {
        b bVar2 = (b) this.f7399w;
        nc.p pVar = ((qc.i) ((tc.a) bVar.get())).a().f10794k;
        ((Set) pVar.f9072d).add(bVar2);
        p pVarB = ((rc.c) pVar.f9069a).b();
        pVarB.d((Executor) pVar.f9071c, new c8.b(pVar, pVarB, bVar2, 13));
        if (Log.isLoggable("FirebaseCrashlytics", 3)) {
            Log.d("FirebaseCrashlytics", "Registering RemoteConfig Rollouts subscriber", null);
        }
    }

    @Override // t0.o
    public p1 k(View view, p1 p1Var) {
        w0.g gVar = (w0.g) this.f7399w;
        ArrayList arrayList = gVar.f13774b;
        m1 m1Var = p1Var.f11791a;
        l0.c cVarB = l0.c.b(m1Var.f(519), m1Var.f(64));
        l0.c cVarB2 = l0.c.b(m1Var.g(519), m1Var.g(64));
        if (!cVarB.equals(gVar.f13775c) || !cVarB2.equals(gVar.f13776d)) {
            gVar.f13775c = cVarB;
            gVar.f13776d = cVarB2;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                w0.c cVar = (w0.c) arrayList.get(size);
                cVar.f13763c = cVarB;
                cVar.f13764d = cVarB2;
                cVar.c();
            }
        }
        return p1Var;
    }
}
