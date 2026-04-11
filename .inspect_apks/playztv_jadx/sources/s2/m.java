package s2;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.Executors;
import s1.b0;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final class m implements n {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final e4.f f11764x = new e4.f(0, -9223372036854775807L, false);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final e4.f f11765y = new e4.f(2, -9223372036854775807L, false);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    public static final e4.f f11766z = new e4.f(3, -9223372036854775807L, false);

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final t2.a f11767u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public i f11768v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public IOException f11769w;

    /* JADX WARN: Illegal instructions before constructor call */
    public m(String str) {
        String strConcat = "ExoPlayer:Loader:".concat(str);
        int i = b0.f11647a;
        this(new t2.a(Executors.newSingleThreadExecutor(new androidx.emoji2.text.a(strConcat, 1)), new r2.h(1)));
    }

    public final void a() {
        i iVar = this.f11768v;
        s1.d.h(iVar);
        iVar.a(false);
    }

    @Override // s2.n
    public final void b() {
        IOException iOException = this.f11769w;
        if (iOException != null) {
            throw iOException;
        }
        i iVar = this.f11768v;
        if (iVar != null) {
            int i = iVar.f11758u;
            IOException iOException2 = iVar.f11762y;
            if (iOException2 != null && iVar.f11763z > i) {
                throw iOException2;
            }
        }
    }

    public final boolean c() {
        return this.f11769w != null;
    }

    public final boolean d() {
        return this.f11768v != null;
    }

    public final void e(k kVar) {
        i iVar = this.f11768v;
        if (iVar != null) {
            iVar.a(true);
        }
        t2.a aVar = this.f11767u;
        if (kVar != null) {
            aVar.execute(new androidx.fragment.app.e(21, kVar));
        }
        aVar.f12066v.accept(aVar.f12065u);
    }

    public final void f(j jVar, h hVar, int i) {
        Looper looperMyLooper = Looper.myLooper();
        s1.d.h(looperMyLooper);
        this.f11769w = null;
        i iVar = new i(this, looperMyLooper, jVar, hVar, i, SystemClock.elapsedRealtime());
        s1.d.g(this.f11768v == null);
        this.f11768v = iVar;
        iVar.b();
    }

    public m(t2.a aVar) {
        this.f11767u = aVar;
    }
}
