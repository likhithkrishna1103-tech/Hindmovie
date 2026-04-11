package c;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import androidx.lifecycle.m0;
import androidx.media3.decoder.DecoderInputBuffer;

/* JADX INFO: compiled from: r8-map-id-c4f9814488669853ae93fbc55db361a9ba0734c3936998bc53cdd659ea79ae23 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class f implements fe.a {

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final /* synthetic */ int f1949v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public final /* synthetic */ h.j f1950w;

    public /* synthetic */ f(h.j jVar, int i) {
        this.f1949v = i;
        this.f1950w = jVar;
    }

    @Override // fe.a
    public final Object b() {
        switch (this.f1949v) {
            case DecoderInputBuffer.BUFFER_REPLACEMENT_MODE_DISABLED /* 0 */:
                this.f1950w.reportFullyDrawn();
                return rd.l.f11003a;
            case 1:
                h.j jVar = this.f1950w;
                return new w(jVar.A, new f(jVar, 0));
            case 2:
                o4.a aVar = new o4.a();
                this.f1950w.j().b().f1947c.b(aVar);
                return aVar;
            case 3:
                h.j jVar2 = this.f1950w;
                return new m0(jVar2.getApplication(), jVar2, jVar2.getIntent() != null ? jVar2.getIntent().getExtras() : null);
            default:
                h.j jVar3 = this.f1950w;
                f0 f0Var = new f0(new e(jVar3, 0));
                if (Build.VERSION.SDK_INT >= 33) {
                    if (ge.i.a(Looper.myLooper(), Looper.getMainLooper())) {
                        jVar3.f5437v.a(new g(f0Var, jVar3));
                    } else {
                        new Handler(Looper.getMainLooper()).post(new androidx.fragment.app.d(1, jVar3, f0Var));
                    }
                }
                return f0Var;
        }
    }
}
