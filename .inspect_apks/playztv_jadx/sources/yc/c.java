package yc;

import android.content.Context;
import h4.z;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Context f14654a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final id.e f14655b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final f f14656c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final id.h f14657d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f14658e;
    public final z f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final h f14659g;

    public c(Context context, id.e eVar, f fVar, id.h hVar, d dVar, z zVar, h hVar2) {
        this.f14654a = context;
        this.f14655b = eVar;
        this.f14656c = fVar;
        this.f14657d = hVar;
        this.f14658e = dVar;
        this.f = zVar;
        this.f14659g = hVar2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!c.class.equals(obj != null ? obj.getClass() : null)) {
            return false;
        }
        be.h.c(obj, "null cannot be cast to non-null type com.tonyodev.fetch2.FetchConfiguration");
        c cVar = (c) obj;
        return be.h.a(this.f14654a, cVar.f14654a) && be.h.a(this.f14655b, cVar.f14655b) && this.f14656c == cVar.f14656c && be.h.a(this.f14657d, cVar.f14657d) && be.h.a(this.f14658e, cVar.f14658e) && this.f.equals(cVar.f) && this.f14659g == cVar.f14659g;
    }

    public final int hashCode() {
        return ((((((((this.f14659g.hashCode() + ((this.f.hashCode() + ((((((this.f14658e.hashCode() + ((((((this.f14657d.hashCode() + ((this.f14656c.hashCode() + ((this.f14655b.hashCode() + (((((((((this.f14654a.hashCode() * 31) - 1521653773) * 31) + 1) * 31) + ((int) 2000)) * 31) + 1237) * 31)) * 31)) * 31)) * 31) + 1231) * 31) + 1231) * 31)) * 31) + 1237) * 31) + 1231) * 31)) * 31)) * 31) + ((int) 300000)) * 31) + 1231) * 31) - 1) * 31) + 1231;
    }

    public final String toString() {
        return "FetchConfiguration(appContext=" + this.f14654a + ", namespace='LibGlobalFetchLib', concurrentLimit=1, progressReportingIntervalMillis=2000, loggingEnabled=false, httpDownloader=" + this.f14655b + ", globalNetworkType=" + this.f14656c + ", logger=" + this.f14657d + ", autoStart=true, retryOnNetworkGain=true, fileServerDownloader=" + this.f14658e + ", hashCheckingEnabled=false, fileExistChecksEnabled=true, storageResolver=" + this.f + ", fetchNotificationManager=null, fetchDatabaseManager=null, backgroundHandler=null, prioritySort=" + this.f14659g + ", internetCheckUrl=null, activeDownloadsCheckInterval=300000, createFileOnEnqueue=true, preAllocateFileOnCreation=true, maxAutoRetryAttempts=-1, fetchHandler=null)";
    }
}
