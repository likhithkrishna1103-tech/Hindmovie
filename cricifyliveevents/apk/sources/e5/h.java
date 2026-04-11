package e5;

import android.content.Context;
import c.d0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class h implements d5.d {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final Context f3801v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final String f3802w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public final d5.c f3803x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public final rd.j f3804y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public boolean f3805z;

    public h(Context context, String str, d5.c cVar) {
        ge.i.e(context, "context");
        ge.i.e(cVar, "callback");
        this.f3801v = context;
        this.f3802w = str;
        this.f3803x = cVar;
        this.f3804y = new rd.j(new d0(1, this));
    }

    @Override // d5.d
    public final d5.b Y() {
        return ((g) this.f3804y.getValue()).a(true);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        rd.j jVar = this.f3804y;
        if (jVar.a()) {
            ((g) jVar.getValue()).close();
        }
    }

    @Override // d5.d
    public final String getDatabaseName() {
        return this.f3802w;
    }

    @Override // d5.d
    public final void setWriteAheadLoggingEnabled(boolean z10) {
        rd.j jVar = this.f3804y;
        if (jVar.a()) {
            ((g) jVar.getValue()).setWriteAheadLoggingEnabled(z10);
        }
        this.f3805z = z10;
    }
}
