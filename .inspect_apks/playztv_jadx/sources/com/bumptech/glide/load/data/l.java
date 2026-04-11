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

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class l implements e {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final i6.h f2817u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final int f2818v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public HttpURLConnection f2819w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public InputStream f2820x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public volatile boolean f2821y;

    public l(i6.h hVar, int i) {
        this.f2817u = hVar;
        this.f2818v = i;
    }

    public static int d(HttpURLConnection httpURLConnection) {
        try {
            return httpURLConnection.getResponseCode();
        } catch (IOException e10) {
            if (!Log.isLoggable("HttpUrlFetcher", 3)) {
                return -1;
            }
            Log.d("HttpUrlFetcher", "Failed to get a response code", e10);
            return -1;
        }
    }

    @Override // com.bumptech.glide.load.data.e
    public final Class a() {
        return InputStream.class;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void b() {
        InputStream inputStream = this.f2820x;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
        HttpURLConnection httpURLConnection = this.f2819w;
        if (httpURLConnection != null) {
            httpURLConnection.disconnect();
        }
        this.f2819w = null;
    }

    @Override // com.bumptech.glide.load.data.e
    public final int c() {
        return 2;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void cancel() {
        this.f2821y = true;
    }

    @Override // com.bumptech.glide.load.data.e
    public final void e(com.bumptech.glide.f fVar, d dVar) {
        i6.h hVar = this.f2817u;
        int i = x6.h.f14283b;
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
        try {
            try {
                if (hVar.f == null) {
                    hVar.f = new URL(hVar.d());
                }
                dVar.r(f(hVar.f, 0, null, hVar.f6401b.a()));
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + x6.h.a(jElapsedRealtimeNanos));
                }
            } catch (IOException e10) {
                if (Log.isLoggable("HttpUrlFetcher", 3)) {
                    Log.d("HttpUrlFetcher", "Failed to load data for url", e10);
                }
                dVar.l(e10);
                if (Log.isLoggable("HttpUrlFetcher", 2)) {
                    Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + x6.h.a(jElapsedRealtimeNanos));
                }
            }
        } catch (Throwable th) {
            if (Log.isLoggable("HttpUrlFetcher", 2)) {
                Log.v("HttpUrlFetcher", "Finished http url fetcher fetch in " + x6.h.a(jElapsedRealtimeNanos));
            }
            throw th;
        }
    }

    public final InputStream f(URL url, int i, URL url2, Map map) throws c6.c {
        if (i >= 5) {
            throw new c6.c(-1, null, "Too many (> 5) redirects!");
        }
        if (url2 != null) {
            try {
                if (url.toURI().equals(url2.toURI())) {
                    throw new c6.c(-1, null, "In re-direct loop");
                }
            } catch (URISyntaxException unused) {
            }
        }
        int i10 = this.f2818v;
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
            this.f2819w = httpURLConnection;
            try {
                httpURLConnection.connect();
                this.f2820x = this.f2819w.getInputStream();
                if (this.f2821y) {
                    return null;
                }
                int iD = d(this.f2819w);
                int i11 = iD / 100;
                if (i11 == 2) {
                    HttpURLConnection httpURLConnection2 = this.f2819w;
                    try {
                        if (TextUtils.isEmpty(httpURLConnection2.getContentEncoding())) {
                            this.f2820x = new x6.d(httpURLConnection2.getInputStream(), httpURLConnection2.getContentLength());
                        } else {
                            if (Log.isLoggable("HttpUrlFetcher", 3)) {
                                Log.d("HttpUrlFetcher", "Got non empty content encoding: " + httpURLConnection2.getContentEncoding());
                            }
                            this.f2820x = httpURLConnection2.getInputStream();
                        }
                        return this.f2820x;
                    } catch (IOException e10) {
                        throw new c6.c(d(httpURLConnection2), e10, "Failed to obtain InputStream");
                    }
                }
                if (i11 != 3) {
                    if (iD == -1) {
                        throw new c6.c(iD, null, "Http request failed");
                    }
                    try {
                        throw new c6.c(iD, null, this.f2819w.getResponseMessage());
                    } catch (IOException e11) {
                        throw new c6.c(iD, e11, "Failed to get a response message");
                    }
                }
                String headerField = this.f2819w.getHeaderField("Location");
                if (TextUtils.isEmpty(headerField)) {
                    throw new c6.c(iD, null, "Received empty or null redirect url");
                }
                try {
                    URL url3 = new URL(url, headerField);
                    b();
                    return f(url3, i + 1, url, map);
                } catch (MalformedURLException e12) {
                    throw new c6.c(iD, e12, l4.a.m("Bad redirect url: ", headerField));
                }
            } catch (IOException e13) {
                throw new c6.c(d(this.f2819w), e13, "Failed to connect or obtain data");
            }
        } catch (IOException e14) {
            throw new c6.c(0, e14, "URL.openConnection threw");
        }
    }
}
