package a5;

import android.content.Context;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class j implements z4.b {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final Context f564u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final String f565v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final t1.e f566w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final nd.i f567x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public boolean f568y;

    public j(Context context, String str, t1.e eVar) {
        be.h.e(context, "context");
        be.h.e(eVar, "callback");
        this.f564u = context;
        this.f565v = str;
        this.f566w = eVar;
        this.f567x = new nd.i(new e(0, this));
    }

    @Override // z4.b
    public final z4.a Z() {
        return ((i) this.f567x.getValue()).a(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        if (this.f567x.f8987v != nd.j.f8989a) {
            ((i) this.f567x.getValue()).close();
        }
    }

    @Override // z4.b
    public final String getDatabaseName() {
        return this.f565v;
    }

    @Override // z4.b
    public final void setWriteAheadLoggingEnabled(boolean z2) {
        if (this.f567x.f8987v != nd.j.f8989a) {
            ((i) this.f567x.getValue()).setWriteAheadLoggingEnabled(z2);
        }
        this.f568y = z2;
    }
}
