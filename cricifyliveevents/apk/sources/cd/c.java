package cd;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f2155a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final md.e f2156b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final g f2157c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final d5.a f2158d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f2159e;
    public final i2.k f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final i f2160g;

    public c(Context context, md.e eVar, g gVar, d5.a aVar, d dVar, i2.k kVar, i iVar) {
        this.f2155a = context;
        this.f2156b = eVar;
        this.f2157c = gVar;
        this.f2158d = aVar;
        this.f2159e = dVar;
        this.f = kVar;
        this.f2160g = iVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        ge.i.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.FetchConfiguration");
        c cVar = (c) obj;
        return ge.i.a(this.f2155a, cVar.f2155a) && ge.i.a(this.f2156b, cVar.f2156b) && this.f2157c == cVar.f2157c && ge.i.a(this.f2158d, cVar.f2158d) && ge.i.a(this.f2159e, cVar.f2159e) && this.f.equals(cVar.f) && this.f2160g == cVar.f2160g;
    }

    public final int hashCode() {
        return ((((((((this.f2160g.hashCode() + ((this.f.hashCode() + ((((((this.f2159e.hashCode() + ((((((this.f2158d.hashCode() + ((this.f2157c.hashCode() + ((this.f2156b.hashCode() + (((((((((this.f2155a.hashCode() * 31) - 1521653773) * 31) + 1) * 31) + ((int) 2000)) * 31) + 1237) * 31)) * 31)) * 31)) * 31) + 1231) * 31) + 1231) * 31)) * 31) + 1237) * 31) + 1231) * 31)) * 31)) * 31) + ((int) 300000)) * 31) + 1231) * 31) - 1) * 31) + 1231;
    }

    public final String toString() {
        return "FetchConfiguration(appContext=" + this.f2155a + ", namespace='LibGlobalFetchLib', concurrentLimit=1, progressReportingIntervalMillis=2000, loggingEnabled=false, httpDownloader=" + this.f2156b + ", globalNetworkType=" + this.f2157c + ", logger=" + this.f2158d + ", autoStart=true, retryOnNetworkGain=true, fileServerDownloader=" + this.f2159e + ", hashCheckingEnabled=false, fileExistChecksEnabled=true, storageResolver=" + this.f + ", fetchNotificationManager=null, fetchDatabaseManager=null, backgroundHandler=null, prioritySort=" + this.f2160g + ", internetCheckUrl=null, activeDownloadsCheckInterval=300000, createFileOnEnqueue=true, preAllocateFileOnCreation=true, maxAutoRetryAttempts=-1, fetchHandler=null)";
    }
}
