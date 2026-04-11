package n;

import android.content.Context;
import android.graphics.Rect;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class q3 implements e7.b {
    public final Object A;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Object f8507u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Object f8508v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Object f8509w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Object f8510x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final Object f8511y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public final Object f8512z;

    public q3(md.a aVar, md.a aVar2, md.a aVar3, a7.b bVar, md.a aVar4, md.a aVar5, md.a aVar6) {
        this.f8507u = aVar;
        this.f8508v = aVar2;
        this.f8509w = aVar3;
        this.f8510x = bVar;
        this.f8511y = aVar4;
        this.f8512z = aVar5;
        this.A = aVar6;
    }

    public void a(int i, long j5) {
        if (i == 0) {
            new xb.f("Unable to fetch the latest version of the template.");
            d();
        } else {
            ((ScheduledExecutorService) this.f8512z).schedule(new yb.b(this, i, j5), ((Random) this.A).nextInt(4), TimeUnit.SECONDS);
        }
    }

    public void b(InputStream inputStream) throws IOException {
        JSONObject jSONObject;
        boolean zIsEmpty;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String strM = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            strM = e6.j.m(strM, line);
            if (line.contains("}")) {
                int iIndexOf = strM.indexOf(123);
                int iLastIndexOf = strM.lastIndexOf(125);
                strM = (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : strM.substring(iIndexOf, iLastIndexOf + 1);
                if (!strM.isEmpty()) {
                    try {
                        jSONObject = new JSONObject(strM);
                    } catch (JSONException e10) {
                        new xb.c("Unable to parse config update message.", e10.getCause());
                        d();
                        Log.e("FirebaseRemoteConfig", "Unable to parse latest config update message.", e10);
                    }
                    if (jSONObject.has("featureDisabled") && jSONObject.getBoolean("featureDisabled")) {
                        yb.l lVar = (yb.l) this.f8511y;
                        new xb.f("The server is temporarily unavailable. Try again in a few minutes.");
                        lVar.a();
                        break;
                    }
                    synchronized (this) {
                        zIsEmpty = ((LinkedHashSet) this.f8507u).isEmpty();
                    }
                    if (zIsEmpty) {
                        break;
                    }
                    if (jSONObject.has("latestTemplateVersionNumber")) {
                        long j5 = ((yb.g) this.f8509w).f14606g.f14615a.getLong("last_template_version", 0L);
                        long j8 = jSONObject.getLong("latestTemplateVersionNumber");
                        if (j8 > j5) {
                            a(3, j8);
                        }
                    }
                    strM = "";
                } else {
                    continue;
                }
            }
        }
        bufferedReader.close();
        inputStream.close();
    }

    public void c() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.f8508v;
        try {
            InputStream inputStream = httpURLConnection.getInputStream();
            b(inputStream);
            inputStream.close();
        } catch (IOException e10) {
            Log.d("FirebaseRemoteConfig", "Stream was cancelled due to an exception. Retrying the connection...", e10);
        } finally {
            httpURLConnection.disconnect();
        }
    }

    public synchronized void d() {
        Iterator it = ((LinkedHashSet) this.f8507u).iterator();
        while (it.hasNext()) {
            ((yb.l) it.next()).a();
        }
    }

    @Override // md.a
    public Object get() {
        Context context = (Context) ((md.a) this.f8507u).get();
        d7.d dVar = (d7.d) ((md.a) this.f8508v).get();
        j7.d dVar2 = (j7.d) ((md.a) this.f8509w).get();
        a7.b bVar = (a7.b) ((a7.b) this.f8510x).get();
        Executor executor = (Executor) ((md.a) this.f8511y).get();
        k7.c cVar = (k7.c) ((md.a) this.f8512z).get();
        k8.b0 b0Var = new k8.b0(17);
        k8.a0 a0Var = new k8.a0(17);
        j7.c cVar2 = (j7.c) ((md.a) this.A).get();
        b7.s sVar = new b7.s();
        sVar.f1898a = context;
        sVar.f1899b = dVar;
        sVar.f1900c = dVar2;
        sVar.f1901d = bVar;
        sVar.f1902e = executor;
        sVar.f = cVar;
        sVar.f1903g = b0Var;
        sVar.f1904h = a0Var;
        sVar.i = cVar2;
        return sVar;
    }

    public q3(Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f8510x = layoutParams;
        this.f8511y = new Rect();
        this.f8512z = new int[2];
        this.A = new int[2];
        this.f8507u = context;
        View viewInflate = LayoutInflater.from(context).inflate(g.g.abc_tooltip, (ViewGroup) null);
        this.f8508v = viewInflate;
        this.f8509w = (TextView) viewInflate.findViewById(g.f.message);
        layoutParams.setTitle(q3.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = g.i.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    public q3(HttpURLConnection httpURLConnection, yb.g gVar, yb.c cVar, LinkedHashSet linkedHashSet, yb.l lVar, ScheduledExecutorService scheduledExecutorService) {
        this.f8508v = httpURLConnection;
        this.f8509w = gVar;
        this.f8510x = cVar;
        this.f8507u = linkedHashSet;
        this.f8511y = lVar;
        this.f8512z = scheduledExecutorService;
        this.A = new Random();
    }

    public q3(yc.c cVar, id.k kVar, zc.g gVar, ed.a aVar, a7.b bVar, Handler handler, h4.z zVar, b7.s sVar) {
        be.h.e(handler, "uiHandler");
        this.f8507u = cVar;
        this.f8508v = kVar;
        this.f8509w = gVar;
        this.f8510x = handler;
        this.f8511y = sVar;
        ed.a aVar2 = new ed.a(gVar);
        c2.x xVar = new c2.x(cVar.f14654a, 1);
        this.f8512z = xVar;
        bd.a aVar3 = new bd.a(cVar.f14655b, cVar.f14657d, xVar, aVar2, zVar, sVar, cVar.f14658e, cVar.f, bVar);
        ed.d dVar = new ed.d(kVar, aVar, aVar3, xVar, cVar.f14657d, sVar, cVar.f14659g);
        aVar3.F = dVar;
        yc.f fVar = cVar.f14656c;
        be.h.e(fVar, "<set-?>");
        dVar.C = fVar;
        this.A = new dd.a(gVar, aVar3, dVar, cVar.f14657d, cVar.f14655b, cVar.f14658e, sVar, handler, cVar.f, bVar, cVar.f14659g);
        rc.b bVar2 = new rc.b(8, this);
        synchronized (gVar.f14963v) {
            gVar.f14962u.f14960y = bVar2;
        }
    }
}
