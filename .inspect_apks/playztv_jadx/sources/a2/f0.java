package a2;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Surface;
import android.widget.ImageView;
import androidx.media3.decoder.DecoderInputBuffer;
import com.playz.tv.activities.SplashActivity;
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
import java.util.HashMap;
import java.util.Iterator;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f0 implements s1.m, w2.h, t1.t, g4.a0, g4.e1, s1.h, g4.c1, nc.w, k7.b, pc.k, j2.x {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f219u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ Object f220v;

    public /* synthetic */ f0(int i, Object obj) {
        this.f219u = i;
        this.f220v = obj;
    }

    @Override // s1.m
    public void a(Object obj) {
        switch (this.f219u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                ((p1.u0) obj).N((p1.l1) this.f220v);
                break;
            case 1:
                ((p1.u0) obj).w((p1.d) this.f220v);
                break;
            case 2:
                ((p1.u0) obj).x((r1.c) this.f220v);
                break;
            case 3:
                ((p1.u0) obj).n(((l0) this.f220v).f312u.f350i0);
                break;
            case b1.j.LONG_FIELD_NUMBER /* 4 */:
                ((p1.u0) obj).v((p1.l0) this.f220v);
                break;
            case b1.j.STRING_FIELD_NUMBER /* 5 */:
            case b1.j.STRING_SET_FIELD_NUMBER /* 6 */:
            default:
                o2.z zVar = (o2.z) this.f220v;
                b2.n nVar = (b2.n) obj;
                nVar.getClass();
                nVar.f1783w = zVar.f9255a;
                break;
            case b1.j.DOUBLE_FIELD_NUMBER /* 7 */:
                ((b2.n) obj).f1775o = (p1.p0) this.f220v;
                break;
            case 8:
                h hVar = (h) this.f220v;
                b2.n nVar2 = (b2.n) obj;
                nVar2.f1785y += hVar.f249g;
                nVar2.f1786z += hVar.f248e;
                break;
        }
    }

    @Override // s1.h
    public void accept(Object obj) {
        switch (this.f219u) {
            case 17:
                ((g4.j1) obj).e((p1.q0) this.f220v);
                break;
            default:
                ((g4.j1) obj).n((Surface) this.f220v);
                break;
        }
    }

    @Override // g4.a0
    public void b(g4.r rVar, int i) {
        rVar.a(i, (p1.s0) this.f220v);
    }

    @Override // nc.w
    public void c() {
        SplashActivity splashActivity = (SplashActivity) this.f220v;
        int i = SplashActivity.f3647g0;
        splashActivity.y();
    }

    @Override // pc.k
    public void d(Drawable drawable, boolean z2) {
        ic.i iVar = (ic.i) this.f220v;
        ImageView imageView = iVar.f6512v;
        if (z2) {
            iVar.f6511u.setVisibility(0);
            imageView.setVisibility(0);
            imageView.setImageDrawable(drawable);
        }
    }

    @Override // w2.h
    public long e(long j5) {
        w2.u uVar = (w2.u) this.f220v;
        return s1.b0.j((j5 * ((long) uVar.f13672e)) / 1000000, 0L, uVar.f13675j - 1);
    }

    @Override // j2.x
    public int f(Object obj) {
        p1.q qVar = (p1.q) this.f220v;
        j2.p pVar = (j2.p) obj;
        String str = pVar.f6711b;
        return ((str.equals(qVar.f10023n) || str.equals(j2.y.b(qVar))) && pVar.c(qVar, false) && pVar.d(qVar)) ? 1 : 0;
    }

    @Override // g4.e1
    public Object g(g4.b0 b0Var, g4.s sVar, int i) {
        int i10 = this.f219u;
        Object obj = this.f220v;
        switch (i10) {
            case 16:
                return b0Var.l(sVar, (aa.j0) obj);
            default:
                g4.c1 c1Var = (g4.c1) obj;
                ea.v vVar = ea.v.f4633v;
                if (!b0Var.j()) {
                    c1Var.j(b0Var.f4973t, sVar);
                    g4.f1.L(b0Var, sVar, i, new g4.q1(0));
                }
                return ea.v.f4633v;
        }
    }

    @Override // k7.b
    public Object h() {
        SQLiteDatabase sQLiteDatabaseA;
        int i = this.f219u;
        int i10 = 1;
        Object obj = this.f220v;
        switch (i) {
            case 22:
                j7.g gVar = (j7.g) ((j7.c) obj);
                gVar.getClass();
                int i11 = f7.a.f4789e;
                ub.o oVar = new ub.o(12);
                oVar.f12869w = null;
                oVar.f12870x = new ArrayList();
                oVar.f12871y = null;
                oVar.f12868v = "";
                HashMap map = new HashMap();
                sQLiteDatabaseA = gVar.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    f7.a aVar = (f7.a) j7.g.J(sQLiteDatabaseA.rawQuery("SELECT log_source, reason, events_dropped_count FROM log_event_dropped", new String[0]), new dd.e(gVar, map, oVar, 7));
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return aVar;
                } finally {
                }
            case 23:
                j7.g gVar2 = (j7.g) ((j7.d) obj);
                long jG = gVar2.f6821v.g() - gVar2.f6823x.f6812d;
                sQLiteDatabaseA = gVar2.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    String[] strArr = {String.valueOf(jG)};
                    Cursor cursorRawQuery = sQLiteDatabaseA.rawQuery("SELECT COUNT(*), transport_name FROM events WHERE timestamp_ms < ? GROUP BY transport_name", strArr);
                    while (cursorRawQuery.moveToNext()) {
                        try {
                            gVar2.F(cursorRawQuery.getInt(0), f7.c.f4796w, cursorRawQuery.getString(1));
                        } catch (Throwable th) {
                            cursorRawQuery.close();
                            throw th;
                        }
                    }
                    cursorRawQuery.close();
                    int iDelete = sQLiteDatabaseA.delete("events", "timestamp_ms < ?", strArr);
                    sQLiteDatabaseA.setTransactionSuccessful();
                    sQLiteDatabaseA.endTransaction();
                    return Integer.valueOf(iDelete);
                } finally {
                }
            case 24:
                j7.g gVar3 = (j7.g) ((j7.c) ((b7.s) obj).i);
                sQLiteDatabaseA = gVar3.a();
                sQLiteDatabaseA.beginTransaction();
                try {
                    sQLiteDatabaseA.compileStatement("DELETE FROM log_event_dropped").execute();
                    sQLiteDatabaseA.compileStatement("UPDATE global_log_event_state SET last_metrics_upload_ms=" + gVar3.f6821v.g()).execute();
                    sQLiteDatabaseA.setTransactionSuccessful();
                    return null;
                } finally {
                }
            default:
                ub.o oVar2 = (ub.o) obj;
                Iterator it = ((Iterable) ((j7.g) ((j7.d) oVar2.f12869w)).v(new ia.b(i10))).iterator();
                while (it.hasNext()) {
                    ((a7.b) oVar2.f12870x).C((c7.j) it.next(), 1, false);
                }
                return null;
        }
    }

    @Override // t1.t
    public void i(long j5, s1.u uVar) {
        switch (this.f219u) {
            case 13:
                w2.b.e(j5, uVar, ((d4.d0) this.f220v).f3812c);
                break;
            default:
                w2.b.f(j5, uVar, ((d4.d0) this.f220v).f3812c);
                break;
        }
    }

    @Override // g4.c1
    public void j(g4.j1 j1Var, g4.s sVar) {
        ((s1.h) this.f220v).accept(j1Var);
    }

    public a7.c k(a7.b bVar) throws IOException {
        a7.d dVar = (a7.d) this.f220v;
        URL url = (URL) bVar.f618v;
        String strT = cf.l.t("CctTransportBackend");
        if (Log.isLoggable(strT, 4)) {
            Log.i(strT, String.format("Making request to: %s", url));
        }
        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
        httpURLConnection.setConnectTimeout(30000);
        httpURLConnection.setReadTimeout(dVar.f629g);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setInstanceFollowRedirects(false);
        httpURLConnection.setRequestMethod("POST");
        httpURLConnection.setRequestProperty("User-Agent", "datatransport/3.3.0 android/");
        httpURLConnection.setRequestProperty("Content-Encoding", "gzip");
        httpURLConnection.setRequestProperty("Content-Type", "application/json");
        httpURLConnection.setRequestProperty("Accept-Encoding", "gzip");
        String str = (String) bVar.f620x;
        if (str != null) {
            httpURLConnection.setRequestProperty("X-Goog-Api-Key", str);
        }
        try {
            OutputStream outputStream = httpURLConnection.getOutputStream();
            try {
                GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(outputStream);
                try {
                    u5.d dVar2 = dVar.f624a;
                    b7.m mVar = (b7.m) bVar.f619w;
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(gZIPOutputStream));
                    ib.d dVar3 = (ib.d) dVar2.f12784v;
                    ib.e eVar = new ib.e(bufferedWriter, dVar3.f6478a, dVar3.f6479b, dVar3.f6480c, dVar3.f6481d);
                    eVar.h(mVar);
                    eVar.j();
                    eVar.f6483b.flush();
                    gZIPOutputStream.close();
                    if (outputStream != null) {
                        outputStream.close();
                    }
                    int responseCode = httpURLConnection.getResponseCode();
                    Integer numValueOf = Integer.valueOf(responseCode);
                    String strT2 = cf.l.t("CctTransportBackend");
                    if (Log.isLoggable(strT2, 4)) {
                        Log.i(strT2, String.format("Status Code: %d", numValueOf));
                    }
                    cf.l.l("CctTransportBackend", "Content-Type: %s", httpURLConnection.getHeaderField("Content-Type"));
                    cf.l.l("CctTransportBackend", "Content-Encoding: %s", httpURLConnection.getHeaderField("Content-Encoding"));
                    if (responseCode == 302 || responseCode == 301 || responseCode == 307) {
                        return new a7.c(responseCode, new URL(httpURLConnection.getHeaderField("Location")), 0L);
                    }
                    if (responseCode != 200) {
                        return new a7.c(responseCode, null, 0L);
                    }
                    InputStream inputStream = httpURLConnection.getInputStream();
                    try {
                        InputStream gZIPInputStream = "gzip".equals(httpURLConnection.getHeaderField("Content-Encoding")) ? new GZIPInputStream(inputStream) : inputStream;
                        try {
                            a7.c cVar = new a7.c(responseCode, null, b7.v.a(new BufferedReader(new InputStreamReader(gZIPInputStream))).f1917a);
                            if (gZIPInputStream != null) {
                                gZIPInputStream.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            return cVar;
                        } finally {
                        }
                    } finally {
                    }
                } finally {
                }
            } finally {
            }
        } catch (gb.b e10) {
            e = e10;
            cf.l.o("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new a7.c(400, null, 0L);
        } catch (ConnectException e11) {
            e = e11;
            cf.l.o("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new a7.c(500, null, 0L);
        } catch (UnknownHostException e12) {
            e = e12;
            cf.l.o("CctTransportBackend", "Couldn't open connection, returning with 500", e);
            return new a7.c(500, null, 0L);
        } catch (IOException e13) {
            e = e13;
            cf.l.o("CctTransportBackend", "Couldn't encode request, returning with 400", e);
            return new a7.c(400, null, 0L);
        }
    }

    public /* synthetic */ f0(b2.a aVar, Object obj, int i) {
        this.f219u = i;
        this.f220v = obj;
    }

    public /* synthetic */ f0(b2.a aVar, o2.u uVar, o2.z zVar, IOException iOException, boolean z2) {
        this.f219u = 9;
        this.f220v = zVar;
    }
}
