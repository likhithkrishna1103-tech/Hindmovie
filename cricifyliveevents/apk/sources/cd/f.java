package cd;

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
import sd.p;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class f implements md.e {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final md.c f2163v = md.c.f8424v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final ka.f f2164w = new ka.f(6);

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final Map f2165x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final CookieManager f2166y;

    public f() {
        Map mapSynchronizedMap = Collections.synchronizedMap(new HashMap());
        ge.i.d(mapSynchronizedMap, "synchronizedMap(...)");
        this.f2165x = mapSynchronizedMap;
        CookieManager cookieManager = new CookieManager();
        cookieManager.setCookiePolicy(CookiePolicy.ACCEPT_ALL);
        this.f2166y = cookieManager;
    }

    public static LinkedHashMap a(Map map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            if (str != null) {
                Collection collection = (List) entry.getValue();
                if (collection == null) {
                    collection = p.f11669v;
                }
                linkedHashMap.put(str, collection);
            }
        }
        return linkedHashMap;
    }

    @Override // md.e
    public final md.d D(dd.c cVar, md.k kVar) throws IOException {
        String str;
        boolean z10;
        long jO;
        String strE;
        ge.i.e(kVar, "interruptMonitor");
        CookieHandler.setDefault(this.f2166y);
        String str2 = (String) cVar.f3672w;
        URLConnection uRLConnectionOpenConnection = new URL(str2).openConnection();
        ge.i.c(uRLConnectionOpenConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection;
        g(httpURLConnection, cVar);
        if (httpURLConnection.getRequestProperty("Referer") == null) {
            httpURLConnection.addRequestProperty("Referer", android.support.v4.media.session.b.x(str2));
        }
        httpURLConnection.connect();
        Map<String, List<String>> headerFields = httpURLConnection.getHeaderFields();
        ge.i.d(headerFields, "getHeaderFields(...)");
        LinkedHashMap linkedHashMapA = a(headerFields);
        int responseCode = httpURLConnection.getResponseCode();
        str = "";
        if ((responseCode == 302 || responseCode == 301 || responseCode == 303) && android.support.v4.media.session.b.u(linkedHashMapA, "Location") != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception unused) {
            }
            String strU = android.support.v4.media.session.b.u(linkedHashMapA, "Location");
            if (strU == null) {
                strU = "";
            }
            URLConnection uRLConnectionOpenConnection2 = new URL(strU).openConnection();
            ge.i.c(uRLConnectionOpenConnection2, "null cannot be cast to non-null type java.net.HttpURLConnection");
            httpURLConnection = (HttpURLConnection) uRLConnectionOpenConnection2;
            g(httpURLConnection, cVar);
            if (httpURLConnection.getRequestProperty("Referer") == null) {
                httpURLConnection.addRequestProperty("Referer", android.support.v4.media.session.b.x(str2));
            }
            httpURLConnection.connect();
            Map<String, List<String>> headerFields2 = httpURLConnection.getHeaderFields();
            ge.i.d(headerFields2, "getHeaderFields(...)");
            linkedHashMapA = a(headerFields2);
            responseCode = httpURLConnection.getResponseCode();
        }
        HttpURLConnection httpURLConnection2 = httpURLConnection;
        LinkedHashMap linkedHashMap = linkedHashMapA;
        int i = responseCode;
        InputStream inputStream = null;
        if (200 > i || i >= 300) {
            z10 = false;
            jO = -1;
            strE = android.support.v4.media.session.b.e(httpURLConnection2.getErrorStream());
        } else {
            jO = android.support.v4.media.session.b.o(linkedHashMap);
            InputStream inputStream2 = httpURLConnection2.getInputStream();
            String strU2 = android.support.v4.media.session.b.u(linkedHashMap, "Content-MD5");
            str = strU2 != null ? strU2 : "";
            z10 = true;
            strE = null;
            inputStream = inputStream2;
        }
        boolean zA = android.support.v4.media.session.b.a(i, linkedHashMap);
        ge.i.d(httpURLConnection2.getHeaderFields(), "getHeaderFields(...)");
        md.d dVar = new md.d(i, z10, jO, inputStream, cVar, str, linkedHashMap, zA, strE);
        this.f2165x.put(dVar, httpURLConnection2);
        return dVar;
    }

    @Override // md.e
    public final void H(md.d dVar) {
        Map map = this.f2165x;
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

    @Override // md.e
    public final md.c X(dd.c cVar, Set set) {
        ge.i.e(set, "supportedFileDownloaderTypes");
        return this.f2163v;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Map map = this.f2165x;
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

    public final void g(HttpURLConnection httpURLConnection, dd.c cVar) throws ProtocolException {
        httpURLConnection.setRequestMethod((String) cVar.f3675z);
        this.f2164w.getClass();
        httpURLConnection.setReadTimeout(20000);
        httpURLConnection.setConnectTimeout(15000);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setDefaultUseCaches(false);
        httpURLConnection.setInstanceFollowRedirects(true);
        httpURLConnection.setDoInput(true);
        for (Map.Entry entry : ((LinkedHashMap) cVar.f3673x).entrySet()) {
            httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
        }
    }

    @Override // md.e
    public final Set x(dd.c cVar) {
        md.c cVar2 = md.c.f8424v;
        md.c cVar3 = this.f2163v;
        if (cVar3 == cVar2) {
            return u8.a.w(cVar3);
        }
        try {
            return android.support.v4.media.session.b.y(cVar, this);
        } catch (Exception unused) {
            return u8.a.w(cVar3);
        }
    }

    @Override // md.e
    public final void B(dd.c cVar) {
    }

    @Override // md.e
    public final void F(dd.c cVar) {
    }

    @Override // md.e
    public final void y(dd.c cVar) {
    }
}
