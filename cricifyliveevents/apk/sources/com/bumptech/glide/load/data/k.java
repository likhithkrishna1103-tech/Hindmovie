package com.bumptech.glide.load.data;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class k implements d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final d7.j f2245v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final int f2246w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public HttpURLConnection f2247x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public InputStream f2248y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public volatile boolean f2249z;

    public k(d7.j jVar, int i) {
        this.f2245v = jVar;
        this.f2246w = i;
    }

    public static int c(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e9) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e9);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void b() {
        InputStream inputStream = this.f2248y;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f2247x;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f2247x = null;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void cancel() {
        this.f2249z = true;
    }

    public final InputStream d(URL url, int i, URL url2, Map map) throws a2.a {
        if (i >= 5) {
            throw new a2.a(-1, null, "Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new a2.a(-1, null, "In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i10 = this.f2246w;
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            for (Map.Entry entry : map.entrySet()) {
                httpURLConnection.addRequestProperty((String) entry.getKey(), (String) entry.getValue());
            }
            httpURLConnection.setConnectTimeout(i10);
            httpURLConnection.setReadTimeout(i10);
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setDoInput(true);
            httpURLConnection.setInstanceFollowRedirects(false);
            this.f2247x = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f2248y = this.f2247x.getInputStream();
                if (this.f2249z) {
                    return null;
                }
                int iC = c(this.f2247x);
                int i11 = iC / 100;
                if (i11 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f2247x;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f2248y = new s7.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f2248y = httpURLConnection2.getInputStream();
                        }
                        return this.f2248y;
                    } catch (IOException e9) {
                        throw new a2.a(c(httpURLConnection2), e9, "Failed to obtain InputStream");
                    }
                }
                if (i11 != 3) {
                    if (iC == -1) {
                        throw new a2.a(iC, null, "Http request failed");
                    }
                    try {
                        throw new a2.a(iC, null, this.f2247x.getResponseMessage());
                    } catch (IOException e10) {
                        throw new a2.a(iC, e10, "Failed to get a response message");
                    }
                }
                String headerField = this.f2247x.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new a2.a(iC, null, "Received empty or null redirect url");
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return d(url3, i + 1, url, map);
                } catch (MalformedURLException e11) {
                    throw new a2.a(iC, e11, q4.a.n("Bad redirect url: ", headerField));
                }
            } catch (IOException e12) {
                throw new a2.a(c(this.f2247x), e12, "Failed to connect or obtain data");
            }
        } catch (IOException e13) {
            throw new a2.a(0, e13, "URL.openConnection threw");
        }
    }

    @Override // com.bumptech.glide.load.data.d
    public final int e() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.d
    public final void f(com.bumptech.glide.h hVar, c cVar) {
        d7.j jVar = this.f2245v;
        int i = s7.h.f11599b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                if (jVar.f == null) {
                    jVar.f = new URL(jVar.d());
                }
                cVar.d(d(jVar.f, 0, null, jVar.f3488b.a()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + s7.h.a(jElapsedRealtimeNanos));
                }
            } catch (IOException e9) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e9);
                }
                cVar.c(e9);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + s7.h.a(jElapsedRealtimeNanos));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + s7.h.a(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }
}
