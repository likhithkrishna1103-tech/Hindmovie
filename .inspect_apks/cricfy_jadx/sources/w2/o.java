package w2;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executors;
import v1.b0;
import y1.a0;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final class o implements p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final i4.e f13882d = new i4.e(0, -9223372036854775807L, false);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final i4.e f13883e = new i4.e(2, -9223372036854775807L, false);
    public static final i4.e f = new i4.e(3, -9223372036854775807L, false);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x2.a f13884a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public j f13885b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public IOException f13886c;

    /* JADX WARN: Illegal instructions before constructor call */
    public o(String str) {
        String strConcat = "ExoPlayer:Loader:".concat(str);
        int i = a0.f14551a;
        this(new x2.a(Executors.newSingleThreadExecutor(new androidx.emoji2.text.a(1, strConcat)), new b0(11)));
    }

    public final void a() {
        j jVar = this.f13885b;
        y1.d.h(jVar);
        jVar.a(false);
    }

    public final boolean b() {
        return this.f13886c != null;
    }

    @Override // w2.p
    public final void c() throws IOException {
        IOException iOException = this.f13886c;
        if (iOException != null) {
            throw iOException;
        }
        j jVar = this.f13885b;
        if (jVar != null) {
            int i = jVar.f13875v;
            IOException iOException2 = jVar.f13879z;
            if (iOException2 != null && jVar.A > i) {
                throw iOException2;
            }
        }
    }

    public final boolean d() {
        return this.f13885b != null;
    }

    public final void e(l lVar) {
        j jVar = this.f13885b;
        if (jVar != null) {
            jVar.a(true);
        }
        x2.a aVar = this.f13884a;
        if (lVar != null) {
            aVar.execute(new m(0, lVar));
        }
        aVar.f14287w.accept(aVar.f14286v);
    }

    public final void f(k kVar, i iVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        y1.d.h(looperMyLooper);
        this.f13886c = null;
        j jVar = new j(this, looperMyLooper, kVar, iVar, i, SystemClock.elapsedRealtime());
        y1.d.g(this.f13885b == null);
        this.f13885b = jVar;
        jVar.b();
    }

    public o(x2.a aVar) {
        this.f13884a = aVar;
    }
}
