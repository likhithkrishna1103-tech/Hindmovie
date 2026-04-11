package rc;

import android.text.format.DateUtils;
import com.google.android.gms.internal.measurement.k1;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import j9.p;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final long i = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f10949j = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ic.d f10950a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final hc.b f10951b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f10952c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f10953d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f10954e;
    public final ConfigFetchHttpClient f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final l f10955g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f10956h;

    public g(ic.d dVar, hc.b bVar, Executor executor, Random random, c cVar, ConfigFetchHttpClient configFetchHttpClient, l lVar, HashMap map) {
        this.f10950a = dVar;
        this.f10951b = bVar;
        this.f10952c = executor;
        this.f10953d = random;
        this.f10954e = cVar;
        this.f = configFetchHttpClient;
        this.f10955g = lVar;
        this.f10956h = map;
    }

    public final f a(String str, String str2, Date date, HashMap map) throws qc.c, qc.e, qc.f {
        String str3;
        try {
            HttpURLConnection httpURLConnectionB = this.f.b();
            ConfigFetchHttpClient configFetchHttpClient = this.f;
            HashMap mapD = d();
            String string = this.f10955g.f10983a.getString("last_fetch_etag", null);
            eb.b bVar = (eb.b) this.f10951b.get();
            f fVarFetch = configFetchHttpClient.fetch(httpURLConnectionB, str, str2, mapD, string, map, bVar != null ? (Long) ((k1) ((eb.c) bVar).f3883a.f10037w).a(null, null, true).get("_fot") : null, date, this.f10955g.b());
            e eVar = fVarFetch.f10947b;
            if (eVar != null) {
                l lVar = this.f10955g;
                long j4 = eVar.f;
                synchronized (lVar.f10984b) {
                    lVar.f10983a.edit().putLong("last_template_version", j4).apply();
                }
            }
            String str4 = fVarFetch.f10948c;
            if (str4 != null) {
                this.f10955g.e(str4);
            }
            this.f10955g.d(0, l.f);
            return fVarFetch;
        } catch (qc.f e9) {
            int i10 = e9.f10795v;
            l lVar2 = this.f10955g;
            if (i10 == 429 || i10 == 502 || i10 == 503 || i10 == 504) {
                int i11 = lVar2.a().f10980a + 1;
                TimeUnit timeUnit = TimeUnit.MINUTES;
                int[] iArr = f10949j;
                long millis = timeUnit.toMillis(iArr[Math.min(i11, iArr.length) - 1]);
                lVar2.d(i11, new Date(date.getTime() + (millis / 2) + ((long) this.f10953d.nextInt((int) millis))));
            }
            k kVarA = lVar2.a();
            int i12 = e9.f10795v;
            if (kVarA.f10980a > 1 || i12 == 429) {
                kVarA.f10981b.getTime();
                throw new qc.e("Fetch was throttled.");
            }
            if (i12 == 401) {
                str3 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
            } else if (i12 == 403) {
                str3 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
            } else {
                if (i12 == 429) {
                    throw new qc.c("The throttled response from the server was not handled correctly by the FRC SDK.");
                }
                if (i12 != 500) {
                    switch (i12) {
                        case 502:
                        case 503:
                        case 504:
                            str3 = "The server is unavailable. Please try again later.";
                            break;
                        default:
                            str3 = "The server returned an unexpected error.";
                            break;
                    }
                } else {
                    str3 = "There was an internal server error.";
                }
            }
            throw new qc.f(e9.f10795v, "Fetch failed: ".concat(str3), e9);
        }
    }

    public final p b(p pVar, long j4, HashMap map) {
        p pVarF;
        Date date = new Date(System.currentTimeMillis());
        boolean zJ = pVar.j();
        l lVar = this.f10955g;
        if (zJ) {
            Date date2 = new Date(lVar.f10983a.getLong("last_fetch_time_in_millis", -1L));
            if (date2.equals(l.f10982e) ? false : date.before(new Date(TimeUnit.SECONDS.toMillis(j4) + date2.getTime()))) {
                return vf.g.A(new f(2, null, null));
            }
        }
        Date date3 = lVar.a().f10981b;
        Date date4 = date.before(date3) ? date3 : null;
        Executor executor = this.f10952c;
        if (date4 != null) {
            String str = "Fetch is throttled. Please wait before calling fetch again: " + DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(date4.getTime() - date.getTime()));
            date4.getTime();
            pVarF = vf.g.z(new qc.e(str));
        } else {
            ic.c cVar = (ic.c) this.f10950a;
            p pVarD = cVar.d();
            p pVarE = cVar.e();
            pVarF = vf.g.c0(pVarD, pVarE).f(executor, new d6.a(this, pVarD, pVarE, date, map));
        }
        return pVarF.f(executor, new androidx.fragment.app.e(21, this, date));
    }

    public final p c(int i10) {
        HashMap map = new HashMap(this.f10956h);
        map.put("X-Firebase-RC-Fetch-Type", "REALTIME/" + i10);
        return this.f10954e.b().f(this.f10952c, new androidx.fragment.app.e(20, this, map));
    }

    public final HashMap d() {
        HashMap map = new HashMap();
        eb.b bVar = (eb.b) this.f10951b.get();
        if (bVar != null) {
            for (Map.Entry entry : ((k1) ((eb.c) bVar).f3883a.f10037w).a(null, null, false).entrySet()) {
                map.put((String) entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }
}
