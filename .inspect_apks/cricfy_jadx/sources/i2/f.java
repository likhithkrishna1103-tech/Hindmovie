package i2;

import android.content.Context;
import android.media.AudioDeviceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import androidx.fragment.app.f1;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f5992a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Object f5993b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f5994c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Object f5995d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f5996e;
    public final Object f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f5997g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Object f5998h;
    public Object i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Object f5999j;

    public f(HttpURLConnection httpURLConnection, rc.g gVar, rc.c cVar, LinkedHashSet linkedHashSet, rc.i iVar, ScheduledExecutorService scheduledExecutorService, rc.l lVar) {
        this.f5994c = httpURLConnection;
        this.f5995d = gVar;
        this.f5996e = cVar;
        this.f5993b = linkedHashSet;
        this.f = iVar;
        this.f5997g = scheduledExecutorService;
        this.f5998h = new Random();
        this.f5992a = false;
        this.f5999j = lVar;
        this.i = s8.a.f11610a;
    }

    public void a(int i, long j4) {
        if (i == 0) {
            new qc.f("Unable to fetch the latest version of the template.");
            e();
        } else {
            ((ScheduledExecutorService) this.f5997g).schedule(new rc.b(this, i, j4), ((Random) this.f5998h).nextInt(4), TimeUnit.SECONDS);
        }
    }

    public void b(InputStream inputStream) throws IOException {
        JSONObject jSONObject;
        boolean zIsEmpty;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
        String strJ = "";
        while (true) {
            String line = bufferedReader.readLine();
            if (line == null) {
                break;
            }
            strJ = l0.e.j(strJ, line);
            if (line.contains("}")) {
                int iIndexOf = strJ.indexOf(123);
                int iLastIndexOf = strJ.lastIndexOf(125);
                strJ = (iIndexOf < 0 || iLastIndexOf < 0 || iIndexOf >= iLastIndexOf) ? "" : strJ.substring(iIndexOf, iLastIndexOf + 1);
                if (!strJ.isEmpty()) {
                    try {
                        jSONObject = new JSONObject(strJ);
                    } catch (JSONException e9) {
                        new qc.c("Unable to parse config update message.", e9.getCause());
                        e();
                        Log.e("FirebaseRemoteConfig", "Unable to parse latest config update message.", e9);
                    }
                    if (jSONObject.has("featureDisabled") && jSONObject.getBoolean("featureDisabled")) {
                        rc.i iVar = (rc.i) this.f;
                        new qc.f("The server is temporarily unavailable. Try again in a few minutes.");
                        iVar.a();
                        break;
                    }
                    synchronized (this) {
                        zIsEmpty = ((LinkedHashSet) this.f5993b).isEmpty();
                    }
                    if (zIsEmpty) {
                        break;
                    }
                    if (jSONObject.has("latestTemplateVersionNumber")) {
                        long j4 = ((rc.g) this.f5995d).f10955g.f10983a.getLong("last_template_version", 0L);
                        long j7 = jSONObject.getLong("latestTemplateVersionNumber");
                        if (j7 > j4) {
                            a(3, j7);
                        }
                    }
                    if (jSONObject.has("retryIntervalSeconds")) {
                        g(jSONObject.getInt("retryIntervalSeconds"));
                    }
                    strJ = "";
                } else {
                    continue;
                }
            }
        }
        bufferedReader.close();
    }

    public void c() {
        HttpURLConnection httpURLConnection = (HttpURLConnection) this.f5994c;
        if (httpURLConnection == null) {
            return;
        }
        InputStream inputStream = null;
        try {
            try {
                try {
                    inputStream = httpURLConnection.getInputStream();
                    b(inputStream);
                    if (inputStream != null) {
                        inputStream.close();
                    }
                } catch (IOException e9) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e9);
                }
            } catch (IOException e10) {
                if (!this.f5992a) {
                    Log.d("FirebaseRemoteConfig", "Real-time connection was closed due to an exception.", e10);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e11) {
                    Log.d("FirebaseRemoteConfig", "Exception thrown when closing connection stream. Retrying connection...", e11);
                }
            }
            throw th;
        }
    }

    public void d(c cVar) {
        if (!this.f5992a || cVar.equals((c) this.f5998h)) {
            return;
        }
        this.f5998h = cVar;
        f0 f0Var = (f0) ((f1) this.f5994c).f986w;
        Looper looperMyLooper = Looper.myLooper();
        boolean z10 = f0Var.f6016h0 == looperMyLooper;
        StringBuilder sb = new StringBuilder("Current looper (");
        sb.append(looperMyLooper == null ? "null" : looperMyLooper.getThread().getName());
        sb.append(") is not the playback looper (");
        Looper looper = f0Var.f6016h0;
        sb.append(looper != null ? looper.getThread().getName() : "null");
        sb.append(")");
        y1.d.f(sb.toString(), z10);
        c cVar2 = f0Var.f6036x;
        if (cVar2 == null || cVar.equals(cVar2)) {
            return;
        }
        f0Var.f6036x = cVar;
        p pVar = f0Var.f6031s;
        if (pVar != null) {
            pVar.h();
        }
    }

    public synchronized void e() {
        Iterator it = ((LinkedHashSet) this.f5993b).iterator();
        while (it.hasNext()) {
            ((rc.i) it.next()).a();
        }
    }

    public void f(AudioDeviceInfo audioDeviceInfo) {
        p6.d dVar = (p6.d) this.i;
        if (Objects.equals(audioDeviceInfo, dVar == null ? null : (AudioDeviceInfo) dVar.f10037w)) {
            return;
        }
        p6.d dVar2 = audioDeviceInfo != null ? new p6.d(24, audioDeviceInfo) : null;
        this.i = dVar2;
        d(c.c((Context) this.f5993b, (v1.c) this.f5999j, dVar2));
    }

    public synchronized void g(int i) {
        ((s8.a) this.i).getClass();
        ((rc.l) this.f5999j).f(new Date(new Date(System.currentTimeMillis()).getTime() + (((long) i) * 1000)));
    }

    public f(Context context, f1 f1Var, v1.c cVar, p6.d dVar) {
        Context applicationContext = context.getApplicationContext();
        this.f5993b = applicationContext;
        this.f5994c = f1Var;
        this.f5999j = cVar;
        this.i = dVar;
        int i = y1.a0.f14551a;
        Looper looperMyLooper = Looper.myLooper();
        Handler handler = new Handler(looperMyLooper == null ? Looper.getMainLooper() : looperMyLooper, null);
        this.f5995d = handler;
        this.f5996e = new d(this);
        this.f = new com.bumptech.glide.manager.r(3, this);
        c cVar2 = c.f5977c;
        String str = Build.MANUFACTURER;
        Uri uriFor = (str.equals("Amazon") || str.equals("Xiaomi")) ? Settings.Global.getUriFor("external_surround_sound_enabled") : null;
        this.f5997g = uriFor != null ? new e(this, handler, applicationContext.getContentResolver(), uriFor) : null;
    }
}
