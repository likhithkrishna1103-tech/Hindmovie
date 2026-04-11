package yc;

import id.l;
import java.io.IOException;
import java.io.InputStream;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import od.q;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class e implements id.e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final id.c f14662u = id.c.f6568u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final ua.c f14663v = new ua.c();

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final Map f14664w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final CookieManager f14665x;

    public e() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        be.h.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.f14664w = mapSynchronizedMap;
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        this.f14665x = cookieManager;
    }

    public static LinkedHashMap a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                Collection collection = (List) entry.getValue();
                if (collection == null) {
                    collection = q.f9570u;
                }
                linkedHashMap.put(str, collection);
            }
        }
        return linkedHashMap;
    }

    @Override // id.e
    public final void C(id.d dVar) {
        Map map = this.f14664w;
        if (map.containsKey(dVar)) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) map.get(dVar);
            map.remove(dVar);
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map map = this.f14664w;
        Iterator it = map.entrySet().iterator();
        while (it.hasNext()) {
            HttpURLConnection httpURLConnection = (HttpURLConnection) ((Map.Entry) it.next()).getValue();
            if (httpURLConnection != null) {
                try {
                    httpURLConnection.disconnect();
                } catch (Exception unused) {
                }
            }
        }
        map.clear();
    }

    public final void d(HttpURLConnection httpURLConnection, zc.c cVar) throws ProtocolException {
        httpURLConnection.setRequestMethod((String) cVar.f14948x);
        this.f14663v.getClass();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        for (Map.Entry entry : ((LinkedHashMap) cVar.f14946v).entrySet()) {
            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // id.e
    public final Set s(zc.c cVar) {
        id.c cVar2 = id.c.f6568u;
        id.c cVar3 = this.f14662u;
        if (cVar3 == cVar2) {
            return cf.d.s(cVar3);
        }
        try {
            return android.support.v4.media.session.b.A(cVar, this);
        } catch (Exception unused) {
            return cf.d.s(cVar3);
        }
    }

    @Override // id.e
    public final id.d t(zc.c cVar, l lVar) throws IOException {
        String str;
        boolean z2;
        long jS;
        String strL;
        be.h.e(lVar, "interruptMonitor");
        CookieHandler.setDefault(this.f14665x);
        String str2 = (String) cVar.f14945u;
        URLConnection uRLConnectionOpenConnection = new URL(str2).openConnection();
        be.h.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        d(httpURLConnection, cVar);
        if (httpURLConnection.getRequestProperty("Referer") == null) {
            httpURLConnection.addRequestProperty("Referer", android.support.v4.media.session.b.z(str2));
        }
        httpURLConnection.connect();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        be.h.d(headerFields, "getHeaderFields(...)");
        LinkedHashMap linkedHashMapA = a(headerFields);
        int responseCode = httpURLConnection.getResponseCode();
        str = "";
        if ((responseCode == 302 || responseCode == 301 || responseCode == 303) && android.support.v4.media.session.b.x(linkedHashMapA, "Location") != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            String strX = android.support.v4.media.session.b.x(linkedHashMapA, "Location");
            if (strX == null) {
                strX = "";
            }
            URLConnection uRLConnectionOpenConnection2 = new URL(strX).openConnection();
            be.h.c(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
            d(httpURLConnection, cVar);
            if (httpURLConnection.getRequestProperty("Referer") == null) {
                httpURLConnection.addRequestProperty("Referer", android.support.v4.media.session.b.z(str2));
            }
            httpURLConnection.connect();
            Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
            be.h.d(headerFields2, "getHeaderFields(...)");
            linkedHashMapA = a(headerFields2);
            responseCode = httpURLConnection.getResponseCode();
        }
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        LinkedHashMap linkedHashMap = linkedHashMapA;
        int i = responseCode;
        InputStream inputStream = null;
        if (200 > i || i >= 300) {
            z2 = false;
            jS = -1;
            strL = android.support.v4.media.session.b.l(httpURLConnection2.getErrorStream());
        } else {
            jS = android.support.v4.media.session.b.s(linkedHashMap);
            InputStream inputStream2 = httpURLConnection2.getInputStream();
            String strX2 = android.support.v4.media.session.b.x(linkedHashMap, "Content-MD5");
            str = strX2 != null ? strX2 : "";
            z2 = true;
            strL = null;
            inputStream = inputStream2;
        }
        boolean zA = android.support.v4.media.session.b.a(i, linkedHashMap);
        be.h.d(httpURLConnection2.getHeaderFields(), "getHeaderFields(...)");
        id.d dVar = new id.d(i, z2, jS, inputStream, cVar, str, linkedHashMap, zA, strL);
        this.f14664w.put(dVar, httpURLConnection2);
        return dVar;
    }

    @Override // id.e
    public final id.c w(zc.c cVar, Set set) {
        be.h.e(set, "supportedFileDownloaderTypes");
        return this.f14662u;
    }

    @Override // id.e
    public final void E(zc.c cVar) {
    }

    @Override // id.e
    public final void T(zc.c cVar) {
    }

    @Override // id.e
    public final void u(zc.c cVar) {
    }
}
