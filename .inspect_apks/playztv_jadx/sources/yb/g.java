package yb;

import android.text.format.DateUtils;
import com.google.android.gms.internal.measurement.i1;
import com.google.firebase.remoteconfig.internal.ConfigFetchHttpClient;
import java.net.HttpURLConnection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import o8.o;
import wa.t1;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class g {
    public static final long i = TimeUnit.HOURS.toSeconds(12);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int[] f14600j = {2, 4, 8, 16, 32, 64, 128, 256};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ob.d f14601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final nb.b f14602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Executor f14603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Random f14604d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final c f14605e;
    public final ConfigFetchHttpClient f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final j f14606g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Map f14607h;

    public g(ob.d dVar, nb.b bVar, Executor executor, Random random, c cVar, ConfigFetchHttpClient configFetchHttpClient, j jVar, HashMap map) {
        this.f14601a = dVar;
        this.f14602b = bVar;
        this.f14603c = executor;
        this.f14604d = random;
        this.f14605e = cVar;
        this.f = configFetchHttpClient;
        this.f14606g = jVar;
        this.f14607h = map;
    }

    public final f a(String str, String str2, Date date, HashMap map) throws xb.c, xb.e, xb.f {
        Date date2;
        String str3;
        try {
            HttpURLConnection httpURLConnectionB = this.f.b();
            ConfigFetchHttpClient configFetchHttpClient = this.f;
            HashMap mapD = d();
            String string = this.f14606g.f14615a.getString("last_fetch_etag", null);
            ka.b bVar = (ka.b) this.f14602b.get();
            date2 = date;
            try {
                f fVarFetch = configFetchHttpClient.fetch(httpURLConnectionB, str, str2, mapD, string, map, bVar != null ? (Long) ((i1) ((ka.c) bVar).f7608a.f11562v).d(null, null, true).get("_fot") : null, date2);
                e eVar = fVarFetch.f14598b;
                if (eVar != null) {
                    j jVar = this.f14606g;
                    long j5 = eVar.f;
                    synchronized (jVar.f14616b) {
                        jVar.f14615a.edit().putLong("last_template_version", j5).apply();
                    }
                }
                String str4 = fVarFetch.f14599c;
                if (str4 != null) {
                    this.f14606g.d(str4);
                }
                this.f14606g.c(0, j.f);
                return fVarFetch;
            } catch (xb.f e10) {
                e = e10;
                xb.f fVar = e;
                int i10 = fVar.f14344u;
                j jVar2 = this.f14606g;
                if (i10 == 429 || i10 == 502 || i10 == 503 || i10 == 504) {
                    int i11 = jVar2.a().f14612a + 1;
                    TimeUnit timeUnit = TimeUnit.MINUTES;
                    int[] iArr = f14600j;
                    long millis = timeUnit.toMillis(iArr[Math.min(i11, iArr.length) - 1]);
                    jVar2.c(i11, new Date(date2.getTime() + (millis / 2) + ((long) this.f14604d.nextInt((int) millis))));
                }
                i iVarA = jVar2.a();
                int i12 = fVar.f14344u;
                if (iVarA.f14612a > 1 || i12 == 429) {
                    iVarA.f14613b.getTime();
                    throw new xb.e("Fetch was throttled.");
                }
                if (i12 == 401) {
                    str3 = "The request did not have the required credentials. Please make sure your google-services.json is valid.";
                } else if (i12 == 403) {
                    str3 = "The user is not authorized to access the project. Please make sure you are using the API key that corresponds to your Firebase project.";
                } else {
                    if (i12 == 429) {
                        throw new xb.c("The throttled response from the server was not handled correctly by the FRC SDK.");
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
                throw new xb.f(fVar.f14344u, "Fetch failed: ".concat(str3), fVar);
            }
        } catch (xb.f e11) {
            e = e11;
            date2 = date;
        }
    }

    public final o b(o oVar, long j5, HashMap map) {
        o oVarF;
        Date date = new Date(System.currentTimeMillis());
        boolean zJ = oVar.j();
        j jVar = this.f14606g;
        if (zJ) {
            Date date2 = new Date(jVar.f14615a.getLong("last_fetch_time_in_millis", -1L));
            if (date2.equals(j.f14614e) ? false : date.before(new Date(TimeUnit.SECONDS.toMillis(j5) + date2.getTime()))) {
                return t1.k(new f(2, null, null));
            }
        }
        Date date3 = jVar.a().f14613b;
        Date date4 = date.before(date3) ? date3 : null;
        Executor executor = this.f14603c;
        if (date4 != null) {
            String str = "Fetch is throttled. Please wait before calling fetch again: " + DateUtils.formatElapsedTime(TimeUnit.MILLISECONDS.toSeconds(date4.getTime() - date.getTime()));
            date4.getTime();
            oVarF = t1.j(new xb.e(str));
        } else {
            ob.c cVar = (ob.c) this.f14601a;
            o oVarD = cVar.d();
            o oVarE = cVar.e();
            oVarF = t1.y(oVarD, oVarE).f(executor, new tc.a(this, oVarD, oVarE, date, map));
        }
        return oVarF.f(executor, new b2.b(this, 26, date));
    }

    public final o c(int i10) {
        HashMap map = new HashMap(this.f14607h);
        map.put("X-Firebase-RC-Fetch-Type", "REALTIME/" + i10);
        return this.f14605e.b().f(this.f14603c, new b2.b(this, 25, map));
    }

    public final HashMap d() {
        HashMap map = new HashMap();
        ka.b bVar = (ka.b) this.f14602b.get();
        if (bVar != null) {
            for (Map.Entry entry : ((i1) ((ka.c) bVar).f7608a.f11562v).d(null, null, false).entrySet()) {
                map.put((String) entry.getKey(), entry.getValue().toString());
            }
        }
        return map;
    }
}
