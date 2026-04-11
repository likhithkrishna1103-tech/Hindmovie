package c;

import a2.g0;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.m0;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-8af220986ec75471f42850aff14da9e2635b56ed97029d3e9e3ceb4607eaaaec */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements ae.a {

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final /* synthetic */ int f2162u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ h.j f2163v;

    public /* synthetic */ f(h.j jVar, int i) {
        this.f2162u = i;
        this.f2163v = jVar;
    }

    @Override // ae.a
    public final Object b() {
        switch (this.f2162u) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f2163v.reportFullyDrawn();
                return nd.k.f8990a;
            case 1:
                h.j jVar = this.f2163v;
                return new v(jVar.f2186z, new f(jVar, 0));
            case 2:
                j4.a aVar = new j4.a();
                this.f2163v.j().f2157b.d(aVar);
                return aVar;
            case 3:
                h.j jVar2 = this.f2163v;
                return new m0(jVar2.getApplication(), jVar2, jVar2.getIntent() != null ? jVar2.getIntent().getExtras() : null);
            default:
                h.j jVar3 = this.f2163v;
                c0 c0Var = new c0(new e(jVar3, 0));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (be.h.a(Looper.myLooper(), Looper.getMainLooper())) {
                        jVar3.f4244u.a(new g(c0Var, jVar3));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new g0(jVar3, 9, c0Var));
                    }
                }
                return c0Var;
        }
    }
}
