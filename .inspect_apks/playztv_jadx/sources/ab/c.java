package ab;

import android.app.Service;
import android.app.job.JobParameters;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.media3.decoder.DecoderInputBuffer;
import b1.j;
import com.google.android.gms.internal.measurement.l0;
import com.google.android.gms.internal.measurement.n2;
import com.google.android.gms.internal.measurement.q0;
import com.google.android.gms.internal.measurement.w0;
import com.google.android.material.appbar.AppBarLayout;
import ea.t;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import k8.a4;
import k8.c2;
import k8.d1;
import k8.e4;
import k8.h0;
import k8.h1;
import k8.k1;
import k8.l3;
import k8.o1;
import k8.p0;
import k8.s0;
import k8.t2;
import k8.u;
import k8.u2;
import k8.v;
import k8.x3;
import k8.y1;
import k8.z2;
import ld.k;
import n0.e;
import n0.f;
import o8.o;
import p7.h;
import p7.l;
import p7.m;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f779u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public Object f780v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public Object f781w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public Object f782x;

    public /* synthetic */ c(int i) {
        this.f779u = i;
    }

    private final void a() {
        synchronized (((AtomicReference) this.f780v)) {
            try {
                try {
                } catch (RemoteException e10) {
                    ((z2) this.f782x).g().A.c(e10, "Failed to get app instance id");
                }
                if (!((z2) this.f782x).n1().z1().i(y1.f7555w)) {
                    ((z2) this.f782x).g().F.d("Analytics storage consent denied; will not get app instance id");
                    ((z2) this.f782x).q1().S1(null);
                    ((z2) this.f782x).n1().C.r(null);
                    ((AtomicReference) this.f780v).set(null);
                    return;
                }
                z2 z2Var = (z2) this.f782x;
                h0 h0Var = z2Var.f7573y;
                if (h0Var == null) {
                    z2Var.g().A.d("Failed to get app instance id");
                    return;
                }
                ((AtomicReference) this.f780v).set(h0Var.m((a4) this.f781w));
                String str = (String) ((AtomicReference) this.f780v).get();
                if (str != null) {
                    ((z2) this.f782x).q1().S1(str);
                    ((z2) this.f782x).n1().C.r(str);
                }
                ((z2) this.f782x).H1();
                ((AtomicReference) this.f780v).notify();
            } finally {
                ((AtomicReference) this.f780v).notify();
            }
        }
    }

    private final void b() {
        int i;
        o oVarE;
        p7.a aVar = (p7.a) this.f781w;
        Intent intent = aVar.f10247u;
        String stringExtra = intent.getStringExtra("google.message_id");
        if (stringExtra == null) {
            stringExtra = intent.getStringExtra("message_id");
        }
        if (TextUtils.isEmpty(stringExtra)) {
            oVarE = t1.k(null);
        } else {
            Bundle bundle = new Bundle();
            Intent intent2 = aVar.f10247u;
            String stringExtra2 = intent2.getStringExtra("google.message_id");
            if (stringExtra2 == null) {
                stringExtra2 = intent2.getStringExtra("message_id");
            }
            bundle.putString("google.message_id", stringExtra2);
            Intent intent3 = aVar.f10247u;
            Integer numValueOf = intent3.hasExtra("google.product_id") ? Integer.valueOf(intent3.getIntExtra("google.product_id", 0)) : null;
            if (numValueOf != null) {
                bundle.putInt("google.product_id", numValueOf.intValue());
            }
            Context context = (Context) this.f780v;
            bundle.putBoolean("supports_message_handled", true);
            m mVarD = m.d(context);
            synchronized (mVarD) {
                i = mVarD.f10283u;
                mVarD.f10283u = i + 1;
            }
            oVarE = mVarD.e(new l(i, 2, bundle, 0));
        }
        oVarE.b(h.f10263v, new rc.b(29, (CountDownLatch) this.f782x));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c(int i, IOException iOException, byte[] bArr, Map map) {
        h1 h1VarX = ((t2) this.f782x).x();
        u2 u2Var = new u2(0);
        u2Var.f7440w = this;
        u2Var.f7439v = i;
        u2Var.f7441x = iOException;
        u2Var.f7442y = bArr;
        h1VarX.y1(u2Var);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r3v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r3v27 */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        n2 n2Var;
        boolean zB;
        Map<String, List<String>> headerFields;
        HttpURLConnection httpURLConnection;
        OutputStream outputStream;
        OverScroller overScroller;
        int responseCode = 0;
        Object objCall = null;
        outputStream = null;
        OutputStream outputStream2 = null;
        switch (this.f779u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                d dVar = (d) this.f782x;
                ta.a aVar = (ta.a) this.f780v;
                dVar.b(aVar, (o8.h) this.f781w);
                ((AtomicInteger) dVar.i.f10311w).set(0);
                double dMin = Math.min(3600000.0d, Math.pow(dVar.f784b, dVar.a()) * (60000.0d / dVar.f783a));
                String str = "Delay for: " + String.format(Locale.US, "%.2f", Double.valueOf(dMin / 1000.0d)) + " s for report: " + aVar.f12349b;
                if (Log.isLoggable("FirebaseCrashlytics", 3)) {
                    Log.d("FirebaseCrashlytics", str, null);
                }
                try {
                    Thread.sleep((long) dMin);
                    return;
                } catch (InterruptedException unused) {
                    return;
                }
            case 1:
                a4 a4Var = (a4) this.f781w;
                o1 o1Var = (o1) this.f782x;
                o1Var.f7348d.d0();
                k8.d dVar2 = (k8.d) this.f780v;
                if (dVar2.f7130w.a() == null) {
                    o1Var.f7348d.t(dVar2, a4Var);
                    return;
                } else {
                    o1Var.f7348d.K(dVar2, a4Var);
                    return;
                }
            case 2:
                o1 o1Var2 = (o1) this.f782x;
                x3 x3Var = o1Var2.f7348d;
                v vVar = (v) this.f780v;
                String str2 = vVar.f7444u;
                u uVar = vVar.f7445v;
                if ("_cmp".equals(str2) && uVar != null) {
                    Bundle bundle = uVar.f7434u;
                    if (bundle.size() != 0) {
                        String string = bundle.getString("_cis");
                        if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                            x3Var.g().G.c(vVar.toString(), "Event has been filtered ");
                            vVar = new v("_cmpx", vVar.f7445v, vVar.f7446w, vVar.f7447x);
                        }
                    }
                }
                String str3 = vVar.f7444u;
                a4 a4Var2 = (a4) this.f781w;
                d1 d1Var = x3Var.f7544u;
                s0 s0Var = x3Var.A;
                x3.y(d1Var);
                String str4 = a4Var2.f7076u;
                if (TextUtils.isEmpty(str4) || (n2Var = (n2) d1Var.C.get(str4)) == null || n2Var.n() == 0) {
                    o1Var2.I(vVar, a4Var2);
                    return;
                }
                x3Var.g().I.c(str4, "EES config found for");
                d1 d1Var2 = x3Var.f7544u;
                x3.y(d1Var2);
                vVar = TextUtils.isEmpty(str4) ? 0 : (com.google.android.gms.internal.measurement.v) d1Var2.E.g(str4);
                if (vVar == 0) {
                    x3Var.g().I.c(str4, "EES not loaded for");
                    o1Var2.I(vVar, a4Var2);
                    return;
                }
                try {
                    x3.y(s0Var);
                    HashMap mapH1 = s0.H1(vVar.f7445v.d(), true);
                    String strC = c2.c(str3, c2.f7112c, c2.f7110a);
                    if (strC == null) {
                        strC = str3;
                    }
                    zB = vVar.b(new com.google.android.gms.internal.measurement.c(strC, vVar.f7447x, mapH1));
                    break;
                } catch (l0 unused2) {
                    x3Var.g().A.b(a4Var2.f7077v, str3, "EES error. appId, eventName");
                    zB = false;
                }
                if (!zB) {
                    x3Var.g().I.c(str3, "EES was not applied to event");
                    o1Var2.I(vVar, a4Var2);
                    return;
                }
                a7.b bVar = vVar.f3215c;
                if (((com.google.android.gms.internal.measurement.c) bVar.f619w).equals((com.google.android.gms.internal.measurement.c) bVar.f618v)) {
                    o1Var2.I(vVar, a4Var2);
                } else {
                    x3Var.g().I.c(str3, "EES edited event");
                    x3.y(s0Var);
                    o1Var2.I(s0.J1((com.google.android.gms.internal.measurement.c) vVar.f3215c.f619w), a4Var2);
                }
                if (((ArrayList) vVar.f3215c.f620x).isEmpty()) {
                    return;
                }
                ArrayList arrayList = (ArrayList) vVar.f3215c.f620x;
                int size = arrayList.size();
                while (responseCode < size) {
                    Object obj = arrayList.get(responseCode);
                    responseCode++;
                    com.google.android.gms.internal.measurement.c cVar = (com.google.android.gms.internal.measurement.c) obj;
                    x3Var.g().I.c(cVar.f2908a, "EES logging created event");
                    x3.y(s0Var);
                    o1Var2.I(s0.J1(cVar), a4Var2);
                }
                return;
            case 3:
                o1 o1Var3 = (o1) this.f782x;
                o1Var3.f7348d.d0();
                o1Var3.f7348d.u((v) this.f780v, (String) this.f781w);
                return;
            case j.LONG_FIELD_NUMBER /* 4 */:
                a4 a4Var3 = (a4) this.f781w;
                o1 o1Var4 = (o1) this.f782x;
                o1Var4.f7348d.d0();
                e4 e4Var = (e4) this.f780v;
                if (e4Var.a() == null) {
                    o1Var4.f7348d.r(e4Var.f7164v, a4Var3);
                    return;
                } else {
                    o1Var4.f7348d.z(e4Var, a4Var3);
                    return;
                }
            case j.STRING_FIELD_NUMBER /* 5 */:
                h1 h1Var = ((k1) ((t2) this.f782x).f2454v).D;
                k1.f(h1Var);
                h1Var.B1();
                try {
                    URL url = (URL) this.f780v;
                    synchronized (q0.class) {
                    }
                    URLConnection uRLConnectionOpenConnection = url.openConnection();
                    if (!(uRLConnectionOpenConnection instanceof HttpURLConnection)) {
                        throw new IOException("Failed to obtain HTTP connection");
                    }
                    httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
                    httpURLConnection.setDefaultUseCaches(false);
                    httpURLConnection.setConnectTimeout(60000);
                    httpURLConnection.setReadTimeout(61000);
                    httpURLConnection.setInstanceFollowRedirects(false);
                    httpURLConnection.setDoInput(true);
                    try {
                        responseCode = httpURLConnection.getResponseCode();
                        headerFields = httpURLConnection.getHeaderFields();
                    } catch (IOException e10) {
                        e = e10;
                        headerFields = null;
                    } catch (Throwable th) {
                        th = th;
                        headerFields = null;
                    }
                    try {
                        byte[] bArrT1 = t2.t1(httpURLConnection);
                        httpURLConnection.disconnect();
                        c(responseCode, null, bArrT1, headerFields);
                        return;
                    } catch (IOException e11) {
                        e = e11;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        c(responseCode, e, null, headerFields);
                        return;
                    } catch (Throwable th2) {
                        th = th2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        c(responseCode, null, null, headerFields);
                        throw th;
                    }
                } catch (IOException e12) {
                    e = e12;
                    headerFields = null;
                    httpURLConnection = null;
                } catch (Throwable th3) {
                    th = th3;
                    headerFields = null;
                    httpURLConnection = null;
                }
                break;
            case j.STRING_SET_FIELD_NUMBER /* 6 */:
                a();
                return;
            case j.DOUBLE_FIELD_NUMBER /* 7 */:
                a4 a4Var4 = (a4) this.f780v;
                w0 w0Var = (w0) this.f781w;
                z2 z2Var = (z2) this.f782x;
                try {
                    if (!z2Var.n1().z1().i(y1.f7555w)) {
                        z2Var.g().F.d("Analytics storage consent denied; will not get app instance id");
                        z2Var.q1().S1(null);
                        z2Var.n1().C.r(null);
                        return;
                    }
                    h0 h0Var = z2Var.f7573y;
                    if (h0Var == null) {
                        z2Var.g().A.d("Failed to get app instance id");
                        return;
                    }
                    String strM = h0Var.m(a4Var4);
                    if (strM != null) {
                        z2Var.q1().S1(strM);
                        z2Var.n1().C.r(strM);
                    }
                    z2Var.H1();
                    z2Var.o1().P1(strM, w0Var);
                    return;
                } catch (RemoteException e13) {
                    z2Var.g().A.c(e13, "Failed to get app instance id");
                    return;
                } finally {
                    z2Var.o1().P1(null, w0Var);
                }
            case 8:
                a4 a4Var5 = (a4) this.f780v;
                z2 z2Var2 = (z2) this.f782x;
                h0 h0Var2 = z2Var2.f7573y;
                if (h0Var2 == null) {
                    z2Var2.g().A.d("Failed to send default event parameters to service");
                    return;
                }
                try {
                    h0Var2.mo2g((Bundle) this.f781w, a4Var5);
                    return;
                } catch (RemoteException e14) {
                    z2Var2.g().A.c(e14, "Failed to send default event parameters to service");
                    return;
                }
            case 9:
                rc.b bVar2 = (rc.b) this.f780v;
                p0 p0Var = (p0) this.f781w;
                JobParameters jobParameters = (JobParameters) this.f782x;
                p0Var.I.d("AppMeasurementJobService processed last upload request.");
                ((l3) ((Service) bVar2.f11562v)).b(jobParameters);
                return;
            case 10:
                InputStream inputStream = (InputStream) this.f780v;
                pc.m mVar = (pc.m) this.f782x;
                Socket socket = (Socket) this.f781w;
                try {
                    try {
                        outputStream = socket.getOutputStream();
                    } catch (Exception e15) {
                        e = e15;
                    }
                    break;
                } catch (Throwable th4) {
                    th = th4;
                }
                try {
                    ld.d dVar3 = new ld.d(mVar, new ld.c(0), (InputStream) this.f780v, outputStream, socket.getInetAddress());
                    while (!socket.isClosed()) {
                        dVar3.c();
                        break;
                    }
                    k.a(outputStream);
                } catch (Exception e16) {
                    e = e16;
                    outputStream2 = outputStream;
                    if ((!(e instanceof SocketException) || !"NanoHttpd Shutdown".equals(e.getMessage())) && !(e instanceof SocketTimeoutException)) {
                        k.f8153d.log(Level.SEVERE, "Communication with the client broken, or an bug in the handler code", (Throwable) e);
                    }
                    k.a(outputStream2);
                    break;
                } catch (Throwable th5) {
                    th = th5;
                    outputStream2 = outputStream;
                    k.a(outputStream2);
                    k.a(inputStream);
                    k.a(socket);
                    ((List) mVar.f8156c.f797w).remove(this);
                    throw th;
                }
                k.a(inputStream);
                k.a(socket);
                ((List) mVar.f8156c.f797w).remove(this);
                return;
            case 11:
                try {
                    objCall = ((e) this.f780v).call();
                    break;
                } catch (Exception unused3) {
                }
                ((Handler) this.f782x).post(new t((f) this.f781w, 21, objCall));
                return;
            case 12:
                b();
                return;
            default:
                CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.f780v;
                r8.c cVar2 = (r8.c) this.f782x;
                View view = (View) this.f781w;
                if (view == null || (overScroller = cVar2.f11541x) == null) {
                    return;
                }
                if (overScroller.computeScrollOffset()) {
                    cVar2.A(coordinatorLayout, view, cVar2.f11541x.getCurrY());
                    view.postOnAnimation(this);
                    return;
                }
                AppBarLayout appBarLayout = (AppBarLayout) view;
                ((AppBarLayout.BaseBehavior) cVar2).G(coordinatorLayout, appBarLayout);
                if (appBarLayout.E) {
                    appBarLayout.e(appBarLayout.f(AppBarLayout.BaseBehavior.D(coordinatorLayout)));
                    return;
                }
                return;
        }
    }

    public /* synthetic */ c(Context context, p7.a aVar, CountDownLatch countDownLatch) {
        this.f779u = 12;
        this.f780v = context;
        this.f781w = aVar;
        this.f782x = countDownLatch;
    }

    public /* synthetic */ c(Object obj, Object obj2, Object obj3, int i) {
        this.f779u = i;
        this.f782x = obj;
        this.f780v = obj2;
        this.f781w = obj3;
    }

    public c(t2 t2Var, String str, URL url, u5.c cVar) {
        this.f779u = 5;
        this.f782x = t2Var;
        t7.v.d(str);
        this.f780v = url;
        this.f781w = cVar;
    }
}
